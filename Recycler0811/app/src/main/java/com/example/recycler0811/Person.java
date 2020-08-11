package com.example.recycler0811;

public class Person {
    private int face;
    private String name;
    private String tel;
    private String email;
    private int addr_img;
    private String addr;

    public Person(int face, String name, String tel, String email, int addr_img, String addr) {
        this.face = face;
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.addr_img = addr_img;
        this.addr = addr;
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddr_img() {
        return addr_img;
    }

    public void setAddr_img(int addr_img) {
        this.addr_img = addr_img;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
