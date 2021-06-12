package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FoodDao;
import com.pojo.Food;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet 
{
	Food f= new Food();
	FoodDao fd= new FoodDao();
	boolean result;
	HttpSession s;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("operation");
		s=request.getSession();
		if(a != null && a.equals("edit"))
		{
			String name=request.getParameter("fname");
			Food f=fd.searchFood(name);
			s.setAttribute("Food", f);
			response.sendRedirect("updateFood.jsp");
			
		}
		else if(a !=null && a.equals("delete"))
		{
			int id=Integer.parseInt(request.getParameter("fid"));
			result=fd.deleteFood(id);
			if(result==true)
			{
				 response.sendRedirect("FoodServlet");
			}
			else
			{
				response.sendRedirect("Error.html");
			}
		}
		else
		{
		
		List<Food> flist=fd.displayFood();
		s.setAttribute("FoodDetails", flist);
		response.sendRedirect("FoodList.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("operation");
		s=request.getSession();
		String name,cat;
		double price;
		if(a != null && a.equals("update"))
		{
			int id=Integer.parseInt(request.getParameter("foodId"));
			 name=request.getParameter("fname");
			 cat=request.getParameter("category");
			 price=Double.parseDouble(request.getParameter("price"));
			 f.setFoodId(id);
			 f.setFoodName(name);
			 f.setPrice(price);
			 f.setCategory(cat);
			 result=fd.updateFood(f);
			 if(result==true)
			 {
				 response.sendRedirect("FoodServlet");
			 }
			 else
			 {
				 response.sendRedirect("Error.html");
			 }
			
		}
		else if(a!=null && a.equals("Search")) //Search food
		 {
			 String foodName=request.getParameter("FoodName");
			 List<Food> foodlist=fd.getFoodByName(foodName);
			 s.setAttribute("FoodDetails", foodlist);
			 response.sendRedirect("FoodList.jsp");
		}
		else
		{
		 name=request.getParameter("fname");
		 cat=request.getParameter("category");
		 price=Double.parseDouble(request.getParameter("price"));
		f.setFoodName(name);
		f.setPrice(price);
		f.setCategory(cat);
		result=fd.addFood(f);
		if(result==true)
		{
			response.sendRedirect("success.html");
		}
		else
		{
			
			response.sendRedirect("Error.html");
		}
		
		}
		
	}

}
