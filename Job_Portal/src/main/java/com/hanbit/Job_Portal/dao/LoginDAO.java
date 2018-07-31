/**
 * 
 */
package com.hanbit.Job_Portal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.hanbit.Job_Portal.constants.DataBaseConstants;
import com.hanbit.Job_Portal.constants.ExtraConstants;
import com.hanbit.Job_Portal.exceptions.BusinessException;
import com.hanbit.Job_Portal.request.vo.LoginVO;
import com.hanbit.Job_Portal.request.vo.RegistrationRequestVO;
import com.hanbit.Job_Portal.response.vo.RecruiterResponseVO;
import com.hanbit.Job_Portal.response.vo.ResponseVO;
import com.hanbit.Job_Portal.response.vo.UserDetails;
import com.hanbit.Job_Portal.service.EmailService;
import com.hanbit.Job_Portal.utils.Encryptor;

/**
 * @author Bharat Kumar
 * 
 */
public class LoginDAO {

	// public static int CommunityID;

	public Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName(DataBaseConstants.DRIVER_CLASS);
		connection = DriverManager.getConnection(DataBaseConstants.DRIVER_URL, DataBaseConstants.USER_NAME,
				DataBaseConstants.PASSWORD);
		return connection;
	}

	public ResponseVO validateUser(LoginVO loginVo) throws ClassNotFoundException, BusinessException, SQLException {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet1 = null;
		ResponseVO responsevo = new ResponseVO();
		UserDetails userDetails = new UserDetails();

		try {
			con = getConnection();
			pstmt = con.prepareStatement(
					"SELECT user_id,user_password,role_id,applicant_id,recu_id FROM mdc_user where user_id=? and user_password = ?");
			pstmt.setString(1, loginVo.getUsername());
			pstmt.setString(2, loginVo.getPassword());
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				if (loginVo.getUsername().matches(resultSet.getString("user_id"))
						&& loginVo.getPassword().equals(resultSet.getString("user_password"))) {

					if (resultSet.getString("role_id").equalsIgnoreCase("1")) {
						
						pstmt1 = con.prepareStatement(
								"SELECT DISTINCT tr.firstName,tr.lastName,tr.email,tr.srNo FROM mdc_user as tmdc,recruiter tr  where tmdc.role_id=? and tmdc.recu_id=? and tmdc.recu_id = tr.srNo");
						pstmt1.setString(1, resultSet.getString("role_id"));
						pstmt1.setString(2, resultSet.getString("recu_id"));
						resultSet1 = pstmt1.executeQuery();
						if (resultSet1.next()) {
							
							userDetails.setFirstName(resultSet1.getString("firstName"));
							userDetails.setLastName(resultSet1.getString("lastName"));
							userDetails.setEmail(resultSet1.getString("email"));
							
						}

						responsevo.setType(resultSet.getString("recu_id"));

					} else if (resultSet.getString("role_id").equalsIgnoreCase("2")) {
						
						pstmt1 = con.prepareStatement(
								"SELECT DISTINCT ta.firstName,ta.lastName,ta.email,ta.srNo FROM mdc_user as tmdc,applicant ta  where tmdc.role_id=? and tmdc.applicant_id=? and tmdc.applicant_id = ta.srNo");
						pstmt1.setString(1, resultSet.getString("role_id"));
						pstmt1.setString(2, resultSet.getString("applicant_id"));
						resultSet1 = pstmt1.executeQuery();
						if (resultSet1.next()) {
							
							userDetails.setFirstName(resultSet1.getString("firstName"));
							userDetails.setLastName(resultSet1.getString("lastName"));
							userDetails.setEmail(resultSet1.getString("email"));
							
						}
						
						responsevo.setType(resultSet.getString("applicant_id"));
					}

					responsevo.setRoleId(resultSet.getString("role_id"));
					responsevo.setResult("Success");
					responsevo.setMessage("Successfully Logged In");

				} else {

					responsevo.setResult("Failure");
					responsevo.setMessage("User not yet registered");

				}
			} else {
				responsevo.setResult("Failure");
				responsevo.setMessage("Invalid Credentials");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {

			pstmt.close();
			resultSet.close();
			con.close();

		}
		responsevo.setUserDetails(userDetails);
		return responsevo;
	}

	public ResponseVO forgotpassword(LoginVO loginvo) throws SQLException, MessagingException {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		String roleId = "";
		String applicant="";
		String recruiter="";
		String userId;
		ResponseVO responsevo = new ResponseVO();
		try {
			con = getConnection();
			// fetching the login credentials of particular user id from database

			pstmt1 = con.prepareStatement("Select DISTINCT role_id,applicant_id,recu_id from mdc_user where user_id=?");
			pstmt1.setString(1, loginvo.getUsername());
			resultSet1 = pstmt1.executeQuery();

			if (resultSet1.next()) {
				roleId = Integer.toString(resultSet1.getInt("role_id"));
				applicant =Integer.toString(resultSet1.getInt("applicant_id"));
				recruiter =Integer.toString(resultSet1.getInt("recu_id"));
			}

			if (roleId.equalsIgnoreCase("2")) {

				pstmt = con.prepareStatement(
						"select tmu.user_id,tmu.user_nm,tmu.user_password,tmu.role_id from mdc_user tmu, applicant ta where tmu.user_id=? and tmu.role_id=? and tmu.applicant_id=? and ta.email=tmu.user_id and ta.srNo=tmu.applicant_id");
				pstmt.setString(1, loginvo.getUsername());
				pstmt.setString(2, roleId);
				pstmt.setString(3, applicant);
				resultSet = pstmt.executeQuery();

				if (resultSet.next()) {

					userId = resultSet.getString("user_id");
					EmailService emailService = new EmailService();
					emailService.sendMail(resultSet.getString("user_id"),
							Encryptor.decrypt(ExtraConstants.key1, ExtraConstants.key2,
									resultSet.getString("user_password")),
							
							"Hi " + resultSet.getString("user_nm") + " this is you login password  ");
					responsevo.setResult("email sent successfully");

				}

			} else if (roleId.equalsIgnoreCase("1")) {

				pstmt = con.prepareStatement(
						"select DISTINCT tmu.user_id,tmu.user_nm,tmu.user_password,tmu.role_id from mdc_user tmu, recruiter tr where tmu.user_id=? and tmu.role_id=? and tmu.recu_id=? and tr.email=tmu.user_id and tr.srNo=tmu.recu_id");
				pstmt.setString(1, loginvo.getUsername());
				pstmt.setString(2, roleId);
				pstmt.setString(3, recruiter);
				resultSet = pstmt.executeQuery();

				if (resultSet.next()) {

					userId = resultSet.getString("user_id");
					EmailService emailService = new EmailService();
					emailService.sendMail(resultSet.getString("user_id"),
							Encryptor.decrypt(ExtraConstants.key1, ExtraConstants.key2,
									resultSet.getString("user_password")),
							"Hi " + resultSet.getString("user_nm") + " this is you login password  ");
					responsevo.setResult("email sent successfully");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			resultSet.close();
			con.close();
		}
		return responsevo;

	}

	public boolean checkuserid(LoginVO loginvo) throws SQLException {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = getConnection();

			pstmt = con.prepareStatement("select DISTINCT user_id from mdc_user where user_id=?");
			pstmt.setString(1, loginvo.getUsername());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			con.close();
		}

		return result;
	}

	public boolean checkcustomerid(int customerID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean result = false;

		try {
			con = getConnection();
			// System.out.println("In=======>"+customerID);

			pstmt = con.prepareStatement("select user_id from mdc_user where cust_id=?");
			pstmt.setInt(1, customerID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// System.out.println("=======>"+customerID);

				result = true;
			}

			System.out.println("=======>" + result);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt.close();
			rs.close();
			con.close();
		}

		System.out.println("Boolen==>" + result);

		return result;
	}

	public String adduser(RegistrationRequestVO registrationvo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		String result = "Failure";
		int recuriterid = 0;
		int applicantid = 0;

		int srno = 0;

		try {

			con = getConnection();


			registrationvo.setPassword(
					Encryptor.encrypt(ExtraConstants.key1, ExtraConstants.key2, registrationvo.getPassword()));

			if (registrationvo.getType().equalsIgnoreCase("1")) {

				pstmt = con.prepareStatement(
						"INSERT INTO recruiter(firstName,lastName,email,lastDate) VALUES(?,?,?,SYSDATETIME())");
				pstmt.setString(1, registrationvo.getFirstName());
				pstmt.setString(2, registrationvo.getLastName());
				pstmt.setString(3, registrationvo.getEmail());

				if (pstmt.executeUpdate() > 0) {
					result = "Success";
				}

				ps1 = con.prepareStatement("select srNo,firstName,lastName,lastDate FROM recruiter order by lastDate desc");

				rs1 = ps1.executeQuery();
				if (rs1.next()) {
					applicantid=0;
					recuriterid = rs1.getInt("srNo");
				}

			} else if (registrationvo.getType().equalsIgnoreCase("2")) {
				pstmt = con.prepareStatement(
						"INSERT INTO applicant([firstName],[lastName],[email],[lastaDate]) VALUES(?,?,?,SYSDATETIME())");
				pstmt.setString(1, registrationvo.getFirstName());
				pstmt.setString(2, registrationvo.getLastName());
				pstmt.setString(3, registrationvo.getEmail());

				if (pstmt.executeUpdate() > 0) {
					result = "Success";
				}

				ps1 = con.prepareStatement("select srNo,firstName,lastName,lastaDate FROM [applicant] order by lastaDate desc");

				rs1 = ps1.executeQuery();
				if (rs1.next()) {
					recuriterid=0;
					applicantid = rs1.getInt("srNo");
				}

			}

			System.out.println("password==>"+registrationvo.getPassword());
			
			pstmt1 = con.prepareStatement(
					"insert into mdc_user(user_id,user_nm,user_password,role_id,active_flg,applicant_id,recu_id) values(?,?,?,?,1,?,?)");
			pstmt1.setString(1, registrationvo.getEmail());
			pstmt1.setString(2, registrationvo.getEmail());
			pstmt1.setString(3, registrationvo.getPassword());
			pstmt1.setString(4, registrationvo.getType());
			pstmt1.setInt(5, applicantid);
			pstmt1.setInt(6, recuriterid);

			if (pstmt1.executeUpdate() > 0) {
				System.out.println("Second statement Srno==>" + srno);
				result = "Success";

				/*final String senderEmail = "alert@hanbitsolutions.com";// change
				// accordingly
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");

				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmail, "hanbit@123");// change
						// accordingly
					}
				});

				// try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(senderEmail));// change
				// accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(registrationvo.getEmail()));
				message.setSubject("Password for " + uservo.getMobileNo());
				message.setText("Password for UserName:" + registrationvo.getEmail() + " is : " + password);

				Transport.send(message);*/
				// responsevo.setResult("Success");
				// responsevo.setMessage("Your Password Has Been Sent To your Registered
				// Email");

				// }
				// }

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			pstmt1.close();
			con.close();
		}

		return result;
	}
}
