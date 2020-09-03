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
public class Patient {
    public final static String PATIENT_ID = "PatientID";
      public final static String FIRST_NAME = "FirstName";
      public final static String LAST_NAME = "LastName";
      public final static String GENDER = "PatientGender";
      public final static String DATE_OF_BIRTH = "PatientDOB";
      public final static String AGE = "PatientAge";
      public final static String PHONE_NUMBER = "PatientPhone";
      public final static String NATIONALITY = "PatientNationality";
      public final static String PATIENT_TYPE = "PatientType";
      public final static String PATIENT_ROLE = "PatientRole";
      
    
    
    
    private int PatientID;
    private String PatientRole;
    private String FirstName;
    private String LastName;
    private String PatientType;
    private String PatientGender;
    private String PatientDOB;
    private int PatientPhone;
    private int PatientAge;
    private String PatientNationality;
    

    public Patient(int PatientID, String PatientRole, String FirstName, String LastName, String PatientType, String PatientGender, String PatientDOB, int PatientPhone, int PatientAge, String PatientNationality) {
        this.PatientID = PatientID;
        this.PatientRole = PatientRole;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PatientType = PatientType;
        this.PatientGender = PatientGender;
        this.PatientDOB = PatientDOB;
        this.PatientPhone = PatientPhone;
        this.PatientAge = PatientAge;
        this.PatientNationality = PatientNationality;
    

  
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public String getPatientRole() {
        return PatientRole;
    }

    public void setPatientRole(String PatientRole) {
        this.PatientRole = PatientRole;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPatientType() {
        return PatientType;
    }

    public void setPatientType(String PatientType) {
        this.PatientType = PatientType;
    }

    public String getPatientGender() {
        return PatientGender;
    }

    public void setPatientGender(String PatientGender) {
        this.PatientGender = PatientGender;
    }

    public String getPatientDOB() {
        return PatientDOB;
    }

    public void setPatientDOB(String PatientDOB) {
        this.PatientDOB = PatientDOB;
    }

    public int getPatientPhone() {
        return PatientPhone;
    }

    public void setPatientPhone(int PatientPhone) {
        this.PatientPhone = PatientPhone;
    }

    public int getPatientAge() {
        return PatientAge;
    }

    public void setPatientAge(int PatientAge) {
        this.PatientAge = PatientAge;
    }

    public String getPatientNationality() {
        return PatientNationality;
    }

    public void setPatientNationality(String PatientNationality) {
        this.PatientNationality = PatientNationality;
    }

    @Override
    public String toString() {
        return  PatientID  + PatientRole  + FirstName +  LastName +  PatientType +  PatientGender +  PatientDOB +  PatientPhone +  PatientAge +  PatientNationality;
    }
     
}
