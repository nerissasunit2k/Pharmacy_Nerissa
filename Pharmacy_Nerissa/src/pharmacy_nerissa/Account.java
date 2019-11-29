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
public class Account extends Personal_info {
    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, String fname, String lname, int age) {
        super(fname, lname, age);
        this.username = username;
        this.password = password;
    }

    public Account(Personal_info p, Account a) {
        super(p.getFname(), p.getLname(), p.getAge());
        this.username = a.getUsername();
        this.password = a.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;    
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", fname=" + super.getFname() + ", lname=" + super.getLname() + ", age=" + super.getAge() + '}';
   }

}