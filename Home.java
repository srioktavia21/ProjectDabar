/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dabar;

/**
 *
 * @author sriok
 */

import java.sql.SQLException;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.*;


public class Home extends javax.swing.JFrame {
    
    Connection conn = (Connection) Koneksi.koneksiDB();
    ArrayList<String> arrayls = new ArrayList<String>();
    
 
    /**
     * Creates new form Home
     */
    public Home() {
        this.conn = (Connection) Koneksi.koneksiDB();
        initComponents();
    }
    
    public void getData() {
        
        DefaultTableModel tabModel;
        Object[] row = {"No", "Nama Barang", "Jumlah Barang"};
        tabModel = new DefaultTableModel(null, row);
        tb_data.setModel(tabModel);
        
        try {
            arrayls.clear();
            Statement st = conn.createStatement();
            String query = "SELECT * FROM barang ORDER BY id DESC";
            ResultSet set = st.executeQuery(query);
            
            int a = 1;
            while (set.next()) {
                String nomor, nama_barang, jumlah_barang, id;
                
                id = set.getString("id");
                nomor = String.valueOf(a + tabModel.getRowCount());
                nama_barang = set.getString("Nama_Barang");
                jumlah_barang = set.getString("Jumlah_Barang");
                
                String[] data = {nomor, nama_barang, jumlah_barang};
                tabModel.addRow(data);
                arrayls.add(id.toString());
            }
        
        }catch (Exception e) {
            System.out.println (e.getMessage().toString());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        bt_login = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_AddData = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA STOK BARANG PT SAMUDRA ANGKASA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 430, -1));

        bt_login.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bt_login.setText("LOGIN");
        bt_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_loginMouseClicked(evt);
            }
        });
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        getContentPane().add(bt_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_dataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_data);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 380, 140));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));

        btn_AddData.setText("Add Data");
        btn_AddData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddDataActionPerformed(evt);
            }
        });
        jPanel1.add(btn_AddData);

        btn_refresh.setText("Refresh");
        jPanel1.add(btn_refresh);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 210, 220));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Dabar/bg3.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        DefaultTableModel tabMode;
        Object [] row = { "No", "Nama Barang", "Jumlah Barang"};
        tabMode = new DefaultTableModel (null, row);
        tb_data.setModel(tabMode);
        
        try {
             Connection conn = (Connection) Dabar.Koneksi.koneksiDB();
             Statement st = conn.createStatement();
             String sql = "SELECT * From barang ";
             ResultSet set = st.executeQuery(sql);
             
             int a = 1 ;
                 while (set.next()) {
                      String Nomor    = String.valueOf(a + tabMode.getRowCount());
                      String Nabar    = set.getString("Nama_barang");
                      String Jumlah   = set.getString("Jumlah_barang");
                      
                      String [] data = {Nomor, Nabar, Jumlah};
                      tabMode.addRow(data);
                 }
        }
        catch ( SQLException  |  HeadlessException e ){
        }
        
    }//GEN-LAST:event_formWindowActivated

    private void tb_dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dataMouseClicked
        // TODO add your handling code here:
        int i = tb_data.getSelectedRow();
        if (i > -1) {
            String id = arrayls.get(i);
            Action fAction = new Action (new Home(), "edit", id);
            fAction.tf_nama_barang.setText(tb_data.getValueAt(i,1).toString());
            fAction.tf_jumlah_barang.setText(tb_data.getValueAt(i,2).toString());
            fAction.setVisible(true);
        }
        
    }//GEN-LAST:event_tb_dataMouseClicked

    private void btn_AddDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddDataActionPerformed
        // TODO add your handling code here:
        Action fAction = new Action(new Home(), "add", "0");
        fAction.setVisible(true);
    }//GEN-LAST:event_btn_AddDataActionPerformed

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_loginActionPerformed

    private void bt_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_loginMouseClicked
        // TODO add your handling code here:
        Login hal = new Login();
        hal.setVisible(true);
        dispose();
     
    }//GEN-LAST:event_bt_loginMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bt_login;
    private javax.swing.JButton btn_AddData;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_data;
    // End of variables declaration//GEN-END:variables
}
