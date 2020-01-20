package com.lti.college;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
  
	
	
    public RegisterServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		int cid = Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String coursetype=request.getParameter("coursetype");
		String city=request.getParameter("city");
		int fees = Integer.parseInt(request.getParameter("fees"));
		int pincode = Integer.parseInt(request.getParameter("pin"));
		 
		College c=new College(cid,cname,coursetype,city,fees,pincode);
		
		
		
		
	
			RegisterDaoImpl rd=new RegisterDaoImpl();
			
			rd.addCollege(c);
		}
		catch(NumberFormatException e){ // handle your exception
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		
		
		
		
		doGet(request, response);
	}

}
