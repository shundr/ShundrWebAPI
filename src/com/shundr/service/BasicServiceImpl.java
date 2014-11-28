
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
import com.shundr.response.bean.CargoInfoList;
import com.shundr.response.bean.Response;
import com.shundr.response.bean.UserLogin;
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
				userInfoDao.updateLoginTime(loginTime);
				
				
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
	




}
