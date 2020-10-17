package Day3_09062020;

public class Multiple_Conditions {

    public static void main(String[] args) {
        //using multiple conditional statements
        int a = 2;
        int b = 3;
        int c = 4;

        //print either a & b is equal, greater, or less than c

        if (a+b < c) {
           System.out.println("a & b is less than c");
        } else if (a+b > c) {
            System.out.println("a & b is greater than c");
        } else {
            System.out.println("a & b is equal to c");
        }//end of conditional statements

    }//end of method

}//end of class
