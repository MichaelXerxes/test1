package Assigment2OOP;
import java.util.Scanner;
public class Row extends Policy{
    Scanner keyboard=new Scanner(System.in);
    private String destination;
   // private int numberofTravelers;
    public Row(){
      destination=" ";
      numberTravelers=0;
    }
    public Row(String newdestination,int numerTravelers){
        this.destination=newdestination;
       this.numberTravelers=numerTravelers;
    }
    public void setDestination(String destination){

        this.destination=destination;
    }
    public void setNumberTravelers(int numberofTravelers){
        this.numberTravelers=numberofTravelers;
    }
    public String getDestination(){ return this.destination;}
    public int getNumberofTravelers(){ return this.numberTravelers;}
    public String toString(){
        return this.destination+"  "+this.numberTravelers+" "+this.dailyRate;
    }
    public void enterInfo(){
        System.out.println("What`s a Destination ?");
        setDestination(keyboard.nextLine());
        System.out.println("How many Travelers ?");
        while(!keyboard.hasNextInt()){  ///loop for integer number check
            String word = keyboard.next();
            System.err.println(word + " is not a proper value");

                // word = keyboard.next();
                //System.err.println(word + " is not a  proper value");
                System.out.println("Enter number of Travelers from 0 to 1000 : ");

        }
        setNumberTravelers(keyboard.nextInt());
    }
    public void ChooseDestination(){
        int n=-1;
        System.out.println("Choose your destination from list below. Type proper number ! "+"\nNorth Amercia type '1'"+
                "\nSouth America type '2' "+"\nAsia type '3'"+"\nRest of the World type '4'");
        n=keyboard.nextInt();
         destination=destinations.get(n-1);

    }
    public double choosePlan(){
        enterInfo();
        System.out.println(toString());
        ChooseDestination();

        if((destination.equals("North America"))||(destination.equals("NA"))){
                    return  dailyRate=7;
                }
        else if ((destination.equals("South America"))||(destination.equals("SA"))){
                    return dailyRate=8;
                }
        else if ((destination.equals("Asia"))||(destination.equals("AA"))){
                    return dailyRate=9;
                }
        else if ((destination.equals("Rest World"))||(destination.equals("RS"))){
                    return dailyRate=10;
                }
        else {
                System.out.println("you don`t choose anything");
        }
        return dailyRate=0;
       // System.out.println(toString());
    }
}

