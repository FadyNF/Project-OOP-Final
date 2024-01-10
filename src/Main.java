import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);

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
        /*
        sellerArrayList.add(new Seller("Buffalo Burger", "123", 1));
        sellerArrayList.add(new Seller("Wimpy", "123", 2));
        sellerArrayList.add(new Seller("Willy's Kitchen", "123", 3));
        sellerArrayList.add(new Seller("Alagha", "123", 4));
        sellerArrayList.add(new Seller("Pablo & Abdo", "123", 5));
        sellerArrayList.add(new Seller("Bazooka", "123", 6));
        sellerArrayList.add(new Seller("City Crepe", "123", 7));
        sellerArrayList.add(new Seller("Mori Sushi", "123", 8));
        sellerArrayList.add(new Seller("Prego", "123", 9));
        sellerArrayList.add(new Seller("Asian Corner", "123", 10));
        sellerArrayList.add(new Seller("Paul", "123", 11));
        sellerArrayList.add(new Seller("Wafflicious", "123", 12));
        sellerArrayList.add(new Seller("DipNDip", "123", 13));
        sellerArrayList.add(new Seller("Primos", "123", 14));
        sellerArrayList.add(new Seller("Cilantro", "123", 15));*/
        /*
        productArrayList.add(new Product(1, "Animal Style", 166));
        productArrayList.add(new Product(2, "Cholos", 161));
        productArrayList.add(new Product(3, "Blue Cheese", 166));
        productArrayList.add(new Product(4, "Hitchhicker", 198));
        productArrayList.add(new Product(5, "Old School", 161));
        productArrayList.add(new Product(6, "Spicy B", 107));
        productArrayList.add(new Product(7, "New Skool", 105));
        productArrayList.add(new Product(8, "BBQ Bacon Chicken", 115));
        productArrayList.add(new Product(9, "Cheesy Chicky Fillet", 105));
        productArrayList.add(new Product(10, "Junior Cheese Burger", 48));
        productArrayList.add(new Product(11, "Big Willy", 142));
        productArrayList.add(new Product(12, "Chili Chili", 152));
        productArrayList.add(new Product(13, "Pepperazzi", 157));
        productArrayList.add(new Product(14, "Brooklyn Shrooms", 142));
        productArrayList.add(new Product(15, "Ranchie Crunch", 172));
        productArrayList.add(new Product(16, "Chicken shawerma", 65));
        productArrayList.add(new Product(17, "Beef Shawerma", 80));
        productArrayList.add(new Product(18, "Crunchy chicken Sandwich", 80));
        productArrayList.add(new Product(19, "Fajita Sandwich", 80));
        productArrayList.add(new Product(20, "French Fries Sandwich", 35));
        productArrayList.add(new Product(21, "Pablo Burger", 65));
        productArrayList.add(new Product(22, "Original Tony Burger", 95));
        productArrayList.add(new Product(23, "Con Carne Taco", 85));
        productArrayList.add(new Product(24, "Corden Bleu Sandwich", 89));
        productArrayList.add(new Product(25, "Cowboy Hot Dog Sandwich", 85));
        productArrayList.add(new Product(26, "Tower Chicken Crispy", 100));
        productArrayList.add(new Product(27, "Chicken Turkey", 100));
        productArrayList.add(new Product(28, "Honey Yummy", 135));
        productArrayList.add(new Product(29, "RPG", 150));
        productArrayList.add(new Product(30, "Zinger Supreme", 9));
        productArrayList.add(new Product(31, "Hot Dog Crepe", 62));
        productArrayList.add(new Product(32, "Crispy Crepe", 72));
        productArrayList.add(new Product(33, "Tuna Crepe", 57));
        productArrayList.add(new Product(34, "Mafia Crepe", 87));
        productArrayList.add(new Product(35, "Monster Crepe", 67));
        productArrayList.add(new Product(36, "Combo 30", 420));
        productArrayList.add(new Product(37, "Combo 50", 650));
        productArrayList.add(new Product(38, "Combo 100", 1250));
        productArrayList.add(new Product(39, "Miso Soup", 65));
        productArrayList.add(new Product(40, "Tom Yum", 110));
        productArrayList.add(new Product(41, "Grilled Kofta Meal", 127));
        productArrayList.add(new Product(42, "Grilled Fillet Meal", 163));
        productArrayList.add(new Product(43, "Star Mix Meal", 253));
        productArrayList.add(new Product(44, "Shish Tawook Meal", 127));
        productArrayList.add(new Product(45, "Chicken BBQ Meal", 95));
        productArrayList.add(new Product(46, "Mahraja Meal", 115));
        productArrayList.add(new Product(47, "Sea Food Meal", 145));
        productArrayList.add(new Product(48, "Nasi Goreng", 110));
        productArrayList.add(new Product(49, "Chicken Sechuan", 105));
        productArrayList.add(new Product(50, "Mah Mee Noodles", 55));
        productArrayList.add(new Product(51, "Miso Avocado Toast", 159));
        productArrayList.add(new Product(52, "Feta Avo", 169));
        productArrayList.add(new Product(53, "Salmon Croll", 199));
        productArrayList.add(new Product(54, "Halloumi Pesto", 164));
        productArrayList.add(new Product(55, "Omelette Club", 169));
        productArrayList.add(new Product(56, "Belgium Waffle", 58));
        productArrayList.add(new Product(57, "American Waffle", 47));
        productArrayList.add(new Product(58, "Mickey Waffle", 39));
        productArrayList.add(new Product(59, "TNT Belgium Waffle", 100));
        productArrayList.add(new Product(60, "Maltesers Waffle", 90));
        productArrayList.add(new Product(61, "Brownies Crepe", 232));
        productArrayList.add(new Product(62, "Fettuccine Crepe", 272));
        productArrayList.add(new Product(63, "Waffle Stick", 167));
        productArrayList.add(new Product(64, "Oreo Pancakes", 316));
        productArrayList.add(new Product(65, "Bella Nutella Cake", 1228));
        productArrayList.add(new Product(66, "Salami Pizza", 145));
        productArrayList.add(new Product(67, "Hot Dog Pizza", 140));
        productArrayList.add(new Product(68, "Chicken Ranch Pizza", 160));
        productArrayList.add(new Product(69, "Chicken BBQ Pizza", 160));
        productArrayList.add(new Product(70, "Smoked Pizza", 165));
        productArrayList.add(new Product(71, "Cappucciano", 65));
        productArrayList.add(new Product(72, "Latte", 60));
        productArrayList.add(new Product(73, "Latte Frappe", 80));
        productArrayList.add(new Product(74, "Flat White",70 ));
        productArrayList.add(new Product(75, "Iced Spanish Latte", 85));*/
        /*int counter = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                Seller seller = sellerArrayList.get(i);
                Product product = productArrayList.get(counter);
                seller.getSellerProducts().add(product);
                counter++;
            }
        }*/
        /*for (Seller seller : sellerArrayList){
            System.out.println("Seller ID: " + seller.getSellerID());
            System.out.println("Seller Name: " + seller.getUserName());
            System.out.println("Seller Pass: " + seller.getUserPassword());

            System.out.println("______________________________");
            System.out.println("Seller Products:-");
            for (Product product : seller.getSellerProducts()){
                System.out.println("\tProduct ID: " + product.getProductID());
                System.out.println("\tProduct Name: " + product.getProductName());
                System.out.println("\tProduct Price: " + product.getProductPrice());
            }
            System.out.println();
        }*/
        /*for  (Seller seller : sellerArrayList){
            if (seller.getUserName().equalsIgnoreCase("Alagha")){
                for (Product product : seller.getSellerProducts()){
                    System.out.println("Product ID: " + product.getProductID());
                    System.out.println("Product Name: " + product.getProductName());
                }
            }
        }*/

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
            loginOption = s.nextByte();
            if (loginOption == 1 || loginOption == 2) {
                break;
            }
            System.out.println("Invalid Choice ");
        }

        System.out.println("1) Admin");
        System.out.println("2) Seller");
        System.out.println("3) Customer");
        System.out.println("Choose your role: ");
        byte roleOption;
        while (true) {
            roleOption = s.nextByte();
            if (roleOption >= 1 && roleOption <= 3) {
                break;
            }
            System.out.println("Invalid Choice ");
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
                        failedLoginChoice = s.nextByte();
                        if (failedLoginChoice == 1 || failedLoginChoice == 2) {
                            break;
                        }
                        System.out.println("Invalid Choice ");
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
                        failedLoginChoice = s.nextByte();
                        if (failedLoginChoice == 1 || failedLoginChoice == 2) {
                            break;
                        }
                        System.out.println("Invalid Choice ");
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
                        failedLoginChoice = s.nextByte();
                        if (failedLoginChoice == 1 || failedLoginChoice == 2) {
                            break;
                        }
                        System.out.println("Invalid Choice ");
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
                        failedLoginChoice = s.nextByte();
                        if (failedLoginChoice == 1 || failedLoginChoice == 2) {
                            break;
                        }
                        System.out.println("Invalid Choice ");
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
                        failedLoginChoice = s.nextByte();
                        if (failedLoginChoice == 1 || failedLoginChoice == 2) {
                            break;
                        }
                        System.out.println("Invalid Choice ");
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
                        failedLoginChoice = s.nextByte();
                        if (failedLoginChoice == 1 || failedLoginChoice == 2) {
                            break;
                        }
                        System.out.println("Invalid Choice ");
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
            option = s.nextByte();
            if (option >= 1 && option <= 4)
                break;
            System.out.print("Invalid Input: ");
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
    }

    public static void sellerMenu(Seller sellerLoggedIn) {
        System.out.println("Seller Menu: ");
        System.out.println("1) Add - Edit - Remove - Search");
        System.out.println("2) View Data about Products");
        System.out.println("3) View Data about Orders");

        byte option;
        while (true) {
            option = s.nextByte();
            if (option >= 1 && option <= 3)
                break;
            System.out.print("Invalid Input ");
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
            option = s.nextByte();
            if (option >= 1 && option <= 4)
                break;
            System.out.print("Invalid Input ");
        }

        switch (option) {
            // Admin add user case
            case 1: {
                System.out.println("What is the type of User you want to add? ");
                System.out.println("1) Customer");
                System.out.println("2) Seller");

                byte typeOfUser;
                while (true) {
                    typeOfUser = s.nextByte();
                    if (typeOfUser == 1 || typeOfUser == 2)
                        break;
                    System.out.print("Invalid Input ");
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
                    userType = s.nextByte();
                    if (userType == 1 || userType == 2)
                        break;
                    System.out.print("Invalid Input ");
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
                    userType = s.nextByte();
                    if (userType == 1 || userType == 2)
                        break;
                    System.out.print("Invalid Input ");
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
            returnOption = s.nextByte();
            if (returnOption == 1 || returnOption == 2)
                break;
            System.out.println("Invalid Input ");
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
            option = s.nextByte();
            if (option >= 1 && option <= 3)
                break;
            System.out.println("Invalid Input ");
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
            returnOption = s.nextByte();
            if (returnOption == 1 || returnOption == 2)
                break;
            System.out.println("Invalid Input ");
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
        System.out.println("1) Orders per Customer and its details");
        System.out.println("2) Customer with max Orders");
        System.out.println("3) Customer with max Revenue");

        byte option;
        while (true) {
            option = s.nextByte();
            if (option >= 1 && option <= 3)
                break;
            System.out.print("Invalid Input ");
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
            returnOption = s.nextByte();
            if (returnOption == 1 || returnOption == 2)
                break;
            System.out.println("Invalid Input ");
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
            option = s.nextByte();
            if (option >= 1 && option <= 3)
                break;
            System.out.print("Invalid Input ");
        }

        switch (option) {
            // View Order details case
            case 1: {
                System.out.println("Enter the ID of the Order you want to see its details: ");
                int orderID = s.nextInt();
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
                Date startDate = null, endDate = null;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    s.nextLine();
                    System.out.println("Enter start date (dd/MM/yyyy): ");
                    startDate = format.parse(s.nextLine());

                    System.out.println("Enter end date (dd/MM/yyyy): ");
                    endDate = format.parse(s.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please enter in dd/MM/yyyy format.");
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
                Date startDate = null, endDate = null;
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    s.nextLine();
                    System.out.println("Enter start date (dd/MM/yyyy): ");
                    startDate = format.parse(s.nextLine());

                    System.out.println("Enter end date (dd/MM/yyyy): ");
                    endDate = format.parse(s.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid date format. Please enter in dd/MM/yyyy format.");
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
            returnOption = s.nextByte();
            if (returnOption == 1 || returnOption == 2)
                break;
            System.out.println("Invalid Input ");
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
            option = s.nextByte();
            if (option >= 1 && option <= 4)
                break;
            System.out.print("Invalid Input ");
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

                        System.out.println("Product edited successfully: " + foundProduct);
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
                for (Product product : productArrayList) {
                    System.out.println(product);
                }
            }
            break;
        }

        System.out.println("Return to Seller Menu?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        byte returnOption;
        while (true) {
            returnOption = s.nextByte();
            if (returnOption == 1 || returnOption == 2)
                break;
            System.out.println("Invalid Input ");
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
            option = s.nextByte();
            if (option >= 1 && option <= 3)
                break;
            System.out.print("Invalid Input");
        }

        Date startDate = null,
                endDate = null;
        SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy");

        try {
            s.nextLine();
            System.out.println("Enter start date (dd/MM/yyyy):");
            startDate=format.parse(s.nextLine());
            System.out.println("Enter end date (dd/MM/yyyy):  ");
            endDate=format.parse(s.nextLine());

        } catch (Exception e) {
            System.out.println("Invalid date format. Please use the format dd/MM/yyyy.");
            return;
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
                System.out.println(sellerLoggedIn.getUserName() + "'s best selling products is/are:- ");
                for (Product product : mostRevenueProductsOverTime) {
                    System.out.println("Product ID: " + product.getProductID());
                    System.out.println("Product Name: " + product.getProductName());
                }
            }
                break;
        }
    }

    public static void sellerViewDataOfOrders(Seller sellerLoggedIn) {}
}