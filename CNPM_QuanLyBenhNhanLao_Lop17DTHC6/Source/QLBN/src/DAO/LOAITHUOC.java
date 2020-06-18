
package DAO;

public class LOAITHUOC {
    public int MaLoai;
    public String MoTaChiTiet;
    public String TenLoai;

    public LOAITHUOC(int MaLoai, String MoTaChiTiet, String TenLoai) {
        this.MaLoai = MaLoai;
        this.MoTaChiTiet = MoTaChiTiet;
        this.TenLoai = TenLoai;
    }
          
    public String GetMoTaChiTiet() {
        return MoTaChiTiet;
    }
    
    public String GetTenLoai() {
        return TenLoai;
    }

    public void SetMoTaChiTiet(String MoTaChiTiet) {
        this.MoTaChiTiet = MoTaChiTiet;
    }

     public void SetTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }  
}
