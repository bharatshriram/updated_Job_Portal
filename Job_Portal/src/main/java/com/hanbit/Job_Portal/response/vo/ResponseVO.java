/**
 * 
 */
package com.hanbit.Job_Portal.response.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * @author Bharat Kumar
 *
 */
public class ResponseVO {
	
	private Map<String, String> dropDownallStateNameList;
	private Map<String, String> dropDownallDistrictNameList;
	private Map<String, String> dropDownallProfileNameList;
	private List<RecruiterResponseVO> recruiterDetails;
	private List<RegistrationResponseVO> registrationDetails;
	private List<ApplicantResposeVO> applicantDetails;
	private List<fetchViewResponseVO> fetchDetails;
	private String result;
	private String errorMessage;
	private String message;
	private String billid;
	private String roleId;
	private String type;
	private int size;
	private UserDetails userDetails;
	
	
	
	
	
	
	
	public List<fetchViewResponseVO> getFetchDetails() {
		return fetchDetails;
	}
	public void setFetchDetails(List<fetchViewResponseVO> fetchDetails) {
		this.fetchDetails = fetchDetails;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public List<RegistrationResponseVO> getRegistrationDetails() {
		return registrationDetails;
	}
	public void setRegistrationDetails(List<RegistrationResponseVO> registrationDetails) {
		this.registrationDetails = registrationDetails;
	}
	public List<ApplicantResposeVO> getApplicantDetails() {
		return applicantDetails;
	}
	public void setApplicantDetails(List<ApplicantResposeVO> applicantDetails) {
		this.applicantDetails = applicantDetails;
	}
	public Map<String, String> getDropDownallProfileNameList() {
		return dropDownallProfileNameList;
	}
	public void setDropDownallProfileNameList(Map<String, String> dropDownallProfileNameList) {
		this.dropDownallProfileNameList = dropDownallProfileNameList;
	}
	public Map<String, String> getDropDownallStateNameList() {
		return dropDownallStateNameList;
	}
	public void setDropDownallStateNameList(Map<String, String> dropDownallStateNameList) {
		this.dropDownallStateNameList = dropDownallStateNameList;
	}
	public Map<String, String> getDropDownallDistrictNameList() {
		return dropDownallDistrictNameList;
	}
	public void setDropDownallDistrictNameList(Map<String, String> dropDownallDistrictNameList) {
		this.dropDownallDistrictNameList = dropDownallDistrictNameList;
	}
	public List<RecruiterResponseVO> getRecruiterDetails() {
		return recruiterDetails;
	}
	public void setRecruiterDetails(List<RecruiterResponseVO> recruiterDetails) {
		this.recruiterDetails = recruiterDetails;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
		
}
