import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;  
/**
 * Mad-Max Fury Road esque game where cars battle it out over the worst conditions
 * simulated to win the grand prize at the end. 
 * Welcome to the Golden Requiem : F-mega race.
 *
 * @Shorya Sinha (your name)
 * @version 1 (a version number or a date)
 */

public class mainclass
{
    /**
     * Method main
     * This method main will be used to run the simulation of the entire game and redirect values to other classes such as carcharacteristics
     * and it's subclasses such as AIracers and usercar. AIracers also has subclasses Orc and Goblin and the method main will also redirect and initialise
     * objects/instances of those classes using substitution principle and polymorphism. To access methods which are only part of the subclasses and not
     * the superclass, we use dynamic binding referencing. There is also a call to the constructor of the class racetrack which will initialise the position
     * value there and also create a method called seteventlikelihood which is the gateway probability method to execute the fight method of the carcharacteristics class.
     */
    public static void main(String[] args){
        
        Random random = new Random();
        System.out.println("**************************************"); 
        System.out.println("****Welcome fellow Champion racer!****");
        System.out.println("To a racing game where you fight to win and move up the ladder");
        System.out.println("Now follow the guidelines of details presented to you. If you don't then you will be axed unfortunately ;))");
        int enemies = random.nextInt((10-5))+5;
        System.out.println("Looks like there are "+enemies+" enemies ready to challenge you!");
        final int racers = enemies+1;
        System.out.println("There are "+racers+" participating in this racing simulator");
        ArrayList<AIracers> allAIracecars = new ArrayList<AIracers>();
        carcharacteristics userracerobj = new usercar("default",0,0,"default"); 
        final int usernum= random.nextInt(racers);
        System.out.println("Looks like you are the "+(usernum+1)+" st/nd/th/rd racer"); 
        int points=12;
        int count=0;
        AIracers[] randomarray = {new AIracers("Ford",2.1,285,"decent"), new AIracers("Subaru",1.6,200,"poor"), new AIracers("Jeep",2.5,300,"top"),new AIracers("Mitsubishi",1.8,211,"great")};
        for(int i=0;i<racers;i++){
            if(i==usernum){
                System.out.println("You have 4 cars to choose from as a base option. You are given 12 points to choose from. ");
                System.out.println("Car 1- Brand: Ford, Engine size: 2.1, Horsepower:  285, Base model durability: decent. Points you spend: 6");
                System.out.println("Car 2- Brand: Subaru, Engine size: 1.6, Horsepower: 200, Base model durability: poor. Points you spend: 3");
                System.out.println("Car 3- Brand: Jeep, Engine size: 2.5 Horsepower: 300, Base model durability: top. Points you spend: 9");
                System.out.println("Car 4- Brand: Mitsubishi, Engine size: 1.8, Horsepower: 211, Base model durability: great. Points you spend 8");
                int choice = inputInt("Enter only 1-4 to choose which base model of car you will select.");
                if (choice>4 || choice<1){
                    System.out.println("Invalid entry. You are to be axed. Goodbye");
                    System.exit(0);
                }    
                else{
                    if(choice==1){
                        points=6;
                        carcharacteristics tempmyobj = new usercar("Ford",2.1,285,"decent");
                        ((usercar)tempmyobj).setPosition(usernum);
                        ((usercar)tempmyobj).setPoints(points);
                        userracerobj=tempmyobj;
                    }
                    else if(choice==2){
                        points=9;
                        carcharacteristics tempmyobj = new usercar("Subaru",1.6,200,"poor");
                        ((usercar)tempmyobj).setPosition(usernum);
                        ((usercar)tempmyobj).setPosition(usernum);
                        userracerobj=tempmyobj;
                    }
                    else if(choice==3){
                        points=3;
                        carcharacteristics tempmyobj = new usercar("Jeep",2.5,300,"good");
                        ((usercar)tempmyobj).setPosition(usernum);
                        ((usercar)tempmyobj).setPosition(usernum);
                        userracerobj=tempmyobj;
                    }
                    else{
                        points=4;
                        carcharacteristics tempmyobj = new usercar("Mitsubishi",1.8,211,"decent");
                        ((usercar)tempmyobj).setPosition(usernum);
                        ((usercar)tempmyobj).setPosition(usernum);
                        userracerobj = tempmyobj;
                    }    
                }  
            }
            else{
                 int randomcar= random.nextInt(randomarray.length);
                 allAIracecars.add(randomarray[randomcar]); 
                 count+=1;
            }  
        }
        System.out.println("***You currently have "+points+" to spend***"); 
        System.out.println("Now you will choose a set of characteristics for your car depending upon the points available. Choose wisely");
        System.out.println("These set of characteristics are based upon choosing the class for your character. The class of the character also defines the fighting ability, however the car is the major factor");
        System.out.println("Enemy types will be set. With goblin racers being the weakest and having low firepower while Orc racers being the strongest and having greater firepower");
        ArrayList<carcharacteristics> allAIobjects = new ArrayList<carcharacteristics>();  
        int count1=0;
        for(int i=0;i<racers;i++){
            if(i==usernum){
               System.out.println("The user will now choose their playerclass from the details which will be provided below: ");
               userracerobj.setClassplayer(userracerobj,points);
               allAIobjects.add(null);
            }
            else{
               if(i%2==0){
                  carcharacteristics AIobj = allAIracecars.get(count1);
                  count1+=1;
                  AIracers myobj1 = new Orc(AIobj.getBrand(),AIobj.getEnginesize(),AIobj.getHorsepower(),AIobj.getDurability());
                  ((AIracers)myobj1).setEnemytype("Orc");
                  myobj1.setClassnonplayer(AIobj);
                  ((Orc)myobj1).setClassnonplayer(myobj1);
                  ((Orc)myobj1).setPosition(i);
                  allAIobjects.add(myobj1); 
               }
               else{
                  carcharacteristics AIobj = allAIracecars.get(count1);
                  count1+=1;
                  AIracers myobj2 = new Goblin(AIobj.getBrand(),AIobj.getEnginesize(),AIobj.getHorsepower(),AIobj.getDurability());
                  myobj2.setClassnonplayer(AIobj);
                  ((AIracers)myobj2).setEnemytype("Goblin");
                  ((Goblin)myobj2).setPosition(i);
                  ((Goblin)myobj2).setClassnonplayer(myobj2);
                  allAIobjects.add(myobj2);
               }     
            }    
        }  
        int rounds=0; 
        racetrack.racetrack(usernum);  
        while(rounds!=7){
              int randomfighter = random.nextInt(allAIobjects.size());
              carcharacteristics randomAItype = allAIobjects.get(randomfighter);
              boolean deadoralive=((usercar)userracerobj).deadoralive();
              if(deadoralive==true){
                   System.out.println("User is dead. Game over.");
                   System.exit(0);
              }
              else{
                   if(allAIobjects.get(randomfighter)!=null){
                       String enemytype=((AIracers)randomAItype).getEnemytype(); 
                       if(enemytype.equals("Orc")){
                           System.out.println("An Orc racer seems to be challenging the user for a fight");
                           int enemypos=randomfighter+1;
                           ((Orc)randomAItype).setPosition(randomfighter);
                           System.out.println("The position of the orc racer is : "+enemypos);
                           int result=((Orc)randomAItype).carfight(userracerobj);   
                           if(result==-2){
                               System.out.println("The low probability of this fight means it cannot take place!"); 
                           }    
                           else{ 
                                if(result==1){
                                    int aiposition= ((Orc)randomAItype).getPosition();
                                    int userposition=((usercar)userracerobj).getPosition();
                                    int printaipos=aiposition+1;
                                    int userprintpos=userposition+1;
                                    if(aiposition<userposition){
                                        System.out.println("User has overtaken the enemy Orc racer and is now placed at "+printaipos+".");
                                        ((usercar)userracerobj).setPosition(printaipos);
                                        System.out.println("The Orc racer slips down to the user's position");
                                        ((Orc)randomAItype).setPosition(userposition);
                                        allAIobjects.set(userposition,randomAItype);
                                        allAIobjects.set(aiposition,null);
                                        ((AIracers)randomAItype).deadoralive(randomAItype);
                                        boolean aideadoralive=((AIracers)randomAItype).getdeadoralive();
                                        if(aideadoralive==true){
                                            System.out.println("You have killed the Orc racer");
                                            allAIobjects.remove(randomfighter);
                                            System.out.println("You get 2 points");
                                            userracerobj.changePoints(2);
                                            System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                                        }
                                    }    
                                    else{
                                        System.out.println("User has defeated the Orc racer in total. The user remains in "+userposition+" place.");
                                        System.out.println("Since the user is already in a higher position, both racers remain in the same place");
                                        ((AIracers)randomAItype).deadoralive(randomAItype);
                                        boolean aideadoralive=((AIracers)randomAItype).getdeadoralive();
                                        if(aideadoralive==true){
                                            System.out.println("You have killed the Orc racer");
                                            allAIobjects.remove(randomfighter);
                                            System.out.println("You get 2 points");
                                            userracerobj.changePoints(2);
                                            System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                                        }  
                                    }    
                                }
                                else if(result==0){
                                    int aiposition= ((Orc)randomAItype).getPosition();
                                    int userposition=((usercar)userracerobj).getPosition();
                                    int printaipos=aiposition+1;
                                    int userprintpos=userposition+1;
                                    System.out.println("The Orc racer at position "+printaipos+" and the User racer have reached a stalemate");
                                    System.out.println("User remains at position "+userprintpos);
                                    System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                                }
                                else{
                                    int aiposition= ((Orc)randomAItype).getPosition();
                                    int userposition=((usercar)userracerobj).getPosition();
                                    int printaipos=aiposition+1;
                                    int userprintpos=userposition+1;
                                    System.out.println("User has lost the fight to Orc racer at position "+printaipos+".");
                                    System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                                    System.out.println("User will lose 2 points for the loss");
                                    if(aiposition<userposition){
                                        System.out.println("Orc racer keeps it's position");
                                        System.out.println("User racer keeps it's position");
                                    }    
                                    else{
                                        System.out.println("User racer loses it's position to the Orc racer");
                                        ((usercar)userracerobj).setPosition(aiposition);
                                        System.out.println("User racer is now placed at "+printaipos+" place");
                                        allAIobjects.set(aiposition,null);
                                        allAIobjects.set(userposition,randomAItype);
                                    }    
                                    userracerobj.changePoints(-2);
                                }    
                           }
                       }
                       else{
                           System.out.println("A Goblin racer seems to be challenging the user for a fight"); 
                           int enemypos=randomfighter+1;
                           ((Goblin)randomAItype).setPosition(randomfighter);
                           System.out.println("The position of the Goblin racer is : "+enemypos);
                           int result=((Goblin)randomAItype).carfight(userracerobj); 
                           if(result==-2){
                                System.out.println("The low probability of this fight means it cannot take place!");
                           }    
                           else{
                               if(result==1){
                                   int aiposition= ((Goblin)randomAItype).getPosition(); 
                                   int userposition=((usercar)userracerobj).getPosition();
                                   int printaipos=aiposition+1; 
                                   int userprintpos=userposition+1;
                                   if(aiposition<userposition){
                                       System.out.println("User has defeated the Goblin racer.");
                                       System.out.println("User has overtaken the enemy Goblin racer and is now placed at "+printaipos+".");
                                       ((usercar)userracerobj).setPosition(aiposition);
                                       System.out.println("The Goblin racer slips down to the user's position");
                                       ((Goblin)randomAItype).setPosition(userposition);
                                       ((Goblin)randomAItype).deadoralive(randomAItype);
                                       ((AIracers)randomAItype).deadoralive(randomAItype);
                                       boolean aideadoralive=((AIracers)randomAItype).getdeadoralive();
                                       allAIobjects.set(userposition,randomAItype);
                                       allAIobjects.set(aiposition,null);
                                       if(aideadoralive==true){
                                           System.out.println("The Goblin racer has been slain by the user");
                                           allAIobjects.remove(randomfighter);
                                           System.out.println("You get no points since they are easy to kill");
                                           System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                                        }    
                                   }    
                                   else{ 
                                       System.out.println("User has defeated the Goblin racer. The user remains in "+userprintpos+" place.");
                                       ((AIracers)randomAItype).deadoralive(randomAItype);
                                       boolean aideadoralive=((AIracers)randomAItype).getdeadoralive();
                                       if(aideadoralive==true){
                                           System.out.println("You have killed the Goblin racer"); 
                                           allAIobjects.remove(randomfighter);
                                           System.out.println("You get no points since they are easy to kill");
                                           System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                                        }  
                                   }    
                               }
                               else if(result==0){
                                    int aiposition= ((Goblin)randomAItype).getPosition();
                                    int userposition=((usercar)userracerobj).getPosition();
                                    int printaipos=aiposition+1;
                                    int userprintpos=userposition+1;
                                    System.out.println("User racer and the Goblin racer have reached a stalemate");
                                    System.out.println("User remains at position "+userprintpos+" place.");
                                    System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                               } 
                               else{
                                    int aiposition= ((Goblin)randomAItype).getPosition();
                                    int userposition=((usercar)userracerobj).getPosition();
                                    int printaipos=aiposition+1;
                                    int userprintpos=userposition+1;
                                    System.out.println("User has lost the fight to Goblin racer at position "+printaipos+".");
                                    System.out.println("The user has currently "+((usercar)userracerobj).getPoints()+" points.");
                                    System.out.println("User will lose 5 points for the loss");
                                    if(aiposition<userposition){
                                        System.out.println("Since it's victory for the Goblin racer, both racers will keep their positions");
                                        System.out.println("Goblin racer keeps it's position");
                                        System.out.println("User racer keeps it's position");
                                    }    
                                    else{
                                        System.out.println("User racer loses it's position to the Goblin racer");
                                        ((usercar)userracerobj).setPosition(aiposition);
                                        System.out.println("User racer is now placed at "+printaipos+" place");
                                        allAIobjects.set(aiposition,null);
                                        allAIobjects.set(userposition,randomAItype);
                                    }    
                                    userracerobj.changePoints(-5);
                               }    
                            }
                       }
                       System.out.println("The user's health currently is "+userracerobj.getHealth());
                       System.out.println("The user car's firepower currently is "+userracerobj.getFirepower());
                       rounds+=1; 
                    }
              }     
        }
        int userposition=((usercar)userracerobj).getPosition();  
        if(userposition!=0){
            System.out.println("Within these 7 rounds, you have not been able to remain first. Therefore you have lost this game");
            System.exit(0);
        }    
        else{
            System.out.println("You have won the race by keeping the podium place until the end! Well done.");
        }    
    } 
    public static String inputString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String answer = scanner.nextLine();
        return answer;
    }
    public static int inputInt(String message){
        Scanner scanner= new Scanner(System.in);
        System.out.println(message);
        int answer = Integer.parseInt(scanner.nextLine());
        return answer;
    }
}
