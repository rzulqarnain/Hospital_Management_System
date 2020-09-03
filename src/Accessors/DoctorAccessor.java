/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Model.Doctor;
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
public class DoctorAccessor {

    private static final String sqlSelectAll = "select * from DOCTOR order by DOCTOR_ID";
    private static final String sqlInsert = "insert into DOCTOR values(?,?,?,?,?,?,?,?,?)";
    private static final String sqlDelete = "delete from DOCTOR where DOCTOR_ID = ?";
    private static final String sqlUpdate = "update DOCTOR set FIRST_NAME = ?, lAST_NAME = ?, GENDER = ?,PHONE_NUMBER=?, SPECIALIZATION = ?, DEPARTMENT = ?, CONSULATION_DAY = ?, CONSULATION_TIME = ? where DOCTOR_ID = ?";

    private DoctorAccessor() {
    }
    public static ArrayList<Doctor> findAllDoctor() {
        return findDoctor(sqlSelectAll);
    } 
    public static ArrayList<Doctor> findDoctor(String query) {
        ArrayList<Doctor> res = new ArrayList();

        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(query);

            while (result.next() == true) {
                int DoctorID = result.getInt("DOCTOR_ID");
                String lastname = result.getString("LAST_NAME");
                String firstname = result.getString("FIRST_NAME");
                String gender = result.getString("GENDER");
                int phoneNumber = result.getInt("PHONE_NUMBER");
                String specialization = result.getString("SPECIALIZATION");
                String department = result.getString("DEPARTMENT");
                String consulationDay = result.getString("CONSULATION_DAY");
                String consulationTime = result.getString("CONSULATION_TIME");
                Doctor item = new Doctor(DoctorID, firstname, lastname, gender, phoneNumber, specialization, department, consulationDay, consulationTime);
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
    public static Doctor findDoctorByID(int id) {
        Doctor res = null;
        List<Doctor> doctor = findDoctor("select * from DOCTOR where DOCTOR_ID=" + id);
        if (doctor.size() == 1) {
            res = doctor.get(0);
        }
        return res;
    }

    private static boolean DoctorExists(Doctor doctor) {
        return findDoctorByID(doctor.getDoctorID()) != null;
    }

    public static boolean deleteDoctor(Doctor item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!DoctorExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, item.getDoctorID());

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
    public static boolean addDoctor(Doctor item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (DoctorExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlInsert);

            int id = item.getDoctorID();
            String lastname = item.getLastName();
            String firstname = item.getFirstName();
            String gender = item.getGender();
            int phonenNumber = item.getPhoneNo();
            String specialization = item.getSpecialization();
            String department = item.getDepartment();
            String consulationDay = item.getConsulationDay();
            String consulationTime = item.getConsulationTime();

            ps.setInt(1, id);
            ps.setString(3, lastname);
            ps.setString(2, firstname);
            ps.setString(4, gender);
            ps.setInt(5, phonenNumber);
            ps.setString(6, specialization);
            ps.setString(7, department);
            ps.setString(8, consulationDay);
            ps.setString(9, consulationTime);

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
    public static boolean updateDoctor(Doctor item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!DoctorExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlUpdate);

            int id = item.getDoctorID();
            String lastname = item.getLastName();
            String firstname = item.getFirstName();
            String gender = item.getGender();
            int phonenNumber = item.getPhoneNo();
            String specialization = item.getSpecialization();
            String department = item.getDepartment();
            String consulationDay = item.getConsulationDay();
            String consulationTime = item.getConsulationTime();

            ps.setInt(9, id);
            ps.setString(2, lastname);
            ps.setString(1, firstname);
            ps.setString(3, gender);
             ps.setInt(4, phonenNumber);
            ps.setString(5, specialization);
            ps.setString(6, department);
            ps.setString(7, consulationDay);
            ps.setString(8, consulationTime);

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

