/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Model.Ward;
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
public class WardAccessor {
     private static final String sqlSelectAll = "select * from WARD order by PATIENT_ID";
    private static final String sqlInsert = "insert into WARD values(?,?,?,?)";
    private static final String sqlDelete = "delete from  WARD  where PATIENT_ID = ?";
    private static final String sqlUpdate = "update WARD set WARD_NUMBER = ?, WARD_TYPE = ?, DEPARTMENT = ? where PATIENT_ID = ?";

    private WardAccessor() {
    }
    
   public static ArrayList<Ward> findAllWard() {
        return findWard(sqlSelectAll);
    } 
   
    public static ArrayList<Ward> findWard(String query) {
        ArrayList<Ward> res = new ArrayList();

        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(query);

            while (result.next() == true) {
                int PatientID = result.getInt("PATIENT_ID");
                int WardNumber = result.getInt("WARD_NUMBER");
                String WardType = result.getString("WARD_TYPE");
                String department = result.getString("DEPARTMENT");
                
               
                Ward item = new Ward(PatientID, WardNumber, WardType, department);
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
    
    public static Ward findWardByPID(int id) {
        Ward res = null;
        List<Ward> ward = findWard("select * from WARD where PATIENT_ID =" + id);
        if (ward.size() == 1) {
            res = ward.get(0);
        }
        return res;
    }

    private static boolean WardExists(Ward ward) {
        return findWardByPID(ward.getPatientid()) != null;
    }

    public static boolean deleteWard(Ward item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!WardExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, item.getPatientid());

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
    
    public static boolean addWard(Ward item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (WardExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlInsert);

            int Patientid = item.getPatientid();
            int WardNumber = item.getWardNumber();
            String Ward_type = item.getWardtype();
            String department = item.getDepartment();
            
           

            ps.setInt(1, Patientid);
            ps.setInt(2, WardNumber);
            ps.setString(3, Ward_type);
            ps.setString(4, department);
          
            

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
    
    public static boolean updateWard(Ward item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!WardExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlUpdate);

              int Patientid = item.getPatientid();
            int WardNumber = item.getWardNumber();
            String Ward_type = item.getWardtype();
            String department = item.getDepartment();
            
           

            ps.setInt(4, Patientid);
            ps.setInt(1, WardNumber);
            ps.setString(2, Ward_type);
            ps.setString(3, department);
            

          

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





