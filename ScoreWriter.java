package dtask;

	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;

	public class ScoreWriter {
	    private final String filePath;

	    public ScoreWriter(String filePath) {
	        this.filePath = filePath;
	    }

	    public synchronized void writeToFile(Students student) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
	            writer.println(student.toString());
	            System.out.println(" Written: " + student);
	        } catch (IOException e) {
	            System.err.println(" Error writing to file: " + e.getMessage());
	        }
	    }
}
