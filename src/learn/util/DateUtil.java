package learn.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//
	private static SimpleDateFormat sdfFile = new SimpleDateFormat("yyyyMMddhhmmss");
	//
	private static SimpleDateFormat sdf_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Date getDateAfterStringBySECONDs(Date d, int second) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.SECOND, now.get(Calendar.SECOND) + second);//+后 -前
		Date date =now.getTime();
		return date;
	}
	
	//字符串转日期,年月日时分秒
	public static Date getDateHMS(String str)throws Exception{
		return sdf_time.parse(str);
	}
	//字符串转成日期,年月日
	public static Date getDate(String dateStr) throws Exception{
		return sdf.parse(dateStr);
	}
	
	//字符串转成日期
	public static String getStringDate(Date date) throws Exception{
		return sdf.format(date);
	}
	//字符串转成日期
	public static String getStringDateTime(Date date) throws Exception{
		return sdfFile.format(date);
	}
	
	//字符串转成日期
	public static String DateTimeToString(Date date) throws Exception{
		return sdf_time.format(date);
	}
	
	//字符串转成日期
	public static Timestamp getChangeDateTime(String date) throws Exception{
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(date);
		return ts;
	}
	
	//字符串转成日期
	public static Timestamp getDateTime() throws Exception{
		Date date = new Date();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String date1 = sdf_time.format(date);
		ts = Timestamp.valueOf(date1);
		return ts;
	}
	
	//字符串转成详细日期
	public static Timestamp getStringDateTime(String date) throws Exception{
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(date);
		return ts;
	}
	
	public static Date getNewEndTime(double hours) throws Exception{
		Date date = new Date();
	    date.setTime(date.getTime() + Math.round(hours*60*60*1000));
	    return date;
	} 
	
	//比较两个时间的大小
	public static boolean getTimeResult(Date start,Date end) throws Exception{
		long sts = 	start.getTime();
		long ste = end.getTime();
		if(sts>ste) {
			//前边大于后边
			return true;
		}else {
			return false;
		}
		
	}
/**
 * 得到几天后的时间
 *
 * @param d
 * @param day
 * @return
 */
public static Date getDateAfter(Date d, int day) {
    Calendar now = Calendar.getInstance();
    now.setTime(d);
    now.set(Calendar.DATE, now.get(Calendar.DATE) + day);//+后 -前
    return now.getTime();
}
public static String getDateAfterString(Date d, int day) {
    Calendar now = Calendar.getInstance();
    now.setTime(d);
    now.set(Calendar.DATE, now.get(Calendar.DATE) + day);//+后 -前
    Date date =now.getTime();
    return sdf_time.format(date);
}
/**
 * 得到几分钟后时间
 */
 public static String getDateAfterStringByMINUTE(Date d, int min) {
	    Calendar now = Calendar.getInstance();
	    now.setTime(d);
	    now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + min);//+后 -前
	    Date date =now.getTime();
	    return sdf_time.format(date);
	}
 public static Date getDateAfterStringByMINUTEs(Date d, int min) {
	    Calendar now = Calendar.getInstance();
	    now.setTime(d);
	    now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + min);//+后 -前
	    Date date =now.getTime();
	    return date;
	}
//几天前时间
	public static Date getDateBefore(Date d, int day) {
	    Calendar now = Calendar.getInstance();
	    now.setTime(d);
	    now.set(Calendar.DATE, now.get(Calendar.DATE) - day);//+后 -前
	    return now.getTime();
	}
	//几天前时间
		public static String getDateBeforeToString(Date d, int day) {
		    Calendar now = Calendar.getInstance();
		    now.setTime(d);
		    now.set(Calendar.DATE, now.get(Calendar.DATE) - day);//+后 -前
		    Date date = now.getTime();
		    return sdf_time.format(date);
		}
 //当前时间转unix时间戳类型
 public static Long timeChangeTimestamp(Date date) {
	 
	  //普通时间 转换 Unix timestamp  
    // DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
     long epoch = date.getTime()/1000;               //  获得 unix timestamp
     System.out.println("2016-3-1 unix stamp is "+ epoch);   
     return epoch; 
      
 }  
 //unix timestamp转data
 public static Date TimestampChangeData(Long date) {
	// unix timestamp 转换 普通时间
     Date d2  = new Date(date * 1000);
     return d2;
 }
 //两个时间时间差
 public static String getDateResult(Date date1 , Date date2) {
	 
	    try  
	    {  
	      Date d1 = date1;
	      Date d2 = date2;
	      long diff = d1.getTime() - d2.getTime();//这样得到的差值是毫秒级别  
	      long days = diff / (1000 * 60 * 60 * 24);  
	   
	      long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
	      long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);  
	      System.out.println(""+days+"天"+hours+"小时"+minutes+"分"); 
	      String result = ""+days+"天"+hours+"小时"+minutes+"分";
	      return result;
	    }catch (Exception e)  {  
	    }
	    return  "";
 }
 
 public static double getAddResult(double a,double b){
	BigDecimal aprice = new BigDecimal(Double.toString(a));
	BigDecimal bprice = new BigDecimal(Double.toString(b));
	return aprice.add(bprice).doubleValue();
 }
 
 public static double getSubtractResult(double a,double b){
		BigDecimal aprice = new BigDecimal(Double.toString(a));
		BigDecimal bprice = new BigDecimal(Double.toString(b));
		return aprice.subtract(bprice).doubleValue();
	 }
	
}

