public class racetrack
{
    int position;
    double eventlikelihood;
    int round;
    /**
     * Method racetrack
     * This method is called upon by the mainclass method main when it reaches the point of execution to start the game.
     */
    public static void racetrack(int usernum){
        System.out.println("Welcome user, you are placed at the starting position of "+(usernum+1)+".");
        System.out.println("Survive 7 rounds which are full of fights and keep the first place to win. If you lose health below 0 then you are dead ");
        System.out.println("Points will be filled after each event depending upon the event. There are 2 rounds for each carfight and the user only loses when there is a loss/loss or a draw/loss. There is also possibility of reduction in points");
        System.out.println("**Let the race start!**");
    }   
    public racetrack(int position, int round){
        this.position=position;
        this.round=round;
    }      
}
