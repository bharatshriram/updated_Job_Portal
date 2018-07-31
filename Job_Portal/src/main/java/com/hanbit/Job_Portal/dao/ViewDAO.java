/**
 * 
 */
package com.hanbit.Job_Portal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;




import com.hanbit.Job_Portal.constants.DataBaseConstants;
import com.hanbit.Job_Portal.constants.SQLConstants;
import com.hanbit.Job_Portal.response.vo.fetchViewResponseVO;

/**
 * @author Bharat Kumar
 *
 */
public class ViewDAO {
	
	
	Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(DataBaseConstants.DRIVER_CLASS);
		connection = DriverManager.getConnection(DataBaseConstants.DRIVER_URL, DataBaseConstants.USER_NAME,
				DataBaseConstants.PASSWORD);
		return connection;
	}

	public List<fetchViewResponseVO> getfetchViewdetails(int srNo, String Name) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		List<fetchViewResponseVO> fetchdetails_list = null;
		fetchViewResponseVO fetchdetailsvo = null;

		try {
			
			con = getConnection();
			
			fetchdetails_list = new LinkedList<fetchViewResponseVO>();
			
			pstmt = con.prepareStatement(SQLConstants.fetchdetails);
			pstmt.setString(1, Name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
					fetchdetailsvo = new fetchViewResponseVO();
					
					
					
					fetchdetailsvo.setSrNo(rs.getInt("srNo"));
					fetchdetailsvo.setFirstName(rs.getString("firstName"));
					fetchdetailsvo.setLastName(rs.getString("lastName"));
					fetchdetailsvo.setMobile(rs.getString("mobile"));
					fetchdetailsvo.setEmail(rs.getString("email"));
					fetchdetailsvo.setLocation(rs.getString("location"));
					fetchdetailsvo.setJobProfile(rs.getString("jobProfile"));
					fetchdetailsvo.setJobDesc(rs.getString("job_Desc"));
					fetchdetailsvo.setJobDate(rs.getString("jobDate"));
					fetchdetailsvo.setLastDate(rs.getString("lastDate"));
					fetchdetails_list.add(fetchdetailsvo);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
		//	rs1.close();
			con.close();
		}
		return fetchdetails_list;
	}

	public List<fetchViewResponseVO> getApplieddetails(int jobsrNo) throws SQLException {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		List<fetchViewResponseVO> fetchdetails_list = null;
		fetchViewResponseVO fetchdetailsvo = null;
		String profile="";

		try {
			
			con = getConnection();
			
			fetchdetails_list = new LinkedList<fetchViewResponseVO>();
			
			pstmt1 = con.prepareStatement(SQLConstants.jobPortalbySrno);
			pstmt1.setInt(1, jobsrNo);
		
			rs1 = pstmt1.executeQuery();
			/*ta.firstName,ta.lastName,ta.email,ta.mobile,ta.gender,ta.currentLocation,ta.profileSummary,ta.keySkill,ta.designation,ta.lastaDate*/
			if (rs1.next()) {
				
				profile=rs1.getString("jobProfile");
			}
			
			
			pstmt = con.prepareStatement(SQLConstants.fetchApplieddetails);
			pstmt.setInt(1, jobsrNo);
			pstmt.setString(2, profile);
			rs = pstmt.executeQuery();
			/*ta.firstName,ta.lastName,ta.email,ta.mobile,ta.gender,ta.currentLocation,ta.profileSummary,ta.keySkill,ta.designation,ta.lastaDate*/
			while (rs.next()) {
				
					fetchdetailsvo = new fetchViewResponseVO();
					
					fetchdetailsvo.setSrNo(rs.getInt("srNo"));
					
					fetchdetailsvo.setApplicantfirstName(rs.getString("firstName"));
					fetchdetailsvo.setApplicantlastName(rs.getString("lastName"));
					fetchdetailsvo.setApplicantemail(rs.getString("email"));
					fetchdetailsvo.setApplicantmobile(rs.getString("mobile"));
					fetchdetailsvo.setApplicantgender(rs.getString("gender"));
					fetchdetailsvo.setApplicantcurrentlocation(rs.getString("currentLocation"));
					fetchdetailsvo.setApplicantprofileSummary(rs.getString("profileSummary"));
					fetchdetailsvo.setApplicantkeySkill(rs.getString("keySkill"));
					fetchdetailsvo.setApplicantdesignaion(rs.getString("designation"));
					fetchdetailsvo.setLastDate(rs.getString("lastaDate"));
					fetchdetails_list.add(fetchdetailsvo);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
		//	rs1.close();
			con.close();
		}
		return fetchdetails_list;
	}

}
