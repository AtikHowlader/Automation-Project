package Day3_09062020;

public class Methods_Execution_Class {

    public static void main(String[] args) {
        //void methods
        Reusable_Methods.add(40,60);

        Reusable_Methods.subtraction(60,40);

        //return add method
        int number = Reusable_Methods.returnAdd(40,50);
        System.out.println("New result is " + (number+20));

    }//end of method

}//end of class
