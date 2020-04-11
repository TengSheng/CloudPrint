package cn.sm1234.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sm1234.domain.User;
import cn.sm1234.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController{

	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String login (User user, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		User resultUser = userService.login(user);
		if(resultUser == null) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或者密码错误");
	        response.setCharacterEncoding("utf-8");
			response.getWriter().print("登陆失败！");
			return "index";
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", resultUser);
	        response.setCharacterEncoding("utf-8");
	        response.getWriter().print("登陆成功！");
			return "redirect:/main.jsp";
		}
	}
}
