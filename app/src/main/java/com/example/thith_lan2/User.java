package com.example.thith_lan2;

public class User {
    private String id;
    private String firstname;
    private String lastname;
    private String gioitinh;

    public User(String id, String firstname, String lastname, String gioitinh) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gioitinh = gioitinh;
    }

    public User(String firstname, String lastname, String gioitinh) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gioitinh = gioitinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
}
