
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.service.util
* @file DateAdapter.java
* 
* @date 2014-2-19-下午2:39:44
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 * @project Twitter
 * @author Dayong.Shen
 * @class DateAdapter
 * 
 * @date 2014-2-19-下午2:39:44
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */

public class DateAdapter extends XmlAdapter<String, Date>{
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.parse(v);
    }
}
