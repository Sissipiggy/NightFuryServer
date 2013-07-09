package com.TroyEmpire.NightFuryServer.Util;

import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaUtil {
	// a singleton class
	// 实现单例模式的类
	private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService();

	public static ImageCaptchaService getInstance() {
		return instance;
	}

	/*
	 * 跟验证码生成有关的函数
	 */
	public static boolean validateCaptcha(String captchaId, String inputChars) {
		boolean bValidated = false;
		try {
			bValidated = CaptchaUtil.getInstance().validateResponseForID(
					captchaId, inputChars);
		} catch (CaptchaServiceException cse) {
		}
		return bValidated;
	}
}
