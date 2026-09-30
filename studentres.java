import java.util.Scanner;

class Student {
    // Attributes
    String name;
    int rollNo;
    int[] marks;
    int total;
    double average;

    // Constructor
    Student(int rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    // Compute total marks
    void computeTotal() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
    }

    // Compute average marks
    void computeAverage() {
        average = (double) total / marks.length;
    }

    // Return grade
    char grade() {
        if (average >= 90)
            return 'A';
        else if (average >= 80)
            return 'B';
        else if (average >= 70)
            return 'C';
        else if (average >= 60)
            return 'D';
        else
            return 'F';
    }

    // Display student result
    void displayResult() {
        System.out.println("--------------------------------");
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.print("Marks   : ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
        System.out.println("Total   : " + total);
        System.out.printf("Average : %.2f\n", average);
        System.out.println("Grade   : " + grade());
    }
}

public class StudentResultSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[10];
        int subjects = 5;

        // Input details for 10 students
        for (int i = 0; i < students.length; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            int[] marks = new int[subjects];

            System.out.println("Enter marks of " + subjects + " subjects:");
            for (int j = 0; j < subjects; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }

            students[i] = new Student(rollNo, name, marks);
            students[i].computeTotal();
            students[i].computeAverage();
        }

        // Display results
        System.out.println("\n========== STUDENT RESULTS ==========");

        for (Student s : students) {
            s.displayResult();
        }

        sc.close();
    }
}