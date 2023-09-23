import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

public class App {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCRM Application Menu:");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.toString();
            scanner.nextLine(); // Consume the newline character
            if( choice == "2" || choice=="1"||choice == "3" || choice=="4"){
                switch (choice) {
             
               case "1":
                    addCustomer(scanner);
                    break;
                case "2":
                    viewCustomers();
                    break;
                case "3":
                    searchCustomer(scanner);
                    break;
                case "4":
                    System.out.println("Exiting CRM Application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }  

            } else{System.out.print("Its wrong , Try again. ");

            }
            
        }
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        System.out.print("Enter customer phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, email, phone);
        customers.add(customer);

        System.out.println("Customer added successfully!");
    }

    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("\nCustomer List:");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println("Customer " + (i + 1));
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        }
    }

    private static void searchCustomer(Scanner scanner) {
        System.out.print("Enter customer name to search: ");
        String searchName = scanner.nextLine();

        ArrayList<Customer> searchResults = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toLowerCase().contains(searchName.toLowerCase())) {
                searchResults.add(customer);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No customers found with the given name.");
        } else {
            System.out.println("\nSearch Results:");
            for (Customer customer : searchResults) {
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhone());
            }
        }
    }
}
