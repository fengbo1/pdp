package pdp.util;

import java.math.BigDecimal;

public class Util {
	//public static final String downloadpath ="C:/Program Files (x86)/Apache Software Foundation/Tomcat 7.0/webapps/performance/derive/";
	public static final String downloadpath ="C:/Program Files/apache-tomcat-7.0.59/webapps/pdp/derive/";
	public static final int pagesize = 15;
	/**
	 *double保留小数点后两位 
	 *
	 */
	public static String DoubleTo2(Double num)
	{
		String result="-";
		double temp;
		if(num==null||num.equals("null")||num.SIZE<1)
		{
			result = "-";
		}
		else
		{
			BigDecimal b = new BigDecimal(num+0.00000001);  
			temp = b.setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
			if(temp<0.000001&&temp>-0.000001)
			{
				result = "-";
			}
			else
			{
				result = String.valueOf(temp);
			}
		}
		return result;
	}
	
	public static String NormToString(String norm)
	{
		String result = "";
		if(norm==null)
		{
			
		}
		else if(norm.equals("norma"))
		{
			result = "关键业务指标";
		}
		else if(norm.equals("norma"))
		{
			result = "关键任务指标";
		}
		else if(norm.equals("norma"))
		{
			result = "品能目标";
		}
		else if(norm.equals("norma"))
		{
			result = "加分项";
		}
		else
		{
			
		}
		return result;
	}
	public static String ChuToString(String chu)
	{
		String result = "";
		if(chu==null)
		{
			
		}
		else if(chu.equals("1"))
		{
			result = "综合与生产管理处";
		}
		else if(chu.equals("2"))
		{
			result = "合规与监督二处";
		}
		else if(chu.equals("3"))
		{
			result = "通用业务二处";
		}
		else if(chu.equals("5"))
		{
			result = "研发支持二处";
		}
		else if(chu.equals("6"))
		{
			result = "专业处理二处";
		}
		
		return result;
	}
}
