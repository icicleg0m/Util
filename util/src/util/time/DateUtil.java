package util.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	// Data format Ÿ��
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
	 * epochseconds�� yyyyMMdd ���� ��¥�� ǥ���ϴ� string���� ��ȯ�Ѵ�.
	 * 
	 * @param sepoch epochseconds
	 * @return yyyy-MM-dd ���� ��¥�� ǥ���ϴ� string
	 * @throws Exception
	 */
	public static String convertEpochToDateString(String s) {
		return convertEpochToDateString(s, F_DATEDAY_DASH);
	}

	/**
	 * epochseconds�� �־��� dPattern ���� ��¥�� ǥ���ϴ� string���� ��ȯ�Ѵ�.
	 * 
	 * @param sepoch epochseconds
	 * @return dPattern ���� ��¥�� ǥ���ϴ� string
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
	 * 1970�� 1�� 1�� 00�� 00�� 00�� �� �������� ������ ��¥������ �ʸ� ���Ѵ�.
	 * 
	 * @param sdate epochseconds�� ���� ��¥ yyyyMMdd ����
	 * @return epochseconds
	 * @throws ParseException
	 */
	public static String convertStringToEpoch(String sdate) {
		return convertStringToEpoch(sdate, F_DATEDAY_NONE);
	}

	/**
	 * 1970�� 1�� 1�� 00�� 00�� 00�� �� �������� ������ ��¥������ �ʸ� ���Ѵ�.
	 * 
	 * @param sdate epochseconds�� ���� ��¥ yyyyMMdd ����
	 * @return epochseconds
	 * @throws ParseException
	 */
	public static String convertDateToEpoch(Date date) {
		return convertStringToEpoch(convertDateToString(date, F_DATEDAY_NONE), F_DATEDAY_NONE);
	}

	/**
	 * 1970�� 1�� 1�� 00�� 00�� 00�� �� �������� ������ ��¥������ �ʸ� ���Ѵ�.
	 * 
	 * @param sdate epochseconds�� ���� ��¥ Fromate
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
	 * ��� : ���� ��¥�� java.util.Date���·� ��´�.
	 * </pre>
	 * 
	 * @return java.util.Date
	 */
	public static java.util.Date getCurrentDate() {
		return new java.util.Date(System.currentTimeMillis());
	}

	/**
	 * <pre>
	 * ��� : ���� ��¥�� 0�� ������ �ð��� java.util.Date���·� ��´�.
	 * </pre>
	 * 
	 * @return java.util.Date
	 */
	public static java.util.Date getCurrentDateStartTime() {
		Calendar cal = Calendar.getInstance(); // ���ó�¥�� ���Ѵ�.
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * <pre>
	 * ��� : date�� �ش� ���� ���Ͽ� return
	 * </pre>
	 * 
	 * @param java.util.Date   date ������ �Ǵ� date
	 * @param java.lang.String ����Ÿ�� format
	 * @param int              ���� ��
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
	 * ��� : millisecond�� �ش� ���� ���Ͽ� return
	 * </pre>
	 * 
	 * @param log millisecond ������ �Ǵ� �ð�(�и�������)
	 * @param int dat ���� ��
	 * @return long
	 */
	public static long addDate(long millisecond, int dat) {
		long msSecondPerDate = 86400000;
		long addDate = dat * msSecondPerDate;
		return (millisecond + addDate);
	}

	/**
	 * <pre>
	 * ��� : millisecond�� �ش� ���� ���Ͽ� �������� format ������ ���ڿ� return
	 * </pre>
	 * 
	 * @param millisecond ������ �Ǵ� �ð�
	 * @param format      ����Ÿ�� format
	 * @param dat         ���� ��
	 * @return String
	 */
	public static String addDate(long millisecond, String format, int dat) {
		if (dat == 0)
			return convertMillisecondToStringo(millisecond, format);
		return convertMillisecondToStringo(addDate(millisecond, dat), format);
	}

	/**
	 * <pre>
	 * ��� : date�� �ش� ���� ���Ͽ� return
	 * </pre>
	 * 
	 * @param java.lang.String strDate ������ �Ǵ� date
	 * @param java.lang.String ����Ÿ�� format
	 * @param int              ���� ��
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
	 * ��� : date�� �ش� �ð��� ���Ͽ� return
	 * </pre>
	 * 
	 * @param java.util.Date   date ������ �Ǵ� date
	 * @param java.lang.String ����Ÿ�� format
	 * @param int              ���� �ð�
	 * @return java.lang.String
	 */
	public static java.util.Date addTime(java.util.Date date, int hour) {
		long time = date.getTime();

		// 1�ð��� �и��������� ȯ��
		// 3600000 = 60*60*1000;
		long msSecondPerHour = 3600000;
		long addTime = hour * msSecondPerHour;

		time = time + addTime;
		return new java.util.Date(time);
	}

	/**
	 * <pre>
	 * ��� : date�� �ش� ���� ���Ͽ� return
	 * </pre>
	 * 
	 * @param java.util.Date date ������ �Ǵ� date
	 * @param int            month ���� ��
	 * @return
	 */
	public static java.util.Date addMonth(java.util.Date date, int month) {
		java.util.Calendar cal = convertDateToCalendar(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	/**
	 * <pre>
	 * ��� : date�� �ش� �⵵�� ���Ͽ� return
	 * </pre>
	 * 
	 * @param java.util.Date date ������ �Ǵ� date
	 * @param int            year ���� �⵵
	 * @return
	 */
	public static java.util.Date addYear(java.util.Date date, int year) {
		java.util.Calendar cal = convertDateToCalendar(date);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	/**
	 * <pre>
	 * ��� : date�� �ش� �ð��� �Է� �޾Ƽ� Calender Ÿ������ ���� �Ѵ�.
	 * </pre>
	 * 
	 * @param java.util.Date date �Է� ����
	 * @return java.util.Calendar
	 */
	public static java.util.Calendar convertDateToCalendar(java.util.Date date) {
		java.util.Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * <pre>
	 * ��� : date�� �ش� �ð��� ���Ͽ� return
	 * </pre>
	 * 
	 * @param java.lang.String strDate ������ �Ǵ� date
	 * @param java.lang.String ����Ÿ�� format
	 * @param int              ���� �ð�
	 * @return java.lang.String
	 */
	public static String addTime(String strDate, String format, int hour) {
		java.util.Date date = convertStringToDate(strDate, format);
		java.util.Date newDate = addTime(date, hour);
		return convertDateToString(newDate, format);
	}

	/**
	 * <pre>
	 * ��� : format������ String����Ÿ�� java.util.Date�� ��ȯ
	 * </pre>
	 * 
	 * @param java.lang.String strDate �������� �Ǵ� date
	 * @param java.lang.String format String�� ����
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
	 * ��� : java.util.Date�� ����Ÿ�� format�� �°� String���� ��ȯ
	 * </pre>
	 * 
	 * @param java.util.Date   date �������� �Ǵ� date
	 * @param java.lang.String format String�� ����
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
	 * ������ �������� ������ ù°����(�Ͽ���)�� ���ڸ� �־��� ���˴�� �����Ѵ�.
	 * 
	 * @param format
	 * @return
	 */
	public static String getFirstDayOfWeek(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.KOREA); // ��¥������ ���Ѵ�.
		Calendar cal = Calendar.getInstance(); // ���ó�¥�� ���Ѵ�.

		cal.add(Calendar.DAY_OF_MONTH, -cal.get(Calendar.DAY_OF_WEEK) + 1); //
		return formatter.format(cal.getTime());
	}

	/**
	 * <pre>
	 * ��� : ���� ��¥�� String���·� ��´�.
	 * </pre>
	 * 
	 * @param String format ��¥ ���� - DateUtilŬ�������� ���� �Ǿ� �ִ� ��� ���
	 * @return java.lang.String
	 */
	public static String getCurrentDate(String format) {
		return getChangeDateFormat(getMillisecond(), format);
	}

	public static String convertMillisecondToStringo(long millisecond, String format) {
		return getChangeDateFormat(millisecond, format);
	}

	/**
	 * �и������� �ð��� �Է� �޾� ���� ������ Ÿ������ ���ڿ� ���� ���� �ش�.
	 * 
	 * @param millisecans
	 * @param format
	 * @return �ش� ������ �Է� �ð�
	 */
	public static String getChangeDateFormat(long millisecond, String format) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(format);
		return formatter.format(millisecond);
	}

	/**
	 * ���� �ð��� long Ÿ���� �и�������� ��´�.
	 * 
	 * @return long(Millisecond, 1,000���� 1��)
	 */
	public static long getMillisecond() {
		return System.currentTimeMillis();
	}
	
	/**
	 * ��Ʈ�� ������ ������ ������ ���� �Ѵ�.
	 * 
	 * @param date ������ �Է� ����
	 * @param inputFormat ������ �Է� ������ ���� ����
	 * @param outPutFormat �ⷰ ������ ���� ����
	 * @return String
	 */
	public static String convertStringDateFromat(String date, String inputFormat, String outPutFormat) {
		// �Է� �ڷ� Ȯ��
		if (date == null || "".equals(date) || inputFormat == null || "".equals(inputFormat) || outPutFormat == null
				|| "".equals(outPutFormat)) {
			return null;
		}
		return convertDateToString(convertStringToDate(date, inputFormat), outPutFormat);
	}
}
