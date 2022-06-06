package sm.supermarket;

import javafx.beans.property.SimpleStringProperty;

public class Employee {
    private final SimpleStringProperty ID;
    private final SimpleStringProperty firstname;
    private final SimpleStringProperty lastname;
    private final SimpleStringProperty birthday;
    private final SimpleStringProperty gender;
    private final SimpleStringProperty address;
    private final SimpleStringProperty phonenumber;
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleStringProperty role;
    private final SimpleStringProperty salary;


    public Employee(String id, String fname, String lname, String Dob, String gender, String address, String phoneNr, String username, String password, String role, String salary) {
        this.ID = new SimpleStringProperty(id);
        this.firstname = new SimpleStringProperty(fname);
        this.lastname = new SimpleStringProperty(lname);
        this.birthday = new SimpleStringProperty(Dob);
        this.gender = new SimpleStringProperty(gender);
        this.address = new SimpleStringProperty(address);
        this.phonenumber = new SimpleStringProperty(phoneNr);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleStringProperty(role);
        this.salary = new SimpleStringProperty(salary);


    }


    public String getID() {
        return ID.get();
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public String getBirthday() {
        return birthday.get();
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber.get();
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber.set(phonenumber);
    }

    public SimpleStringProperty phonenumberProperty() {
        return phonenumber;
    }

    public String getUsername(String uname) {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public String getRole() {
        return role.get();
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

    public String getSalary() {
        return salary.get();
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

    public SimpleStringProperty salaryProperty() {
        return salary;
    }
}
