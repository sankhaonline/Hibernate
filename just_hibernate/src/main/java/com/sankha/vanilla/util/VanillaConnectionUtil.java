package com.sankha.vanilla.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class VanillaConnectionUtil {
	final static Logger logger = LoggerFactory.getLogger(VanillaConnectionUtil.class);

	private static Connection connection = null;

	private static String dbConnURL = "jdbc:mysql://localhost:3306/justhibernate?useSSL=false";
	private static String driverClass = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "mypass";

	public static final Connection getConnection() {
		try {
			Class.forName(driverClass).newInstance();
			connection = DriverManager.getConnection(dbConnURL, userName, password);
		} catch (Exception ex) {
			logger.error("Exception:" + ex.getMessage());
		}
		return connection;
	}
}
