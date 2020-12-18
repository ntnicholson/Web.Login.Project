package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("user");
		String password = request.getParameter("pass");
		//response.setContentType("text/html");
		
		//New user
		com.bean.User u = new com.bean.User(name, password);
		
		//Data access object
		com.interfaces.IUserService us = new com.dao.UserAccount();
		
		if (us.Login(u) == true) 
		{
			response.getWriter().println("user login is successful");
			HttpSession s = request.getSession();
			s.setAttribute("uName", name);
			response.sendRedirect("DashboardServlet");
		}
		else {
			response.sendRedirect("loginError.html");
		}
	}

}
