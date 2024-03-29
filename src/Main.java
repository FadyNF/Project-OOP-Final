import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static Scanner s = new Scanner(System.in);
    private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    static Seller chosenSeller = null;
    static ArrayList<Admin> adminArrayList = new ArrayList<>();
    static ArrayList<Customer> customerArrayList = new ArrayList<>();
    static ArrayList<Seller> sellerArrayList = new ArrayList<>();
    static ArrayList<Order> orderArrayList = new ArrayList<>();
    static ArrayList<Product> productArrayList = new ArrayList<>();


    static final String adminPath = "C:\\Users\\Fady\\Desktop\\OOP Project\\Project OOP Final\\src\\admins.bin";
    static final String customerPath = "C:\\Users\\Fady\\Desktop\\OOP Project\\Project OOP Final\\src\\customers.bin";
    static final String sellerPath = "C:\\Users\\Fady\\Desktop\\OOP Project\\Project OOP Final\\src\\sellers.bin";
    static final String orderPath = "C:\\Users\\Fady\\Desktop\\OOP Project\\Project OOP Final\\src\\orders.bin";
    static final String productPath = "C:\\Users\\Fady\\Desktop\\OOP Project\\Project OOP Final\\src\\products.bin";

    public static void main(String[] args) {
        loadArrayLists();
        startupMenu();
        saveArrayLists();
    }

    public static void loadArrayLists() {
        try {
            try (ObjectInputStream oisAdmins = new ObjectInputStream(new FileInputStream(adminPath))) {
                adminArrayList = (ArrayList<Admin>) oisAdmins.readObject();
            }
            try (ObjectInputStream oisCustomers = new ObjectInputStream(new FileInputStream(customerPath))) {
                customerArrayList = (ArrayList<Customer>) oisCustomers.readObject();
            }
            try (ObjectInputStream oisSellers = new ObjectInputStream(new FileInputStream(sellerPath))) {
                sellerArrayList = (ArrayList<Seller>) oisSellers.readObject();
            }
            try (ObjectInputStream oisOrders = new ObjectInputStream(new FileInputStream(orderPath))) {
                orderArrayList = (ArrayList<Order>) oisOrders.readObject();
            }
            try (ObjectInputStream oisProducts = new ObjectInputStream(new FileInputStream(productPath))) {
                productArrayList = (ArrayList<Product>) oisProducts.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveArrayLists() {
        try {
            try (ObjectOutputStream oosAdmins = new ObjectOutputStream(new FileOutputStream(adminPath))) {
                oosAdmins.writeObject(adminArrayList);
            }
            try (ObjectOutputStream oosCustomers = new ObjectOutputStream(new FileOutputStream(customerPath))) {
                oosCustomers.writeObject(customerArrayList);
            }
            try (ObjectOutputStream oosSellers = new ObjectOutputStream(new FileOutputStream(sellerPath))) {
                oosSellers.writeObject(sellerArrayList);
            }
            try (ObjectOutputStream oosOrders = new ObjectOutputStream(new FileOutputStream(orderPath))) {
                oosOrders.writeObject(orderArrayList);
            }
            try (ObjectOutputStream oosProducts = new ObjectOutputStream(new FileOutputStream(productPath))) {
                oosProducts.writeObject(productArrayList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startupMenu() {
        System.out.println("Welcome to Otlob");
        System.out.println("1) Login");
        System.out.println("2) Sign-up");
        System.out.print("Choose Option: ");
        byte loginOption;
        while (true) {
            try {
                loginOption = s.nextByte();

                if (loginOption == 1 || loginOption == 2) {
                    break;
                } else {
                    System.out.println("Invalid Choice");
                }
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input. Please enter a valid number.");
            }
        }

        System.out.println("1) Admin");
        System.out.println("2) Seller");
        System.out.println("3) Customer");
        System.out.println("Choose your role: ");
        byte roleOption;
        while (true) {
            try {
                roleOption = s.nextByte();
                if (roleOption >= 1 && roleOption <= 3)
                    break;

                System.out.println("Invalid Choice ");
            } catch(InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input. Please enter a valid number.");
            }
        }

        switch (roleOption) {
            case 1:
                adminLogin(loginOption);
                break;
            case 2:
                sellerLogin(loginOption);
                break;
            case 3:
                customerLogin(loginOption);
                break;
        }
    }

    public static void adminLogin(byte loginOption) {
        String name, pass;
        boolean found = false;
        s.nextLine();
        System.out.print("What's your UserName: ");
        name = s.nextLine();

        System.out.print("What's your Password: ");
        pass = s.nextLine();


        byte failedLoginChoice;
        switch (loginOption) {
            case 1: {
                for (Admin admin : adminArrayList) {
                    if (admin.getUserName().equals(name) && admin.getUserPassword().equals(pass)) {
                        System.out.println("Welcome " + name);
                        Admin adminLoggedIn = admin;
                        found = true;
                        adminMenu(adminLoggedIn);
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Admin Not Found");
                    System.out.println("Would you like to Sign up? \n1) Yes\n2) No");

                    while (true) {
                        try {
                            failedLoginChoice = s.nextByte();
                            if (failedLoginChoice == 1 || failedLoginChoice == 2)
                                break;

                            System.out.println("Invalid Choice ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }

                    }


                    if (failedLoginChoice == 1) {
                        adminLogin((byte) 2);
                    } else {
                        System.exit(0);
                    }
                }
            }
            break;
            case 2: {
                for (Admin admin : adminArrayList) {
                    if (admin.getUserName().equals(name) && admin.getUserPassword().equals(pass)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("User already exists");
                    System.out.println("Would you like to login? \n1) Yes\n2) No");
                    while (true) {
                        try {
                            failedLoginChoice = s.nextByte();
                            if (failedLoginChoice == 1 || failedLoginChoice == 2)
                                break;
                            System.out.println("Invalid Choice ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }

                    }

                    if (failedLoginChoice == 1) {
                        adminLogin((byte) 1);
                    } else {
                        System.exit(0);
                    }
                } else {
                    int id = adminArrayList.size() + 1;
                    Admin adminLoggedIn = new Admin(name, pass, id);
                    adminArrayList.add(adminLoggedIn);
                    System.out.println("Admin account created for " + name);
                    adminMenu(adminLoggedIn);
                }
            }
            break;
        }
    }

    public static void customerLogin(byte loginOption) {
        String name, pass;
        boolean found = false;
        s.nextLine();
        System.out.print("What's your UserName: ");
        name = s.nextLine();

        System.out.print("What's your Password: ");
        pass = s.nextLine();

        byte failedLoginChoice;
        switch (loginOption) {
            case 1: {
                for (Customer customer : customerArrayList) {
                    if (customer.getUserName().equals(name) && customer.getUserPassword().equals(pass)) {
                        System.out.println("Welcome " + name);
                        Customer customerLoggedIn = customer;
                        found = true;
                        customerMenu(customerLoggedIn);
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Customer Not Found");
                    System.out.println("Would you like to Sign up? \n1) Yes\n2) No");

                    while (true) {
                        try {
                            failedLoginChoice = s.nextByte();
                            if (failedLoginChoice == 1 || failedLoginChoice == 2)
                                break;
                            System.out.println("Invalid Choice ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }
                    }

                    if (failedLoginChoice == 1) {
                        customerLogin((byte) 2);
                    } else {
                        System.exit(0);
                    }
                }
            }
            break;
            case 2: {
                for (Customer customer : customerArrayList) {
                    if (customer.getUserName().equals(name) && customer.getUserPassword().equals(pass)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("User already exists");
                    System.out.println("Would you like to login? \n1) Yes\n2) No");
                    while (true) {
                        try {
                            failedLoginChoice = s.nextByte();
                            if (failedLoginChoice == 1 || failedLoginChoice == 2)
                                break;

                            System.out.println("Invalid Choice ");
                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }
                    }

                    if (failedLoginChoice == 1) {
                        customerLogin((byte) 1);
                    } else {
                        System.exit(0);
                    }
                } else {
                    int id = customerArrayList.size() + 1;
                    Customer customerLoggedIn = new Customer(name, pass, id);
                    customerArrayList.add(customerLoggedIn);
                    System.out.println("Customer account created for " + name);
                    customerMenu(customerLoggedIn);
                }
                break;
            }
        }
    }

    public static void sellerLogin(byte loginOption) {
        String name, pass;
        boolean found = false;
        s.nextLine();
        System.out.print("What's your UserName: ");
        name = s.nextLine();

        System.out.print("What's your Password: ");
        pass = s.nextLine();

        byte failedLoginChoice;
        switch (loginOption) {
            case 1: {
                for (Seller seller : sellerArrayList) {
                    if (seller.getUserName().equals(name) && seller.getUserPassword().equals(pass)) {
                        System.out.println("Welcome " + name);
                        Seller sellerLoggedIn = seller;
                        found = true;
                        sellerMenu(sellerLoggedIn);
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Seller Not Found");
                    System.out.println("Would you like to Sign up? \n1) Yes\n2) No");

                    while (true) {
                        try {
                            failedLoginChoice = s.nextByte();
                            if (failedLoginChoice == 1 || failedLoginChoice == 2)
                                break;

                            System.out.println("Invalid Choice ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }
                    }

                    if (failedLoginChoice == 1) {
                        sellerLogin((byte) 2);
                    } else {
                        System.exit(0);
                    }
                }
            }
            break;
            case 2: {
                for (Seller seller : sellerArrayList) {
                    if (seller.getUserName().equals(name) && seller.getUserPassword().equals(pass)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("User already exists");
                    System.out.println("Would you like to login? \n1) Yes\n2) No");
                    while (true) {
                        try {
                            failedLoginChoice = s.nextByte();
                            if (failedLoginChoice == 1 || failedLoginChoice == 2)
                                break;

                            System.out.println("Invalid Choice ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }

                    }

                    if (failedLoginChoice == 1) {
                        sellerLogin((byte) 1);
                    } else {
                        System.exit(0);
                    }
                } else {
                    int id = sellerArrayList.size() + 1;
                    Seller sellerLoggedIn = new Seller(name, pass, id);
                    sellerArrayList.add(sellerLoggedIn);
                    System.out.println("Seller account created for " + name);
                    sellerMenu(sellerLoggedIn);
                }
            }
            break;
        }
    }

    public static void adminMenu(Admin adminLoggedIn) {
        System.out.println("Admin Menu: ");
        System.out.println("1) Add - Edit - Remove - Search");
        System.out.println("2) View Data about Sellers");
        System.out.println("3) View Data about Customers");
        System.out.println("4) View Data about Orders");
        System.out.print("Which option would you like? ");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 4)
                    break;
                System.out.print("Invalid Input: ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }
        }

        switch (option) {
            case 1:
                adminManagerMethod(adminLoggedIn);
                break;
            case 2:
                adminViewDataOfSellers(adminLoggedIn);
                break;
            case 3:
                adminViewDataOfCustomers(adminLoggedIn);
                break;
            case 4:
                adminViewDataOfOrders(adminLoggedIn);
                break;
        }


    }

    public static void customerMenu(Customer customerLoggedIn) {
        System.out.println("-----------------------------");
        System.out.println("1) Start Ordering ");
        System.out.println("2) Track Order History ");
        System.out.print("What would you like to do today? ");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option == 1 || option == 2)
                    break;
                System.out.print("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        switch (option) {
            case 1:
                customerStartOrdering(customerLoggedIn);
                break;
            case 2:
                customerTrackHistory(customerLoggedIn);
                break;
        }
    }

    public static void sellerMenu(Seller sellerLoggedIn) {
        System.out.println("Seller Menu: ");
        System.out.println("1) Add - Edit - Remove - Search");
        System.out.println("2) View Data about Products");
        System.out.println("3) View Data about Orders");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 3)
                    break;
                System.out.print("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }
        }

        switch (option) {
            case 1:
                sellerManagerMethod(sellerLoggedIn);
                break;
            case 2:
                sellerViewDataOfProducts(sellerLoggedIn);
                break;
            case 3:
                sellerViewDataOfOrders(sellerLoggedIn);
                break;
        }
    }

    public static void adminManagerMethod(Admin adminLoggedIn) {
        System.out.println("-----------------------------");
        System.out.println("1) Add User");
        System.out.println("2) Edit User");
        System.out.println("3) Remove User");
        System.out.println("4) View Users");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 4)
                    break;
                System.out.print("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }
        }

        switch (option) {
            // Admin add user case
            case 1: {
                System.out.println("What is the type of User you want to add? ");
                System.out.println("1) Customer");
                System.out.println("2) Seller");

                byte typeOfUser;
                while (true) {
                    try {
                        typeOfUser = s.nextByte();
                        if (typeOfUser == 1 || typeOfUser == 2)
                            break;
                        System.out.print("Invalid Input ");

                    } catch (InputMismatchException e) {
                        s.next();
                        System.out.println("Invalid Input, please enter a valid number");
                    }

                }

                String userName, userPassword;

                if (typeOfUser == 1) {
                    System.out.print("What is this Customer's name? ");
                    userName = s.next();

                    s.nextLine();

                    System.out.print("What will be this Customer's password? ");
                    userPassword = s.nextLine();

                    int id = customerArrayList.size() + 1;
                    Customer newCustomer = new Customer(userName, userPassword, id);
                    System.out.println("New Customer Account Created for " + newCustomer.getUserName());

                    adminLoggedIn.addUser(customerArrayList, newCustomer);
                } else {
                    System.out.print("What is this Seller's name? ");
                    userName = s.next();

                    s.nextLine();

                    System.out.print("What will be this Seller's password? ");
                    userPassword = s.nextLine();

                    int id = sellerArrayList.size() + 1;
                    Seller newSeller = new Seller(userName, userPassword, id);
                    System.out.println("New Seller Account Created for " + newSeller.getUserName());
                    adminLoggedIn.addUser(sellerArrayList, newSeller);
                }
            }
            break;

            // Admin Edit user case
            case 2: {
                System.out.println("Do you want to edit a...... ");
                System.out.println("1) Customer");
                System.out.println("2) Seller");

                byte userType;
                while (true) {
                    try {
                        userType = s.nextByte();
                        if (userType == 1 || userType == 2)
                            break;
                        System.out.print("Invalid Input ");

                    } catch (InputMismatchException e) {
                        s.next();
                        System.out.println("Invalid Input, please enter a valid number");
                    }

                }
                s.nextLine();

                System.out.println("Enter the Name or ID of the user you want to edit. ");
                String promptOfEditingUser = s.nextLine();

                int userID = -1;
                try {
                    userID = Integer.parseInt(promptOfEditingUser);

                    System.out.println("Editing User with ID: " + userID);
                } catch (NumberFormatException e) {
                    System.out.println("Editing User with Name: " + promptOfEditingUser);
                }

                Customer foundCustomer = null;
                Seller foundSeller = null;

                switch (userType) {
                    case 1: {
                        // if admin entered an id
                        if (userID != -1) {
                            for (Customer customer : customerArrayList) {
                                if (customer.getCustomerID() == userID) {
                                    foundCustomer = customer;
                                    break;
                                }
                            }

                            if (foundCustomer != null) {
                                System.out.println("Customer ID: " + foundCustomer.getCustomerID());
                                System.out.println("Customer Name: " + foundCustomer.getUserName());

                                System.out.print("Enter user's new name: ");
                                String newName = s.nextLine();
                                adminLoggedIn.editUserName(customerArrayList, foundCustomer, newName);

                            } else {
                                System.out.println("User not found");
                            }
                        } else {
                            for (Customer customer : customerArrayList) {
                                if (customer.getUserName().equals(promptOfEditingUser)) {
                                    foundCustomer = customer;
                                    break;
                                }
                            }

                            if (foundCustomer != null) {
                                System.out.println("Customer ID: " + foundCustomer.getCustomerID());
                                System.out.println("Customer Name: " + foundCustomer.getUserName());

                                System.out.print("Enter user's new name: ");
                                String newName = s.nextLine();
                                adminLoggedIn.editUserName(customerArrayList, foundCustomer, newName);
                            } else {
                                System.out.println("User not found");
                            }
                        }
                    }
                    break;
                    case 2: {
                        // if admin entered an id
                        if (userID != -1) {
                            for (Seller seller : sellerArrayList) {
                                if (seller.getSellerID() == userID) {
                                    foundSeller = seller;
                                    break;
                                }
                            }

                            if (foundSeller != null) {
                                System.out.println("Seller ID: " + foundSeller.getSellerID());
                                System.out.println("Seller Name: " + foundSeller.getUserName());

                                System.out.print("Enter user's new name: ");
                                String newName = s.nextLine();
                                adminLoggedIn.editUserName(sellerArrayList, foundSeller, newName);

                            } else {
                                System.out.println("User not found");
                            }

                        } else {
                            for (Seller seller : sellerArrayList) {
                                if (seller.getUserName().equals(promptOfEditingUser)) {
                                    foundSeller = seller;
                                    break;
                                }
                            }

                            if (foundSeller != null) {
                                System.out.println("Seller ID: " + foundSeller.getSellerID());
                                System.out.println("Seller Name: " + foundSeller.getUserName());

                                System.out.print("Enter user's new name: ");
                                String newName = s.nextLine();
                                adminLoggedIn.editUserName(sellerArrayList, foundSeller, newName);
                            } else {
                                System.out.println("User not found");
                            }
                        }
                    }
                    break;
                }
            }
            break;

            // Admin remove user case
            case 3: {
                System.out.println("Do you want to Remove a...... ");
                System.out.println("1) Customer");
                System.out.println("2) Seller");

                byte userType;
                while (true) {
                    try {
                        userType = s.nextByte();
                        if (userType == 1 || userType == 2)
                            break;
                        System.out.print("Invalid Input ");

                    } catch (InputMismatchException e) {
                        s.next();
                        System.out.println("Invalid Input, please enter a valid number");
                    }

                }
                s.nextLine();

                System.out.println("Enter the Name or ID of the user you want to remove. ");
                String promptOfEditingUser = s.nextLine();

                int userID = -1;
                try {
                    userID = Integer.parseInt(promptOfEditingUser);

                    System.out.println("Removing User with ID: " + userID);
                } catch (NumberFormatException e) {
                    System.out.println("Removing User with Name: " + promptOfEditingUser);
                }

                Customer foundCustomer = null;
                Seller foundSeller = null;

                switch (userType) {
                    case 1: {
                        if (userID != -1) {
                            for (Customer customer : customerArrayList) {
                                if (customer.getCustomerID() == userID) {
                                    foundCustomer = customer;
                                    break;
                                }
                            }

                        } else {
                            for (Customer customer : customerArrayList) {
                                if (customer.getUserName().equals(promptOfEditingUser)) {
                                    foundCustomer = customer;
                                    break;
                                }
                            }
                        }


                        if (foundCustomer != null) {
                            adminLoggedIn.removeUser(customerArrayList, foundCustomer);
                        } else {
                            System.out.println("User not found");
                        }
                    }
                    break;
                    case 2: {
                        if (userID != -1) {
                            for (Seller seller : sellerArrayList) {
                                if (seller.getSellerID() == userID) {
                                    foundSeller = seller;
                                    break;
                                }
                            }

                        } else {
                            for (Seller seller : sellerArrayList) {
                                if (seller.getUserName().equals(promptOfEditingUser)) {
                                    foundSeller = seller;
                                    break;
                                }
                            }
                        }


                        if (foundSeller != null) {
                            adminLoggedIn.removeUser(sellerArrayList, foundSeller);
                        } else {
                            System.out.println("User not found");
                        }
                    }
                    break;
                }

            }
            break;

            // Admin search/view users case
            case 4: {
                s.nextLine();
                System.out.print("Enter your Search Query: ");
                String searchQuery = s.nextLine();

                ArrayList<User> userArrayList = new ArrayList<>(customerArrayList);
                userArrayList.addAll(sellerArrayList);

                ArrayList<User> searchFoundFromQuery = adminLoggedIn.searchUser(userArrayList, searchQuery);
                if (!searchFoundFromQuery.isEmpty()) {
                    for (User u : searchFoundFromQuery) {
                        System.out.println("User Name: " + u.getUserName());
                    }
                } else {
                    System.out.println("Nothing was found");
                }

            }
            break;
        }

        System.out.println("Return to Admin Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        if (returnOption == 1)
            adminMenu(adminLoggedIn);
        else {
            saveArrayLists();
            System.exit(0);
        }
    }

    public static void adminViewDataOfSellers(Admin adminLoggedIn) {
        System.out.println("------------------------------");
        System.out.println("1) Orders per Seller and its details");
        System.out.println("2) Sellers with max number of orders");
        System.out.println("3) Sellers with max revenue");
        System.out.print("Enter choice: ");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 3)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        switch (option) {
            // Orders per seller and its products case
            case 1: {
                HashMap<Seller, ArrayList<Order>> ordersPerSellerHashMap
                        = adminLoggedIn.getOrdersPerSeller(sellerArrayList);

                for (HashMap.Entry<Seller, ArrayList<Order>> entry : ordersPerSellerHashMap.entrySet()) {
                    Seller seller = entry.getKey();
                    ArrayList<Order> orders = entry.getValue();

                    System.out.println("Seller: " + seller.getUserName());

                    for (Order order : orders) {
                        System.out.println("  Order ID: " + order.getOrderID());

                        // Display Order Products and Quantities
                        HashMap<Product, Integer> orderProducts = order.getOrderProducts();

                        for (HashMap.Entry<Product, Integer> productEntry : orderProducts.entrySet()) {
                            Product product = productEntry.getKey();
                            int quantity = productEntry.getValue();

                            System.out.println("    Product: " + product.getProductName());
                            System.out.println("    Quantity: " + quantity);
                        }

                        System.out.println("  Order Price: " + order.getTotalPrice());
                        System.out.println("  Order Date: " + order.getOrderDate());
                        System.out.println();
                    }

                    System.out.println();
                }

            }
            break;

            // Sellers with max number of orders case
            case 2: {
                ArrayList<Seller> sellersWithMaxOrders = adminLoggedIn.getSellerWithMaxOrders(sellerArrayList);
                System.out.println("Sellers with the max Orders:");

                for (Seller seller : sellersWithMaxOrders) {
                    System.out.println("Seller ID: " + seller.getSellerID());
                    System.out.println("Seller Name: " + seller.getUserName());
                    System.out.println("Order count: " + seller.getSellerOrders().size());
                    System.out.println();
                }
            }
            break;

            // Sellers with max revenue case
            case 3: {
                ArrayList<Seller> sellersWithMaxRevenue = adminLoggedIn.getSellerWithMaxRevenue(sellerArrayList);
                System.out.println("Sellers with max Revenue");

                for (Seller seller : sellersWithMaxRevenue) {
                    System.out.println("Seller ID: " + seller.getSellerID());
                    System.out.println("Seller Name: " + seller.getUserName());
                    System.out.println("Seller Revenue: " + seller.calculateTotalRevenue());
                    System.out.println();
                }
            }
            break;
        }

        System.out.println("Return to Admin Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }
        }

        if (returnOption == 1)
            adminMenu(adminLoggedIn);
        else {
            saveArrayLists();
            System.exit(0);
        }
    }

    public static void adminViewDataOfCustomers(Admin adminLoggedIn) {
        System.out.println("------------------------------");
        System.out.println("1) Orders per Customer and his/her details");
        System.out.println("2) Customer with max Orders");
        System.out.println("3) Customer with max Revenue");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 3)
                    break;
                System.out.print("Invalid Input ");
            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }


        switch (option) {
            // Orders per customer case
            case 1: {
                HashMap<Customer, ArrayList<Order>> ordersPerCustomerHashmap
                        = adminLoggedIn.getOrdersPerCustomer(customerArrayList);

                for (HashMap.Entry<Customer, ArrayList<Order>> entry : ordersPerCustomerHashmap.entrySet()) {
                    Customer customer = entry.getKey();
                    ArrayList<Order> orders = entry.getValue();

                    System.out.println("Customer: " + customer.getUserName());

                    for (Order order : orders) {
                        System.out.println("  Order ID: " + order.getOrderID());

                        // Display Order Products and Quantities
                        HashMap<Product, Integer> orderProducts = order.getOrderProducts();

                        for (HashMap.Entry<Product, Integer> productEntry : orderProducts.entrySet()) {
                            Product product = productEntry.getKey();
                            int quantity = productEntry.getValue();

                            System.out.println("    Product: " + product.getProductName());
                            System.out.println("    Quantity: " + quantity);
                        }

                        System.out.println("  Order Price: " + order.getTotalPrice());
                        System.out.println("  Order Date: " + order.getOrderDate());
                        System.out.println();
                    }

                    System.out.println();
                }

            }
            break;

            // customer with max orders case
            case 2: {
                ArrayList<Customer> customersWithMaxOrders = adminLoggedIn.getCustomerWithMaxOrders(customerArrayList);
                System.out.println("Customers with max Orders: ");

                for (Customer customer : customersWithMaxOrders) {
                    System.out.println("Customer ID: " + customer.getCustomerID());
                    System.out.println("Customer Name: " + customer.getUserName());
                    System.out.println("Order count: " + customer.getCustomerOrders().size());
                    System.out.println();
                }
            }
            break;

            // customer with max revenue case
            case 3: {
                ArrayList<Customer> customersWithMaxRevenue = adminLoggedIn.getCustomerWithMaxRevenue(customerArrayList);
                System.out.println("Customers with max Revenue: ");

                for (Customer customer : customersWithMaxRevenue) {
                    System.out.println("Customer ID: " + customer.getCustomerID());
                    System.out.println("Customer Name: " + customer.getUserName());
                    System.out.println("Revenue: " + customer.calculateTotalRevenue());
                    System.out.println();
                }
            }
            break;
        }


        System.out.println("Return to Admin Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }
        }

        if (returnOption == 1)
            adminMenu(adminLoggedIn);
        else {
            saveArrayLists();
            System.exit(0);
        }
    }

    public static void adminViewDataOfOrders(Admin adminLoggedIn) {
        System.out.println("------------------------------");
        System.out.println("1) View an Order's details");
        System.out.println("2) Calculate Average Revenue in a time Period");
        System.out.println("3) Calculate Total Revenue in a time Period");
        System.out.print("Which option would you like? ");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 3)
                    break;
                System.out.print("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        switch (option) {
            // View Order details case
            case 1: {
                int orderID = -1;
                while (true) {
                    try {
                        System.out.println("Enter the ID of the Order you want to see its details: ");
                        orderID = s.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        s.next();
                        System.out.println("Invalid Input, please enter a valid number");
                    }

                }

                Order orderNeeded = null;
                for (Order order : orderArrayList) {
                    if (order.getOrderID() == orderID) {
                        orderNeeded = order;
                        break;
                    }
                }

                adminLoggedIn.viewOrderDetails(orderArrayList, orderNeeded);
            }
            break;

            // Calculate average revenue in a period of time case
            case 2: {
                s.nextLine();
                Date startDate = getDateInput("Enter start date (dd/MM/yyyy): ");
                Date endDate;

                while (true) {
                    endDate = getDateInput("Enter end date (dd/MM/yyyy): ");

                    if (endDate.after(startDate) || endDate.equals(startDate)) {
                        break;  // Exit the loop if end date is valid
                    } else {
                        System.out.println("End date should be equal to or after the start date.");
                    }
                }

                double averageRevenue = adminLoggedIn.getAverageRevenue(orderArrayList, startDate, endDate);

                System.out.println("Average Revenue from ");
                System.out.println("Start Date: " + startDate);
                System.out.println("End Date: " + endDate);
                System.out.println("Revenue: " + averageRevenue);

            }
            break;

            // Calculate total revenue in a period of time case
            case 3: {
                s.nextLine();
                Date startDate = getDateInput("Enter start date (dd/MM/yyyy): ");
                Date endDate;

                while (true) {
                    endDate = getDateInput("Enter end date (dd/MM/yyyy): ");

                    if (endDate.after(startDate) || endDate.equals(startDate)) {
                        break;  // Exit the loop if end date is valid
                    } else {
                        System.out.println("End date should be equal to or after the start date.");
                    }
                }

                double averageRevenue = adminLoggedIn.getTotalRevenue(orderArrayList, startDate, endDate);

                System.out.println("Total Revenue from ");
                System.out.println("Start Date: " + startDate);
                System.out.println("End Date: " + endDate);
                System.out.println("Revenue: " + averageRevenue);

            }
            break;
        }

        System.out.println("Return to Admin Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }
        }

        if (returnOption == 1)
            adminMenu(adminLoggedIn);
        else {
            saveArrayLists();
            System.exit(0);
        }
    }

    public static void sellerManagerMethod(Seller sellerLoggedIn) {
        System.out.println("-----------------------------");
        System.out.println("1) Add Product");
        System.out.println("2) Edit Product");
        System.out.println("3) Remove Product");
        System.out.println("4) View Products");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 4)
                    break;
                System.out.print("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }
        }

        switch (option) {
            // Seller add product case
            case 1: {
                System.out.print("Enter the name of the product: ");
                String productName = s.nextLine();
                s.nextLine();

                System.out.print("Enter the price of the product: ");
                double productPrice = s.nextDouble();

                int id = productArrayList.size() +1;
                Product newProduct = new Product(id, productName, productPrice);

                System.out.println("New Product Added: " + newProduct);
                sellerLoggedIn.addProduct(productArrayList, newProduct);
            }
            break;

            // Seller edit product case
            case 2: {
                s.nextLine();
                System.out.print("Enter the name of the product you want to edit: ");
                String productName = s.nextLine().trim();

                System.out.println("Product Name: " + productName);
                Product foundProduct = null;
                for (Product product : sellerLoggedIn.getSellerProducts()){
                    if (product.getProductName().equalsIgnoreCase(productName)){
                        foundProduct = product;
                        break;
                    }
                }


                if (foundProduct != null) {
                    System.out.println("Current Product Name: " + foundProduct.getProductName());
                    System.out.println("Current Product Price: " + foundProduct.getProductPrice());

                    System.out.println("Do you want to edit the products name or price?");
                    System.out.println("1) Name");
                    System.out.println("2) Price");

                    byte editingOption;
                    while(true){
                        editingOption = s.nextByte();
                        if (editingOption ==1 || editingOption == 2)
                            break;
                        System.out.print("Invalid Input");
                    }

                    if (editingOption == 1){
                        s.nextLine();
                        System.out.println("Enter New Name of the product");
                        String newProductName = s.nextLine();
                        sellerLoggedIn.editProductName(foundProduct, newProductName);

                        System.out.println("New Product Name: " + foundProduct.getProductName());
                    } else {

                        System.out.print("Enter the new price of the product: ");
                        double newProductPrice = s.nextDouble();
                        sellerLoggedIn.editProductPrice(foundProduct, newProductPrice);

                        System.out.println("Product edited successfully: " + foundProduct.getProductName());
                    }

                } else {
                    System.out.println("Product not found");
                }
            }
            break;

            // Seller remove product case
            case 3: {
                s.nextLine();
                System.out.print("Enter the name of the product you want to edit: ");
                String productName = s.nextLine().trim();

                System.out.println("Product Name: " + productName);
                Product foundProduct = null;
                for (Product product : sellerLoggedIn.getSellerProducts()){
                    if (product.getProductName().equalsIgnoreCase(productName)){
                        foundProduct = product;
                        break;
                    }
                }

                if (foundProduct != null) {
                    System.out.println("Removing Product Name: " + foundProduct.getProductName());
                    System.out.println("Product Price: " + foundProduct.getProductPrice());

                    sellerLoggedIn.removeProduct(productArrayList, foundProduct);
                    System.out.println("Product removed successfully");
                } else {
                    System.out.println("Product not found");
                }
            }
            break;

            // Seller view products case
            case 4: {
                System.out.println("List of Products:");
                sellerLoggedIn.displayProducts();
            }
            break;
        }

        System.out.println("Return to Seller Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        if (returnOption == 1)
            sellerMenu(sellerLoggedIn);
        else {
            saveArrayLists();
            System.exit(0);
        }

    }

    public static void sellerViewDataOfProducts(Seller sellerLoggedIn) {
        System.out.println("-----------------------------");
        System.out.println("1) View Number of Pieces sold over a specific period of time");
        System.out.println("2) View Best Seller Products over a specific period of time");
        System.out.println("3) View Most Revenue Products over a specific period of time");
        System.out.print("Which would you like to view today? ");

        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 3)
                    break;
                System.out.print("Invalid Input");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        s.nextLine();
        Date startDate = getDateInput("Enter start date (dd/MM/yyyy): ");
        Date endDate;

        while (true) {
            endDate = getDateInput("Enter end date (dd/MM/yyyy): ");

            if (endDate.after(startDate) || endDate.equals(startDate)) {
                break;  // Exit the loop if end date is valid
            } else {
                System.out.println("End date should be equal to or after the start date.");
            }
        }


        switch (option) {
            // View Number of Pieces sold over time case
            case 1: {
                int numberOfPiecesSold = sellerLoggedIn.calculatePiecesSoldOverTime(startDate, endDate);

                System.out.println(sellerLoggedIn.getUserName() + " sold " + numberOfPiecesSold + " from " +
                        startDate + " till " + endDate);
            }
                break;

            // View Best Seller Products over a specific period of time case
            case 2:{
                ArrayList<Product> bestSellingProductOverTime = sellerLoggedIn.bestSellingProductOverTime(startDate, endDate);
                System.out.println(sellerLoggedIn.getUserName() + "'s best selling products is/are:- ");
                for (Product product : bestSellingProductOverTime) {
                    System.out.println("Product ID: " + product.getProductID());
                    System.out.println("Product Name: " + product.getProductName());
                }
            }
                break;

            // View Most Revenue Products over a specific period of time case
            case 3: {
                ArrayList<Product> mostRevenueProductsOverTime = sellerLoggedIn.mostRevenueProductOverTime(startDate, endDate);
                System.out.println(sellerLoggedIn.getUserName() + "'s most revenue products is/are:- ");
                for (Product product : mostRevenueProductsOverTime) {
                    System.out.println("Product ID: " + product.getProductID());
                    System.out.println("Product Name: " + product.getProductName());
                }
            }
                break;
        }

        System.out.println("Return to Seller Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        if (returnOption == 1)
            sellerMenu(sellerLoggedIn);
        else {
            saveArrayLists();
            System.exit(0);
        }
    }

    public static void sellerViewDataOfOrders(Seller sellerLoggedIn) {
        System.out.println("-----------------------------");
        System.out.println("1) View an Order's details");
        System.out.println("2) Change an Order's status");
        System.out.println("3) Calculate Average Revenue over a specific period of time");
        System.out.println("4) Calculate total Revenue");
        
        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 4)
                    break;
                System.out.print("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        switch (option) {
            // View an Order's details case
            case 1: {
                System.out.print("Enter the Order's ID you want to view its details: ");
                int orderID = s.nextInt();


                Order foundOrder = null;
                for (Order order : orderArrayList) {
                    if (orderID == order.getOrderID()) {
                        foundOrder = order;
                        break;
                    }
                }

                if (foundOrder != null) {
                    sellerLoggedIn.viewOrderDetails(orderArrayList, foundOrder);
                } else {
                    System.out.println("Order not found");
                }
            }
                break;

            // Change an Order's status case
            case 2: {
                System.out.print("Enter the Order's ID you want to change its status: ");
                int orderID = s.nextInt();


                Order foundOrder = null;
                for (Order order : orderArrayList) {
                    if (orderID == order.getOrderID()) {
                        foundOrder = order;
                        break;
                    }
                }

                if (foundOrder != null) {
                    System.out.println("Current Order Status for Order with ID: " + foundOrder.getOrderID()
                            + " : " + foundOrder.getStatus());

                    System.out.println("What would you want to change this order's status into? ");
                    System.out.println("1) Cancelled");
                    System.out.println("2) Pending");
                    System.out.println("3) Delivered");

                    byte orderStatusOption;
                    while (true) {
                        try {
                            orderStatusOption = s.nextByte();
                            if (orderStatusOption >= 1 && orderStatusOption <= 3)
                                break;
                            System.out.print("Invalid Input ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }

                    }

                    OrderStatus orderStatus = null;
                    switch (orderStatusOption) {
                        case 1:
                            orderStatus = OrderStatus.CANCELLED;
                            sellerLoggedIn.changeOrderStatus(foundOrder, orderStatus);
                            break;
                        case 2:
                            orderStatus = OrderStatus.PENDING;
                            sellerLoggedIn.changeOrderStatus(foundOrder, orderStatus);
                            break;
                        case 3:
                            orderStatus = OrderStatus.DELIVERED;
                            sellerLoggedIn.changeOrderStatus(foundOrder, orderStatus);
                            break;
                    }

                } else {
                    System.out.println("Order not found");
                }
            }

            // Calculate Average Revenue over a specific period of time case
                break;
            case 3: {
                s.nextLine();
                Date startDate = getDateInput("Enter start date (dd/MM/yyyy): ");
                Date endDate;

                while (true) {
                    endDate = getDateInput("Enter end date (dd/MM/yyyy): ");

                    if (endDate.after(startDate) || endDate.equals(startDate)) {
                        break;  // Exit the loop if end date is valid
                    } else {
                        System.out.println("End date should be equal to or after the start date.");
                    }
                }

                double averageRevenue = sellerLoggedIn.calculateAverageRevenue(startDate, endDate);

                System.out.println(sellerLoggedIn.getUserName() + "'s average revenue from "
                        + startDate + " till " + endDate + " = " + averageRevenue);
            }
                break;

            // Calculate total Revenue over a specific period of time case
            case 4: {
                double totalRevenue = sellerLoggedIn.calculateTotalRevenue();

                System.out.println(sellerLoggedIn.getUserName() + "'s total revenue " +" = " + totalRevenue);
            }
                break;

        }

        System.out.println("Return to Seller Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        if (returnOption == 1)
            sellerMenu(sellerLoggedIn);
        else {
            saveArrayLists();
            System.exit(0);
        }
    }

    private static Date getDateInput(String prompt) {
        Date date = null;
        while (true) {
            try {
                System.out.println(prompt);
                date = format.parse(s.nextLine());
                break; // Exit the loop if parsing is successful
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use the format dd/MM/yyyy.");
            }
        }
        return date;
    }

    public static void customerStartOrdering(Customer customerLoggedIn) {
        System.out.println("-----------------------------");
        System.out.println("1) Search Vendors & Products");
        System.out.println("2) Add Product to Cart");
        System.out.println("3) Remove Product from Cart");
        System.out.println("4) Cancel/Clear Cart");
        System.out.println("5) View Cart & Confirm Order");
        
        System.out.print("Choice: ");
        byte option;
        while (true) {
            try {
                option = s.nextByte();
                if (option >= 1 && option <= 5)
                    break;
                System.out.print("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        switch (option) {
            // Search Vendors & Products case
            case 1:
                customerSearchVendorsAndProducts(customerLoggedIn);
                break;

            // Add Product to Cart case
            case 2: {
                if (chosenSeller == null) {
                    System.out.println("Which Vendor would you like to dine in? ");
                    for (int i = 0; i < sellerArrayList.size(); i++){
                        System.out.print((i + 1) + ") " + sellerArrayList.get(i).getUserName() + '\t');
                        if (i% 3 == 0)
                            System.out.println();
                    }

                    byte sellerOption;
                    while (true) {
                        try {
                            sellerOption = s.nextByte();
                            if (sellerOption >= 1 && sellerOption <= sellerArrayList.size())
                                break;
                            System.out.print("Invalid Input ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }
                    }
                    chosenSeller = sellerArrayList.get(sellerOption - 1);
                }

                // Print all the seller's products
                System.out.println(chosenSeller.getUserName() + " products and prices:- ");
                for (int i = 0; i < chosenSeller.getSellerProducts().size(); i++) {
                    Product product = chosenSeller.getSellerProducts().get(i);
                    System.out.println("\t" + (i + 1) + ") " + product.getProductName()
                            + ", Price: " + product.getProductPrice());
                }

                while (true) {
                    System.out.println("Enter the product number you want to add to your cart (0 to finish): ");
                    int productOption = -1;

                    try {
                        productOption = s.nextInt();
                        if (productOption == 0) {
                            break; // User chose to finish adding products
                        }

                    } catch (InputMismatchException e) {
                        s.next();
                        System.out.println("Invalid Input, please enter a valid number");
                    }


                    System.out.println("How many of " + chosenSeller.getSellerProducts().get(productOption - 1).getProductName()
                            + " would you like? ");
                    int productQuantity;
                    while (true) {
                        try {
                            productQuantity = s.nextInt();
                            if (productQuantity > 0)
                                break;
                            System.out.print("Invalid Input ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }
                    }

                    if (productOption <= chosenSeller.getSellerProducts().size()){
                        Product selectedProduct = chosenSeller.getSellerProducts().get(productOption - 1);
                        customerLoggedIn.getCustomerCart().addProduct(selectedProduct, productQuantity);
                    } else {
                        System.out.println("Invalid product number. Please try again.");
                    }
                }
            }
                break;

            // Remove Product from Cart case
            case 3: {
                System.out.println("Select the products you want? ");
                System.out.println("Your cart:- ");

                HashMap<Product, Integer> cartProducts = customerLoggedIn.getCustomerCart().getCartProducts();
                int i = 1;

                for (HashMap.Entry<Product, Integer> entry : cartProducts.entrySet()) {
                    Product product = entry.getKey();
                    int quantity = entry.getValue();

                    System.out.println(i + ") " + product.getProductName() + ", Quantity: " + quantity);
                    i++;
                }
                System.out.println("Select the product you want to remove (0 to finish): ");
                int productOption = s.nextInt();

                if (productOption == 0) {
                    System.out.println("No more products to remove.");
                } else if (productOption >= 1 && productOption <= cartProducts.size()) {
                    // Retrieve the product at the selected index
                    Product selectedProduct = null;
                    int currentIndex = 1;

                    for (HashMap.Entry<Product, Integer> entry : cartProducts.entrySet()) {
                        if (currentIndex == productOption) {
                            selectedProduct = entry.getKey();
                            break;
                        }
                        currentIndex++;
                    }

                    if (selectedProduct != null) {
                        System.out.println("Enter the quantity to remove: ");
                        int quantityToRemove = s.nextInt();

                        // Check if the entered quantity is valid
                        if (quantityToRemove > 0 && quantityToRemove <= cartProducts.get(selectedProduct)) {
                            // Update the quantity in the cart
                            customerLoggedIn.getCustomerCart().removeProduct(selectedProduct, quantityToRemove);
                            System.out.println("Quantity updated in your cart.");
                        } else {
                            System.out.println("Invalid quantity. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid product number. Please try again.");
                    }
                } else {
                    System.out.println("Invalid product number. Please try again.");
                }

            }
                break;

            // Cancel/Clear Cart case
            case 4: {
                s.nextLine();
                System.out.println("Confirm Clearing Cart? yes/no");
                String clearCartConfirmation = s.nextLine();

                if (clearCartConfirmation.equalsIgnoreCase("yes")){
                    customerLoggedIn.getCustomerCart().clearCart();
                    System.out.println("Cart Cleared");
                }
            }
                break;

            // View Cart case
            case 5: {

                HashMap<Product, Integer> cartProducts = customerLoggedIn.getCustomerCart().getCartProducts();
                if (!cartProducts.isEmpty()) {
                    int i = 0;
                    for (HashMap.Entry<Product, Integer> entry : cartProducts.entrySet()) {
                        Product product = entry.getKey();
                        int quantity = entry.getValue();

                        System.out.println((i + 1) + ") " + product.getProductName() + ", Quantity: " + quantity);
                        i++;
                    }

                    s.nextLine();
                    System.out.println("Total Cart Price: " + customerLoggedIn.getCustomerCart().getTotalPrice());
                    System.out.println("-------------------------------");
                    System.out.println("Confirm Order? yes/no");

                    String cartConfirmation;
                    while (true) {
                        try {
                            cartConfirmation = s.nextLine();
                            if (cartConfirmation.equalsIgnoreCase("yes") ||
                                    cartConfirmation.equalsIgnoreCase("no"))
                                break;
                            System.out.print("Invalid Input ");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }

                    }

                    if (cartConfirmation.equalsIgnoreCase("yes")) {
                        int orderID = orderArrayList.size() + 1;
                        Order newOrder = new Order(orderID);
                        newOrder.setOrderProducts(customerLoggedIn.getCustomerCart().getCartProducts());
                        newOrder.setOrderDate(new Date());
                        newOrder.setTotalPrice(customerLoggedIn.getCustomerCart().getTotalPrice());

                        System.out.print("Enter your address: ");
                        String address = s.nextLine();
                        //s.nextLine();
                        System.out.println("Address Entered: " + address);
                        newOrder.setOrderAddress(address);

                        orderArrayList.add(newOrder);
                        customerLoggedIn.getCustomerOrders().add(newOrder);
                        chosenSeller.getSellerOrders().add(newOrder);
                    }
                }
            }
                break;
        }

        System.out.println("Return to Customer Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        if (returnOption == 1)
            customerMenu(customerLoggedIn);
        else {
            customerLoggedIn.getCustomerCart().clearCart();
            saveArrayLists();
            System.exit(0);
        }


    }

    public static void customerTrackHistory(Customer customerLoggedIn) {
        System.out.println("-----------------------------");
        System.out.println("Choose an option:");
        System.out.println("1. View all of his order details");
        System.out.println("2. Track order status");
        System.out.println("3. Rate orders from 1 to 5");

        int option = s.nextInt();

        switch (option) {
            case 1:{

                if (!customerLoggedIn.getCustomerOrders().isEmpty()) {
                    for (Order order : customerLoggedIn.getCustomerOrders()) {
                        System.out.println("Order Details:");
                        System.out.println("Order ID: " + order.getOrderID());
                        for (HashMap.Entry<Product, Integer> entry : order.getOrderProducts().entrySet()) {
                            Product product = entry.getKey();
                            int quantity = entry.getValue();

                            System.out.println("  - " + product.getProductName() +
                                    ", Quantity: " + quantity +
                                    ", Price per unit: " + product.getProductPrice());
                        }

                        System.out.println("Order Status: " + order.getStatus());
                        System.out.println("Total Amount: " + order.getTotalPrice());
                        System.out.println("Order Date: " + order.getOrderDate());

                    }
                } else {
                    System.out.println("You haven't ordered anything yet");
                }

            }
                break;
            case 2:{
                if (!customerLoggedIn.getCustomerOrders().isEmpty()) {

                    System.out.println("Enter the order ID to track:");
                    int orderId = s.nextInt();

                    Order orderToTrack = null;

                    for (Order order : customerLoggedIn.getCustomerOrders()) {
                        if (order.getOrderID() == orderId) {
                            orderToTrack = order;
                            break;
                        }
                    }

                    if (orderToTrack != null) {
                        System.out.println("Order ID: " + orderToTrack.getOrderID());
                        System.out.println("Order Status: " + orderToTrack.getStatus());
                    } else {
                        System.out.println("Order not found.");
                    }
                } else {
                    System.out.println("You haven't ordered anything yet");
                }
            }
                break;
            case 3: {
                if (!customerLoggedIn.getCustomerOrders().isEmpty()) {
                    System.out.println("Enter the order ID to rate:");
                    int orderIdToRate = s.nextInt();

                    Order orderToRate = null;

                    for (Order order : customerLoggedIn.getCustomerOrders()) {
                        if (order.getOrderID() == orderIdToRate) {
                            orderToRate = order;
                            break;
                        }
                    }

                    if (orderToRate != null) {
                    System.out.println("Enter your rating (1 to 5):");
                    int rating;


                    while (true) {
                        try {
                            rating = s.nextInt();
                            if (rating >= 1 && rating <= 5)
                                break;
                            System.out.println("Invalid Input");

                        } catch (InputMismatchException e) {
                            s.next();
                            System.out.println("Invalid Input, please enter a valid number");
                        }

                    }
                    orderToRate.setRate(rating);
                    System.out.println("Rating submitted successfully.");

                } else {
                    System.out.println("Order not found.");
                }

                } else {
                    System.out.println("You haven't ordered anything yet");
                }
            }
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }

        System.out.println("Return to Customer Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            try {
                returnOption = s.nextByte();
                if (returnOption == 1 || returnOption == 2)
                    break;
                System.out.println("Invalid Input ");

            } catch (InputMismatchException e) {
                s.next();
                System.out.println("Invalid Input, please enter a valid number");
            }

        }

        if (returnOption == 1)
            customerMenu(customerLoggedIn);
        else {
            customerLoggedIn.getCustomerCart().clearCart();
            saveArrayLists();
            System.exit(0);
        }
    }

    public static void customerSearchVendorsAndProducts(Customer customerLoggedIn) {
        s.nextLine();
        System.out.println("-----------------------------");
        System.out.print("What do you want to search for? ");
        String searchQuery = s.nextLine();

        for (Seller seller : sellerArrayList){
            ArrayList<Product> sellerListThatMatchesSearch = new ArrayList<>();
            sellerListThatMatchesSearch = customerLoggedIn.searchProducts(seller.getSellerProducts(), searchQuery);

            if (!sellerListThatMatchesSearch.isEmpty()){
                for (Product product : sellerListThatMatchesSearch) {
                    System.out.println("Product ID: " + product.getProductID());
                    System.out.println("Product Name: " + product.getProductName());
                    System.out.println("Product Price: " + product.getProductPrice());
                    System.out.println("Product Seller: " + seller.getUserName());
                }
                System.out.println("____________________________");
            }

        }
    }
}