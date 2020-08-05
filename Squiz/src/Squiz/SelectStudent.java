/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Squiz;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Harshit
 */
public class SelectStudent extends javax.swing.JFrame {

    /**
     * Creates new form SelectStudent
     */
    static Socket socket;
    static String username;
    public SelectStudent(Socket socket, String username) {
        initComponents();
        this.socket = socket;
        this.username = username;
        currentuser.setText(username);
         try{
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
        String[] s = {"givesubjects"};
        objectOutputStream.writeObject(s);
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String[] str = (String[]) objectInputStream.readObject( );
            ssubject.setModel(new javax.swing.DefaultComboBoxModel(str));
        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
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

        ssubject = new javax.swing.JComboBox<>();
        sqcode = new javax.swing.JComboBox<>();
        qbegin = new javax.swing.JLabel();
        sesub = new javax.swing.JLabel();
        cross = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        currentuser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ssubject.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ssubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ssubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ssubjectMouseClicked(evt);
            }
        });
        getContentPane().add(ssubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 370, 60));

        sqcode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sqcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(sqcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 346, 370, 60));

        qbegin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        qbegin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qbeginMouseClicked(evt);
            }
        });
        getContentPane().add(qbegin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 270, 60));

        sesub.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sesub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sesubMouseClicked(evt);
            }
        });
        getContentPane().add(sesub, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 240, 60));

        cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crossMouseClicked(evt);
            }
        });
        getContentPane().add(cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 50, 40));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 50, 40));

        currentuser.setBackground(new java.awt.Color(102, 102, 102));
        currentuser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentuser.setForeground(new java.awt.Color(240, 240, 240));
        currentuser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(currentuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 236, 180, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Squiz/SELECTSTUDENTSUBJECT.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 996, 598));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sesubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesubMouseClicked
        try{
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
        String[] s = {"givequizcodes",ssubject.getSelectedItem().toString()};
        objectOutputStream.writeObject(s);
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String[] str = (String[]) objectInputStream.readObject();
            sqcode.setModel(new javax.swing.DefaultComboBoxModel(str));
        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_sesubMouseClicked

    private void qbeginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qbeginMouseClicked

        String qcode = sqcode.getSelectedItem().toString();
        if(qcode!=null)
        {
            //new StudentLogin().setVisible(true);
            String s = ssubject.getSelectedItem().toString();
            new sectionStudent(socket, s, username, qcode).setVisible(true);
            //JOptionPane.showMessageDialog(null, "Next Jframe Not Visible");
            dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "No Quiz available");
        
    }//GEN-LAST:event_qbeginMouseClicked

    private void crossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crossMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_crossMouseClicked

    private void ssubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssubjectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ssubjectMouseClicked

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
            java.util.logging.Logger.getLogger(SelectStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectStudent(socket,username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cross;
    private javax.swing.JTextField currentuser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel qbegin;
    private javax.swing.JLabel sesub;
    private javax.swing.JComboBox<String> sqcode;
    private javax.swing.JComboBox<String> ssubject;
    // End of variables declaration//GEN-END:variables
}
