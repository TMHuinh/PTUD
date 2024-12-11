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
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author duyzz
 */

public class QuanLyHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form QuanLyHoaDon
     */
    public QuanLyHoaDon() {
        initComponents();
        jTable2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(32, 136, 203));
        jTable2.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable2.setRowHeight(25);
        jTable2.setBackground(new Color(255, 255, 255));
        jTable2.setSelectionMode(0);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(32, 136, 203));
        jTable1.getTableHeader().setForeground(new Color(255, 255, 255));
        jTable1.setRowHeight(25);
        jTable1.setBackground(new Color(255, 255, 255));
        jTable1.setSelectionMode(0);
        modal_2 = jTable2.getModel();
        dtm_2 = (DefaultTableModel) modal_2;
        modal_1 = jTable1.getModel();
        dtm_1 = (DefaultTableModel) modal_1;
        dataToTable();
    }

    public void dataToTable() {
        HoaDon_Dao dsHD = new HoaDon_Dao();
        List<HoaDon> list = dsHD.layDSHD();
        for (HoaDon hd : list) {
            dtm_2.addRow(new Object[]{
                hd.getMaHD(),
                hd.getNgayLap(),
                hd.getThanhToan(),
                hd.getNhanVien().getTenNV(),
                hd.getKhachHang().getTenKH(),
                hd.getKhuyenMai()
            });
        }
    }
    public void inHD(HoaDon hd, List<ChiTietHoaDon> cthd) {
        String directoryPath = "T:\\N3_HK1\\PTUD\\TrendyWear\\HoaDon"; // Đường dẫn đến thư mục bạn muốn lưu
        new File(directoryPath).mkdirs(); // Tạo thư mục nếu nó chưa tồn tại
        String filename = directoryPath + "\\" + "HD" + hd.getMaHD()+"_e" + ".pdf";
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
            doc.add(new Paragraph(khuyenmai+ hd.getKhuyenMai()).setFontSize(infoFontSize));
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
            double tongTien=0;
            for (ChiTietHoaDon cthd1 : cthd) {
                String tspp = cthd1.getSanPham().getTenSP();
                
                String tsppcd = Normalizer.normalize(tspp, Normalizer.Form.NFC);
                table.addCell(new Paragraph(i++ + "").setFontSize(tableFontSize));
                table.addCell(new Paragraph(tsppcd).setFontSize(tableFontSize));
                table.addCell(new Paragraph(cthd1.getSoLuong() + "").setFontSize(tableFontSize));
                table.addCell(new Paragraph(currencyFormatter.format(cthd1.getSanPham().getGia())).setFontSize(tableFontSize)); // Hiển thị giá tiền
                table.addCell(new Paragraph(currencyFormatter.format(cthd1.thanhTien())).setFontSize(tableFontSize));
               tongTien+=cthd1.thanhTien();
            }
            tongTien= hd.getKhuyenMai().equals("Không")?tongTien:tongTien*0.95;
            doc.add(table);
            doc.add(new Paragraph(ttien +currencyFormatter.format(tongTien) ).setFontSize(infoFontSize).setBold());
            doc.add(new Paragraph(loichao).setFontSize(10f).setBold().setTextAlignment(TextAlignment.CENTER));
            doc.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
            try {
                Desktop.getDesktop().open(new File(filename));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 242, 241));
        setPreferredSize(new java.awt.Dimension(1450, 650));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên sản phẩm", "Số lượng", "Thành tiền"
            }
        ));
        jTable1.setSelectionBackground(new java.awt.Color(102, 255, 178));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 121, 107));
        jLabel1.setText("HÓA ĐƠN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 121, 107));
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Hình thức thanh toán", "Tên nhân viên", "Tên khách hàng", "Khuyến mãi"
            }
        ));
        jTable2.setSelectionBackground(new java.awt.Color(102, 255, 178));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setMinWidth(100);
        }

        jPanel1.setBackground(new java.awt.Color(224, 242, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 121, 107)), "Chọn tác vụ: ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 121, 107))); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 121, 107));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/share.png"))); // NOI18N
        jButton2.setText("Xuất");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 121, 107));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-button.png"))); // NOI18N
        jButton1.setText("Xóa");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int r = jTable2.getSelectedRow();
        if (r != -1) {
            List<entity.ChiTietHoaDon> list = cthd_d.TimtheomaHD(dtm_2.getValueAt(r, 0).toString());
            dtm_1.setRowCount(0);
            for (entity.ChiTietHoaDon cthd : list) {
                dtm_1.addRow(new Object[]{
                    cthd.getHoaDon().getMaHD(),
                    cthd.getSanPham().getTenSP(),
                    cthd.getSoLuong(),
                    cthd.thanhTien()
                });
            }
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int r = jTable2.getSelectedRow();
        if (r != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hóa đơn này?",
                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (cthd_d.xoaHD(dtm_2.getValueAt(r, 0).toString())) {
                    if (hd_d.xoaHD(dtm_2.getValueAt(r, 0).toString())) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công");
                        dtm_2.setRowCount(0);
                        dataToTable();
                        dtm_1.setRowCount(0);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int r = jTable2.getSelectedRow();
         if(r!=-1){
             inHD(hd_d.timHD(dtm_2.getValueAt(r, 0).toString()),cthd_d.TimtheomaHD(dtm_2.getValueAt(r, 0).toString()));
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    private ChiTietHoaDon_Dao cthd_d = new ChiTietHoaDon_Dao();
    private HoaDon_Dao hd_d = new HoaDon_Dao();
    private TableModel modal_2;
    private DefaultTableModel dtm_2;
    private TableModel modal_1;
    private DefaultTableModel dtm_1;
     private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
}
