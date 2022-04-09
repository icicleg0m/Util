package util.variable;

import java.util.HashSet;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	// 특수 문자 및 테그 삭제용.
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
	 * 태그를 제거한 문자열을 반환합니다.
	 * 
	 * @param sData
	 * @return 태그를 제거한 문자열
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
	 * 특수 문자(specialCharacter) 삭제 하는 함수( !@#$%^&*(),.?\\\":\\[\\]{}|<>/;~ )
	 * 
	 * @param input
	 * @return
	 */
	public static String removeSpecialCharacter(String input) {
		
		return input.replaceAll(specialCharacter, "");
	}

	public static void comparisonStringChar(char c, String s, int stringIndex) {
		if (c == s.charAt(stringIndex)) {
			System.out.println("입력 문자열(" + s + ")의 " + stringIndex + "몇번째 단어가 입력 문자(" + c + ")와 같습니다.");
		} else {
			System.out.println("입력 문자열(" + s + ")의 " + stringIndex + "몇번째 단어가 입력 문자(" + c + ")와 같지 않습니다.");
		}
	}

	public static void comparisonStringCharTest() {
		String s1 = "12345678";
		String s2 = "abcdefg";
		String s3 = "가나다라마";

		comparisonStringChar('1', s1, 0);
		comparisonStringChar('1', s1, 1);
		comparisonStringChar('1', s2, 1);
		comparisonStringChar('1', s3, 1);
		comparisonStringChar('나', s3, 1);
	}

	public static void testStringNew() {

		String s1 = "Hellow";
		String s2 = "Hellow";
		String s3 = "Hellow!";
		String s5 = new String("Hellow");

		if (s1 == s2) {
			System.out.println("1번 if 결과");
		}
		if (s1 == s5) {
			System.out.println("2번 if 결과");
		}
		s1 = "Hellow!";
		if (s1 == s2) {
			System.out.println("3번 if 결과" + s1 + "==" + s2);
		}
		if (s1 == s3) {
			System.out.println("4번 if 결과");
		}

	}

	public static StringBuffer sb = new StringBuffer("<DREREFERENCE>12</DREREFERENCE>\r\n"
			+ "<DRETITLE>日연구소 &#034;1905년 이전 일본인 독도서 어업&#034; 동영상 공개</DRETITLE>\r\n"
			+ "<DREDATE>1234567890</DREDATE>\r\n" + "<tttttttt/>\r\n" + "<LANGUAGETYPE>koreanUTF8</LANGUAGETYPE>\r\n"
			+ "<FETCHTIME>&gt;&lt;1234567895</FETCHTIME>\r\n"
			+ "<IP_CONTENT>김호준 특파원 &amp;= &apos;일본 외무성 산하 일본국제문제연구소가 1905년 이전부터 일본인이 독도에서 조업했다는 증언이 담긴 동영상을 26일 유튜브에 공개했다.</IP_CONTENT>\r\n"
			+ "<DRECONTENT>1905년 독도가 일본 시마네(島根)현에 편입되기 전부터 일본인 어부들이 독도 주변에서 조업했다는 증언을 소개해 독도에 대한 부당한 영유권 주장을 되풀이하는 것이 목적이다.\r\n"
			+ "\r\n" + "연구소가 공개한 동영상에는 할아버지가 독도에서 조업했다고 증언하는 사사키 준(87) 씨가 등장한다. 동영상 촬영일은 2019년 7월 6일이다.\r\n" + "\r\n"
			+ "시마네현 오키노시마초에 거주하는 준 씨는 어린 시절 할아버지인 이시바시 마쓰타로(1863~1941) 씨로부터 들은 독도 이야기를 증언한다.\r\n" + "\r\n"
			+ "할아버지가 독도에서 강치 사냥을 했고, 전복을 채취했다는 내용이다.\r\n" + "\r\n"
			+ "연구소는 동영상 설명 자료에서 이시바시 씨를 &#039;독도 강치 사냥의 개척자&#039;로 소개하면서 &#034;이시바시 마쓰타로는 메이지 (시대) 후반에는 독도 강치 사냥에서 철수&#034;했다며 &#034;사사키 씨의 증언을 통해 1905년 다케시마(竹島·일본이 주장하는 독도의 명칭)의 시마네현 편입 전 다케시마의 어업 실태를 알 수 있다&#034;고 설명했다.\r\n"
			+ "\r\n" + "동영상에는 독도에서 잡은 전복을 가공·판매했고, [강치의] 기름과 가죽, 고기를 이용했으며, 러일 전쟁 때 러시아 병사가 독도로 표류해왔다는 내용 등이 담겼다.\r\n"
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
		// comparisonStringChar 확인용
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
