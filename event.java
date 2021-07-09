import java.util.Random;
public class event extends racetrack
{
    public event(int position, int round){
        super(position,round);
    }    
    public static boolean seteventlikelihood(int usernum,int enemynum){
        Random rand = new Random();
        boolean fightorno=false;
        int difference1=usernum-enemynum;
        int difference2=enemynum-usernum;
        double random = rand.nextDouble();
        if(difference1<=0){
            if (random<=0.6){
                fightorno=true;
            }  
            else{
                fightorno=false;
            }    
        }
        else if(difference2<=0){
           if(random<=0.8){
               fightorno=true;
           }    
           else{
               fightorno=false;
           }    
        } 
        return fightorno;
    }   
}