import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.*;
public class Main {
    public static void main(String[] args){
        //Total Points/Total Credits
        //Point for a class =grade value*credits
        //A =4 B =3...
        Scanner sc =new Scanner(System.in);
        Integer totalPoints=0;
        Integer totalCredits=0;
        boolean moreClasses=false;
        do {
            Integer credits = 0;
            boolean validCredits = true;
            do {
                validCredits = true;
                System.out.println("Enter number of credits:");
                String creditsString = sc.nextLine();
                try {
                    credits = Integer.parseInt(creditsString);
                    validCredits = true;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a valid integer");
                    validCredits = false;
                }
            } while (!validCredits);
            Integer gradeValue = 0;
            String grade = "";
            boolean validGrades = true;
            do {
                validGrades = true;
                System.out.println("Enter grade:");
                grade = sc.nextLine();
                if (grade.equalsIgnoreCase("A")) {
                    gradeValue = 4;
                } else if (grade.equalsIgnoreCase("B")) {
                    gradeValue = 3;
                } else if (grade.equalsIgnoreCase("C")) {
                    gradeValue = 2;
                } else if (grade.equalsIgnoreCase("D")) {
                    gradeValue = 1;
                } else if (grade.equalsIgnoreCase("F")) {
                    gradeValue = 0;
                } else {
                    System.out.println("You didn't entered a valid grade :(");
                    validGrades = false;
                }
            } while (!validGrades);
            Integer points = gradeValue * credits;
            totalPoints+=points;
            totalCredits+=credits;
            System.out.println("Would you like to enter another class? (Y/N)");
            String moreClassesString=sc.nextLine();
            moreClasses=moreClassesString.equalsIgnoreCase("Y");
        }while (moreClasses);
        DecimalFormat df=new DecimalFormat("0.00");
        Double gpa=Double.valueOf(totalPoints)/Double.valueOf(totalCredits);
        System.out.println("Credits : "+totalCredits);
        System.out.println("Points : "+totalPoints);
        System.out.println("GPA : "+df.format(gpa));
    }
}
