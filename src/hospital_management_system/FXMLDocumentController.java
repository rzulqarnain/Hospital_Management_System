/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital_management_system;

import Model.Bill;
import Accessors.BillAccessor;
import Model.Doctor;
import Accessors.DoctorAccessor;
import Model.Lab;
import Accessors.LabAccessor;
import Model.Patient;
import Accessors.PatientAccessor;
import Model.Pharmacy;
import Accessors.PharmacyAccessor;
import Model.Ward;
import Accessors.WardAccessor;
import database.ConnectionManager;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;
import utilities.FileUtils;

/**
 *
 * @author StudentAdmin
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;
    @FXML
    private RadioButton rbPatientMale;
    @FXML
    private RadioButton rbPatientFemale;
    private TextField txtPatientSearchID;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtPatientAge;
    @FXML
    private TextField txtPatientPhone;
    @FXML
    private TextField txtPatientNationality;
    private TextArea txtPatientArea;
    @FXML
    private RadioButton rbInpatient;
    @FXML
    private RadioButton rbOutpatient;
    @FXML
    private TextField txtMedSearchId;
    @FXML
    private TextField txtDoctorSearchID;
    @FXML
    private TextField txtDoctorFirstName;
    @FXML
    private TextField txtDoctorLastName;
    @FXML
    private TextField txtDoctorPhone;
    @FXML
    private TextField txtDoctorSpec;
    @FXML
    private TextField txtDoctorDep;
    @FXML
    private RadioButton rbDoctorMale;
    @FXML
    private RadioButton rbDoctorFemale;
    private TextArea txtDoctorArea;
    @FXML
    private TextField txtDoctorConTime;
    @FXML
    private TextField txtDoctorID;
    @FXML
    private TextField txtBillNo;
    @FXML
    private TextField txtPaymentPatientID;
    @FXML
    private TextField txtDocCharge;
    @FXML
    private TextField txtMedCharge;
    @FXML
    private TextField txtRoomCharge;
    @FXML
    private TextField txtLabCharge;
    @FXML
    private TextField txtTotal;
    private TextArea txtPaymentArea;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtSearchID;
    @FXML
    private TextField txtPaymentDocID;
    @FXML
    private Tab PatientTab;
    @FXML
    private Tab tabpane;
    @FXML
    private TabPane pane;
    @FXML
    private Tab DoctorTab;
    @FXML
    private Tab BillTab;
    private TextArea txtBillArea;
    @FXML
    private ComboBox<String> patientRole;
    @FXML
    private ComboBox<String> cmbPaymentPatientType;
    @FXML
    private TextField txtdob;
    @FXML
    private ComboBox<String> cmbDoctorConDay;
    @FXML
    private ToggleGroup grpGender;
    @FXML
    private ToggleGroup grpType;
    @FXML
    private ToggleGroup grpDGender;
    @FXML
//    private TextField txtMedSearchId;
//    @FXML
    private TextField txtMedId;
    @FXML
    private TextField txtMedName;
    @FXML
    private TextField txtMedType;
    @FXML
    private TextField txtMedSupplierId;
    @FXML
    private TextField txtMedStock;
    @FXML
    private TextField txtMedPrice;
    private TextArea txtMedArea;
    @FXML
    private TextField txtMedManuDate;
    @FXML
    private TextField txtMedExpDate;
    @FXML
    private ImageView GenderImage;
    @FXML
    private Tab PharmacyTab;
    @FXML
    private TextField txtWardSearchID;
    @FXML
    private TextField txtWardNo;
    @FXML
    private TextField txtWardType;
    @FXML
    private TextField txtWardDep;
    @FXML
    private ToggleGroup grpLGender;
    @FXML
    private TextField txtLabPatientID;
    @FXML
    private TextField txtLabDate;
    @FXML
    private TextField txtLabCategory;
    @FXML
    private TextField txtLabAmount;
    @FXML
    private Tab WardTab;
    @FXML
    private Tab LabTab;
    @FXML
    private Tab MedTab;
    private TextArea txtWardArea;
    @FXML
    private RadioButton rbLabPT;
    @FXML
    private RadioButton rbLabOutpatient;
    private TextArea txtLabArea;

    private ArrayList<Patient> Patientlist;

    private ArrayList<Bill> Billlist;

    private ArrayList<Doctor> DoctorList;

    private ArrayList<Pharmacy> PharmacyList;

    private ArrayList<Ward> WardList;

    private ArrayList<Lab> LabList;

    Connection dbconnection;
    @FXML
    private TextField txtBillPID;
    private TextArea txtBPatientArea;
    @FXML
    private TableView<Patient> tblPatient;
    @FXML
    private TableColumn<Patient, Integer> colID;
    @FXML
    private TableColumn<Patient, String> colFirstName;
    @FXML
    private TableColumn<Patient, String> colLastName;
    @FXML
    private TableColumn<Patient, String> colgender;
    @FXML
    private TableColumn<Patient, String> colDOB;
    @FXML
    private TableColumn<Patient, Integer> colAge;
    @FXML
    private TableColumn<Patient, Integer> colPhoneNumber;
    @FXML
    private TableColumn<Patient, String> colNationality;
    @FXML
    private TableColumn<Patient, String> colType;
    @FXML
    private TableColumn<Patient, String> colRole;
    @FXML
    private TableView<Doctor> tblDoctor;
    @FXML
    private TableColumn<Doctor, Integer> colDID;
    @FXML
    private TableColumn<Doctor, String> colDFirstName;
    @FXML
    private TableColumn<Doctor, String> colDLastName;
    @FXML
    private TableColumn<Doctor, String> colGender;
    @FXML
    private TableColumn<Doctor, Integer> colDPhone;
    @FXML
    private TableColumn<Doctor, String> colSpecialization;
    @FXML
    private TableColumn<Doctor, String> colDepartment;
    @FXML
    private TableColumn<Doctor, String> colConsulationday;
    @FXML
    private TableColumn<Doctor, String> colConsulationTime;
    @FXML
    private TableView<Pharmacy> tblPharmacy;
    @FXML
    private TableColumn<Pharmacy, String> colMName;
    @FXML
    private TableColumn<Pharmacy, String> colMType;
    @FXML
    private TableColumn<Pharmacy, Integer> colSuppID;
    @FXML
    private TableColumn<Pharmacy, Integer> colStock;
    @FXML
    private TableColumn<Pharmacy, Integer> colPrice;
    @FXML
    private TableColumn<Pharmacy, String> colManufactureDate;
    @FXML
    private TableColumn<Pharmacy, String> colExpiryDate;
    @FXML
    private TableColumn<Pharmacy, Integer> colMID;
    @FXML
    private TableView<Ward> tblWard;
    @FXML
    private TableColumn<Ward, Integer> colPID;
    @FXML
    private TableColumn<Ward, Integer> colWardNo;
    @FXML
    private TableColumn<Ward, String> colWardType;
    @FXML
    private TableColumn<Ward, String> colwardDep;
    @FXML
    private TableView<Lab> tblLab;
    @FXML
    private TableColumn<Lab, Integer> colLabPatientID;
    @FXML
    private TableColumn<Lab, String> colPType;
    @FXML
    private TableColumn<Lab, String> colLabDate;
    @FXML
    private TableColumn<Lab, String> colCategory;
    @FXML
    private TableColumn<Lab, Integer> colAmount;
    @FXML
    private TableView<Bill> tblPayment;
    @FXML
    private TableColumn<Bill, Integer> colBillnum;
    @FXML
    private TableColumn<Bill, Integer> colBillPID;
    @FXML
    private TableColumn<Bill, Integer> colBillDID;
    @FXML
    private TableColumn<Bill, String> colBillPatientTyp;
    @FXML
    private TableColumn<Bill, Integer> colDoctorcharge;
    @FXML
    private TableColumn<Bill, Integer> colMedicineCharge;
    @FXML
    private TableColumn<Bill, Integer> colRoomCharge;
    @FXML
    private TableColumn<Bill, Integer> colLabCharge;
    @FXML
    private TableColumn<Bill, Integer> colTotalAmount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        patientRole.getItems().addAll("Patient", "Doctor", "Staff");
        cmbPaymentPatientType.getItems().addAll("Inpatient", "Outpatient");
        cmbDoctorConDay.getItems().addAll("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        colID.setCellValueFactory(new PropertyValueFactory(Patient.PATIENT_ID));
        colFirstName.setCellValueFactory(new PropertyValueFactory(Patient.FIRST_NAME));
        colLastName.setCellValueFactory(new PropertyValueFactory(Patient.LAST_NAME));
        colgender.setCellValueFactory(new PropertyValueFactory(Patient.GENDER));
        colDOB.setCellValueFactory(new PropertyValueFactory(Patient.DATE_OF_BIRTH));
        colAge.setCellValueFactory(new PropertyValueFactory(Patient.AGE));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory(Patient.PHONE_NUMBER));
        colNationality.setCellValueFactory(new PropertyValueFactory(Patient.NATIONALITY));
        colType.setCellValueFactory(new PropertyValueFactory(Patient.PATIENT_TYPE));
        colRole.setCellValueFactory(new PropertyValueFactory(Patient.PATIENT_ROLE));

        colDID.setCellValueFactory(new PropertyValueFactory(Doctor.DOCTOR_ID));
        colDFirstName.setCellValueFactory(new PropertyValueFactory(Doctor.FIRST_NAME));
        colDLastName.setCellValueFactory(new PropertyValueFactory(Doctor.LAST_NAME));
        colGender.setCellValueFactory(new PropertyValueFactory(Doctor.GENDER));
        colDPhone.setCellValueFactory(new PropertyValueFactory(Doctor.PHONE_NUMBER));
        colSpecialization.setCellValueFactory(new PropertyValueFactory(Doctor.SPECIALIZATION));
        colDepartment.setCellValueFactory(new PropertyValueFactory(Doctor.DEPARTMENT));
        colConsulationday.setCellValueFactory(new PropertyValueFactory(Doctor.CONSULATION_DAY));
        colConsulationTime.setCellValueFactory(new PropertyValueFactory(Doctor.CONSULATION_TIME));

        colMID.setCellValueFactory(new PropertyValueFactory(Pharmacy.MEDICINE_ID));
        colMName.setCellValueFactory(new PropertyValueFactory(Pharmacy.MEDICINE_NAME));
        colMType.setCellValueFactory(new PropertyValueFactory(Pharmacy.MEDICINE_TYPE));
        colSuppID.setCellValueFactory(new PropertyValueFactory(Pharmacy.SUPPLIER_ID));
        colStock.setCellValueFactory(new PropertyValueFactory(Pharmacy.STOCK));
        colPrice.setCellValueFactory(new PropertyValueFactory(Pharmacy.PRICE));
        colManufactureDate.setCellValueFactory(new PropertyValueFactory(Pharmacy.MANUFACTURE_DATE));
        colExpiryDate.setCellValueFactory(new PropertyValueFactory(Pharmacy.EXPIRY_DATE));

        colPID.setCellValueFactory(new PropertyValueFactory(Ward.PATIENT_ID));
        colWardNo.setCellValueFactory(new PropertyValueFactory(Ward.WARD_NUMBER));
        colWardType.setCellValueFactory(new PropertyValueFactory(Ward.WARD_TYPE));
        colwardDep.setCellValueFactory(new PropertyValueFactory(Ward.DEPARTMENT));

        colLabPatientID.setCellValueFactory(new PropertyValueFactory(Lab.PATIENT_ID));
        colPType.setCellValueFactory(new PropertyValueFactory(Lab.PATIENT_TYPE));
        colLabDate.setCellValueFactory(new PropertyValueFactory(Lab.DATE));
        colCategory.setCellValueFactory(new PropertyValueFactory(Lab.CATEGORY));
        colAmount.setCellValueFactory(new PropertyValueFactory(Lab.AMOUNT));
        
        colBillnum.setCellValueFactory(new PropertyValueFactory(Bill.BILL_NUMBER));
        colBillPID.setCellValueFactory(new PropertyValueFactory(Bill.PATIENT_ID));
        colBillDID.setCellValueFactory(new PropertyValueFactory(Bill.DOCTOR_ID));
        colBillPatientTyp.setCellValueFactory(new PropertyValueFactory(Bill.PATIENT_TYPE));
        colDoctorcharge.setCellValueFactory(new PropertyValueFactory(Bill.DOCTOR_CHARGE));
        colMedicineCharge.setCellValueFactory(new PropertyValueFactory(Bill.MEDICINE_CHARGE));
        colRoomCharge.setCellValueFactory(new PropertyValueFactory(Bill.ROOM_CHARGE));
        colLabCharge.setCellValueFactory(new PropertyValueFactory(Bill.LAB_CHARGE));
         colTotalAmount.setCellValueFactory(new PropertyValueFactory(Bill.TOTAL));


    }

    private void showAlert(String message) {
        new Alert(Alert.AlertType.INFORMATION, message).show();
    }

    @FXML
    private void handleButtonLogin(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if (username.equals("hospital") && password.equals("hospital")) {
            PatientTab.setDisable(false);
            DoctorTab.setDisable(false);
            PharmacyTab.setDisable(false);
            WardTab.setDisable(false);
            LabTab.setDisable(false);

            pane.getSelectionModel().select(PatientTab);

        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Password");
        }

    }

    @FXML
    private void handleButtonLogout(ActionEvent event) {
        PatientTab.setDisable(true);
        DoctorTab.setDisable(true);
        PharmacyTab.setDisable(true);
        WardTab.setDisable(true);
        LabTab.setDisable(true);
        BillTab.setDisable(true);
        MedTab.setDisable(true);

        pane.getSelectionModel().select(tabpane);

        txtUsername.setText("");
        txtPassword.setText("");
    }

    @FXML
    private void handleButtonProceedToBill(ActionEvent event) {
        BillTab.setDisable(false);
        pane.getSelectionModel().select(BillTab);
    }

    @FXML
    private void handleButtonPatientSearchID(ActionEvent event) {
        int PatientID = Integer.parseInt(txtSearchID.getText());

        if (txtSearchID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Patient ID must be 5 Numbers");
            return;
        }

        Patient result = PatientAccessor.findPatientByID(PatientID);

        txtID.setText(result.getPatientID() + "");
        txtFirstName.setText(result.getFirstName());
        txtLastName.setText(result.getLastName());
        txtPatientAge.setText(result.getPatientAge() + "");
        txtPatientPhone.setText(result.getPatientPhone() + "");
        txtPatientNationality.setText(result.getPatientNationality());
        txtdob.setText(result.getPatientDOB());
         tblPatient.setItems(FXCollections.observableArrayList(result));
        patientRole.setValue(result.getPatientRole());
        
        if (result.getPatientGender().equalsIgnoreCase("Male")){
            rbPatientMale.setSelected(true);
        }else{
            rbPatientFemale.setSelected(true);
        }
        
        if (result.getPatientType().equalsIgnoreCase("Inpatient")){
            rbInpatient.setSelected(true);
        }else{
            rbOutpatient.setSelected(true);
        }
    }

    @FXML
    private void handleButtonPatientCreate(ActionEvent event) {

        int PatientID = Integer.parseInt(txtID.getText());

        if (txtID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Patient ID must be 5 Numbers");
            return;
        }
        String pr = patientRole.getSelectionModel().getSelectedItem();
        String FirstName = txtFirstName.getText();
        String LastName = txtLastName.getText();
        String pg = "";
        if (rbPatientMale.isSelected()) {
            pg = rbPatientMale.getText();

        } else {
            pg = rbPatientFemale.getText();

        }
        int age = Integer.parseInt(txtPatientAge.getText());
        int phoneNumber = Integer.parseInt(txtPatientPhone.getText());
        String nationality = txtPatientNationality.getText();
        String dob = txtdob.getText();

        String patientType = "";
        if (rbInpatient.isSelected()) {
            patientType = rbInpatient.getText();
        } else {
            patientType = rbOutpatient.getText();
        }

        Patient item = new Patient(PatientID, pr, FirstName, LastName, patientType, pg, dob, phoneNumber, age, nationality);
        boolean result = PatientAccessor.addPatient(item);

        if (result) {
            showAlert("Patient Created");
        } else {
            showAlert("Patient cannot be created");
        }

        handleButtonPatientDisplay(null);

    }

    @FXML
    private void handleButtonPatientUpdate(ActionEvent event) {
        int PatientID = Integer.parseInt(txtID.getText());

        if (txtID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Patient ID must be 5 Numbers");
            return;
        }
        String pr = patientRole.getSelectionModel().getSelectedItem();
        String FirstName = txtFirstName.getText();
        String LastName = txtLastName.getText();
        String pg = "";
        if (rbPatientMale.isSelected()) {
            pg = rbPatientMale.getText();

        } else {
            pg = rbPatientFemale.getText();

        }
        int age = Integer.parseInt(txtPatientAge.getText());
        int phoneNumber = Integer.parseInt(txtPatientPhone.getText());
        String nationality = txtPatientNationality.getText();
        String dob = txtdob.getText();

        String patientType = "";
        if (rbInpatient.isSelected()) {
            patientType = rbInpatient.getText();
        } else {
            patientType = rbOutpatient.getText();
        }

        Patient item = new Patient(PatientID, pr, FirstName, LastName, patientType, pg, dob, phoneNumber, age, nationality);
        boolean result = PatientAccessor.updatePatient(item);

        if (result) {
            showAlert("Patient Updated");
        } else {
            showAlert("Patient cannot be Updated");
        }
        handleButtonPatientDisplay(null);

    }

    @FXML
    private void handleButtonPatientDelete(ActionEvent event) {

        int PatientID = Integer.parseInt(txtID.getText());
        Patient item = new Patient(PatientID, null, null, null, null, null, null, 1, 1, null);
        boolean result = PatientAccessor.deletePatient(item);

        if (result) {
            showAlert("Patient Deleted");
        } else {
            showAlert("Patient cannot be Deleted");
        }
        handleButtonPatientDisplay(null);

    }

    @FXML
    private void handleButtonPatientDisplay(ActionEvent event) {

        List<Patient> patients = PatientAccessor.findAllPatient();
        tblPatient.setItems(FXCollections.observableArrayList(patients));
    }

    @FXML
    private void handleButtonPatientCancel(ActionEvent event) {
        txtID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPatientAge.setText("");
        txtPatientPhone.setText("");
        txtPatientNationality.setText("");
        txtdob.setText("");
        patientRole.getItems().clear();
        txtSearchID.setText("");
        rbPatientFemale.setSelected(false);
        rbPatientMale.setSelected(false);
        rbInpatient.setSelected(false);
        rbOutpatient.setSelected(false);
        
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------DOCTOR----------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private void handleButtonDisplayDoctors(ActionEvent event) {

        List<Doctor> doctors = DoctorAccessor.findAllDoctor();
        tblDoctor.setItems(FXCollections.observableArrayList(doctors));

    }
//int PatientID = Integer.parseInt(txtID.getText());
//
//        if (txtID.getText().length() != 5) {
//            JOptionPane.showMessageDialog(null, "Patient ID must be 5 Numbers");
//            return;
//        }
//        String pr = patientRole.getSelectionModel().getSelectedItem();
//        String FirstName = txtFirstName.getText();
//        String LastName = txtLastName.getText();
//        String pg = "";
//        if (rbPatientMale.isSelected()) {
//            pg = rbPatientMale.getText();
//
//        } else {
//            pg = rbPatientFemale.getText();
//
//        }
//        int age = Integer.parseInt(txtPatientAge.getText());
//        int phoneNumber = Integer.parseInt(txtPatientPhone.getText());
//        String nationality = txtPatientNationality.getText();
//        String dob = txtdob.getText();
//
//        String patientType = "";
//        if (rbInpatient.isSelected()) {
//            patientType = rbInpatient.getText();
//        } else {
//            patientType = rbOutpatient.getText();
//        }
//
//        Patient item = new Patient(PatientID, pr, FirstName, LastName, patientType, pg, dob, phoneNumber, age, nationality);
//        boolean result = PatientAccessor.addPatient(item);
//
//        if (result) {
//            showAlert("Patient Created");
//        } else {
//            showAlert("Patient cannot be created");
//        }
//
//        handleButtonPatientDisplay(null);

    @FXML
    private void handleButtonDoctorrCreate(ActionEvent event) {
        int DoctorID = Integer.parseInt(txtDoctorID.getText());
        if (txtDoctorID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Doctor ID must be 5 Numbers");
            return;
        }
        String FirstName = txtDoctorFirstName.getText();
        String LastName = txtDoctorLastName.getText();
        String pg = "";
        if (pg.equals("Male")) {
            pg = "Male";
            rbDoctorMale.setSelected(true);
        } else if (pg.equals("Female")) {
            rbDoctorFemale.setSelected(true);
            pg = "Female";

        }
        int phoneNumber = Integer.parseInt(txtDoctorPhone.getText());
        String specialization = txtDoctorSpec.getText();
        String department = txtDoctorDep.getText();
        String consulationTime = txtDoctorConTime.getText();

        String consulationDay = cmbDoctorConDay.getSelectionModel().getSelectedItem();
        String dob = txtdob.getText();

        Doctor item = new Doctor(DoctorID, FirstName, LastName, pg, phoneNumber, specialization, department, consulationDay, consulationTime);
        boolean result = DoctorAccessor.addDoctor(item);
        if (result) {
            showAlert("Doctor Created");
        } else {
            showAlert("Doctor cannot be created");
        }
        handleButtonDisplayDoctors(null);

    }

    @FXML
    private void handleButtonDoctorDelete(ActionEvent event) {
        int DoctorID = Integer.parseInt(txtDoctorID.getText());
        Doctor item = new Doctor(DoctorID, null, null, null, 1, null, null, null, null);
        boolean result = DoctorAccessor.deleteDoctor(item);

        if (result) {
            showAlert("Doctor Deleted");
        } else {
            showAlert("Doctor cannot be Deleted");
        }
        handleButtonDisplayDoctors(null);
    }

    @FXML
    private void handleButtonDoctorCancel(ActionEvent event) {
        txtDoctorSearchID.setText("");
        txtDoctorID.setText("");
        txtDoctorFirstName.setText("");
        txtDoctorLastName.setText("");
        txtDoctorPhone.setText("");
        txtDoctorSpec.setText("");
        txtDoctorDep.setText("");
        txtDoctorConTime.setText("");
         rbDoctorFemale.setSelected(false);
        rbDoctorMale.setSelected(false);
        cmbDoctorConDay.getItems().clear();
        
        
    }

    @FXML
    private void handleButtonDoctorID(ActionEvent event) {

        int DoctorID = Integer.parseInt(txtDoctorSearchID.getText());
        if (txtDoctorSearchID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Doctor ID must be 5 Numbers");
            return;
        }

        Doctor result = DoctorAccessor.findDoctorByID(DoctorID);

        txtDoctorID.setText(result.getDoctorID()+ "");
        txtDoctorFirstName.setText(result.getFirstName());
        txtDoctorLastName.setText(result.getLastName());
        txtDoctorPhone.setText(result.getPhoneNo() + "");
        txtDoctorSpec.setText(result.getSpecialization());
        txtDoctorDep.setText(result.getDepartment());
        txtDoctorConTime.setText(result.getConsulationTime());
         cmbDoctorConDay.setValue(result.getConsulationDay());
         if (result.getGender().equalsIgnoreCase("Male")){
            rbDoctorMale.setSelected(true);
        }else{
            rbDoctorFemale.setSelected(true);
        }
          tblDoctor.setItems(FXCollections.observableArrayList(result));
    }

    @FXML
    private void handleButtonDoctorUpdate(ActionEvent event) {
        int DoctorID = Integer.parseInt(txtDoctorID.getText());
        if (txtDoctorID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Doctor ID must be 5 Numbers");
            return;
        }
        String FirstName = txtDoctorFirstName.getText();
        String LastName = txtDoctorLastName.getText();
        String pg = "";
        if (rbDoctorMale.isSelected()) {
            pg = rbDoctorMale.getText();

        } else {
            pg = rbDoctorFemale.getText();

        }
        int PhoneNo = Integer.parseInt(txtDoctorPhone.getText());
        String specialization = txtDoctorSpec.getText();
        String department = txtDoctorDep.getText();
        String consulationDay = cmbDoctorConDay.getSelectionModel().getSelectedItem();
        String consulationTime = txtDoctorConTime.getText();

        Doctor item = new Doctor(DoctorID, FirstName, LastName, pg, PhoneNo, specialization, department, consulationDay, consulationTime);
        boolean result = DoctorAccessor.updateDoctor(item);

        if (result) {
            showAlert("Doctor Updated");
        } else {
            showAlert("Doctor cannot be Updated");
        }
        handleButtonDisplayDoctors(null);
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------BILL--------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------------------------

    @FXML
    private void handleButtonPaymentCancel(ActionEvent event) {

        txtBillNo.setText("");
        txtPaymentPatientID.setText("");
        txtPaymentDocID.setText("");
        txtDocCharge.setText("");
        txtMedCharge.setText("");
        txtRoomCharge.setText("");
        txtLabCharge.setText("");
        txtTotal.setText("");
        txtBillPID.setText("");
        txtBillNo.setText("");
        cmbPaymentPatientType.getItems().clear();
        
        
    }

    @FXML
    private void handleButtonPaymentCreate(ActionEvent event) {

        int BillNo = Integer.parseInt(txtBillNo.getText());

        if (txtBillNo.getText().length() != 3) {
            JOptionPane.showMessageDialog(null, "Bill Number must be 3 Numbers");
            return;
        }

        int PatientID = Integer.parseInt(txtPaymentPatientID.getText());
        String PatientType = cmbPaymentPatientType.getSelectionModel().getSelectedItem();
        int DoctorID = Integer.parseInt(txtPaymentDocID.getText());
        int DocCharge = Integer.parseInt(txtDocCharge.getText());
        int MedCharge = Integer.parseInt(txtMedCharge.getText());
        int RoomCharge = Integer.parseInt(txtRoomCharge.getText());
        int LabCharge = Integer.parseInt(txtLabCharge.getText());
        int Total = Integer.parseInt(txtTotal.getText());

        Bill item = new Bill(BillNo, PatientID, DoctorID, PatientType, DocCharge, MedCharge, RoomCharge, LabCharge, Total);
        boolean result = BillAccessor.addBill(item);

        if (result) {
            showAlert("Bill Created");
        } else {
            showAlert("Bill cannot be created");
        }
        handleButtonBillDisplay(null);

    }

    @FXML
    private void handleButtonPaymentDelete(ActionEvent event) {

        int BillNumber = Integer.parseInt(txtBillNo.getText());
        Bill items = new Bill(BillNumber, 1, 1, null, 1, 1, 1, 1, 1);
        boolean result = BillAccessor.deleteBill(items);

        if (result) {
            showAlert("Bill Deleted");
        } else {
            showAlert("Bill cannot be Deleted");

            txtBillNo.setText("");
            txtPaymentPatientID.setText("");
            txtPaymentDocID.setText("");
            txtDocCharge.setText("");
            txtMedCharge.setText("");
            txtRoomCharge.setText("");
            txtLabCharge.setText("");
            txtTotal.setText("");
        }
        handleButtonBillDisplay(null);
    }

    @FXML
    private void handleButtonPaymentUpdate(ActionEvent event) {
        int BillNo = Integer.parseInt(txtBillNo.getText());
        if (txtBillNo.getText().length() != 3) {
            JOptionPane.showMessageDialog(null, "Bill Number must be 3 Numbers");
            return;
        }
        int PatientID = Integer.parseInt(txtPaymentPatientID.getText());
        String PatientType = cmbPaymentPatientType.getSelectionModel().getSelectedItem();
        int DocCharge = Integer.parseInt(txtDocCharge.getText());
        int MedCharge = Integer.parseInt(txtMedCharge.getText());
        int RoomCharge = Integer.parseInt(txtRoomCharge.getText());
        int LabCharge = Integer.parseInt(txtLabCharge.getText());
        int DoctorID = Integer.parseInt(txtPaymentDocID.getText());
        int Total = Integer.parseInt(txtTotal.getText());

        Bill item = new Bill(BillNo, PatientID, DoctorID, PatientType, DocCharge, MedCharge, RoomCharge, LabCharge, Total);
        boolean result = BillAccessor.updateBill(item);

        if (result) {
            showAlert("Bill Updated");
        } else {
            showAlert("Bill cannot be Updated");
        }
        handleButtonBillDisplay(null);
    }

    @FXML
    private void handleButtonBillDisplay(ActionEvent event) {
          List<Bill> bills = BillAccessor.findAllBill();
        tblPayment.setItems(FXCollections.observableArrayList(bills));

    }

    @FXML
    private void handleButtonPaymentSearch(ActionEvent event) { 
        int BillNumber = Integer.parseInt(txtBillNo.getText());

        if (txtBillNo.getText().length() != 3) {
            JOptionPane.showMessageDialog(null, "Bill number must be 3");
            return;
        }

       Bill result = BillAccessor.findBillByNo(BillNumber);

        txtPaymentPatientID.setText(result.getPatientID() + "");
        txtDocCharge.setText(result.getDoctorCharge()+"");
        txtMedCharge.setText(result.getMedicineCharge()+"");
        txtRoomCharge.setText(result.getRoomCharge()+"" );
        txtLabCharge.setText(result.getLabCharge() + "");
        txtPaymentDocID.setText(result.getDoctorID()+"");
        txtTotal.setText(result.getTotal()+"");
        
        if (result.getPatientType().equalsIgnoreCase("Inpatient")) {
            cmbPaymentPatientType.setValue("Inpatient");
        } else {
            cmbPaymentPatientType.setValue("Outpatient");
        }
        
        tblPayment.setItems(FXCollections.observableArrayList(result));


    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------MEDICINE-------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private void handleButtonMedSearchId(ActionEvent event) {
        
        int MedicineID = Integer.parseInt(txtMedSearchId.getText());
        if (txtMedSearchId.getText().length() != 3) {
            JOptionPane.showMessageDialog(null, "Medicine ID must be 3 Numbers");
            return;
        }

        Pharmacy result = PharmacyAccessor.findPharmacyByID(MedicineID);

        txtMedId.setText(result.getMedicineID()+"");
        txtMedName.setText(result.getMedicineName());
        txtMedType.setText(result.getMedicineType());
        txtMedSupplierId.setText(result.getSupplierID()+"");
        txtMedStock.setText(result.getStock()+"");
        txtMedPrice.setText(result.getPrice()+"");
        txtMedManuDate.setText(result.getManufactureDate());
    txtMedExpDate.setText(result.getExpiryDate());
    tblPharmacy.setItems(FXCollections.observableArrayList(result));
    }

    @FXML
    private void handleButtonMedUpdate(ActionEvent event) {
        int MedicineID = Integer.parseInt(txtMedId.getText());
        if (txtMedId.getText().length() != 3) {
            JOptionPane.showMessageDialog(null, "Medicine Number must be 3 Numbers");
            return;
        }
        String MedicineName = txtMedName.getText();
        String MedicineType = txtMedType.getText();
        int SupplierID = Integer.parseInt(txtMedSupplierId.getText());
        int Stock = Integer.parseInt(txtMedStock.getText());
        int Price = Integer.parseInt(txtMedPrice.getText());
        String ManuDate = txtMedManuDate.getText();
        String ExpDate = txtMedExpDate.getText();

        Pharmacy item = new Pharmacy(MedicineID, MedicineName, MedicineType, SupplierID, Stock, Price, ManuDate, ExpDate);
        boolean result = PharmacyAccessor.updatePharmacy(item);

        if (result) {
            showAlert("Medicine Updated");
        } else {
            showAlert("Medicine cannot be Updated");
        }
        handleButtonMedDisplay(null);
    }

    @FXML
    private void handleButtonMedDelete(ActionEvent event) {

        int MedicineID = Integer.parseInt(txtMedId.getText());
        Pharmacy items = new Pharmacy(MedicineID, null, null, 1, 1, 1, null, null);
        boolean result = PharmacyAccessor.deletePharmacy(items);

        if (result) {
            showAlert("Medicine Deleted");
        } else {
            showAlert("Medicine cannot be Deleted");

            txtMedId.setText("");
            txtMedName.setText("");
            txtMedType.setText("");
            txtMedSupplierId.setText("");
            txtMedStock.setText("");
            txtMedPrice.setText("");
            txtMedManuDate.setText("");
            txtMedExpDate.setText("");
        }
        handleButtonMedDisplay(null);
    }

    @FXML
    private void handleButtonMedCancel(ActionEvent event) {
        txtMedId.setText("");
        txtMedName.setText("");
        txtMedType.setText("");
        txtMedSupplierId.setText("");
        txtMedStock.setText("");
        txtMedPrice.setText("");
        txtMedManuDate.setText("");
        txtMedExpDate.setText("");
        txtMedArea.setText("");
    }

    @FXML
    private void handleButtonMedCreate(ActionEvent event) {
        int MedID = Integer.parseInt(txtMedId.getText());

        if (txtMedId.getText().length() != 3) {
            JOptionPane.showMessageDialog(null, "Medicine Number must be 3 Numbers");
            return;
        }

        String MedName = txtMedName.getText();
        String MedType = txtMedType.getText();
        int SupplierID = Integer.parseInt(txtMedSupplierId.getText());
        int Stock = Integer.parseInt(txtMedStock.getText());
        int Price = Integer.parseInt(txtMedPrice.getText());
        String ManuDate = txtMedManuDate.getText();
        String ExpDate = txtMedExpDate.getText();

        Pharmacy item = new Pharmacy(MedID, MedName, MedType, SupplierID, Stock, Price, ManuDate, ExpDate);
        boolean result = PharmacyAccessor.addPharmacy(item);

        if (result) {
            showAlert("Medicine Created");
        } else {
            showAlert("Medicine cannot be created");
        }
        handleButtonMedDisplay(null);
    }

    @FXML
    private void handleButtonMedDisplay(ActionEvent event) {
        List<Pharmacy> medicines = PharmacyAccessor.findAllPharmacy();
        tblPharmacy.setItems(FXCollections.observableArrayList(medicines));
    }

    @FXML
    private void handleButtonProceedToMed(ActionEvent event) {
        MedTab.setDisable(false);
        pane.getSelectionModel().select(MedTab);
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------WARD-----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private void handleButtonWardSearchID(ActionEvent event) {
         int PatientID = Integer.parseInt(txtWardSearchID.getText());
        if (txtWardSearchID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "invalid ID");
            return;
        }

      Ward result = WardAccessor.findWardByPID(PatientID);

        txtWardNo.setText(result.getWardNumber()+"");
        txtWardType.setText(result.getWardtype());
        txtWardDep.setText(result.getDepartment());
        tblWard.setItems(FXCollections.observableArrayList(result));
       
    }

    @FXML
    private void handleButtonAdd(ActionEvent event) {
        int PatientID = Integer.parseInt(txtWardSearchID.getText());
        if (txtWardSearchID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Ward Number must be 5 Numbers");
            return;
        }
        int WardNumber = Integer.parseInt(txtWardNo.getText());
        String Wardtype = txtWardType.getText();
        String Department = txtWardDep.getText();

        Ward item = new Ward(PatientID, WardNumber, Wardtype, Department);
        boolean result = WardAccessor.addWard(item);

        if (result) {
            showAlert("Ward Added");
        } else {
            showAlert("Ward cannot be Added");
        }
        handleButtonWardDisplay(null);
    }

    @FXML
    private void handleButtonWardDisplay(ActionEvent event) {
        List<Ward> wards = WardAccessor.findAllWard();
        tblWard.setItems(FXCollections.observableArrayList(wards));
    }

    @FXML
    private void handleButtonWardUpdate(ActionEvent event) {

        int PatientID = Integer.parseInt(txtWardSearchID.getText());
        if (txtWardSearchID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Ward Number must be 5 Numbers");
            return;
        }
        int WardNumber = Integer.parseInt(txtWardNo.getText());
        String Wardtype = txtWardType.getText();
        String Department = txtWardDep.getText();

        Ward item = new Ward(PatientID, WardNumber, Wardtype, Department);
        boolean result = WardAccessor.updateWard(item);

        if (result) {
            showAlert("Ward Updated");
        } else {
            showAlert("Ward cannot be Updated");
        }
        handleButtonWardDisplay(null);
    }

    @FXML
    private void handleButtonWardDelete(ActionEvent event) {
        int PatientID = Integer.parseInt(txtWardSearchID.getText());
        Ward items = new Ward(PatientID, 1, null, null);
        boolean result = WardAccessor.deleteWard(items);

        if (result) {
            showAlert("Ward Deleted");
        } else {
            showAlert("Ward cannot be Deleted");

            txtWardNo.setText("");
            txtWardType.setText("");
            txtWardDep.setText("");

        }
        handleButtonWardDisplay(null);
    }

    @FXML
    private void handleButtonWardCancel(ActionEvent event) {
        txtWardSearchID.setText("");
        txtWardNo.setText("");
        txtWardType.setText("");
        txtWardDep.setText("");
        txtWardArea.setText("");

    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------LAB------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private void handleButtonLabCreate(ActionEvent event) {
        int LabPatientID = Integer.parseInt(txtLabPatientID.getText());

        if (txtLabPatientID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Patient ID  must be 5 Numbers");
            return;
        }
        String radio = "";
        if (rbLabPT.isSelected()) {
            radio = rbLabPT.getText();

        } else {
            radio = rbLabOutpatient.getText();
        }
        String Date = txtLabDate.getText();
        String Category = txtLabCategory.getText();
        int amount = Integer.parseInt(txtLabAmount.getText());

        Lab item = new Lab(LabPatientID, radio, Date, Category, amount);
        boolean result = LabAccessor.addLab(item);

        if (result) {
            showAlert("Lab Added");
        } else {
            showAlert("Lab cannot be Added");
        }

        handleButtonLabDisplay(null);
    }

    @FXML
    private void handleButtonLabUpdate(ActionEvent event) {
        int LabPatientID = Integer.parseInt(txtLabPatientID.getText());

        if (txtLabPatientID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Patient ID  must be 5 Numbers");
            return;

        }
        String radio = "";
        if (rbLabPT.isSelected()) {
            radio = rbLabPT.getText();

        } else {
            radio = rbLabOutpatient.getText();
        }

        String Date = txtLabDate.getText();
        String Category = txtLabCategory.getText();
        int amount = Integer.parseInt(txtLabAmount.getText());

        Lab item = new Lab(LabPatientID, radio, Date, Category, amount);
        boolean result = LabAccessor.updateLab(item);

        if (result) {
            showAlert("Lab Updated");
        } else {
            showAlert("Lab cannot be Updated");
        }

        handleButtonLabDisplay(null);
    }

    @FXML
    private void handleButtonLabCancel(ActionEvent event) {
        txtLabPatientID.setText("");
        txtLabDate.setText("");
        txtLabCategory.setText("");
        txtLabAmount.setText("");
        rbLabPT.setSelected(false);
        rbLabOutpatient.setSelected(false);
       
    }

    @FXML
    private void handleButtonLabSearchID(ActionEvent event) {
 int PatientID = Integer.parseInt(txtLabPatientID.getText());
        if (txtLabPatientID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "invalid ID");
            return;
        }

      Lab result = LabAccessor.findLabByPID(PatientID);

        txtLabDate.setText(result.getDate()+"");
        txtLabCategory.setText(result.getCategory());
        txtLabAmount.setText(result.getAmount()+"");
        tblLab.setItems(FXCollections.observableArrayList(result));
        if (result.getPatientType().equalsIgnoreCase("Inpatient")){
            rbLabPT.setSelected(true);
        }else{
            rbLabOutpatient.setSelected(true);
        }
        
    }

    @FXML
    private void handleButtonLabDisplay(ActionEvent event) {
        List<Lab> labs = LabAccessor.findAllLab();
        tblLab.setItems(FXCollections.observableArrayList(labs));

    }

    
    @FXML
    private void handleButtonPSEarchID(ActionEvent event) {
          int PatientID = Integer.parseInt(txtBillPID.getText());

        if (txtBillPID.getText().length() != 5) {
            JOptionPane.showMessageDialog(null, "Patient ID number must be 5");
            return;
        }

//       Bill result = BillAccessor.findBillByNo(PatientID);

       Bill result = BillAccessor.findBillByPatientID(PatientID);
       
       
        txtPaymentPatientID.setText(result.getPatientID() + "");
        txtDocCharge.setText(result.getDoctorCharge()+"");
        txtMedCharge.setText(result.getMedicineCharge()+"");
        txtRoomCharge.setText(result.getRoomCharge()+"" );
        txtLabCharge.setText(result.getLabCharge() + "");
        txtPaymentDocID.setText(result.getDoctorID()+"");
        txtTotal.setText(result.getTotal()+"");
        if (result.getPatientType().equalsIgnoreCase("Inpatient")) {
            cmbPaymentPatientType.setValue("Inpatient");
        } else {
            cmbPaymentPatientType.setValue("Outpatient");
        }
        tblPayment.setItems(FXCollections.observableArrayList(result));


    }

    @FXML
    private void handleButtonDoctorID(MouseEvent event) {
       Doctor doc = tblDoctor.getSelectionModel().getSelectedItem();
//       
       txtDoctorID.setText(doc.getDoctorID()+ "");
        txtDoctorFirstName.setText(doc.getFirstName());
        txtDoctorLastName.setText(doc.getLastName());
        txtDoctorPhone.setText(doc.getPhoneNo() + "");
        txtDoctorSpec.setText(doc.getSpecialization());
        txtDoctorDep.setText(doc.getDepartment());
        txtDoctorConTime.setText(doc.getConsulationTime());
        cmbDoctorConDay.setValue(doc.getConsulationDay());
//        System.out.println(doc.getGender()+"||||||||||||||||||||||||||||||||||||||||||||");
        if (doc.getGender().equalsIgnoreCase("Male")){
            rbDoctorMale.setSelected(true);
        }
            else{
            rbDoctorFemale.setSelected(true);
        }
          tblDoctor.setItems(FXCollections.observableArrayList(doc));
    }

    @FXML
    private void handleButtonPatientSearchID(MouseEvent event) {
        Patient patient =tblPatient.getSelectionModel().getSelectedItem();
        
        txtID.setText(patient.getPatientID()+"");
        txtFirstName.setText(patient.getFirstName());
        txtLastName.setText(patient.getLastName());
        txtPatientAge.setText(patient.getPatientAge()+"");
        txtPatientPhone.setText(patient.getPatientPhone()+"");
        txtPatientNationality.setText(patient.getPatientNationality());
        txtdob.setText(patient.getPatientDOB());
        patientRole.setValue(patient.getPatientRole());
        
        if (patient.getPatientGender().equalsIgnoreCase("Male")){
            rbPatientMale.setSelected(true);
        }else{
            rbPatientFemale.setSelected(true);
        }
         if (patient.getPatientType().equalsIgnoreCase("Inpatient")){
            rbInpatient.setSelected(true);
        }else{
            rbOutpatient.setSelected(true);
        }
        tblPatient.setItems(FXCollections.observableArrayList(patient));
    }
    

}
