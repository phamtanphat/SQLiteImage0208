package com.ptp.phamtanphat.sqliteimage0208;

/**
 * Created by KhoaPhamPC on 20/9/2017.
 */

public class Thucung {
    private int Id;
    private String Ten;
    private byte[] hinhanh;

    public Thucung(int id, String ten, byte[] hinhanh) {
        Id = id;
        Ten = ten;
        this.hinhanh = hinhanh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }
}
