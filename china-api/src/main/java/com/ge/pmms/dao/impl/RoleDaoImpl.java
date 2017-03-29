package com.ge.pmms.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.RoleDao;
import com.ge.pmms.entity.ModuleSubmoduleMaster;
import com.ge.pmms.entity.Role;
import com.ge.pmms.entity.RoleDto;
import com.ge.pmms.entity.RoleSubModule;

/**
 * User Data Access Object Implementation.
 *
 * @author
 */
@Repository

public class RoleDaoImpl extends BasicDao implements RoleDao {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(RoleDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoleInfo() {
		return super.getSession().createCriteria(Role.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleDto> getRoleModuleAccess(int roleId) {
		List<RoleDto> list = new ArrayList<RoleDto>();
		List<RoleDto> roleAccessDtls = super.getSession().createCriteria(RoleDto.class).list();
		for (RoleDto dto : roleAccessDtls) {
			if (roleId == dto.getRoleId()) {
				list.add(dto);
			}
		}
		return list;
	}

	@Override
	public void addRole(String jsonString) {
		
		Role role = new Role();
		JSONArray jsonArr= new JSONArray(jsonString);
		
		int length= jsonArr.length();
		JSONArray  roleArr= (JSONArray) jsonArr.get(length-1);
		String roleName= roleArr.getJSONObject(0).getString("roleName");
		String roleDesc= roleArr.getJSONObject(0).getString("roleDesc");
		
		JSONArray  newArr = (JSONArray) jsonArr.remove(length-1);
		role.setRoleName(roleName);
		role.setRoleDescription(roleDesc);
		super.getSession().saveOrUpdate(role);
		for (int i = 0; i < jsonArr.length(); i++) {
			
			ArrayList operationList= new ArrayList();
		    JSONObject row = jsonArr.getJSONObject(i);
		    JSONObject operationValue = (JSONObject) jsonArr.getJSONObject(i).get("sub_values");
		    boolean add= (boolean) operationValue.get("add");
		    boolean edit =(boolean) operationValue.get("edit");
		    boolean delete=(boolean) operationValue.get("del");
		    if(add){
		    	operationList.add("A");
		    	}
		    if(edit){
		    	operationList.add("E");
		    	}
		    if(delete){
		    	operationList.add("D");
		    	}
		  
		    for(int j=0;j<operationList.size();j++){
		    	RoleSubModule roleSubModlue = new RoleSubModule();
		    	Criteria cr = super.getSession().createCriteria(Role.class, "role");
		    	Role roleObj = (Role) cr.add(Restrictions.eq("role.roleName", roleName)).uniqueResult();
		    	 int moduleId =  Integer.parseInt(row.getString("parentId"));
				 int subModuleId = Integer.parseInt(row.getString("submoduleId"));
				 roleSubModlue.setModuleId(moduleId);
				 roleSubModlue.setSubModuleId(subModuleId);
				 roleSubModlue.setRoleId(roleObj.getId());
				 roleSubModlue.setCreatedBy("55");
				 roleSubModlue.setOperation((String) operationList.get(j));
				 roleSubModlue.setCreatedDt(new Date());
				 roleSubModlue.setLastUpdatedBy("55");
				 roleSubModlue.setLastUpdatedDt(new Date());
				 super.getSession().saveOrUpdate(roleSubModlue);
		    }
		    
		}
		
		//super.getSession().saveOrUpdate(role);
	}

	@Override
	public List<Integer> removeRole(List<Integer> ids) {
		Session session = this.getSession();

		for (int id : ids) {
			Role role = (Role) session.load(Role.class, new Integer(id));

			if (null != role) {
				session.delete(role);
			}
		}
		return ids;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModuleSubmoduleMaster> getModuleSubModuleMapping() {
		// TODO Auto-generated method stub
		return super.getSession().createCriteria(ModuleSubmoduleMaster.class).list();
	}

	@Override
	public List<RoleSubModule> editRole(String[] roleDtls) {
		// TODO Auto-generated method stub
		
		int roleId=Integer.parseInt(roleDtls[0]);
		Criteria cr = super.getSession().createCriteria(RoleSubModule.class, "roleSubModule").add(Restrictions.eq("roleSubModule.roleId", roleId));
		List<RoleSubModule> l= cr.list();
		return   l; 
		
		
		
	}

	@Override
	public void saveEditRole(String jsonString) {
		// TODO Auto-generated method stub
		Role role = new Role();
		
		JSONArray jsonArr= new JSONArray(jsonString);
		
		int length= jsonArr.length();
		JSONArray  roleArr= (JSONArray) jsonArr.get(length-1);
		int roleId = (int) roleArr.getJSONObject(0).get("roleId");
		String roleName= roleArr.getJSONObject(0).getString("roleName");
		String roleDesc= roleArr.getJSONObject(0).getString("roleDesc");
		
		JSONArray  newArr = (JSONArray) jsonArr.remove(length-1);
		for (int i = 0; i < jsonArr.length(); i++) {
			
			ArrayList operationList= new ArrayList();
		    JSONObject row = jsonArr.getJSONObject(i);
		    JSONObject operationValue = (JSONObject) jsonArr.getJSONObject(i).get("sub_values");
		    boolean add= (boolean) operationValue.get("add");
		    boolean edit =(boolean) operationValue.get("edit");
		    boolean delete=(boolean) operationValue.get("del");
		    if(add){
		    	operationList.add("A");
		    	}
		    if(edit){
		    	operationList.add("E");
		    	}
		    if(delete){
		    	operationList.add("D");
		    	}
		  
		    for(int j=0;j<operationList.size();j++){
		    	RoleSubModule roleSubModlue = new RoleSubModule();
		    	Criteria cr = super.getSession().createCriteria(RoleSubModule.class, "roleSubModlue");
		    	cr.add(Restrictions.eq("roleSubModlue.roleId", roleId));
		    	cr.setProjection(Projections.property("id"));
		    	List<Number> result=cr.list();
		    	 int moduleId =  Integer.parseInt(row.getString("parentId"));
				 String subMod= row.getString("submoduleId").substring(2,row.getString("submoduleId").length());
		    	 int subModuleId = Integer.parseInt(subMod);
				 roleSubModlue.setModuleId(moduleId);
				 roleSubModlue.setSubModuleId(subModuleId);
				 roleSubModlue.setRoleId(roleId);
				 roleSubModlue.setCreatedBy("55");
				 roleSubModlue.setOperation((String) operationList.get(j));
				 roleSubModlue.setCreatedDt(new Date());
				 roleSubModlue.setLastUpdatedBy("55");
				 roleSubModlue.setLastUpdatedDt(new Date());
				 super.getSession().saveOrUpdate(roleSubModlue);
		    	
	}

		}
		
	}
}
