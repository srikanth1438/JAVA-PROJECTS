import java.util.*;
class Mobile{
    private int pin;
    Mobile(int p){
        pin=p;
    }
    public int getpin(){
        return pin;
    }
    void unlockmobile(int enterpin){
        if(enterpin==pin){
            System.out.println("mobile is unlocked");
        }
        else{
            System.out.println("entered pin is wrong");
        }
    }
    void changepin(int oldpin,int newpin){
        if(oldpin==pin){
            pin=newpin;
            System.out.println("pin is updated");
        }
        else{
            System.out.println("oldpin is wrong");
        }
    }
}
public class Mobilephonelocksystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Mobile m1=new Mobile(1111);
        m1.unlockmobile(1212);
        m1.unlockmobile(1111);
        m1.changepin(1111,1212);
        m1.changepin(1111,1212);
    }
}