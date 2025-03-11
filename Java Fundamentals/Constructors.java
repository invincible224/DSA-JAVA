// In Java, you cannot have more than one public class in a single source file. This restriction is in place to ensure a clear and straightforward relationship between the class and its filename, making it easier to manage and locate classes in large projects.
// File Naming Convention: When a class is declared as public, its name must match the name of the source file. For instance, if you have a public class named Student, the source file must be named Student.java. This convention helps developers quickly identify which file contains which class, simplifying project structure and navigation.

class Student{
    int age;
    String name;
    double percentage;
    final String schoolName ="NGKG";

    public Student(int age, String name,double percentage){
        this.age = age;
        this.name = name;
        this.percentage =percentage;
    }
}

public class Constructors {
    public static void main(String[] args) {
        Student s1 = new Student(17, "Hydra", 78.90);
        System.out.println(s1.age + s1.name+s1.schoolName + s1.percentage);
    }
}
