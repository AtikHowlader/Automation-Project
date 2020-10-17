package Day2_09052020;

public class for_loop {

    public static void main(String[] args) {
        //dynamic array with string data
        String[] zipCode = new String[5]; //defining and setting boundary for array values
        zipCode[0] = "11435";
        zipCode[1] = "13795";
        zipCode[2] = "12567";
        zipCode[3] = "09623";
        zipCode[4] = "76437";

        //iterate through all of zipcode data and print each one
        /*length command is useful to use so you don't have to hard code
        your end point on i < whatever the end point is
         */
        for(int i = 0;i < zipCode.length;i++){
            //code goes here
            System.out.println("The zipcode is " + zipCode[i]);
        }//end of loop

    }//end of class
}
