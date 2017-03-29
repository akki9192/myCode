package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.ChartInfo;

public interface TopNEquipmentRptService {
	public List<ChartInfo> limitquery(String data);

}
