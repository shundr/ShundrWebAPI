
/**
* @project Event Extraction
* @author Dayong.Shen
* @package com.shundr.service
* @file FileServiceImpl.java
* 
* @date 2014-4-7-下午3:07:54
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;
/**
 * @project Event Extraction
 * @author Dayong.Shen
 * @class FileServiceImpl
 * 
 * @date 2014-4-7-下午3:07:54
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */
@Service
public class FileServiceImpl implements FileService {
	 private static final String FILE_PATH = "C:\\Server\\TwitterUserHead";

	@Override
	public Response getUserHeadPhoto(String userId) {
		
		 File file=null;
		
		try{
	       file = new File(FILE_PATH+"\\"+userId+".jpg");
	       
	       if(!file.exists()){
	    	 //defualtHeadPhoto
	    	   file = new File(FILE_PATH+"\\"+"defualtHeadPhoto.jpg");
	       }
	       
		}catch(Exception ex){
			
		  
		}
	      
	      ResponseBuilder response = Response.ok((Object) file);
	      response.header("Content-Disposition", "attachment; filename="+userId+".png");
	      return response.build();
	   }

    /*
	@Override
	 public Response uploadFile(List<Attachment> attachments, @Context HttpServletRequest request) {
	      for (Attachment attachment : attachments) {
	         DataHandler handler = attachment.getDataHandler();
	         try {
	            InputStream stream = handler.getInputStream();
	            MultivaluedMap<String, String> map = attachment.getHeaders();
	            System.out.println("fileName Here" + getFileName(map));
	            OutputStream out = new FileOutputStream(new File("C:/uploads/" + getFileName(map)));

	            int read = 0;
	            byte[] bytes = new byte[1024];
	            while ((read = stream.read(bytes)) != -1) {
	               out.write(bytes, 0, read);
	            }
	            stream.close();
	            out.flush();
	            out.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }

	      return Response.ok("file uploaded").build();
	   }

	   private String getFileName(MultivaluedMap<String, String> header) {
	      String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
	      for (String filename : contentDisposition) {
	         if ((filename.trim().startsWith("filename"))) {
	            String[] name = filename.split("=");
	            String exactFileName = name[1].trim().replaceAll("\"", "");
	            return exactFileName;
	         }
	      }
	      return "unknown";
	   }
	   */
	   
}
