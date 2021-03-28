package Assigment2OOP;

public class Winter extends Policy{
    protected String chooseLevel;

    public Winter(){
     chooseLevel=" ";
    }
    public Winter(String newLevel){
        this.chooseLevel=newLevel;
    }
    public void setChooseLevel(String chooseLevel){
        this.chooseLevel=chooseLevel;
    }
    public String getChooseLevel(){return  this.chooseLevel;}
    public String toStringWinter(){
        return chooseLevel;
    }
    public Object DispalyWinter(){
        Winter x=new Winter();
        System.out.println(toStringWinter());
        return x;
    }
}
