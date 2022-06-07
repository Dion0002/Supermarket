package sm.supermarket;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class DashboardController implements Initializable {

    DBConnection conn = new DBConnection();
    Connection conDB = conn.getConnection();
    PreparedStatement pst;
    ResultSet rs;
    @FXML
    private PieChart PieChart;
    @FXML
    private AreaChart<?, ?> areaChart;
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

    public void nrEmpl() {
        try {
            String sql = "Select count(ID) from employees";
            pst = conDB.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String employees = rs.getString("count(ID)");
                lbl_Employees.setText(employees);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    public void nrCustomer() {
        try {
            String sql = "Select count(ID) from customers";
            pst = conDB.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String customer = rs.getString("count(ID)");
                lbl_customer.setText(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    public void loadPieChart() throws SQLException, ClassCastException {
        ObservableList<PieChart.Data> pieChartData = observableArrayList(
                new PieChart.Data("January", 13),
                new PieChart.Data("February", 25),
                new PieChart.Data("March", 10),
                new PieChart.Data("April", 43),
                new PieChart.Data("April", 25),
                new PieChart.Data("May", 22),
                new PieChart.Data("June", 12),
                new PieChart.Data("July", 82),
                new PieChart.Data("August", 22),
                new PieChart.Data("September", 32),
                new PieChart.Data("October", 24),
                new PieChart.Data("November", 22),
                new PieChart.Data("December", 22));
        PieChart.setData(pieChartData);

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("1", 23));
        series.getData().add(new XYChart.Data("2", 65));
        series.getData().add(new XYChart.Data("3", 68));
        series.getData().add(new XYChart.Data("4", 32));
        series.getData().add(new XYChart.Data("5", 56));
        series.getData().add(new XYChart.Data("6", 76));
        series.getData().add(new XYChart.Data("7", 44));
        areaChart.getData().add(series);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nrEmpl();
        nrCustomer();
        try {
            loadPieChart();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
