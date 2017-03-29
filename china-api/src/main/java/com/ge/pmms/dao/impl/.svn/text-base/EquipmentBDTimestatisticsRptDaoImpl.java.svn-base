package com.ge.pmms.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.EquipmentBDTimestatisticsRptDao;
import com.ge.pmms.dto.EquipDashBoardRptBean;
import com.ge.pmms.dto.Series;

@Repository("equipmentBDTimestatisticsRptDao")
public class EquipmentBDTimestatisticsRptDaoImpl extends BasicDao implements EquipmentBDTimestatisticsRptDao {

	private static final Logger log = LoggerFactory.getLogger(EquipmentBDTimestatisticsRptDaoImpl.class);
	
	@Override
	public List getEquipmentBDTimestatisticsRpt(String startDate,String endtDate, String equipId) {		
		
		List downRatio = new ArrayList();
		Map<String,List<Map<String,String>>> map = new HashMap<String, List<Map<String,String>>>();
		Map<String,List<Map<String,String>>> mapresult = new HashMap<String, List<Map<String,String>>>();
		 List Result=new ArrayList();
		
		if("".equals(equipId))
		{	
			String hql="select EI.dept_id ,date_part('month',WI.Created_date),SUM(WI.duration_of_breakdown)from pmms.wo_info WI  inner join pmms.equip_info EI  on WI.equip_id=WI.equip_id "
					+ "where WI.created_date BETWEEN '" + startDate + "'and '" + endtDate
					+"'group by EI.dept_id,date_part('month',WI.Created_date) Order by EI.dept_Id,date_part('month',WI.Created_date)";
						
			SQLQuery query = super.getSession().createSQLQuery(hql);		
			List<Object[]> queryList = query.list();
			List l=new ArrayList();
			HashMap h = new HashMap();
			String temp="";				
			for (Object[] aRow : queryList) {		
				if(aRow[0]!=null)
				{
				if(!aRow[0].equals(temp))
	                {	
					h = new HashMap();
				    downRatio = new ArrayList();					
				    temp=(String) aRow[0];
					h.put(((Double) aRow[1]).intValue(), aRow[2]);						
					downRatio.add(h);
					map.put(temp, downRatio);
	                }
				else
				{
					h.put(((Double) aRow[1]).intValue(), aRow[2]);
					
				}
				
				}
				}	
			Result=getMonthlyWiseData(map);	
		
		}	
		
		else
		{			
			
			String hql = "select date_part('month',Created_date) ,AVG(duration_of_breakdown)"
					+ " from pmms.wo_info where created_date BETWEEN '" + startDate + "'and '" + endtDate
					+ "' and equip_id='" + equipId
					+ "' group by date_part('month',Created_date) Order by date_part('month',Created_date) ASC";	

		SQLQuery query = super.getSession().createSQLQuery(hql);
		
		List<Object[]> queryList = query.list();		
		
		HashMap h = new HashMap();		
		for (Object[] aRow : queryList) {	
			
			h.put(((Double) aRow[0]).intValue(), aRow[1]);					
		}
		downRatio.add(h);
		map.put("EquipNumber", downRatio);
		Result=getMonthlyWiseData(map);		
		}
		System.out.println(Result);
		return Result;
	}

	
	public List getEquipmentBDTimestatisticsTable(String startDate,String endtDate, String equipId) {
		List downRatio = new ArrayList();
		Map<String,List<Map<String,String>>> map = new HashMap<String, List<Map<String,String>>>();
		
		String hql="select EI.dept_id ,date_part('month',WI.Created_date),sum(WI.duration_of_breakdown)from pmms.wo_info WI  inner join pmms.equip_info EI  on WI.equip_id=WI.equip_id "
				+ "where WI.created_date BETWEEN '" + startDate + "'and '" + endtDate
				+"'group by EI.dept_id,date_part('month',WI.Created_date) Order by EI.dept_Id,date_part('month',WI.Created_date)";
					
		SQLQuery query = super.getSession().createSQLQuery(hql);		
		List<Object[]> queryList = query.list();
		List l=new ArrayList();
		HashMap h = new HashMap();
		String temp="";				
		for (Object[] aRow : queryList) {		
			if(aRow[0]!=null)
			{
			if(!aRow[0].equals(temp))
                {	
				h = new HashMap();			   					
			    temp=(String) aRow[0];			   
			    h.put("name", temp);	
				h.put(((Double) aRow[1]).intValue(), aRow[2]);				
				downRatio.add(h);				
                }
			else
			{
				h.put(((Double) aRow[1]).intValue(), aRow[2]);
				
			}
			
			}
			}	
		return downRatio;
	}
	
