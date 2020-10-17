package Day3_09062020;

public class Reusable_Methods {

    //custom method to add two integers
    /*void methods only executes the statements inside
    but doesn't return anything
     */
    public static void add(int a, int b){
        System.out.println("My result of a & b is " + (a+b));
    }//end of add method

    public static void subtraction(int a, int b){
        System.out.println("My result of a - b is " + (a-b));
    }//end of subtraction method

    public static int returnAdd(int a, int b){
        int result = a+b;
        System.out.println("My result of a & b is " + result);
        return result;
    }//end of return add method

}//end of class
