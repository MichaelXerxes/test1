package Assigment2OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Hazard extends Policy {
   final protected int flatRate=14;
   protected String destination;
   public Hazard(){
       destination=" ";
       numberTravelers=0;
       getTypeofactivity();
   }
   public Hazard(int newnumberTravelkers,String newdestination){
       this.destination=newdestination;
       this.numberTravelers=newnumberTravelkers;
       getDestination();
       getTypeofactivity();

   }

   public int getNumberTravelers(){return this.numberTravelers;}
   public void setDestination(int index){
       this.destination=destinations.get(index);
   }
   public ArrayList<String> getDestination(){
        return this.destinations;
   }
   public void setTypeofactivity(ArrayList<String> Typeofactivity){

       this.Typeofactivity=Typeofactivity;
   }
    public void setNumberTravelers(int numberofTravelers){
        this.numberTravelers=numberofTravelers;
    }
   public ArrayList<String> getTypeofactivity(){
       return  this.Typeofactivity;
   }
   public Object ChooseHaz(){
       Scanner keyboard=new Scanner(System.in);
       int index=-1;
       Hazard b=new Hazard();
       getTypeofactivity();
       getDestination();
       System.out.println("How many Travelers ?");
       setNumberTravelers(keyboard.nextInt());
       System.out.println("Choose destination from list");
       for(int i=0;i<destinations.size();i++){
           String str=destinations.get(i);

           System.out.println(str+" "+destinations.indexOf(str));
       }
       System.out.println("Choose 1 or 2 or 3 or 4");
       index=keyboard.nextInt();
       setDestination(index-1);
       return b;
   }
   public String toStringHaz(){
       return this.Typeofactivity+" "+this.destinations+" "+this.numberTravelers+" "+this.Levels;
   }
   public void DispalyHaz(){
       ChooseHaz();
       System.out.println(toStringHaz());
   }
}
