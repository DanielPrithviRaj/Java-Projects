/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import java.util.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author LENOVO
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    static int randomNumber;
    
    public Home() {
        initComponents();
        setLocationRelativeTo(null);
       // IBD_Baseline_2.main(null);
        
    }
    
    private final Set<Integer> generatedNumbers = new HashSet<>();
    private final Random random = new Random();
    public int generateUniqueFiveDigitNumber() {
        

        // Keep generating until a unique number is found
        do {
            randomNumber = 10000 + random.nextInt(90000); // Random number between 10000 and 99999
        } while (generatedNumbers.contains(randomNumber)); // Check if number already exists

        // Store the number to avoid future duplicates
        generatedNumbers.add(randomNumber);

        return randomNumber;
    }
    
private static void exportToCSV(){
        
    
        
        // Connect to the database and fetch data
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibd_form", "root", "danny");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT  base_details_1.Date,base_details_1.Patient_ID, base_details_1.Patient_Name, base_details_1.DOB, base_details_1.Phone_No, base_details_1.Email, base_details_1.Occupation, base_details_1.Residence, base_details_1.Qualification, base_details_1.Date_of_symptoms, base_details_1.Date_of_diagnosis, base_details_1.Initial_symptoms, base_details_1.ATT_use, base_details_1.Duration_of_ATT, base_details_1.TB_family_member, base_details_1.Mantoux, base_details_1.BCG_scar, base_details_1.Chest_Xray, base_details_1.QFT, base_details_1.Smoking, base_details_1.Hbsag, base_details_1.HCV_Ab, base_details_1.HIV, base_details_1.Family_history_IBD, base_details_1.Erythema_nodousum, base_details_1.Pyoderma_gangerenosum, base_details_1.Oral_ulcers, base_details_1.Deep_vein_thrombosis, base_details_1.Red_eye, base_details_1.PSC, base_details_1.Peripheral_joint_arthritis, base_details_1.Peripheral_joint_arthralgia, base_details_1.Axial_arthritis, base_details_1.Axial_arthralgia, base_details_1.Comorb_DM, base_details_1.Comorb_HT, base_details_1.Comorb_Asthma, base_details_1.Comorb_COPD, base_details_1.Comorb_IHD, base_details_1.Any_other_illness, base_details_2.Endoscopy, base_details_2.Histology, base_details_2.Radiology, base_details_2.Capsule, base_details_2.Per_op, base_details_2.Perianal_a_f_s, base_details_2.POH_Blood_transfusion, base_details_2.POH_Surgery, base_details_2.Date_Sur_perform, base_details_2.Diagnosis, base_details_2.IBD_type, base_details_2.Crohns_phenotype, base_details_2.UC_extent, base_details_2.Rx_past, base_details_2.Drugs_reaction  FROM base_details_1 JOIN base_details_2 ON base_details_1.Patient_ID = base_details_2.Patient_ID")) 
        
        {
           // Create a Workbook instance (XLSX format)
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("MySQL Data");

            // Get the column names from the ResultSet metadata
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create the header row
            Row headerRow = sheet.createRow(0);
            for (int i = 1; i <= columnCount; i++) {
                Cell cell = headerRow.createCell(i - 1);
                cell.setCellValue(metaData.getColumnName(i));
            }

            // Create rows for data
            int rowNum = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                for (int i = 1; i <= columnCount; i++) {
                    Cell cell = row.createCell(i - 1);
                    cell.setCellValue(rs.getString(i)); // Can adjust this based on data type
                }
            }

            // Write the output to a file
           /** try (FileOutputStream fileOut = new FileOutputStream("output_data.xlsx")) {
                workbook.write(fileOut);
            }

            JOptionPane.showMessageDialog(null,"Data exported to output_data.xlsx successfully!"); **/
           
            // Open JFileChooser for saving the file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Excel File");

        // Set the file filter to save .xlsx files
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Excel Files", "xlsx"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToSave = fileChooser.getSelectedFile();

            // Ensure the file has the .xlsx extension
            if (!fileToSave.getName().endsWith(".xlsx")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
            }

            // Save the workbook to the selected file
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
                workbook.write(fileOut);
                JOptionPane.showMessageDialog(null, "File saved successfully: " + fileToSave.getAbsolutePath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving the file!");
            }
        }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("IBD SYSTEM");

        jButton1.setText("IBD FORM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Export Stat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1)
                        .addGap(106, 106, 106)
                        .addComponent(jButton3))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel1)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(189, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        try {
            jInternalFrame1.setIcon(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           
           IBD_Baseline_1.main(null);
           setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       exportToCSV();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
