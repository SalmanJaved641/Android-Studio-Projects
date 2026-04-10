package android;
import java.util.Scanner;
public class Main extends Parent {
    public static void main(String[] args) {
        Main obj1 =  new Main();
        obj1.show();//call extend class(Parent) method
        obj1.cont();//call nonstatic method in static using super
        // keyword without creating its object
        Child obj2=new Child();//call method using object without extend it
        obj2.show();
        Child obj3=new Child(3);//constructor overloading
        implement_class obj4=new implement_class();//to call method of interface after implementing
        obj4.eat();
        obj4.trevel();
        static_this_final_keyword c1=new static_this_final_keyword();//call constructor for print static values
        static_this_final_keyword c2=new static_this_final_keyword();
        static_this_final_keyword c3=new static_this_final_keyword();
        static_this_final_keyword obj5=new static_this_final_keyword();
        obj5.This();
        static_this_final_keyword obj6=new static_this_final_keyword();
        obj6.Final();
        System.out.print("enter marks: ");
        Scanner sc = new Scanner(System.in);
        int marks=sc.nextInt();
        if (marks>=90) {
            System.out.println("motor bike is gifted");
        } else if (marks>=80) {
            System.out.println("iphone is gifted");
        }
        else{
            System.out.println("try again");
        }
    }
    public void cont(){
        int sum = super.show();
        System.out.println(sum);
    }

}