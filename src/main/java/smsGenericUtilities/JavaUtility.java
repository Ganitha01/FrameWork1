package smsGenericUtilities;
/**
 * 
 * @author ANITHA
 *
 */

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method will return a random number from 1 to 1000
	 * @return
	 */
	public int getRandomNumber()
	{
	Random random=new Random();
	int ranNo=random.nextInt(10000);
	return ranNo;
	}
	/**
	 * this method will return the currtn sysytem date
	 * @return
	 */
	public String getCurrentSystemDate()
	{
		Date date=new Date();
		String currenDate=date.toString();
		return currenDate;
	}
	/**
	 * this method will return the current date in required format
	 * @param format
	 * @return
	 */
	public String getCurrentSystemDateInFormat(String format)
	{
		Date dat=new Date();
		String d[]=dat.toString().split(" ");
		String day=d[0];
		String month=d[1];
		int integerMonth=dat.getMonth();
		integerMonth++;
		String date=d[2];
		String time=d[3];
		String year=d[5];
		if(format.contains("d-m(nubmer)-y"))
		{
			String currentDate=day+"-"+integerMonth+"-"+year;
			return currentDate;
		}else if(format.contains("day-month-year"))
		{
			String currentDate=day+"-"+month+"-"+year;
			return currentDate;
		}
		else if(format.contains("day/month/year"))
		{
			String currentDate=d[0]+"/"+month+"/"+year;
			return currentDate;
		}
		else
		{
			String currentDate=year+"-"+"0"+integerMonth+"-"+date;
			return currentDate;
		}
	}

}
