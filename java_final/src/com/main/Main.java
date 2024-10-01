package com.main;

import com.sabarirestaurant.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
       
        int ch;
        String id;
        restaurant r;
        Scanner scan = new Scanner(System.in);
        Login l = new Login();
        User u = new User();
        int v;

        do {
            System.out.println("Enter your name:");
            u.setName(scan.next());
            System.out.println("Enter your password:");
            u.setPassword(scan.next());
            System.out.println("Enter your role (Admin or User):");
            u.setUser_type(scan.next());

            if (l.valid(u.getName(), u.getPassword(), u.getUser_type())) {
                do {
                    System.out.println("1. Add 2. Update 3. Search 4. Remove 5. Show 6. Exit");
                    ch = scan.nextInt();
                    switch (ch) {
                        case 1:
                        	 r = new restaurant();
                        	System.out.println("Enter table_no,name,food,price:");
                        	r.setTable_no(scan.next());
                            r.setName(scan.next());
                            r.setFood(scan.next());
                            r.setPrice(scan.nextInt());
                            inv.add(r);
                            break;
                        case 2:
                 	r = new restaurant();
                        	System.out.println("Enter table_no to update:");
                        	String idToUpdate=scan.next();
                        	r.setTable_no(idToUpdate);
                        	System.out.println("Enter details to be updated:");
                        	 r.setPrice(scan.nextInt());
                        	 inv.update(r);
                            break;
                        case 3:
                            System.out.println("Enter table_no to search:");
                            String table_no = scan.next();
                            r = inv.search(table_no);
                            if (r != null) {
                                System.out.println(r);
                            } else {
                                System.out.println("Not found.");
                            }
                            break;
                        case 4:
                            System.out.println("Enter table_no to remove:");
                             table_no = scan.next();
                            inv.remove(table_no);
                            break;
                        case 5:
                            inv.show();
                            break;
                        
                        case 6:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } while (ch != 6);
            } else {
                System.out.println("Invalid credentials.");
            }

            System.out.println("Press 1 to continue or any other key to exit.");
            v = scan.nextInt();
        } while (v == 1);

        scan.close();
    }
}
