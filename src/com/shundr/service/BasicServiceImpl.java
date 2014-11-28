
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.service
* @file IthingServiceImpl.java
* 
* @date 2014-2-26-下午12:19:28
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.apache.solr.common.SolrDocumentList;

import com.shundr.database.bean.CargoInfo;
import com.shundr.database.bean.UserInfo;
import com.shundr.database.dao.CargoInfoDao;
import com.shundr.database.dao.CompanyInfoDao;
import com.shundr.database.dao.TruckInfoDao;
import com.shundr.database.dao.UserInfoDao;
import com.shundr.database.dao.UserTruckRelationDao;
import com.shundr.response.bean.Captcha;
import com.shundr.response.bean.CargoInfoList;
import com.shundr.response.bean.Response;
import com.shundr.response.bean.UserLogin;
import com.shundr.service.util.CaptchaUtil;
import com.shundr.service.util.DateUtil;
import com.shundr.service.util.MD5Encryption;
import com.shundr.service.util.StrUtil;




/**
 * @project Twitter
 * @author Dayong.Shen
 * @class IthingServiceImpl
 * 
 * @date 2014-2-26-下午12:19:28
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */
@Service
public class BasicServiceImpl implements BasicService {
	private static final Logger log = LoggerFactory
			.getLogger(BasicServiceImpl.class);
	
	@Resource
	private UserInfoDao userInfoDao;
	
	@Resource
	private CargoInfoDao cargoInfoDao;
	
	@Resource
	private CompanyInfoDao companyInfoDao;
	
	@Resource
	private TruckInfoDao truckInfoDao;
	
	@Resource
	private UserTruckRelationDao userTruckRelationDao;
	
	


	
	@Override
	public Response getUserLogout(String access_token) {
		// TODO Auto-generated method stub
		Response response=new Response();
	     
    	 if(AccessAuthService.getAuthMap().containsKey(access_token)){			    	
				
    		    AccessAuthService.getAuthMap().remove(access_token);
    		 
    		    response.setDescription("用户注销成功!");
    		    response.setStatus("success");
		     }else{
		    	 response.setDescription("用户根本未登陆!");
		    	 response.setStatus("error");
		     }
    	 
    	//设置查询的方法
 		try{
 			response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
 			}catch(Exception ex){
 				
 			}
 		//设置查询的参数	
 		response.setParams("access_token: "+access_token);
	
	     return response;
	}

	@Override
	public Response<UserLogin> getUserLogin(String username,
			String userpsw) {
		Response<UserLogin> response=new Response<UserLogin>();
		
		if(username!=null&userpsw!=null){
			UserInfo user = null;
			boolean isPhone = username.matches("[0-9]+");
			
			if(isPhone){
				user=userInfoDao.getUserInfoByUserPhone(username);
			}else{
				user=userInfoDao.getUserInfoByUserName(username);
			}
			
					
			
			if(user.getUserPsw().contentEquals(userpsw)){
				
								
				
				//设定这次登陆时间
				Timestamp loginTime=new Timestamp(System.currentTimeMillis());
				userInfoDao.updateLoginTime(username,loginTime);
				
				
				response.setDescription("登陆成功");
				response.setStatus("success");
				
				String token=MD5Encryption.getMD5(user.getUserName()+userpsw);
				
				UserLogin userLogin=new UserLogin();
				
				userLogin.setUser(user);
				userLogin.setAccessToken(token);
				userLogin.setLastActiveTime(loginTime);
				
				AccessAuthService.getAuthMap().put(token, userLogin);
				
				response.setResult(userLogin);
				
				response.setNumReturn(1);
				
			
				
		        
			}else{
				response.setDescription("用户名或密码错误");
				response.setStatus("error");
				response.setNumReturn(1);
					
				
			}
			
		}else{
			response.setDescription("用户名或密码为空");
			response.setStatus("error");
			response.setNumReturn(1);
		}
		
		//设置查询的方法
		try{
			response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
			}catch(Exception ex){
				
			}
		//设置查询的参数	
		response.setParams("username: "+username+", userpsw: "+userpsw);
		
		return response;		
	}

	

