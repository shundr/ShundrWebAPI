
/**
* @project Event Extraction
* @author Dayong.Shen
* @package com.shundr.service
* @file CustomJsonMapper.java
* 
* @date 2014-4-16-下午12:45:21
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service.util;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Service;


/**
 * @project Event Extraction
 * @author Dayong.Shen
 * @class CustomJsonMapper
 * 
 * @date 2014-4-16-下午12:45:21
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */
@Service
public class CustomJsonMapper extends ObjectMapper {

	public CustomJsonMapper(){
		super();
		
		this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		this.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE , true);
		this.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
		
		this.getSerializationConfig().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}
	
}
