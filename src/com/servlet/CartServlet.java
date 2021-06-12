package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDao;
import com.pojo.Cart;
import com.pojo.Order;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	Cart c= new Cart();
	CartDao cd= new CartDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		String a=request.getParameter("operation");
		String customer=(String)s.getAttribute("Customer");
		
		if(a!=null && a.equals("addToCart"))
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			c.setEmailId(customer);
			c.setFoodId(fid);
			boolean result=cd.addCart(c);
			if(result==true)
			{
				s.setAttribute("success", "Food Added to Cart");
				response.sendRedirect("FoodList.jsp");
			}
			else
			{
				response.sendRedirect("Error.html");
			}
			
		}
		else if(a!=null && a.equals("displayorder"))
		{
			List<Order>olist=cd.displayallorder();
			s.setAttribute("OrderList", olist);
			response.sendRedirect("OrderList.jsp");
			
		}
		else
		{
			List<Cart> clist=cd.showCart(customer);
			s.setAttribute("cartlist", clist);
			response.sendRedirect("CartList.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s=request.getSession();
		String customer=(String)s.getAttribute("Customer");
		double totalBill = 0;
		String price[]=request.getParameterValues("foodprice");
		String qty[]=request.getParameterValues("qty");
		for(int i=0;i<price.length;i++)
		{
			totalBill=Double.parseDouble(price[i])*Integer.parseInt(qty[i]);
		}
		int orderId=cd.placeOrder(customer, totalBill);
		if(orderId>0)
		 {
			 boolean flag=cd.clearCart(customer);
			 if(flag==true)
			 {
				 s.setAttribute("success","Your total bill is:"+totalBill);
				 response.sendRedirect("index.jsp");
			 }
		 }
		 else
		 {
			 response.sendRedirect("Error.html");
		 }
		
	}

}
