package Action_Items;

public class Assignment_2 {

    public static void main(String[] args) {

        String [] cities = new String[4];
        cities[0] = "Queens";
        cities[1] = "Manhattan";
        cities[2] = "Brooklyn";
        cities[3] = "Staten";

        for (int i = 0; i < cities.length;i++){
            if (cities[i] == "Brooklyn"){
                System.out.println(cities[i]);
            }else if (cities[i] == "Manhattan"){
                System.out.println(cities[i]);
            }//end of if else conditions
        }//end of for loop

    }//end of method

}//end of class
