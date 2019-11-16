package com.ns.carrental.model;

import javax.persistence.*;

@Entity
@Table(name = "bookedcars")
public class BookedCarsList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String numberplate;
    private byte[] image;
    private String carname;
    private long phonenumber;
    private String username;
    private String bookeddate;
    private String bookedtime;
    private Boolean bookstatus;

    public Boolean getBookstatus() {
        return bookstatus;
    }

    public void setBookstatus(Boolean bookstatus) {
        this.bookstatus = bookstatus;
    }

    public String getBookeddate() {
        return bookeddate;
    }

    public void setBookeddate(String bookeddate) {
        this.bookeddate = bookeddate;
    }

    public String getBookedtime() {
        return bookedtime;
    }

    public void setBookedtime(String bookedtime) {
        this.bookedtime = bookedtime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

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
}
