package Assigment2OOP;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
public class HolidayPlan {
    Scanner keyboard=new Scanner(System.in);
    private String id, name;
    private ArrayList<Calendar> dob;
    private ArrayList<String> travellers;
    private Calendar dateCreated;
    private Policy policy;
    private String insuranceStatus;
    private String destination;
    private double cost;
    private ArrayList<String> destinations = new ArrayList<String>(); //an additional array to locate the destination


    public HolidayPlan() {
        id = " ";
        name = " ";
        dob = null;
        travellers = null;
        dateCreated = Calendar.getInstance();
        policy = null;
        insuranceStatus = "client has own";
        destination = "";
        cost=0;
        destinations.add(0,"North America");
        destinations.add(1,"South America");
        destinations.add(2,"Asia");
        destinations.add(3,"Rest World");
    }

    public HolidayPlan(String id, String name, ArrayList<Calendar> dob, ArrayList<String> travellers,String destination,double cost)
    {
        this.id = id;
        this.name = name;
        this.dob = dob;
        dateCreated = Calendar.getInstance();
        policy = null;
        this.travellers=travellers;
        this.destination= destination;
        insuranceStatus = "client has own";
        this.cost = cost;
    }

    //set methods
    public void setId (String id){
        this.id = id;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setDob (Calendar dob){
        this.dob.add(dob);
    }

    public void setTravellers(String traveller){
        this.travellers.add(traveller);
    }

    public void setPolicy(Policy policy){
//add cost of policy to holiday cost
        this.policy = policy;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setInsuranceStatus(String insuranceStatus){
        this.insuranceStatus = insuranceStatus;
    }

    //get methods
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Calendar> getDob(){
        return dob;
    }

    public ArrayList<String> getTravellers(){
        return travellers;
    }

    public Calendar getDateCreated(){
        return dateCreated;
    }

    public Policy getPolicy(){
        return policy;
    }

    public String getDestination(){
        return destination;
    }

    public double getCost(){
        return cost;
    }

    public String getInsuranceStatus(){
        return insuranceStatus;
    }

    public void acceptPolicy(Policy p){
        //accept a policy p and link it to this portfolio

        this.policy = PolisyX();
        policy.setPortfolio(this.id);
        policy.setStatus("active");
        this.cost = this.cost + policy.getPremium();
//add cost of policy to holiday cost
    }
    public void DisplayHolidayPlan(){//dodane
        EneterDetails();
        System.out.println(toString());
    }
    public void EneterDetails(){//dodane
        
        System.out.println("Whats is ID number ?");
        setId(keyboard.nextLine());
        System.out.println("What`s Holiday plan holder name");
        setName(keyboard.nextLine());
        System.out.println("What is Destination choose from list bellow"+"\nType -1- for North America"+
                "\nType -2- for Hsouth America"+"\nType -3- for Asia"+"\nType -4- for rest of World");
        this.destination=destinations.get(keyboard.nextInt()-1);
        System.out.println("DOB?");
        //setDob(keyboard.nextInt());
        setDate();
        System.out.println();
        Policy p=PolisyX();
        acceptPolicy(p);

    }
    public Policy PolisyX(){
        int abc=-1;
        Row a=new Row();
        Hazard b=new Hazard();
        Winter c=new Winter();
        if(abc==1){
            return a;
        }
        else if(abc==2){
            return b;
        }
        return c;
    }
    
    
    public void setDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Calendar dob = Calendar.getInstance(); //create dob object
        String date = "";
        int error = 0;

        do
        {	//read date from keyboard as String
            System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
            date = keyboard.nextLine();

            try
            {	//apply SimpleDateFormat format to the date variable
                //and store the date in the Calendar object dob
                dob.setTime(sdf.parse(date));
                error = 0;
            }
            catch(Exception e)
            {
                System.out.print("date not in correct format (dd/MM/yyyy):");
                error = 1;
            }
        }while (error == 1);
    }
    public String toString(){

        DecimalFormat df = new DecimalFormat("#.00");
        String str = " ";
        str += "ID: " + id + "\n";
        str += "Name: " + name + "\n";
        str += "Destination:" + destination + "\n";

        if (dob!= null && travellers!=null)
        {
            for(int i = 0;i<travellers.size();i++)

                str = str + "Name: "+ travellers.get(i) + "  DOB: " + dob.get(i).get(Calendar.DATE) +  "/" + (dob.get(i).get(Calendar.MONTH) + 1) +  "/" +dob.get(i).get(Calendar.YEAR) + "\n";
        }

        if (dateCreated!= null)
        {
            str = str + "Date Created: "+  dateCreated.get(Calendar.DATE) +  "/" + (dateCreated.get(Calendar.MONTH) + 1) +  "/" + dateCreated.get(Calendar.YEAR) + "\n";
        }
        if (insuranceStatus == "Company Policy")
            str = str + "Policy ID: " + policy.getPolicyNum() + "\n";

        str = str + "Total Cost: £" + df.format(cost);
        return str;
    }
}

