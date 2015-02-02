package org.imrul.business;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AuthorServiceImpl {
	
	public int getAuthorAge(int year, int month, int day){
		Calendar cal = new GregorianCalendar(year, month, day);
	    Calendar now = new GregorianCalendar();
	    int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
	    if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
	        || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) > now
	            .get(Calendar.DAY_OF_MONTH))) {
	      res--;
	    }
	    return res;
	}

}
