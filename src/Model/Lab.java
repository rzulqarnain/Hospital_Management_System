/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author StudentAdmin
 */
public class Lab {

    public final static String PATIENT_ID = "PatientID";
    public final static String PATIENT_TYPE = "PatientType";
    public final static String DATE = "date";
    public final static String CATEGORY = "Category";
    public final static String AMOUNT = "Amount";

    int PatientID;
    String PatientType;
    String date;
    String Category;
    int Amount;

    public Lab(int PatientID, String PatientType, String date, String Category, int Amount) {
        this.PatientID = PatientID;
        this.PatientType = PatientType;
        this.date = date;
        this.Category = Category;
        this.Amount = Amount;
    }

    public int getPatientID() {
        return PatientID;
    }

    public String getPatientType() {
        return PatientType;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return Category;
    }

    public int getAmount() {
        return Amount;
    }

    @Override
    public String toString() {
        return "PatientID=" + PatientID + ", PatientType=" + PatientType + ", date=" + date + ", Category=" + Category + ", Amount=" + Amount;
    }

}
