package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	// 1. create constructor to load the file
	public ReadConfig() {
		// create config.property file
		File src = new File("./Configuration/config.properties");

		try {
			// read the file
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties(); // Initiating the pro object
			pro.load(fis); // loading congif.properties file
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	} // end constructor

	// now creating different methods to read all variables
	// from config.properties file

	// for baseURL
	public String getApplicationURL() {
		// create url variable and read baseURL from config.properties file
		String url = pro.getProperty("baseURL");
		return url;
	}

	// for username
	public String getUsername() {
		// create username variable and read usernaem from config.properties file
		String uName = pro.getProperty("username");
		return uName;
	}

	// for password
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}

	// for chrome driver
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	// for IE Driver
	public String getIEPath() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}

	// for fire fox driver
	public String getFirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	// for Edge driver
	public String getEdgePath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}

}
