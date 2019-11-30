/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Tien Nguyen
 */
public class BENHNHAN {
     public String getMABN() {
        return MABN;
    }

    public void setMABN(String MABN) {
        this.MABN = MABN;
    }
      public String getTENBN() {
        return TENBN;
    }

    public void setTENBN(String TENBN) {
        this.TENBN = TENBN;
    }
     public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }
      public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }
      public int getTUOI() {
        return TUOI;
    }

    public void setTUOI(int TUOI) {
        this.TUOI = TUOI;
    }
      public Date getNGAYDIEUTRI() {
        return NGAYDIEUTRI;
    }

    public void setNGAYDIEUTRI(Date NGAYDIEUTRI) {
        this.NGAYDIEUTRI = NGAYDIEUTRI;
    }
    
      public String getLOAIBN() {
        return LOAIBN;
    }

    public void setLOAIBN(String LOAIBN) {
        this.LOAIBN = LOAIBN;
    }
    
      public String getCANNANG() {
        return CANNANG;
    }

    public void setCANNANG(String CANNANG) {
        this.CANNANG = CANNANG;
    }

    public List<THUOC> getDanhSachThuoc() {
        return DanhSachThuoc;
    }

    public void setDanhSachThuoc(List<THUOC> DanhSachThuoc) {
        this.DanhSachThuoc = DanhSachThuoc;
    }
    
    
    
    
    
    public String MABN;
    public String TENBN;
    public String DIACHI;
    public String GIOITINH;
    public int TUOI;
    public Date NGAYDIEUTRI; 
 
    public String LOAIBN;
    public String CANNANG;
    public List<THUOC> DanhSachThuoc;
 
}
