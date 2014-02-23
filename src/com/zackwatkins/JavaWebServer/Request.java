package com.zackwatkins.JavaWebServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Request {
	private String targetFile = null;
	private String[] parsedRequest = null;
	private Socket request = null;
	
	public Request(Socket request) {
		this.request = request;
	}
	
	public void parse() {
		try {
			InputStream sis = request.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(sis));
			String firstLine = in.readLine();
			System.out.println(firstLine);
			parsedRequest = firstLine.split(" ");
			targetFile = parsedRequest[1];
			
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getTargetFile() {
		return this.targetFile;
	}
	
	public void serveFile(String[] file) {
		try {
			PrintWriter out = new PrintWriter(request.getOutputStream(), true);
			//Do static stuff
			out.write("HTTP/1.1 200 OK");
			out.write("Date:");
			out.write("Server: Zack's Java Server");
			out.write("Conetent-Type: text/html");
			out.write("Content-Length: 99999");
			for(int i = 0; i < file.length; i++) {
				out.write(file[i]);
			}
			out.flush();
			//out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		request = null;
	}
}
