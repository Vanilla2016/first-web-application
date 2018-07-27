package com.in28minutes.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.symptoms.constants.SymptomsConstants;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.ResultSetMetaData;
import com.opensymphony.xwork2.ActionSupport;

import com.in28minutes.connection.DataConnector;
import com.in28minutes.connection.DataConnector.ConnectorRetriever;

public class QueryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String tableValues;
	private String SQLQuery;
	private InputStream inputStream;
	private com.in28minutes.connection.DataConnector inputDataConnector;
	private MySQLConnection inputConnection;
	private String actionId;
	public String readNameTableString = null;
	public static final String INGREDIENTSQUERY =  "SELECT INGREDIENTID, INGREDIENTNAME FROM SYMPTOMSDB.INGREDIENTS";
	
	public String execute() {
		  
		/*
		  if (getActionId().equalsIgnoreCase(SymptomsConstants.ingredients)) {
			  readNameTableString = SymptomsConstants.INGREDIENTSQUERY;
		  } else if (getActionId().equalsIgnoreCase(SymptomsConstants.sleephours)) {
			  readNameTableString = SymptomsConstants.SLEEPHOURSQUERY;
		  } else if (getActionId().equalsIgnoreCase(SymptomsConstants.preparation)) {
			  readNameTableString = SymptomsConstants.PREPARATIONQUERY;
		  }
	*/
		     inputConnection = ConnectorRetriever.getInstance();
			 tableValues = readTableVals(inputConnection, INGREDIENTSQUERY, true);
			 setInputStream(new ByteArrayInputStream(tableValues.getBytes(StandardCharsets.UTF_8)));
			 return SUCCESS;
	  }

		public String getSQLQuery() {
			return SQLQuery;
		}
	
		public void setSQLQuery(String sQLQuery) {
			SQLQuery = sQLQuery;
		}
	  
		public String getTableValues() {
			return tableValues;
		}

		public void setTableValues(String tableValues) {
			this.tableValues = tableValues;
		}

		public InputStream getInputStream() {
			return inputStream;
		}

		public void setInputStream(InputStream inputStream) {
			this.inputStream = inputStream;
		}

		public void setActionId(String actionId) {
			this.actionId = actionId;
		}

		public String getActionId() {
			return actionId;
		}
		
		/*
		 * Updated to make more generic to make read of DB columns based on RS metadata
		 * 
		 */
		public String readTableVals (MySQLConnection passInConn, String statementString, boolean divLayout) {
			
			ResultSet tableSet = null;
			StringBuffer tableVals = new StringBuffer();
			tableVals.append("\n");
			//String openTag = divLayout ? "<li>" : "<td>";
			//String closeTag = divLayout ? "</li>" : "</td>";
			
			try {
				PreparedStatement conStatement = passInConn.prepareStatement(statementString);
				tableSet = conStatement.executeQuery();
				ResultSetMetaData tableMetaData = (ResultSetMetaData) tableSet.getMetaData();
				int count = 0;
				
								
					
					
				} catch (SQLException sqlEx) {
					sqlEx.getStackTrace();
				}
			//System.out.println(tableVals);
			return tableVals.toString();
		}
}
