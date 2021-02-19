/*
this program should determine how far back from 
the car in front you should be based on your current speed
the dmv data recomended 10-15 seconds behind car in front of you
*/

package tailgate;

public class Tailgate {
        
        boolean nocars; //checks if no cars in front of you, true = no cars, false = car
        boolean maxspeed; //true = default to max speed limit. false= default to optimal speed
        float maxspeedlimit; //variable where the speed limit of the area should be stored, constantly updating should also be in mph format
        
        double userdis; //used to output message for user, should be provided by radar. should also be in miles
        float userspeed; //should be given by app, speed the user is traveling
        float optimaldistancelow; //determines lower bound of safe distance from next car
        float optimaldistanceupper;//determines upper bound of safe distance of next car                 

   public Tailgate(){ //built for testing
        nocars = false;
        maxspeedlimit = 60;
        userdis = 50; //how far in feet is the user from next car
        userspeed = 20;
        changemaxspeed();
        getoptimallimitlowerbound(userspeed);
        getoptimallimitupperbound(userspeed);
        getmessage();
    } 
        
    public boolean changemaxspeed(){ //changes whether we should be defaulting to max speed or not
    if(nocars==true){ //there are no cars in front
       maxspeed = true; //change to true so default speedlimit
       System.out.println("True");
       return (maxspeed); //returns maxspeed as true
    }
    else {//there are cars in front of you
        maxspeed = false; //don't defaut to max speed
        System.out.println("False");
        return(maxspeed); //returns maxspeed false
    }
    }
    public float getoptimallimitlowerbound(float userspeed1) { //will change default to max speed limit
    if (maxspeed == true){ //true = we should default to max speed limit
       optimaldistancelow = (maxspeedlimit-10); //lower bound, whatever the speedlimit is -10 
       System.out.println(optimaldistancelow);
       return(optimaldistancelow);
    }
    else { //not defaulting to max speed
      userspeed1 = userspeed; //converting miles per hour to miles per second
      optimaldistancelow = userspeed1*(2); //lower bound of how far back user should be. 10 seconds behind and then converted to feet 
      System.out.println(optimaldistancelow);
      return(optimaldistancelow);  
    }    
    }    
    
    public float getoptimallimitupperbound(float userspeed1) { //will change default to max speed limit
    if (maxspeed == true){ //true = we should default to max speed limit
       optimaldistanceupper = maxspeedlimit; //upper bound, whatever the speedlimit is in the area 
       System.out.println(optimaldistanceupper);
       return(optimaldistanceupper);
    }
    else { //not defaulting to max speed
        userspeed1 = userspeed; //converting miles per hour to miles per second
        optimaldistanceupper = userspeed1*(4); //upper bound of how far back you should be. 15 seconds behind then converted to feet
        System.out.println(optimaldistanceupper);
        return(optimaldistanceupper);  //returning upper bound 
    }    
    }
    
    public void getmessage(){
    if(userdis>optimaldistanceupper){
    System.out.println("You are too far!");
    }
    else if(userdis<optimaldistancelow){
    System.out.println("You are too close!");
    }
    else {
    System.out.println("Perfect!");
    }
    }
    public static void main(String[] args) {
    Tailgate test = new Tailgate();
    }
}