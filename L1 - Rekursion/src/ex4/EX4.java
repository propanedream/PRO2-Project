package ex4;

public class EX4 {
    //recursive function to reverse a string
    public String reverseString(String str) {
//checks if the string is empty
        if (str.isEmpty()) {
            System.out.println("String is empty.");
//if the above condition is true returns the same string
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }








    public static void main(String[] args) {
        EX4 rs = new EX4();
        String resultantSting1 = rs.reverseString("123");
        String resultantSting2 = rs.reverseString("abc");
        String resultantSting3 = rs.reverseString("cba");
        System.out.println(resultantSting1);
        System.out.println(resultantSting2);
        System.out.println(resultantSting3);
        System.out.println(rs.reverseString("ahmed ali"));
    }
}
