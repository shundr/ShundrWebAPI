
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

import com.shundr.response.bean.Response;
import com.shundr.response.bean.UserLogin;


/**
 * @project Twitter
 * @author Dayong.Shen
 * @class AccessAuthorizationService
 * 
 * @date 2014-2-27-上午11:52:59
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */

public class AccessAuthService {

	
	private static Map<String,UserLogin> authMap=new HashMap<String,UserLogin>(); 
    private static int maxInactiveInterval=12*60*60;//秒数 过期时间,-1表示永远不过期
	

	public AccessAuthService() {
		// TODO Auto-generated constructor stub
	}

	public static Response authorization(String access_token) {
		// TODO Auto-generated method stub
		Response authResult=new Response();
		
	    if(access_token!=null&authMap.size()>0){
	    	
	    	if(authMap.get(access_token)==null){//access_token不存在
	    		 authResult.setDescription("认证失败,access_token不存在,用户未登录!");
		    	 authResult.setStatus("error");	   
		    	 
	    	}else{//access_token存在，看看access_token是否过期
	    		 if(isExpire(authMap.get(access_token).getLastActiveTime())){//过期						
	    			 authResult.setDescription("认证失败,access_token已过期!");
			    	 authResult.setStatus("error");	
			    	 
			    	 //过期则在authMap中删除
			    	 authMap.remove(access_token);
				     }else{//没过期
				    	 authResult.setDescription("认证成功");
					     authResult.setStatus("success");
					     
					     //更新最后一次活动时间
					     authMap.get(access_token).setLastActiveTime(new Timestamp(System.currentTimeMillis()));
				     }
	    	}	    
	     }else{
	    	 authResult.setDescription("认证失败,请重新登陆!");
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
	 * authMap
	 *
	 * @return  the authMap
	 * @since   1.0.0
	 */
	
	public static Map<String, UserLogin> getAuthMap() {
		return authMap;
	}



	/**
	 * @param authMap the authMap to set
	 */
	
	public static void setAuthMap(Map<String, UserLogin> authMap) {
		AccessAuthService.authMap = authMap;
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
		AccessAuthService.maxInactiveInterval = maxInactiveInterval;
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
