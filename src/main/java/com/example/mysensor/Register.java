package com.example.mysensor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 MongoClient mongo;
	 MongoCollection<Document> collection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
 @Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
	MongoClientURI uri = new MongoClientURI(
			"mongodb://db:db@mongodb/mydb");
	mongo = new MongoClient(uri);  
	   MongoDatabase database = mongo.getDatabase("mydb"); 
	  collection = database.getCollection("profiles");
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String devid=request.getParameter("devid");
	   String usr=request.getParameter("usr");
	   String pwd=request.getParameter("pwd");
	   
	   Document document = new Document("devid", devid) 
			      .append("usr",usr)
			      .append("pwd", pwd);
	  collection.insertOne(document);	
	 
	  response.getWriter().append("you are successfully registered and you can go to login page");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	mongo.close();
    }
}
