package qlbn;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Connection.SqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Tien Nguyen
 */
public class Them extends javax.swing.JFrame {

    Statement statement;
    Connection conn;
    ResultSet resultSet;
    PreparedStatement ps = null;
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
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                this.cbxLoaiBN.addItem(resultSet.getString(2));
            }
            String sqlLoaiThuoc = "SELECT * FROM LOAITHUOC";
            resultSet = statement.executeQuery(sqlLoaiThuoc);
            while (resultSet.next()) {
                this.cbxLoaiThuoc.addItem(resultSet.getString("TENLOAI"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        this.dtpNgayDT.setFormats("dd/MM/yyyy");
        this.cbxLoaiThuoc.setEnabled(false);
        this.btnThemLoaiThuoc.setEnabled(false);
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
        btnThemBN = new javax.swing.JButton();
        btnThemLoaiThuoc = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 33));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cân nặng (Kg)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Loại thuốc (Viên)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, 48));

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
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 112, 31));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Địa chỉ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 112, -1));

        txtLocation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLocation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 93, 544, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText(" Giới tính");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 87, 33));

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
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, 30));

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
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 50, 33));

        txtThoiGianDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtThoiGianDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtThoiGianDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiGianDTActionPerformed(evt);
            }
        });
        getContentPane().add(txtThoiGianDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, 167, 30));

        lbNgayDieuTri.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNgayDieuTri.setText("Ngày Điều Trị");
        getContentPane().add(lbNgayDieuTri, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        cbxLoaiThuoc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxLoaiThuoc.setEnabled(false);
        cbxLoaiThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLoaiThuocActionPerformed(evt);
            }
        });
        getContentPane().add(cbxLoaiThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 180, 33));

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
        getContentPane().add(dtpNgayDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 180, 30));

        btnThemBN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/sign-add-icon.png"))); // NOI18N
        btnThemBN.setText("Thêm Loại B.Nhân");
        btnThemBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBNActionPerformed(evt);
            }
        });
        getContentPane().add(btnThemBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 180, 30));

        btnThemLoaiThuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/sign-add-icon.png"))); // NOI18N
        btnThemLoaiThuoc.setText("Thêm Loại Thuốc");
        btnThemLoaiThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiThuocActionPerformed(evt);
            }
        });
        getContentPane().add(btnThemLoaiThuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 180, 30));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/iconBack.png"))); // NOI18N
        btnBack.setText("Trở Về");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/gdthem.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //hàm dùng để insert thuốc bn sử dụng, bn mới & tái phát dùng giống nhau 3 loại thuốc, khác thời gian điều trị
    //tùy theo cân nặng khác nhau số lượng viên sẽ khác nhau
    public void InsertSuDungThuoc(int MaBN, int SLVRHZ, int SLVE, int SLVRH, java.sql.Date ngayBDTC, java.sql.Date ngayKTTC, java.sql.Date ngayBDCC, java.sql.Date ngayKTCC) {
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

            ps = conn.prepareStatement("insert into SUDUNGTHUOC values(?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, maRHZ);
            ps.setInt(2, MaBN);
            ps.setInt(3, SLVRHZ);
            ps.setDate(4, ngayBDTC);
            ps.setDate(5, ngayKTTC);
            ps.setDate(6, null);
            ps.setDate(7, null);

            int row1 = ps.executeUpdate();
            if (row1 > 0) {
                System.out.println("insert mã thuốc RHZ thành công");
            } else {
                System.out.println("insert mã thuốc RHZ thất bại");
            }

            ps = conn.prepareStatement("insert into SUDUNGTHUOC values(?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, maE);
            ps.setInt(2, MaBN);
            ps.setInt(3, SLVRHZ);
            ps.setDate(4, ngayBDTC);
            ps.setDate(5, ngayKTTC);
            ps.setDate(6, ngayBDCC);
            ps.setDate(7, ngayKTCC);

            int row2 = ps.executeUpdate();
            if (row2 > 0) {
                System.out.println("insert mã thuốc E thành công");
            } else {
                System.out.println("insert mã thuốc E thất bại");
            }

            ps = conn.prepareStatement("insert into SUDUNGTHUOC values(?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, maRH);
            ps.setInt(2, MaBN);
            ps.setInt(3, SLVRHZ);
            ps.setDate(4, null);
            ps.setDate(5, null);
            ps.setDate(6, ngayBDCC);
            ps.setDate(7, ngayKTCC);

            int row3 = ps.executeUpdate();
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
    public java.util.Date addMonth(java.util.Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        return cal.getTime();
    }

    //thêm ngày dùng Calendar truyền vào date + số ngày trả về date
    public static java.util.Date addDay(java.util.Date date, int i) {
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
            java.util.Date ngayDT = dtpNgayDT.getDate();
            //chuyển sang sql.Date mới insert vô db đc vì db là kiểu Date
            java.sql.Date ngayBDTC = new java.sql.Date(ngayDT.getTime());
            int thoiGianTC = 0, thoiGianCC = 0;

            if (cbxLoaiBN.getSelectedIndex() == 0) {
                thoiGianTC = 2;
                thoiGianCC = 4;
            } else {
                if (cbxLoaiBN.getSelectedIndex() == 1) {
                    thoiGianTC = 3;
                    thoiGianCC = 5;
                }
            }
            int thoiGianDT = Integer.parseInt(txtThoiGianDT.getText());
            //do loại bn lấy từ combobox mà cbx đếm từ 0 nên phải +1
            loaiBN++;

            //viết câu insert xuống db
            ps = conn.prepareStatement("insert into BENHNHAN values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, ten);
            ps.setInt(2, tuoi);
            ps.setString(3, diaChi);
            ps.setBoolean(4, gioiTinh);
            ps.setInt(5, loaiBN);
            ps.setInt(6, canNang);
            ps.setDate(7, ngayBDTC);
            ps.setInt(8, thoiGianDT);
            ps.setInt(9, thoiGianTC);
            ps.setInt(10, thoiGianCC);

            //excuteUpdate trả về số dòng thực hiện đc
            int rowBN = ps.executeUpdate();
            if (rowBN > 0) {
                JOptionPane.showMessageDialog(null, "Thêm bệnh nhân thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không thể thêm bệnh nhân!");
            }

            //lấy ra mã bn vừa insert vào để insert vào bảng sử dụng thuốc
            String sqlLayMaBN = "select MAX(MaBN) from BENHNHAN";
            resultSet = statement.executeQuery(sqlLayMaBN);
            int layMaBN = 0;
            while (resultSet.next()) {
                layMaBN = resultSet.getInt(1);
            }

            //mỗi bệnh nhân có 1 danh sách thuốc sdung, tùy theo loại bn và cân nặng, thời gian đtrị tùy vào loại bn
            if (loaiBN == 1) {
                java.util.Date ngaykttc = addDay(ngayDT, 2);
                java.util.Date ngaybdcc = addDay(ngaykttc, 1);
                java.util.Date ngayktcc = addMonth(ngaybdcc, 2);
                //chuyển ngày sang util.Date để tính toán và chuyển về sql.Date để insert xuống db
                java.sql.Date ngayKTTC = new java.sql.Date(ngaykttc.getTime());
                java.sql.Date ngayBDCC = new java.sql.Date(ngaybdcc.getTime());
                java.sql.Date ngayKTCC = new java.sql.Date(ngayktcc.getTime());

                if (canNang < 39) {
                    InsertSuDungThuoc(layMaBN, 2, 2, 2, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
                }
                if (canNang >= 40 && canNang < 55) {
                    InsertSuDungThuoc(layMaBN, 3, 2, 3, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
                }
                if (canNang >= 55 && canNang < 70) {
                    InsertSuDungThuoc(layMaBN, 4, 3, 4, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
                }
                if (canNang >= 70) {
                    InsertSuDungThuoc(layMaBN, 5, 4, 5, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
                }
            } else {
                if (loaiBN == 2) {
                    java.util.Date ngaykttc = addDay(ngayDT, 3);
                    java.util.Date ngaybdcc = addDay(ngaykttc, 1);
                    java.util.Date ngayktcc = addMonth(ngaybdcc, 5);

                    java.sql.Date ngayKTTC = new java.sql.Date(ngaykttc.getTime());
                    java.sql.Date ngayBDCC = new java.sql.Date(ngaybdcc.getTime());
                    java.sql.Date ngayKTCC = new java.sql.Date(ngayktcc.getTime());

                    if (canNang < 39) {
                        InsertSuDungThuoc(layMaBN, 2, 2, 2, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
                    }
                    if (canNang >= 40 && canNang < 55) {
                        InsertSuDungThuoc(layMaBN, 3, 2, 3, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
                    }
                    if (canNang >= 55 && canNang < 70) {
                        InsertSuDungThuoc(layMaBN, 4, 3, 4, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
                    }
                    if (canNang >= 70) {
                        InsertSuDungThuoc(layMaBN, 5, 4, 5, ngayBDTC, ngayKTTC, ngayBDCC, ngayKTCC);
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
        if (cbxLoaiBN.getSelectedIndex() != 0 && cbxLoaiBN.getSelectedIndex() != 1) {
            this.cbxLoaiThuoc.setEnabled(true);
            this.btnThemLoaiThuoc.setEnabled(true);
        } else {
            this.cbxLoaiThuoc.setEnabled(false);
            this.btnThemLoaiThuoc.setEnabled(false);
        }
        if (cbxLoaiBN.getSelectedIndex() == 0) {
            txtThoiGianDT.setText("6");
        }
        if (cbxLoaiBN.getSelectedIndex() == 1) {
            txtThoiGianDT.setText("8");
        }
    }//GEN-LAST:event_cbxLoaiBNActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ManHinhChinh mhc = new ManHinhChinh();
        mhc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnThemBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBNActionPerformed
        // TODO add your handling code here:
        Them mht = new Them();
        mht.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnThemBNActionPerformed

    private void btnThemLoaiThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiThuocActionPerformed
        // TODO add your handling code here:
        ThemLoaiThuoc tlt = new ThemLoaiThuoc();
        tlt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnThemLoaiThuocActionPerformed

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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private javax.swing.ButtonGroup btnGroupLoaiBenhNhan;
    private javax.swing.ButtonGroup btnGroupSoKy;
    private javax.swing.JButton btnThemBN;
    private javax.swing.JButton btnThemLoaiThuoc;
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
