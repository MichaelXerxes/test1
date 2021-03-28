package Assigment2OOP;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Row test2=new Row();
        //test2.choosePlan();
        Hazard test1haz=new Hazard();
       // test1haz.DispalyHaz();
        //WhatPolicy();
        // DisplayPolice();
        //HolidayPlan testhol1=new HolidayPlan("007","Michal",16/06/1982,," Asia",22);

        HolidayPlan testhol1=new HolidayPlan();
        //testhol1.DisplayHolidayPlan();
       // testhol1.EneterDetails();
        testhol1.DisplayHolidayPlan();
    }
    public  static  void DisplayPolice(){
        //Object x=WhatPolicy();

           // System.out.println(x);
        }


    public static void WhatPolicy(){
        Scanner keyboard=new Scanner(System.in);
        Object a=new Row();
        Object b=new Hazard();
        int i=-1;
        System.out.println("What type of Police you want to choose?"+"\nType -1- for Rest of Word"+
                "\nType -2- for Hazard"+"\nType -3- for Winter");
        i=keyboard.nextInt();
        if(i==1){
           // a.choosePaln();
        }
        else if (i==2){

        }


    }
}
