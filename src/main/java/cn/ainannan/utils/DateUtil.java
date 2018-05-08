package cn.ainannan.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 获取当前日期的零时零分零秒
	 * @return
	 */
	public static Date getCurrDateFirst() {
		return getDateFirst(new Date());
	}
	
	/**
	 * 获取指定日期的零时零分零秒
	 * @param date
	 * @return
	 */
	public static Date getDateFirst(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date zero = calendar.getTime();
		return zero;
	}
	
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCurrDateFirst()));
	}
}
