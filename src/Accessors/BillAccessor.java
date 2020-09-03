/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Model.Bill;
import Model.Patient;
import database.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author StudentAdmin
 */
public class BillAccessor {

    private static final String sqlSelectAll = "select * from BILL order by BILL_NUMBER";
    private static final String sqlInsert = "insert into BILL values(?,?,?,?,?,?,?,?,?)";
    private static final String sqlDelete = "delete from BILL where BILL_NUMBER = ?";
    private static final String sqlUpdate = "update BILL set PATIENT_ID = ?, DOCTOR_ID = ?, PATIENT_TYPE = ?,DOCTOR_CHARGE=?, MEDICINE_CHARGE = ?, ROOM_CHARGE = ?, LAB_CHARGE = ?, TOTAL = ? where BILL_NUMBER = ?";

    private BillAccessor() {
    } 
    public static ArrayList<Bill> findAllBill() {
        return findBill(sqlSelectAll);
    } 
    public static ArrayList<Bill> findBill(String query) {
        ArrayList<Bill> res = new ArrayList();

        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(query);

            while (result.next() == true) {
                int BillNo = result.getInt("BILL_NUMBER");
                int PatientID = result.getInt("PATIENT_ID");
                int DoctorID = result.getInt("DOCTOR_ID");
                String PatientType = result.getString("PATIENT_TYPE");
                int DocCharge = result.getInt("DOCTOR_CHARGE");
                int MedCharge = result.getInt("MEDICINE_CHARGE");
                int RoomCharge = result.getInt("ROOM_CHARGE");
                int LabCharge = result.getInt("LAB_CHARGE");
                int Total = result.getInt("TOTAL");

                Bill item = new Bill(BillNo, PatientID, DoctorID, PatientType, DocCharge, MedCharge, RoomCharge, LabCharge, Total);
                res.add(item);
            }

        } catch (SQLException e) {
            res = new ArrayList();
            System.err.println(e);
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!");
            }

        }
        return res;
    }
    public static Bill findBillByPatientID(int PatientID) {
        Bill res = null;
        List<Bill> patient = findBill("select * from BILL where PATIENT_ID=" + PatientID);
        if (patient.size() == 1) {
            res = patient.get(0);
        }
        return res;
    }
    
    public static Bill findBillByNo(int num) {
        Bill res = null;
        List<Bill> bill = findBill("select * from BILL where BILL_NUMBER=" + num);
        if (bill.size() == 1) {
            res = bill.get(0);
        }
        return res;
    }

//     private static boolean BillExists(Bill bill) {
//        return findBillByPatientID(bill.getPatientID()) != null;
//    }
     
    private static boolean BillExists(Bill bill) {
        return findBillByNo(bill.getBillNumber()) != null;
    }
    

    public static boolean deleteBill(Bill item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!BillExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, item.getBillNumber());

            ps.execute();
            res = true;
        } catch (SQLException e) {
            res = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!");
            }

        }
        return res;
    } 
    public static boolean addBill(Bill item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (BillExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlInsert);

            int Billno = item.getBillNumber();
            int PatientID = item.getPatientID();
                int DoctorID = item.getDoctorID();
                String PatientType = item.getPatientType();
                int DocCharge = item.getDoctorCharge();
                int MedCharge = item.getMedicineCharge();
                int RoomCharge = item.getRoomCharge();
                int LabCharge = item.getLabCharge();
                int Total = item.getTotal();
                
            ps.setInt(1, Billno);
            ps.setInt(3, PatientID);
            ps.setInt(2, DoctorID);
            ps.setString(4, PatientType);
            ps.setInt(5, DocCharge);
            ps.setInt(6, MedCharge);
            ps.setInt(7, RoomCharge);
            ps.setInt(8, LabCharge);
            ps.setInt(9, Total);

            ps.execute();
            res = true;
        } catch (SQLException e) {
            res = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!");
            }

        }
        return res;
    } 
    public static boolean updateBill(Bill item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!BillExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlUpdate);

            int Billno = item.getBillNumber();
            int PatientID = item.getPatientID();
                int DoctorID = item.getDoctorID();
                String PatientType = item.getPatientType();
                int DocCharge = item.getDoctorCharge();
                int MedCharge = item.getMedicineCharge();
                int RoomCharge = item.getRoomCharge();
                int LabCharge = item.getLabCharge();
                int Total = item.getTotal();

            ps.setInt(9, Billno);
            ps.setInt(1, PatientID);
            ps.setInt(2, DoctorID);
            ps.setString(3, PatientType);
            ps.setInt(4, DocCharge);
            ps.setInt(5, MedCharge);
            ps.setInt(6, RoomCharge);
            ps.setInt(7, LabCharge);
            ps.setInt(8, Total);

            ps.execute();
            res = true;
        } catch (SQLException e) {
            res = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("Could not close resources!");
            }

        }
        return res;
    } 

} 
