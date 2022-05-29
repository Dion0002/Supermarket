package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private PieChart PieChart;

    @FXML
    private JFXButton btn_Employee;

    @FXML
    private JFXButton btn_customer;

    @FXML
    private JFXButton btn_orders;

    @FXML
    private JFXButton btn_sales;

    @FXML
    private ImageView img_customer;

    @FXML
    private ImageView img_emp;

    @FXML
    private ImageView img_orders;

    @FXML
    private ImageView img_sales;

    @FXML
    private Label lbl_Employees;

    @FXML
    private Label lbl_customer;

    @FXML
    private Label lbl_dashboard;

    @FXML
    private Label lbl_lblsales;

    @FXML
    private Label lbl_orders;


    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void nrEmpl(){
        try{
            String sql = "Select count(ID) from employees";
            pst=conDB.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                String customer = rs.getString("count(ID)");
                lbl_Employees.setText(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    nrEmpl();
    }
}
