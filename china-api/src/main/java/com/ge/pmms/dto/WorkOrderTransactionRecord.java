package com.ge.pmms.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WorkOrderTransactionRecord 
{
	public int WorkOrderNumber()
	{
		 int serialNo = 000;
		 
		 Date date = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyykkmmss");
			String workdate = sdf.format(date);
	 
	 
	      for (int i=0;i<10;i++){
	          serialNo++;
	          	System.out.println("Testing =====> " +workdate + serialNo);
	      }
	      return serialNo;
	}
}
