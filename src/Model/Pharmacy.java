/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Student
 */
public class Pharmacy {
    public final static String MEDICINE_ID = "MedicineID";
      public final static String MEDICINE_NAME = "MedicineName";
      public final static String MEDICINE_TYPE = "MedicineType";
      public final static String SUPPLIER_ID = "SupplierID";
      public final static String STOCK = "Stock";
      public final static String PRICE = "Price";
      public final static String MANUFACTURE_DATE = "ManufactureDate";
      public final static String EXPIRY_DATE = "ExpiryDate";
      

    private int MedicineID;
    private String MedicineName;
    private String MedicineType;
    private int SupplierID;
    private int Stock;
    private int Price;
    private String ManufactureDate;
    private String ExpiryDate;

    public Pharmacy(int MedicineID, String MedicineName, String MedicineType, int SupplierID, int Stock, int Price, String ManufactureDate, String ExpiryDate) {
        this.MedicineID = MedicineID;
        this.MedicineName = MedicineName;
        this.MedicineType = MedicineType;
        this.SupplierID = SupplierID;
        this.Stock = Stock;
        this.Price = Price;
        this.ManufactureDate = ManufactureDate;
        this.ExpiryDate = ExpiryDate;
    }

    public int getMedicineID() {
        return MedicineID;
    }

    public void setMedicineID(int MedicineID) {
        this.MedicineID = MedicineID;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String MedicineName) {
        this.MedicineName = MedicineName;
    }

    public String getMedicineType() {
        return MedicineType;
    }

    public void setMedicineType(String MedicineType) {
        this.MedicineType = MedicineType;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(String ManufactureDate) {
        this.ManufactureDate = ManufactureDate;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String ExpiryDate) {
        this.ExpiryDate = ExpiryDate;
    }

    @Override
    public String toString() {
        return "MedicineID=" + MedicineID + ", MedicineName=" + MedicineName + ", MedicineType=" + MedicineType + ", SupplierID=" + SupplierID + ", Stock=" + Stock + ", Price=" + Price + ", ManufactureDate=" + ManufactureDate + ", ExpiryDate=" + ExpiryDate;
    }
    
    
}