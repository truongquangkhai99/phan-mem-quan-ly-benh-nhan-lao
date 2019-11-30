/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlbn;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import DAO.BENHNHAN;
import BUS.BENHNHANBUS;
import DAO.THUOC;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Tien Nguyen
 */
public class Sua extends javax.swing.JFrame {
     /**
     * Creates new form QLBNL
     */
    BENHNHAN b = new BENHNHAN();
    public Sua() {
        initComponents();
  
    }
    public Sua(BENHNHAN bn) {
        initComponents();
        // Load field
        this.b = bn;
        txtName.setText(bn.getTENBN());
        txtLocation.setText(bn.getDIACHI());
        txtAge.setText(Integer.toString(bn.getTUOI()));
        System.out.println(bn.getGIOITINH());
        if (bn.getGIOITINH().indexOf("am") >= 0)
        {
            System.out.println("nammmmmmmmmmmmm");
            rbtNam.setSelected(true);
        }
        else
        {
            System.out.println("nuuuuuuuuuuuuuuu");
            rbtNu.setSelected(true);
        }
        String lbnhan = bn.getLOAIBN();
        if(lbnhan.compareTo("Mới") == 0)
            cbxloaibenhnhan.setSelectedIndex(0);
        if(lbnhan.compareTo("Tái phát") == 0)
            cbxloaibenhnhan.setSelectedIndex(1);
        if(lbnhan.compareTo("Kháng thuốc") == 0)
            cbxloaibenhnhan.setSelectedIndex(2);
        if(lbnhan.compareTo("Trẻ em") == 0)
            cbxloaibenhnhan.setSelectedIndex(3);
        
        String soky = bn.getCANNANG();
        if(soky.compareTo("< 39") == 0)
            cbbcannang.setSelectedIndex(0);
        if(soky.compareTo("40 -> 55") == 0)
            cbbcannang.setSelectedIndex(1);
        if(soky.compareTo("56 -> 70") == 0)
            cbbcannang.setSelectedIndex(2);
        if(soky.compareTo("> 70") == 0)
            cbbcannang.setSelectedIndex(3);
        
        // Load thuoc
        for (THUOC t:bn.getDanhSachThuoc())
        {
            String tenThuoc = t.getMALOAITHUOC().toUpperCase();
            tenThuoc = tenThuoc.replace(" ", "");
            switch (tenThuoc)
            {
                case "EMB":
                    txtEMB.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "SM":
                    txtSM.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "E":
                    txtE.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "RH":
                    txtRH.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "RHZE":
                    txtRHZE.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "RHZ":
                    txtRHZ.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "RH150_7":
                    txtRH15_7.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "RH150_10":
                    txtRH15_10.setText(Integer.toString(t.getSOLUONG()));
                    break;
                case "RH100_100":
                    txtRH10_10.setText(Integer.toString(t.getSOLUONG()));
                    break;
            }
        
        }
    }
        
        
    /**23
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGioiTinh = new javax.swing.ButtonGroup();
        btnGroupLoaiBenhNhan = new javax.swing.ButtonGroup();
        btnGroupSoKy = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtRHZE = new javax.swing.JTextField();
        txtSM = new javax.swing.JTextField();
        txtRHZ = new javax.swing.JTextField();
        txtEMB = new javax.swing.JTextField();
        txtE = new javax.swing.JTextField();
        txtRH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRH15_10 = new javax.swing.JTextField();
        txtRH15_7 = new javax.swing.JTextField();
        txtRH10_10 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        rbtNam = new javax.swing.JRadioButton();
        rbtNu = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        cbxloaibenhnhan = new javax.swing.JComboBox<>();
        cbbcannang = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nhập Bệnh Nhân");
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setForeground(java.awt.Color.pink);
        setSize(new java.awt.Dimension(14, 20));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Loại bệnh nhân");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 222, -1, 33));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cân nặng (Kg)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(522, 222, -1, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Loại thuốc (Viên)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 314, -1, 48));

        btnLuu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/sign-add-icon.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        getContentPane().add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 599, 93, -1));

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

        txtRHZE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRHZE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRHZE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRHZEActionPerformed(evt);
            }
        });
        getContentPane().add(txtRHZE, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 80, 30));

        txtSM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 84, 32));

        txtRHZ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRHZ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRHZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRHZActionPerformed(evt);
            }
        });
        getContentPane().add(txtRHZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 80, 30));

        txtEMB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEMB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEMBActionPerformed(evt);
            }
        });
        getContentPane().add(txtEMB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 84, 29));

        txtE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEActionPerformed(evt);
            }
        });
        getContentPane().add(txtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 84, 33));

        txtRH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRHActionPerformed(evt);
            }
        });
        getContentPane().add(txtRH, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 348, 80, 29));

        jLabel4.setText("SM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 409, 26, 25));

        jLabel5.setText("RHZE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 413, -1, 20));

        jLabel6.setText("RHZ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, 37, -1));

        jLabel7.setText("E");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 34, -1));

        jLabel8.setText("EMB");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 363, 34, -1));

        jLabel9.setText("RH");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 350, 34, 29));

        txtRH15_10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRH15_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtRH15_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRH15_10ActionPerformed(evt);
            }
        });
        getContentPane().add(txtRH15_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 345, 75, 28));

        txtRH15_7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRH15_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtRH15_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 406, 75, 32));

        txtRH10_10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRH10_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtRH10_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(707, 464, 75, 29));

        jLabel10.setText("RH150/100");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 416, -1, -1));

        jLabel11.setText("RH150/7");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 353, -1, -1));

        jLabel12.setText("RH100/100");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 473, -1, -1));

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
        rbtNam.setText("Nam");
        rbtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNamActionPerformed(evt);
            }
        });
        getContentPane().add(rbtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 163, -1, -1));

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

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAge.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        getContentPane().add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 162, 167, 28));

        cbxloaibenhnhan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxloaibenhnhan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mới", "Tái phát", "Kháng thuốc", "Trẻ em" }));
        getContentPane().add(cbxloaibenhnhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 222, 159, 33));

        cbbcannang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "< 39", "40 -> 55", "56 -> 70", "> 70" }));
        getContentPane().add(cbbcannang, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 224, 167, 33));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlbn/gdthem.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtRHZEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRHZEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRHZEActionPerformed

    private void txtRHZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRHZActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRHZActionPerformed

    private void txtEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEActionPerformed

    private void txtRH15_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRH15_10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRH15_10ActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        BENHNHANBUS benhnhan = new BENHNHANBUS();
        BENHNHAN bn = new BENHNHAN();
//         TODO add your handling code here:   
        // Thêm phần dùng thuốc
        try {
            
            // Thông tin bệnh nhân
            String gioiTinh = "Nữ";
            if (rbtNam.isSelected())
                gioiTinh = "Nam";

            bn.setMABN(this.b.getMABN());
            bn.setTENBN(txtName.getText().toString());
            bn.setDIACHI(txtLocation.getText().toString());
            bn.setTUOI(Integer.parseInt(txtAge.getText().toString()));
            bn.setGIOITINH(gioiTinh);
            bn.setLOAIBN(cbxloaibenhnhan.getSelectedItem().toString());
            bn.setCANNANG(cbbcannang.getSelectedItem().toString());

//            System.out.println( cbbcannang.getSelectedItem().toString());
            
            // Thông tin thuốc
            List<THUOC> DanhSachThuoc=new ArrayList();
            if(! txtEMB.getText().isEmpty())
            {
                THUOC tmp = new THUOC("EMB", Integer.parseInt(txtEMB.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtSM.getText().isEmpty())
            {
                THUOC tmp = new THUOC("SM", Integer.parseInt(txtSM.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtE.getText().isEmpty())
            {
                THUOC tmp = new THUOC("E", Integer.parseInt(txtE.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtRH.getText().isEmpty())
            {
               THUOC tmp = new THUOC("RH", Integer.parseInt(txtRH.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtRHZE.getText().isEmpty())
            {
                THUOC tmp = new THUOC("RHZE", Integer.parseInt(txtRHZE.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtRHZ.getText().isEmpty())
            {
                THUOC tmp = new THUOC("RHZ", Integer.parseInt(txtRHZ.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtRH15_7.getText().isEmpty())
            {
                THUOC tmp = new THUOC("RH150_7", Integer.parseInt(txtRH15_7.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtRH15_10.getText().isEmpty())
            {
                THUOC tmp = new THUOC("RH150_10", Integer.parseInt(txtRH15_10.getText()));
                DanhSachThuoc.add(tmp);
            }
            if(! txtRH10_10.getText().isEmpty())
            {
                THUOC tmp = new THUOC("RH100_100", Integer.parseInt(txtRH10_10.getText()));
                DanhSachThuoc.add(tmp);
            }
            
            
            bn.setDanhSachThuoc(DanhSachThuoc);
            
            benhnhan.updatebenhnhan(bn);

            Object[] options = {"OK"};
            int input = JOptionPane.showOptionDialog(null, "Đã lưu thông tin bệnh nhân thành công !", "Thông báo", 
                    JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,options[0]);

            if(input == JOptionPane.YES_OPTION)
            {
                this.setVisible(false);
                TimXoaSua frm = new TimXoaSua();
                frm.setVisible(true);
            }
        } catch (NumberFormatException ex)
        {
            Logger.getLogger(Them.class.getName()).log(Level.SEVERE, null, ex);
            
            Object[] options = {"OK"};
           JOptionPane.showOptionDialog(null, "Bạn hãy điền đầy đủ thông tin !", 
                   "Thông báo", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                   null, options,options[0]);

        }
        catch (Exception ex) {
            Logger.getLogger(Them.class.getName()).log(Level.SEVERE, null, ex);
            
            Object[] options = {"OK"};
            int input = JOptionPane.showOptionDialog(null, "Lưu thông tin không thành công !", 
                    "Thông báo", JOptionPane.ERROR_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options,options[0]);

            if(input == JOptionPane.YES_OPTION)
            {
                Sua frm = new Sua(this.b);
                this.setVisible(false);
                frm.setVisible(true);
            }
        }


    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
//        System.exit(0);
    this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void rbtNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtNuActionPerformed

    private void rbtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtNamActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtRHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRHActionPerformed

    private void txtEMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEMBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEMBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Them.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Them().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private javax.swing.ButtonGroup btnGroupLoaiBenhNhan;
    private javax.swing.ButtonGroup btnGroupSoKy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cbbcannang;
    private javax.swing.JComboBox<String> cbxloaibenhnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbtNam;
    private javax.swing.JRadioButton rbtNu;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtE;
    private javax.swing.JTextField txtEMB;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRH;
    private javax.swing.JTextField txtRH10_10;
    private javax.swing.JTextField txtRH15_10;
    private javax.swing.JTextField txtRH15_7;
    private javax.swing.JTextField txtRHZ;
    private javax.swing.JTextField txtRHZE;
    private javax.swing.JTextField txtSM;
    // End of variables declaration//GEN-END:variables
}
