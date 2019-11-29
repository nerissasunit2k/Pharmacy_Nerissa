/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy_nerissa;


import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author sunitne_sd2082
 */
public class Main {
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pharmacy p = new Pharmacy();
        p.addStock();
//        display.firstMenu();
        Account acc = new Account();

        OUTER_1:
        while (true) {
            OUTER_2:
            while (true) {
                System.out.print("\n1. Customer\n2. Pharmacist\nChoice: ");
                int in1 = input.nextInt();
                System.out.print("\n1. Register\n2. Log In\nChoice: ");
                int in2 = input.nextInt();
                switch (in1) {
                    //customer
                    case 1:
                        switch (in2) {
                            case 1:
                                acc = p.registerCustomer();
                                if (acc.getUsername() == null) {
                                    System.out.println("\nMinors are not allowed to purchased!\n");
                                    break;
                                } else {
                                    break OUTER_2;
                                }
                            case 2:
                                acc = p.loginCustomer();
                                if (acc.getUsername() != null) {
                                    break OUTER_2;
                                } else {
                                    System.out.println("\nCannot find account! Register first!");
                                }
                                break;
                            default:
                                System.out.println("\nInvalid Input!");
                        }
                        break;
                    //pharmacist
                    case 2:
                        switch (in2) {
                            case 1:
                                acc = p.registerPharmacist();
                                break OUTER_2;
                            case 2:
                                acc = p.loginPharmacist();
                                if (acc.getUsername() != null) {
                                    break OUTER_2;
                                } else {
                                    System.out.println("\nCannot find account! Register first");
                                }
                                break;
                            default:
                                System.out.println("\nInvalid Input!");
                        }
                        break;
                    default:
                        System.err.println("Invalid Input.");
                        break;
                }
            }

            //if customer
            if (acc instanceof Customer) {
                ArrayList<Medicine> purchasedTempHolder = new ArrayList();
                OUTER_3:
                while (true) {
                    System.out.print("\n1. View Types of Medicine\n2. Exit\nChoice: ");
                    switch (input.nextInt()) {
                        case 1:
                            System.out.println("\n1. Cough\n2. Headache\n3. Allergies\n4. Body Pain\n5. Exit\n>");
                            int in4 = input.nextInt();
                            p.displayMed(in4);
                            if (in4 != 5 ) {
                                p.purchaseMed((Customer) acc, purchasedTempHolder);
                            }else{
                                System.out.println("You are now exit!");
                                break;
                            }
                            break;
                        case 2:
                            System.out.println("You are now exit! Thank you :D");
                           // p.computeTotal((Customer) acc, purchasedTempHolder);
                            break OUTER_3;
                        default:
                            System.out.println("\nInvalid input!");
                    }
                }
                //if pharmacist
            } else {
                OUTER_4:
                while (true) {
                    System.out.print("1. View Types of Medicine\n2. Add Medicine\n3. View Users\n4. Remove Medicine\n5. Exit\nChoice: ");
                    switch (input.nextInt()) {
                        case 1:
                            System.out.println("\n1. Cough\n2. Headache\n3. Allergies\n4. Body Pain\n5. Exit\n>");
                            int in4 = input.nextInt();
                            p.displayMed(in4);
                            break;
                        case 2:
                            p.addMedicine();
                            break;
                        case 3:
                            p.viewUsers();
                            break;
                        case 4:
                            System.out.println("Remove medecine");
                            input.nextLine();
                            System.out.println("Medicine name:");
                            String medname = input.nextLine();
                            p.removeMedicine(medname);
                            break ;
                        case 5: 
                            System.out.println("You are now exit ! Thank you");
                            break  OUTER_4;
                        default:
                            System.out.println("\nInvalid input!\n");
                    }
                }
            }
        }

    }
}
