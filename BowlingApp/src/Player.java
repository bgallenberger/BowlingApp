import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Frame> frameList = new ArrayList<Frame>();
    private ArrayList<Strike> strikeList = new ArrayList<Strike>();
    private ArrayList<Spare> spareList = new ArrayList<Spare>();

    public Player(String name) {
        this.name = name;
    }

    public int bowl1(){
        //generate random num between 0 and 10
        return 1;
    }

    public int bowl2(){
        //generate random num between 0 and (10 - bowl1)
        return 1;
    }

    public void addStrike(Strike newStrike){
        strikeList.add(newStrike);
    }

    public void updateLists(int score){
        updateStrikes(score);
        updateSpares(score);
        //add complete frames to framelist
    }

    private void updateStrikes(int score){
        boolean completeStrike = false;
        if(strikeList.size() > 0) {
            // update strikes and remove complete strikes
            for (int i = 0; i < strikeList.size(); i++) {
                //get and set how many balls the strike is waiting on
                int balls = strikeList.get(i).getNumberOfBalls();
                strikeList.get(i).setNumberOfBalls(balls - 1);
                //get and set the current combined score
                int currentScore = strikeList.get(i).getCurrentScore();
                strikeList.get(i).setCurrentScore((currentScore + score));
                if (strikeList.get(i).getNumberOfBalls() == 0) {
                    //get current score and correlating frame num
                    int totalScore = strikeList.get(i).getCurrentScore();
                    int correlatingFrameNum = strikeList.get(i).getCorrelatingFrameNum();
                    //update frame
                    frameList.get((correlatingFrameNum - 1)).setTotalScore(totalScore);
                    completeStrike = true;
                }
            }
        }
        if (completeStrike){
            //remove completed frame
            strikeList.remove(0);
        }
    }
    private void updateSpares(int score) {
        // update spares and remove complete spares
        for (int i = 0; i < spareList.size(); i++) {
            int currentScore = spareList.get(i).getCurrentScore();
            spareList.get(i).setCurrentScore((currentScore + score));
            //get current score and correlating frame num
            int totalScore = spareList.get(i).getCurrentScore();
            int correlatingFrameNum = spareList.get(i).getCorrelatingFrameNum();
            //update frame
            frameList.get((correlatingFrameNum - 1)).setTotalScore(totalScore);
            //remove spare
            spareList.remove(0);

        }
    }

    public void addFrame(Frame frame){
        int i = frame.getFrameNum();
        frameList.add((i-1),frame);
    }


    public String getName() {
        return name;
    }

    public ArrayList<Frame> getFrameList() {
        return frameList;
    }

    public void setFrameList(ArrayList<Frame> frameList) {
        this.frameList = frameList;
    }

    public ArrayList<Strike> getStrikeList() {
        return strikeList;
    }

    public void setStrikeList(ArrayList<Strike> strikeList) {
        this.strikeList = strikeList;
    }

    public ArrayList<Spare> getSpareList() {
        return spareList;
    }

    public void setSpareList(ArrayList<Spare> spareList) {
        this.spareList = spareList;
    }
}
