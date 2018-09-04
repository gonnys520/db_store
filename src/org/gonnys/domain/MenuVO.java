package org.gonnys.domain;

import java.util.Date;

public class MenuVO {
    private int mno, smo;
    private String mname;
    private  int price;

    @Override
    public String toString() {
        return "MenuVO{" +
                "mno=" + mno +
                ", smo=" + smo +
                ", mname='" + mname + '\'' +
                ", price=" + price +
                ", regdate=" + regdate +
                '}';
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getSmo() {
        return smo;
    }

    public void setSmo(int smo) {
        this.smo = smo;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    private Date regdate;

}
