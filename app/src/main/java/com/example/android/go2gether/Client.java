package com.example.android.go2gether;

class Client {
    public String name,email,country,phonenumber,gender,password;

    //con
    public Client(String name, String email, String country, String phonenumber, String gender, String password) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.password = password;
    }


    //get
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    //set

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
