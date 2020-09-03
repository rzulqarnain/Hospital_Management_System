/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Accessors;

import Model.Pharmacy;
import static Accessors.PharmacyAccessor.findPharmacyByID;
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
public class PharmacyAccessor {

    private static final String sqlSelectAll = "select * from PHARMACY order by MEDICINE_ID";
    private static final String sqlInsert = "insert into PHARMACY values(?,?,?,?,?,?,?,?)";
    private static final String sqlDelete = "delete from PHARMACY where MEDICINE_ID = ?";
    private static final String sqlUpdate = "update PHARMACY set  MEDICINE_NAME = ?, MEDICINE_TYPE = ?, SUPPLIER_ID = ?, STOCK = ?, PRICE = ?, MANUFACTURE_DATE = ?, EXPIRY_DATE = ? where Medicine_ID = ?";

    private PharmacyAccessor() {
    }

    public static ArrayList<Pharmacy> findAllPharmacy() {
        return findPharmacy(sqlSelectAll);
    }

    public static ArrayList<Pharmacy> findPharmacy(String query) {
        ArrayList<Pharmacy> res = new ArrayList();

        Connection conn = null;
        Statement st = null;
        ResultSet result = null;

        try {
            conn = ConnectionManager.getConnection();
            st = conn.createStatement();
            result = st.executeQuery(query);

            while (result.next() == true) {
                int MedID = result.getInt("MEDICINE_ID");
                String MedName = result.getString("MEDICINE_NAME");
                String MedType = result.getString("MEDICINE_TYPE");
                int SupplierId = result.getInt("SUPPLIER_ID");
                int Stock = result.getInt("STOCK");
                int Price = result.getInt("PRICE");
                String ManuDate = result.getString("MANUFACTURE_DATE");
                String ExpDate = result.getString("EXPIRY_DATE");
                Pharmacy item = new Pharmacy(MedID, MedName, MedType, SupplierId, Stock, Price, ManuDate, ExpDate);
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

    public static Pharmacy findPharmacyByID(int id) {
        Pharmacy res = null;
        List<Pharmacy> Pharmacy = findPharmacy("select * from PHARMACY where MEDICINE_ID=" + id);
        if (Pharmacy.size() == 1) {
            res = Pharmacy.get(0);
        }
        return res;
    }

    private static boolean PharmacyExists(Pharmacy pharmacy) {
        return findPharmacyByID(pharmacy.getMedicineID()) != null;
    }

    public static boolean deletePharmacy(Pharmacy item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!PharmacyExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, item.getMedicineID());

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

    public static boolean addPharmacy(Pharmacy item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (PharmacyExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlInsert);
            
            int MedID = item.getMedicineID();
            String MedName = item.getMedicineName();
            String MedType = item.getMedicineType();
            int SupplierId = item.getSupplierID();
            int Stock = item.getStock();
            int Price = item.getPrice();
            String ManuDate = item.getManufactureDate();
            String ExpDate = item.getExpiryDate();

            ps.setInt(1, MedID);
            ps.setString(2, MedName);
            ps.setString(3, MedType);
            ps.setInt(4, SupplierId);
            ps.setInt(5, Stock);
            ps.setInt(6, Price);
            ps.setString(7, ManuDate);
            ps.setString(8, ExpDate);
            

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

    public static boolean updatePharmacy(Pharmacy item) {
        boolean res = false;
        Connection conn = null;
        PreparedStatement ps = null;

        if (!PharmacyExists(item)) {
            return false;
        }

        try {
            conn = ConnectionManager.getConnection();
            ps = conn.prepareStatement(sqlUpdate);

            int MedID = item.getMedicineID();
            String MedName = item.getMedicineName();
            String MedType = item.getMedicineType();
            int SupplierId = item.getSupplierID();
            int Stock = item.getStock();
            int Price = item.getPrice();
            String ManuDate = item.getManufactureDate();
            String ExpDate = item.getExpiryDate();

            ps.setInt(8, MedID);
            ps.setString(1, MedName);
            ps.setString(2, MedType);
            ps.setInt(3, SupplierId);
            ps.setInt(4, Stock);
            ps.setInt(5, Price);
            ps.setString(6, ManuDate);
            ps.setString(7, ExpDate);

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
