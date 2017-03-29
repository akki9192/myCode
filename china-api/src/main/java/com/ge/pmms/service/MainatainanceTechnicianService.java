package com.ge.pmms.service;

import java.util.List;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;

public interface MainatainanceTechnicianService {

	List<Maintainancecheck> searchListtWithDates(String data);

	List<Maintainancecheck> getMaintainanceCheck();

	List<Maintainancecheck> searchHistoryListtWithDates(String data);

	List<Maintainancecheck> getMaintainanceCheckHistory(String status);

	List<MaintainanceCheckDtls> getMaintainanceTechCheckDtls(String maintId);

	void updateStatus(Maintainancecheck maintainancecheck);

}
