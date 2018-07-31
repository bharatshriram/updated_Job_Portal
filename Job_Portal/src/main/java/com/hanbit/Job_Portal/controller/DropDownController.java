package com.hanbit.Job_Portal.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hanbit.Job_Portal.dao.DropDownDAO;
import com.hanbit.Job_Portal.response.vo.ResponseVO;

/**
 * @author Bharat Kumar
 *
 */

@Controller
public class DropDownController {

	Gson gson = new Gson();


	@RequestMapping(value = "/AllStateList", method = RequestMethod.GET, produces = "application/json")

	public @ResponseBody String allStateList() throws SQLException {

		Map<String, String> getStateNameList = new LinkedHashMap<String, String>();
		DropDownDAO dropdown = new DropDownDAO();
		ResponseVO responsevo = new ResponseVO();

		getStateNameList = dropdown.getallStateNameList();

		responsevo.setDropDownallStateNameList(getStateNameList);

		String StateName = gson.toJson(responsevo);

		return StateName;
	}

	@RequestMapping(value = "/DistrictList/{state}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getalldistrictlist(@PathVariable("state") String state) throws SQLException {

		DropDownDAO dropdowndao = new DropDownDAO();
		Map<String, String> getDistrictNameList = new LinkedHashMap<String, String>();
		ResponseVO responsevo = new ResponseVO();

		getDistrictNameList = dropdowndao.getAllDistrictList(state);
		responsevo.setDropDownallDistrictNameList(getDistrictNameList);

		String DistrictList = gson.toJson(responsevo);

		return DistrictList;
	}
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getallprofilelist() throws SQLException {

		DropDownDAO dropdowndao = new DropDownDAO();
		Map<String, String> getProfileNameList = new LinkedHashMap<String, String>();
		ResponseVO responsevo = new ResponseVO();

		getProfileNameList = dropdowndao.getAllprofileList();
		responsevo.setDropDownallProfileNameList(getProfileNameList);

		String ProfileList = gson.toJson(responsevo);

		return ProfileList;
	}

}
