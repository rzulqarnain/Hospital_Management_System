/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

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
 * @author Student
 */
public class PatientAccessor {

    private static final String sqlSelectAll = "select * from PATIENT order by PATIENT_ID";
    private static final String sqlInsert = "insert into PATIENT values(?,?,?,?,?,?,?,?,?,?)";
    private static final String sqlDelete = "delete from PATIENT where PATIENT_ID = ?";
    private static final String sqlUpdate = "update PATIENT set FIRST_NAME = ?, lAST_NAME = ?, GENDER = ?, DATE_OF_BIRTH = ?, AGE = ?, PHONE_NUMBER = ?, NATIONALITY = ?, PATIENT_TYPE = ?, PATIENT_ROLE = ? where PATIENT_ID = ?";

    private PatientAccessor() {
    }

    public static ArrayList<Patient> findAllPatient() {
        return findPatient(sqlSelectAll);
    }

    public static ArrayList<Patient> findPatient(String query) {
        ArrayList<Patient> res = new ArrayList();

        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(query);

            while (result.next() == true) {
                int PatientID = result.getInt("PATIENT_ID");
                String lastname = result.getString("LAST_NAME");
                String firstname = result.getString("FIRST_NAME");
                String gender = result.getString("GENDER");
                String nationality = result.getString("NATIONALITY");
                int age = result.getInt("AGE");
                String dob = result.getString("DATE_OF_BIRTH");
                int phone = result.getInt("PHONE_NUMBER");
                String patientrole = result.getString("PATIENT_ROLE");
                String patienttype = result.getString("PATIENT_TYPE");
                Patient item = new Patient(PatientID, patientrole, firstname, lastname, patienttype, gender, dob, phone, age, nationality);
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

    public static Patient findPatientByID(int id) {
        Patient res = null;
        List<Patient> patient = findPatient("select * from PATIENT where PATIENT_ID=" + id);
        if (patient.size() == 1) {
            res = patient.get(0);
        }
        return res;
    }

    private static boolean PatientExists(Patient patient) {
        return findPatientByID(patient.getPatientID()) != null;
    }

    public static boolean deletePatient(Patient item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!PatientExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, item.getPatientID());

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

    public static boolean addPatient(Patient item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (PatientExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlInsert);

            int id = item.getPatientID();
            String lastname = item.getLastName();
            String firstname = item.getFirstName();
            String gender = item.getPatientGender();
            String nationality = item.getPatientNationality();
            int age = item.getPatientAge();
            String dob = item.getPatientDOB();
            int phone = item.getPatientPhone();
            String patientrole = item.getPatientRole();
            String patienttype = item.getPatientType();

            ps.setInt(1, id);
            ps.setString(3, lastname);
            ps.setString(2, firstname);
            ps.setString(4, gender);
            ps.setString(8, nationality);
            ps.setInt(6, age);
            ps.setString(5, dob);
            ps.setInt(7, phone);
            ps.setString(10, patientrole);
            ps.setString(9, patienttype);

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

    public static boolean updatePatient(Patient item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!PatientExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlUpdate);

            int id = item.getPatientID();
            String lastname = item.getLastName();
            String firstname = item.getFirstName();
            String gender = item.getPatientGender();
            String nationality = item.getPatientNationality();
            int age = item.getPatientAge();
            String dob = item.getPatientDOB();
            int phone = item.getPatientPhone();
            String patientrole = item.getPatientRole();
            String patienttype = item.getPatientType();

            ps.setInt(10, id);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, gender);
            ps.setString(4, dob);
            ps.setInt(5, age);
            ps.setString(7, nationality);
            ps.setInt(6, phone);
            ps.setString(9, patientrole);
            ps.setString(8, patienttype);

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
