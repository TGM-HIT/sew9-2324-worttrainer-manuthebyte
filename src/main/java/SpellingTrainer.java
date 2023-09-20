import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Random;

public class SpellingTrainer {
    private List<ImageWordPair> pairs;
    private ImageWordPair currentPair;
    private TrainerStatistics stats;
    private PersistMethod persistMethod;

    public SpellingTrainer(List<ImageWordPair> pairs, PersistMethod persistMethod) {
        this.pairs = pairs;
        this.stats = new TrainerStatistics();
        this.persistMethod = persistMethod;
    }

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

            if (answer != null) {
                if (answer.equals(this.currentPair.getWord())) {
                    JOptionPane.showMessageDialog(null, "Correct!");
                    this.stats.incrementCorrect();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong! The correct answer is " + this.currentPair.getWord());
                    this.stats.incrementWrong();
                }
                this.persistMethod.persist(this.stats);
                this.currentPair = this.pairs.get(rand.nextInt(this.pairs.size()));
            } else {
                this.persistMethod.persist(this.stats);
                this.currentPair = this.pairs.get(rand.nextInt(this.pairs.size()));
                break;
            }
        }
    }

    private String buildStatsString() {
        String statsString = "Total: " + this.stats.getTotal() + "\n" +
                "Correct: " + this.stats.getCorrect() + "\n" +
                "Wrong: " + this.stats.getWrong() + "\n" +
                "Accuracy: " + this.stats.getCorrect() / (double) this.stats.getTotal() * 100 + "%";

        return statsString;
    }
}
