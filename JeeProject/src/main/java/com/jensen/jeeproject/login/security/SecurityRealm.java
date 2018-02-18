package com.jensen.jeeproject.login.security;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jensen.jeeproject.common.enumeration.UserStateEnum;
import com.jensen.jeeproject.system.entity.User;
import com.jensen.jeeproject.system.service.UserService;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author StarZou
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 * 权限检查
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Subject currentUser = SecurityUtils.getSubject();

		Session session = currentUser.getSession(false);

		if (session == null) {
			session = currentUser.getSession();
		}

		// 从Session中获取的权限对象
		SimpleAuthorizationInfo authorizationInfo = (SimpleAuthorizationInfo) session.getAttribute("authorizationInfo");

		return authorizationInfo;
	}

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String loginName = String.valueOf(token.getPrincipal());
		// 通过数据库进行验证
		User user = userService.getUserByLoginName(loginName);
		if (user != null) {
			if (UserStateEnum.DISABLE.equals(user.getState())) {
				throw new DisabledAccountException();
			}
			ShiroUser shiroUser = new ShiroUser(user);
			ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
			SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(shiroUser, user.getPassword(),
					credentialsSalt, getName());
			return authenticationInfo;
		} else {
			throw new UnknownAccountException();
		}
	}

	public static class ShiroUser implements Serializable {

		private static final long serialVersionUID = -1373760761780840081L;
		private String id;
		private String loginName;
		private String officeId;
		private String officePath;

		public ShiroUser() {

		}

		public ShiroUser(User user) {

			init(user);
		}

		public void init(User user) {

			this.id = user.getId();
			this.loginName = user.getLoginName();
			this.officeId = user.getOffice().getId();
			this.officePath = user.getOffice().getPath();
		}

		public static ShiroUser getInstance() {

			ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			return shiroUser;
		}

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getOfficeId() {
			return officeId;
		}

		public void setOfficeId(String officeId) {
			this.officeId = officeId;
		}

		public String getOfficePath() {
			return officePath;
		}

		public void setOfficePath(String officePath) {
			this.officePath = officePath;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		/**
		 * 重载hashCode,只计算loginName;
		 */
		@Override
		public int hashCode() {
			return HashCodeBuilder.reflectionHashCode(this, "loginName");
		}

		/**
		 * 重载equals,只比较loginName
		 */
		@Override
		public boolean equals(Object obj) {
			return EqualsBuilder.reflectionEquals(this, obj, "loginName");
		}
	}

	public void initCredentialsMatcher() {

		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("MD5");
		credentialsMatcher.setHashIterations(1024);
		setCredentialsMatcher(credentialsMatcher);
	}

}