	@SuppressWarnings("unused")
	public List getMonthlyWiseData(Map map)
	{
		ArrayList Result1=new ArrayList();
		if(!CollectionUtils.isEmpty(map))
		{					
			Set mapSet = (Set) map.entrySet();
	        Iterator mapIterator = mapSet.iterator();
	        while (mapIterator.hasNext()) 
	        {
	        Map.Entry mapEntry = (Map.Entry) mapIterator.next();
	        String keyValue = (String) mapEntry.getKey();
	        List value = (List) mapEntry.getValue();	      
	        ArrayList<Double> r=new ArrayList<Double>();
	        Series serice=new Series();
	        Map data= new HashMap();
	        data=(Map) value.get(0);
	        Set dataSet = (Set) data.entrySet();	       
	        for(int i=1;i<=12;i++)
	        {
	        	
	        	if(!data.containsKey(i))
	        	{
	        		r.add(0.0);
	        	}
	        	else
	        	{
						try {
							Double d = (double) data.get(i);
							r.add(d);

						} catch (Exception e) {
							r.add(0.0);
							e.printStackTrace();
						}
	        }
	        }
	        serice.setName(keyValue);
	        serice.setData(r); 	        
	        Result1.add(serice);
	      
					
		}
		
		}  
		
		return Result1;
		
	}


	@Override
	public List getEquipmentBDTimestatisticsRptFiveYear() {		
		 ArrayList Result=new ArrayList();
		Calendar now = Calendar.getInstance(); 
		int year = now.get(Calendar.YEAR); 
		int y=year-4;
		String years=Integer.toString(y);
		Map<String,List<Map<String,String>>> map = new HashMap<String, List<Map<String,String>>>();

		String hql="select EI.dept_id ,date_part('year',WI.Created_date),sum(WI.duration_of_breakdown)from pmms.wo_info WI  inner join "
				+ "pmms.equip_info EI  on WI.equip_id=WI.equip_id where date_part('year',WI.Created_date)>='" + years + "' group by"
				+ " EI.dept_id,date_part('year',WI.Created_date) Order by EI.dept_Id,date_part('year',WI.Created_date)";

		SQLQuery query = super.getSession().createSQLQuery(hql);		
		List<Object[]> queryList = query.list();
		List l=new ArrayList();
		List downRatio = new ArrayList();
		HashMap h = new HashMap();
		String temp="";				
		for (Object[] aRow : queryList) {		
			if(aRow[0]!=null)
			{
			if(!aRow[0].equals(temp))
                {	
				h = new HashMap();
			    downRatio = new ArrayList();					
			    temp=(String) aRow[0];			    
				h.put(((Double) aRow[1]).intValue(), aRow[2]);	
				
				downRatio.add(h);
				map.put(temp, downRatio);
                }
			else
			{
				h.put(((Double) aRow[1]).intValue(), aRow[2]);
				
			}
			
			}
			}	
		
		if(!CollectionUtils.isEmpty(map))
		{
			
			Set mapSet = (Set) map.entrySet();
	        Iterator mapIterator = mapSet.iterator();
	        while (mapIterator.hasNext()) 
	        {
	        Map.Entry mapEntry = (Map.Entry) mapIterator.next();
	        String keyValue = (String) mapEntry.getKey();
	        List value = (List) mapEntry.getValue();	      
	        ArrayList<Double> r=new ArrayList<Double>();
	        Series serice=new Series();
	        Map data= new HashMap();
	        data=(Map) value.get(0);
	        Set dataSet = (Set) data.entrySet();	        
	      
	        for(int i=year-4;i<=year;i++)
	        {
	        	if(!data.containsKey(i))
	        	{
	        		r.add(0.0);
	        	}
	        	else
	        	{
	        		double d=(double) data.get(i);
	        		r.add(d);
	        		
	        	}
	        }	      
	        serice.setName(keyValue);
	        serice.setData(r); 	        
	       Result.add(serice);	      
					
		}
		
		} 
		return Result;
	}
	
	
	public List getEquipmentBDTimestatisticsRptFiveYearTable()
	{
		
		 ArrayList Result=new ArrayList();
		    Calendar now = Calendar.getInstance(); 
			int year = now.get(Calendar.YEAR); 
			int y=year-4;
			String years=Integer.toString(y);
			Map<String,List<Map<String,String>>> map = new HashMap<String, List<Map<String,String>>>();

			String hql="select EI.dept_id ,date_part('year',WI.Created_date),sum(WI.duration_of_breakdown)from pmms.wo_info WI  inner join "
					+ "pmms.equip_info EI  on WI.equip_id=WI.equip_id where date_part('year',WI.Created_date)>='" + years + "' group by"
					+ " EI.dept_id,date_part('year',WI.Created_date) Order by EI.dept_Id,date_part('year',WI.Created_date)";

			SQLQuery query = super.getSession().createSQLQuery(hql);		
			List<Object[]> queryList = query.list();
			List l=new ArrayList();
			List downRatio = new ArrayList();
			HashMap h = new HashMap();
			String temp="";				
			for (Object[] aRow : queryList) {		
				if(aRow[0]!=null)
				{
				if(!aRow[0].equals(temp))
	                {	
					h = new HashMap();				   					
				    temp=(String) aRow[0];
					h.put(((Double) aRow[1]).intValue(), aRow[2]);	
					h.put("name", temp);
					downRatio.add(h);					
	                }
				else
				{
					h.put(((Double) aRow[1]).intValue(), aRow[2]);
					
				}
				
				}
				}
			return downRatio;
		
	}


