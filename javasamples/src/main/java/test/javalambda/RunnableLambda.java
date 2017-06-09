package test.javalambda;

public class RunnableLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Runnable r1 = new Runnable() {
			
			public void run() {
				System.out.println("In 1");
				
			}
		};
		
		Runnable r2 = () -> {System.out.println("In 2");};
		new Thread(r2).start();
		new Thread(r1).start();
		
	}

}
