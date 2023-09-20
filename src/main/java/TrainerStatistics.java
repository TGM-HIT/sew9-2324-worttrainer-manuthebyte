public class TrainerStatistics {
    private int total;
    private int correct;
    private int wrong;

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

    public void incrementCorrect() {
        total++;
        correct++;
    }

    public void incrementWrong() {
        total++;
        wrong++;
    }
}
