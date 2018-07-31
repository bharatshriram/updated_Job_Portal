/**
 * 
 */
package com.hanbit.Job_Portal.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hanbit.Job_Portal.bo.RegistartionSetUpBO;
import com.hanbit.Job_Portal.dao.RegistartionSetUpDAO;
import com.hanbit.Job_Portal.exceptions.BusinessException;
import com.hanbit.Job_Portal.request.vo.ApplicantRequestVO;
import com.hanbit.Job_Portal.request.vo.RecruiterRequestVO;
import com.hanbit.Job_Portal.request.vo.RegistrationRequestVO;
import com.hanbit.Job_Portal.response.vo.ResponseVO;

/**
 * @author Bharat Kumar
 * 
 */
@Controller
public class RegistartionSetUpController {

	/* registration */
	Gson gson = new Gson();
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseVO registrationdetails(@RequestBody RegistrationRequestVO registrationvo) throws SQLException {

		RegistartionSetUpBO recruitersetupbo = new RegistartionSetUpBO();
		ResponseVO responsevo = new ResponseVO();

		try {
			responsevo.setResult(recruitersetupbo.addregistration(registrationvo));
			
			System.out.println("====>"+responsevo.getResult());

		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}

		return responsevo;
	}
	
	@RequestMapping(value = "/recruiterDetails/{typeId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseVO recruiterdetails(@PathVariable("typeId") int typeId) throws SQLException {

		RegistartionSetUpDAO registartionsetupdao = new RegistartionSetUpDAO();
		ResponseVO responsevo = new ResponseVO();

		System.out.println("Json ========>"+gson.toJson(registartionsetupdao.getRecruiterdetails(typeId)));
		
		responsevo.setRecruiterDetails(registartionsetupdao.getRecruiterdetails(typeId));

		responsevo.setSize(registartionsetupdao.getRecruiterdetails(typeId).size());
		
		return responsevo;
	}

	@RequestMapping(value = "/recruiter/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseVO addrecruiter(@RequestBody RecruiterRequestVO recruitervo)
			throws ClassNotFoundException, SQLException, BusinessException {

		RegistartionSetUpBO recruitersetupbo = new RegistartionSetUpBO();
		ResponseVO responsevo = new ResponseVO();

		try {
			responsevo.setResult(recruitersetupbo.addrecruiter(recruitervo));

		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}

		return responsevo;
	}

	@RequestMapping(value = "/recruiter/edit/{srno}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseVO editRecruiter(@PathVariable("srno") int srno,
			@RequestBody RecruiterRequestVO recruitervo)
			throws ClassNotFoundException, BusinessException, SQLException {

		RegistartionSetUpBO communitysetupbo = new RegistartionSetUpBO();
		ResponseVO responsevo = new ResponseVO();
		

		recruitervo.setSrNo(srno);

		try {
			responsevo.setResult(communitysetupbo.editrecruiter(recruitervo));
		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}

		return responsevo;
	}
	
	
	/*For Applicant*/
	
	@RequestMapping(value = "/applicant/add", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseVO addapplicant(@RequestBody ApplicantRequestVO applicantvo)
			throws ClassNotFoundException, SQLException, BusinessException {

		RegistartionSetUpBO applicantvosetupbo = new RegistartionSetUpBO();
		ResponseVO responsevo = new ResponseVO();

		try {
			responsevo.setResult(applicantvosetupbo.addapplicantvo(applicantvo));

		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}

		return responsevo;
	}
	
	
	@RequestMapping(value = "/applicantDetails/{typeId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseVO applicantdetails(@PathVariable("typeId") int typeId) throws SQLException {

		RegistartionSetUpDAO registartionsetupdao = new RegistartionSetUpDAO();
		ResponseVO responsevo = new ResponseVO();

		
		responsevo.setApplicantDetails(registartionsetupdao.getapplicantdetails(typeId));

		responsevo.setSize(registartionsetupdao.getapplicantdetails(typeId).size());
		
		return responsevo;
	}
	
	
	@RequestMapping(value = "/applicant/edit/{srno}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseVO editapplicant(@PathVariable("srno") int srno,
			@RequestBody ApplicantRequestVO applicantvo)
			throws ClassNotFoundException, BusinessException, SQLException {

		RegistartionSetUpBO communitysetupbo = new RegistartionSetUpBO();
		ResponseVO responsevo = new ResponseVO();
		

		applicantvo.setSrNo(srno);

		try {
			responsevo.setResult(communitysetupbo.editapplicant(applicantvo));
		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}

		return responsevo;
	}
	
	
}
