package sprint2.assignment;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE ="customers.txt";
    private static final String ACTIVE ="activeCustomers.txt";
    public static final List<Customer> CUSTOMERS = new ArrayList<>();


    public static void main(String[] args) {
        bootstrap(FILE); //skriver ut alla som finns i listan
        for(Customer c : CUSTOMERS) {
            System.out.println(c);
        }
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Enter social or name");
            String answer = scanner.nextLine();
            boolean isFound = false;

            for(Customer c : CUSTOMERS) {
                if(c.getSocial().equals(answer) || c.getName().equalsIgnoreCase(answer)) { //söker blend de som finns i listan
                    LocalDate localDate = LocalDate.parse(c.getDateOfRegistry()); //får date of registry
                    if(localDate.isAfter(LocalDate.now().minusYears(1))){ //om datumet är mindre än ett år
                        saveActiveCustomer(c);
                    }
                    else {
                        System.out.println("You need to pay"); //om mer än ett år
                    }
                    isFound = true;
                    break;
                }
            }
            if(!isFound){ // om personen inte finns i listan
                System.out.println("The person is not a member");
            }

            System.out.println("do you want to continue?");//
            String svar = scanner.nextLine();
            if(svar.equalsIgnoreCase("N")) {
                flag = false;
            }
        }
    }

    private static void saveActiveCustomer(Customer customer) {
        System.out.println("Custumer is active");
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(ACTIVE, true))){
            pw.println(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void bootstrap(String path) {
        try(Scanner scan = new Scanner(new File(path))) {
            while(scan.hasNextLine()){
                String[] temp = scan.nextLine().split(",");
                String date = scan.nextLine();
                CUSTOMERS.add(new Customer(temp[0], temp[1].trim(), date));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
