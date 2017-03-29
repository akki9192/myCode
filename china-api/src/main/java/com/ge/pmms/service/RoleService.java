package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.ModuleSubmoduleMaster;
import com.ge.pmms.entity.Role;
import com.ge.pmms.entity.RoleDto;
import com.ge.pmms.entity.RoleSubModule;




/**
 * UserService interface.
 *
 * @author Ayushi Jain
 */
public interface RoleService {

	List<Role> getRoleInfo();
	
	List<RoleDto> getRoleModuleAccess(int roleId);
	
	List<Integer> removeRole(List<Integer> ids);

	List<ModuleSubmoduleMaster> getModuleSubModuleMapping();

	void addRole(String jsonString);

	List<RoleSubModule> editRole(String[] roledto);

	void saveEditRole(String jsonString);
	

}
