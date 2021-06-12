package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	LoginDao ld= new LoginDao();
	boolean result;
	HttpSession s;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		s=request.getSession();
		s.invalidate();
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		s=request.getSession();
		String type=request.getParameter("type");
		String u=request.getParameter("uname");
		String p=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		if(type.equals("Admin"))
		{
		if(u.equals("admin")&& p.equals("123"))
		{
			s.setAttribute("Admin", u);
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("Login.jsp");
		}
		}
		
		else if(type.equals("Customer"))
		{
			 result=ld.customerLogin(u, p);
			 if(result==true)
			 {
					s.setAttribute("Customer", u);
				 response.sendRedirect("index.jsp");
			 }
			 else
			 {
				 response.sendRedirect("Login.jsp");

			 }
		}
	}

}
