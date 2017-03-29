package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.EquipIssueList;
import com.ge.pmms.entity.MeasuringToolTransInfo;

public interface MeasuringToolTransInfoService {

	List<MeasuringToolTransInfo> getMeasuringToolStockTransactions();

	void saveStockInTransaction(MeasuringToolTransInfo measuringToolTransInfo);

	List<MeasuringToolTransInfo> searchStockTransactionsWithDates(String data);

}
