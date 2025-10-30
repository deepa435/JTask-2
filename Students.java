package dtask;

public class Students {


	    private String name;
	    private int rollno;
	    private int marks;

	    public Students(String name, int rollno, int marks) {
	        this.name = name;
	        this.rollno = rollno;
	        this.marks = marks;
	    }

	    @Override
	    public String toString() {
	        return name + "," + rollno + "," + marks;
	    }

	    // Optional getters (useful for tests or extensions)
	    public String getName() {
	        return name;
	    }

	    public int getRollno() {
	        return rollno;
	    }

	    public int getMarks() {
	        return marks;
	    }
}
