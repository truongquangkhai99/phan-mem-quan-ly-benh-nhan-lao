/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbn;

import Connection.SqlConnection;
import Connection.XuatExcel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import qlbn.ChiTietBenhNhan;

/**
 *
 * @author Tien Nguyen
 */
public class TimXoaSua extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDienChinh
     */
    SqlConnection conn;
    
    private DefaultTableModel tableModel = new DefaultTableModel();
    //private TimXoaSua tsx = new TimXoaSua();
    private final String[] colsName = {"STT", "Tên bệnh nhân", "Loại bệnh nhân", "Ngày bắt đầu điều trị", "Thuốc sử dụng(số viên)", "Tổng số viên đã dùng"};
    Statement st;
    
    public ResultSet BenhNhan() throws SQLException, ClassNotFoundException {
        String sqlBenhNhan = "SELECT B.MABN AS [STT], TENBN AS[TÊN BỆNH NHÂN], L.TENLOAI AS [LOẠI BỆNH NHÂN], NGAYBDDT AS [NGÀY BÁT ĐẦU ĐIỀU TRỊ], SUM(SOLUONGVIEN) AS [TỔNG THUỐC]\n"
                + "FROM BENHNHAN B, LOAIBENHNHAN L, SUDUNGTHUOC S, LOAITHUOC LTH\n"
                + "WHERE L.MALOAIBN = B.MALOAIBN AND B.MABN = S.MABN AND S.MALOAI = LTH.MALOAI\n"
                + "GROUP BY B.MABN, TENBN, L.TENLOAI, NGAYBDDT";
        //String sqlThuoc = "SELECT SUM(SOLUONGVIEN) FROM SUDUNGTHUOC S, BENHNHAN B WHERE S.MABN = B.MABN GROUP BY TENBN";
        return conn.TruyVan(sqlBenhNhan);
    }
    
    public ResultSet LoaiThuoc() throws ClassNotFoundException, SQLException {
        String sqlLoaiThuoc = "SELECT TENLOAITHUOC = STUFF(\n"
                + "(SELECT ', ' + TENLOAI + '(' + CONVERT(NVARCHAR,SOLUONGVIEN) + ')'\n"
                + "FROM SUDUNGTHUOC t1, LOAITHUOC L\n"
                + "WHERE t1.MABN = t2.MABN AND L.MALOAI = t1.MALOAI\n"
                + "FOR XML PATH (''))\n"
                + ", 1, 1, '') from SUDUNGTHUOC t2\n"
                + "group by MABN";
        return conn.TruyVan(sqlLoaiThuoc);
    }
    
    public void ShowData() throws SQLException, ClassNotFoundException {
        ResultSet resultBN = BenhNhan();
        ResultSet resultThuoc = LoaiThuoc();
        String rows[] = new String[6];
        try {
            while (resultBN.next() && resultThuoc.next()) {
                rows[0] = resultBN.getString(1);
                rows[1] = resultBN.getString(2);
                rows[2] = resultBN.getString(3);
                rows[3] = resultBN.getString(4);
                rows[4] = resultThuoc.getString(1);
                rows[5] = resultBN.getString(5);
                tableModel.addRow(rows);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Sai");
        }
    }
    
    public ResultSet ShowTheoMa(String ma) {
        String sql = "SELECT B.MABN, TENBN, TUOI, GIOITINH, TENLOAI, DIACHI, CANNANG, NGAYBDDT, THOIGIANDT, THOIGIANCC, THOIGIANTC, SUM (SOLUONGVIEN) AS [TỔNG VIÊN]\n"
                + "FROM BENHNHAN B, SUDUNGTHUOC S, LOAIBENHNHAN LBN\n"
                + "WHERE B.MABN = S.MABN AND B.MALOAIBN = LBN.MALOAIBN AND B.MABN= '" + ma + "'\n"
                + "GROUP BY  B.MABN ,TENBN, TUOI, GIOITINH, TENLOAI, DIACHI, CANNANG, NGAYBDDT, THOIGIANDT, THOIGIANCC, THOIGIANTC\n"
                + "ORDER BY B.MABN";
        return conn.TruyVan(sql);
    }

//    public void Edit(int ma, String ten, int tuoi, String loaibn, String dc, int skdt, int tgdt, int tgcc, int tgtc) {
//        String sql = "UPDATE BENHNHAN"
//                + "SET TENBN=N'" + ten + "', "
//                + "TUOI = '" + tuoi + "', "
//                + "TENLOAI = '" + loaibn +"', "
//                + "DIACHI = '" + dc + "',"
//                + "SOKY = '" + skdt +"',"
//                + "THOIGIANDT = '" + tgdt + "',"
//                + "THOIGIANCC = '" + tgcc + "',"
//                + "THOIGIANTC = '" + tgtc + "'"
//                + "WHERE MABN = '" + ma + "'";
//        conn.Update(sql);
//    }
    public TimXoaSua() throws SQLException, ClassNotFoundException {
        initComponents();
        conn = new SqlConnection();
        conn.getSQLServerConnection();
        tableModel.setColumnIdentifiers(colsName);
        btnChiTiet.setEnabled(false);
        tableBenhNhan.setModel(tableModel);
        ShowData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPhanMem = new javax.swing.JLabel();
        btnChiTiet = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBenhNhan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PHẦN MỀM QUẢN LÝ BỆNH NHÂN LAO");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPhanMem.setBackground(new java.awt.Color(0, 204, 204));
        txtPhanMem.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtPhanMem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPhanMem.setText("THÔNG TIN SỬ DỤNG THUỐC");
        getContentPane().add(txtPhanMem, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 13, 634, 43));

        btnChiTiet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChiTiet.setText("Xem chi tiết");
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        getContentPane().add(btnChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, 40));
        btnChiTiet.getAccessibleContext().setAccessibleName("Thêm");

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        getContentPane().add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 278, 30));

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/search.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setBorder(null);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 110, 30));

        btnXuatExcel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/excel.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setBorder(null);
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });
        getContentPane().add(btnXuatExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 140, 109, 30));

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/sign-add-icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        getContentPane().add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, 40));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/iconBack.png"))); // NOI18N
        btnBack.setText("Trở Về");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 40));

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/cancel.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setMaximumSize(new java.awt.Dimension(129, 39));
        btnHuy.setMinimumSize(new java.awt.Dimension(129, 39));
        btnHuy.setPreferredSize(new java.awt.Dimension(129, 39));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        getContentPane().add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 140, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/gdtimkiem.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 180));

        tableBenhNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tableBenhNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBenhNhanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableBenhNhan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 196, 1230, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void TimKiem() {
        DefaultTableModel model = (DefaultTableModel) tableBenhNhan.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        tableBenhNhan.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText().trim()));
    }

