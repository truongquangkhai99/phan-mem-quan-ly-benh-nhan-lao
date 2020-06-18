//DAO tương đương Model là từng bảng dưới db
package DAO;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Tien Nguyen
 */
public class BENHNHAN {        
    private String TenBN;
    private String DiaChi;
    private Boolean GioiTinh;
    private int Tuoi;
    private int LoaiBN;
    private int CanNang;
    private int ThoiGianTC;
    private int ThoiGianCC;

    public void setTenBN(String TenBN) {
        this.TenBN = TenBN;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public void setLoaiBN(int LoaiBN) {
        this.LoaiBN = LoaiBN;
    }

    public void setCanNang(int CanNang) {
        this.CanNang = CanNang;
    }

    public void setNgayBDDT(Date NgayBDDT) {
        this.NgayBDDT = NgayBDDT;
    }

    public void setThoiGianDT(int ThoiGianDT) {
        this.ThoiGianDT = ThoiGianDT;
    }

    public void setThoiGianTC(int ThoiGianTC) {
        this.ThoiGianTC = ThoiGianTC;
    }

    public void setThoiGianCC(int ThoiGianCC) {
        this.ThoiGianCC = ThoiGianCC;
    }
    private Date NgayBDDT;
    private int ThoiGianDT;

    public String getTenBN() {
        return TenBN;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public int getLoaiBN() {
        return LoaiBN;
    }

    public int getCanNang() {
        return CanNang;
    }

    public Date getNgayBDDT() {
        return NgayBDDT;
    }

    public int getThoiGianDT() {
        return ThoiGianDT;
    }

    public int getThoiGianTC() {
        return ThoiGianTC;
    }

    public int getThoiGianCC() {
        return ThoiGianCC;
    }
}
