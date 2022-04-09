package test.jvm;

public class MethodStackAreaTest {
	
	static int StaticNum = 0; 
	
	public static void main(String[] args) {
		int localNum = 0;
		Integer localInterger = new Integer(0);
		
		add1(localNum, localInterger);
		add2(localNum, localInterger);

	}
	
	static void add1(int localNum, Integer localInterger) {
		StaticNum++;
		localNum++;
		localInterger++;
		System.out.println("add1:staticNum=" + StaticNum + ",localNum=" + localNum + ",localInterger=" + localInterger);
	}
	static void add2(int localNum, Integer localInterger) {
		StaticNum++;
		localNum++;
		localInterger++;
		System.out.println("add2:staticNum=" + StaticNum + ",localNum=" + localNum + ",localInterger=" + localInterger);
	}

}
