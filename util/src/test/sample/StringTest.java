package test.sample;

import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		String str = "<p>A-SPICE 기준 개발 산출물 모두 준비 저장 테스트<td></p><br><BR><p>저장 테스트</p>";
		Pattern pattern = Pattern.compile("<(/)?(p)(\\s)*(/)?>", Pattern.CASE_INSENSITIVE);
		Pattern pattern2 = Pattern.compile("<(br)(\\s)*(/)?>", Pattern.CASE_INSENSITIVE);

		String str2 = pattern.matcher(str).replaceAll("");
		String str3 = pattern2.matcher(str).replaceAll("");

		System.out.println(str2);
		System.out.println(str3);

		System.out.println(Pattern.compile("<(/)?(p)(\\s)*(/)?>", Pattern.CASE_INSENSITIVE)
				.matcher(Pattern.compile("<(br)(\\s)*(/)?>", Pattern.CASE_INSENSITIVE).matcher(str).replaceAll(""))
				.replaceAll(""));

		// str.replaceAll(Pattern.compile("<(p)(\\s)*(/)?>", Pattern.CASE_INSENSITIVE),
		// "");
		// _removeTagMap.put(Pattern.compile("<(p)(\\s)*(/)?>",
		// Pattern.CASE_INSENSITIVE), "\n"); // 2011-10-25
		// System.out.println(Pattern.compile("<(p)(\\s)*(/)?>",
		// Pattern.CASE_INSENSITIVE));

	}

}
