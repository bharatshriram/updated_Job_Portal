package com.hanbit.Job_Portal.constants;

public class SQLConstants {

	public static final String getallProfileName = "Select [srno], profile from Profile";
	public static final String fetchdetails = "select DISTINCT tr.srNo,tr.mobile,tr.firstName,tr.lastName,tr.email,tr.location,tr.jobProfile,tr.job_Desc,tr.jobDate,tr.lastDate from recruiter tr where tr.jobProfile=?";
	public static final String fetchApplieddetails = "select DISTINCT ta.srNo,ta.firstName,ta.lastName,ta.email,ta.mobile,ta.gender,ta.currentLocation,ta.profileSummary,ta.keySkill,ta.designation,ta.lastaDate from applyJob taj, recruiter tr,applicant ta where taj.jobProfile=tr.jobProfile and taj.recruiter_id = tr.srNo and taj.applicant_id = ta.srNo and tr.srNo=? and tr.jobProfile=?";
	public static final String jobPortalbySrno = "select DISTINCT jobProfile from recruiter where srNo=?";
	public static String getallStateName="Select SrNo, State from State";
	public static String getallDistrictName="select DISTINCT ld.SrNo, ld.Name from ListOfDistrict ld where StateId=? order by ld.Name ASC";
	
}
