/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fly;

import Connection.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class PassengerInfoTable extends javax.swing.JFrame {

    /**
     * Creates new form CustomerFirstPage
     */
    public PassengerInfoTable() {
        initComponents();
        show_user();
    }

    public ArrayList<User> userList() {
        ArrayList<User> usersList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager
                    .getConnection(
                            "jdbc:sqlserver://localhost:1433;databaseName=FLY_SKY;selectMethod=cursor", "sa", "123456");

            String query1 = "SELECT * FROM PASSENGER";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query1);
            User user;
            while (rs.next()) {
                user = new User(rs.getInt("CustomerID"), rs.getString("Name"), rs.getString("Email"), rs.getString("ContactNo"));
                usersList.add(user);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        return usersList;
    }
    public void show_user()
    {
        ArrayList<User> list= userList();
        DefaultTableModel model=(DefaultTableModel)PassengerTable.getModel();
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getName();
            row[2]=list.get(i).getEmail();
            row[3]=list.get(i).getPhone();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PassengerTable = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        PassengerTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PassengerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerID", "Name", "Email", "ContactNo"
            }
        ));
        PassengerTable.setRowHeight(26);
        jScrollPane1.setViewportView(PassengerTable);
        if (PassengerTable.getColumnModel().getColumnCount() > 0) {
            PassengerTable.getColumnModel().getColumn(0).setResizable(false);
            PassengerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            PassengerTable.getColumnModel().getColumn(1).setResizable(false);
            PassengerTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 130, 1440, 402);

        BackBtn.setBackground(new java.awt.Color(255, 102, 0));
        BackBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BackBtn.setText("Back");
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
        });
        jPanel1.add(BackBtn);
        BackBtn.setBounds(40, 740, 120, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fly/CustomerFirstPage.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1440, 810);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        CustomerFirstPage cfp = new CustomerFirstPage();
        cfp.setVisible(true);
    }//GEN-LAST:event_BackBtnMouseClicked

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
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerInfoTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassengerInfoTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTable PassengerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}