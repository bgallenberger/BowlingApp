import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner keyboard = new Scanner(System.in);
    private ArrayList<Player> playerList = new ArrayList<Player>();
    private int numOfPlayers;

    //creates players and asks for player names
    public void createPlayers() {
        System.out.println("Enter number of players");
        numOfPlayers = Integer.parseInt(keyboard.nextLine());
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("enter player " + (i + 1) + "'s name");
            String name = keyboard.nextLine();
            Player newPlayer = new Player(name);
            playerList.add(newPlayer);
        }
    }

    public void startGame() {
        //go through 10 turns
        for (int i = 1; i <= 10; i++) {
            System.out.println("Turn " + (i));
            //have each player take a turn
            for (int j = 0; j < numOfPlayers; j++) {
                System.out.println("It is " + playerList.get(j).getName() +
                        "'s turn (player " + (j + 1) + ")");
                System.out.println("PLease bowl and then enter your score:");
                // generate score
                // int score1 = playerList.get(j).bowl1();
                int score1 = Integer.parseInt(keyboard.nextLine());
                //if strike make and add a strike to the list
                //update all strikes and spares currently in lists
                playerList.get(j).updateLists(score1);
                if (score1 == 10) {
                    //make frame and add to frameList
                    Frame newFrame = new Frame(score1, i, true);
                    newFrame.setTotalScore(score1);
                    playerList.get(j).addFrame(newFrame);
                    // make strike and add to list
                    Strike newStrike = new Strike(i, score1);
                    playerList.get(j).getStrikeList().add(newStrike);
                    System.out.println("Strike!");
                    // else have user enter second score
                }else{
                    Frame newFrame = new Frame(score1, i, false);
                    System.out.println("PLease bowl and then enter your second score:");
                    // generate score
                    // int score2 = playerList.get(j).bowl2();
                    int score2 = Integer.parseInt(keyboard.nextLine());
                    //update all strikes and spares currently in lists
                    playerList.get(j).updateLists(score2);
                    newFrame.setScore2(score2);
                    if((score1 + score2) == 10){
                        //make spare and add to spareList
                        newFrame.setSpare(true);
                        Spare newSpare = new Spare(i,10);
                        newFrame.setTotalScore((score1 + score2));
                        playerList.get(j).addFrame(newFrame);
                        playerList.get(j).getSpareList().add(newSpare);
                        System.out.println("Spare!");
                    }else{
                        // frame is complete so just add to frame list
                        newFrame.setComplete(true);
                        newFrame.setTotalScore((score1 + score2));
                        playerList.get(j).addFrame(newFrame);
                    }
                }
            }
        }

        //go through players and have them bowl if they have any uncompleted spares or strikes
        for (int i = 0;i<numOfPlayers;i++){
            if(playerList.get(i).getFrameList().get(9).isStrike()){
                System.out.println(playerList.get(i).getName() + "(player " + (i+1) + ") your last ball " +
                        "was a strike.");
                System.out.println("PLease bowl and then enter your score:");
                int score1 = Integer.parseInt(keyboard.nextLine());
                playerList.get(i).updateLists(score1);
                System.out.println("PLease bowl and then enter your second score:");
                int score2 = Integer.parseInt(keyboard.nextLine());
                playerList.get(i).updateLists(score2);
            }else if(playerList.get(i).getFrameList().get(9).isSpare()){
                System.out.println(playerList.get(i).getName() + "(player " + (i+1) + ") your last ball " +
                        "was a spare.");
                System.out.println("PLease bowl and then enter your score:");
                int score1 = Integer.parseInt(keyboard.nextLine());
                playerList.get(i).updateLists(score1);
            }
        }
    }

    public void scoreGame(){
        //go through all players
        for (int i = 0;i<numOfPlayers;i++){
            //go through framelist to get all frames
            int totalScore = 0;
            for(int j = 0;j<10;j++) {
                System.out.print("turn " + (j + 1)+": ");
                totalScore += playerList.get(i).getFrameList().get(j).getTotalScore();
                System.out.println(totalScore);
            }
            System.out.println("player " + (i + 1) + " final score is: " + totalScore);
        }
    }
}
