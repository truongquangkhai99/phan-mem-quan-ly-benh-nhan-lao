package qlbn;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Connection.SqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Tien Nguyen
 */
public class Them extends javax.swing.JFrame {

    Statement statement;
    Connection conn;
    ResultSet resultSet;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Them() {
        initComponents();
        try {
            SqlConnection sqlConn = new SqlConnection();
            conn = sqlConn.getSQLServerConnection();
            try {
                statement = conn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "SELECT * FROM LOAIBENHNHAN";
            ResultSet resultSet;
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                this.cbxLoaiBN.addItem(resultSet.getString(2));
            }
            String sqlLoaiThuoc = "SELECT * FROM LOAITHUOC";
            resultSet = statement.executeQuery(sqlLoaiThuoc);
            while (resultSet.next()) {
                this.cbxLoaiThuoc.addItem(resultSet.getString("TENLOAI"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.dtpNgayDT.setFormats("dd/MM/yyyy");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGioiTinh = new javax.swing.ButtonGroup();
        btnGroupLoaiBenhNhan = new javax.swing.ButtonGroup();
        btnGroupSoKy = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        rbtNam = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rbtNu = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtThoiGianDT = new javax.swing.JTextField();
        lbNgayDieuTri = new javax.swing.JLabel();
        cbxLoaiThuoc = new javax.swing.JComboBox<>();
        txtAge = new javax.swing.JTextField();
        cbxLoaiBN = new javax.swing.JComboBox<>();
        txtCanNang = new javax.swing.JTextField();
        dtpNgayDT = new org.jdesktop.swingx.JXDatePicker();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nhập Bệnh Nhân");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setForeground(java.awt.Color.pink);
        setSize(new java.awt.Dimension(14, 20));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Loại bệnh nhân");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 222, -1, 33));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cân nặng (Kg)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 222, -1, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Loại thuốc (Viên)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, 48));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/sign-add-icon.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 599, 93, -1));

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/cancel.png"))); // NOI18N
        btnExit.setText("Huỷ");
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 599, 79, -1));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 46, 544, 28));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tên bệnh nhân");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 44, 112, 31));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Địa chỉ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 99, 112, -1));

        txtLocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 93, 544, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText(" Giới tính");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 159, 87, 33));

        btnGroupGioiTinh.add(rbtNam);
        rbtNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtNam.setSelected(true);
        rbtNam.setText("Nam");
        rbtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNamActionPerformed(evt);
            }
        });
        getContentPane().add(rbtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 163, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Thời Gian Điều Trị (Tháng) ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, -1, 30));

        btnGroupGioiTinh.add(rbtNu);
        rbtNu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtNu.setText("Nữ");
        rbtNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNuActionPerformed(evt);
            }
        });
        getContentPane().add(rbtNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 163, 58, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Tuổi");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 159, 50, 33));

        txtThoiGianDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThoiGianDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtThoiGianDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianDTActionPerformed(evt);
            }
        });
        getContentPane().add(txtThoiGianDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 167, 30));

        lbNgayDieuTri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgayDieuTri.setText("Ngày Điều Trị");
        getContentPane().add(lbNgayDieuTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        cbxLoaiThuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxLoaiThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiThuocActionPerformed(evt);
            }
        });
        getContentPane().add(cbxLoaiThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 180, 33));

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        getContentPane().add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 167, 28));

        cbxLoaiBN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxLoaiBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiBNActionPerformed(evt);
            }
        });
        getContentPane().add(cbxLoaiBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 222, 180, 33));

        txtCanNang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCanNang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCanNang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCanNangActionPerformed(evt);
            }
        });
        getContentPane().add(txtCanNang, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 167, 28));
        getContentPane().add(dtpNgayDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 180, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/gdthem.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void InsertSuDungThuoc(int MaBN, int SLVRHZ, int SLVE, int SLVRH, String ngayBDTC, String ngayKTTC, String ngayBDCC, String ngayKTCC) {
        //lấy ra mã loại thuốc RHZ cho bệnh nhân Mới
        try {
            String sqlRHZ = "select MALOAI from LOAITHUOC where LOAITHUOC.TENLOAI = 'RHZ'";
            resultSet = statement.executeQuery(sqlRHZ);
            int maRHZ = 0;
            while (resultSet.next()) {
                maRHZ = resultSet.getInt(1);
            }

            //lấy ra mã loại thuốc E cho bệnh nhân Mớiselect MALOAI from LOAITHUOC where LOAITHUOC.TENLOAI = 'RHZ'
            String sqlE = "select MALOAI from LOAITHUOC where LOAITHUOC.TENLOAI = 'E'";
            resultSet = statement.executeQuery(sqlE);
            int maE = 0;
            while (resultSet.next()) {
                maE = resultSet.getInt(1);
            }

            //lấy ra mã loại thuốc RH cho bệnh nhân Mới
            String sqlRH = "select MALOAI from LOAITHUOC where LOAITHUOC.TENLOAI = 'RH'";
            resultSet = statement.executeQuery(sqlRH);
            int maRH = 0;
            while (resultSet.next()) {
                maRH = resultSet.getInt(1);
            }

            String insertSDT1 = "INSERT INTO SUDUNGTHUOC (MALOAI,MABN,SoLuongVien,NgayBDTC,NgayKTTC,NgayBDCC,NgayKTCC)\n"
                    + "VALUES ('" + maRHZ + "', '" + MaBN + "', '" + SLVRHZ + "', '" + ngayBDTC +"', '" + ngayKTTC + "', null, null)";
            int row1 = statement.executeUpdate(insertSDT1);
            if (row1 > 0) {
                System.out.println("insert mã thuốc RHZ thành công");
            } else {
                System.out.println("insert mã thuốc RHZ thất bại");
            }

            String insertSDT2 = "INSERT INTO SUDUNGTHUOC (MALOAI,MABN,SoLuongVien,NgayBDTC,NgayKTTC,NgayBDCC,NgayKTCC)\n"
                    + "VALUES ('" + maE + "', '" + MaBN + "', '" + SLVE + "', '" + ngayBDTC + "', '" + ngayKTTC + "','" + ngayBDCC + "','" + ngayKTCC + "')";
            int row2 = statement.executeUpdate(insertSDT2);
            if (row2 > 0) {
                System.out.println("insert mã thuốc E thành công");
            } else {
                System.out.println("insert mã thuốc E thất bại");
            }
            
            String insertSDT3 = "INSERT INTO SUDUNGTHUOC (MALOAI,MABN,SoLuongVien,NgayBDTC,NgayKTTC,NgayBDCC,NgayKTCC)\n"
                    + "VALUES ('" + maRH + "', '" + MaBN + "', '" + SLVRH + "', null, null,'" + ngayBDCC + "','" + ngayKTCC + "')";          
            int row3 = statement.executeUpdate(insertSDT3);
            if (row3 > 0) {
                System.out.println("insert mã thuốc RH thành công");
            } else {
                System.out.println("insert mã thuốc RH thất bại");
            }
            
            //thêm thành công thì dẫn đến màn hình Quản Lý Thông Tin Bệnh Nhân
            TimXoaSua txs = new TimXoaSua();
            txs.setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //thêm tháng dùng Calendar truyền vào date + số tháng trả về date
    public Date addMonth(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();
    }
    
    //thêm ngày dùng Calendar truyền vào date + số ngày trả về date
    public static Date addDay(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, i);
        return cal.getTime();
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            //Lấy Thông tin bệnh nhân từ giao diện nhập vào
            String ten = txtName.getText();
            Boolean gioiTinh = true;
            if (rbtNu.isSelected()) {
                gioiTinh = false;
            }
            int tuoi = Integer.parseInt(txtAge.getText());
            String diaChi = txtLocation.getText();
            int loaiBN = cbxLoaiBN.getSelectedIndex();
            int canNang = Integer.parseInt(txtCanNang.getText());
            Date ngayDT = dtpNgayDT.getDate();
            int thoiGianTC = 0, thoiGianCC = 0;

            if (cbxLoaiBN.getSelectedIndex() == 0) {
                thoiGianTC = 2;
                thoiGianCC = 4;
                txtThoiGianDT.setText("6");
            } else {
                if (cbxLoaiBN.getSelectedIndex() == 1) {
                    thoiGianTC = 3;
                    thoiGianCC = 5;
                    txtThoiGianDT.setText("8");
                }
            }
            int thoiGianDT = Integer.parseInt(txtThoiGianDT.getText());
            loaiBN++;
            String ngayBDTC = formatter.format(ngayDT);
            //viết câu insert xuống db
            String sqlInsertBN = "INSERT INTO BENHNHAN (TENBN,TUOI,DIACHI,GIOITINH,MALOAIBN,CANNANG,NGAYBDDT,THOIGIANDT,THOIGIANTC,THOIGIANCC)\n"
                    + "VALUES (N'" + ten + "', '" + tuoi + "', N'" + diaChi + "', '" + gioiTinh + "', '" + loaiBN + "','" + canNang + "','" + ngayBDTC + "','" + thoiGianDT + "','" + thoiGianTC + "', '" + thoiGianCC + "')";

            //excuteUpdate trả về số dòng thực hiện đc
            int rowBN = statement.executeUpdate(sqlInsertBN);
            if (rowBN > 0) {
                JOptionPane.showMessageDialog(null, "Thêm bệnh nhân thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không thể thêm bệnh nhân!");
            }

            //lấy ra mã bn vừa insert vào để insert vào bảng sử dụng thuốc
            String sqlLayMaBN = "select MAX(MaBN) from BENHNHAN";
            ResultSet resultSet = statement.executeQuery(sqlLayMaBN);
            int layMaBN = 0;
            while (resultSet.next()) {
                layMaBN = resultSet.getInt(1);
            }

            //mỗi bệnh nhân có 1 danh sách thuốc sdung
            if (loaiBN == 1) {
                Date ngayKTTC = addMonth(ngayDT, 2);
                Date ngayBDCC = addDay(ngayKTTC, 1);
                Date ngayKTCC = addMonth(ngayBDCC, 2);
                if (canNang < 39) {
                    InsertSuDungThuoc(layMaBN, 2, 2, 2, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                }
                if (canNang >= 40 && canNang < 55) {
                    InsertSuDungThuoc(layMaBN, 3, 2, 3, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                }
                if (canNang >= 55 && canNang < 70) {
                    InsertSuDungThuoc(layMaBN, 4, 3, 4, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                }
                if (canNang >= 70) {
                    InsertSuDungThuoc(layMaBN, 5, 4, 5, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                }
            } else {
                if (loaiBN == 2) {
                    Date ngayKTTC = addMonth(ngayDT, 3);
                    Date ngayBDCC = addDay(ngayKTTC, 1);
                    Date ngayKTCC = addMonth(ngayBDCC, 5);
                    if (canNang < 39) {
                        InsertSuDungThuoc(layMaBN, 2, 2, 2, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                    }
                    if (canNang >= 40 && canNang < 55) {
                        InsertSuDungThuoc(layMaBN, 3, 2, 3, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                    }
                    if (canNang >= 55 && canNang < 70) {
                        InsertSuDungThuoc(layMaBN, 4, 3, 4, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                    }
                    if (canNang >= 70) {
                        InsertSuDungThuoc(layMaBN, 5, 4, 5, ngayBDTC, formatter.format(ngayKTTC), formatter.format(ngayBDCC), formatter.format(ngayKTCC));
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void rbtNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtNuActionPerformed

    private void rbtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtNamActionPerformed

    private void txtThoiGianDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiGianDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiGianDTActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
//        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void cbxLoaiThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLoaiThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLoaiThuocActionPerformed

    private void txtCanNangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCanNangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCanNangActionPerformed

    private void cbxLoaiBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLoaiBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLoaiBNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Them().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private javax.swing.ButtonGroup btnGroupLoaiBenhNhan;
    private javax.swing.ButtonGroup btnGroupSoKy;
    private javax.swing.JComboBox<String> cbxLoaiBN;
    private javax.swing.JComboBox<String> cbxLoaiThuoc;
    private org.jdesktop.swingx.JXDatePicker dtpNgayDT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbNgayDieuTri;
    private javax.swing.JRadioButton rbtNam;
    private javax.swing.JRadioButton rbtNu;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCanNang;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtThoiGianDT;
    // End of variables declaration//GEN-END:variables
}
