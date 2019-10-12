public class Frame {
    private int score1;
    private int score2;
    private int totalScore;
    private int displayScore;
    private boolean strike;
    private boolean spare;
    private int frameNum;
    private boolean complete;

    public Frame(int score1,int turn, boolean strike) {
        this.score1 = score1;
        this.frameNum = turn;
        if(strike){
            this.strike = true;
        }else{
            this.strike = false;
        }
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
        if((score1 + score2) == 10){
            spare = true;
        }else{
            spare = false;
            complete = true;
        }
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public int getFrameNum() {
        return frameNum;
    }

    public void setCount(int frameNum){
        this.frameNum = frameNum;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
