package com.ge.pmms.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.json.JSONObject;
//import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ge.pmms.Tools;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.TopNEquipmentRptDao;
import com.ge.pmms.dto.ChartInfo;
@Repository
public class TopNEquipmentRptDaoImpl extends BasicDao implements TopNEquipmentRptDao{

	@SuppressWarnings("unchecked")
	public List<ChartInfo> limitquery(String data) {
		
		{
			JSONObject dateData = new JSONObject(data);
			String limit = dateData.getString("limit");
			String startdate = dateData.getString("FacilityFromDateFields");
			String endDate = dateData.getString("FacilityToDateFields");

			System.out.println("-----------------"+startdate+"---------"+endDate+"----------");

			String sql = "select to_char(created_date,'Mon')  as months,  equip_id, count(  equip_id) "
					+ " as equip_count from pmms.wo_info  where created_date	"
					+ "BETWEEN '" + startdate + "'and '" + endDate + "' and wo_type='EQ' "	
					+ "		group by  equip_id,months  "
					+ "Order by count(equip_id) desc limit "+limit ;
		
			System.out.println("************##****************##************"+sql);
			SQLQuery query = super.getSession().createSQLQuery(sql);
			
		
			@SuppressWarnings("unchecked")
			List<?> queryList = query.list();
			ChartInfo chartInfo;
			List<ChartInfo> list = new ArrayList<ChartInfo>();
			if(!CollectionUtils.isEmpty(queryList)){
				Iterator<?> ite = queryList.iterator();
				while(ite.hasNext()){
					Object[] obj = (Object[])ite.next();
					chartInfo=new ChartInfo();
					chartInfo.setMaintMonth(String.valueOf(obj[0]));
					chartInfo.setEquipId(String.valueOf(obj[1]));
					chartInfo.setCount(Tools.isNull(obj[2])?0.0:Double.parseDouble(String.valueOf(obj[2])));
					list.add(chartInfo);
				}
			}

//			for (Object[] aRow : queryList) {
//				System.out.println( aRow[0].toString()   +"----***********------queryList------0");
//				System.out.println( aRow[1].toString()+"----------queryList----1");
//				System.out.println( aRow[2].toString()+"----------queryList----2");
//
//			}
			
			return list;

		}
//		return null;
	}
	
}
