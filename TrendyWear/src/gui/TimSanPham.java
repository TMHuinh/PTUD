/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.LoaiSanPham_Dao;
import dao.NhaCungCap_Dao;
import dao.SanPham_Dao;
import entity.NhaCungCap;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DELL
 */
public class TimSanPham extends javax.swing.JPanel {

    /**
     * Creates new form TimSanPham
     */
    public TimSanPham() {
        initComponents();
        jTable2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(32, 136, 203));
        jTable2.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable2.setRowHeight(25);
        jTable2.setBackground(new Color(255, 255, 255));
        jTable2.setSelectionMode(0);
        modal = jTable2.getModel();
        dtm = (DefaultTableModel) modal;
        dataToTable();
        dataNCC();
        dataLSP();
    }

    public void dataToTable() {
        List<entity.SanPham> list = sp_d.layDSSP();
        for (entity.SanPham sp : list) {
            dtm.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getMauSac(),
                sp.getKichCo(),
                sp.getGia(),
                sp.getThuongHieu(),
                sp.getSoLuongTon(),
                sp.getNhaCungCap().getTenNCC(),
                sp.getLoaiSanPham().getTenLoai()
            });
        }
    }

    public void dataNCC() {
        List<NhaCungCap> list = ncc_d.layDSNCC();
        for (NhaCungCap ncc : list) {
            jComboBox2.addItem(ncc.getTenNCC());
            mapNCC.put(ncc.getTenNCC(), ncc.getMaNCC());
        }
    }

    public void dataLSP() {
        List<entity.LoaiSanPham> list = lsp_d.layDSLSP();
        for (entity.LoaiSanPham lsp : list) {
            jComboBox1.addItem(lsp.getTenLoai());
            mapLSP.put(lsp.getTenLoai(), lsp.getMaLoai());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(224, 242, 241));
        setPreferredSize(new java.awt.Dimension(1450, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 121, 107));
        jLabel1.setText("TÌM KIẾM SẢN PHẨM");

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Màu sắc ", "Size", "Giá", "Thương hiệu", "Số lượng tồn", "Nhà cung cấp", "Loại sản phẩm"
            }
        ));
        jTable2.setSelectionBackground(new java.awt.Color(102, 255, 178));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 121, 107));
        jLabel4.setText("Tên sản phẩm");

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

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 121, 107));
        jLabel5.setText("Loại sản phẩm");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 121, 107));
        jLabel6.setText("Nhà cung cấp");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 121, 107));
        jLabel2.setText("Hình ảnh");

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(111, 111, 111))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(525, 525, 525))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!jTextField2.getText().equals("") && jComboBox1.getSelectedItem().toString().endsWith("Tất cả") && jComboBox2.getSelectedItem().toString().endsWith("Tất cả")) {
            try {
                List<entity.SanPham> list = sp_d.timSP(jTextField2.getText(), "", "", 0);
                dtm.setRowCount(0);
                for (entity.SanPham sp : list) {
                    dtm.addRow(new Object[]{
                        sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getMauSac(),
                        sp.getKichCo(),
                        sp.getGia(),
                        sp.getThuongHieu(),
                        sp.getSoLuongTon(),
                        sp.getNhaCungCap().getTenNCC(),
                        sp.getLoaiSanPham().getTenLoai()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!jTextField2.getText().equals("") && !jComboBox1.getSelectedItem().toString().endsWith("Tất cả") && jComboBox2.getSelectedItem().toString().endsWith("Tất cả")) {

            try {
                List<entity.SanPham> list = sp_d.timSP(jTextField2.getText(), mapLSP.get(jComboBox1.getSelectedItem().toString()), "", 1);
                dtm.setRowCount(0);
                for (entity.SanPham sp : list) {
                    dtm.addRow(new Object[]{
                        sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getMauSac(),
                        sp.getKichCo(),
                        sp.getGia(),
                        sp.getThuongHieu(),
                        sp.getSoLuongTon(),
                        sp.getNhaCungCap().getTenNCC(),
                        sp.getLoaiSanPham().getTenLoai()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!jTextField2.getText().equals("") && jComboBox1.getSelectedItem().toString().endsWith("Tất cả") && !jComboBox2.getSelectedItem().toString().endsWith("Tất cả")) {
            try {
                List<entity.SanPham> list = sp_d.timSP(jTextField2.getText(), "", mapNCC.get(jComboBox2.getSelectedItem().toString()), 2);
                dtm.setRowCount(0);
                for (entity.SanPham sp : list) {
                    dtm.addRow(new Object[]{
                        sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getMauSac(),
                        sp.getKichCo(),
                        sp.getGia(),
                        sp.getThuongHieu(),
                        sp.getSoLuongTon(),
                        sp.getNhaCungCap().getTenNCC(),
                        sp.getLoaiSanPham().getTenLoai()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jTextField2.getText().equals("") && !jComboBox1.getSelectedItem().toString().endsWith("Tất cả") && jComboBox2.getSelectedItem().toString().endsWith("Tất cả")) {
            try {
                List<entity.SanPham> list = sp_d.timSP(jTextField2.getText(), mapLSP.get(jComboBox1.getSelectedItem().toString()), "", 3);
                dtm.setRowCount(0);
                for (entity.SanPham sp : list) {
                    dtm.addRow(new Object[]{
                        sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getMauSac(),
                        sp.getKichCo(),
                        sp.getGia(),
                        sp.getThuongHieu(),
                        sp.getSoLuongTon(),
                        sp.getNhaCungCap().getTenNCC(),
                        sp.getLoaiSanPham().getTenLoai()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jTextField2.getText().equals("") && !jComboBox1.getSelectedItem().toString().endsWith("Tất cả") && !jComboBox2.getSelectedItem().toString().endsWith("Tất cả")) {
            try {
                List<entity.SanPham> list = sp_d.timSP(jTextField2.getText(), mapLSP.get(jComboBox1.getSelectedItem().toString()), mapNCC.get(jComboBox2.getSelectedItem().toString()), 4);
                dtm.setRowCount(0);
                for (entity.SanPham sp : list) {
                    dtm.addRow(new Object[]{
                        sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getMauSac(),
                        sp.getKichCo(),
                        sp.getGia(),
                        sp.getThuongHieu(),
                        sp.getSoLuongTon(),
                        sp.getNhaCungCap().getTenNCC(),
                        sp.getLoaiSanPham().getTenLoai()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jTextField2.getText().equals("") && jComboBox1.getSelectedItem().toString().endsWith("Tất cả") && !jComboBox2.getSelectedItem().toString().endsWith("Tất cả")) {
            try {
                List<entity.SanPham> list = sp_d.timSP(jTextField2.getText(), "", mapNCC.get(jComboBox2.getSelectedItem().toString()), 5);
                dtm.setRowCount(0);
                for (entity.SanPham sp : list) {
                    dtm.addRow(new Object[]{
                        sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getMauSac(),
                        sp.getKichCo(),
                        sp.getGia(),
                        sp.getThuongHieu(),
                        sp.getSoLuongTon(),
                        sp.getNhaCungCap().getTenNCC(),
                        sp.getLoaiSanPham().getTenLoai()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!jTextField2.getText().equals("") && !jComboBox1.getSelectedItem().toString().endsWith("Tất cả") && !jComboBox2.getSelectedItem().toString().endsWith("Tất cả")) {
            try {
                List<entity.SanPham> list = sp_d.timSP(jTextField2.getText(), mapLSP.get(jComboBox1.getSelectedItem().toString()), mapNCC.get(jComboBox2.getSelectedItem().toString()), 6);
                dtm.setRowCount(0);
                for (entity.SanPham sp : list) {
                    dtm.addRow(new Object[]{
                        sp.getMaSP(),
                        sp.getTenSP(),
                        sp.getMauSac(),
                        sp.getKichCo(),
                        sp.getGia(),
                        sp.getThuongHieu(),
                        sp.getSoLuongTon(),
                        sp.getNhaCungCap().getTenNCC(),
                        sp.getLoaiSanPham().getTenLoai()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(TimSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r = jTable2.getSelectedRow();
        int mouseCount = evt.getButton();
        if (r != -1) {
            img = sp_d.getURL(dtm.getValueAt(r, 0).toString());
            jLabel3.setIcon(new ImageIcon(img));
        }
        if (mouseCount > 1) {
            jTable2.clearSelection();
            jLabel3.setIcon(new ImageIcon(""));
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        dtm.setRowCount(0);
        dataToTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    private TableModel modal;
    private DefaultTableModel dtm;
    private Map<String, String> mapNCC = new HashMap<>();
    private Map<String, String> mapLSP = new HashMap<>();
    private NhaCungCap_Dao ncc_d = new NhaCungCap_Dao();
    private LoaiSanPham_Dao lsp_d = new LoaiSanPham_Dao();
    private String img;
    private SanPham_Dao sp_d = new SanPham_Dao();
}
