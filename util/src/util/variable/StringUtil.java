package util.variable;

import java.util.HashSet;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	// Ư�� ���� �� �ױ� ������.
	private static String _sSystemInfo;
	private static LinkedHashMap<Pattern, String> _removeTagMap = new LinkedHashMap<Pattern, String>();
	
	private static String specialCharacter = "[!@#$%^&*(),.?\\\":\\[\\]{}|<>/;~]";

	static {
		Properties systemProperties = System.getProperties();
		_sSystemInfo = systemProperties.getProperty("os.name") + " [" + systemProperties.getProperty("os.arch")
				+ "-ver:" + " " + systemProperties.getProperty("os.version") + "]  "
				+ systemProperties.getProperty("java.vendor") + systemProperties.getProperty("java.version");

		_removeTagMap.put(Pattern.compile("&lt;"), "<");
		_removeTagMap.put(Pattern.compile("&gt;"), ">");
		_removeTagMap.put(Pattern.compile("&nbsp;"), " ");
		_removeTagMap.put(Pattern.compile("&amp;"), "&");
		_removeTagMap.put(Pattern.compile("&quot;"), "\"");
		_removeTagMap.put(Pattern.compile("&apos;"), "\'");

//        _removeTagMap.put(Pattern.compile("<!--.*-->"), "");
		_removeTagMap.put(Pattern.compile("<!--.*?-->"), ""); // 2011-10-25
		_removeTagMap.put(Pattern.compile("&[\\w ]{1,4};"), "");
//        _removeTagMap.put(Pattern.compile("<br[^>]*>",Pattern.CASE_INSENSITIVE), "\n");
		_removeTagMap.put(Pattern.compile("<(br)(\\s)*(/)?>", Pattern.CASE_INSENSITIVE), "\n"); // 2011-10-25
//        _removeTagMap.put(Pattern.compile("<p[^>]*>",Pattern.CASE_INSENSITIVE), "\n");
		_removeTagMap.put(Pattern.compile("<(p)(\\s)*(/)?>", Pattern.CASE_INSENSITIVE), "\n"); // 2011-10-25
		_removeTagMap.put(Pattern.compile("<_?(script)(.*)</\\1(?>[^>]*)>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL),
				"");
		_removeTagMap.put(
				Pattern.compile("<_?(style)(?>[^<]*)</\\1(?>[^>]*)>", Pattern.CASE_INSENSITIVE | Pattern.DOTALL), "");
		_removeTagMap.put(Pattern.compile("<_?(object)(?>[^<]*)</\\1(?>[^>]*)>", Pattern.CASE_INSENSITIVE), "");
		_removeTagMap.put(Pattern.compile("<_?(embed)(?>[^<]*)</\\1(?>[^>]*)>", Pattern.CASE_INSENSITIVE), "");
//        _removeTagMap.put(Pattern.compile("<(?! )(?>\"[^\"]*\"|'[^']*'|[^'\">])*>"), "");
		_removeTagMap.put(Pattern.compile("<(?! )(?>\"[^\"]*?\"|'[^']*?'|[^'\">])*?>"), ""); // 2011-10-25
//        _removeTagMap.put(Pattern.compile("<[a-zA-Z\\/\\_]{1}[^>]*>"), "");

//        _removeTagMap.put(Pattern.compile("(\r?\n){3,}"), "\n\n");
		_removeTagMap.put(Pattern.compile("(\r\n){3,}"), "\n\n");
		_removeTagMap.put(Pattern.compile("(\n){3,}"), "\n\n");
		_removeTagMap.put(Pattern.compile("[ \t]{2,}"), " ");

		_removeTagMap.put(Pattern.compile("&(.*){3,4};"), ""); // cms 2020-09-16
	}

	/**
	 * �±׸� ������ ���ڿ��� ��ȯ�մϴ�.
	 * 
	 * @param sData
	 * @return �±׸� ������ ���ڿ�
	 */
	public static String removeTag(String sData) {
		Iterator<Pattern> iter = _removeTagMap.keySet().iterator();
		Pattern pattern = null;

		while (iter.hasNext()) {
			pattern = iter.next();
			sData = pattern.matcher(sData).replaceAll(_removeTagMap.get(pattern));
		}
		return sData;
	}
	
	/**
	 * Ư�� ����(specialCharacter) ���� �ϴ� �Լ�( !@#$%^&*(),.?\\\":\\[\\]{}|<>/;~ )
	 * 
	 * @param input
	 * @return
	 */
	public static String removeSpecialCharacter(String input) {
		
		return input.replaceAll(specialCharacter, "");
	}

	public static void comparisonStringChar(char c, String s, int stringIndex) {
		if (c == s.charAt(stringIndex)) {
			System.out.println("�Է� ���ڿ�(" + s + ")�� " + stringIndex + "���° �ܾ �Է� ����(" + c + ")�� �����ϴ�.");
		} else {
			System.out.println("�Է� ���ڿ�(" + s + ")�� " + stringIndex + "���° �ܾ �Է� ����(" + c + ")�� ���� �ʽ��ϴ�.");
		}
	}

	public static void comparisonStringCharTest() {
		String s1 = "12345678";
		String s2 = "abcdefg";
		String s3 = "�����ٶ�";

		comparisonStringChar('1', s1, 0);
		comparisonStringChar('1', s1, 1);
		comparisonStringChar('1', s2, 1);
		comparisonStringChar('1', s3, 1);
		comparisonStringChar('��', s3, 1);
	}

	public static void testStringNew() {

		String s1 = "Hellow";
		String s2 = "Hellow";
		String s3 = "Hellow!";
		String s5 = new String("Hellow");

		if (s1 == s2) {
			System.out.println("1�� if ���");
		}
		if (s1 == s5) {
			System.out.println("2�� if ���");
		}
		s1 = "Hellow!";
		if (s1 == s2) {
			System.out.println("3�� if ���" + s1 + "==" + s2);
		}
		if (s1 == s3) {
			System.out.println("4�� if ���");
		}

	}

	public static StringBuffer sb = new StringBuffer("<DREREFERENCE>12</DREREFERENCE>\r\n"
			+ "<DRETITLE>������ &#034;1905�� ���� �Ϻ��� ������ ���&#034; ������ ����</DRETITLE>\r\n"
			+ "<DREDATE>1234567890</DREDATE>\r\n" + "<tttttttt/>\r\n" + "<LANGUAGETYPE>koreanUTF8</LANGUAGETYPE>\r\n"
			+ "<FETCHTIME>&gt;&lt;1234567895</FETCHTIME>\r\n"
			+ "<IP_CONTENT>��ȣ�� Ư�Ŀ� &amp;= &apos;�Ϻ� �ܹ��� ���� �Ϻ��������������Ұ� 1905�� �������� �Ϻ����� �������� �����ߴٴ� ������ ��� �������� 26�� ��Ʃ�꿡 �����ߴ�.</IP_CONTENT>\r\n"
			+ "<DRECONTENT>1905�� ������ �Ϻ� �ø���(����)���� ���ԵǱ� ������ �Ϻ��� ��ε��� ���� �ֺ����� �����ߴٴ� ������ �Ұ��� ������ ���� �δ��� ������ ������ ��Ǯ���ϴ� ���� �����̴�.\r\n"
			+ "\r\n" + "�����Ұ� ������ �����󿡴� �Ҿƹ����� �������� �����ߴٰ� �����ϴ� ���Ű ��(87) ���� �����Ѵ�. ������ �Կ����� 2019�� 7�� 6���̴�.\r\n" + "\r\n"
			+ "�ø����� ��Ű��ø��ʿ� �����ϴ� �� ���� � ���� �Ҿƹ����� �̽ùٽ� ����Ÿ��(1863~1941) ���κ��� ���� ���� �̾߱⸦ �����Ѵ�.\r\n" + "\r\n"
			+ "�Ҿƹ����� �������� ��ġ ����� �߰�, ������ ä���ߴٴ� �����̴�.\r\n" + "\r\n"
			+ "�����Ҵ� ������ ���� �ڷῡ�� �̽ùٽ� ���� &#039;���� ��ġ ����� ��ô��&#039;�� �Ұ��ϸ鼭 &#034;�̽ùٽ� ����Ÿ�δ� ������ (�ô�) �Ĺݿ��� ���� ��ġ ��ɿ��� ö��&#034;�ߴٸ� &#034;���Ű ���� ������ ���� 1905�� ���ɽø�(�������Ϻ��� �����ϴ� ������ ��Ī)�� �ø����� ���� �� ���ɽø��� ��� ���¸� �� �� �ִ�&#034;�� �����ߴ�.\r\n"
			+ "\r\n" + "�����󿡴� �������� ���� ������ �������Ǹ��߰�, [��ġ��] �⸧�� ����, ��⸦ �̿�������, ���� ���� �� ���þ� ���簡 ������ ǥ���ؿԴٴ� ���� ���� ����.\r\n"
			+ "</DRECONTENT>");

	public static HashSet<String> getXmlElementNames(String xmlString) {
		HashSet<String> elementSet = new HashSet<String>();

		Pattern pattern = Pattern.compile("[<][/](.*?)[>]");
		Matcher matcher = pattern.matcher(xmlString);
		while (matcher.find()) {
//			System.out.println(matcher.group(1));
			elementSet.add(matcher.group(1));

			if (matcher.group(1) == null) {
				break;
			}
		}
		matcher = pattern.compile("[<](.*?)[/][>]").matcher(xmlString);
		while (matcher.find()) {
//			System.out.println(matcher.group(1));
			elementSet.add(matcher.group(1));

			if (matcher.group(1) == null) {
				break;
			}
		}

		return elementSet;
	}

	public static HashSet<String> getXmlElementNamestest(String xmlString) {
		HashSet<String> elementSet = new HashSet<String>();

		String re1 = "<([^>]+)>"; // Tag 1
		String re2 = "([^<]*)"; // Variable Name 1
		String re3 = "</([^>]+)>"; // Tag 2
		// ['<([^>]*)>(.*?)<\/\1>']
//		Pattern pattern = Pattern.compile(re1+re2+re3,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Pattern pattern = Pattern.compile("[<][/]?(.*?)[/]?[>]");
		Matcher matcher = pattern.matcher(xmlString);
		while (matcher.find()) {
//			System.out.println(matcher.group(1));
			elementSet.add(matcher.group(1));

			if (matcher.group(1) == null) {
				break;
			}
		}
		return elementSet;
	}

	public static boolean findSpaceString(String input) {
		if ("".equals(input.replaceAll(" ", ""))) {
			return true;
		}
		return false;
	}

	public static void testToCase() {
		String test = new String("YES");
		if ("YES" == "yes".toUpperCase()) {
			System.out.println("if=>1");
		}
		if ("YES" == test.toUpperCase()) {
			System.out.println("if=>2");
		}
		if ("YES".equals(test.toUpperCase())) {
			System.out.println("if=>3");
		}
	}

	public static void testSubstr() {
		String test1 = "DREREFERENCE";
		String test2 = "DRETITLE";
		String test3 = "AMP_NAME";

		if ("DRE".equals(test1.substring(0, 2))) {
			System.out.println("1:" + test1.substring(0, 2));
		}
		if ("DRE".equals(test2.substring(0, 3))) {
			System.out.println("2:" + test2.substring(0, 3));
		}
		if ("DRE".equals(test3.substring(0, 2))) {
			System.out.println("3:" + test3.substring(0, 2));
		}

	}
	
	public static void main(String args[]) {
		// comparisonStringChar Ȯ�ο�
//		comparisonStringCharTest();

//		testStringNew();
//		System.out.println(getXmlElementNames(sb.toString()));
//		System.out.println("=======================================");
//		System.out.println(getXmlElementNamestest(sb.toString()));
//		
//		System.out.println(findSpaceString("    "));
//		System.out.println(findSpaceString(""));
//		System.out.println(findSpaceString(" "));
//		System.out.println(findSpaceString(" 11 "));
//		
//		testToCase();

//		testSubstr();
		System.out.println(sb);
		System.out.println("=======================================");
		System.out.println(removeTag(sb.toString()));
		System.out.println("=======================================");
		System.out.println(removeSpecialCharacter(sb.toString()));
		
	}
}
