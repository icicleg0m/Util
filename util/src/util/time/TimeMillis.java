package util.time;

import java.text.SimpleDateFormat;

public class TimeMillis {

	public static void main(String args[]) {
		long startTime = 0;
		long endTime = 0;
		long diffTime = 0;

		startTime = System.currentTimeMillis();
		// Ư�� �۾� ����
		endTime = System.currentTimeMillis();
		diffTime = endTime - startTime;
		System.out.println(diffTime + "ms" + "~~" + startTime);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS"); // SSS�� �и������� ǥ��

		System.out.println(dateFormat.format(System.currentTimeMillis()));
	}

}