//Tìm kiếm tên bệnh nhân
    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemKeyReleased

    //Xem chi tiết khi nhấn vào hàng chứa bệnh nhân
    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        ThongTinChiTiet();
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        ManHinhChinh main = new ManHinhChinh();
        this.setVisible(false);
        main.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        //TODO add your handling code here:
        TimKiem();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        Them them = new Them();
        this.setVisible(false);
        them.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void tableBenhNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBenhNhanMouseClicked
        // TODO add your handling code here:
        btnChiTiet.setEnabled(true);
    }//GEN-LAST:event_tableBenhNhanMouseClicked

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // TODO add your handling code here:
        
        XuatExcel xuat = new XuatExcel();
        xuat.exportExcel(tableBenhNhan);
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        txtTimKiem.setText("");
        TimKiem();
    }//GEN-LAST:event_btnHuyActionPerformed
    
    public void ThongTinChiTiet() {
        ChiTietBenhNhan ct = new ChiTietBenhNhan();
        try {
            int row = tableBenhNhan.getSelectedRow();
            String ma = (tableBenhNhan.getModel().getValueAt(row, 0)).toString();
            ResultSet result = ShowTheoMa(ma);
            if (result.next()) {
                this.setVisible(false);
                ct.setVisible(true);
                ct.txtMaBN.setText(result.getString("MABN"));
                ct.txtTenBN.setText(result.getString("TENBN"));
                ct.txtTuoi.setText(result.getString("TUOI"));
                ct.txtDiaChi.setText(result.getString("DIACHI"));
                ct.txtGioiTinh.setText(result.getString("GIOITINH"));
                ct.txtLoaiBN.setText(result.getString("TENLOAI"));
                ct.txtSoKiDT.setText(result.getString("CANNANG"));
                //ct.dtpNgayBDDT.setFormats(result.getString("NGAYBDDT"));
                ct.txtThoiGianDT.setText(result.getString("THOIGIANDT"));
                ct.txtThoiGianCC.setText(result.getString("THOIGIANCC"));
                ct.txtThoiGianTC.setText(result.getString("THOIGIANTC"));
                //ct.txtTenBN.setText(result.getString("TenBN"));
                ct.txtDiaChi.setText(result.getString("DiaChi"));
            }
        } catch (SQLException ex) {
            
        }
    }

    /**/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        TimXoaSua frm = new TimXoaSua();
        frm.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBenhNhan;
    private javax.swing.JLabel txtPhanMem;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void Edit(String ten, String tuoi, String loai, String dc, int skdt, int tgdt, int tgcc, int tgtc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
