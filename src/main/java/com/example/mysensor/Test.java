package com.example.mysensor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
  //  boolean isEnters=false;
	MongoClient mongo;
	 MongoCollection<Document> collection;
	 MongoDatabase database ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }
     @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	MongoClientURI uri = new MongoClientURI(
    			"mongodb://db:db@mongodb/mydb");
    	mongo = new MongoClient( uri);  
 	   database = mongo.getDatabase("mydb"); 
 	   collection = database.getCollection("profiles");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
				 
		         String recievedString =request.getParameter("status");
		         String key=request.getParameter("key");
		         System.out.println("recived "+recievedString+" "+key);
		         
		       if(recievedString.trim().equals("req")) {
		    	     
		        	 if(Status.isEnters.containsKey(key)) {
		        		 if(Status.isEnters.get(key)) {
		        			 System.out.println("finded isEnter :"+Status.isEnters.get("key"));
		        		   response.getWriter().append("1");
		        		 }else {
		        		   response.getWriter().append("0");
		        		 }
		        	 }else {
		        		 response.getWriter().append("0");
		        	 }
		        	 Status.isEnters.put(key, false);
		        	 //isEnters=false;
		         }else if(recievedString.equals("1")) {
		        	// isEnters=true;
		        	 Status.isEnters.put(key, true);
		        	 System.out.println("changed isEnter :"+Status.isEnters.get(key));
		         }else if(recievedString.trim().equals("img")) {
<<<<<<< HEAD
		        	    if(Status.upload.containsKey(key)) {
		        	      if(Status.upload.get(key)) {
		        	       response.setContentType("image/jpeg");  
		        	       ServletOutputStream out;  
		        	       out = response.getOutputStream(); 
		        	       byte[] decoded = Base64.getDecoder().decode(Status.buffer.get(key));
		        	       out.write(decoded);
		        	       out.close();
		        	        Status.upload.put(key, false);
		        	      // Upload.upload=false;
		        	        
		        	      }else {
		        	    	  System.out.println("img key not true");
		        	    	return;
		        	      }
=======
		        	    if(Upload.upload) {
				       Upload.upload=false;
		        	      response.setContentType("image/jpeg");  
		        	      ServletOutputStream out;  
		        	      out = response.getOutputStream(); 
		        	      out.write(Upload.buffer);
		        	      out.close();
		        	  
		        	   
>>>>>>> b8c188e88f6aebc1f66190ea5101c578d3bbe0df
		        	    }else {
		        	    	System.out.println("img key not found");
		        	    	return;
		        	    }
		         }
		         
		         else {
		        	 response.getWriter().append("0");
		         }
				 
				  }catch(Exception e) {
					  response.getWriter().append("0");
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
