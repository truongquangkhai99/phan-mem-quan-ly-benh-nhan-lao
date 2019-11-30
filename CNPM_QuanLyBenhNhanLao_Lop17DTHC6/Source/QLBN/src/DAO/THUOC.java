/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author ltduo
 */
public class THUOC {
    public String MALOAITHUOC;
    public int SOLUONG;
    public String MABN;

    public THUOC(String MALOAITHUOC, int SOLUONG) {
        this.MALOAITHUOC = MALOAITHUOC;
        this.SOLUONG = SOLUONG;
    }

    public THUOC(String MALOAITHUOC, int SOLUONG, String MABN) {
        this.MALOAITHUOC = MALOAITHUOC;
        this.SOLUONG = SOLUONG;
        this.MABN = MABN;
    }

    public THUOC() {
    }
    
    
    

    public String getMALOAITHUOC() {
        return MALOAITHUOC;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setMALOAITHUOC(String MALOAITHUOC) {
        this.MALOAITHUOC = MALOAITHUOC;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getMABN() {
        return MABN;
    }

    public void setMABN(String MABN) {
        this.MABN = MABN;
    }
    
}
