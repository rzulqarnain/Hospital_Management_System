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
public class Ward {
    
     public final static String PATIENT_ID = "Patientid";
      public final static String WARD_NUMBER = "WardNumber";
      public final static String WARD_TYPE = "Wardtype";
      public final static String DEPARTMENT = "Department";
     
        
    private int Patientid;
    private int WardNumber;
    private String Wardtype;
    private String Department;

    public Ward(int Patientid, int WardNumber, String Wardtype, String Department) {
        this.Patientid = Patientid;
        this.WardNumber = WardNumber;
        this.Wardtype = Wardtype;
        this.Department = Department;
    }

    public int getPatientid() {
        return Patientid;
    }

    public int getWardNumber() {
        return WardNumber;
    }

    public String getWardtype() {
        return Wardtype;
    }

    public String getDepartment() {
        return Department;
    }

    @Override
    public String toString() {
        return  "Patientid=" + Patientid + ", WardNumber=" + WardNumber + ", Wardtype=" + Wardtype + ", Department=" + Department ;
    }
    
    
}
