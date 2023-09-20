/**
 * The trainer statistics
 *
 * @author Manuel Glenk
 * @version 2023-09-20
 */
public class TrainerStatistics {
    private int total; // The total amount of questions
    private int correct; // The amount of correct answers
    private int wrong; // The amount of wrong answers

    /**
     * Creates a new TrainerStatistics
     */
    public TrainerStatistics() {
        this.total = 0;
        this.correct = 0;
        this.wrong = 0;
    }

    public int getTotal() {
        return total;
    }

    public int getCorrect() {
        return correct;
    }

    public int getWrong() {
        return wrong;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    /**
     * Increments the total amount of questions and the amount of correct answers
     */
    public void incrementCorrect() {
        total++;
        correct++;
    }

    /**
     * Increments the total amount of questions and the amount of wrong answers
     */
    public void incrementWrong() {
        total++;
        wrong++;
    }
}
