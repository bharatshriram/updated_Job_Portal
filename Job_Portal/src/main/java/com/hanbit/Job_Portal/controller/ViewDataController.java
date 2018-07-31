
package com.hanbit.Job_Portal.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hanbit.Job_Portal.bo.RegistartionSetUpBO;
import com.hanbit.Job_Portal.dao.RegistartionSetUpDAO;
import com.hanbit.Job_Portal.dao.ViewDAO;
import com.hanbit.Job_Portal.exceptions.BusinessException;
import com.hanbit.Job_Portal.response.vo.ResponseVO;
import com.hanbit.Job_Portal.response.vo.fetchViewResponseVO;


/**
 * @author Bharat Kumar
 *
 */

@Controller
public class ViewDataController {
	
Gson gson = new Gson();
	
	@RequestMapping(value = "/fetchdetails/{srNo}/{Name}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	String fetchdetails(@PathVariable("srNo") int srNo ,@PathVariable("Name") String Name) throws SQLException {
		
		ViewDAO viewdao = new ViewDAO();
		
		System.out.println("==>"+Name);
		
		Name=Name.replace(" ","%20");
		
		System.out.println("After==>"+Name);
		
		List<fetchViewResponseVO> fetchviewdetailslist = new ArrayList<fetchViewResponseVO>();
		
		ResponseVO responsevo = new ResponseVO();
		
		fetchviewdetailslist = viewdao.getfetchViewdetails(srNo,Name); 
		
		responsevo.setFetchDetails(fetchviewdetailslist);
		
		responsevo.setSize(fetchviewdetailslist.size());

		String viewdetails = gson.toJson(responsevo);
		
		System.out.println("viewdetails==>"+viewdetails);

		return viewdetails;
		
	}
	
	@RequestMapping(value = "/applyjob/{applicantsrNo}/{JobSrNo}/{JobProfile}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	ResponseVO applydetails(@PathVariable("applicantsrNo") int applicantsrNo ,@PathVariable("JobSrNo") int JobSrNo,@PathVariable("JobProfile") String JobProfile) throws SQLException,BusinessException {
		
		RegistartionSetUpBO recruitersetupbo = new RegistartionSetUpBO();
		ResponseVO responsevo = new ResponseVO();

		try {
			
			JobProfile=JobProfile.replace(" ","%20");
			
			responsevo.setResult(recruitersetupbo.addapplyjob(applicantsrNo,JobSrNo,JobProfile));

		} catch (BusinessException e) {
			String message = e.getMessage();
			responsevo.setErrorMessage(message);
		}

		return responsevo;
		
	}
	
	@RequestMapping(value = "/applieddetails/{jobsrNo}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	String listAppliedjob(@PathVariable("jobsrNo") int jobsrNo) throws SQLException {
		
		ViewDAO viewdao = new ViewDAO();
		
		List<fetchViewResponseVO> fetchviewdetailslist = new ArrayList<fetchViewResponseVO>();
		
		ResponseVO responsevo = new ResponseVO();
		
		fetchviewdetailslist = viewdao.getApplieddetails(jobsrNo); 
		
		responsevo.setFetchDetails(fetchviewdetailslist);
		
		responsevo.setSize(fetchviewdetailslist.size());

		String viewdetails = gson.toJson(responsevo);

		return viewdetails;
		
	}
}
