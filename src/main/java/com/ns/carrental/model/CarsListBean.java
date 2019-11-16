package com.ns.carrental.model;

import javax.persistence.*;

@Entity
@Table(name = "carslist")
public class CarsListBean {
    @Id
    private String numberplate;
    private String availability;
    private String carname;
    private Boolean bookstatus;
    private int price;
    private byte[] image;
    private long phonenumber;
    private String username;

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public Boolean getBookstatus() {
        return bookstatus;
    }

    public void setBookstatus(Boolean bookstatus) {
        this.bookstatus = bookstatus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
