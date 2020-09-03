/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author StudentAdmin
 */
public class Bill {
    
      public final static String BILL_NUMBER = "BillNumber";
      public final static String PATIENT_ID = "PatientID";
      public final static String DOCTOR_ID = "DoctorID";
      public final static String PATIENT_TYPE = "PatientType";
      public final static String DOCTOR_CHARGE = "DoctorCharge";
      public final static String MEDICINE_CHARGE = "MedicineCharge";
      public final static String ROOM_CHARGE = "RoomCharge";
      public final static String LAB_CHARGE = "LabCharge";
        public final static String TOTAL = "Total";
    
    ArrayList<Bill> bills;
    private int BillNumber;
    private int PatientID;
    private int DoctorID;
    private String PatientType;
    private int DoctorCharge;
    private int MedicineCharge;
    private int RoomCharge;
    private int LabCharge;
    private int Total;

    public Bill(int BillNumber, int PatientID, int DoctorID, String PatientType, int DoctorCharge, int MedicineCharge, int RoomCharge, int LabCharge, int Total) {
        this.BillNumber = BillNumber;
        this.PatientID = PatientID;
        this.DoctorID = DoctorID;
        this.PatientType = PatientType;
        this.DoctorCharge = DoctorCharge;
        this.MedicineCharge = MedicineCharge;
        this.RoomCharge = RoomCharge;
        this.LabCharge = LabCharge;
        this.Total = Total;
    }

    public int getBillNumber() {
        return BillNumber;
    }

    public void setBillNumber(int BillNumber) {
        this.BillNumber = BillNumber;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int DoctorID) {
        this.DoctorID = DoctorID;
    }

    public String getPatientType() {
        return PatientType;
    }

    public void setPatientType(String PatientType) {
        this.PatientType = PatientType;
    }

    public int getDoctorCharge() {
        return DoctorCharge;
    }

    public void setDoctorCharge(int DoctorCharge) {
        this.DoctorCharge = DoctorCharge;
    }

    public int getMedicineCharge() {
        return MedicineCharge;
    }

    public void setMedicineCharge(int MedicineCharge) {
        this.MedicineCharge = MedicineCharge;
    }

    public int getRoomCharge() {
        return RoomCharge;
    }

    public void setRoomCharge(int RoomCharge) {
        this.RoomCharge = RoomCharge;
    }

    public int getLabCharge() {
        return LabCharge;
    }

    public void setLabCharge(int LabCharge) {
        this.LabCharge = LabCharge;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "BillNumber=" + BillNumber + ", PatientID=" + PatientID + ", DoctorID=" + DoctorID + ", PatientType=" + PatientType + ", DoctorCharge=" + DoctorCharge + ", MedicineCharge=" + MedicineCharge + ", RoomCharge=" + RoomCharge + ", LabCharge=" + LabCharge + ", Total=" + Total;
    }
    
   
    
    
}
