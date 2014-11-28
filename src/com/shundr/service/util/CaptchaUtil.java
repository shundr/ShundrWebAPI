package com.shundr.service.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author G.Liang
 *
 */

public class CaptchaUtil {
	
	//���������λ����
	public static String getRandomCaptcha(){
		  Random rd = new Random();
		  String n="";
		  int getNum;
		  do {
		   getNum = Math.abs(rd.nextInt())%10 + 48;//��������0-9�������
		   //getNum = Math.abs(rd.nextInt())%26 + 97;//������ĸa-z�������
		   char num1 = (char)getNum;
		   String dn = Character.toString(num1);
		   n += dn;
		  } while (n.length()<6);
		  //System.out.println("�����6λ�����ǣ�" + n);
		  return n;
	}

	public static String getCaptcha(String phone,String captcha){
		
		String urlStr = "http://open.bizapp.com/api/sms/templateSend";
		URL url = null;
		HttpURLConnection connection = null;
		String paramStr = "appId=F0000035&tpId=2079632&customerId=C1011755&userId=U1013180&password=gl7758521&phones=";
		String param = paramStr+phone+"&fields=˳��||"+captcha+"||7894561||�۳��Ƽ�";
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.connect();

			//POST����ʱʹ��
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			
			pw.print(param);
			pw.flush();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gbk"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		
			reader.close();
			String b = "<resultCode>";
			int beginIndex = buffer.toString().indexOf(b);
			int endIndex = buffer.toString().indexOf("</resultCode>");
			String resultCode = buffer.toString().substring(beginIndex+b.length(), endIndex);
			return resultCode;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	
	/*private static String xmlResultParse(String xmlResult){
		Document doc;
		try {
			doc = DocumentHelper.parseText(xmlResult);
			Element root = doc.getRootElement();
			List<Element> deliverElements = root.elements("res");
			String resultCode = null;
			for(Element deliver:deliverElements){
				resultCode = deliver.elementText("resultCode");
			}				
			System.out.println(resultCode);
			return resultCode;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}*/
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		//String url = "http://open.bizapp.com/api/sms/templateSend";
		//String param = "13297499224";
		//String param = "appId=F0000035&tpId=2029167&customerId=C1011755&userId=U1013180&password=gl7758521&phones=13787262531&fields=˳��ƽ̨||54321||�Ʒ���";
		/*String fields = "&fields=˳��ƽ̨||54321||�Ʒ���";
		String fieldsGBK = java.net.URLEncoder.encode(fields,"gbk");*/
		//String paramStr = new String(param.getBytes(),"gbk");
		//String returnXml = getCaptcha(url, param);
		//System.out.println(returnXml);
	}
	
	
}
