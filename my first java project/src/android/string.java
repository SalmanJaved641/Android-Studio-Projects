package android;

public class string {
    public static void main(String[] args) {
        String str = "Salman Javed ";
        System.out.println(str);
        int lgh_str=str.length();
        System.out.println("length of string is: "+lgh_str);
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.trim());//remove space from start and end
        System.out.println(str.substring(3));//start from 3rd index_no
        System.out.println(str.substring(0,6));//start from 0 index_no and end on 6th index
        System.out.println(str.replace("al","UL"));
        System.out.println(str.replace("ed","ED IQBAL"));
        System.out.println(str.startsWith("S"));
        System.out.println(str.endsWith("ld"));
        System.out.println(str.charAt(1)); //what is charecter at 1st index
        System.out.println(str.indexOf("Ja"));//search index no
        System.out.println(str.indexOf("a",3));//search index no starts from 2nd index
        System.out.println("check if name = to or not: "+str.equals("Salman Javed"));
        System.out.println("merge with name "+str.concat("IQBAL"));
    }
}