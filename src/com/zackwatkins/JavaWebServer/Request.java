package com.zackwatkins.JavaWebServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Request {
	private String targetFile = null;
	private String[] parsedRequest = null;
	private Socket request = null;
	private PrintWriter out = null;
	
	public Request(Socket request) {
		this.request = request;
		try {
			out = new PrintWriter(request.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void parse() {
		try {
			InputStream sis = request.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(sis));
			String firstLine = in.readLine();
			if(firstLine != null) {
				parsedRequest = firstLine.split(" ");
				targetFile = parsedRequest[1];
			} else {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getTargetFile() {
		return this.targetFile;
	}
	
	public void serverError(String error) {
		out.write("ERROR: " + error);
		out.write("\n:(");
		out.flush();
		out.close();
	}
	
	public void serveFile(ArrayList<String> file) {
		//Do static stuff
		out.write("HTTP/1.1 200 OK\n");
		out.write("Date:\n");
		out.write("Server: Zack's Java Server\n");
		out.write("Conetent-Type: text/html\n");
		//out.write("Content-Length: 1\n");
		for(int i = 0; i < file.size(); i++) {
			out.write(file.get(i).toString()+"\n");
		}
		out.flush();
	}
	
	public void close() {
		out.close();
		request = null;
	}
}
