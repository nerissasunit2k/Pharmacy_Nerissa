/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy_nerissa;

/**
 *
 * @author sunitne_sd2082
 */
public class Pharmacist extends Account{

    public Pharmacist() {
    }

    public Pharmacist(String username, String password, String role) {
        super(username, password);
    }

    public Pharmacist(String username, String password, String fname, String lname, int age) {
        super(username, password, fname, lname, age);
    }

    public Pharmacist(Personal_info p, Account a) {
        super(p, a);
    }
    
    
    
}