	/* 
	 * KGCheng
	 * (non-Javadoc)
	 * @see com.shundr.service.BasicService#searchCargoListbyPlace(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Response searchCargoListbyPlace(String cargoSrcPlace,
			String cargoDstPlace, String access_token) {
		// TODO Auto-generated method stub
		Response<CargoInfoList> response=new Response<CargoInfoList>();
		
		CargoInfoList cargoInfoList=new CargoInfoList();
		
		Response authResult=new Response();
	     
	     authResult=AccessAuthService.authorization(access_token);
	     
	     
	    	 if(authResult.getStatus().equals("success")){
			    	
			 	try{
			 		List<CargoInfo>	cargoList=cargoInfoDao.searchCargoListbyPlace( cargoSrcPlace,cargoDstPlace);
			 		 cargoInfoList.setCargoInfoList(cargoList);
			 		 response.setDescription("查询成功");
		    		 response.setStatus("success");
		    		 response.setResult(cargoInfoList);
		    		 response.setNumReturn(cargoInfoList.getCargoInfoList().size());
			 	}catch(Exception e){
			 		response.setDescription("查询失败");
		    		 response.setStatus("error");
		    		 response.setResult(cargoInfoList);
		    		 response.setNumReturn(0);
			 	}	
					
			     }else{
			    	 response.setResult(null);
		    		 response.setNumReturn(0);
			    	 response.setDescription(authResult.getDescription());
			    	 response.setStatus("error");
			     }
	    	 
	    	//设置查询的方法
	    	 try{
					response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
				}catch(Exception ex){
						
				}
			//设置查询的参数	
				response.setParams("cargoSrcPlace: "+cargoSrcPlace+", cargoDstPlace: "+cargoDstPlace+", access_token: "+access_token);
		
		return response;
	}

	/* 
	 * KGCheng
	 * (non-Javadoc)
	 * @see com.shundr.service.BasicService#searchCargoListbyPlace(java.lang.String, java.lang.String, java.lang.String)
	 */

	@Override
	public Response registerCargo(String cargoCategory, Double cargoWeight,
			Double cargoVolume, String cargoSrcPlace, String cargoDstPlace,
			String cargoTurckType, String cargoOwnerName,
			String cargoOwnerPhone, Float cargoPriceMin, Float cargoPriceMax,
			String cargoUnitName, Float cargoUnitPrice,String cargoDescription, String cargoEndTime,
			String access_token) {
		// TODO Auto-generated method stub
		Response<CargoInfo> response=new Response<CargoInfo>();
		
	
		
		Response authResult=new Response();
	     
	     authResult=AccessAuthService.authorization(access_token);
	     
	     
	    	 if(authResult.getStatus().equals("success")){
	    		 
	    		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	
			 	try{
			 		int userId=AccessAuthService.getAuthMap().get(access_token).getUser().getUserId();
			 		 CargoInfo newCargo=new CargoInfo(userId,  cargoCategory,  cargoWeight,
	    					 cargoVolume,  cargoSrcPlace,  cargoDstPlace,
	    					 cargoTurckType,  cargoOwnerName,
	    					 cargoOwnerPhone,  cargoPriceMin,  cargoPriceMax,
	    					 cargoUnitName,  cargoUnitPrice,
	    					 cargoDescription,  new Timestamp((new Date()).getTime()),
	    					 new Timestamp(sdf.parse(cargoEndTime).getTime()),0);
			 	
			 		cargoInfoDao.saveCargoInfo(newCargo);
			 		 
			 		 
			 		 response.setDescription("插入成功");
		    		 response.setStatus("success");
		    		 response.setResult(newCargo);
		    		 response.setNumReturn(1);
			 	}catch(Exception e){
			 		response.setDescription("插入失败");
		    		 response.setStatus("error");
		    		 response.setResult(null);
		    		 response.setNumReturn(0);
			 	}	
					
			     }else{
			    	 response.setDescription(authResult.getDescription());
			    	 response.setStatus("error");
			    	 response.setResult(null);
		    		 response.setNumReturn(0);
			     }
	    	 
	    	//设置查询的方法
	    	 try{
					response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
				}catch(Exception ex){
						
				}
			//设置查询的参数	
				response.setParams("cargoCategory :"+cargoCategory+"，cargoWeight :"+cargoWeight+"，cargoVolume :"+cargoVolume+"，cargoSrcPlace :"+cargoSrcPlace+"，cargoDstPlace :"+cargoDstPlace+"，cargoTurckType :"+cargoTurckType+"，cargoOwnerName :"+cargoOwnerName+"，cargoOwnerPhone :"+cargoOwnerPhone+"，cargoPriceMin :"+cargoPriceMin+"，cargoPriceMax :"+cargoPriceMax+"，cargoUnitName :"+cargoUnitName+"，cargoUnitPrice :"+cargoUnitPrice+"，cargoDescription :"+cargoDescription+"，cargoEndTime :"+cargoEndTime+"，access_token :"+access_token);
		
		return response;
	}
	
	
	/**
	 * @author G.Liang
	 */
	@Override
	public Response<UserInfo> registerUser(String username, String psw,
			String phone, String captcha) {
		Response<UserInfo> response = new Response();
		
		Response captchaResult  = new Response();
		captchaResult = CaptchaService.authorization(phone);
		if(captchaResult.getStatus().equals("success")){
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(username);
			userInfo.setUserPsw(MD5Encryption.getMD5(psw));
			userInfo.setUserPhone(phone);
			userInfo.setUserRegesiterTime(new Timestamp(System.currentTimeMillis()));
			if(userInfoDao.saveRegisterUser(userInfo)){
				response.setDescription("注册成功");
				response.setResult(userInfo);
				response.setStatus("success");
			}
		} else {
			response.setDescription("注册失败");
			response.setStatus("error");
		}
		
		response.setNumReturn(1);
		response.setParams("username: "+username+", userpsw: "+psw+", userPhone: "+phone+", captcha: "+captcha);
		
		//设置查询的方法
   	 	try{
				response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
			}catch(Exception ex){
					
			}
		return response;
	}
	
