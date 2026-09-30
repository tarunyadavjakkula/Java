import java.util.Scanner;

//Patient Class
class Patient {

 // Attributes
 int patientId;
 String name;
 int age;
 String problem;
 String doctorAssigned;
 double feePaid;

 // Parameterized Constructor using this keyword
 Patient(int patientId, String name, int age,
         String problem, String doctorAssigned,
         double feePaid) {

     this.patientId = patientId;
     this.name = name;
     this.age = age;
     this.problem = problem;
     this.doctorAssigned = doctorAssigned;
     this.feePaid = feePaid;
 }

 // Method to display patient report
 void displayReport() {

     System.out.println("\nPATIENT REPORT");
     System.out.println("--------------------------");
     System.out.println("Patient ID      : " + patientId);
     System.out.println("Name            : " + name);
     System.out.println("Age             : " + age);
     System.out.println("Problem         : " + problem);
     System.out.println("Doctor Assigned : " + doctorAssigned);
     System.out.println("Fee Paid        : " + feePaid);
 }

 // Method to update doctor
 void updateDoctor(String doctor) {

     doctorAssigned = doctor;
     System.out.println("Doctor updated successfully.");
 }

 // Method to add fee
 void addFee(double amount) {

     feePaid = feePaid + amount;
     System.out.println("Fee updated successfully.");
 }
}

//Main Class
public class HospitalManagement {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     // Array to store patients
     Patient patients[] = new Patient[100];

     int count = 0;
     int choice;

     do {

         System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
         System.out.println("1. Register Patient");
         System.out.println("2. Update Doctor");
         System.out.println("3. Add Fee");
         System.out.println("4. Display All Patients");
         System.out.println("5. Exit");
         System.out.print("Enter your choice : ");

         choice = sc.nextInt();

         switch (choice) {

             // Register Patient
             case 1:

                 System.out.print("Enter Patient ID : ");
                 int id = sc.nextInt();
                 sc.nextLine();

                 System.out.print("Enter Name : ");
                 String name = sc.nextLine();

                 System.out.print("Enter Age : ");
                 int age = sc.nextInt();
                 sc.nextLine();

                 System.out.print("Enter Problem : ");
                 String problem = sc.nextLine();

                 System.out.print("Enter Doctor Assigned : ");
                 String doctor = sc.nextLine();

                 System.out.print("Enter Fee Paid : ");
                 double fee = sc.nextDouble();

                 patients[count] = new Patient(
                         id, name, age,
                         problem, doctor, fee);

                 count++;

                 System.out.println("Patient Registered Successfully.");
                 break;

             // Update Doctor
             case 2:

                 System.out.print("Enter Patient ID : ");
                 int searchId = sc.nextInt();
                 sc.nextLine();

                 boolean found1 = false;

                 for (int i = 0; i < count; i++) {

                     if (patients[i].patientId == searchId) {

                         System.out.print("Enter New Doctor : ");
                         String newDoctor = sc.nextLine();

                         patients[i].updateDoctor(newDoctor);

                         found1 = true;
                     }
                 }

                 if (!found1) {
                     System.out.println("Patient not found.");
                 }

                 break;

             // Add Fee
             case 3:

                 System.out.print("Enter Patient ID : ");
                 int feeId = sc.nextInt();

                 boolean found2 = false;

                 for (int i = 0; i < count; i++) {

                     if (patients[i].patientId == feeId) {

                         System.out.print("Enter Additional Fee : ");
                         double add = sc.nextDouble();

                         patients[i].addFee(add);

                         found2 = true;
                     }
                 }

                 if (!found2) {
                     System.out.println("Patient not found.");
                 }

                 break;

             // Display Patients
             case 4:

                 if (count == 0) {

                     System.out.println("No patient records available.");
                 } else {

                     for (int i = 0; i < count; i++) {

                         patients[i].displayReport();
                     }
                 }

                 break;

             // Exit
             case 5:

                 System.out.println("Exiting Program...");
                 break;

             default:

                 System.out.println("Invalid Choice.");
         }

     } while (choice != 5);

     sc.close();
 }
}