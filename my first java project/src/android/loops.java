package android;

public class loops {
    public static void main(String[] args) {
        int i=0;
        System.out.println("                 ");
        while (i<=2){
            System.out.println("SALMAN is a good in java using while");
            i++;
        }
        i=0;
        do {
            System.out.println("SALMAN is a good in java using do while");
            i++;
        }while (i<=2);
        for ( i=1;i<=3;i++){
            System.out.println("SALMAN is a good in java using for loop");
        }
        i=0;
        int arr[]={2,9,7};
        for(int a:arr){
            System.out.println("SALMAN IS GOOD IN JAVA using for each loop " +
                    "but not good in array for arr value: "+a+ " and indux number is: "+(i++));


        }
    }
}
