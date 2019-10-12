public class Strike {
    private int correlatingFrameNum;
    private int numberOfBalls = 2;
    private int currentScore;

    public Strike(int correlatingFrameNum, int currentScore) {
        this.correlatingFrameNum = correlatingFrameNum;
        this.currentScore = currentScore;
    }

    public boolean isComplete(){
        if(numberOfBalls == 0) {
            return true;
        }else{
            numberOfBalls--;
            return false;
        }
    }

    public int getCorrelatingFrameNum() {
        return correlatingFrameNum;
    }

    public void setCorrelatingFrameNum(int correlatingFrameNum) {
        this.correlatingFrameNum = correlatingFrameNum;
    }

    public int getNumberOfBalls() {
        return numberOfBalls;
    }

    public void setNumberOfBalls(int numberOfBalls) {
        this.numberOfBalls = numberOfBalls;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }
}
