/*
* VmL
 * 
 */
package com.hanbit.Job_Portal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hanbit.Job_Portal.constants.DataBaseConstants;
import com.hanbit.Job_Portal.request.vo.UserManagementRequestVO;


/**
 * @author Bharat Kumar
 * 
 */
public class ManagementSettingsDAO {


	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		Class.forName(DataBaseConstants.DRIVER_CLASS);
		connection = DriverManager.getConnection(DataBaseConstants.DRIVER_URL, DataBaseConstants.USER_NAME,
				DataBaseConstants.PASSWORD);
		return connection;
	}

	public String edituser(UserManagementRequestVO usermanagementvo) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		String result = "Failure";

		try {
			con = getConnection();
			
			if(usermanagementvo.getUserRole().equalsIgnoreCase("1")) {
			
			pstmt = con.prepareStatement("update mdc_user set user_id=?,user_password=? where recu_id=? and user_password=?");
			}else if(usermanagementvo.getUserRole().equalsIgnoreCase("2")) {
				pstmt = con.prepareStatement("update mdc_user set user_id=?,user_password=? where applicant_id=? and user_password=?");
			}
			pstmt.setString(1, usermanagementvo.getUserID());
			pstmt.setString(2, usermanagementvo.getConfirmPassword());
			pstmt.setInt(3, usermanagementvo.getSrNo());
			pstmt.setString(4, usermanagementvo.getUserPassword());

			if (pstmt.executeUpdate() > 0) {
				result = "Success";
			}
			//}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	
}
