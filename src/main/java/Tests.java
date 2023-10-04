import org.junit.jupiter.api.Test;

import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the functionality of the program.
 */
public class Tests {
    @Test
    public void testPersistAndLoad() {
        String filename = "test.json";
        JsonPersistMethod persistMethod = new JsonPersistMethod(filename);

        // Create some sample TrainerStatistics
        TrainerStatistics originalStats = new TrainerStatistics();
        originalStats.setTotal(10);
        originalStats.setCorrect(7);
        originalStats.setWrong(3);

        // Persist the statistics
        persistMethod.persist(originalStats);

        // Load the statistics
        TrainerStatistics loadedStats = persistMethod.load();

        assertEquals(originalStats.getTotal(), loadedStats.getTotal());
        assertEquals(originalStats.getCorrect(), loadedStats.getCorrect());
        assertEquals(originalStats.getWrong(), loadedStats.getWrong());

        // Clean up by deleting the test file
        File file = new File(filename);
        file.delete();
    }

    @Test
    public void testLoadNonExistentFile() {
        String filename = "nonexistent.json";
        JsonPersistMethod persistMethod = new JsonPersistMethod(filename);

        // Loading from a non-existent file should return an empty TrainerStatistics
        TrainerStatistics loadedStats = persistMethod.load();

        assertEquals(0, loadedStats.getTotal());
        assertEquals(0, loadedStats.getCorrect());
        assertEquals(0, loadedStats.getWrong());
    }
}
