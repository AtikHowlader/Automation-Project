package Day2_09052020;

public class while_loop {

    public static void main(String[] args) {

        //dynamic array with string data
        String[] zipCode = new String[5]; //defining and setting boundary for array values
        zipCode[0] = "11435";
        zipCode[1] = "13795";
        zipCode[2] = "12567";
        zipCode[3] = "09623";
        zipCode[4] = "76437";

        //first initialize the starting point before while loop
        int i = 0;
        //define the while loop with your end point execution
        while(i < zipCode.length){

            System.out.println("The zipcode is " + zipCode[i]);

            //increment goes here
            i = i + 1; //same as i++
        }//end of while loop

    }//end of method

}//end of class
