package test.jvm;

/**
 * ��Ƽ ������ȯ�濡�� static �޼ҵ��� ���� ������ safe�ϴ��� �׽�Ʈ
 *
 * @author
 *
 */
public class StaticMethodMultiThreadTest {

	static class TestThreadClass extends Thread {

		public void run() {

			testStaticMethod(this.getName());

		}

		/**
		 * �׽�Ʈ ����̵Ǵ� static �޼ҵ�(���ú����� ������ ����) - ��� : ���� ������ �� �������� stack�� �����ϱ⿡ multi
		 * thread ȯ�濡���� safe - ���� :
		 * http://tutorials.jenkov.com/java-concurrency/thread-safety.html
		 *
		 * @param threadName ������ �̸�
		 */
		private static void testStaticMethod(String threadName) {

			System.out.println("Start : " + threadName);

			long threadSafeInt = 0;
			threadSafeInt++;

			// Start�� n�� ������ End�� ������ �ʾ������� �׻� 1 => ���� ������ ���� multiple thread�� safe
			System.out.println("threadSafeInt : " + threadSafeInt);

			if (threadSafeInt != 1) {
				System.out.println("It is not thread safe : " + threadSafeInt);

			}

			System.out.println("End : " + threadName);

		}
	}

	/**
	 * �׽�Ʈ�� ���ؼ� ������ ȣ���غ���. - ȣ��Ƚ���� �۾ �ǽɽ������ ȣ���ϴ� Ŭ������ System.out�� �ּ��� �����ϸ� ��Ȯ����
	 */
	public static void main(String args[]) {

		int exeCnt = 100;

		for (int i = 0; i < exeCnt; i++) {
			new Thread(new TestThreadClass()).start();

		}

	}

}
