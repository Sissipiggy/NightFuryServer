<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sectionOneColumnDiv">
	<div class="sectionOneColumnTitleDiv">
	  		<h3 style="color:">注册</h3>
	</div>
	<ul class="regedit">
		<form action="/register" id="reg_form" name="reg_form" method="post"
			onSubmit="return checkForm();">
			<input type="hidden" name="hidCaptchaID" value="<%=session.getId()%>" />
			<input type='hidden' name='invite_code' value='' />
			<li><label>邮箱：</label></li>
			<li><input class="ipt ipt_nomal" name="user_email"
				id="user_email" />
				<div id="user_email_message" class="hint highlight"></div></li>
			<li class="gray">请输入您常用的邮箱，方便日后找回密码。</li>
			<li><label>用户名：</label></li>
			<li><input class="ipt ipt_nomal" name="user_name" id="user_name"
				autocomplete="off" />
				<div id="user_name_message" class="hint"></div></li>
			<li class="gray">4-16个字符，1个中文等于2个字符，一旦注册成功用户名不能修改。</li>
			<li><label>密码：</label></li>
			<li><input class="ipt ipt_nomal" type="password"
				name="user_password" id="user_password" autocomplete="off" />
				<div id="user_password_message" class="hint"></div></li>
			<li class="gray">由6-20个英文字母、数字或符号组成。</li>
			<li><label>重新输入密码：</label></li>
			<li><input class="ipt ipt_nomal" type="password"
				name="user_repassword" id="user_repassword" />
				<div id="user_repassword_message" class="hint highlight"></div></li>
			<li class="gray">重复上面的密码</li>
			</li>
			<li><label>验证码：</label></li>
			<li><img src="/register/captcha" id="captchaImage"
				style="margin-left: 12px;" height="50" ; width="130" border="0"
				align="middle" border="1" /><a href="javascript:getVerCode();">看不清？</a></li>
			<li><input class="ipt ipt_nomal" type="text" name="veriCode"
				id="veriCode" placeholder="输入验证码" />
				<div id="user_veriCode_message" class="hint highlight"></div></li>
			<li><input class="button" type="submit" value="注册" /> </span></li>
		</form>
	</ul>
	<div class="clear"></div>
</div>