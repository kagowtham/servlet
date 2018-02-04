package com.example.mysensor;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class Upload
 */
@WebServlet
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static byte[] buffer;
	static boolean upload=false;
	MongoClient mongo;
	 MongoCollection<Document> collection;
	 MongoDatabase database ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	MongoClientURI uri = new MongoClientURI(
    			"mongodb://db:db@mongodb/mydb");
    	mongo = new MongoClient(uri);  
    	   database = mongo.getDatabase("mydb"); 
    	   
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("called file upload");
		  Part filePart = request.getPart("image");
		  InputStream fileContent = filePart.getInputStream();
		  buffer = new byte[fileContent.available()];
		  fileContent.read(buffer);
	      Status.upload.put(request.getParameter("key"), true);
	      
	      String encoded = Base64.getEncoder().encodeToString(buffer);
	      Status.buffer.put(request.getParameter("key"), encoded);
	      System.out.println("file uploaded \n \n \n "+buffer.length);
	      response.getWriter().write(1);
	      String date=LocalDateTime.now().toString();
	        
	        Document document=new Document("key",request.getParameter("key")).append("image", Status.buffer.get(request.getParameter("key"))).append("date", date);
	        collection = database.getCollection("images");
	        collection.insertOne(document);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
