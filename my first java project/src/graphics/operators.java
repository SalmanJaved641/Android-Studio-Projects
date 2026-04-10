package graphics;
public class operators {
    public static void main(String[] args) {
    /* System.out.println("persedence and associativity");
        int a=60*2-60/2;
        System.out.println(a);
        int b=60/2-60*2;
        System.out.println(b);
    */
        float a=23.4f;
        int b,c;
        b=1;
        c=5;
        System.out.println((b*b-4*a*c)/(2*a));
        int i=5;
        int j=++i;
        System.out.println(j);
//        without f it calculate like int values and give wrong answer
        float as=7/3.0f*4/3.0f;
        System.out.println(as);
//        incrypting in char;
    char grade = 'b';
    grade = (char) (grade+2);
        System.out.println(grade);
//        incrypting in char;
        grade = (char) (grade-2);
        System.out.println(grade);
        float aj=7*49/7.0f+35/7.0f;
        System.out.println(aj);


    }

}
