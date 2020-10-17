package Day2_09052020;

public class Dynamic_Array {

    public static void main(String[] args) {

        //dynamic array with string data
        String[] zipCode = new String[5]; //defining and setting boundary for array values
        zipCode[0] = "11435";
        zipCode[1] = "13795";
        zipCode[2] = "12567";
        zipCode[3] = "09623";
        zipCode[4] = "76437";
        System.out.println("The last zipcode is " + zipCode[4] );

        //dynamic array with integer data
        int[] checkAmount = new int[5];
        checkAmount[0] = 1000;
        checkAmount[1] = 2000;
        checkAmount[2] = 3000;
        checkAmount[3] = 4000;
        checkAmount[4] = 5000;
        System.out.print("The last check amount is " + checkAmount[4]);


    }//end of the method
}//end of the class
