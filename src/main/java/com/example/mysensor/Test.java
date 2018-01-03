package com.example.mysensor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String a="off";
    boolean isEnters=false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
				 
		         String recievedString =request.getParameter("status");
		         System.out.println("recived "+recievedString);
		         if(recievedString.trim().equals("on")||recievedString.trim().equals("off")) {
		        	a=recievedString.trim();
		        	System.out.println("server: changed state "+recievedString);
		        	response.getWriter().append(a);
		         }else if(recievedString.trim().equals("req")) {
		        	 if(isEnters) {
		        		 response.getWriter().append("1");
		        	 }else {
		        		 System.out.println("called");
		        		 response.getWriter().append("0");
		        	 }
		        	 isEnters=false;
		         }else if(recievedString.equals("1")) {
		        	 isEnters=true;
		         }else if(recievedString.trim().equals("img")) {
		        	    if(Upload.upload) {
		        	      response.setContentType("image/jpeg");  
		        	      ServletOutputStream out;  
		        	      out = response.getOutputStream(); 
		        	      out.write(Upload.buffer);
		        	      out.close();
		        	  
		        	      Upload.upload=false;
		        	    }else {
		        	    	return;
		        	    }
		         }
		         
		         else {
		        	 response.getWriter().append(a);
		         }
				 
				  }catch(Exception e) {
					  response.getWriter().append(a);
				  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
