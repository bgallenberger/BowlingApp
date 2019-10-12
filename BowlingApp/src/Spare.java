public class Spare {
    private int correlatingFrameNum;
    private int currentScore;

    public Spare(int correlatingFrameNum, int currentScore){
        this.correlatingFrameNum = correlatingFrameNum;
        this.currentScore = currentScore;
    }

    public int getCorrelatingFrameNum() {
        return correlatingFrameNum;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
