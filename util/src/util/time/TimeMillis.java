package util.time;

import java.text.SimpleDateFormat;

public class TimeMillis {

	public static void main(String args[]) {
		long startTime = 0;
		long endTime = 0;
		long diffTime = 0;

		startTime = System.currentTimeMillis();
		// 특정 작업 수행
		endTime = System.currentTimeMillis();
		diffTime = endTime - startTime;
		System.out.println(diffTime + "ms" + "~~" + startTime);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS"); // SSS가 밀리세컨드 표시

		System.out.println(dateFormat.format(System.currentTimeMillis()));
	}

}
