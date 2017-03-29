/**
 * ============================================================
 * File : SMSUtil.java
 * Description : 
 * 
 * Package : com.ge.pmms
 * Author : Flash
 * Last Edited By :
 * Version : 1.0
 * Created on : Oct 09, 2016
 * History
 * Modified By : Initial Release
 * Classification : GE Confidential
 *
 *
 * ============================================================
 */

package com.ge.pmms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.ofbiz.core.entity.GenericDelegator;
import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.IInboundMessageNotification;
import org.smslib.IOutboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Message.MessageEncodings;
import org.smslib.Message.MessageTypes;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

//import com.ge.pmms.utils.MsgUtil.InboundNotification;
//import com.ge.pmms.utils.MsgUtil.OutboundNotification;


/*******************************************************************************
 *
 * @Author 		: Capgemini
 * @Version 	: 1.0
 * @Date Created: Oct 09, 2016
 * @Date Modified : 
 * @Modified By : 
 * @Contact 	:
 * @Description : 
 * @History		:
 *
 ******************************************************************************/
public class SMSUtil {
	
	//自身类
	static SMSUtil smwps=null;
	//读取全部消息
	public static final org.smslib.InboundMessage.MessageClasses ALL_MESSAGE=org.smslib.InboundMessage.MessageClasses.ALL;
	//读取已读消息
	public static final  org.smslib.InboundMessage.MessageClasses READ_MESSAGE=org.smslib.InboundMessage.MessageClasses.READ;
	//读取未读消息
	public static final org.smslib.InboundMessage.MessageClasses UNREAD_MESSAGE =org.smslib.InboundMessage.MessageClasses.UNREAD;
	//消息服务
	private static Service srv=null;
	//发送消息回调实现类
	OutboundNotification outboundNotification = new OutboundNotification();
	//读取消息回调实现类
	InboundNotification  inboundNotification=new InboundNotification();
	//数据库柄
	private  GenericDelegator delegator=null;
	
	//设备名称
	private static String gateName="SMS";

	private SMSUtil(){}
	
	//构造类的实例，只产生一个对象实例
	
	public static SMSUtil newInstanceSend(String com) throws TimeoutException, GatewayException, SMSLibException, IOException, InterruptedException{
		if(smwps==null)
			smwps=new SMSUtil();
		if (smwps.srv==null)
			smwps.open(com,gateName);		
		return smwps;
	}
	public static SMSUtil newInstanceSend(String com,GenericDelegator delegator) throws TimeoutException, GatewayException, SMSLibException, IOException, InterruptedException{
		if(smwps==null)
			smwps=new SMSUtil();
		if (smwps.srv==null)
			smwps.open(com,gateName);		
		smwps.delegator=delegator;
		return smwps;
	}
	public static SMSUtil newInstanceSend(String com,GenericDelegator delegator,String gateName) throws TimeoutException, GatewayException, SMSLibException, IOException, InterruptedException{
		if(smwps==null)
			smwps=new SMSUtil();
		if (smwps.srv==null)
			smwps.open(com,gateName);		
		smwps.delegator=delegator;
		SMSUtil.gateName=gateName;
		return smwps;
	}
	
