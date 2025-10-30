package dtask;


	public class ThreadLogger extends Thread {
	    private final Students student;
	    private final ScoreWriter writer;

	    public ThreadLogger(Students student, ScoreWriter writer) {
	        this.student = student;
	        this.writer = writer;
	    }

	    @Override
	    public void run() {
	        writer.writeToFile(student);
	    }
}
