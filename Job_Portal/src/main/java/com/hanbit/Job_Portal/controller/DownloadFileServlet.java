package com.hanbit.Job_Portal.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadFileServlet
 */
@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		String FILE_LOCATION = "";
		String filename = "";	
		LocalDate date= LocalDate.now();
		LocalTime time= LocalTime.now();
		System.out.println("MOD==============>"+mode);
		
		if(mode.equalsIgnoreCase("Resume")){

			FILE_LOCATION = "C://FileUploaded//";
			filename = "demo.docx";		
		}
		
		
		File file  = new File(FILE_LOCATION + "/" + filename);
		response.setContentType("application/OCTET-STREAM");
		response.addHeader("Content-Disposition", "attachment; filename=" + filename);
		response.setContentLength((int)(file.length()));
		
		ServletOutputStream servletoutputstream = response.getOutputStream();
		BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
		
		int bytesread = bufferedinputstream.read();
        while(bytesread!= -1){
        	servletoutputstream.write(bytesread);
        	bytesread = bufferedinputstream.read();
        }
	}

}
