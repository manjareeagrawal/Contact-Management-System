import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserServiceImpl();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create User");
            System.out.println("2. Search User by ID");
            System.out.println("3. Search User by Name");
            System.out.println("4. Remove User by ID");
            System.out.println("5. Print all users.");
            System.out.println("6. Update User using uuid.");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your phone no: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your category (1 for Personal, 0 for Business): ");
                    int cat_value = scanner.nextInt();
                    String category;
                    if (cat_value == 0)
                        category = "Business";
                    else if (cat_value == 1)
                        category = "Personal";
                    else
                        category = null;

                    UUID uuid = UUID.randomUUID();
                    System.out.println("Generated UUI: " + uuid.toString());
                    User user = userService.createUser(uuid, name, phone, email, category);
                    System.out.println("User created with UUID: " + uuid);
                    break;

                case 2:
                    System.out.print("Enter the user ID to search: ");
                    String searchId = scanner.nextLine();
                    UUID uuid1=UUID.fromString(searchId);
                    User foundUserById = userService.getUserById(uuid1);
                    if (foundUserById != null) {
                        System.out.println("User found:");
                        userService.displayUser(foundUserById);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the user name to search: ");
                    String searchName = scanner.nextLine();
                    User foundUserByName = userService.getUserByName(searchName);
                    if (foundUserByName != null) {
                        System.out.println("User found:");
                        userService.displayUser(foundUserByName);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the user ID to remove: ");
                    String removeId = scanner.nextLine();
                    UUID uuid2=UUID.fromString(removeId);
                    userService.removeUserById(uuid2);
                    System.out.println("User with ID " + removeId + " removed.");
                    break;

                case 5:
                    System.out.println("Which Data Structure Do You Want The List to Print in?");
                    System.out.println("1. HashMap");
                    System.out.println("2. LinkedHashMap");
                    System.out.println("3. TreeMap");
                    System.out.println("4. LinkedList");
                    System.out.println("5. ArrayList");
                    System.out.println("6. Exit");
                    int dsChoice = scanner.nextInt();
                    switch (dsChoice) {
                        case 1:
                            userService.printAllUsers("HashMap");
                            break;
                        case 2:
                            userService.printAllUsers("LinkedHashMap");
                            break;
                        case 3:
                            System.out.println("Choose how to sort in TreeMap:");
                            System.out.println("1. Sort by Name");
                            System.out.println("2. Sort by Email");
                            System.out.println("3. Sort by Phone");
                            System.out.println("4. Sort by Category");

                            int sortChoice = scanner.nextInt();
                            userService.sortTreeMapByColumn(sortChoice);
                            break;
                        case 4:
                            userService.printAllUsers("LinkedList");
                            break;
                        case 5:
                            userService.printAllUsers("ArrayList");
                            break;
                        case 6:
                            System.out.println("Exiting the data structure choice menu.");
                            break;
                        default:
                            System.out.println("Invalid data structure choice.");
                            break;
                    }
                    break;

                case 6:
                    System.out.println("Enter the UUID of the user to update:");
                    String uuidString = scanner.nextLine();
                    UUID uuid3 = UUID.fromString(uuidString);
                    User u = userService.getUserById(uuid3);

                    if (u != null) {
                        System.out.println("User Credentials: Choose the number where you want to edit");
                        System.out.println("1. Name: " + u.getName());
                        System.out.println("2. Email: " + u.getEmail());
                        System.out.println("3. Phone: " + u.getPhone());
                        System.out.println("4. Category: " + u.getCategory());
                        System.out.println("5. Exit");

                        int updateChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (updateChoice >= 1 && updateChoice <= 4) {
                            System.out.print("Enter the updated value: ");
                            String updatedValue = scanner.nextLine();

                            // Call the finalUpdateEntry method to update the user's data
                            userService.finalUpdateEntry(u, updatedValue, updateChoice,uuid3);

                            System.out.println("User updated successfully.");
                        } else if (updateChoice == 5) {
                            System.out.println("Exiting the update menu.");
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("User with UUID " + uuidString + " not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }


}
