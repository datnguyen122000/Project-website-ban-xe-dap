/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author DELL
 */
public class BuyerAccount {
    private String fullName,address,email,phone,gender,dob;

    public BuyerAccount() {
    }

    public BuyerAccount(String fullName, String address, String email, String phone, String gender, String dob) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "BuyerAccount{" + "fullName=" + fullName + ", address=" + address + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", dob=" + dob + '}';
    }
    
}
