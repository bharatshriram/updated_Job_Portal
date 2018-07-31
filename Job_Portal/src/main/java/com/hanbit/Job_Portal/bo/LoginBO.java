/**
 * 
 */
package com.hanbit.Job_Portal.bo;

import java.sql.SQLException;

import javax.mail.MessagingException;

import com.hanbit.Job_Portal.dao.LoginDAO;
import com.hanbit.Job_Portal.exceptions.BusinessException;
import com.hanbit.Job_Portal.request.vo.LoginVO;
import com.hanbit.Job_Portal.response.vo.ResponseVO;


/**
 * @author K VimaL Kumar
 * 
 */
public class LoginBO {

	public ResponseVO validateUser(LoginVO loginvo)
			throws ClassNotFoundException, BusinessException, SQLException {
		// TODO Auto-generated method stub

		ResponseVO responsevo = new ResponseVO();

		LoginDAO logindao = new LoginDAO();

		if (loginvo.getUsername().isEmpty() || loginvo.getPassword().isEmpty()) {

			throw new BusinessException("ENTER USERNAME AND PASSWORD");
		}

		responsevo = logindao.validateUser(loginvo);

		return responsevo;
	}

	public ResponseVO forgotpassword(LoginVO loginvo)
			throws ClassNotFoundException, BusinessException, SQLException, MessagingException {
		// TODO Auto-generated method stub

		ResponseVO responsevo = new ResponseVO();

		LoginDAO logindao = new LoginDAO();

		if (loginvo.getUsername().isEmpty()) {

			throw new BusinessException("ENTER USER ID");
		}
		
		boolean checkuserid = logindao.checkuserid(loginvo);
		
		if(!checkuserid){
			throw new BusinessException("User has not yet Registered");
		}

		responsevo = logindao.forgotpassword(loginvo);

		return responsevo;
	}

}
