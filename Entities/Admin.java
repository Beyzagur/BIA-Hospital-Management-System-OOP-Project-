package Entities;

public class Admin extends Person {
    public Admin(String name, String surname, String id, String phone, String address, Boolean gender, String bloodType, String password, String email) {
        super(name, surname, id, phone, address, gender, bloodType, password, email);
    }

    public String toString(){
        return String.format("%s %s %s %s %s %s %s %s %s", getName(), getSurname(), getId(),
                getPhone(), getAddress(), getGender() ? "F" : "M", getBloodType(), getPassword(), getEmail());
    }

}
