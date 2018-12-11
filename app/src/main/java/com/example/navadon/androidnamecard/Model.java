package com.example.navadon.androidnamecard;

import android.arch.lifecycle.ViewModel;

public class Model extends ViewModel {
    private String fname;
    private String lname;
    private String position;
    private String email;
    private String phone;
    private int ui;
    private String color1;
    private String color2;
    public static Model model = null;
    public static int[] drawable1 = new int[]{ R.drawable.card1ui1, R.drawable.card1ui2, R.drawable.card1ui3, R.drawable.card1ui4, R.drawable.card1ui5 };
    public static int[] drawable2 = new int[]{ R.drawable.card2ui1, R.drawable.card2ui2, R.drawable.card2ui3, R.drawable.card2ui4, R.drawable.card2ui5 };

    public Model(String fname, String lname, String position, String email, String phone, String ui, String color1, String color2) {
        this.fname = fname;
        this.lname = lname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.ui = Integer.parseInt(ui);
        this.color1 = color1;
        this.color2 = color2;
        Model.model = this;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public int getUi() {
        return ui;
    }
}
