package Action_Items;

public class Assignment_1 {

    public static void main(String[] args) {

        int grade = 90;
        if (grade >= 90 && grade <= 100){
            System.out.println("The grade is A");
        } else if (grade >= 80 && grade <=89){
            System.out.println("The grade is B");
        } else if (grade >= 70 && grade <= 79){
            System.out.println("The grade is C");
        } else if (grade >= 60 && grade <= 69){
            System.out.println("The grade is D");
        } else if (grade < 60){
            System.out.println("The grade is F");
        }//end of if else condition

    }//end of method

}//end of class
