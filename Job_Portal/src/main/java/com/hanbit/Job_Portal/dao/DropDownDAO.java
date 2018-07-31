/**
 * 
 */
package com.hanbit.Job_Portal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.hanbit.Job_Portal.constants.DataBaseConstants;
import com.hanbit.Job_Portal.constants.SQLConstants;



/**
 * @author Bharat Kumar
 *
 */
public class DropDownDAO {

	
	Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(DataBaseConstants.DRIVER_CLASS);
		connection = DriverManager.getConnection(DataBaseConstants.DRIVER_URL, DataBaseConstants.USER_NAME,
				DataBaseConstants.PASSWORD);
		return connection;
	}

	public Map<String, String> getallStateNameList() throws SQLException {
		// TODO Auto-generated method stub
		
		Map<String,String> getStateNameList = new LinkedHashMap<String,String>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			 pstmt = con.prepareStatement(SQLConstants.getallStateName);
			 rs = pstmt.executeQuery();
			while (rs.next()) {
				getStateNameList.put(rs.getString("SrNo"), rs.getString("State"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			con.close();
		}
		return getStateNameList;
	}

	public Map<String, String> getAllDistrictList(String state) throws SQLException {
		// TODO Auto-generated method stub
		
		Map<String,String> getDistrictNameList = new LinkedHashMap<String,String>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			 pstmt = con.prepareStatement(SQLConstants.getallDistrictName);
			 pstmt.setString(1, state);
			 
			 rs = pstmt.executeQuery();
			while (rs.next()) {
				getDistrictNameList.put(rs.getString("Name"), rs.getString("Name"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			con.close();
		}
		return getDistrictNameList;
	}

	public Map<String, String> getAllprofileList() throws SQLException {
		// TODO Auto-generated method stub
		Map<String,String> getProfileNameList = new LinkedHashMap<String,String>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			 pstmt = con.prepareStatement(SQLConstants.getallProfileName);
			 
			 rs = pstmt.executeQuery();
			while (rs.next()) {
				getProfileNameList.put(rs.getString("profile"), rs.getString("profile"));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			con.close();
		}
		return getProfileNameList;
	}


}
