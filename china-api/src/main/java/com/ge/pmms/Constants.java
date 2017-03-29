package com.ge.pmms;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static String LOCALE = "zh_CN";

	public static final String MESSAGE_TYPE_INFO = "info";
	public static final String MESSAGE_TYPE_WARNING = "warning";
	public static final String MESSAGE_TYPE_ERROR = "error";

	public static final String ERR_COMMON_SYS_ERROR = "10000";
	public static final String ERR_COMMON_DB_ERROR = "10001";
	public static final String ERR_COMMON_BAD_ACCESS = "10002";
	public static final String ERR_COMMON_DB_NO_RESULTS = "10003";
	public static final String ERR_COMMON_DB_NOT_EXISTS = "10004";
	public static final String ERR_COMMON_DB_REFERENCED = "10005";

	public static final String ERR_ORDER_NOT_EXISTS = "20000";

	public static final float HOURS_FLOAT = 3600000.0F;
	public static final int HOURS = 60 * 60 * 1000;
	public static final int DAYS = 60 * 60 * 1000 * 24;
	public static final int DECIMAL_SCALE2 = 2;
	public static final int DECIMAL_SCALE4 = 4;
	public static final int DAYOFYR_LEAP = 366;
	public static final int DAYOFYR_NON_LEAP = 365;
	public static final int FEB_LEAP = 29;
	public static final int FEB_NON_LEAP = 28;

	public static final Map<String, String> SYS_CONFIG_MAP = new HashMap<String, String>();

	// 系统参数配置
	// 文档上传存放路径
	public static final String EQUIP_DOC_UPLOAD_PATH = "1001";

	// 设备每天工作时长
	public static final String EQUIP_WORK_TIME = "1002";
	// 计划工单收件人
	public static final String FW_EMAIL_RECEIVER = "1003";
	// 系统是否发送邮件提醒。1：提醒，0：不提醒
	public static final String FLAG_MAIL_REMINDER = "1004";
	// 系统是否发送短信提醒。1：提醒，0：不提醒
	public static final String FLAG_MSG_REMINDER = "1005";
	// 计划工单邮件提醒内容模板
	public static final String FW_EMAIL_FORMAT = "1007";
	// 计划工单短信提醒内容模板
	public static final String FW_MSG_FORMAT = "1008";
	// 间接物料安全库存管理收件人
	public static final String IDM_EMAIL_RECEIVER = "1006";
	// 备件安全库存邮件接收人
	public static final String SPM_EMAIL_RECEIVER = "1009";
	// 故障维修工单创建短信提醒
	public static final String WO_CREATED_MSG_RECEIVER = "1010";
	// 维修团队的SSO,具有维修权限，开始和结束维修工单时验证
	public static final String MAINTANENCE_TEAM = "1011";

	/**
	 * 是否发送提醒
	 */
	public static final String FLAG_REMIND = "1";

	/*
	 * 设备类型
	 */
	public static final String EQUIP_TYPE_MANUFACTURE = "1";
	public static final String EQUIP_TYPE_SPECIAL = "2";
	public static final String EQUIP_TYPE_FACILITY = "3";

	public static final String DATE_PATTEN = "yyyy-MM-dd";
	public static final String DATE_PATTEN_SEC = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTEN_MONTH = "yyyy-MM";

	// 工单状态---刚提交
	//public static final String WORK_ORDER_STATUS_SUBMIT = "1";
	// 工单状态---维修中
	//public static final String WORK_ORDER_STATUS_MAINT = "2";
	
	
	//not started
	public static final String WO_NOT_STARTED = "未开始";//Red Color
	//in-progress/Resume
	public static final String WO_IN_PROGRESS = "进行中";//Yellow Color
	//conditional Close
	public static final String WO_CONDITIONAL_CLOSE = "带遗留问题运行";//Blue Color
	//Pause
	public static final String WO_PAUSE = "暂停";//Cyan Color
	//close
	public static final String WO_CLOSE = "关闭";//White Color
	//Confirm
	public static final String  WO_CONFIRM = "确认";//We do not show this record on screen

	// 工单状态描述---刚提交
	public static final String WORK_ORDER_STATUS_SUBMIT_DESC = "未开始";
	// 工单状态态描述---维修中
	public static final String WORK_ORDER_STATUS_MAINT_DESC = "维修中";
	// 工单状态态描述---已关闭
	public static final String WORK_ORDER_STATUS_ClOSED_DESC = "关闭";

	// 故障维修工单
	public static final String FAULT_WO = "故障维修工单";
	// 计划保养工单
	public static final String PLAN_WO = "计划保养工单";
	
	public static final String EQUIPMENT = "EQUIPMENT";
	public static final String FACILITY = "FACILITY";
	
	public static final String  MAINTENANCE_TECHNICIANS = "设备维修技术员/Equipment maintenance technician";
	
	/**
	 * 五大区域编号和中文名
	 */
	
	//变压器制造部
	public static final String DEPT_TRANSFORMER = "dept0001";
	public static final String DEPT_TRANSFORMER_NM = "变压器制造部";
	//成套设备制部
	public static final String DEPT_OUTFIT = "dept0002";
	public static final String DEPT_OUTFIT_NM = "成套设备制部";
	//机械加工部
	public static final String DEPT_MACHINING = "dept0004";
	public static final String DEPT_MACHINING_NM = "机械加工部";	
	//开关制造部
	public static final String DEPT_SWITCH = "dept0005";
	public static final String DEPT_SWITCH_NM = "开关制造部";	
	//其他部门
	public static final String DEPT_OTHER = "dept0006";
	public static final String DEPT_OTHER_NM = "其他部门";
	//总计
	public static final String DEPT_AVG = "dept000x";
	public static final String DEPT_AVG_NM = "总计";	
	
	
	/**
	 * 报表与统计
	 * 报表类型定义
	 */
	//保养计划完成率
	public static final String CHART_PM_ONE = "PM_ONE";//一年中五大部门
	public static final String CHART_PM_FIVE = "PM_FIVE";//五年中部门
	public static final String CHART_PM_SINGLE = "PM_SINGLE";//单个设备
	//设备可利用率
	public static final String CHART_EA_ONE = "EA_ONE";
	public static final String CHART_EA_FIVE = "EA_FIVE";
	public static final String CHART_EA_SINGLE = "EA_SINGLE";
	//平均维修间隔时间
	public static final String CHART_MTBF_ONE= "MTBF_ONE";
	public static final String CHART_MTBF_FIVE= "MTBF_FIVE";
	public static final String CHART_MTBF_SINGLE= "MTBF_SINGLE";
	//平均维修时间
	public static final String CHART_MTTR_ONE = "MTTR_ONE";
	public static final String CHART_MTTR_FIVE = "MTTR_FIVE";
	public static final String CHART_MTTR_SINGLE = "MTTR_SINGLE";
	//维修配件费用
	public static final String CHART_MSPC_ONE = "MSPC_ONE";
	public static final String CHART_MSPC_FIVE = "MSPC_FIVE";
	public static final String CHART_MSPC_SINGLE = "MSPC_SINGLE";
	//维修配件使用数量
	public static final String CHART_MSPQU_ONE = "MSPQU_ONE";
	public static final String CHART_MSPQU_FIVE = "MSPQU_FIVE";
	public static final String CHART_MSPQU_SINGLE = "MSPQU_SINGLE";
	
	//部门
	public static final String CHART_DEPT_TH = "区域";
	//单个设备
	public static final String CHART_SINGLE_TH = "设备/备件编号";
	
	//按月份统计
	public static final int PERIOD_MONTH = 12;
	//按年统计
	public static final int PERIOD_YEAR = 5;
	

	public static final String INVALID_WRDS = "[\\\\/:*?\"<>|]+";

	// 安全库存
	public static final double Z = 1.65; // 安全系数
	public static final int TIME_SAPN = 24; // 时间跨度，默认24个月
	
	public static final String ITEM_DESC="Email/SMS sent";
	
	public static final String INSPECTION_CHECK = "IC" ;
	
	public static final String MAINTAINANCE_CHECK = "MC" ;
	
	public static final String 	BATCH_FREQUENCY_WEEKLY = "Weekly" ;
	public static final String 	BATCH_FREQUENCY_DAILY = "Daily";
	
	public static final String 	DAILY_WO_PCM_QM_FLAG = "PCM和QM工作单到日常工作转换开关";
	
	public static final String 	TRUE = "TRUE";
	
	public static final String 	Inspection_Category = "MC";
	
	public static final String MEASURING_TOOL="7469";
}
