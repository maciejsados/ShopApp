package maciej.example.com.storeapplication.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "users")
public class Users {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String userName;

    @DatabaseField
    private String userLastName;

    @DatabaseField
    private String birthDate;

    @DatabaseField
    private String gender;

    @DatabaseField
    private String address;

    @DatabaseField
    private String country;

    @DatabaseField
    private String phoneNumber;

    @DatabaseField
    private String email;

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id +
                ", " + userName +
                ", " + userLastName +
                ", " + birthDate +
                ", " + gender +
                ", " + address +
                ", " + country +
                ", " + phoneNumber +
                ", " + email;
    }
}
