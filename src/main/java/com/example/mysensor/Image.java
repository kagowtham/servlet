package com.example.mysensor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class Image
 */
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	 MongoCollection<Document> collection;
	 MongoDatabase database ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Image() {
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
	   
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr=request.getParameter("usr");
		String pwd=request.getParameter("pwd");
		String key = null;
		collection = database.getCollection("profiles");
		List<DBObject> criteria = new ArrayList<DBObject>();
		criteria.add(new BasicDBObject("usr",usr ));
		criteria.add(new BasicDBObject("pwd",pwd ));
		FindIterable<Document> iterDoc = collection.find(new BasicDBObject("$and", criteria));
		Iterator<Document> iterator=iterDoc.iterator();
		while(iterator.hasNext()) {
			Document doc=iterator.next();
			key=doc.getString("key");
		}
		collection = database.getCollection("images");
		FindIterable<Document> iterDoc1 = collection.find(new Document("key",key));
		Iterator<Document> iterator1=iterDoc1.iterator();
		List<String> images=new ArrayList<String>();
		List<String> dates=new ArrayList<String>();
		while(iterator1.hasNext()) {
			Document doc=iterator1.next();
			byte a[]=Base64.getDecoder().decode(doc.getString("image").getBytes());
			images.add(org.apache.commons.codec.binary.Base64.encodeBase64String(a));
			dates.add(doc.getString("date"));
		}
		request.setAttribute("pictureList", images);
		request.setAttribute("dateList", dates);
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}