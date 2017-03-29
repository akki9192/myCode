package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.TopNEquipmentRptDao;
import com.ge.pmms.dto.ChartDetailInfo;
import com.ge.pmms.dto.ChartInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.service.TopNEquipmentRptService;

@Service("equipNService")

@Transactional
public class TopNEquipmentRptServiceImpl implements TopNEquipmentRptService, Serializable {

	private static final long serialVersionUID = -7782629603409257484L;
	@Autowired
	private TopNEquipmentRptDao topNEquipmentRptDao;
	@Override
	public List<ChartInfo> limitquery(String data) {
		
		return topNEquipmentRptDao.limitquery(data);
	}

}
