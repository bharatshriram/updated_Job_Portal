/**
 * 
 */
package com.hanbit.Job_Portal.bo;

import java.sql.SQLException;

import com.hanbit.Job_Portal.dao.LoginDAO;
import com.hanbit.Job_Portal.dao.ManagementSettingsDAO;
import com.hanbit.Job_Portal.exceptions.BusinessException;
import com.hanbit.Job_Portal.request.vo.UserManagementRequestVO;


/**
 * @author Bharat Kumar
 * 
 */
public class ManagementSettingsBO {


	/* UserManagement */



	public String edituser(UserManagementRequestVO usermanagementvo) throws SQLException, BusinessException {
		// TODO Auto-generated method stub

		LoginDAO logindao = new LoginDAO();
		ManagementSettingsDAO managementsettingsdao = new ManagementSettingsDAO();

		if (usermanagementvo.getUserID().isEmpty()
				|| usermanagementvo.getUserPassword().isEmpty() || usermanagementvo.getConfirmPassword().isEmpty()
				|| usermanagementvo.getNewPassword().isEmpty()) {
			throw new BusinessException("ALL FIELDS ARE MANDATORY");
		}

		if (!usermanagementvo.getNewPassword().equals(usermanagementvo.getConfirmPassword())) {
			throw new BusinessException("NEW PASSWORD AND CONFIRM PASSWORD DOESNT MATCH");
		}
		
		

		String result = managementsettingsdao.edituser(usermanagementvo);

		return result;

	}

}
