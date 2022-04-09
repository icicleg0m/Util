package util.variable;

public class StringBufferUtil {

	// Stringbuffer 초기화
	public static StringBuffer delStringBuffer(StringBuffer sb) {
		sb.delete(0, sb.length());
		sb.setLength(0);
		return sb;
	}

	public static void testReplace() {
		StringBuffer sb = new StringBuffer();

		sb.append("test-test-test");
		sb.replace(0, sb.length(), "1234566");

		System.out.println(sb.toString());
	}

	public static void testLength() {

		StringBuffer sb = new StringBuffer();
		StringBuffer sb1 = new StringBuffer("");
		StringBuffer sb2 = new StringBuffer(" ");

		System.out.println("sb length:" + sb.length());
		System.out.println("sb1 length:" + sb1.length());
		System.out.println("sb2 length:" + sb2.length());
		
		if(sb.length() < 1) {
			System.out.println("0");
		}
		if(sb1.length() < 1) {
			System.out.println("1");
		}
		if(sb2.length() < 1) {
			System.out.println("2");
		}
	}

	public static void main(String args[]) {

//		StringBuffer sb = new StringBuffer();
//		StringBuffer sb2 = new StringBuffer("");
//		String tt = new String("(");
//		String bb = new String(")");
//		
//		System.out.println("처음 생성 length : " + sb.length() + ",sb2=" + sb2.length());
//		sb.append(tt);
//		if(sb.length() > 0) {
//			System.out.println(">0 통과");
//		}
//		if(sb.length() > 1) {
//			System.out.println(">1 통과");
//		}
//		sb.append(tt);
//		sb.append(bb);
//		sb.append(bb);
//		sb.append(tt);
//		sb.append(tt);
//		
//		System.out.println("1입력후 length : " + sb.length() + " 내용 : "+ sb);
//		System.out.println("초기화 후 length : " + delStringBuffer(sb).length());
//		sb.append("검색어");
//		System.out.println("검색어 입력후 length : " + sb.length());

//		testReplace();
		testLength();

	}
}
