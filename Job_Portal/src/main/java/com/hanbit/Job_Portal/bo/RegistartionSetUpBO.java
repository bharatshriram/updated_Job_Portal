/**
 * 
 */
package com.hanbit.Job_Portal.bo;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hanbit.Job_Portal.dao.LoginDAO;
import com.hanbit.Job_Portal.dao.RegistartionSetUpDAO;
import com.hanbit.Job_Portal.exceptions.BusinessException;
import com.hanbit.Job_Portal.request.vo.ApplicantRequestVO;
import com.hanbit.Job_Portal.request.vo.RecruiterRequestVO;
import com.hanbit.Job_Portal.request.vo.RegistrationRequestVO;


/**
 * @author Bharat Kumar
 * 
 */
public class RegistartionSetUpBO {
	
	
	public String addregistration(RegistrationRequestVO registrationvo) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		String result = "";
		String result1="";

		RegistartionSetUpDAO registrationsetupdao = new RegistartionSetUpDAO();
		LoginDAO logindao = new LoginDAO();
		
		if(registrationvo.getType().equalsIgnoreCase("1")) {
		
			boolean checkuserid = registrationsetupdao.checkifregisterEmailExist(registrationvo);

			if(checkuserid){
				
				throw new BusinessException("EMAIL ALREADY EXIST PLEASE CHOOOSE ANOTHER EMAIL");
			}
			
			
		}else if(registrationvo.getType().equalsIgnoreCase("2")) {
			boolean checkuserid = registrationsetupdao.checkifregisterApplicantEmailExist(registrationvo);

			if(checkuserid){
				
				throw new BusinessException("EMAIL ALREADY EXIST PLEASE CHOOOSE ANOTHER EMAIL");
			}
		}
		
		
		
		/*
		registrationvo.setPresentPassword(
				Encryptor.randomAlphanumeric(ExtraConstants.CHAR_LIST, ExtraConstants.RANDOM_STRING_LENGTH));*/
		
		System.out.println("Password===>"+registrationvo.getPassword());
		
		result = logindao.adduser(registrationvo);

		return result;
	}



	private boolean checkEmailID(String emailId) {
		// TODO Auto-generated method stub

		boolean result = false;

		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@ [A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(emailId);

		if (!matcher.find()) {
			result = true;
		}

		return result;

	}

	public String addrecruiter(RecruiterRequestVO recruitervo) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		
		RegistartionSetUpDAO recruitersetupdao = new RegistartionSetUpDAO();
		
		boolean flag = false;

		flag = recruitersetupdao.checkifEmailExist(recruitervo);

		if (flag) {
			throw new BusinessException(
					"Email ID Already Exist");
		}

		return recruitersetupdao.addrecruiter(recruitervo);
	}

	public String editrecruiter(RecruiterRequestVO recruitervo)throws BusinessException, SQLException {
		// TODO Auto-generated method stub

		RegistartionSetUpDAO recruitersetupdao = new RegistartionSetUpDAO();
		

		return recruitersetupdao.editrecruiter(recruitervo);
	}

	public String addapplicantvo(ApplicantRequestVO applicantvo) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		RegistartionSetUpDAO applicantsetupdao = new RegistartionSetUpDAO();
		
		boolean flag = false;

		flag = applicantsetupdao.checkifApplicantEmailExist(applicantvo);

		if (flag) {
			throw new BusinessException(
					"Email ID Already Exist");
		}

		return applicantsetupdao.addapplicant(applicantvo);
	}



	public String addapplyjob(int applicantsrNo, int jobSrNo, String JobProfile) throws SQLException, BusinessException {
		// TODO Auto-generated method stub
		
		RegistartionSetUpDAO recruitersetupdao = new RegistartionSetUpDAO();
		
		boolean flag = false;

		/*flag = recruitersetupdao.checkifEmailExist(recruitervo);

		if (flag) {
			throw new BusinessException(
					"Email ID Already Exist");
		}*/

		return recruitersetupdao.addapply(applicantsrNo,jobSrNo,JobProfile);
	}



	public String editapplicant(ApplicantRequestVO applicantvo) throws SQLException, BusinessException {
		// TODO Auto-generated method stub
		RegistartionSetUpDAO recruitersetupdao = new RegistartionSetUpDAO();
		

		return recruitersetupdao.editapplicant(applicantvo);
	}

	

}
