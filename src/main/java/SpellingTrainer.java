import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;

/**
 * The spelling trainer
 *
 * @author Manuel Glenk
 * @version 2023-09-20
 */
public class SpellingTrainer {
    private List<ImageWordPair> pairs; // The list of image-word pairs
    private ImageWordPair currentPair; // The current image-word pair
    private TrainerStatistics stats; // The statistics of the trainer
    private PersistMethod persistMethod; // The persist method

    /**
     * Creates a new SpellingTrainer
     *
     * @param pairs The list of image-word pairs
     * @param persistMethod The persist method
     */
    public SpellingTrainer(List<ImageWordPair> pairs, PersistMethod persistMethod) {
        this.pairs = pairs;
        this.stats = new TrainerStatistics();
        this.persistMethod = persistMethod;
    }

    /**
     * Starts the trainer
     *
     * 1. Pick a random image-word pair
     * 2. Show the image
     * 3. Ask the user for the word
     * 4. If the user entered a word, check if it is correct, show a message dialog with the result and increment the correct or wrong counter
     * 5. If the user did not enter a word, persist the statistics and finish
     */
    public void start() {
        Random rand = new Random();

        this.stats = this.persistMethod.load();
        this.currentPair = this.pairs.get(rand.nextInt(this.pairs.size()));

        while (true) {
            ImageIcon imageIcon = new ImageIcon(this.currentPair.getImageUrl());

            // Define the desired width and height
            int desiredWidth = 200;
            int desiredHeight = 150;

            // Scale the ImageIcon to the desired size
            Image scaledImage = imageIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

            String answer = (String) JOptionPane.showInputDialog(
                    null,
                    buildStatsString() + "\n\nWhat is the word for this image?",
                    null,
                    JOptionPane.PLAIN_MESSAGE,
                    scaledImageIcon, // Use the scaled ImageIcon here
                    null,
                    ""
            );

            if (answer != null && !answer.isEmpty()) {
                if (answer.equals(this.currentPair.getWord())) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    this.stats.incrementCorrect();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong! The correct answer is " + this.currentPair.getWord());
                    this.stats.incrementWrong();
                }
            } else {
                this.persistMethod.persist(this.stats);
                this.currentPair = this.pairs.get(rand.nextInt(this.pairs.size()));
                break;
            }
        }
    }

    /**
     * Builds the stats string
     *
     * Made of:
     * - Total
     * - Correct
     * - Wrong
     * - Accuracy
     *
     * @return The stats string
     */
    private String buildStatsString() {
        String statsString = "Total: " + this.stats.getTotal() + "\n" +
                "Correct: " + this.stats.getCorrect() + "\n" +
                "Wrong: " + this.stats.getWrong() + "\n" +
                "Accuracy: " + this.stats.getCorrect() / (double) this.stats.getTotal() * 100 + "%";

        return statsString;
    }
}
