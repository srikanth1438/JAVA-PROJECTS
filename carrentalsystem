class Car{
    private String brand;
    private String model;
    private int priceperday;
    private boolean isAvailable;
    Car(String b,String m,int p,boolean a){
        brand=b;
        model=m;
        priceperday=p;
        isAvailable=a;
    }
    public String getbrand(){
        return brand;
    }
    public String getmodel(){
        return model;
    }
    public int getpriceperday(){
        return priceperday;
    }
    public boolean getisAvailable(){
        return isAvailable;
    }
    void Rentcar(int days){
        if(isAvailable==true){
            int total=getpriceperday()*days;
            System.out.println(total);
            isAvailable=false;
        }
        else
        System.out.print("car is not available");
    }
    void DisplayDetails(){
        System.out.print(getbrand()+" ");
        System.out.print(getmodel()+" ");
        System.out.print(getpriceperday()+" ");
        System.out.print(getisAvailable()+" ");
        System.out.println();
        
    }
    void returnCar() {
    isAvailable = true;
    System.out.println("Car returned successfully!");
}
}
class Electriccar extends Car{
    private int batteryrange;
    Electriccar(String b,String m,int p,boolean a,int r){
        super(b,m,p,a);
        batteryrange=r;
    }
    public int getbatteryrange(){
        return batteryrange;
    }
}
class Customer{
    private String name;
    private int age;
    Customer(String n,int g){
        name=n;
        age=g;
    }
    public String getname(){
        return name;
    }
    public int getage(){
        return age; 
    }
}
public class CarRentalsystem{
    public static void main(String[] args){
        Car cars[]=new Car[3];
        cars[0]=new Car("toyota","supra",2000,true);
        cars[1]=new Car("toyota","supraMK4",5000,false);
        cars[2]=new Car("maruthi","szuki",500,true);
        for(Car c: cars){
            c.DisplayDetails();
        }
        Electriccar e1=new Electriccar("morris","garage",10000,true,12);
        Customer u1=new Customer("srikanth",21);
        cars[0].Rentcar(2);
        cars[0].returnCar();
        cars[0].Rentcar(3);
    }
}
