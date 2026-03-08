
import java.util.Scanner;

public class CheckoutApp {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        DiscountType discount = DiscountType.NONE;

        while (true) {
            System.out.println("\n=== Campus Bookstore Checkout ===");
            System.out.println("1. Add Textbook");
            System.out.println("2. Add Merch");
            System.out.println("3. View Receipt");
            System.out.println("4. Apply Discount");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine(); // consume leftover newline
            } else {
                System.out.println("Invalid input. Please enter a number 1-5.");
                sc.nextLine(); // clear bad input
                continue;
            }

            switch (choice) {

                case 1: {
                    // Add Textbook
                    System.out.print("Enter textbook name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price;
                    if (sc.hasNextDouble()) {
                        price = sc.nextDouble();
                        sc.nextLine();
                    } else {
                        System.out.println("Invalid price. Returning to menu.");
                        sc.nextLine();
                        break;
                    }

                    System.out.print("Enter course code (ex: CS211): ");
                    String courseCode = sc.nextLine();

                    Textbook t = new Textbook(name, price, courseCode);
                    boolean added = cart.addItem(t);

                    if (added) {
                        System.out.println("Textbook added to cart.");
                    } else {
                        System.out.println("Could not add item (cart full or invalid).");
                    }
                    break;
                }

                case 2: {
                    // Add Merch
                    System.out.print("Enter merch name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price;
                    if (sc.hasNextDouble()) {
                        price = sc.nextDouble();
                        sc.nextLine();
                    } else {
                        System.out.println("Invalid price. Returning to menu.");
                        sc.nextLine();
                        break;
                    }

                    System.out.print("Enter size (S, M, L): ");
                    String size = sc.nextLine();

                    Merch m = new Merch(name, price, size);
                    boolean added = cart.addItem(m);

                    if (added) {
                        System.out.println("Merch added to cart.");
                    } else {
                        System.out.println("Could not add item (cart full or invalid).");
                    }
                    break;
                }

                case 3: {
                    // View Receipt + apply discount summary
                    cart.printReceipt();

                    double subtotal = cart.cartSubtotal();
                    double tax = cart.cartTax();
                    double totalBeforeDiscount = subtotal + tax;

                    double discountAmount = subtotal * (discount.getStorePercent() / 100.0);
                    double subtotalAfterDiscount = subtotal - discountAmount;
                    double totalAfterDiscount = subtotalAfterDiscount + tax;

                    System.out.println("Discount: " + discount + " (" + discount.getStorePercent() + "%)");
                    System.out.println("Total before discount: $" + totalBeforeDiscount);
                    System.out.println("Total after discount:  $" + totalAfterDiscount);
                    break;
                }

                case 4: {
                    // Apply Discount
                    System.out.println("Choose discount type:");
                    System.out.println("1. NONE");
                    System.out.println("2. STUDENT");
                    System.out.println("3. STAFF");
                    System.out.println("4. CLEARANCE");
                    System.out.print("Enter choice: ");

                    int dChoice;
                    if (sc.hasNextInt()) {
                        dChoice = sc.nextInt();
                        sc.nextLine();
                    } else {
                        System.out.println("Invalid input. Returning to menu.");
                        sc.nextLine();
                        break;
                    }

                    switch (dChoice) {
                        case 1:
                            discount = DiscountType.NONE;
                            break;
                        case 2:
                            discount = DiscountType.STUDENT;
                            break;
                        case 3:
                            discount = DiscountType.STAFF;
                            break;
                        case 4:
                            discount = DiscountType.CLEARANCE;
                            break;
                        default:
                            System.out.println("Invalid discount option. Keeping previous discount.");
                            break;
                    }

                    System.out.println("Discount set to: " + discount + " (" + discount.getStorePercent() + "%)");
                    break;
                }

                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return; // exits main

                default:
                    System.out.println("Invalid option. Pick 1-5.");
                    continue; // jump back to menu
            }
        }
    }
    
}