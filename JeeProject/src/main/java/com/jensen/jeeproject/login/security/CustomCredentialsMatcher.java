package com.jensen.jeeproject.login.security;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

/**
 * 登录验证前自定义功能拓展
 * 
 * @className CustomCredentialsMatcher
 * @description 
 * @author JensenLiu
 * @date 2017年9月7日
 * @version V1.0
 */
public class CustomCredentialsMatcher extends HashedCredentialsMatcher {

	private Cache<String, AtomicInteger> passwordRetryCache;

	public CustomCredentialsMatcher(CacheManager cacheManager) {

		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	/**
	 * 自定义用户登录超过指定错误次数后的处理
	 * 
	 * @param token
	 * @param info
	 * @return
	 * @see
	 */
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		String loginName = (String) token.getPrincipal();
		AtomicInteger retryCount = passwordRetryCache.get(loginName);
		if (retryCount == null) {
			retryCount = new AtomicInteger();
			passwordRetryCache.put(loginName, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			throw new ExcessiveAttemptsException("您登录失败次数过多，请稍后再试！");
		}
		boolean matchs = super.doCredentialsMatch(token, info);
		if (matchs) {
			passwordRetryCache.remove(loginName);
		}
		return matchs;
	}

	public Cache<String, AtomicInteger> getPasswordRetryCache() {
		return passwordRetryCache;
	}

	public void setPasswordRetryCache(Cache<String, AtomicInteger> passwordRetryCache) {
		this.passwordRetryCache = passwordRetryCache;
	}
}
