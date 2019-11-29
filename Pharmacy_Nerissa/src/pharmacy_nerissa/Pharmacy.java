/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy_nerissa;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author sunitne_sd2082
 */
public class Pharmacy {

    Scanner in = new Scanner(System.in);
    private ArrayList<Medicine> medicines;
    private ArrayList<Account> accounts;

    public Pharmacy(ArrayList<Medicine> medicines, ArrayList<Account> accounts) {
        this.medicines = medicines;
        this.accounts = accounts;
    }

    public void viewUsers() {

        for (Account account : accounts) {
            if (account instanceof Customer) {
                System.out.println(account);
                if (!((Customer) account).getPurchasedMedicine().isEmpty()) {
                    System.out.println("Purchase history:");
                    Customer acc = (Customer) account;
                    computeTotal(acc, acc.getPurchasedMedicine());
                }
            }
        }
    }

    public Pharmacy() {
        medicines = new ArrayList();
        accounts = new ArrayList();
    }

    public Account registerPharmacist() {
        Account a = inputAccount();
        System.out.println("\nPersonal Information:");
        Personal_info p = inputPerInfo();
        Pharmacist ph = new Pharmacist(p, a);
        accounts.add(ph);
        System.out.println("\nAccount successfully created\n Login as Pharmacists");
        return ph;
    }

    public Account loginPharmacist() {
        Account a = inputAccount();
        for (int i = 0; i < accounts.size(); ++i) {
            Account acc = accounts.get(i);
            if (acc.getUsername().equals(a.getUsername()) && acc.getPassword().equals(a.getPassword())) {
                return acc;
            }
        }
        return new Account();
    }

    public Account registerCustomer() {
        Account a = inputAccount();
        System.out.println("\nPersonal Information:");
        Personal_info p = inputPerInfo();
        if (p.getAge() >= 18) {
            Customer c = new Customer(p, a);
            accounts.add(c);
            System.out.println("\nAccount successfully created\n Log in as User");
            return c;
        }
        return new Account();
    }

    public Account loginCustomer() {
        Account a = inputAccount();
        for (int i = 0; i < accounts.size(); ++i) {
            Account acc = accounts.get(i);
            if (acc.getUsername().equalsIgnoreCase(a.getUsername()) && acc.getPassword().equalsIgnoreCase(a.getPassword())) {
                return acc;
            }
        }
        return new Account();
    }

    public void addMedicine() {
        String type = inputString("Enter type: ");
        String bname = inputString("Enter brand name: ");
        String gname = inputString("Enter generic name: ");
        double price = inputInt("Enter price: ");
        int quant = inputInt("Enter quantity: ");
        medicines.add(new Medicine(type, bname, price, gname, quant));
    }


    public void removeMedicine(String name){
        Iterator itr = medicines.iterator();
        while(itr.hasNext()){
            Medicine med = (Medicine) itr.next();
            if(name.equals(med.getGenericName())){
                itr.remove();
            }
            
        }
        
    }
    
 

    public ArrayList<Medicine> purchaseMed(Customer c, ArrayList<Medicine> purchased) {
        while (true) {
            System.out.println("Enter medicine: ");
            String med = in.next();
            int quant = inputInt("Enter quantity: ");
            Medicine foundmed = findMedicine(med);
            if (foundmed.getBrandName() != null) {
                if (foundmed.getQuantity() >= quant) {
                    foundmed.setQuantity(foundmed.getQuantity() - quant);
                    Medicine purMed = new Medicine(med, foundmed.getPrice(), quant);
                    c.addPurchasedMedicine(purMed);
                    purchased.add(purMed);
                    System.out.println("Press any key to add more\nPress 'n' to exit");
                    String ch = in.next();
                    if (ch.equalsIgnoreCase("n")) {
                        computeTotal(c, purchased);
                        break;
                    } 
                } else {
                    System.out.println("Medicine stock is insufficient\nThe available only is " + foundmed.getQuantity());
                }
            } else {
                System.out.println("Medicine is unavailable!");
            }
        }
        return purchased;
    }

