public class GameHelper {
    public static void printHand(Hand hand){

    }

    public static boolean checkWinner(int playerScore, int computerScore, int scoreLimit){
        if(playerScore > scoreLimit && playerScore > computerScore){
            System.out.println("Congratulations !!!");
            return false;
        }else if(computerScore > scoreLimit && computerScore > playerScore){
            System.out.println("Try Again.");
            return false;
        }

        return true;
    }

}
