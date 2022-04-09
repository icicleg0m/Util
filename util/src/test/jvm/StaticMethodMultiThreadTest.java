package test.jvm;

/**
 * 멀티 스레드환경에서 static 메소드의 로컬 변수가 safe하는지 테스트
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
		 * 테스트 대상이되는 static 메소드(로컬변수를 가지고 있음) - 결과 : 로컬 변수는 각 스레드의 stack에 저장하기에 multi
		 * thread 환경에서도 safe - 참고 :
		 * http://tutorials.jenkov.com/java-concurrency/thread-safety.html
		 *
		 * @param threadName 스레드 이름
		 */
		private static void testStaticMethod(String threadName) {

			System.out.println("Start : " + threadName);

			long threadSafeInt = 0;
			threadSafeInt++;

			// Start가 n번 찍히고 End가 찍히지 않았을때도 항상 1 => 로컬 변수의 값은 multiple thread에 safe
			System.out.println("threadSafeInt : " + threadSafeInt);

			if (threadSafeInt != 1) {
				System.out.println("It is not thread safe : " + threadSafeInt);

			}

			System.out.println("End : " + threadName);

		}
	}

	/**
	 * 테스트를 위해서 여러번 호출해본다. - 호출횟수가 작어서 의심스러우면 호출하는 클래스위 System.out의 주석을 제거하면 명확해짐
	 */
	public static void main(String args[]) {

		int exeCnt = 100;

		for (int i = 0; i < exeCnt; i++) {
			new Thread(new TestThreadClass()).start();

		}

	}

}
