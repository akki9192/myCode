package com.ge.pmms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.ModuleSubmoduleMaster;
import com.ge.pmms.entity.Role;
import com.ge.pmms.entity.RoleDto;
import com.ge.pmms.entity.RoleSubModule;
import com.ge.pmms.service.RoleService;

/**
 * Controller for start page.
 *
 * @author Zoya Khan
 */

@Controller
@CrossOrigin
public class RoleController {

	@Autowired
	private RoleService roleService;

	/* Displaying the exsiting roles */
	@RequestMapping(value = "/getRoleInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> getRoleInfo() {
		return roleService.getRoleInfo();
	}

	
	/* Add a particular ROle */
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	@ResponseBody
	public Response saveRole(@RequestBody String jsonString) {
		roleService.addRole(jsonString);
		return Response.successResponse();
	}

	@RequestMapping(value = "/getRoleModuleAccess", method = RequestMethod.GET)
	@ResponseBody
	public List<RoleDto> getRoleModuleAccess(int roleId) {
		return roleService.getRoleModuleAccess(roleId);
	}

	/* Delete ROle */
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public List<Integer> removeRole(@RequestBody List<Integer> ids) {
		return roleService.removeRole(ids);
	}

	@RequestMapping(value = "/getModuleSubModuleMapping", method = RequestMethod.GET)
	@ResponseBody
	public List<ModuleSubmoduleMaster> getModuleSubModuleMapping() {
		return roleService.getModuleSubModuleMapping();
	}
	
	
	@RequestMapping(value = "/editRole",method = RequestMethod.POST)
	@ResponseBody
	public List<RoleSubModule> editRole(@RequestBody String[] roledto) {
		return roleService.editRole(roledto);
		 
	}
	
	@RequestMapping(value = "/saveEditRole", method = RequestMethod.POST)
	@ResponseBody
	public Response saveEditRole(@RequestBody String jsonString) {
		roleService.saveEditRole(jsonString);
		return Response.successResponse();
	}
}