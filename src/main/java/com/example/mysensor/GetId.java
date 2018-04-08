package com.example.mysensor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * Servlet implementation class GetId
 */
@WebServlet("/GetId")
public class GetId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	MongoCollection<Document> collection ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		MongoClientURI uri = new MongoClientURI(
				   "mongodb+srv://mongodb-stitch-myapp-ykcyz:kagowtham@cluster0-qwbhs.mongodb.net/test");
	      
		   mongo = new MongoClient(uri); 
		   MongoDatabase database = mongo.getDatabase("mydb"); 
		  collection = database.getCollection("profiles");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usr=request.getParameter("usr");
		String pwd=request.getParameter("pwd");
		System.out.println(usr+" "+pwd);
		
		List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("usr",usr ));
		criteria.add(new BasicDBObject("pwd",pwd ));
		FindIterable<Document> iterDoc = collection.find(new BasicDBObject("$and", criteria));
		Iterator<Document> iterator=iterDoc.iterator();
		
		Document d=iterator.next();
		response.getWriter().append(d.get("devid").toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
