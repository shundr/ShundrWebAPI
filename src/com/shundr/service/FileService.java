
/**
* @project Event Extraction
* @author Dayong.Shen
* @package com.shundr.service
* @file FileService.java
* 
* @date 2014-4-7-下午3:07:25
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

/**
 * @project Event Extraction
 * @author Dayong.Shen
 * @class FileService
 * 
 * @date 2014-4-7-下午3:07:25
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */

public interface FileService {
	   @GET
	   @Path("/getUserHeadPhoto/{userId}")
	   @Produces("image/jpg")
	   public Response getUserHeadPhoto(
			   @PathParam("userId") String userId);
	   
	   /*
	   @POST
	   @Path("/uploadFile")
	   @Consumes(MediaType.MULTIPART_FORM_DATA)
	   public Response uploadFile(List<Attachment> attachments, @Context HttpServletRequest request);
	   */
}
