import java.util.Random;
public class carcharacteristics
{
    String brand;
    int points;
    double enginesize;
    int horsepower;
    String durability;
    int health;
    int firepower;
    String playerclass;
    String corneringrating;
    String tenacityrating;
    String aggressionrating; 
    /**
     * carcharacteristics Constructor
     *
     * @param brand A parameter argument passed from mainclass to initialise the instance String variable brand
     * @param enginesize A parameter argument passed from mainclass to initialise the instance double variable enginesize
     * @param horsepower A parameter argument passed from mainclass to initialise the instance integer variable horsepower
     * @param durability A parameter argument passed from mainclass to initialise the instance String variable durability
     */
    public carcharacteristics(String brand, double enginesize, int horsepower, String durability){
       this.brand=brand;
       this.enginesize=enginesize;
       this.horsepower=horsepower;
       this.durability=durability;
    }   
    public String getDurability(){
        return this.durability;
    }
    public String getBrand(){
        return this.brand;
    }
    public int getHorsepower(){
        return this.horsepower;
    }
    public double getEnginesize(){
        return this.enginesize;
    }  
    /**
     * Method setClassplayer
     *
     * @param myobj A parameter myobj is passed from the mainclass which will be the user's instance object and initialise all the variables to be default.
     * @param setpoints int points parameter will initialise the points value in the parameter 
     */
    public void setClassplayer(carcharacteristics myobj,int setpoints){//Override method
        myobj.points=setpoints; 
        myobj.health=100;
        myobj.firepower=50;
        myobj.playerclass="default";
        myobj.corneringrating="default";
        myobj.tenacityrating="default";
        myobj.aggressionrating="default";
    }
    public int getHealth(){
        return this.health;
    }    
    public int getFirepower(){
        return this.firepower;
    }    
    /**
     * Method setClassnonplayer
     *
     * @Takes parameter myobj of type carcharacteristics (which will be passed from mainclass) instance and initialises the instance variables of playerclass, corneringrating, tenacityrating and aggressionrating to be "default"
     */
    public void setClassnonplayer(carcharacteristics myobj){//Override method
       health=80;
       firepower=60;
       playerclass="default";
       corneringrating="default";
       tenacityrating="default";
       aggressionrating="default";
    }
    public void changePoints(int change){
        this.points+=change;
    }    
    public void changeHealth(int change){
       this.health=this.health+change; 
    }
    public void changeFirepower(int change){
        this.firepower=this.firepower+change;
    }    
    /**
     * Method carfight
     *
     * @param myobj A parameter myobj of type carcharacteristics which will be used by the subclass AIracers, which will be further used by subclasses Goblin and Orc
     * These subclasses will call upon the carfight method in the mainclass, and initialise the carfight to execute
     * @return The return value will be the final winner of the execution of the method. This method will be executed 2 times each by classes Orc and Goblin
     * carfight method will take random elements from both cartests and usertests and based upon the conditions below, will execute changes to the userracer object or the Orc/Goblin racer object
     */
    public int carfight(carcharacteristics myobj){//Override method
       Random random = new Random();
       String[] cartests={"test of engine size","test of horsepower","test of durability"};
       String[] usertests={"test of cornering","test of tenacity","test of aggression"};
       this.health-=5;
       int rnd1 = random.nextInt(cartests.length);
       int rnd2 = random.nextInt(usertests.length);
       String test1 = cartests[rnd1];
       String test2 = usertests[rnd2];
       int result=0; 
       if(test1.equals("test of engine size")){
           if(test2.equals("test of cornering")){
               System.out.println("This round will be a fight of the engine size rating and the driver's cornering ability rating");
               if(this.getEnginesize()>myobj.getEnginesize()){
                   System.out.println("The engine size of the enemy racer is bigger than the user racer's and therefore their skills will decide the winner of this round");
                   this.changeHealth(-5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.corneringrating.equals("good")||this.corneringrating.equals("decent")&&myobj.corneringrating.equals("poor")){
                       System.out.println("The enemy racer's cornering rating is good/decent while the user's cornering rating is poor");
                       this.changeHealth(-5);
                       myobj.changeHealth(-5);
                       result=1;
                   }    
                   else if(this.corneringrating.equals("good")&&myobj.corneringrating.equals("decent")){
                       System.out.println("The enemy's cornering rating is good but the user's cornering rating is decent");
                       this.changeHealth(2); 
                       myobj.changeHealth(-2);
                       result=1;
                   } 
                   else{
                       System.out.println("However the enemy racer does not have a superior cornering rating than the user racer");
                       this.changeHealth(-2);
                       myobj.changeHealth(-2);
                       myobj.changePoints(1);
                       result=0;
                   }    
               }
               else{
                   System.out.println("The engine size of the user's is far more superior to the enemy user's and therefore their skills will dictate the winner of this round");
                   this.changeHealth(-3);
                   myobj.changeHealth(2);
                   this.changeFirepower(-5);
                   myobj.changeFirepower(-3);
                   if(this.corneringrating.equals("good")||this.corneringrating.equals("decent")&&myobj.corneringrating.equals("poor")){
                       System.out.println("The enemy racer's cornering rating is good/decent while the user's cornering rating is poor");
                       this.changeHealth(-2);
                       myobj.changeHealth(-2);
                       result=0;
                   }    
                   else if(this.corneringrating.equals("good")&&myobj.corneringrating.equals("decent")){
                       System.out.println("The enemy racer has a superior cornering skill than the user's");
                       this.changeHealth(-4);
                       myobj.changeHealth(-2);
                       result=0;
                   }    
                   else{
                       System.out.println("The user has superior cornering skill than the enemy");
                       this.changeHealth(-5);
                       myobj.changeHealth(-5);
                       myobj.changePoints(2);
                       result=-1;
                   }    
               }  
           }
           else if(test2.equals("test of tenacity")){
               System.out.println("This round will be a fight of the engine size rating and driver's tenacity ability rating");
               if(this.getEnginesize()>myobj.getEnginesize()){
                   System.out.println("The engine size of the enemy racer is bigger than the user racer's and therefore their skills will decide the winner of this round");
                   this.changeHealth(-5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.tenacityrating.equals("good")||this.tenacityrating.equals("decent")&&myobj.tenacityrating.equals("poor")){
                       System.out.println("The enemy has a tenacity rating of good/decent while the user has a tenacity rating of poor");
                       this.changeHealth(-1);
                       myobj.changeHealth(-5);
                       result=1;
                   } 
                   else if(this.tenacityrating.equals("good")&&myobj.tenacityrating.equals("decent")){
                       System.out.println("The enemy has a superior tenacity rating");
                       this.changeHealth(-2);
                       myobj.changeHealth(-4);
                       result=1;
                   } 
                   else{
                       System.out.println("However the enemy racer does not have a superior tenacity rating than the user racer");
                       this.changeHealth(-5);
                       myobj.changeHealth(-3);
                       myobj.changePoints(1);
                       result=0;
                   }    
               }
               else{
                   System.out.println("The engine size of the user's is far more superior to the enemy user's and therefore their skills will dictate the winner of this round");
                   this.changeHealth(-3);
                   myobj.changeHealth(-2);
                   this.changeFirepower(-5);
                   myobj.changeFirepower(-3);
                   if(this.tenacityrating.equals("good")||this.tenacityrating.equals("decent")&&myobj.tenacityrating.equals("poor")){
                       System.out.println("The enemy has a tenacity rating of good/decent while the user has a tenacity rating of poor");
                       this.changeHealth(-2);
                       myobj.changeHealth(-4);
                       result=0;
                   } 
                   else if(this.tenacityrating.equals("good")&&myobj.tenacityrating.equals("decent")){
                       System.out.println("The enemy has a superior tenacity rating");
                       this.changeHealth(-1);
                       myobj.changeHealth(-4);
                       result=0;
                   } 
                   else{
                       System.out.println("The user has a superior/equal tenacity rating to the enemy racer's");
                       myobj.changePoints(2);
                       result=-1;
                   }    
               }    
           }
           else{
               System.out.println("This round will be a fight of the engine size rating and driver's aggression ability rating");
               if(this.getEnginesize()>myobj.getEnginesize()){
                   System.out.println("The engine size of the enemy racer is bigger than the user racer's and therefore their skills will decide the winner of this round");
                   this.changeHealth(-5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.aggressionrating.equals("good")||this.aggressionrating.equals("decent")&&myobj.aggressionrating.equals("poor")){
                       System.out.println("The enemy has an aggression rating of good/decent while the user has an aggression rating of poor");
                       this.changeHealth(-1);
                       myobj.changeHealth(-5);
                       result=1;
                   } 
                   else if(this.aggressionrating.equals("good")&&myobj.aggressionrating.equals("decent")){
                       System.out.println("The enemy has a superior aggression rating");
                       this.changeHealth(-2);
                       myobj.changeHealth(-4);
                       result=1;
                   }    
                   else{
                       System.out.println("However the enemy racer does not have a superior aggression rating than the user racer");
                       myobj.changePoints(1);
                       result=0;
                   }    
               }
               else{
                  System.out.println("The engine size of the user's is far more superior to the enemy user's and therefore their skills will dictate the winner of this round");
                  this.changeHealth(-5);
                  myobj.changeHealth(-5);
                  this.changeFirepower(-5);
                  myobj.changeFirepower(-3); 
                  if(this.aggressionrating.equals("good")||this.aggressionrating.equals("decent")&&myobj.aggressionrating.equals("poor")){
                       System.out.println("The enemy has an aggression rating of good/decent while the user has an aggression rating of poor");
                       this.changeHealth(-2);
                       myobj.changeHealth(-5);
                       result=0;
                  }  
                  else if(this.aggressionrating.equals("good")&&myobj.aggressionrating.equals("decent")){
                       System.out.println("The enemy has a superior aggression rating");
                       this.changeHealth(-3);
                       myobj.changeHealth(-4);
                       result=0;
                  }    
                  else{
                      System.out.println("The user has a superior/equal aggression rating to the enemy racer's");
                      this.changeHealth(-5);
                      myobj.changeHealth(-1);
                      myobj.changePoints(2);
                      result=-1;
                  }
               }    
           }    
       }    
       else if(test1.equals("test of horsepower")){
           if(test2.equals("test of cornering")){
               System.out.println("This round will be a fight of the car's horsepower rating and driver's cornering ability rating");
               if(this.getHorsepower()>myobj.getHorsepower()){
                   System.out.println("The horse power of the enemy is bigger than the user racer's and therefore their individual class skills will decide the winner of this round");
                   this.changeHealth(-5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.corneringrating.equals("good")||this.corneringrating.equals("decent")&&myobj.corneringrating.equals("poor")){
                       System.out.println("The enemy racer's cornering rating is good/decent while the user's cornering rating is poor");
                       this.changeHealth(-1);
                       myobj.changeHealth(-5);
                       result=1;
                   }    
                   else if(this.corneringrating.equals("good")&&myobj.corneringrating.equals("decent")){
                       System.out.println("The enemy racer has a superior cornering skill than the user's");
                       this.changeHealth(-2); 
                       myobj.changeHealth(-4);
                       result=1;
                   } 
                   else{
                       System.out.println("However the user has superior cornering skill than the enemy");
                       this.changeHealth(-3);
                       myobj.changeHealth(-3);
                       myobj.changePoints(1);
                       result=0;
                   }    
               }
               else{
                   System.out.println("The horsepower of the user's is far more superior to the enemy user's and therefore their skills will dictate the winner of this round");
                   this.changeHealth(-3);
                   myobj.changeHealth(2);
                   this.changeFirepower(-5);
                   myobj.changeFirepower(-3);
                   if(this.corneringrating.equals("good")||this.corneringrating.equals("decent")&&myobj.corneringrating.equals("poor")){
                       System.out.println("The enemy racer's cornering rating is good/decent while the user's cornering rating is poor");
                       this.changeHealth(2);
                       myobj.changeHealth(-3);
                       result=0;
                   }    
                   else if(this.corneringrating.equals("good")&&myobj.corneringrating.equals("decent")){
                       System.out.println("The enemy racer has a superior cornering skill than the user's");
                       this.changeHealth(4);
                       myobj.changeHealth(-2);
                       result=0;
                   }    
                   else{
                       System.out.println("The user has a superior/equal cornering rating to the enemy racer's");
                       result=-1;
                   }    
               }  
           }
           else if(test2.equals("test of tenacity")){
               System.out.println("This round will be a fight of the car's horsepower rating and driver's tenacity ability rating"); 
               if(this.getHorsepower()>myobj.getHorsepower()){
                   System.out.println("The horsepower of the enemy racer is bigger than the user racer's and therefore their skills will decide the winner of this round");
                   this.changeHealth(5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.tenacityrating.equals("good")||this.tenacityrating.equals("decent")&&myobj.tenacityrating.equals("poor")){
                       System.out.println("The enemy racer's tenacity rating is good/decent while the user's tenacity rating is poor");
                       this.changeHealth(5);
                       myobj.changeHealth(-5);
                       this.changePoints(2);
                       result=1;
                   } 
                   else if(this.tenacityrating.equals("good")&&myobj.tenacityrating.equals("decent")){
                       System.out.println("The enemy has a superior tenacity rating");
                       this.changeHealth(4);
                       myobj.changeHealth(-2);
                       this.changePoints(1);
                       result=1;
                   } 
                   else{
                       System.out.println("The user has a superior/equal tenacity rating to the enemy racer's");
                       this.changeHealth(-3);
                       myobj.changeHealth(-3);
                       result=0;
                   }  
               }
               else{
                   System.out.println("The horsepower of the user's is far more superior to the enemy user's and therefore their skills will dictate the winner of this round");
                   this.changeHealth(-3);
                   myobj.changeHealth(2);
                   this.changeFirepower(-5);
                   myobj.changeFirepower(-5);
                   if(this.tenacityrating.equals("good")||this.tenacityrating.equals("decent")&&myobj.tenacityrating.equals("poor")){
                       System.out.println("The enemy racer's tenacity rating is good/decent while the user's tenacity rating is poor");
                       this.changeHealth(2);
                       myobj.changeHealth(-3);
                       result=0;
                   } 
                   else if(this.tenacityrating.equals("good")&&myobj.tenacityrating.equals("decent")){
                       System.out.println("The enemy has superior tenacity skill");
                       this.changeHealth(4);
                       myobj.changeHealth(-2);
                       result=0;
                   } 
                   else{
                       System.out.println("The user has superior tenacity skill than the enemy");
                       this.changeHealth(-5);
                       myobj.changeHealth(-2);
                       myobj.changePoints(2);
                       result=-1;
                   } 
               }    
           }
           else{
               System.out.println("This round will be a fight of the car's horsepower rating and driver's aggression ability rating");
               if(this.getHorsepower()>myobj.getHorsepower()){
                   System.out.println("The horsepower of the enemy racer is bigger than the user racer's and therefore their skills will decide the winner of this round");
                   this.changeHealth(5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.aggressionrating.equals("good")||this.aggressionrating.equals("decent")&&myobj.aggressionrating.equals("poor")){
                       System.out.println("The enemy racer's aggression rating is good/decent while the user's aggression rating is poor");
                       this.changeHealth(-1);
                       myobj.changeHealth(-5);
                       result=1;
                   } 
                   else if(this.aggressionrating.equals("good")&&myobj.aggressionrating.equals("decent")){
                       System.out.println("The enemy has a superior aggression rating than the user");
                       this.changeHealth(-2);
                       myobj.changeHealth(-4);
                       result=1;
                   }    
                   else{
                       System.out.println("However, the user has superior aggression skill than the enemy");
                       myobj.changePoints(1);
                       result=0;
                   }    
               }
               else{
                  System.out.println("The horsepower of the user's is far more superior to the enemy user's and therefore their skills will dictate the winner of this round");
                  this.changeHealth(-3);
                  myobj.changeHealth(2);
                  this.changeFirepower(-5);
                  myobj.changeFirepower(-3);
                  if(this.aggressionrating.equals("good")||this.aggressionrating.equals("decent")&&myobj.aggressionrating.equals("poor")){
                      System.out.println("The enemy racer's aggression rating is good/decent while the user's aggression rating is poor");
                      this.changeHealth(-1);
                      myobj.changeHealth(-5);
                      result=0;
                  }  
                  else if(this.aggressionrating.equals("good")&&myobj.aggressionrating.equals("decent")){
                       System.out.println("The enemy has a superior aggression rating than the user");
                       this.changeHealth(-2);
                       myobj.changeHealth(-4);
                       result=0;
                  }    
                  else{
                      System.out.println("The user has superior aggression skill than the enemy");
                      myobj.changePoints(2);
                      myobj.changeHealth(-2);
                      this.changeHealth(-6);
                      result=-1;
                  }
               }   
           } 
       }
       else if(test1.equals("test of durability")){
           if(test2.equals("test of cornering")){
               System.out.println("This round will be a fight of the car's durability rating and driver's cornering ability rating");
               if(this.getDurability().equals("good")||this.getDurability().equals("decent")&&myobj.getDurability().equals("poor")){
                   System.out.println("The enemy racer has a much more superior durability rating (good/decent) than the user racer (poor). Therefore, their individual skills will define the outcome of this round");
                   this.changeHealth(-5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.corneringrating.equals("good")||this.corneringrating.equals("decent")&&myobj.corneringrating.equals("poor")){
                       System.out.println("The enemy racer's cornering rating is good/decent while the user's cornering rating is poor");
                       this.changeHealth(-1);
                       myobj.changeHealth(-5);
                       result=1;
                   }    
                   else if(this.corneringrating.equals("good")&&myobj.corneringrating.equals("decent")){
                       System.out.println("The enemy has a superior cornering rating than the user");
                       this.changeHealth(-2); 
                       myobj.changeHealth(-4);
                       result=1;
                   } 
                   else{
                       System.out.println("However, the user has superior cornering skill than the enemy");
                       this.changeHealth(-3);
                       myobj.changeHealth(-3);
                       myobj.changePoints(1);
                       result=0;
                   }    
               }
               else{
                   System.out.println("The user has a far more durable car than the enemy user's, and therefore their individual class skills will define the outcome of this round");
                   this.changeHealth(-3);
                   myobj.changeHealth(2);
                   this.changeFirepower(-5);
                   myobj.changeFirepower(-3);
                   if(this.corneringrating.equals("good")||this.corneringrating.equals("decent")&&myobj.corneringrating.equals("poor")){
                       System.out.println("The enemy racer's cornering rating is good/decent while the user's cornering rating is poor");
                       this.changeHealth(2);
                       myobj.changeHealth(-3);
                       result=0;
                   }    
                   else if(this.corneringrating.equals("good")&&myobj.corneringrating.equals("decent")){
                       System.out.println("The enemy has a superior cornering rating than the user");
                       this.changeHealth(4);
                       myobj.changeHealth(-2);
                       result=0;
                   }    
                   else{
                       System.out.println("The user has superior cornering skill than the enemy");
                       myobj.changePoints(2);
                       this.changeHealth(-5);
                       myobj.changeHealth(-2);
                       result=-1;
                   }    
               }  
           }
           else if(test2.equals("test of tenacity")){
               System.out.println("This round will be a fight of the car's durability rating and driver's tenacity ability rating");
               if(this.getDurability().equals("good")||this.getDurability().equals("decent")&&myobj.getDurability().equals("poor")){
                   System.out.println("The enemy racer has a much more superior durability rating (good/decent) than the user racer (poor). Therefore, their individual skills will define the outcome of this round");
                   this.changeHealth(5);
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.tenacityrating.equals("good")||this.tenacityrating.equals("decent")&&myobj.tenacityrating.equals("poor")){
                       System.out.println("The enemy has a tenacity rating of good/decent while the user has a tenacity rating of poor");
                       this.changeHealth(5);
                       myobj.changeHealth(-5);
                       this.changePoints(2);
                       result=1;
                   } 
                   else if(this.tenacityrating.equals("good")&&myobj.tenacityrating.equals("decent")){
                       System.out.println("The enemy has a superior tenacity rating than the user");
                       this.changeHealth(4);
                       myobj.changeHealth(-2);
                       this.changePoints(1);
                       result=1;
                   } 
                   else{
                       System.out.println("However, the user has superior tenacity skill than the enemy");
                       this.changeHealth(-3);
                       myobj.changeHealth(-3);
                       result=0;
                   }  
               }
               else{
                   System.out.println("The user has a far more durable car than the enemy user's, and therefore their individual class skills will define the outcome of this round");
                   this.changeHealth(-3);
                   myobj.changeHealth(2);
                   this.changeFirepower(-5);
                   myobj.changeFirepower(-3);
                   if(this.tenacityrating.equals("good")||this.tenacityrating.equals("decent")&&myobj.tenacityrating.equals("poor")){
                       System.out.println("The enemy racer's tenacity rating is good/decent while the user's tenacity rating is poor");
                       this.changeHealth(2);
                       myobj.changeHealth(-3);
                       result=0;
                   }    
                   else if(this.tenacityrating.equals("good")&&myobj.tenacityrating.equals("decent")){
                       System.out.println("The enemy has a superior tenacity rating than the user");
                       this.changeHealth(4);
                       myobj.changeHealth(-2);
                       result=0;
                   }    
                   else{
                       System.out.println("The user has superior tenacity skill than the enemy");
                       myobj.changePoints(2);
                       this.changeHealth(-5);
                       myobj.changeHealth(-2);
                       result=-1;
                   }    
               }  
           } 
           else{
               System.out.println("This round will be a fight of the car's durability rating and driver's aggression ability rating");
               if(this.getDurability().equals("good")||this.getDurability().equals("decent")&&myobj.getDurability().equals("poor")){
                   System.out.println("The enemy racer has a much more superior durability rating (good/decent) than the user racer (poor). Therefore, their individual skills will define the outcome of this round");
                   this.changeHealth(5); 
                   myobj.changeHealth(-5);
                   this.changeFirepower(-2);
                   myobj.changeFirepower(-2);
                   if(this.aggressionrating.equals("good")||this.aggressionrating.equals("decent")&&myobj.aggressionrating.equals("poor")){
                       System.out.println("The enemy racer's aggression rating is good/decent while the user's aggression rating is poor");
                       this.changeHealth(-1);
                       myobj.changeHealth(-5);
                       result=1;
                   } 
                   else if(this.aggressionrating.equals("good")&&myobj.aggressionrating.equals("decent")){
                       System.out.println("The enemy has a superior aggression rating than the user");
                       this.changeHealth(-2);
                       myobj.changeHealth(-4);
                       result=1;
                   }    
                   else{
                       System.out.println("However, the user has superior aggression skill than the enemy");
                       myobj.changePoints(1);
                       result=0;
                   }    
               }
               else{
                  System.out.println("The user has a far more durable car than the enemy user's, and therefore their individual class skills will define the outcome of this round");
                  this.changeHealth(-3);
                  myobj.changeHealth(2);
                  this.changeFirepower(-5);
                  myobj.changeFirepower(-3);
                  if(this.aggressionrating.equals("good")||this.aggressionrating.equals("decent")&&myobj.aggressionrating.equals("poor")){
                       System.out.println("The enemy racer's aggression rating is good/decent while the user's aggression rating is poor");
                       this.changeHealth(-1);
                       myobj.changeHealth(-5);
                       result=0;
                  }  
                  else if(this.aggressionrating.equals("good")&&myobj.aggressionrating.equals("decent")){
                      System.out.println("The enemy has a superior aggression rating than the user");
                       this.changeHealth(-2);
                       myobj.changeHealth(-4);
                       result=0;
                  }    
                  else{
                      System.out.println("The user has superior aggression skill than the enemy");
                      myobj.changePoints(2);
                      myobj.changeHealth(-2);
                      this.changeHealth(-6);
                      result=-1;
                  }
               }   
           }  
       }    
       return result;
    }    
}
