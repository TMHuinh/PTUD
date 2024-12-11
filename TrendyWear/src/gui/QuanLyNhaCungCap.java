/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhaCungCap_Dao;
import entity.NhaCungCap;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author duyzz
 */
public class QuanLyNhaCungCap extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyNhaCungCap
     */
    public QuanLyNhaCungCap() {
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
    }

    public void removedataTable() {
        dtm.setRowCount(0);

    }

    public void xt() {
        jtf_mncc.setText("");
        jtf_mncc.requestFocus();
        jtf_tncc.setText("");
        jtf_dc.setText("");
        jtf_sdt.setText("");
        jtf_email.setText("");

    }

    public void dataToTable() {
        NhaCungCap_Dao dsNCC = new NhaCungCap_Dao();
        List<NhaCungCap> list = dsNCC.layDSNCC();
        modal = jTable2.getModel();
        DefaultTableModel dtf = (DefaultTableModel) modal;

        for (NhaCungCap ncc : list) {
            dtf.addRow(new Object[]{
                ncc.getMaNCC(),
                ncc.getTenNCC(),
                ncc.getDiaChi(),
                ncc.getDienThoai(),
                ncc.getEmail(),});
        }
        jTable2.setModel(dtf);
    }

    public boolean check() {
        if (!(jtf_mncc.getText().trim().matches("^NCC\\d+$"))) {
            JOptionPane.showMessageDialog(this, "Mã không đúng (Phải theo mẫu sau: NCC...)", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!(jtf_tncc.getText().trim().matches("^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*"))) {
            JOptionPane.showMessageDialog(this, "Tên không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!jtf_dc.getText().trim().matches("^.+")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!(jtf_sdt.getText().trim().matches("\\d{10}"))) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!(jtf_email.getText().trim().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))) {
            JOptionPane.showMessageDialog(this, "Email không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtf_mncc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtf_tncc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_dc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_sdt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jb_them = new javax.swing.JButton();
        jb_xoa = new javax.swing.JButton();
        jb_sua = new javax.swing.JButton();
        jb_sua1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 242, 241));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(1450, 650));

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email"
            }
        ));
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(102, 255, 178));
        jTable2.setShowHorizontalLines(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(4).setMinWidth(200);
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 121, 107));
        jLabel6.setText("QUẢN LÝ NHÀ CUNG CẤP");

        jPanel1.setBackground(new java.awt.Color(224, 242, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 121, 107)), "Quản lý nhà cung cấp: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 121, 107))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 121, 107));
        jLabel1.setText("Mã nhà cung cấp");

        jtf_mncc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtf_mncc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 121, 107));
        jLabel2.setText("Tên nhà cung cấp");

        jtf_tncc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtf_tncc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 121, 107));
        jLabel3.setText("Địa chỉ");

        jtf_dc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtf_dc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 121, 107));
        jLabel4.setText("Số điên thoại");

        jtf_sdt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtf_sdt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 121, 107));
        jLabel5.setText("Email");

        jtf_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtf_email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(224, 242, 241));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 121, 107)), "Chọn tác vụ: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 121, 107))); // NOI18N

        jb_them.setBackground(new java.awt.Color(0, 121, 107));
        jb_them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jb_them.setForeground(new java.awt.Color(255, 255, 255));
        jb_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/house.png"))); // NOI18N
        jb_them.setText("Thêm");
        jb_them.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_themActionPerformed(evt);
            }
        });

        jb_xoa.setBackground(new java.awt.Color(0, 121, 107));
        jb_xoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jb_xoa.setForeground(new java.awt.Color(255, 255, 255));
        jb_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-button.png"))); // NOI18N
        jb_xoa.setText("Xóa");
        jb_xoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_xoaActionPerformed(evt);
            }
        });

        jb_sua.setBackground(new java.awt.Color(0, 121, 107));
        jb_sua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jb_sua.setForeground(new java.awt.Color(255, 255, 255));
        jb_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/updating.png"))); // NOI18N
        jb_sua.setText("Cập Nhật");
        jb_sua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_suaActionPerformed(evt);
            }
        });

        jb_sua1.setBackground(new java.awt.Color(0, 121, 107));
        jb_sua1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jb_sua1.setForeground(new java.awt.Color(255, 255, 255));
        jb_sua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        jb_sua1.setText(" Lưu");
        jb_sua1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jb_sua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_sua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jb_them, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(jb_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jb_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jb_sua1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_sua1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_dc, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jtf_tncc)
                            .addComponent(jtf_mncc))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_email, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(jtf_sdt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtf_mncc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_tncc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_dc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(527, 527, 527)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jb_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_xoaActionPerformed
        // TODO add your handling code here:
        int row = jTable2.getSelectedRow();
        if (row != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhà cung cấp này?",
                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                NhaCungCap_Dao ncc_d = new NhaCungCap_Dao();
                if (ncc_d.xoaNCC(dtm.getValueAt(row, 0).toString())) {
                    removedataTable();
                    dataToTable();
                    xt();
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa nhà cung cấp này. Nhà cung cấp đã có sản phẩm trong hệ thống", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn dòng cần xóa","Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jb_xoaActionPerformed

    private void jb_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_suaActionPerformed
        // TODO add your handling code here:
        int row = jTable2.getSelectedRow();
        if (row != -1) {
            if (check()) {
                NhaCungCap ncc = new NhaCungCap(jtf_mncc.getText().trim(), jtf_tncc.getText().trim(), jtf_dc.getText().trim(), jtf_sdt.getText().trim(), jtf_email.getText().trim());
                NhaCungCap_Dao ncc_d = new NhaCungCap_Dao();
                if (ncc_d.CapNhat(ncc)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công", "Thông báo",
                            JOptionPane.INFORMATION_MESSAGE);
                    xt();
                    removedataTable();
                    dataToTable();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_suaActionPerformed

    private void jb_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_themActionPerformed
        // TODO add your handling code here:
        xt();
        jTable2.clearSelection();
        jtf_mncc.setEditable(true);
    }//GEN-LAST:event_jb_themActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r = jTable2.getSelectedRow();
        int mouseCount = evt.getButton();
        if (r != -1) {
            jtf_mncc.setText(dtm.getValueAt(r, 0).toString());
            jtf_mncc.setEditable(false);
            jtf_tncc.setText(dtm.getValueAt(r, 1).toString());
            jtf_dc.setText(dtm.getValueAt(r, 2).toString());
            jtf_sdt.setText(dtm.getValueAt(r, 3).toString());
            jtf_email.setText(dtm.getValueAt(r, 4).toString());
        }
        if (mouseCount > 1) {
            jTable2.clearSelection();
            jtf_mncc.setEditable(true);
            xt();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jb_sua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_sua1ActionPerformed
        // TODO add your handling code here:
        if (check()) {
            NhaCungCap ncc = new NhaCungCap(jtf_mncc.getText().trim(), jtf_tncc.getText().trim(), jtf_dc.getText().trim(), jtf_sdt.getText().trim(), jtf_email.getText().trim());
            NhaCungCap_Dao ncc_d = new NhaCungCap_Dao();
            if (ncc_d.themNCC(ncc)) {
                JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                xt();
                removedataTable();
                dataToTable();
            } else {
                JOptionPane.showMessageDialog(this, "Trùng mã", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jb_sua1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jb_sua;
    private javax.swing.JButton jb_sua1;
    private javax.swing.JButton jb_them;
    private javax.swing.JButton jb_xoa;
    private javax.swing.JTextField jtf_dc;
    private javax.swing.JTextField jtf_email;
    private javax.swing.JTextField jtf_mncc;
    private javax.swing.JTextField jtf_sdt;
    private javax.swing.JTextField jtf_tncc;
    // End of variables declaration//GEN-END:variables
    private TableModel modal;
    private DefaultTableModel dtm;
}
