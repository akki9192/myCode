package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.RoleDao;
import com.ge.pmms.entity.RoleDto;
import com.ge.pmms.entity.RoleSubModule;
import com.ge.pmms.entity.ModuleSubmoduleMaster;
import com.ge.pmms.entity.Role;
import com.ge.pmms.service.RoleService;

/**
 * Implementation for UserService and Spring UserDetailsService.
 *
 * @author Zoya Khan
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService, Serializable {

	private static final long serialVersionUID = 8660080660984105245L;

	private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> getRoleInfo() {

		return roleDao.getRoleInfo();
	}

	

	@Override
	public List<RoleDto> getRoleModuleAccess(int roleId) {
		return roleDao.getRoleModuleAccess(roleId);
	}

	@Override
	public List<Integer> removeRole(List<Integer> ids) {
		return roleDao.removeRole(ids);
	}

	@Override
	public List<ModuleSubmoduleMaster> getModuleSubModuleMapping() {
		// TODO Auto-generated method stub
		return roleDao.getModuleSubModuleMapping();
	}



	@Override
	public void addRole(String jsonString) {
		// TODO Auto-generated method stub
		roleDao.addRole(jsonString);
	}

	
	@Override
	public List<RoleSubModule> editRole(String[]  roleDtls) {
		
		return roleDao.editRole(roleDtls);
		
	}



	@Override
	public void saveEditRole(String jsonString) {
		// TODO Auto-generated method stub
		roleDao.saveEditRole(jsonString);
	}

	
}