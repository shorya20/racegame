import java.util.Scanner;
import java.util.Random;
public class usercar extends carcharacteristics
{
    String playerclass;
    int points;
    int position;
    String[] playerclasses={"Engineer","Maniac","Farmer","Nomad"};
    String[] cornering={"decent","poor","decent","good"};
    String[] tenacity = {"poor","good","poor","decent"};
    String[] aggression={"decent","good","poor","good"};
    String[] pointsrequired={"4","6","2","7"};
    public usercar(String brand, double enginesize, int horsepower, String durability){
        super(brand,enginesize,horsepower,durability);
    }
    public void setPoints(int points){
        this.points=points;
    }
    public int getPoints(){
        return this.points;
    }
    public void setPosition(int position){
       this.position=position;
    }    
    public int getPosition(){
       return this.position;
    } 
    /**
     * Method setClassplayer
     *
     * @param myobj Parameter myobj of type carcharacteristics will take the argument from the mainclass method(in this case it will be the usercar object/instance
     * and will be used to change the default values which have been initialised when the superclass setClassplayer of class carcharacteristics is called.
     * The values of instance variables such as playerclass will now be changed of myobj depending upon user input.
     * @param points Parameter points of type int will take the argument from the mainclass method and initialise the points value of the object/instance when it is passed to the superclass setClassplayer method.
     */
    public void setClassplayer(carcharacteristics myobj,int points){
        super.setClassplayer(myobj,points); 
        for(int i=0;i<playerclasses.length;i++){
           int a=i+1;
           System.out.println("Class "+a+" is: "+playerclasses[i]);
           System.out.println("Their ability of cornering their car on the track is :"+cornering[i]);
           System.out.println("Their ability of tenacity during fight scenarios and pressure is :"+tenacity[i]);
           System.out.println("Their ability of aggression during fight scenarios and racing is :"+aggression[i]);
           System.out.println("Points required for this class :"+pointsrequired[i]);
        }
        while(points>=0){
           int choice=inputInt("Now please choose your choice ranging from 1-4, where 1 is Engineer, 2 is Maniac, 3 is Farmer and 4 is Nomad");
           if(choice==1){
               System.out.println("You have chosen the class "+playerclasses[0]+". This class requires 4 points");
               if(myobj.points<4){
                   System.out.println("I'm sorry, you don't have enough points. Choose another option");
               }
               else{
                   myobj.playerclass="Engineer";
                   myobj.corneringrating="decent";
                   myobj.tenacityrating="poor";
                   myobj.aggressionrating="decent";
                   int a=myobj.points-4;
                   ((usercar)myobj).setPoints(a);
                   break;
               }    
           }
           else if(choice==2){
               System.out.println("You have chosen the class "+playerclasses[1]+". This class requires 6 points");
               if(myobj.points<6){
                   System.out.println("I'm sorry, you don't have enough points. Choose another option");
               }    
               else{
                   int a=myobj.points-6;
                   ((usercar)myobj).setPoints(a);
                   myobj.playerclass="Maniac";
                   myobj.corneringrating="poor";
                   myobj.tenacityrating="good";
                   myobj.aggressionrating="good";
                   break;
               }    
           }
           else if(choice==3){
               System.out.println("You have chosen the class "+playerclasses[2]+". This class requires 2 points");
               if(myobj.points<2){
                   System.out.println("I'm sorry you don't have enough points. Infact you don't have enough points to play this game. Please quit");
                   System.exit(0);
               }
               else{
                  int a=myobj.points-2;
                  ((usercar)myobj).setPoints(a);
                  myobj.playerclass="Farmer";
                  myobj.corneringrating="decent";
                  myobj.tenacityrating="poor";
                  myobj.aggressionrating="poor";
                  break;
               }  
           }
           else if(choice==4){
               System.out.println("You have chosen the class "+playerclasses[3]+". This class requires 7 points");
               if(myobj.points<7){
                   System.out.println("I'm sorry, you don't have enough points. Choose another option");
               }
               else{
                   int a=myobj.points-7;
                   ((usercar)myobj).setPoints(a);
                   myobj.playerclass="Nomad";
                   myobj.corneringrating="good";
                   myobj.tenacityrating="decent";
                   myobj.aggressionrating="good";
                   break;
               }    
           } 
           else{
               System.out.println("Enter a valid option please");
           } 
        }    
    }
    public boolean deadoralive(){
        if(this.health<=0){ 
            return true;
        }    
        else{
            return false;
        }    
    }  
    public static int inputInt(String message){
        Scanner scanner= new Scanner(System.in);
        System.out.println(message);
        int answer = Integer.parseInt(scanner.nextLine());
        return answer;
    }
}
