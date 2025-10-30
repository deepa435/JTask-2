package dtask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import static org.junit.jupiter.api.Assertions.*;

	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;

	public class JavaLoggerTest {
	    private static final String TEST_FILE = "test_scores.csv";

	    @BeforeEach
	    public void setup() throws IOException {
	        Files.deleteIfExists(Paths.get(TEST_FILE));
	    }

	    @Test
	    public void testFileWriting() throws IOException {
	        ScoreWriter writer = new ScoreWriter(TEST_FILE);
	        Students student = new Students("TestUser", 99, 100);

	        writer.writeToFile(student);

	        String content = Files.readString(Paths.get(TEST_FILE));
	        assertTrue(content.contains("TestUser,99,100"), "File should contain the written student record.");
	    }

	    @Test
	    public void testThreadCompletion() throws InterruptedException, IOException {
	        ScoreWriter writer = new ScoreWriter(TEST_FILE);
	        Thread t1 = new ThreadLogger(new Students("Johny", 888, 87), writer);
	        Thread t2 = new ThreadLogger(new Students("John", 777, 98), writer);
	        Thread t3 = new ThreadLogger(new Students("Disha", 999, 99), writer);

	        t1.start();
	        t2.start();
	        t3.start();

	        t1.join();
	        t2.join();
	        t3.join();

	        long lines = Files.lines(Paths.get(TEST_FILE)).count();
	        assertEquals(3, lines, "There should be exactly 3 records written.");
	    }

}