	@Override
	public Map<String,Object> getEquipmentStateDiagramRpt(String impartence) {
		Map map=new HashMap();		
		List deptIdList=getDeptId();
		for(int i=0;i<deptIdList.size();i++)
		{
	     map.put(deptIdList.get(i).toString(), getDeptWiseEquipId(impartence,deptIdList.get(i).toString())) ;
		}	  
		return map;
		}	
	
		
	public List getEquipmentRedRpt() {
		ArrayList WO_NS_Red=new ArrayList();		
		String hql="select distinct(equip_id) from pmms.wo_info where  wo_status ='"+Constants.WO_NOT_STARTED+"' and maint_type='BM'";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<String> queryList = query.list();
		for (String value : queryList) {
			
				WO_NS_Red.add(value);
	
	}
		return WO_NS_Red;
	}
	public List getEquipmentPinkRpt() {
		ArrayList WO_IN_Pink=new ArrayList();
		String hql="select distinct(equip_id) from pmms.wo_info where  wo_status ='"+Constants.WO_IN_PROGRESS+"' and maint_type='BM'";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<String> queryList = query.list();
		for (String value : queryList) {
			
				WO_IN_Pink.add(value);

		}	
	
		return WO_IN_Pink;
	}	
	public List getEquipmentOrngRpt() {
		
		ArrayList WO_IN_Orng=new ArrayList();		
		String hql="select distinct(equip_id) from pmms.wo_info where  wo_status IN('"+Constants.WO_NOT_STARTED+"','"+Constants.WO_IN_PROGRESS+"') and maint_type='SM'";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<String> queryList = query.list();
		for (String value : queryList) {				
			
				WO_IN_Orng.add(value);
             }
		return WO_IN_Orng;

}
	
	public List getDeptWiseEquipId(String impartence,String dept) {
		
		
		String flag=impartence;
		String deptId=dept;
		Series serice=new Series();
		ArrayList EQuipList=new ArrayList();
		List WO_NS_Red=new ArrayList();
		List WO_IN_Pink=new ArrayList();
		List WO_IN_Orng=new ArrayList();
		List Rpt = new ArrayList();
		HashMap h=new HashMap();
		
		String hql="select dept_id,equip_id,position_no from pmms.equip_info where imp_flag='"+flag+"' and dept_id='"+deptId+"' order by POSITION_NO";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		List<Object[]> queryList = query.list();
		
		for (Object[] aRow : queryList) {
			EQuipList.add(aRow[1]);
		
		}	
	    WO_NS_Red=getEquipmentRedRpt();
		WO_IN_Pink=getEquipmentPinkRpt();
		WO_IN_Orng=getEquipmentOrngRpt();		
		for(int i=0;i<EQuipList.size();i++)
		{
			
			EquipDashBoardRptBean E=new EquipDashBoardRptBean();
			if(WO_NS_Red.contains(EQuipList.get(i)))
			{
				E.setDeptName(deptId);
				E.setColor("Red");
				E.setEquipId(EQuipList.get(i).toString());
				
			}
			else if(WO_IN_Pink.contains(EQuipList.get(i)))
			{
				E.setDeptName(deptId);
				E.setColor("Pink");
				E.setEquipId(EQuipList.get(i).toString());
		
			}
			else if(WO_IN_Orng.contains(EQuipList.get(i)))
			{				
				E.setDeptName(deptId);
				E.setColor("Orange");
				E.setEquipId(EQuipList.get(i).toString());
			}
			else{
				E.setDeptName(deptId);
				E.setColor("Blue");
				E.setEquipId(EQuipList.get(i).toString());
			}
			
			Rpt.add(E);
		}
		

		return Rpt;	
	
	}
	
	
	public List<String> getDeptId(){
		List<String> deptList = null;
		String sql = "select DEPT_ID from pmms.dept_info order by id";
		SQLQuery query = getSession().createSQLQuery(sql);
		List<?> list = query.list();
		deptList = (List<String>) list;
		return deptList;
	}
	
	

	
	
}	
		

	
	
	


