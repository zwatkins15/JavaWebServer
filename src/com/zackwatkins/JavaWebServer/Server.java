package com.zackwatkins.JavaWebServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server {
	private static int SERVERPORT = 80, //Default
					   MAXCONNECTIONS = 10;
	private static final double VERSION = 0.01;
	private static String SERVERIP = "127.0.0.1"; //Default
	private static ServerSocket listener;
	
	
	private static void handleArguments(String[] args) {
		//are there any arguments?
		if(args.length != 0) {
			for(int i = 0; i < args.length; i++) {
				//Check for each command
				//TODO: Handle format Exceptions...
				if(args[i].toLowerCase().equals("-p") || args[i].toLowerCase().equals("--listenport")) {
					SERVERPORT = Integer.parseInt(args[i+1]);
					i++; //Skip next args
				} else if(args[i].toLowerCase().equals("-ip") || args[i].toLowerCase().equals("--listenon")) {
					SERVERIP = args[i+1];
					i++; //Skip next args
				} else if(args[i].toLowerCase().equals("-max") || args[i].toLowerCase().equals("--maxconnections")) {
					MAXCONNECTIONS = Integer.parseInt(args[i+1]);
					i++;
				}
			}
		}
		//No arguments, do nothing!
		System.out.printf("%n-INIT: No arguments provided, defaulting settings.%n");
	}
	
	private static void init() {
		//TODO: Custom output for exceptions.
		try {
			listener = new ServerSocket(SERVERPORT, MAXCONNECTIONS, InetAddress.getByName(SERVERIP));
			System.out.printf("-INIT: Socket created: http://%s:%d.", SERVERIP, SERVERPORT);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//Welcome message
		System.out.printf("Welcome to my Java Web server! v%.2f", VERSION);
		//Handle Arguments
		handleArguments(args);
		//Create necessary objects and such...
		init();
	}
}