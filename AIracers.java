import java.util.Random;
public class AIracers extends carcharacteristics
{
    String brand;
    double enginesize;
    int horsepower;
    String durability;
    String playerclass;
    String[] attributes;
    String enemytype;  
    boolean deadoralive;
    String[] playerclasses={"Engineer","Maniac","Farmer","Nomad"};
    String[] cornering={"decent","poor","decent","good"};
    String[] tenacity = {"poor","good","poor","decent"};
    String[] aggression={"decent","good","poor","good"};
    public AIracers(String brand, double enginesize, int horsepower, String durability){
        super(brand,enginesize,horsepower,durability);
    }
    public void setClassnonplayer(carcharacteristics myobj){
        Random random = new Random();
        super.setClassnonplayer(myobj);
        int rnd = random.nextInt(playerclasses.length);
        myobj.playerclass=playerclasses[rnd];
        myobj.corneringrating=cornering[rnd];
        myobj.tenacityrating=tenacity[rnd];
        myobj.aggressionrating=aggression[rnd];
    }
    public int carfight(carcharacteristics myobj){
        int result=super.carfight(myobj);
        return result;
    }    
    public void deadoralive(carcharacteristics myobj){
        if(myobj.health<=0){
            this.deadoralive=true;
        }    
        else{
            this.deadoralive=false;
        }    
    } 
    public boolean getdeadoralive(){
        return this.deadoralive;
    }    
    public void setEnemytype(String enemytype){
        this.enemytype=enemytype;
    } 
    public String getEnemytype(){
        return this.enemytype;
    }    
}
