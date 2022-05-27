package sm.supermarket;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * This class handel all function and other things that will be needed for the user login
 */
public class LoginController  {

    @FXML
    private JFXButton btn_cancel;

    @FXML
    private JFXButton btn_forgot;

    @FXML
    private JFXButton btn_login;

    @FXML
    private JFXButton btn_signUp;

    @FXML
    private ImageView img_logo;

    @FXML
    private ImageView img_pass;

    @FXML
    private ImageView img_user;

    @FXML
    private Label lb_Fast;

    @FXML
    private Label lbl_invalid;

    @FXML
    private Label lbl_market;

    @FXML
    private Label lbl_or;

    @FXML
    private Label lbl_signin;

    @FXML
    private PasswordField pf_password;

    @FXML
    private TextField tf_username;


    private UserRole role=null;


    /**
     * This is for the cancel button to close the program
     * @param event
     */
    public void cancelButton(ActionEvent event) {
        Stage stage = (Stage)  btn_cancel.getScene().getWindow();
        stage.close();
    }
    //Create a list for the user
    List<UserRole> ListLogin = new ArrayList<UserRole>();


    /**
     * This is for the login button to open specific page for the users
     * If user enter his/her credentials that depending on those this function determine what page to open
     * And check for user validation if username or password are incorrect.
     * @param event
     */
    public void  loginButtonOnAction(ActionEvent event){

       if((tf_username.getText().isBlank()==true && pf_password.getText().isBlank()==true)||
               (tf_username.getText().isBlank()==true || pf_password.getText().isBlank()==true) ){

           lbl_invalid.setText("Please enter username and password");


       }else if(auth()==true){
       }
       else{
           lbl_invalid.setText("Incorrect username or password");

       }

    }

    /**
     * User Authentication
     * Open specific page for the users
     * If user enter his/her credentials that depending on those this function determine what page to open
     * @return
     */
    public boolean  auth(){
        try{
            ListLogin = validateLogin(tf_username.getText(), pf_password.getText());

            if(ListLogin.get(0).getRole().equalsIgnoreCase("admin")){
                AdminLog();
            }else if(ListLogin.get(0).getRole().equalsIgnoreCase("cashier")){
                CashLog();
            }
            else  {
                CusLog();
            }
            Stage stage = (Stage)  btn_login.getScene().getWindow();
            stage.close();
        }catch(Exception e){

        }
       return false;
    }


    /**
     * This is for getting the information from the database table and checking if the user input
     * is the same with that of the database
     * @param username
     * @param password
     * @return
     */
    public List validateLogin(String username, String password){
        DBConnection conn = new DBConnection();
        Connection conDB = conn.getConnection();
        List logLogin = new ArrayList();




        //Enter the query for retrieving the info
        String verifyLogin = "select Username, Password, Role from userlogin where Username ='"+tf_username.getText()+
                "' and Password ='" + pf_password.getText() + "'";


         try{
             Statement statement = conDB.createStatement();
             ResultSet queryResult = statement.executeQuery(verifyLogin);

             while(queryResult.next()){
                 UserRole ur = new UserRole();

                     ur.setUsername(queryResult.getString("username"));
                     ur.setPassword(queryResult.getString("password"));
                     ur.setRole(queryResult.getString("role"));
                     logLogin.add(ur);
             }

         }catch (Exception e){
             e.printStackTrace();
             e.getCause();
         }
         return logLogin;
    }






    /**
     * SingUp button that call the singup method
     * @param event
     */
    public void SignUpButton(ActionEvent event){
        SignUP();
    }

    /**
     * Open SignUp page
     */
    public void SignUP(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            Stage SignUPstage = new Stage();
            SignUPstage.initStyle(StageStyle.UNDECORATED);
            SignUPstage.setScene(new Scene(root));
            SignUPstage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        Stage stage = (Stage) btn_signUp.getScene().getWindow();
        stage.close();
    }

    /**
     * Open Admin Page
     */
    public void AdminLog(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("AdminSideBar.fxml"));
            Stage Loggedstage = new Stage();
            Loggedstage.initStyle(StageStyle.UNDECORATED);
            Loggedstage.setScene(new Scene(root));
            Loggedstage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Open Customer Page
     */
    public  void CusLog(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("CustomerPage.fxml"));
            Stage Loggedstage = new Stage();
            Loggedstage.initStyle(StageStyle.UNDECORATED);
            Loggedstage.setScene(new Scene(root));
            Loggedstage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

    /**
     * Open Cashier Page
     */
    public  void CashLog(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("CashierPage.fxml"));
            Stage Loggedstage = new Stage();
            Loggedstage.initStyle(StageStyle.UNDECORATED);
            Loggedstage.setScene(new Scene(root));
            Loggedstage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }

}
