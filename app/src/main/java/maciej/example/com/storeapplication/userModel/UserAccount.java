package maciej.example.com.storeapplication.userModel;

import android.text.TextUtils;

import java.io.Serializable;


public class UserAccount implements Serializable {

    private String firstName;

    private String lastName;

    private String birthDate;

    private Gender gender;

    private String address;

    private String country;

    private String email;

    private String phoneNumber;

    private String password;

    private String confirmPassword;

    private boolean newsletter;


    public boolean isValid() {
        return !TextUtils.isEmpty(firstName)
                && !TextUtils.isEmpty(lastName)
                && !TextUtils.isEmpty(birthDate)
                && !TextUtils.isEmpty(address)
                && !TextUtils.isEmpty(country)
                && !TextUtils.isEmpty(email)
                && !TextUtils.isEmpty(phoneNumber)
                && !TextUtils.isEmpty(password);
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public boolean isNewsletter() {
        return newsletter;
    }
}
