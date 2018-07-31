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

import com.google.gson.JsonElement;
import com.hanbit.Job_Portal.constants.DataBaseConstants;
import com.hanbit.Job_Portal.request.vo.ApplicantRequestVO;
import com.hanbit.Job_Portal.request.vo.RecruiterRequestVO;
import com.hanbit.Job_Portal.request.vo.RegistrationRequestVO;
import com.hanbit.Job_Portal.response.vo.ApplicantResposeVO;
import com.hanbit.Job_Portal.response.vo.RecruiterResponseVO;
import com.hanbit.Job_Portal.response.vo.RegistrationResponseVO;


/**
 * @author Bharat Kumar
 * 
 */
public class RegistartionSetUpDAO {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(DataBaseConstants.DRIVER_CLASS);
		connection = DriverManager.getConnection(DataBaseConstants.DRIVER_URL, DataBaseConstants.USER_NAME,
				DataBaseConstants.PASSWORD);
		return connection;
	}

	/* Recruiter Details */
	
	
	public List<RecruiterResponseVO> getRecruiterdetails(int type) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecruiterResponseVO> recruiterdetailslist = null;
		try {
			con = getConnection();
			recruiterdetailslist = new LinkedList<RecruiterResponseVO>();

				pstmt = con.prepareStatement(
						"select srNo,firstName,lastName,gender,mobile,email,location,jobProfile,job_Desc,jobDate,lastDate FROM recruiter where srNo=? order by lastDate desc");
				pstmt.setInt(1, type);
			

			rs = pstmt.executeQuery();
			RecruiterResponseVO recruitervo = null;
			while (rs.next()) {
				recruitervo = new RecruiterResponseVO();
				recruitervo.setSrNo(rs.getInt("srNo"));
				recruitervo.setFirstName(rs.getString("firstName"));
				recruitervo.setLastName(rs.getString("lastName"));
				recruitervo.setGender(rs.getString("gender"));
				recruitervo.setMobile(rs.getString("mobile"));
				recruitervo.setMobile(rs.getString("mobile"));
				recruitervo.setEmail(rs.getString("email"));
				recruitervo.setLocation(rs.getString("location"));
				recruitervo.setJobProfile(rs.getString("jobProfile"));
				recruitervo.setJobDesc(rs.getString("job_Desc"));
				recruitervo.setJobDate(rs.getString("jobDate"));
				recruitervo.setLastDate(rs.getString("lastDate"));
				recruiterdetailslist.add(recruitervo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			con.close();
		}
		return recruiterdetailslist;
	}

	public boolean checkifEmailExist(RecruiterRequestVO recruitervo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement("select * from recruiter where email=?");
			pstmt.setString(1, recruitervo.getEmail());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public String addrecruiter(RecruiterRequestVO recruitervo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		String result = "Failure";

		try {
			con = getConnection();

			pstmt = con.prepareStatement(
					"INSERT INTO recruiter(firstName,lastName,gender,mobile,email,location,jobProfile,job_Desc,jobDate,lastDate) VALUES(?,?,?,?,?,?,?,?,?,SYSDATETIME())");
			pstmt.setString(1, recruitervo.getFirstName());
			pstmt.setString(2, recruitervo.getLastName());
			pstmt.setString(3, recruitervo.getGender());
			pstmt.setString(4, recruitervo.getMobile());
			pstmt.setString(5, recruitervo.getEmail());
			pstmt.setString(6, recruitervo.getLocation());
			pstmt.setString(7, recruitervo.getJobProfile());
			pstmt.setString(8, recruitervo.getJobDesc());
			pstmt.setString(9, recruitervo.getJobDate());
			
			if (pstmt.executeUpdate() > 0) {
				result = "Success";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public String editrecruiter(RecruiterRequestVO recruitervo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		String result = "Failure";

		try {
			con = getConnection();
			String sqlQuery = "UPDATE recruiter SET firstName=?,lastName=?,gender=?,mobile=?,email=?,location=?,jobProfile=?,job_Desc=?,jobDate=?,lastDate=SYSDATETIME() WHERE srNo=?";
			pstmt = con.prepareStatement(sqlQuery);
			
			pstmt.setString(1, recruitervo.getFirstName());
			pstmt.setString(2, recruitervo.getLastName());
			pstmt.setString(3, recruitervo.getGender());
			pstmt.setString(4, recruitervo.getMobile());
			pstmt.setString(5, recruitervo.getEmail());
			pstmt.setString(6, recruitervo.getLocation());
			pstmt.setString(7, recruitervo.getJobProfile());
			pstmt.setString(8, recruitervo.getJobDesc());
			pstmt.setString(9, recruitervo.getJobDate());

			
			pstmt.setInt(10, recruitervo.getSrNo());
			if (pstmt.executeUpdate() > 0) {
				result = "Success";
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public boolean checkifApplicantEmailExist(ApplicantRequestVO applicantvo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement("select * from applicant where email=?");
			pstmt.setString(1, applicantvo.getEmail());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public String addapplicant(ApplicantRequestVO applicantvo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		String result = "Failure";

		try {
			con = getConnection();

			pstmt = con.prepareStatement(
					"INSERT INTO applicant([firstName],[lastName],gender,[mobile],[email],[currentLocation],[profileSummary],[keySkill],[designation],[organization],[startDate],[endDate],[JobProfile],[noticePeriod],[projectTitle],[projectStartDate],[projectEndDate],[projectDetails],[projectRole],[projectSkill],[education],[passoutYear],[marks],[lastaDate]) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATETIME())");
			pstmt.setString(1, applicantvo.getFirstName());
			pstmt.setString(2, applicantvo.getLastName());
			pstmt.setString(3, applicantvo.getGender());
			pstmt.setString(4, applicantvo.getMobile());
			pstmt.setString(5, applicantvo.getEmail());
			pstmt.setString(6, applicantvo.getCurrentlocation());
			pstmt.setString(7, applicantvo.getProfileSummary());
			pstmt.setString(8, applicantvo.getKeySkill());
			pstmt.setString(9, applicantvo.getDesignaion());
			
			
			pstmt.setString(10, applicantvo.getOrganization());
			pstmt.setString(11, applicantvo.getStartDate());
			pstmt.setString(12, applicantvo.getEndDate());
			pstmt.setString(13, applicantvo.getJobProfile());
			pstmt.setString(14, applicantvo.getNoticePeriod());
			pstmt.setString(15, applicantvo.getProjectName());
			pstmt.setString(16, applicantvo.getProjectStartEnd());
			pstmt.setString(17, applicantvo.getProjectEndDate());
			pstmt.setString(18, applicantvo.getProjectDetails());
			

			pstmt.setString(19, applicantvo.getProjectRole());
			pstmt.setString(20, applicantvo.getProjectSkill());
			pstmt.setString(21, applicantvo.getEducation());
			pstmt.setString(22, applicantvo.getPassoutYear());
			pstmt.setString(23, applicantvo.getMarks());

			
			if (pstmt.executeUpdate() > 0) {
				result = "Success";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public List<ApplicantResposeVO> getapplicantdetails(int typeId) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ApplicantResposeVO> applicantdetailslist = null;
		try {
			con = getConnection();
			applicantdetailslist = new LinkedList<ApplicantResposeVO>();

				pstmt = con.prepareStatement(
						"select srNo,[firstName],[lastName],gender,[mobile],[email],[currentLocation],[profileSummary],[keySkill],[designation],[organization],[startDate],[endDate],[JobProfile],[noticePeriod],[projectTitle],[projectStartDate],[projectEndDate],[projectDetails],[projectRole],[projectSkill],[education],[passoutYear],[marks],[lastaDate] FROM applicant where srNo=? order by lastaDate desc");
				pstmt.setInt(1, typeId);
			

			rs = pstmt.executeQuery();
			ApplicantResposeVO applicantrvo = null;
			while (rs.next()) {
				applicantrvo = new ApplicantResposeVO();
				
				applicantrvo.setSrNo(rs.getInt("srNo"));
				applicantrvo.setFirstName(rs.getString("firstName"));
				applicantrvo.setLastName(rs.getString("lastName"));
				applicantrvo.setGender(rs.getString("gender"));
				applicantrvo.setMobile(rs.getString("mobile"));
				applicantrvo.setEmail(rs.getString("email"));
				applicantrvo.setCurrentlocation(rs.getString("currentlocation"));
				applicantrvo.setProfileSummary(rs.getString("profileSummary"));
				applicantrvo.setKeySkill(rs.getString("keySkill"));
				applicantrvo.setDesignaion(rs.getString("designation"));
				applicantrvo.setOrganization(rs.getString("organization"));
				
				
				
				applicantrvo.setStartDate(rs.getString("startDate"));
				applicantrvo.setEndDate(rs.getString("endDate"));
				applicantrvo.setJobProfile(rs.getString("JobProfile"));
				applicantrvo.setNoticePeriod(rs.getString("noticePeriod"));
				applicantrvo.setProjectName(rs.getString("projectTitle"));
				applicantrvo.setProjectStartEnd(rs.getString("projectStartDate"));
				applicantrvo.setProjectEndDate(rs.getString("projectEndDate"));
				applicantrvo.setProjectDetails(rs.getString("projectDetails"));
				applicantrvo.setProjectRole(rs.getString("projectRole"));
				applicantrvo.setProjectSkill(rs.getString("projectSkill"));
				
				
				applicantrvo.setEducation(rs.getString("education"));
				applicantrvo.setPassoutYear(rs.getString("passoutYear"));
				applicantrvo.setMarks(rs.getString("marks"));
				applicantrvo.setLastDate(rs.getString("lastaDate"));
				
				
				applicantdetailslist.add(applicantrvo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			con.close();
		}
		return applicantdetailslist;
	}

	public boolean checkifregisterEmailExist(RegistrationRequestVO registrationvo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement("select * from recruiter where email=?");
			pstmt.setString(1, registrationvo.getEmail());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public boolean checkifregisterApplicantEmailExist(RegistrationRequestVO registrationvo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement("select * from applicant where email=?");
			pstmt.setString(1, registrationvo.getEmail());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public String addapply(int applicantsrNo, int jobSrNo, String JobProfile) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		String result = "Failure";

		try {
			con = getConnection();

			pstmt = con.prepareStatement(
					"INSERT INTO applyJob(applicant_id,recruiter_id,jobProfile,lastDate) VALUES(?,?,?,SYSDATETIME())");
			pstmt.setInt(1, applicantsrNo);
			pstmt.setInt(2, jobSrNo);
			pstmt.setString(3,JobProfile);
			
			if (pstmt.executeUpdate() > 0) {
				result = "Success";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	public String editapplicant(ApplicantRequestVO applicantvo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		String result = "Failure";

		try {
			con = getConnection();
			String sqlQuery = "UPDATE applicant SET [firstName]=?,[lastName]=?,gender=?,[mobile]=?,[email]=?,[currentLocation]=?,[profileSummary]=?,[keySkill]=?,[designation]=?,[organization]=?,[startDate]=?,[endDate]=?,[JobProfile]=?,[noticePeriod]=?,[projectTitle]=?,[projectStartDate]=?,[projectEndDate]=?,[projectDetails]=?,[projectRole]=?,[projectSkill]=?,[education]=?,[passoutYear]=?,[marks]=?,[lastaDate]=SYSDATETIME() where srNo=?";
			pstmt = con.prepareStatement(sqlQuery);
			
			pstmt.setString(1, applicantvo.getFirstName());
			pstmt.setString(2, applicantvo.getLastName());
			pstmt.setString(3, applicantvo.getGender());
			pstmt.setString(4, applicantvo.getMobile());
			pstmt.setString(5, applicantvo.getEmail());
			pstmt.setString(6, applicantvo.getCurrentlocation());
			pstmt.setString(7, applicantvo.getProfileSummary());
			pstmt.setString(8, applicantvo.getKeySkill());
			pstmt.setString(9, applicantvo.getDesignaion());
			pstmt.setString(10, applicantvo.getOrganization());
			pstmt.setString(11, applicantvo.getStartDate());
			pstmt.setString(12, applicantvo.getEndDate());
			pstmt.setString(13, applicantvo.getJobProfile());
			pstmt.setString(14, applicantvo.getNoticePeriod());
			pstmt.setString(15, applicantvo.getProjectName());
			pstmt.setString(16, applicantvo.getProjectStartEnd());
			pstmt.setString(17, applicantvo.getProjectEndDate());
			pstmt.setString(18, applicantvo.getProjectDetails());
			

			pstmt.setString(19, applicantvo.getProjectRole());
			pstmt.setString(20, applicantvo.getProjectSkill());
			pstmt.setString(21, applicantvo.getEducation());
			pstmt.setString(22, applicantvo.getPassoutYear());
			pstmt.setString(23, applicantvo.getMarks());

			
			pstmt.setInt(24, applicantvo.getSrNo());
			if (pstmt.executeUpdate() > 0) {
				result = "Success";
			}

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return result;
	}

	

	

}
