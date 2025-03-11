// class Student{
//     int rollNo;
//     String name;

//     public void printInfo(){
//         System.out.println(this.rollNo + "  "+ this.name);
//     } 
// }

// Constructor
class Car{
    int prize;
    String brand;
    public void printInfo(){
        System.out.println(this.prize +"  "+this.brand);
    }

    Car(int prize, String brand){
        this.prize = prize;
        this.brand = brand;
    }

}

public class OOPS{
    public static void main(String args[]){
        // Student s1 = new Student();
        // s1.name = "Vipul";
        // s1.rollNo = 58;
        // s1.printInfo();

        Car c1 = new Car(2900000,"Tata");
        c1.printInfo();

    }
}