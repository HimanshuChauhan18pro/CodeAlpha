package Projects;

import java.util.Scanner;
import java.util.ArrayList;

public class StrudentGradeTracker {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        System.out.print("\nEnter the Number of Students: ");
        int numberOfStudent =input.nextInt();

        ArrayList<String> studentName = new ArrayList<String>();
        ArrayList<Double> studentGrade = new ArrayList<Double>();

        for(int i=0;i<numberOfStudent ;i++){
            System.out.print("\nEnter the name of Student : ");
            String name = input.next();
            studentName.add(i,name);

            System.out.print("Enter the Grade for "+studentName.get(i)+" : ");
            double grade= input.nextDouble();
            studentGrade.add(i,grade);
        }

        double sum =0;
        double highestGrade = studentGrade.get(0);
        double lowestGrade = studentGrade.get(0);

        for(double grade : studentGrade){
            sum+=grade;
            if(grade > highestGrade){
                highestGrade= grade;
            }
            if (grade<lowestGrade) {
                lowestGrade =grade;
            }
        }

        double average = sum /numberOfStudent;
        System.out.println("\nAverage Grade: "+average);
        System.out.println("\nHighest Grade: "+highestGrade);
        System.out.println("\nLowest Grade: "+lowestGrade);


        input.close();
    }
}
