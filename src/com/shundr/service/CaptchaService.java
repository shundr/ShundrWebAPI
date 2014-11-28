
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.service
* @file AccessAuthorizationService.java
* 
* @date 2014-2-27-上午11:52:59
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.shundr.response.bean.Captcha;
import com.shundr.response.bean.Response;
import com.shundr.response.bean.UserLogin;


/**
 * @author G.Liang
 * 
 * 
 */

public class CaptchaService {

	
	private static Map<String,Captcha> captchaMap=new HashMap<String,Captcha>(); 
    private static int maxInactiveInterval=30*60;//秒数 过期时间,-1表示永远不过期
	

	public CaptchaService() {
		// TODO Auto-generated constructor stub
	}

	public static Response authorization(String phone) {
		// TODO Auto-generated method stub
		Response authResult=new Response();
		
	    if(phone!=null&!phone.equals("")){
	    	
	    	if(captchaMap.get(phone)==null){//vcode不存在
	    		 authResult.setDescription("获取失败,captcha不存在,用户未获取验证码!");
		    	 authResult.setStatus("error");	   
		    	 
	    	}else{//vcode存在，看看vcode是否过期
	    		 if(isExpire(captchaMap.get(phone).getFirstGetCaptchaTime())){//过期						
	    			 authResult.setDescription("获取失败,captcha已过期!");
			    	 authResult.setStatus("error");	
			    	 
			    	 //过期则在vcodeMap中删除
			    	 captchaMap.remove(phone);
				     }else{//没过期
				    	 authResult.setDescription("获取成功,captcha有效");
					     authResult.setStatus("success");
				     }
	    	}	    
	     }else{
	    	 authResult.setDescription("电话未输入");
	    	 authResult.setStatus("error");
	     }
	    
	    return authResult;
	}
	
	public static boolean isExpire(Timestamp time){		
		
		Calendar calendar =Calendar.getInstance();
		calendar.setTimeInMillis(time.getTime());
		//calendar.add(Calendar.HOUR_OF_DAY,maxInactiveInterval);
		calendar.add(Calendar.SECOND,maxInactiveInterval);
		
		if(calendar.before(Calendar.getInstance())){
			return true;
		}else{
			return false;
		}
		
	}


	
	 /**
	 * maxInactiveInterval
	 *
	 * @return  the maxInactiveInterval
	 * @since   1.0.0
	 */
	
	public static int getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	
	 /**
	 * @param maxInactiveInterval the maxInactiveInterval to set
	 */
	 
	public static void setMaxInactiveInterval(int maxInactiveInterval) {
		CaptchaService.maxInactiveInterval = maxInactiveInterval;
	}

	public static Map<String, Captcha> getCaptchaMap() {
		return captchaMap;
	}

	public static void setCaptchaMap(Map<String, Captcha> captchaMap) {
		CaptchaService.captchaMap = captchaMap;
	}

	
	

	

	
	
	/*
	 * request.getSession(false)==null可以近似的判断是否过期：如果已经过期，那么返回的是null，但是当起一次请求，刚刚建立一个session的时候，上述方法也返回null
所以应该这个做
if(null==request.getSession(false)){
   if(true==request.getSession(true).isNew()){
      }
else{
System.out.println("session已经过期");
}
}
	 */



}