    public void computeTotal(Customer c, ArrayList<Medicine> pmed) {
        double total = 0;
        System.out.println("__________________________________");
        for (Medicine m : pmed) {
            System.out.println("Medicine: " + m.getBrandName());
            System.out.println("Price: " + m.getPrice());
            System.out.println("Quantity: " + m.getQuantity());
            System.out.println("Total: " + m.getPrice() * m.getQuantity());
            total += m.getPrice() * m.getQuantity();
            System.out.println("__________________________________");
        }
        if (c.getAge() > 59) {
            total = total - (total * .20);
            System.out.println("DISCOUNT 20%");
        }
        System.out.println("TOTAL AMOUNT: " + total);
        System.out.println("__________________________________");
    }

    public void addMedicine(Medicine m) {
        medicines.add(m);
    }

    public Medicine findMedicine(String medName) {
        for (Medicine m : medicines) {
            if (m.getBrandName().equals(medName)) {
                return m;
            }
        }
        return new Medicine();
    }

    public void displayMed() {
        for (Medicine m : medicines) {
            System.out.println(m);
        }
    }

    public void displayType() {
        String type = inputString("Enter type of medicine: ");
        for (Medicine m : medicines) {
            if (m.getType().equals(type)) {
                System.out.println(m);
            }
        }
    }

    public String inputString(String label) {
        System.out.print(label);
        return in.next();
       
    }

    public int inputInt(String label) {
        System.out.print(label);
        return in.nextInt();
    }

    public Personal_info inputPerInfo() {
        String fname = inputString("Enter first name: ");
        String lname = inputString("Enter last name: ");
        String age = inputString("Enter age: ");
        return new Personal_info(fname, lname, Integer.valueOf(age));
    }

    public Account inputAccount() {
        String uname = inputString("Enter username: ");
        String pass = inputString("Enter password: ");
        return new Account(uname, pass);
    }

    public void viewType(String type) {
        System.out.printf("\n%20s | %20s | %15s | %15s |%20s|", "Type", "BrandName", "Price", "Generic Name", "Quantity\n");
        for (Medicine m : medicines) {
            if (m.getType().equalsIgnoreCase(type)) {
                System.out.println(m);
            }
        }
    }

    public void addStock() {
        medicines.add(new Medicine("Cough", "Ambroxol1", 35, "Myracof", 50));
        medicines.add(new Medicine("Headache", "Cataflam", 25, "Diclofenac", 50));
        medicines.add(new Medicine("Allergies", "Mometasone Furoat", 25, "Allerta Dermatec", 50));
        medicines.add(new Medicine("Body Pain", "Ibuprofen + Paracetamol", 25, "Alaxan", 50));

        medicines.add(new Medicine("Cough", "Ambroxol", 35, "Expel OD", 50));
        medicines.add(new Medicine("Headache", "Paracetamol", 25, "UHP Fevertab", 50));
        medicines.add(new Medicine("Allergies", "Loratadine", 23, "Allerta", 50));
        medicines.add(new Medicine("Body Pain", "Paracetamol Caffeine", 10, "Rexidol", 50));

        medicines.add(new Medicine("Cough", "Carbocisteine", 30, "Solmux", 50));
        medicines.add(new Medicine("Headache", "Paracetamol", 50, "Biogesic 325", 50));
        medicines.add(new Medicine("Allergies", "Cetirizine", 25, "Allerkid", 50));
        medicines.add(new Medicine("Body Pain", "Ibuprofen", 20, "Medicol Advance", 50));
        
        medicines.add(new Medicine("Cough", "Codral Cold & Flu", 10, "phenylephrine", 50));
        medicines.add(new Medicine("Headache", "Aleve", 50, "Naproxen", 50));
        medicines.add(new Medicine("Allergies", "Loratadine", 25, "Alavert", 50));
        medicines.add(new Medicine("Body Pain", "Acetaminophen", 20, "Tylenol", 50));

    }

    public void displayMed(int in4) {
        switch (in4) {
            case 1:
                viewType("Cough");
                break;
            case 2:
                viewType("Headache");
                break;
            case 3:
                viewType("Allergies");
                break;
            case 4:
                viewType("Body Pain");
                break;
            case 5:
                break;
            default:
                System.out.println("\nINVALID INPUT!");
        }
    }

}