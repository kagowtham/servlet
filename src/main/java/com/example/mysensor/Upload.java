package com.example.mysensor;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Upload
 */
@WebServlet
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static byte[] buffer;
	static boolean upload=false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
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
	      upload=true;
	      System.out.println("file uploaded \n \n \n "+buffer.length);
	      response.getWriter().write(1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
