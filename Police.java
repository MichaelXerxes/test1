package Assigment2OOP;

import java.util.ArrayList;
import java.util.Calendar;
class Policy{

    protected String policyNum, name,status;
    protected Calendar dob, sDate, eDate;
    protected double dailyRate, premium;
    protected String holidayPlanID;
    protected ArrayList<String> destinations = new ArrayList<String>(); //an additional array to locate the destination
    protected ArrayList<String> Typeofactivity = new ArrayList<String>();
    protected ArrayList<String> Levels=new ArrayList<String>();
    protected int numberTravelers;
    public Policy(){
        policyNum = " ";
        name = " ";
        dob = null;
        sDate = null;
        eDate = null;
        status = "pending";
        dailyRate = 0;
        premium = 0;
        holidayPlanID = "";
        destinations.add(0,"North America");
        destinations.add(1,"South America");
        destinations.add(2,"Asia");
        destinations.add(3,"Rest World");
        Typeofactivity.add(0,"Sky");
        Typeofactivity.add(1,"Snowboard");
        Typeofactivity.add(2,"Skates");
        Typeofactivity.add(3,"Other");
        Levels.add(0,"Beginner");
        Levels.add(1,"Intermediate");
        Levels.add(2,"Advanced");
        Levels.add(3,"Master");
        numberTravelers=0;
    }

    public Policy(String policyNum,String holidayPlanID,String name, Calendar dob, Calendar sDate, Calendar eDate ){
        this.policyNum = policyNum;
        this.name = name;
        this.dob = dob;
        this.sDate = sDate;
        this.eDate = eDate;
        status = "pending";
        dailyRate = 4;
        premium = 0;
        this.holidayPlanID = holidayPlanID;
    }

    //set methods

    public void setPolicyNum (String policyNum){
        this.policyNum = policyNum;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setDob (Calendar dob){
        this.dob = dob;
    }

    public void setSDate (Calendar sDate){
        this.sDate = sDate;
    }

    public void setEDate (Calendar eDate){
        this.eDate = eDate;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public void setDailyRate (double dailyRate){
        this.dailyRate = dailyRate;
    }

    public void setPremium (double premium){
        this.premium = premium;
    }

    public void setPortfolio (String holidayPlanID){
        this.holidayPlanID = holidayPlanID;
    }

    //get methods
    public String getPolicyNum(){
        return policyNum;
    }

    public String getName(){
        return name;
    }

    public Calendar getDob(){
        return dob;
    }

    public Calendar getSDate(){
        return sDate;
    }

    public Calendar getEDate(){
        return eDate;
    }

    public String getStatus(){
        return status;
    }

    public double getDailyRate(){
        return dailyRate;
    }

    public double getPremium(){
        return premium;
    }

    public String getHolidayPlanID(){
        return holidayPlanID;
    }

    public void cancelPolicy(Calendar eDate){
        this.eDate = eDate;
        status = "CANCELLED";
    }

    public void calPremium(){
        //work out number of days of policy and calculate premium based on a daily rate and number of people
        if(sDate!= null && eDate!= null)
        {
            long time1 = sDate.getTimeInMillis();
            long time2 = eDate.getTimeInMillis();
            long diff = time2 - time1;
            long days = diff/1000/60/60/24;

            premium =days * dailyRate;
        }
        else
            premium = 0;
    }


    public String toString(){
        String str = " ";
        str = str + "Policy Number: " + policyNum + "\n";
        str = str + "Name: " + name + "\n";

        if (dob!= null)
        {
            str = str + "DOB: " + dob.get(Calendar.DATE) +  "/" + (dob.get(Calendar.MONTH) + 1) +  "/" + dob.get(Calendar.YEAR) + "\n";
        }
        if (sDate!= null)
        {
            str = str + "Start Date: "+ sDate.get(Calendar.DATE) +  "/" + (sDate.get(Calendar.MONTH) + 1) +  "/" + sDate.get(Calendar.YEAR) + "\n";
        }
        if (eDate!= null)
        {
            str = str + "End Date: "+ eDate.get(Calendar.DATE) +  "/" + (eDate.get(Calendar.MONTH) + 1) +  "/" + eDate.get(Calendar.YEAR) + "\n";
        }
        str = str + "Policy Type: " + this.getClass().getName() + "\n";
        str = str + "Policy Status: " + status + "\n";
        str = str + "Policy Daily Rate: " + dailyRate + "\n";
        if (holidayPlanID!= "")
        {
            str = str + "Related Portfolio Reference: " + holidayPlanID + "\n";
        }
        str = str + "Policy Premium: " + premium + "\n";
        return str;
    }

}

