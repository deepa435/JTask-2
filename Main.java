package dtask;

public class Main {
	 public static void main(String[] args) {
	        String filePath = "scores.csv";
	        ScoreWriter writer = new ScoreWriter(filePath);

	        Thread t1 = new ThreadLogger(new Students("Johny", 888, 97), writer);
	        Thread t2 = new ThreadLogger(new Students("John", 777, 98), writer);
	        Thread t3 = new ThreadLogger(new Students("Disha", 999, 99), writer);

	        // Start all threads
	        t1.start();
	        t2.start();
	        t3.start();

	        // Wait for all to complete
	        try {
	            t1.join();
	            t2.join();
	            t3.join();
	        } catch (InterruptedException e) {
	            System.err.println("Thread interrupted: " + e.getMessage());
	        }

	        System.out.println("✅ All threads completed writing.");
	    }
}
