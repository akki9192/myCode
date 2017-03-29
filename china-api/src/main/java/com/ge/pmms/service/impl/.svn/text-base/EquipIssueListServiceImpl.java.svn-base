package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.EquipIssueListDao;
import com.ge.pmms.entity.EquipIssueList;
import com.ge.pmms.service.EquipIssueListService;

/**
*
* @author Priyanka Gupta
*/


@Service("equipIssueListService")
@Transactional
public class EquipIssueListServiceImpl implements EquipIssueListService,Serializable{
	
	 private static final long serialVersionUID = 8660080660984105245L;

	    private static final Logger log = LoggerFactory
	            .getLogger(UserServiceImpl.class);
	
	@Autowired
    private EquipIssueListDao equipIssueListDao;
	
	@Override
	public void addEquipIssueList(EquipIssueList equipIssueList) {
		equipIssueListDao.addEquipIssueList(equipIssueList);

	}
	
	@Override
	public String isEquipDataValid(String woId, String equipId, String requestorSSO){
		return equipIssueListDao.isEquipDataValid(woId,equipId,requestorSSO);
	}
	
	@Override
	public String startEquipIssueList(EquipIssueList equipIssueList){
		return equipIssueListDao.startEquipIssueList(equipIssueList);
	}
	
	@Override
	public String closeEquipIssueList(EquipIssueList equipIssueList){
		return equipIssueListDao.closeEquipIssueList(equipIssueList);
	}
	
	@Override
	public List<EquipIssueList> getEquipmentIssueList(String deptId, String equipType){
		return equipIssueListDao.getEquipmentIssueList(deptId,equipType);
	}
	
	@Override
	public List<EquipIssueList> getClosedEquipmentIssueList(){
		return equipIssueListDao.getClosedEquipmentIssueList();
	}
	
	@Override
	public List<EquipIssueList> searchEquipmentIssuesWithDates(String data){
		return equipIssueListDao.searchEquipmentIssuesWithDates(data);
	}
	@Override
	public List<EquipIssueList> getEquipmentIssues(){
		return equipIssueListDao.getEquipmentIssues();
	}

	@Override
	public List<EquipIssueList> getEquipmentIssuesHistory(){
		return equipIssueListDao.getEquipmentIssuesHistory();
	}

	@Override
	public List<EquipIssueList> updateEquipmentDtls(String idsSelected) {
		// TODO Auto-generated method stub
		return equipIssueListDao.updateEquipmentDtls(idsSelected);
	}

	@Override
	public List<EquipIssueList> closeEquipmentDtls(String idsSelected) {
		return equipIssueListDao.closeEquipmentDtls(idsSelected);
	}
	
	
}