	//打开端口，开启服务
	public static void open(String com,String gateName) throws TimeoutException, GatewayException, SMSLibException, IOException, InterruptedException {
		//单例。Service.startService();只能调用一次，否则抛出端口异常！
		  if(srv==null){
			  //srv = new Service();
			  srv = Service.getInstance();
			//comPort     串口名，比如COM1或者/dev/ttyS1
			  //baudRate   端口速度，WAVECOM是9600
			  //manufacturer,model 制造商和型号随便填
			  SerialModemGateway gateway= new SerialModemGateway(gateName,com,115200,"",srv.toString());
			  gateway.setInbound(true);
			  gateway.setOutbound(true);
			  srv.addGateway(gateway);			 
			  srv.startService();
		  }
			  //gateway.setSimPin("0000");
			 // gateway.setOutboundNotification(outboundNotification);
			 
			  //gateway.setInboundNotification(inboundNotification);
			  //srv.setOutboundNotification(outboundNotification);
			  //srv.setInboundNotification(inboundNotification);
			 // srv.S.SERIAL_POLLING_INTERVAL=10;
			  //srv.S.SERIAL_POLLING=true;
	}
	//读取信息
	public List <org.smslib.InboundMessage> readSms(org.smslib.InboundMessage.MessageClasses messageType) throws TimeoutException, GatewayException, IOException, InterruptedException{
		List <InboundMessage>  smss=new LinkedList<InboundMessage>();
		//InboundMessage inm=null;		
		srv.readMessages(smss,messageType,gateName);
		//System.out.println(smss);		
		//System.out.println(msg);
		return smss;
	}	 
	//发送单条消息
	public static boolean sendSms(String mobile,String content) {				
		OutboundMessage msg = new OutboundMessage(mobile, content);
		msg.setEncoding(MessageEncodings.ENCUCS2);
		//msg.setStatusReport(true);
		try {
			
			srv.sendMessage(msg);
			} catch (Exception e) {
				//LOGGER.error("sending single msg Exception:......"+e.getLocalizedMessage());
				return false;
			}
		return true;
	}
	//群发消息
	public static boolean sendMutipleSms(Collection<OutboundMessage> messages) {
		try {
			srv.sendMessages(messages);
		}
		catch (TimeoutException e) {
			//LOGGER.error("sendMutipleSms Exception:TimeoutException......"+e.getLocalizedMessage());
			return false;
		}
		catch (GatewayException e) {
			//LOGGER.error("sendMutipleSms Exception:GatewayException......"+e.getLocalizedMessage());
			return false;
		}
		catch (IOException e) {
			//LOGGER.error("sendMutipleSms Exception:IOException......"+e.getLocalizedMessage());
			return false;
		}
		catch (InterruptedException e) {
			//LOGGER.error("sendMutipleSms Exception:InterruptedException......"+e.getLocalizedMessage());
			return false;
		}finally{
//			try {
//				srv.stopService();
//			}
//			catch (TimeoutException e) {
//				LOGGER.error("stop sending msg Service Exception:TimeoutException......"+e.getLocalizedMessage());
//			}
//			catch (GatewayException e) {
//				LOGGER.error("stop sending msg Service Exception:GatewayException......"+e.getLocalizedMessage());
//			}
//			catch (IOException e) {
//				LOGGER.error("stop sending msg Service Exception:IOException......"+e.getLocalizedMessage());
//			}
//			catch (InterruptedException e) {
//				LOGGER.error("stop sending msg Service Exception:InterruptedException......"+e.getLocalizedMessage());
//			}
		}
		return true;
	}	
	//群发消息
	public List<Map<String, String>>  sendSms(List<Map<String,String>> messages) {
		List <Map<String, String>>   failList=new ArrayList <Map<String, String>>();
		Iterator<Map<String, String>> itr= messages.iterator();
		while(itr.hasNext()){
			Map<String, String> message=(Map<String, String>)itr.next();
			String mobile=(String)message.get("mobile");
			String content=(String)message.get("content");
			if(!sendSms(mobile,content))
				failList.add(message);
		}
		return failList;
	}
	
	
	//关闭服务
	public static void close() {
		try {
			  srv.stopService();
			}catch (Exception e) {
				//LOGGER.error("stop sending msg Exception:......"+e.getLocalizedMessage());
			 }
	 }
			 
	public class OutboundNotification implements IOutboundMessageNotification{
		/*public void process(String gatewayId, OutboundMessage msg){
			//LOGGER.error("Outbound handler called from Gateway: " + gatewayId+"msg="+msg);
		 }*/

		@Override
		public void process(AGateway gateway, OutboundMessage msg) {
			// TODO Auto-generated method stub
			
		}
	 }
	public class InboundNotification implements IInboundMessageNotification{

		/*public void process(String arg0, MessageTypes arg1, InboundMessage arg2) {
		}*/

		@Override
		public void process(AGateway gateway, MessageTypes msgType,
				InboundMessage msg) {
			// TODO Auto-generated method stub
			
		}
		
	}	 
	

	/*public static void main(String[] args) throws TimeoutException, GatewayException, IOException, InterruptedException {       
		System.out.println("=============================");
		
		String mob = "18936087925";
		String content="你好,PMMS平台提醒你，有一个故障维修工单产生请即时处理。工单编号:201506111634083596;设备名称：柔性加工线; 所属部门:机械加工部";
		SMSUtil sms=new SMSUtil();//newInstance();		 
		 try {
			sms.open("COM3","SMS");
		} catch (TimeoutException e) {
			System.out.println("============================="+e.getMessage());
			e.printStackTrace();
		} catch (GatewayException e) {
			e.printStackTrace();
		} catch (SMSLibException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1、发送短消息");
		System.out.println("quit、退出");
		String str="";
		System.out.println("1、发送短消息");
		
		System.out.println("quit、退出");	
		sms.sendSms(mob,content);

		sms.close();
				
	}*/
	
	public static void sendMsg(String mobileNo,String msgContent )
	{
		/*String mobileNo = "13348017813";

		String msgContent = "Hello from SMSLib!";*/
		// sms content
		List<OutboundMessage> msgs = new ArrayList<OutboundMessage>();

		OutboundMessage obm = new OutboundMessage(mobileNo, msgContent);
		obm.setEncoding(MessageEncodings.ENCUCS2);
		msgs.add(obm);

		try {
			SMSUtil.open("COM3", "SMS");
			
			SMSUtil.sendMutipleSms(msgs);
			
			
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GatewayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SMSLibException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
