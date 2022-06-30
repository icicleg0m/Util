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
			System.out.println("ó�� ����Ʈ�� ũ��");
		} else {
			System.out.println("�ι�° ����Ʈ�� ũ�ų� ����");
		}
		if(compareStringDate(date2, F_DATEMONTH_DASH, date1, F_DATEMONTH_DASH)) {
			System.out.println("ó�� ����Ʈ�� ũ��");
		} else {
			System.out.println("�ι�° ����Ʈ�� ũ�ų� ����");
		}
		if(compareStringDate(date2, F_DATEMONTH_DASH, date3, F_DATEDAY_DASH)) {
			System.out.println("ó�� ����Ʈ�� ũ��");
		} else {
			System.out.println("�ι�° ����Ʈ�� ũ�ų� ����");
		}
//		compareStringDate(date1, F_DATEMONTH_DASH, date1, F_DATEMONTH_DASH);
//		compareStringDate(date2, F_DATEMONTH_DASH, date1, F_DATEMONTH_DASH);
	}
	
	/**
	 * ��Ʈ�� ���ڿ� ������ Ȯ�� �ϴ� �Լ�
	 * ó�� ���ڰ� ū��츸 true ��ȯ
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
	 * ��Ʈ�� ������ ������ ������ ���� �Ѵ�.
	 * 
	 * @param date ������ �Է� ����
	 * @param inputFormat ������ �Է� ������ ���� ����
	 * @param outPutFormat �ⷰ ������ ���� ����
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
	 * ��� : format������ String����Ÿ�� java.util.Date�� ��ȯ
	 * 
	 * @param java.lang.String strDate �������� �Ǵ� date
	 * @param java.lang.String format String�� ����
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
	 * 1970�� 1�� 1�� 00�� 00�� 00�� �� �������� ������ ��¥������ �ʸ� ���Ѵ�.
	 * 
	 * @param sdate epochseconds�� ���� ��¥ yyyyMMdd ����
	 * @return epochseconds
	 * @throws ParseException
	 */
	public static String convertDateToEpoch(Date date) {
		return convertStringToEpoch(convertDateToString(date, F_DATEDAY_DASH), F_DATEMONTH_DASH);
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
	
}
