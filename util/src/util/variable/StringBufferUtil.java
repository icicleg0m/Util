package util.variable;

public class StringBufferUtil {

	// Stringbuffer �ʱ�ȭ
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
//		System.out.println("ó�� ���� length : " + sb.length() + ",sb2=" + sb2.length());
//		sb.append(tt);
//		if(sb.length() > 0) {
//			System.out.println(">0 ���");
//		}
//		if(sb.length() > 1) {
//			System.out.println(">1 ���");
//		}
//		sb.append(tt);
//		sb.append(bb);
//		sb.append(bb);
//		sb.append(tt);
//		sb.append(tt);
//		
//		System.out.println("1�Է��� length : " + sb.length() + " ���� : "+ sb);
//		System.out.println("�ʱ�ȭ �� length : " + delStringBuffer(sb).length());
//		sb.append("�˻���");
//		System.out.println("�˻��� �Է��� length : " + sb.length());

//		testReplace();
		testLength();

	}
}
