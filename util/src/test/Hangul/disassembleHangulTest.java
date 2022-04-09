package test.Hangul;

public class disassembleHangulTest {

	final static String[] chosung = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
			"��", "��", "��" };
	final static String[] moeum = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "�Ǥ�", "�Ǥ�", "�Ǥ�", "��", "��", "�̤�", "�̤�",
			"�̤�", "��", "��", "�Ѥ�", "��" };
	final static String[] badchim = { "", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
			"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };

	public String process(String fieldName, String sData) {
		sData = removeMark(sData);

		if (fieldName.equals("ACFIELD")) {
			sData = disassembleHangul(sData, 0);
		} else if (fieldName.equals("ACFIELDR")) {
			sData = disassembleHangul(sData, 1);
		} else if (fieldName.equals("ACFIELDIC")) {
			sData = disassembleHangul(sData, 2);
		}

		return getMatrixWords(sData);
	}

	public String disassembleHangul(String s, int direction) {
		if (s == null) {
			return null;
		}
		String t = "";
		String tmp = "";
		int n, n1, n2, n3;
		char c;

		if (direction == 1) {
			tmp = s;
			s = "";
			for (int j = tmp.length() - 1; j >= 0; j--) {
				s = s + tmp.charAt(j) + "";
			}
			tmp = "";
		}

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			n = (int) (c & 0xFFFF);
			if (n >= 0xAC00 && n <= 0xD7A3) {
				n = n - 0xAC00;
				n1 = n / (21 * 28);
				n = n % (21 * 28);
				n2 = n / 28;
				n3 = n % 28;
				if(direction == 2) {
					tmp = chosung[n1];
				} else {
					tmp = chosung[n1] + moeum[n2] + badchim[n3];
				}
				t += tmp;
			} else {
				t += c;
			}
		}
		return t;
	}

	public String getMatrixWords(String str) {
		String ret = "";

		String term = "";
		for (int i = 0; i < str.length(); i++) {
			term += str.charAt(i);
			if (ret.length() > 0)
				ret += ", ";
			ret += term;
		}
		return ret;
	}

	/*
	 * -----------------------------------------------------------------------------
	 * ------ Description: Ư����ȣ���� Parameters: strValue(�Է°�)
	 * -----------------------------------------------------------------------------
	 * ------
	 */
	public String removeMark(String strValue) {
		String arrMark[] = { "+", "@", "=", "*", "<", ">", "`", "\\", "[", "]", "(", ")" };
		for (int i = 0; i < arrMark.length; i++) {
			strValue = replace(strValue, arrMark[i], "");
		}

		return strValue;
	}

	public String replace(String str, String oldString, String newString) {
		for (int index = 0; (index = str.indexOf(oldString, index)) >= 0; index += newString.length())
			str = str.substring(0, index) + newString + str.substring(index + oldString.length());
		return str;
	}

	public static void main(String[] args) {

		disassembleHangulTest dht = new disassembleHangulTest();
		System.out.println("==========================================");
		System.out.println(dht.process("ACFIELD", "���ͻ��"));
		System.out.println(dht.process("ACFIELDR", "���ͻ��"));
		System.out.println(dht.process("ACFIELDIC", "���ͻ��"));
		System.out.println("==========================================");
		System.out.println(dht.process("ACFIELD", "��, ���, ����, ���ͻ�, ���ͻ��"));
		System.out.println(dht.process("ACFIELDR", "��, ���, ����, ���ͻ�, ���ͻ��"));
		System.out.println(dht.process("ACFIELDIC", "��, ���, ����, ���ͻ�, ���ͻ��"));
		System.out.println("==========================================");
		System.out.println(dht.process("ACFIELD", "ȭ1 400��"));
		System.out.println(dht.process("ACFIELDR", "ȭ1 400��"));
		System.out.println(dht.process("ACFIELDIC", "ȭ1 400��"));
		System.out.println("==========================================");
		System.out.println(dht.process("ACFIELD", "ȭ, ȭ1, ȭ14, ȭ140, ȭ1400, ȭ1400��"));
		System.out.println(dht.process("ACFIELDR", "ȭ, ȭ1, ȭ14, ȭ140, ȭ1400, ȭ1400��"));
		System.out.println(dht.process("ACFIELDIC", "ȭ, ȭ1, ȭ14, ȭ140, ȭ1400, ȭ1400��"));
		System.out.println("==========================================");
	}
}