	/**
	 * @author G.Liang
	 */
	@Override
	public Response<Captcha> getCaptcha(String phone) {
		// TODO Auto-generated method stub
		Response<Captcha> response = new Response<Captcha>();
		//生成验证码，放入内存中
		Captcha captcha = new Captcha();
		String captchaStr = CaptchaUtil.getRandomCaptcha();
		captcha.setCaptchaStr(captchaStr);
		captcha.setFirstGetCaptchaTime(new Timestamp(System.currentTimeMillis()));
		CaptchaService.getCaptchaMap().put(phone, captcha);
		
		//发送验证码到手机
		String resultCode = CaptchaUtil.getCaptcha(phone,captchaStr);
		
		response.setResult(captcha);
		response.setParams("phone: "+phone);
		response.setNumReturn(1);
		try{
			response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
		}catch(Exception ex){
				
		}
		if(resultCode.equals("100")){
			response.setStatus("success");
			response.setDescription("发送验证码成功");
		} else {
			response.setStatus("error");
			response.setDescription("发送验证码失败，resultCode: "+resultCode);
			response.setResult(captcha);
		}
		return response;
	}

	/**
	 * @author G.Liang
	 */
	@Override
	public Response<String> checkUserName(String username) {
		Response<String> response = new Response<String>();
		if(!userInfoDao.getIsExistUser(username)) {
			//不存在此用户名
			response.setDescription("不存在此用户名，此用户名可用");
			response.setResult(username);
			response.setStatus("success");
		} else {
			response.setDescription("存在此用户名，此用户名不可用");
			response.setResult(username);
			response.setStatus("error");
		}
		
		response.setNumReturn(1);
		response.setParams("username: "+username);
		try{
			response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
		}catch(Exception ex){
				
		}
		return response;
	}

	/**
	 * @author G.Liang
	 * 	 找回密码，确认手机号
	 */
	@Override
	public Response<String> confirmPhone(String phone) {
		Response<String> response = new Response<String>();
		if(!userInfoDao.getIsExistPhone(phone)) {
			response.setDescription("不存在此手机号，找回密码失败");
			response.setResult(phone);
			response.setStatus("error");
		} else {
			response.setDescription("存在此手机号，找回密码第一步完成");
			response.setResult(phone);
			response.setStatus("success");
		}
		
		response.setNumReturn(1);
		response.setParams("phone: "+phone);
		try{
			response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
		}catch(Exception ex){
				
		}
		return response;
	}

	/**
	 * @author G.Liang
	 * 	 找回密码，重置密码
	 */
	@Override
	public Response<String> resetUserPsw(String phone, String userpsw) {
		Response<String> response = new Response<String>();
		Response captchaResult  = new Response();
		captchaResult = CaptchaService.authorization(phone);
		if(captchaResult.getStatus().equals("success")){
			//验证码输入正确，重置密码
			String userpswMD5 = MD5Encryption.getMD5(userpsw);
			if(userInfoDao.updateUserPsw(phone,userpswMD5)==1){
				response.setDescription("重置密码成功");
				log.info("重置密码成功");
				response.setStatus("success");
				response.setResult(phone);
			} else {
				response.setDescription("重置密码失败，更新数据库错误");
				log.error("重置密码失败，更新数据库错误");
				response.setStatus("error");
				response.setResult(phone);
			}
			
		} else {
			response.setDescription("重置密码失败，验证码错误");
			log.error("重置密码失败，验证码错误");
			response.setStatus("error");
			response.setResult(phone);
		}
		response.setNumReturn(1);
		response.setParams("phone: "+ phone);
		try{
			response.setQueryMethod(new Exception().getStackTrace()[0].getMethodName());
		}catch(Exception ex){
				
		}
		return response;
	}



}
