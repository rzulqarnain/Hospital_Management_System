/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Model.Lab;
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
public class LabAccessor {

    private static final String sqlSelectAll = "select * from LAB order by PATIENT_ID";
    private static final String sqlInsert = "insert into LAB values(?,?,?,?,?)";
    private static final String sqlUpdate = "update LAB set PATIENT_TYPE = ?, DATE = ?, CATEGORY = ?, AMOUNT = ? where PATIENT_ID = ?";

    private LabAccessor() {
    }

    public static ArrayList<Lab> findAllLab() {
        return findLab(sqlSelectAll);
    }

    public static ArrayList<Lab> findLab(String query) {
        ArrayList<Lab> res = new ArrayList();

        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(query);

            while (result.next() == true) {
                int PatientID = result.getInt("PATIENT_ID");
                String PatientType = result.getString("PATIENT_TYPE");
                String date = result.getString("DATE");
                String category = result.getString("CATEGORY");
                int Amount = result.getInt("AMOUNT");

                Lab item = new Lab(PatientID, PatientType, date, category, Amount);
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

    public static Lab findLabByPID(int id) {
        Lab res = null;
        List<Lab> lab = findLab("select * from LAB where PATIENT_ID =" + id);
        if (lab.size() == 1) {
            res = lab.get(0);
        }
        return res;
    }

    private static boolean LabExists(Lab lab) {
        return findLabByPID(lab.getPatientID()) != null;
    }

//    public static boolean deleteLab(Lab item) {
//        boolean res = false;
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        if (!LabExists(item)) {
//            return false;
//        }
//
//        try {
//            conn = ConnectionManager.getConnection();
//            ps = conn.prepareStatement(sqlDelete);
//            ps.setInt(1, item.getPatientID());
//
//            ps.execute();
//            res = true;
//        } catch (SQLException e) {
//            res = false;
//        } finally {
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Could not close resources!");
//            }
//
//        }
//        return res;
//    } // end remove
    public static boolean addLab(Lab item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (LabExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlInsert);

            int Patientid = item.getPatientID();
            String PatientType = item.getPatientType();
            String date = item.getDate();
            String category = item.getCategory();
            int Amount = item.getAmount();

            ps.setInt(1, Patientid);
            ps.setString(2, PatientType);
            ps.setString(3, date);
            ps.setString(4, category);
            ps.setInt(5, Amount);

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

    public static boolean updateLab(Lab item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!LabExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlUpdate);

            int Patientid = item.getPatientID();
            String PatientType = item.getPatientType();
            String date = item.getDate();
            String category = item.getCategory();
            int Amount = item.getAmount();

            ps.setInt(5, Patientid);
            ps.setString(1, PatientType);
            ps.setString(2, date);
            ps.setString(3, category);
            ps.setInt(4, Amount);

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
