class Employee {

    int id;
    String name;
    double baseSalary;
    String department;

    // Default constructor
    Employee() {
        id = 0;
        name = "Unknown";
        baseSalary = 0;
        department = "Unknown";
    }

    // Parameterized constructor
    Employee(int id, String name, double baseSalary, String department) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID   : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Department    : " + department);
        System.out.println("Base Salary   : " + baseSalary);
    }

    void calculateSalary() {
        SalaryBreakup s = new SalaryBreakup();
        s.computeBreakup();
        s.printBreakup();
    }

    void generateSlip() {
        System.out.println("\n===== MONTHLY SALARY SLIP =====");
        displayEmployeeDetails();
        calculateSalary();
        System.out.println("===============================");
    }

    // Inner class
    class SalaryBreakup {

        double hra;
        double da;
        double pf;
        double tax;
        double netPay;

        void computeBreakup() {

            hra = baseSalary * 0.20;
            da = baseSalary * 0.10;
            pf = baseSalary * 0.12;

            double grossSalary = baseSalary + hra + da;

            tax = grossSalary * 0.10;

            netPay = grossSalary - pf - tax;
        }

        void printBreakup() {

            System.out.println("HRA           : " + hra);
            System.out.println("DA            : " + da);
            System.out.println("PF            : " + pf);
            System.out.println("Tax           : " + tax);
            System.out.println("Net Pay       : " + netPay);
        }
    }

    public static void main(String[] args) {

        Employee e = new Employee(
            101,
            "Emmanuel",
            30000,
            "CSE"
        );

        e.generateSlip();
    }
}