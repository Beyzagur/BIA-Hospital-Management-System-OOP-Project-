package Entities;

public abstract class Person {
    private final String name;
    private final String surname;
    private final String id;
    private  String phone;
    private  String address;
    private final Boolean gender;
    private final String bloodType;
    private String password;
    private String email;

    public Person(String name, String surname, String id, String phone, String address, Boolean gender, String bloodType, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.bloodType = bloodType;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
