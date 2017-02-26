package com.sankha.vanilla;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sankha.vanilla.util.VanillaConnectionUtil;

public class VanillaMovieManager {
	final static Logger logger = LoggerFactory.getLogger(VanillaMovieManager.class);

	private static String insertSql = "INSERT INTO MOVIES VALUES(?,?,?,?)";
	private static String selectSql = "SELECT *  FROM MOVIES";

	public static void persistMovie() {
		PreparedStatement ps;
		try {
			ps = VanillaConnectionUtil.getConnection().prepareStatement(insertSql);
			ps.setInt(1, 1002);
			ps.setString(2, "John Wick: Chapter 2");
			ps.setString(3, "Chad Stahelski");
			ps.setString(4, "Action, Crime");

			ps.execute();
			logger.info("Movie persisted successfully!");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void queryMovie() {
		Statement ps;
		try {
			ps = VanillaConnectionUtil.getConnection().createStatement();
			ResultSet rs = ps.executeQuery(selectSql);
			while (rs.next()) {
				logger.info("Movie found: " + rs.getString("NAME") + ", Directed by: " + rs.getString("DIRECTOR"));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
