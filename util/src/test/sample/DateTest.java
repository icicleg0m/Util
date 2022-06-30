package test.sample;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {
	
	public final static String F_DATEDAY_DASH = "yyyy-MM-dd";
	public final static String F_DATEMONTH_DASH = "yyyy-MM";
	
	
	public static void main(String[] args) {
		String date1 = "2022-02";
		String date2 = "2022-05";
		String date3 = "2022-05-01";
		String date4 = "";
		String date5 = "";
		String date6 = "";
		
		
		System.out.println(convertStringDateFromat(date1,F_DATEMONTH_DASH, F_DATEDAY_DASH));
		if(compareStringDate(date1, F_DATEMONTH_DASH, date2, F_DATEMONTH_DASH)) {
			System.out.println("처음 데이트가 크다");
		} else {
			System.out.println("두번째 데이트가 크거나 같다");
		}
		if(compareStringDate(date2, F_DATEMONTH_DASH, date1, F_DATEMONTH_DASH)) {
			System.out.println("처음 데이트가 크다");
		} else {
			System.out.println("두번째 데이트가 크거나 같다");
		}
		if(compareStringDate(date2, F_DATEMONTH_DASH, date3, F_DATEDAY_DASH)) {
			System.out.println("처음 데이트가 크다");
		} else {
			System.out.println("두번째 데이트가 크거나 같다");
		}
//		compareStringDate(date1, F_DATEMONTH_DASH, date1, F_DATEMONTH_DASH);
//		compareStringDate(date2, F_DATEMONTH_DASH, date1, F_DATEMONTH_DASH);
	}
	
	/**
	 * 스트링 문자와 포멧을 확인 하는 함수
	 * 처음 문자가 큰경우만 true 반환
	 * 
	 * @param firstDate
	 * @param firstFormat
	 * @param secondDate
	 * @param secondFormat
	 * @return
	 */
	public static boolean compareStringDate(String firstDate, String firstFormat, String secondDate, String secondFormat) {
		if(firstDate == null || "".equals(firstDate) || firstFormat == null || "".equals(firstFormat) || 
				secondDate == null || "".equals(secondDate) || secondFormat == null || "".equals(secondFormat) ) {
			return false;
		}
		if(convertStringToDate(firstDate, firstFormat).compareTo(convertStringToDate(secondDate, secondFormat)) == -1) {
			return false;
		} else if(convertStringToDate(firstDate, firstFormat).compareTo(convertStringToDate(secondDate, secondFormat)) == 0) {
			return false;
		}
		return true;
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
		if (date == null || "".equals(date) || inputFormat == null || "".equals(inputFormat) || outPutFormat == null
				|| "".equals(outPutFormat)) {
			return null;
		}
		return convertDateToString(convertStringToDate(date, inputFormat), outPutFormat);
	}
	
	/**
	 * 기능 : format형태인 String데이타를 java.util.Date로 변환
	 * 
	 * @param java.lang.String strDate 변경대상이 되는 date
	 * @param java.lang.String format String의 포맷
	 * @return java.util.Date
	 */
	public static java.util.Date convertStringToDate(String strDate, String format) {
		if (strDate == null || strDate.length() == 0) {
			return null;
		}
		try {
			SimpleDateFormat fmt = new SimpleDateFormat(format);
			return fmt.parse(strDate, new ParsePosition(0));
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 1970년 1월 1일 00시 00분 00초 를 기준으로 지정된 날짜까지의 초를 구한다.
	 * 
	 * @param sdate epochseconds를 구할 날짜 yyyyMMdd 형식
	 * @return epochseconds
	 * @throws ParseException
	 */
	public static String convertDateToEpoch(Date date) {
		return convertStringToEpoch(convertDateToString(date, F_DATEDAY_DASH), F_DATEMONTH_DASH);
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
	
}
