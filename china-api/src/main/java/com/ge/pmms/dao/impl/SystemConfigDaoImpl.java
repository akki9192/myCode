package com.ge.pmms.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.SystemConfigDao;
import com.ge.pmms.entity.RoleSubModule;
import com.ge.pmms.entity.SystemConfig;
import com.ge.pmms.entity.SystemParam;
import com.ge.pmms.entity.User;
import com.ge.pmms.service.impl.SystemConfigServiceImpl;

/**
 * User Data Access Object Implementation.
 *
 * @author
 */

@Repository

public class SystemConfigDaoImpl extends BasicDao implements SystemConfigDao {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(SystemConfigServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemConfig> getSystemconfiguration() {
		return super.getSession().createCriteria(SystemConfig.class).list();
			
	}

	
	
	
	@Override
	public void addSystemconfiguration(String jsonString) {
	
		SystemParam param=new SystemParam();
		String result =jsonString.replace("\\","").replace(",null", "");
		JSONArray jsonArr= new JSONArray(result);
		
		int length= jsonArr.length();
		for (int i=0;i<length;i++)
		{
			JSONObject sysParam= (JSONObject) jsonArr.get(i);
			String itemName = ((String) sysParam.get("name")).trim();
			String itemDesc= Constants.ITEM_DESC;
			JSONArray ssoArr=  (JSONArray) sysParam.get("sso");
			super.getSession().createSQLQuery("delete from pmms.sys_param where itemName=:data").addEntity(SystemParam.class).setParameter("data", itemName).executeUpdate();
			for(int j=0;j<ssoArr.length();j++)
			{
				String sso=(String) ssoArr.get(j);
				//SystemParam param=new SystemParam();
				param.setItemDesc(itemDesc);
				param.setItemName(itemName);
				param.setItemValue(sso);
				super.getSession().saveOrUpdate(param);
				
			}
			ssoArr = new JSONArray();
			
		}
		
		/*String itemName=data.getItemName();
		String itemValue=data.getItemValue();
		String itemDesc=data.getItemDesc();
		String maintainanceArr=data.getMaintainanceArr();
		
		String maintainancearr[]=maintainanceArr.split(",");
		int countter=0;
		super.getSession().createSQLQuery("delete from pmms.sys_param where itemName=:data").addEntity(SystemParam.class).setParameter("data", itemName).executeUpdate();
		for(String sso: maintainancearr){
				
			countter++;
			SystemParam param=new SystemParam();
			param.setItemDesc(itemDesc);
			param.setItemName(itemName);
			param.setItemValue(sso);
			super.getSession().saveOrUpdate(param);
			System.out.println("countter------------> " +countter);
		}*/
		 //super.getSession().saveOrUpdate(data);
		
		

	}




	@SuppressWarnings("unchecked")
	@Override
	public List<SystemParam> getSystemconfigurationSelected(String type) {
		
		//return super.getSession().createQuery("from SystemParam where itemName = :code").setParameter("code", type).list();
		//return super.getSession().createCriteria(SystemParam.class).add(Restrictions.and(Restrictions.eq("itemName", type))).list();
		String query="select * from pmms.sys_param where itemName=:data";
		return super.getSession().createSQLQuery(query).addEntity(SystemParam.class).setParameter("data", type).list();
		
		
		
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getMobileNumber(String strSysParamType)
	{
		HashMap ssoMobileMapping = new HashMap();
		String hql = "SELECT pmms.users.sso,  pmms.users.contactno FROM pmms.users INNER JOIN pmms.sys_param ON pmms.users.sso = pmms.sys_param.itemValue WHERE pmms.sys_param.itemName= '" + strSysParamType + "'";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<Object[]> listResultMobile = query.list();
		for(Object[] row : listResultMobile) {
			ssoMobileMapping.put(row[0].toString(), row[1].toString());
		}
		
		return  ssoMobileMapping;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> editSystem(String[] system) {
		int sso=Integer.parseInt(system[0]);
		Criteria cr = super.getSession().createCriteria(User.class, "user").add(Restrictions.eq("user.sso", sso));
		List<User> l= cr.list();
		return   l; 
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map getEmailReceipt(String strSysParamType)
	{
		HashMap emailMapping = new HashMap();
		String hql = "SELECT pmms.users.sso,  pmms.users.contactno , pmms.users.emailid FROM pmms.users INNER JOIN pmms.sys_param ON pmms.users.sso = pmms.sys_param.itemValue WHERE pmms.sys_param.itemName= '" + strSysParamType + "'";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<Object[]> listResultEmail = query.list();
		for(Object[] row : listResultEmail) {
			emailMapping.put(row[0].toString(), row[1].toString());
		}
		
		return  emailMapping;
		
	}
}
