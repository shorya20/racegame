public class Orc extends AIracers
{
   int position;
   public Orc(String brand, double enginesize, int horsepower, String durability){
       super(brand,enginesize,horsepower,durability);
   } 
   public void setPosition(int position){
       this.position=position;
   }    
   public int getPosition(){
       return this.position;
   }  
   public boolean returnlikelihood(carcharacteristics userobj){
       return event.seteventlikelihood(((usercar)userobj).getPosition(),this.getPosition());  
   } 
   public void setClassnonplayer(carcharacteristics myobj){
       super.setClassnonplayer(myobj);
       myobj.health=90;
   }    
   public int carfight(carcharacteristics userobj){ 
       boolean fight=returnlikelihood(userobj); 
       int finalresult=0;
       int result=0;
       int result1=0; 
       int result2=0; 
       if(fight==true){
           System.out.println("Orc deals heavy damages to the user's health if the user loses");
           for(int i=0;i<2;i++){ 
               if(i==0){
                   result = super.carfight(userobj);
                   if(result==1){
                       System.out.println("User has lost the first round to Orc racer "+(this.position+1)+".");
                       userobj.changeHealth(-25);
                       System.out.println("User loses 25 health");
                       System.out.println("User loses 10 firepower");
                       userobj.changeFirepower(-10);
                       result1=-1;
                   }
                   else if(result==0){
                       System.out.println("User has drawn the first round to Orc racer "+(this.position+1)+".");
                       result1=0;
                   }
                   else{
                       System.out.println("User has won the first round to Orc racer "+(this.position+1)+".");
                       result1=1;
                   }
               }    
               else{
                    result = super.carfight(userobj);
                    if(result==1){
                        System.out.println("User has lost the second round to Orc racer "+(this.position+1)+".");
                        result2=-1;
                    }
                    else if(result==0){
                        System.out.println("User has drawn the second round to Orc racer "+(this.position+1)+".");
                        result2=0;
                    }
                    else{
                         System.out.println("User has won the second round to Orc racer "+(this.position+1)+".");
                         result2=1;
                    }
               }         
           }
           if(result1==1 && result2==1){
               finalresult=1;
           }
           else if(result1==1 && result2==0 || result1==0 && result2==1){
               finalresult=1;
           }   
           else if(result1==-1 && result2==1 || result1==-1 && result2==1){
               finalresult=0;
           }   
           else if(result1==-1 && result2==0 || result1==0 && result2==-1){
               finalresult=-1;
           }    
           else if(result1==0 && result2==0){
               finalresult=0;
           }    
           else{
                finalresult=-1;
           }    
       }
       else{
           finalresult=-2; 
       }    
       return finalresult; 
    }     
}
