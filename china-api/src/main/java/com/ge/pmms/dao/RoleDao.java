package com.ge.pmms.dao;


import java.util.List;

import com.ge.pmms.entity.ModuleSubmoduleMaster;
import com.ge.pmms.entity.Role;
import com.ge.pmms.entity.RoleDto;
import com.ge.pmms.entity.RoleSubModule;

/**
 * User Data Access Object Interface.
 *
 * @author Zoya Khan
 *
 */
public interface RoleDao {

	public void addRole(String jsonString);

	List<Role> getRoleInfo();
	
	List<RoleDto> getRoleModuleAccess(int roleId);

	List<Integer> removeRole(List<Integer> ids);

	public List<ModuleSubmoduleMaster> getModuleSubModuleMapping();

	public List<RoleSubModule> editRole(String[] roleDtls);

	public void saveEditRole(String jsonString);
	


}
