/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy_nerissa;

import java.util.ArrayList;

/**
 *
 * @author sunitne_sd2082
 */
public class Customer extends Account{
    private ArrayList<Medicine> purchasedMedicine;
    
    public Customer() {
    }
        
    public Customer(Personal_info p, Account a) {
        super(p, a);
        purchasedMedicine =  new ArrayList();
    } 
    public Customer(String username, String password, String role) {
        super(username, password);
        purchasedMedicine =  new ArrayList();
    }

    public Customer(String username, String password, String role, String fname, String lname, int age) {
        super(username, password, fname, lname, age);
         purchasedMedicine =  new ArrayList();
    }

    public ArrayList<Medicine> getPurchasedMedicine() {
        return purchasedMedicine;
    }

    public void setPurchasedMedicine(ArrayList<Medicine> purchasedMedicine) {
        this.purchasedMedicine = purchasedMedicine;
    }
    
    public void addPurchasedMedicine(Medicine m) {
        this.purchasedMedicine.add(m);
    }
 
}