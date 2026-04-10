package android;
public class static_this_final_keyword {
    int a;
    static int num = 0;//static will get memory once (even if we don't create its object)

    // and retain its value
    static_this_final_keyword() {
        num++;
        System.out.println(num);
        /*ab ham is constructor jab bhi new obj bnaya ga to num kii new value print ho gi kio ka
        static na num ka lia memory ma jaga alocate kar de ha go ab obj bna ho ya na
         bna ho har time rahte ha*/
    }

    public void This() {
        int a;
        a = 7;
        this.a = 77;//this is used to represent current class
//                      "this" can never be explain in one leacture
        System.out.println("value of a in method: " + a);
        System.out.println("value of a in class: " + this.a);
    }

    public void Final() {
        final int a = 586;
        System.out.println("final a is: " + a);
        //we cannot reassign "a" or change its value
        //we cannot override final method
        //final class can never be extend in other class
    }
}