import entities.models.Employee;
import entities.models.outSourceEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for(int i = 1; i<=n; i++ ){
            System.out.println("Employee #" + i + "data: ");
            System.out.println("Outsourced (y/n) ? ");
            char ch = sc.next().charAt(0);
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Hours: ");
            int hours = sc.nextInt();
            System.out.println("Value per Hour: ");
            double valuePerHour = sc.nextDouble();
            if(ch == 'y'){
                System.out.println("Additional Charge");
                double additionalCharge = sc.nextDouble();
                employees.add(new outSourceEmployee(name, hours, valuePerHour, additionalCharge));
            }else{
                employees.add(new Employee(name, hours, valuePerHour));

            }
        }

        System.out.println();
        System.out.println("Payment: ");
        for (Employee e: employees) {
            System.out.println(e.getName() + " - $" + String.format("%.2f", e.payment()) + "\n");
        }
    }
}