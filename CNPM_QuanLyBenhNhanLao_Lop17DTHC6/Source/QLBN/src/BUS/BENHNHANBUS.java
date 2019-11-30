/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import Connection.Sqlconnect;
import DAO.BENHNHAN;
import DAO.THUOC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tien Nguyen
 */
public class BENHNHANBUS {
    public static Connection conn;
    public static ResultSet rs;
    public static  Sqlconnect sqlcn;
    
    public List<BENHNHAN> Laydanhsachbenhnhan() throws ClassNotFoundException 
    {
        // Tạo đối tượng của lớp kết nối
        sqlcn = new Sqlconnect();    
        try {
              // Tạo kết nối databases bằng cách gọi phương thức getSQLServerConnection
              conn = sqlcn.getSQLServerConnection();
              System.out.print("ket noi thanh cong ");
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");   
        }
        List<BENHNHAN> list=new ArrayList();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT bn.MABN,bn.TENBN,bn.TUOI,bn.DIACHI,bn.GIOITINH,bn.LOAIBN,bn.SOKY,bn.NGAYDIEUTRI" +
            " FROM BENHNHAN bn";      

            rs = statement.executeQuery(sql);
            System.out.print("truy van thanh cong ");   
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
        // System.out.print("\n Danh sach ");
        try {
            while(rs.next())
            {
                BENHNHAN benhnhan = new BENHNHAN();
                benhnhan.setMABN(rs.getString("MABN"));
                benhnhan.setTENBN(rs.getString("TENBN"));
                benhnhan.setTUOI(rs.getInt("TUOI"));
                benhnhan.setDIACHI(rs.getString("DIACHI"));
                benhnhan.setGIOITINH(rs.getString("GIOITINH"));
                benhnhan.setLOAIBN(rs.getString("LOAIBN"));
                benhnhan.setNGAYDIEUTRI(rs.getDate("NGAYDIEUTRI"));
                benhnhan.setCANNANG(rs.getString("SOKY"));
               list.add(benhnhan);   
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");      
        }
        for (BENHNHAN b:list)
        {
            Statement statement;
            try {
                statement = conn.createStatement();
                String sql = "SELECT sd.MALOAI, sd.MABN, sd.SLVIEN, sd.NGAYDT" +
                " FROM SUDUNGTHUOC sd"
                        + " WHERE MABN = '" + b.getMABN() + "'";      

                rs = statement.executeQuery(sql);
                List<THUOC> tmp = new ArrayList<THUOC>();
                while(rs.next())
                {
                    THUOC t = new THUOC(rs.getString("MALOAI"), rs.getInt("SLVIEN"), rs.getString("MABN"));
                    tmp.add(t);   
                }
                b.setDanhSachThuoc(tmp);  
            System.out.print("truy van thanh cong ");
            } catch (SQLException ex) {
                Logger.getLogger(BENHNHANBUS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }  
    // Tim Kiem Benh Nhan
    public List<BENHNHAN> Timkiembenhnhan(String keywork) throws ClassNotFoundException 
    {
        System.out.println(keywork);
         sqlcn = new Sqlconnect();
         List<BENHNHAN> list=new ArrayList();
//        try {
//              a = sqlcn.getSQLServerConnection();
//        } catch (SQLException ex){
//             System.out.print("Lỗi ! khong the ket noi den SQLserver ");  
//        }
//        try {
//            Statement statement = a.createStatement();
//            String sql = "SELECT bn.MABN,bn.TENBN,bn.DIACHI,bn.GIOITINH,bn.LOAIBN_ID,lbn.TenLoaiBenhNhan AS TENLOAIBENHNHAN,bn.SOKY_ID,\n" +
//            "cn.CanNang as CANNANG,bn.SOLUONG,BN.TUOI,BN.NGAYDIEUTRI,BN.LOAITHUOC\n" +
//            " FROM BENHNHAN bn\n" +
//            "INNER JOIN DanhMuc_CanNang cn ON bn.SOKY_ID = cn.Id\n" +
//            "INNER JOIN DanhMuc_LoaiBenhNhan lbn ON bn.LOAIBN_ID = lbn.Id";           
//
//            rs = statement.executeQuery(sql);
//            //System.out.print("truy van thanh cong ");   
//        } catch (SQLException ex) {
//           System.out.print("Lỗi rồi ");
//        }
//        // System.out.print("\n Danh sach ");
//        try {
//            while(rs.next())
//            {
//                BENHNHAN benhnhan = new BENHNHAN();
//                benhnhan.setMABN(rs.getString("MABN"));
//                benhnhan.setTENBN(rs.getString("TENBN"));
//                benhnhan.setDIACHI(rs.getString("DIACHI"));
//                benhnhan.setGIOITINH(rs.getString("GIOITINH"));
//                benhnhan.setLOAIBN_ID(rs.getInt("LOAIBN_ID"));
//                benhnhan.setSOKY_ID(rs.getInt("SOKY_ID"));
//                benhnhan.setSOLUONG(rs.getInt("SOLUONG"));
//                benhnhan.setTUOI(rs.getInt("TUOI"));
//                benhnhan.setLOAITHUOC(rs.getString("LOAITHUOC"));
//                benhnhan.setTENLOAIBENHNHAN(rs.getString("TENLOAIBENHNHAN"));
//                benhnhan.setCANNANG(rs.getString("CANNANG"));
//               list.add(benhnhan);   
//            }
//        } catch (SQLException ex) {
//            System.out.print("loi khong the khoi tao ");      
//        }
        return list;
    }  
     
    public void thembenhnhan(BENHNHAN benhnhan, int flag) throws ClassNotFoundException, SQLException 
    {
        // Tạo đối tượng của lớp kết nối
        sqlcn = new Sqlconnect();   
        try {
                // Tạo kết nối databases bằng cách gọi phương thức getSQLServerConnection
              conn = sqlcn.getSQLServerConnection();
              System.out.print("ket noi thanh cong ");
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");   
        }
        String mabn = benhnhan.getMABN();
        if (flag == 1)
            mabn = PhatSinhMa();
            
//            int mabn_asc = Integer.parseInt(mabn);
//            mabn_asc ++;
//            System.out.println(mabn_asc);
        // Insert thông tin bệnh nhân xuống database'
        String sql = "INSERT INTO BENHNHAN(MABN,TENBN,TUOI,DIACHI,GIOITINH,LOAIBN,SOKY,NGAYDIEUTRI) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
          
            pstmt.setString(1,mabn);
            pstmt.setString(2, benhnhan.getTENBN());
            pstmt.setInt(3, benhnhan.getTUOI());
            pstmt.setString(4, benhnhan.getDIACHI());
            pstmt.setString(5, benhnhan.getGIOITINH());
            pstmt.setString(6, benhnhan.getLOAIBN());
            pstmt.setString(7, benhnhan.getCANNANG());
            java.util.Date myDate = new java.util.Date("10/10/2009");
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            pstmt.setDate(8, sqlDate);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BENHNHANBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Insert list thuoc
        // https://viralpatel.net/blogs/batch-insert-in-java-jdbc/
        sql = "insert into SUDUNGTHUOC (MALOAI, MABN, SLVIEN, NGAYDT) values (?, ?, ?, ?)";
        PreparedStatement ps;
        try {
            List<THUOC> DanhSachThuoc = benhnhan.getDanhSachThuoc();
            ps = conn.prepareStatement(sql);
             for (THUOC thuoc: DanhSachThuoc) {
                 System.out.println(thuoc.getMALOAITHUOC());
                 System.out.println(thuoc.getSOLUONG());
                 System.out.println("\n\n");
                ps.setString(1, thuoc.getMALOAITHUOC());
                ps.setString(2, mabn);
                ps.setInt(3, thuoc.getSOLUONG());
                java.util.Date myDate = new java.util.Date("10/10/2009");
                java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
                ps.setDate(4, sqlDate);
                ps.addBatch();
            }
            ps.executeBatch();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BENHNHANBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();       
    }
    
 public void xoabenhnhan(BENHNHAN benhnhan) throws ClassNotFoundException, SQLException 
    {
        // Tạo đối tượng của lớp kết nối
        sqlcn = new Sqlconnect();   
        try {
                // Tạo kết nối databases bằng cách gọi phương thức getSQLServerConnection
              conn = sqlcn.getSQLServerConnection();
              System.out.print("ket noi thanh cong ");
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");   
        }
        String sql1 = "DELETE FROM BENHNHAN WHERE MABN = '" + benhnhan.getMABN() + "'";
        String sql2 = "DELETE FROM SUDUNGTHUOC WHERE MABN = '" + benhnhan.getMABN() + "'";
        try {
            Statement pstmt = conn.createStatement();
            pstmt.executeUpdate(sql1);
            pstmt.executeUpdate(sql2);
        } catch (SQLException ex) {
            Logger.getLogger(BENHNHANBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();       
    }  

 public void updatebenhnhan(BENHNHAN benhnhan) throws ClassNotFoundException, SQLException 
    {
        xoabenhnhan(benhnhan);
        thembenhnhan(benhnhan, 0);
    }  
     public String PhatSinhMa() throws SQLException, ClassNotFoundException
   {
        sqlcn=new Sqlconnect();
         //Statement statement = a.createStatement();
        //ResultSet rs1=statement.executeQuery("select top 1 MaRap from RAP where MaRap = " + );
      
      
      String ma = "";
     
        try {
              conn =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("Kết nối thất bại");
             
        }
        
            Statement statement = conn.createStatement();
            rs=statement.executeQuery(" SELECT TOP 1 * FROM BENHNHAN ORDER BY MABN DESC");
            while(rs.next())
            {
              ma = rs.getString("MABN");
            }
            
            if(ma == "")
            {
                    ma = "BN" +  1;
                    return ma;
            }
                 
            
            //String[] split = ma.split("/");
            String ma_int = ma.substring(2).replace(" ", "");
           // String  m = split[1].toString().trim();
           
            int n = Integer.parseInt(ma_int);
            if(n < 9)
            {
                n = n + 1;
                ma = "BN" +  n;
                
            }
            else
            {
                 n = n + 1;
                ma = "BN" +  n;
            }
          //  System.out.println(ma + "NN");
         return  ma;
   } 
   
}
