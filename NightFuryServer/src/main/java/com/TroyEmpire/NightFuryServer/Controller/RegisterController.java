package com.TroyEmpire.NightFuryServer.Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TroyEmpire.NightFuryServer.Entity.User;
import com.TroyEmpire.NightFuryServer.IService.IUserService;
import com.TroyEmpire.NightFuryServer.Util.CaptchaUtil;
import com.TroyEmpire.NightFuryServer.Util.MathUtil;

@Controller
public class RegisterController {

	@Autowired
	private IUserService userService;

	private String sImgType = "jpg";

	@RequestMapping(value = "/studentRegister", method = RequestMethod.GET)
	public ModelAndView registerGet(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null)
			return new ModelAndView("register");
		Map<String, User> userMap = new HashMap<String, User>();
		userMap.put("user", user);
		return new ModelAndView("register", userMap);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPost(HttpServletRequest request,
			HttpServletResponse responese) {
		User user = new User();
		try {
			user.setAddDate(new Date());
			user.setEmail(request.getParameter("user_email"));
			user.setName(request.getParameter("user_name"));
			user.setPassward(MathUtil.Md5(request.getParameter("user_password")));
			// 数字2代表注册后的身份只能是学生用户
			byte studentRole = 2;
			user.setUserRole(studentRole);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		userService.saveUser(user);
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/register/validateEmail", method = RequestMethod.GET)
	public void ajaxValidateEmail(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		if (userService.checkUserIfExistByEmain(email)) {
			try {
				response.getWriter().write("exist");
				response.getWriter().flush();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	@RequestMapping(value = "/register/validateCaptcha", method = RequestMethod.GET)
	public void ajaxValidateCaptcha(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String hidCaptchaID = request.getSession().getId();
		String veriCode = request.getParameter("veriCode");
		String message = "";
		if (hidCaptchaID == null || veriCode == null) {
			message = "fault";
		} else {
			boolean passedCaptchaTest = CaptchaUtil.validateCaptcha(
					hidCaptchaID, veriCode);
			message = passedCaptchaTest ? "pass" : "unpass";
		}
		try {
			response.getWriter().write(message);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/register/captcha", method = RequestMethod.GET)
	public void getCaptcha(HttpServletRequest request,
			HttpServletResponse response) {
		ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
		byte[] captchaBytes;
		if (request.getQueryString() != null) {
			return;
		}
		try {
			// Session ID is used to identify the particular captcha.
			String captchaId = request.getSession().getId();
			// Generate the captcha image.
			BufferedImage challengeImage = CaptchaUtil.getInstance()
					.getImageChallengeForID(captchaId, request.getLocale());
			ImageIO.write(challengeImage, sImgType, imgOutputStream);
			captchaBytes = imgOutputStream.toByteArray();
			// Set appropriate http headers.
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/" + sImgType);
			// Write the image to the client.
			ServletOutputStream outStream;
			outStream = response.getOutputStream();
			outStream.write(captchaBytes);
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
