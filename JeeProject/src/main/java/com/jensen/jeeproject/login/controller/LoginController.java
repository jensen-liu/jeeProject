package com.jensen.jeeproject.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import static com.jensen.jeeproject.common.util.PropUtil.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jensen.jeeproject.common.controller.BaseController;
import com.jensen.jeeproject.common.util.VerifyCodeUtils;
import com.jensen.jeeproject.login.vo.LoginVO;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/**
	 * 跳转至登录页
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String toLogin() {

		return "login";
	}

	/**
	 * 跳转至系统首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "index")
	public String toIndex() {

		return "layout/index";
	}

	/**
	 * 登录验证码
	 * 
	 * @param vo
	 * @param rs
	 * @param model
	 * @param errorInfo
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@Valid LoginVO vo, BindingResult rs, Model model, HttpServletRequest request) {

		try {
			Subject subject = SecurityUtils.getSubject();
			if (subject.isAuthenticated()) {
				return "redirect:/index";
			}
			if (rs.hasErrors()) {
				model.addAttribute("message", rs.getAllErrors().get(0).getDefaultMessage());
				return "login";
			} else {
				String verifyCode = (String) request.getSession().getAttribute("verifyCode");
				if (null == verifyCode) {
					return "login";
				}
				if (!vo.getVerifyCode().equalsIgnoreCase(verifyCode)) {
					model.addAttribute("message", "验证码不正确");
					return "login";
				} else {
					UsernamePasswordToken token = new UsernamePasswordToken(vo.getLoginName(), vo.getPassword());
					token.setRememberMe(Boolean.valueOf(vo.getRememberMe()));
					subject.login(token);
					return "redirect:/index";
				}
			}
		} catch (UnknownAccountException e) {
			model.addAttribute("message", getPropMessage("login.UnknownAccount"));
		} catch (ExcessiveAttemptsException e) {
			model.addAttribute("message", e.getMessage());
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("message", getPropMessage("login.IncorrectCredentials"));
		} catch (LockedAccountException e) {
			model.addAttribute("message", e.getMessage());
		} catch (DisabledAccountException e) {
			model.addAttribute("message", getPropMessage("login.DisabledAccount"));
		} catch (Exception e) {
			model.addAttribute("message", getPropMessage("exception"));
			LOGGER.error("系统登录异常", e);
		}
		return "login";
	}

	/**
	 * 生成登录验证码并保存至session中
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("verifyCode")
	public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) {

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字符串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入Session, 此处可以根据自己的需求
		HttpSession session = request.getSession();
		session.setAttribute("verifyCode", verifyCode);
		// 生成图片
		int w = 100, h = 35;
		try {
			// 将图片写入到 response 的输出流即可将图片返回到客户端了
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			LOGGER.error("生成验证码失败, Cause by: {}", e.getMessage(), e);
		}
	}

}
