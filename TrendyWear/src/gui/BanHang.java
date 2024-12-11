/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import dao.ChiTietHoaDon_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.LoaiSanPham_Dao;
import dao.SanPham_Dao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.NhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.OverlayLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author duyzz
 */
public class BanHang extends javax.swing.JPanel {

    /**
     * Creates new form BanHang
     */
    public BanHang(NhanVien nv) {
        initComponents();
        this.nv = nv;
        jTable2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(32, 136, 203));
        jTable2.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable2.setRowHeight(25);
        jTable2.setBackground(new Color(255, 255, 255));
        jTable2.setSelectionMode(0);
        modal = jTable2.getModel();
        dtm = (DefaultTableModel) modal;
        jPanel2.setLayout(new BorderLayout());
        list = getDS();
        jTextField1.setEditable(false);
        jPanel2.setLayout(new GridLayout(0, 6, 2, 2));
        for (entity.SanPham sp : list) {
            SanPham spc = new SanPham(sp);
            spc.jLabel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    if (Integer.valueOf(spc.jSpinner1.getValue().toString()) <= 0) {
                        JOptionPane.showMessageDialog(BanHang.this, "Vui lòng nhập số lượng");
                    } else {
                        if (jTable2.getRowCount() > 0) {
                            int index = -1;
                            for (int i = 0; i < jTable2.getRowCount(); i++) {
                                if (spc.maSP.equals(dtm.getValueAt(i, 0))) {
                                    index = i;
                                    break;
                                }
                            }
                            if (index != -1) {
                                dtm.setValueAt(Integer.valueOf(spc.jSpinner1.getValue().toString()) + Integer.valueOf(dtm.getValueAt(index, 3).toString()), index, 3);
                                tongTien();
                                spc.jSpinner1.setValue(0);
                            } else {
                                dtm.addRow(new Object[]{
                                    spc.maSP,
                                    spc.jLabel2.getText(),
                                    spc.jLabel3.getText(),
                                    spc.jSpinner1.getValue().toString()
                                });
                                spc.jSpinner1.setValue(0);
                                tongTien();
                            }
                        } else {
                            dtm.addRow(new Object[]{
                                spc.maSP,
                                spc.jLabel2.getText(),
                                spc.jLabel3.getText(),
                                spc.jSpinner1.getValue().toString()
                            });
                            spc.jSpinner1.setValue(0);
                            tongTien();
                        }

                    }
                }
            });
            jPanel2.add(spc);
        }
        list1 = getDSLSP();
        dataToCBB();

    }

    public List<entity.SanPham> getDS() {
        ArrayList<entity.SanPham> list = sp_d.layDSSP();
        return list;
    }

    public void tongTien() {
        int row = jTable2.getRowCount();
        amount = 0;
        for (int i = 0; i < row; i++) {
            double temp = 0;
            temp = Double.parseDouble(dtm.getValueAt(i, 3).toString()) * Double.parseDouble(dtm.getValueAt(i, 2).toString());
            amount += temp;
        }
        amount = jLabel7.getText().equals("5%") ? (0.95 * amount) : amount;
        jLabel2.setText(currencyFormatter.format(amount));
    }

    public List<entity.LoaiSanPham> getDSLSP() {
        return lsp_d.layDSLSP();
    }

    public List<entity.SanPham> filter(String dk) {
        List<entity.SanPham> list_filter = new ArrayList<>();
        for (entity.SanPham sp : list) {
            if (sp.getLoaiSanPham().getTenLoai().equals(dk)) {
                list_filter.add(sp);
            }
        };
        return list_filter;
    }

    public void dataToCBB() {
        for (entity.LoaiSanPham lsp : list1) {
            jComboBox1.addItem(lsp.getTenLoai());
        }
    }

    public boolean checkTonKho(List<entity.ChiTietHoaDon> list) {
        for (ChiTietHoaDon cthd : list) {
            if (!sp_d.tonKho(cthd.getSanPham().getMaSP(), cthd.getSoLuong())) {
                JOptionPane.showMessageDialog(this, cthd.getSanPham().getTenSP() + " không đủ số lượng", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(224, 242, 241));
        setPreferredSize(new java.awt.Dimension(1450, 650));

        jPanel1.setBackground(new java.awt.Color(224, 242, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng"
            }
        ));
        jTable2.setSelectionBackground(new java.awt.Color(102, 255, 178));
        jScrollPane1.setViewportView(jTable2);

        jButton1.setBackground(new java.awt.Color(0, 121, 107));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xóa sản phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 121, 107));
        jLabel1.setText("Tổng cộng:");

        jButton2.setBackground(new java.awt.Color(0, 121, 107));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thanh toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));

        jButton3.setBackground(new java.awt.Color(0, 121, 107));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Xóa tất cả sản phẩm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 121, 107));
        jLabel3.setText("Tên khách hàng");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 121, 107));
        jLabel4.setText("Số điện thoại");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton4.setBackground(new java.awt.Color(0, 121, 107));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Check khuyến mãi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 121, 107));
        jLabel5.setText("Danh sách sản phẩm");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 121, 107));
        jLabel6.setText("Khuyến mãi:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 121, 107));
        jLabel8.setText("BÁN HÀNG");

        jComboBox1.setBackground(new java.awt.Color(0, 121, 107));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 121, 107));
        jLabel9.setText("Lọc theo loại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel9)
                        .addGap(36, 36, 36)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(589, 589, 589))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int row = jTable2.getSelectedRow();
        if (row != -1) {
            dtm.removeRow(row);
            tongTien();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jTable2.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Trỗng");
        }
        dtm.setRowCount(0);
        tongTien();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTable2.getRowCount() > 0) {
            if (jTextField2.getText().equals("")) {
                JOptionPane.showMessageDialog(BanHang.this, "Vui lòng nhập đầy đủ thông tin khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } else {
                if (count == 0) {
                    Map<String, Integer> map = new HashMap<>();
                    map = kh_d.layDiem(jTextField2.getText().trim());
                    Set<String> key = map.keySet();
                    List list = new ArrayList<>(key);
                    String name = list.get(0).toString();
                    int soDiem = map.get(name);
                    jTextField1.setText(name);
                    if (soDiem == -1) {
                        JOptionPane.showMessageDialog(BanHang.this, "Khách hàng chưa tồn tại trong hệ thống", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    } else if (soDiem >= 10) {
                        amount *= 0.95;
                        jLabel7.setText("5%");
                        jLabel2.setText(currencyFormatter.format(amount));
                        count++;
                    } else {
                        jLabel7.setText("Không");
                        discount = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã kiểm tra khuyễn mãi rồi");
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (jTable2.getRowCount() > 0) {
            String[] options = {"Chuyển khoản", "Tiền mặt", "Hủy"};
            int confirm = JOptionPane.showOptionDialog(this,
                    "Chọn hình thức thanh toán",
                    "Hình thức thanh toán",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (confirm == 0) {
                // Người dùng chọn "Chuyển khoản"          
                HoaDon hd = new HoaDon(UUID.randomUUID().toString(), "Chuyển khoản", discount ? "5%" : "Không", LocalDateTime.now(), nv, kh_d.timTheoMa(jTextField1.getText(), jTextField2.getText()));
                List<ChiTietHoaDon> list = new ArrayList<>();
                for (int i = 0; i < jTable2.getRowCount(); i++) {
                    String sl = dtm.getValueAt(i, 3).toString();
                    ChiTietHoaDon cthd = new ChiTietHoaDon(Integer.parseInt(sl), hd, sp_d.timTheoMa(dtm.getValueAt(i, 0).toString()));
                    list.add(cthd);
                }
                //bo sung them check ton kho
                if (jLabel7.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra khuyến mãi", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (checkTonKho(list)) {
                        if (hd_d.themHD(hd)) {
                            //boolean check = true;
                            for (ChiTietHoaDon cthd : list) {
                                cthd_d.themHD(cthd);
                            }
                        }
                        dtm.setRowCount(0);
                        if (discount) {
                            kh_d.doiThuong(jTextField1.getText(), jTextField2.getText());
                        }
                        kh_d.tichDiem(jTextField1.getText(), jTextField2.getText());
                        jTextField1.setText("");
                        jTextField2.setText("");
                        inHD(hd, list, 1);
                        jLabel2.setText("");
                        jLabel7.setText("");
                        qrcode = new QRCode();
                        qrcode.setVisible(true);
                        qrcode.setLocationRelativeTo(null);
                        qrcode.setResizable(false);
                        qrcode.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                }

            } else if (confirm == 1) {
                // Người dùng chọn "Tiền mặt" 

                HoaDon hd = new HoaDon(UUID.randomUUID().toString(), "Tiền mặt", discount ? "5%" : "Không", LocalDateTime.now(), nv, kh_d.timTheoMa(jTextField1.getText(), jTextField2.getText()));
                List<ChiTietHoaDon> list = new ArrayList<>();
                for (int i = 0; i < jTable2.getRowCount(); i++) {
                    String sl = dtm.getValueAt(i, 3).toString();
                    ChiTietHoaDon cthd = new ChiTietHoaDon(Integer.parseInt(sl), hd, sp_d.timTheoMa(dtm.getValueAt(i, 0).toString()));
                    list.add(cthd);
                }
                if (jLabel7.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra khuyến mãi", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (checkTonKho(list)) {
                        if (hd_d.themHD(hd)) {

                            for (ChiTietHoaDon cthd : list) {
                                cthd_d.themHD(cthd);
                            }
                        }
                        dtm.setRowCount(0);
                        if (discount) {
                            kh_d.doiThuong(jTextField1.getText(), jTextField2.getText());
                        }
                        kh_d.tichDiem(jTextField1.getText(), jTextField2.getText());
                        jTextField1.setText("");
                        jTextField2.setText("");
                        inHD(hd, list, 0);
                        jLabel2.setText("");
                        jLabel7.setText("");
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để thanh toán");
        }
        count = 0;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:     
        String selectItem = jComboBox1.getSelectedItem().toString();
        if (!selectItem.equals("Tất cả")) {
            List<entity.SanPham> list1 = new ArrayList<>();
            list1 = filter(selectItem);
            jPanel2.removeAll();
            for (entity.SanPham sp : list1) {
                SanPham spc = new SanPham(sp);
                spc.jLabel1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                        if (Integer.valueOf(spc.jSpinner1.getValue().toString()) <= 0) {
                            JOptionPane.showMessageDialog(jPanel2, "Vui lòng nhập số lượng");
                        } else {
                            dtm.addRow(new Object[]{
                                spc.maSP,
                                spc.jLabel2.getText(),
                                spc.jLabel3.getText(),
                                spc.jSpinner1.getValue().toString()
                            });
                            spc.jSpinner1.setValue(0);
                            tongTien();
                        }
                    }
                });
                jPanel2.add(spc);
                jPanel2.revalidate();
                jPanel2.repaint();
            }

        } else {
            list = sp_d.layDSSP();
            jPanel2.removeAll();
            for (entity.SanPham sp : list) {
                SanPham spc = new SanPham(sp);
                spc.jLabel1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                        if (Integer.valueOf(spc.jSpinner1.getValue().toString()) <= 0) {
                            JOptionPane.showMessageDialog(jPanel2, "Vui lòng nhập số lượng");
                        } else {
                            dtm.addRow(new Object[]{
                                spc.maSP,
                                spc.jLabel2.getText(),
                                spc.jLabel3.getText(),
                                spc.jSpinner1.getValue().toString()
                            });
                            spc.jSpinner1.setValue(0);
                            tongTien();
                        }
                    }
                });
                jPanel2.add(spc);
            }
            jPanel2.revalidate();
            jPanel2.repaint();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    public void inHD(HoaDon hd, List<ChiTietHoaDon> cthd, int o) {
        String directoryPath = "T:\\N3_HK1\\PTUD\\TrendyWear\\HoaDon"; // Đường dẫn đến thư mục bạn muốn lưu
        new File(directoryPath).mkdirs(); // Tạo thư mục nếu nó chưa tồn tại
        String filename = directoryPath + "\\" + "HD" + hd.getMaHD() + ".pdf";
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(filename));
            Document doc = new Document(pdfDoc, PageSize.A6);
            FontProvider fontProvider = new FontProvider();
            String fontPath = "T:\\N3_HK1\\PTUD\\TrendyWear\\thuvien\\Times New Roman.ttf";
            fontProvider.addFont(fontPath);
            PdfFont font = PdfFontFactory.createFont(fontPath, PdfEncodings.IDENTITY_H, true);
            doc.setFont(font);

            // Cỡ chữ cho các đoạn văn
            float titleFontSize = 20f; // Cỡ chữ cho tiêu đề
            float supFontSize = 15f;
            float infoFontSize = 10f;   // Cỡ chữ cho thông tin hóa đơn
            float tableFontSize = 8f;   // Cỡ chữ nhỏ hơn cho bảng

            String tenkh = hd.getKhachHang().getTenKH();
            String tenkhcd = Normalizer.normalize(tenkh, Normalizer.Form.NFC);
            String tsp = Normalizer.normalize("Tên sản phẩm", Normalizer.Form.NFC);
            String sl = Normalizer.normalize("Số lượng", Normalizer.Form.NFC);
            String tt = Normalizer.normalize("Thành tiền", Normalizer.Form.NFC);
            String gia = Normalizer.normalize("Giá tiền", Normalizer.Form.NFC);
            String mhd = Normalizer.normalize("Mã hóa đơn: ", Normalizer.Form.NFC);
            String tnv = Normalizer.normalize("Tên nhân viên: ", Normalizer.Form.NFC);
            String tkh = Normalizer.normalize("Tên khách hàng: ", Normalizer.Form.NFC);
            String ntao = Normalizer.normalize("Ngày tạo: ", Normalizer.Form.NFC);
            String ttien = Normalizer.normalize("TỔNG TIỀN: ", Normalizer.Form.NFC);
            String khuyenmai = Normalizer.normalize("Khuyến mãi: ", Normalizer.Form.NFC);
            String loichao = Normalizer.normalize("Cảm ơn quý khách. Hẹn gặp lại!", Normalizer.Form.NFC);
            // Định dạng ngày giờ VN
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedDate = hd.getNgayLap().format(formatter);

            // Định dạng tiền theo kiểu VN
            // Không hiển thị số thập phân
            // Tiêu đề hóa đơn
            doc.add(new Paragraph("===== TrendyWear =====").setFontSize(titleFontSize).setBold().setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("HÓA ĐƠN BÁN HÀNG").setFontSize(supFontSize).setBold().setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph(mhd + hd.getMaHD()).setFontSize(infoFontSize));
            doc.add(new Paragraph(tnv + hd.getNhanVien().getTenNV()).setFontSize(infoFontSize));
            doc.add(new Paragraph(tkh + tenkhcd).setFontSize(infoFontSize));
            doc.add(new Paragraph(khuyenmai + hd.getKhuyenMai()).setFontSize(infoFontSize));
            doc.add(new Paragraph(ntao + formattedDate).setFontSize(infoFontSize));
            // Tạo bảng hóa đơn
            Table table = new Table(UnitValue.createPercentArray(new float[]{10, 30, 10, 10, 10})); // Thêm cột cho "Giá Tiền"
            table.setMarginTop(5);
            table.addCell(new Paragraph("STT").setFontSize(tableFontSize));
            table.addCell(new Paragraph(tsp).setFontSize(tableFontSize));
            table.addCell(new Paragraph(sl).setFontSize(tableFontSize));
            table.addCell(new Paragraph(gia).setFontSize(tableFontSize)); // Cột "Giá Tiền"
            table.addCell(new Paragraph(tt).setFontSize(tableFontSize));
            int i = 1;
            for (ChiTietHoaDon cthd1 : cthd) {
                String tspp = cthd1.getSanPham().getTenSP();
                String tsppcd = Normalizer.normalize(tspp, Normalizer.Form.NFC);
                table.addCell(new Paragraph(i++ + "").setFontSize(tableFontSize));
                table.addCell(new Paragraph(tsppcd).setFontSize(tableFontSize));
                table.addCell(new Paragraph(cthd1.getSoLuong() + "").setFontSize(tableFontSize));
                table.addCell(new Paragraph(currencyFormatter.format(cthd1.getSanPham().getGia())).setFontSize(tableFontSize)); // Hiển thị giá tiền
                table.addCell(new Paragraph(currencyFormatter.format(cthd1.thanhTien())).setFontSize(tableFontSize));
            }
            doc.add(table);
            doc.add(new Paragraph(ttien + jLabel2.getText()).setFontSize(infoFontSize).setBold());
            doc.add(new Paragraph(loichao).setFontSize(10f).setBold().setTextAlignment(TextAlignment.CENTER));
            doc.close();

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        if (o == 0) {
            try {
                Desktop.getDesktop().open(new File(filename));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    private SanPham_Dao sp_d = new SanPham_Dao();
    private LoaiSanPham_Dao lsp_d = new LoaiSanPham_Dao();
    private List<entity.SanPham> list;
    private List<entity.LoaiSanPham> list1;
    private TableModel modal;
    private DefaultTableModel dtm;
    private KhachHang_Dao kh_d = new KhachHang_Dao();
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    private double amount = 0;
    private QRCode qrcode;
    private NhanVien nv;
    private HoaDon_Dao hd_d = new HoaDon_Dao();
    private ChiTietHoaDon_Dao cthd_d = new ChiTietHoaDon_Dao();
    private boolean discount = true;
    private int count = 0;
}
