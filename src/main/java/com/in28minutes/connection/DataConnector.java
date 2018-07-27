package com.in28minutes.connection;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.*;

import javax.sql.DataSource;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

public class DataConnector implements DataSource {

	private static MySQLConnection con = null;
	
	/*	
	 * Static inner class to enable Singleton access to DB connection resource  
	 */
	public static class ConnectorRetriever {
		
		private static DataConnector dataConnector = new DataConnector();
		
		
		public ConnectorRetriever () {
		
		}
		
		/* Singleton method to ensure only one database connection */
		public static MySQLConnection getInstance() {
			
			if (con == null) {
				try {
					con =  dataConnector.getConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return con;
		}
	}
	
	private DataConnector() {
	
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MySQLConnection getConnection() throws SQLException {

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} 
		
		//Properties props = new Properties();
		//props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
		//Context ctx = new InitialContext();
		//Context envCtx = (Context) ctx.lookup("java:comp/env/dom_webprojs");
		//DataSource ds = (DataSource)envCtx.lookup("jdbc/dom_webproj");	
		// = ds.getConnection("root", "Sm0k3stack3r"); 
		try {
				String url = "jdbc:mysql://localhost:3306/mysql";
				con = (MySQLConnection)DriverManager.getConnection(url, "root", "Sm0k3stack3r");
				System.out.println("Connected to database");
			}
			catch (Exception e){
			    e.printStackTrace();
			}
			return con;
		}
	
	public void closeConnection(MySQLConnection passCon) {
		try {
			passCon.close();
			System.out.println("Connection to database closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
