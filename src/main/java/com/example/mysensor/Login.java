package com.example.mysensor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	MongoCollection<Document> collection ;
	MongoDatabase database ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	   database = mongo.getDatabase("mydb"); 
	  collection = database.getCollection("profiles");
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr=request.getParameter("usr");
		String pwd=request.getParameter("pwd");
		System.out.println(usr+" "+pwd);
		if(usr.equals("a")&&pwd.equals("a")) {
			collection = database.getCollection("images");
			collection.deleteMany(new Document());
		};
		List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("usr",usr ));
		criteria.add(new BasicDBObject("pwd",pwd ));
		FindIterable<Document> iterDoc = collection.find(new BasicDBObject("$and", criteria));
		Iterator<Document> iterator=iterDoc.iterator();
		
		int i=0;
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			i++;
		}
		if(i==0) {
			System.out.println("false");
			response.getWriter().append("false");
			
		}else {
			System.out.println("true");
			response.getWriter().append("true");
			
		}
		
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
