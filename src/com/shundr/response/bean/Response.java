
/**
* @project Twitter
* @author Dayong.Shen
* @package com.ithing.database.bean
* @file XmlResult.java
* 
* @date 2014-2-25-上午10:29:54
* @Copyright 2014 ISI Team of NUDT-版权所有
* 
*/
 
package com.shundr.response.bean;

import org.codehaus.jackson.map.annotate.JsonRootName;




/**
 * @project Twitter
 * @author Dayong.Shen
 * @class XmlResult
 * 
 * @date 2014-2-25-上午10:29:54
 * @Copyright 2014 ISI Team of NUDT-版权所有
 * @Version 1.0.0
 */
@JsonRootName("response")
public class Response<T> {

	/**
	 * 创建一个新的实例 XmlResult.
	 *
	 */
	public Response() {
		// TODO Auto-generated constructor stub
	}
	

	private String queryMethod;
	
	private String params;
	
	/**
	 * status: success 
	 *         fail	
	 */
	private String status;
	
	/**
	 * description 描述失败的原因
	 */
	private String description;
	
	
	
	/**
	 * numReturn 返回的对象的个数，如果返回的是list，则是list的中的对象个数
	 */
	private int numReturn;
	
	/**
	 * result 返回的对象
	 */
	private  T result;

	
	/**
	 * result
	 *
	 * @return  the result
	 * @since   1.0.0
	 */
	
	public T getResult() {
		return result;
	}

	/**
	 * @param status the status to set
	 */
	
	

	/**
	 * @param result the result to set
	 */
	
	public void setResult(T result) {
		this.result = result;
	}

	
	 /**
	 * numReturn
	 *
	 * @return  the numReturn
	 * @since   1.0.0
	 */
	
	public int getNumReturn() {
		return numReturn;
	}

	
	 /**
	 * @param numReturn the numReturn to set
	 */
	 
	public void setNumReturn(int numReturn) {
		this.numReturn = numReturn;
	}

	


	
	/**
	 * status
	 *
	 * @return  the status
	 * @since   1.0.0
	 */
	
	public String getStatus() {
		return status;
	}

	/**
	 * description
	 *
	 * @return  the description
	 * @since   1.0.0
	 */
	
	public String getDescription() {
		return description;
	}
	
	
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param description the description to set
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * params
	 *
	 * @return  the params
	 * @since   1.0.0
	 */
	
	public String getParams() {
		return params;
	}


	/**
	 * @param params the params to set
	 */
	
	public void setParams(String params) {
		this.params = params;
	}

	
	 /**
	 * queryMethod
	 *
	 * @return  the queryMethod
	 * @since   1.0.0
	 */
	
	public String getQueryMethod() {
		return queryMethod;
	}

	
	 /**
	 * @param queryMethod the queryMethod to set
	 */
	 
	public void setQueryMethod(String queryMethod) {
		this.queryMethod = queryMethod;
	}

	

}
