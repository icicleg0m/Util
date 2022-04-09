package util.variable;

public class IntUtil {
	
	private static int psi;
	
	/**
	 * @return the psi
	 */
	public static int getPsi() {
		return psi;
	}

	/**
	 * @param psi the psi to set
	 */
	public static void setPsi(int psi) {
		IntUtil.psi = psi;
	}

	public static void testInt() {
		
		int i;
		int j = 0;
		int k = 22;
		
		System.out.println("i=" + getPsi() + ",j=" + j + ",k=" + k);
		
	}
	
	public static void main(String args[]) {
		
		int i;
		int j = 0;
		int k = 22;
		
		testInt();
		
	}
}
