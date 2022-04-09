package util.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	// Data format 타입
	static final String pattern = "yyyyMMdd_HHmmss_SSSSS";
	public final static String F_DATE_REVERSE_SLASH = "dd/MM/yyyy";
	public final static String F_DATEMONTH_NONE = "yyyyMM";
	public final static String F_DATEDAY_NONE = "yyyyMMdd";
	public final static String F_DATEDAY_DASH = "yyyy-MM-dd";
	public final static String F_DATEHOUR_NONE = "yyyyMMddHH";
	public final static String F_DATEMINUTE_NONE = "yyyyMMddHHmm";
	public final static String F_DATETIME_NONE = "yyyyMMddHHmmss";
	public final static String F_DATETIMEMS_NONE = "yyyyMMddHHmmssSSS";
	public final static String F_TIMEMINUTE_NONE = "HHmm";
	public final static String F_YEAR = "yyyy";
	public final static String F_MONTH = "MM";
	public final static String F_DAY = "dd";

	public static void main(String args[]) {

		//
//		System.out.println(convertDateToString(addDate(getCurrentDate(), -7), F_DATEDAY_DASH));
//		System.out.println(convertDateToString(addDate(getCurrentDate(), -90), F_DATEDAY_DASH));
//		System.out.println(convertDateToString(addMonth(getCurrentDate(), -1), F_DATEDAY_DASH));
//		System.out.println(convertDateToString(addMonth(getCurrentDate(), -9), F_DATEDAY_DASH));
//		System.out.println(convertDateToString(addYear(getCurrentDate(), -7), F_DATEDAY_DASH));
//		System.out.println(convertDateToString(addYear(getCurrentDate(), -100), F_DATEDAY_DASH));

		System.out.println(convertDateToString(addDate(getCurrentDate(), -1), pattern));
		System.out.println(convertDateToString(addDate(getCurrentDateStartTime(), -1), pattern));

//		System.out.println(convertStringToEpoch("20200717"));
//		System.out.println(convertEpochToDateString(convertStringToEpoch("20200717"), F_DATEDAY_NONE));
//		System.out.println(convertEpochToDateString(convertStringToEpoch("20200717")));
	}

	/**
	 * epochseconds를 yyyyMMdd 형의 날짜를 표현하는 string으로 변환한다.
	 * 
	 * @param sepoch epochseconds
	 * @return yyyy-MM-dd 형의 날짜를 표현하는 string
	 * @throws Exception
	 */
	public static String convertEpochToDateString(String s) {
		return convertEpochToDateString(s, F_DATEDAY_DASH);
	}

	/**
	 * epochseconds를 주어진 dPattern 형의 날짜를 표현하는 string으로 변환한다.
	 * 
	 * @param sepoch epochseconds
	 * @return dPattern 형의 날짜를 표현하는 string
	 * @throws Exception
	 */
	public static String convertEpochToDateString(String s, String dPattern) {
		String s1 = "";
		String s2 = "";

		if (!"0".equals(s)) {
			Long long1 = new Long(s);
			long l = long1.longValue() * (long) Math.pow(10, 13 - s.length());
			Date date = new Date(l);
			SimpleDateFormat simpledateformat = new SimpleDateFormat(dPattern, new Locale("ko", "KOREA"));
			s2 = simpledateformat.format(date);
		}
		s1 = s2;
		return s1;
	}

	/**
	 * 1970년 1월 1일 00시 00분 00초 를 기준으로 지정된 날짜까지의 초를 구한다.
	 * 
	 * @param sdate epochseconds를 구할 날짜 yyyyMMdd 형식
	 * @return epochseconds
	 * @throws ParseException
	 */
	public static String convertStringToEpoch(String sdate) {
		return convertStringToEpoch(sdate, F_DATEDAY_NONE);
	}

	/**
	 * 1970년 1월 1일 00시 00분 00초 를 기준으로 지정된 날짜까지의 초를 구한다.
	 * 
	 * @param sdate epochseconds를 구할 날짜 yyyyMMdd 형식
	 * @return epochseconds
	 * @throws ParseException
	 */
	public static String convertDateToEpoch(Date date) {
		return convertStringToEpoch(convertDateToString(date, F_DATEDAY_NONE), F_DATEDAY_NONE);
	}

	/**
	 * 1970년 1월 1일 00시 00분 00초 를 기준으로 지정된 날짜까지의 초를 구한다.
	 * 
	 * @param sdate epochseconds를 구할 날짜 Fromate
	 * @return epochseconds
	 * @throws ParseException
	 */
	public static String convertStringToEpoch(String sdate, String datePattern) {
		String s1 = new String("");
		SimpleDateFormat simpledateformat = new SimpleDateFormat(datePattern);
		Date date = new Date();
		try {
			date = simpledateformat.parse(sdate);
			long l = date.getTime() / 1000L;
			Long long1 = new Long(l);
			s1 = long1.toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return s1;
	}

	/**
	 * <pre>
	 * 기능 : 현재 날짜를 java.util.Date형태로 얻는다.
	 * </pre>
	 * 
	 * @return java.util.Date
	 */
	public static java.util.Date getCurrentDate() {
		return new java.util.Date(System.currentTimeMillis());
	}

	/**
	 * <pre>
	 * 기능 : 현재 날짜의 0시 정각의 시간를 java.util.Date형태로 얻는다.
	 * </pre>
	 * 
	 * @return java.util.Date
	 */
	public static java.util.Date getCurrentDateStartTime() {
		Calendar cal = Calendar.getInstance(); // 오늘날짜를 구한다.
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * <pre>
	 * 기능 : date에 해당 일을 더하여 return
	 * </pre>
	 * 
	 * @param java.util.Date   date 기준이 되는 date
	 * @param java.lang.String 데이타의 format
	 * @param int              더할 일
	 * @return java.lang.String
	 */
	public static java.util.Date addDate(java.util.Date date, int dat) {
		if (dat == 0)
			return date;
		long time = date.getTime();

		long msSecondPerDate = 86400000;
		long addDate = dat * msSecondPerDate;
		time = time + addDate;
		return new java.util.Date(time);
	}

	/**
	 * <pre>
	 * 기능 : millisecond에 해당 일을 더하여 return
	 * </pre>
	 * 
	 * @param log millisecond 기준이 되는 시간(밀리세컨드)
	 * @param int dat 더할 일
	 * @return long
	 */
	public static long addDate(long millisecond, int dat) {
		long msSecondPerDate = 86400000;
		long addDate = dat * msSecondPerDate;
		return (millisecond + addDate);
	}

	/**
	 * <pre>
	 * 기능 : millisecond에 해당 일을 더하여 데이터의 format 형식의 문자열 return
	 * </pre>
	 * 
	 * @param millisecond 기준이 되는 시간
	 * @param format      데이타의 format
	 * @param dat         더할 일
	 * @return String
	 */
	public static String addDate(long millisecond, String format, int dat) {
		if (dat == 0)
			return convertMillisecondToStringo(millisecond, format);
		return convertMillisecondToStringo(addDate(millisecond, dat), format);
	}

	/**
	 * <pre>
	 * 기능 : date에 해당 일을 더하여 return
	 * </pre>
	 * 
	 * @param java.lang.String strDate 기준이 되는 date
	 * @param java.lang.String 데이타의 format
	 * @param int              더할 일
	 * @return java.lang.String
	 */
	public static String addDate(String strDate, String format, int dat) {
		if (dat == 0)
			return strDate;
		java.util.Date date = convertStringToDate(strDate, format);
		java.util.Date newDate = addDate(date, dat);
		return convertDateToString(newDate, format);
	}

	/**
	 * <pre>
	 * 기능 : date에 해당 시간을 더하여 return
	 * </pre>
	 * 
	 * @param java.util.Date   date 기준이 되는 date
	 * @param java.lang.String 데이타의 format
	 * @param int              더할 시간
	 * @return java.lang.String
	 */
	public static java.util.Date addTime(java.util.Date date, int hour) {
		long time = date.getTime();

		// 1시간을 밀리세컨으로 환산
		// 3600000 = 60*60*1000;
		long msSecondPerHour = 3600000;
		long addTime = hour * msSecondPerHour;

		time = time + addTime;
		return new java.util.Date(time);
	}

	/**
	 * <pre>
	 * 기능 : date에 해당 월을 더하여 return
	 * </pre>
	 * 
	 * @param java.util.Date date 기준이 되는 date
	 * @param int            month 다할 월
	 * @return
	 */
	public static java.util.Date addMonth(java.util.Date date, int month) {
		java.util.Calendar cal = convertDateToCalendar(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	/**
	 * <pre>
	 * 기능 : date에 해당 년도를 더하여 return
	 * </pre>
	 * 
	 * @param java.util.Date date 기준이 되는 date
	 * @param int            year 더할 년도
	 * @return
	 */
	public static java.util.Date addYear(java.util.Date date, int year) {
		java.util.Calendar cal = convertDateToCalendar(date);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	/**
	 * <pre>
	 * 기능 : date에 해당 시간을 입력 받아서 Calender 타입으로 변경 한다.
	 * </pre>
	 * 
	 * @param java.util.Date date 입력 일자
	 * @return java.util.Calendar
	 */
	public static java.util.Calendar convertDateToCalendar(java.util.Date date) {
		java.util.Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * <pre>
	 * 기능 : date에 해당 시간을 더하여 return
	 * </pre>
	 * 
	 * @param java.lang.String strDate 기준이 되는 date
	 * @param java.lang.String 데이타의 format
	 * @param int              더할 시간
	 * @return java.lang.String
	 */
	public static String addTime(String strDate, String format, int hour) {
		java.util.Date date = convertStringToDate(strDate, format);
		java.util.Date newDate = addTime(date, hour);
		return convertDateToString(newDate, format);
	}

	/**
	 * <pre>
	 * 기능 : format형태인 String데이타를 java.util.Date로 변환
	 * </pre>
	 * 
	 * @param java.lang.String strDate 변경대상이 되는 date
	 * @param java.lang.String format String의 포맷
	 * @return java.util.Date
	 */
	public static java.util.Date convertStringToDate(String strDate, String format) {
		if (strDate == null || strDate.length() == 0) {
			return null;
		}
		/*
		 * if (strDate.length() != format.length()) { return null; }
		 */
		try {
			SimpleDateFormat fmt = new SimpleDateFormat(format);
			return fmt.parse(strDate, new ParsePosition(0));
		} catch (Exception e) {
			// logger.debug("DateUtil.convertStringToDate : Exception" + e.getMessage());
			return null;
		}
	}

	/**
	 * <pre>
	 * 기능 : java.util.Date인 데이타를 format에 맞게 String으로 변환
	 * </pre>
	 * 
	 * @param java.util.Date   date 변경대상이 되는 date
	 * @param java.lang.String format String의 포맷
	 * @return java.lang.String
	 */
	public static String convertDateToString(java.util.Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 오늘을 기준으로 금주의 첫째요일(일요일)의 일자를 주어진 포맷대로 리턴한다.
	 * 
	 * @param format
	 * @return
	 */
	public static String getFirstDayOfWeek(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA); // 날짜포맷을 정한다.
		Calendar cal = Calendar.getInstance(); // 오늘날짜를 구한다.

		cal.add(Calendar.DAY_OF_MONTH, -cal.get(Calendar.DAY_OF_WEEK) + 1); //
		return formatter.format(cal.getTime());
	}

	/**
	 * <pre>
	 * 기능 : 현재 날짜를 String형태로 얻는다.
	 * </pre>
	 * 
	 * @param String format 날짜 포맷 - DateUtil클래스내에 정의 되어 있는 상수 사용
	 * @return java.lang.String
	 */
	public static String getCurrentDate(String format) {
		return getChangeDateFormat(getMillisecond(), format);
	}

	public static String convertMillisecondToStringo(long millisecond, String format) {
		return getChangeDateFormat(millisecond, format);
	}

	/**
	 * 밀리세컨드 시간을 입력 받아 선택 포멧의 타입으로 문자열 값을 돌려 준다.
	 * 
	 * @param millisecans
	 * @param format
	 * @return 해당 포맷은 입력 시간
	 */
	public static String getChangeDateFormat(long millisecond, String format) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
		return formatter.format(millisecond);
	}

	/**
	 * 현제 시간을 long 타입의 밀리세컨드로 얻는다.
	 * 
	 * @return long(Millisecond, 1,000분의 1초)
	 */
	public static long getMillisecond() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 스트링 문자의 데이터 포멧을 변경 한다.
	 * 
	 * @param date 데이터 입력 문자
	 * @param inputFormat 데이터 입력 문자의 포멧 형식
	 * @param outPutFormat 출럭 데이터 포멧 형식
	 * @return String
	 */
	public static String convertStringDateFromat(String date, String inputFormat, String outPutFormat) {
		// 입력 자료 확인
		if (date == null || "".equals(date) || inputFormat == null || "".equals(inputFormat) || outPutFormat == null
				|| "".equals(outPutFormat)) {
			return null;
		}
		return convertDateToString(convertStringToDate(date, inputFormat), outPutFormat);
	}
}
