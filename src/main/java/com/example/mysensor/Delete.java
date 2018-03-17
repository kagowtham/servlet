package com.example.mysensor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	 MongoCollection<Document> collection;
   
    public Delete() {
        super();
       
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	MongoClientURI uri = new MongoClientURI(
    			"mongodb://db:db@mongodb/mydb");
    	mongo = new MongoClient(uri);  
    	   MongoDatabase database = mongo.getDatabase("mydb"); 
    	  collection = database.getCollection("images");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date=request.getParameter("date");
		DeleteResult ds=collection.deleteOne(new Document("date",date));
		if(ds.getDeletedCount()>0) {
			response.getWriter().append("true");
		}else {
			response.getWriter().append("false");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
