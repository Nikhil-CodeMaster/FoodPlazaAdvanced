package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	Customer c= new Customer();
	CustomerDao cd= new CustomerDao();
	boolean result;
	HttpSession s;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		s=request.getSession();
		List <Customer> custlist=cd.getallcustomer();
		s.setAttribute("custlist", custlist);
    	response.sendRedirect("CustomerList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		s=request.getSession();
		String cname=request.getParameter("cname");
		String address=request.getParameter("address");
		String contact=request.getParameter("contactno");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
//		int cid=Integer.parseInt(request.getParameter("fid"));

		
//		c.setCustId(cid);
		c.setCustomerName(cname);
		c.setAddress(address);
		c.setContactNo(contact);
		c.setEmailId(emailid);
		c.setPassword(password);
		result=cd.addCustomer(c);
		if(result == true)
		{
			s.setAttribute("success", "You have successfully registered");
			response.sendRedirect("index.jsp");
		}
		else
		{
			response.sendRedirect("Error.html");
		}
	}

}
