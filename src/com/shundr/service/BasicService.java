
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.service
* @file IthingService.java
* 
* @date 2014-2-26-下午12:17:50
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service;


import java.util.Date;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;



import com.shundr.database.bean.UserInfo;
import com.shundr.response.bean.Captcha;
import com.shundr.response.bean.Response;
import com.shundr.response.bean.UserLogin;
import com.shundr.service.util.DateAdapter;



/**
 * @project Twitter
 * @author Dayong.Shen
 * @class IthingService
 * 
 * @date 2014-2-26-下午12:17:50
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */
@Path(value = "")
//@Produces("application/xml")
@Produces("application/json")
public interface BasicService {

	@GET
	@Path("/getUserLogin")
	Response<UserLogin> getUserLogin(@QueryParam("username") String username,@QueryParam("userpsw") String userpsw);
	
		
	@GET
	@Path("/getUserLogout")
	Response getUserLogout(@QueryParam("access_token") String access_token);
	/**
	 * KGCheng
	 * @param cargoSrcPlace
	 * @param cargoDstPlace
	 * @param access_token
	 * @return
	 */
	@GET
	@Path("/searchCargoListbyPlace")
	Response searchCargoListbyPlace(@QueryParam("cargoSrcPlace") String cargoSrcPlace,@QueryParam("cargoDstPlace") String cargoDstPlace,@QueryParam("access_token") String access_token);
	
	/**
	 * KGCheng
	 * @param cargoCategory
	 * @param cargoWeight
	 * @param cargoVolume
	 * @param cargoSrcPlace
	 * @param cargoDstPlace
	 * @param cargoTurckType
	 * @param cargoOwnerName
	 * @param cargoOwnerPhone
	 * @param cargoPriceMin
	 * @param cargoPriceMax
	 * @param cargoUnitName
	 * @param cargoUnitPrice
	 * @param cargoEndTime  //格式为 yyyy-MM-dd HH:mm:ss
	 * @param access_token
	 * @return
	 */
	@POST
	@Path("/registerCargo")
	Response registerCargo(@FormParam("cargoCategory") String cargoCategory,
			@FormParam("cargoWeight") Double cargoWeight,
			@FormParam("cargoVolume") Double cargoVolume,
			@FormParam("cargoSrcPlace") String cargoSrcPlace,
			@FormParam("cargoDstPlace") String cargoDstPlace,
			@FormParam("cargoTurckType") String cargoTurckType,
			@FormParam("cargoOwnerName") String cargoOwnerName,
			@FormParam("cargoOwnerPhone") String cargoOwnerPhone,
			@FormParam("cargoPriceMin") Float cargoPriceMin,
			@FormParam("cargoPriceMax") Float cargoPriceMax,
			@FormParam("cargoUnitName") String cargoUnitName,
			@FormParam("cargoUnitPrice") Float cargoUnitPrice,
			@FormParam("cargoUnitPrice") String cargoDescription,	
			@FormParam("cargoEndTime") String cargoEndTime,
			@FormParam("access_token") String access_token);
	
	
	/**
	 * @author G.Liang
	 *
	 */
	@POST
	@Path("/registerUser")
	Response<UserInfo> registerUser(
			@FormParam("username") String username,
			@FormParam("userpsw") String userpsw,
			@FormParam("phone") String phone, 
			@FormParam("captcha") String captcha);

	
	/**
	 * @author G.Liang
	 *  注册时获取验证码
	 *  找回密码，获取新验证码
	 */
	@GET
	@Path("/getCaptcha/{phone}")
	Response<Captcha> getCaptcha(
			@PathParam("phone") String phone);
	
	/**
	 * @author G.Liang
	 *
	 */
	@GET
	@Path("/checkUserName/{username}")
	Response<String> checkUserName(
			@PathParam("username") String username);
	
	/**
	 * @author G.Liang
	 * 	 注册时，确认手机号
	 * 	 找回密码，确认手机号
	 */
	@GET
	@Path("/confirmPhone/{phone}")
	Response<String> confirmPhone(
			@PathParam("confirmPhone") String phone);
	
	/**
	 * @author G.Liang
	 * 	 找回密码，重置密码
	 */
	@POST
	@Path("/resetUserPsw")
	Response<String> resetUserPsw(
			@FormParam("phone") String phone,
			@FormParam("userpsw") String userpsw);
	


	
}
