/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhanVien_Dao;
import entity.NhanVien;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class TimNhanVien extends javax.swing.JPanel {

   
    public TimNhanVien() {
        initComponents();
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(32, 136, 203));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable1.setRowHeight(25);
        jTable1.setBackground(new Color(255, 255, 255));
        jTable1.setSelectionMode(0);
        modal = jTable1.getModel();
        dtm = (DefaultTableModel) modal;
        dataToTable();
    }

    public void dataToTable() {
        NhanVien_Dao dsNV = new NhanVien_Dao();
        List<NhanVien> list = dsNV.layDSNV();
        for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }       
    }
     public void removedataTable() {
        dtm.setRowCount(0);

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 242, 241));
        setPreferredSize(new java.awt.Dimension(1450, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 121, 107));
        jLabel1.setText("TÌM KIẾM NHÂN VIÊN");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Email", "Lương", "Địa chỉ", "Chức vụ"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(102, 255, 178));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 121, 107));
        jLabel2.setText("Tên nhân viên");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 121, 107));
        jLabel3.setText("Chức vụ");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nhân viên", "Quản lý" }));
        jComboBox1.setToolTipText("0");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 121, 107));
        jLabel4.setText("Số điện thoại");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(224, 242, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 121, 107)), "Chọn tác vụ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 121, 107))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 121, 107));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/transparency.png"))); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 121, 107));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton2.setText(" Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(519, 519, 519))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(151, 151, 151)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: 
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
        removedataTable();
        dataToTable();
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          List<NhanVien> list;
        if(!(jTextField1.getText().equals("")||jTextField2.getText().equals("")||jComboBox1.getSelectedItem().toString().equals("Tất cả"))){
             list = nv_d.Tim(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),0);
            removedataTable();
            for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }
            list.clear();
        }
        if(!jTextField1.getText().equals("")&&!jTextField2.getText().equals("")&& jComboBox1.getSelectedItem().toString().equals("Tất cả")){
            list = nv_d.Tim(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),1);
            removedataTable();
            for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }
            list.clear();
        }
        if(!jTextField1.getText().equals("")&&jTextField2.getText().equals("")&& !jComboBox1.getSelectedItem().toString().equals("Tất cả")){
            list = nv_d.Tim(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),2);
            removedataTable();
            for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }
            list.clear();
        }
        if(jTextField1.getText().equals("")&&!jTextField2.getText().equals("")&& !jComboBox1.getSelectedItem().toString().equals("Tất cả")){
            list = nv_d.Tim(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),3);
            removedataTable();
            for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }
            list.clear();
        }
        if(!jTextField1.getText().equals("")&&jTextField2.getText().equals("")&& jComboBox1.getSelectedItem().toString().equals("Tất cả")){
            list = nv_d.Tim(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),4);
            removedataTable();
            for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }
            list.clear();
        }
        if(jTextField1.getText().equals("")&&!jTextField2.getText().equals("")&& jComboBox1.getSelectedItem().toString().equals("Tất cả")){
            list = nv_d.Tim(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),5);
            removedataTable();
            for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }
            list.clear();
        }
        if(jTextField1.getText().equals("")&&jTextField2.getText().equals("")&& !jComboBox1.getSelectedItem().toString().equals("Tất cả")){
            list = nv_d.Tim(jTextField1.getText(),jTextField2.getText(),jComboBox1.getSelectedItem().toString(),6);
            removedataTable();
            for (NhanVien nv : list) {
            dtm.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getDienThoai(),
                nv.getEmail(),
                nv.getLuong(),
                nv.getDiaChi(),
                nv.getChucVu(),
            });
        }
            list.clear();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    private TableModel modal;
    private DefaultTableModel dtm;
    private NhanVien_Dao nv_d = new NhanVien_Dao();
          
}
