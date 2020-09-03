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
public class Doctor {
    public final static String DOCTOR_ID = "DoctorID";
      public final static String FIRST_NAME = "FirstName";
      public final static String LAST_NAME = "LastName";
      public final static String GENDER = "Gender";
      public final static String PHONE_NUMBER = "PhoneNo";
      public final static String SPECIALIZATION = "Specialization";
      public final static String DEPARTMENT = "Department";
      public final static String CONSULATION_DAY = "ConsulationDay";
        public final static String CONSULATION_TIME = "ConsulationTime";
      
    private int DoctorID;
    private String FirstName;
    private String LastName;
    private String Gender;
    private int PhoneNo;
    private String Specialization;
    private String Department;
    private String ConsulationDay;
    private String ConsulationTime;

    public Doctor(int DoctorID, String FirstName, String LastName, String Gender, int PhoneNo,String Specialization, String Department, String ConsulationDay, String ConsulationTime) {
        this.DoctorID = DoctorID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Specialization = Specialization;
        this.Department = Department;
        this.ConsulationDay = ConsulationDay;
        this.ConsulationTime = ConsulationTime;
         this.PhoneNo = PhoneNo;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(int PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getConsulationDay() {
        return ConsulationDay;
    }

    public void setConsulationDay(String ConsulationDay) {
        this.ConsulationDay = ConsulationDay;
    }

    public String getConsulationTime() {
        return ConsulationTime;
    }

    public void setConsulationTime(String ConsulationTime) {
        this.ConsulationTime = ConsulationTime;
    }

    @Override
    public String toString() {
        return  DoctorID + FirstName + LastName +  Gender +  PhoneNo +  Specialization +  Department +  ConsulationDay + ConsulationTime ;
    }

    
    
}
