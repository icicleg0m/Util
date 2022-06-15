package test.sample;

import java.util.regex.Pattern;

public class StringTest {

	public static void main(String[] args) {
		String str = "<p>A-SPICE ���� ���� ���⹰ ��� �غ� ���� �׽�Ʈ<td></p><br><BR><p>���� �׽�Ʈ</p>";
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
