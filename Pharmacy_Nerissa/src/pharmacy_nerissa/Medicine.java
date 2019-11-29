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
public class Medicine {
    private String type;
    private String brandName;
    private double price;
    private String genericName;
    private int quantity;

    public Medicine() {
    }
   
    public Medicine(String type, String brandName, double price, String genericName, int quantity) {
        this.type = type;
        this.brandName = brandName;
        this.price = price;
        this.genericName = genericName;
        this.quantity = quantity;
    }
    
     public Medicine(String brandName, double price, int quantity) {
        this.brandName = brandName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        
        
//       System.out.println("|%-20sTYPE|%-20sBRAND NAME|%-20sPRICE|%-20sGENERIC NAME|%-20sQUANTITY");
       return String.format("\n%20s  %20s  %15s  %15s %20s", type, brandName, price,genericName,quantity);
//       System.out.println("|%-20sTYPE|%-20sBRAND NAME|%-20sPRICE|%-20sGENERIC NAME|me, quantity);

    }
    
}
    