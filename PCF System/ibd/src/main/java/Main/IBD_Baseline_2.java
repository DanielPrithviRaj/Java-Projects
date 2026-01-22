/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;


import static Main.IBD_Baseline_1.*;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author LENOVO
 */
public class IBD_Baseline_2 extends javax.swing.JFrame {

    /**
     * Creates new form IBD_Baseline_2
     */
    
    static String Combobox1, Combobox3, Combobox4, Combobox5, Combobox6, Combobox7, tpmt_activity, nudt15, date_sur, date_sur1, date_sur2, past_drug;
    static String endoscopyCheckboxes,histologyCheckboxes,radiologyCheckboxes,capsuleCheckboxes,preopCheckboxes,phenotypeCheckboxes; 
    static int selectedMonth3, selectedMonth2, selectedMonth1, selectedYear1, selectedYear2, selectedYear3 ;
    static String str =" ";
            
    public IBD_Baseline_2() {
        initComponents();
        setLocationRelativeTo(null);
        
        month1.setVisible(false);
        year1.setVisible(false);
        history1.setVisible(false); // past history data
        
        month2.setVisible(false);
        year2.setVisible(false);
        history2.setVisible(false);
        
        month3.setVisible(false);
        year3.setVisible(false);
        history3.setVisible(false);
        
        other_data.setEditable(false);
        past_tx.setEditable(false);
        undo_button.setVisible(false);
        
        JScrollBar verticalScrollBar = Baseline_2_Scroll.getVerticalScrollBar();
            verticalScrollBar.setUnitIncrement(20);
            verticalScrollBar.setBlockIncrement(100); 
            jTextArea1.setEditable(false);
            
            ButtonGroup group = new ButtonGroup();
            group.add(yes);
            group.add(no);
            
            // Set the default state (disable editing by default)
        jTextArea2.setEditable(false);
        no.setSelected(true); // Initially disable editing

        // Add ActionListener to enable button
        yes.addActionListener((ActionEvent e) -> {
            jTextArea2.setEditable(true);
        });

        // Add ActionListener to disable button
        no.addActionListener((ActionEvent e) -> {
            jTextArea2.setEditable(false);
        });
        
        finish.addActionListener((ActionEvent e) -> {
            // Only save data if the radio button is selected
            if (yes.isSelected() && !jTextArea2.getText().trim().isEmpty()) {
                past_drug = jTextArea2.getText();
            } else {
                past_drug = "";
            }
        });
    }
    
    
    private void exportToPDF() {
        //String pdfPath = "form_output.pdf";

        try (PdfWriter writer = new PdfWriter(pt_id)) {
            PdfDocument pdf = new PdfDocument(writer);
            // Add Title
            try (Document document = new Document(pdf)) {
                // Add Title
                PdfFont italicFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_OBLIQUE);
        Paragraph paragraph2 = new Paragraph("IBD BASELINE DETAILS(to be filled only once for each patient)").setTextAlignment(TextAlignment.CENTER)
                .setFont(italicFont)                                // Set italic font
                .setFontSize(14);
              
              document.add(paragraph2);
                
                 document.add(new Paragraph("Patient ID: " + pt_id +"                                                           " + "Date: " + simp_date));
                 
                 // document.add(new Paragraph("Patient ID: " + pt_id));
               
                 document.add(new Paragraph("Patient Name: " + data));
                         
                 document.add(new Paragraph("DOB: " + data1));
             
                 document.add(new Paragraph("Phone Number: " + data2));
                 
                 document.add(new Paragraph("Email ID:" + data3));
             
                 document.add(new Paragraph("Occupation:" + data4));
               
                 document.add(new Paragraph("Residence:" + data5));
                
                 document.add(new Paragraph("Education:" + value));
                 
                 document.add(new Paragraph("\nMonth/year of onset of symptoms:" + value1));
                
                 document.add(new Paragraph("Month/year of diagnosis:" + value2));

                 document.add(new Paragraph("\nPatient's initial symptoms:" + selectedCheckboxes));
                
                 document.add(new Paragraph("ATT use:" + comboBox1 +"                            "+"Duration of ATT(months):" + durationATT));
                
                 document.add(new Paragraph("TB in any family member:" + comboBox2));
                 
                 document.add(new Paragraph("Mantoux:" + comboBox3 +"                   "+"Smoking:" + comboBox4));
                 
                 document.add(new Paragraph("BCG scar:" + comboBox5 +"                  "+"HbsAg:" + comboBox6));
                 
                 document.add(new Paragraph("Chest X-ray:" + comboBox7 +"                   "+"HCV Ab:" + comboBox8));
                 
                 document.add(new Paragraph("QFT:" + comboBox9 +"                   "+"HIV:" + comboBox10));
                 
                 
               
                 document.add(new Paragraph("\nFamily history of IBD:" + comboBox11));
                
                 document.add(new Paragraph("EXTRA INTESTINAL MANIFESTATIONS:-"));
                
                 document.add(new Paragraph("Erythema nodousum:" + comboBox12 +"                    "+"Pyoderma gangerenosum:" + comboBox13));
                 
                 document.add(new Paragraph("Oral ulcers:" + comboBox14 +"                  "+"Deep vein thrombosis:" + comboBox15));
                 
                 document.add(new Paragraph("Red eye:" + comboBox16 +"                  "+"PSC:" + comboBox17));
                 
                 document.add(new Paragraph("Peripheral joint arthritis:" + comboBox18 +"                   "+"Peripheral joint arthralgia:" + comboBox19));
                 
                 document.add(new Paragraph("Axial arthritis:" + comboBox20 +"                  "+"Axial arthralgia:" + comboBox21));         
        
                
                 
                 document.add(new Paragraph("Comorbs:- " + "  " + "DM:" + comboBox22 + "    " + "HT:" + comboBox23 + "      " + "Asthma:" + comboBox24 + "      " + "COPD:" + comboBox25 + "    " +"IHD:" + comboBox26));                              
                
                 //document.add(new Paragraph("DM:" + comboBox22 + "  " + "HT:" + comboBox23 + "  " + "Asthma:" + comboBox24 + "  " + "COPD:" + comboBox25 + "  " +"IHD:" + comboBox26));
                  
                      
                 document.add(new Paragraph("Any other significant illness:" + other_illness));
                 
                 //Page 2
                 
                 document.add(new Paragraph("\nExtent of involvement (use pre-treatment / earliest reports), mark box if segment is involved. To decide whether there is histological evidence of involment of a segment, look for the term MODERATE CHRONIC inflamation in the biopsy report (mild and acute inflamation are not significant)"));
                 
                document.add(new Paragraph("\nEndoscopy:" + "  " + endoscopyCheckboxes)); 
                document.add(new Paragraph("Histology:" + "  " + histologyCheckboxes));
                document.add(new Paragraph("Radiology:" + "  " +radiologyCheckboxes));
                document.add(new Paragraph("Capsule:" + "  " +capsuleCheckboxes));
                document.add(new Paragraph("Per-op:" + "  " +preopCheckboxes));
                
                document.add(new Paragraph("\nPerianal abscess / fistula / stricture:" + Combobox1 ));
                
                document.add(new Paragraph("\nPast history of blood transfusion:" + Combobox3));
                
                document.add(new Paragraph("Past history of surger:" + Combobox4));
                
                document.add(new Paragraph("\nDate & Surgery performed 1:" + date_sur));
                 document.add(new Paragraph("\nDate & Surgery performed 2:" + date_sur1));
                  document.add(new Paragraph("\nDate & Surgery performed 3:" + date_sur2));
                
                document.add(new Paragraph("\nDiagnosis:"));
                
                document.add(new Paragraph("IBD type:" + Combobox5));
                
                document.add(new Paragraph("Crohn's phenotype:" + phenotypeCheckboxes));
                
                document.add(new Paragraph("Ulcerative colitis extent:" + Combobox6));
                
                document.add(new Paragraph("Treatments received in the past:" + Combobox7));
                
                document.add(new Paragraph("TPMT activity:" + tpmt_activity));
                
                document.add(new Paragraph("NUDT15 c.415C>T:" + nudt15));
                
                document.add(new Paragraph("Any past adverse reaction to drugs:" + past_drug));
            }

            // Notify the user
            JOptionPane.showMessageDialog(null, "PDF exported successfully to " + pt_id + "IBDform.pdf ");
           // setState(JFrame.ICONIFIED);
            Home.main(null);
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error exporting PDF.");
           // IBD_Baseline_2.setDefaultLookAndFeelDecorated(false);
            Home.main(null);
        }
    }
    
    public static void insertMultipleRecords(List<List<String>> records) {
        String insertSQL = "INSERT INTO base_details_2 (Patient_ID,Endoscopy,Histology,Radiology,Capsule,Per_op,Perianal_a_f_s,POH_Blood_transfusion,POH_Surgery,Date_Sur_perform,Date_Sur_perform1,Date_Sur_perform2,IBD_type,Crohns_phenotype,UC_extent,Rx_past,TPMT_activity,NUDT,Drugs_reaction) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibd_form", "root", "danny");
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Disable auto-commit for batch processing
            connection.setAutoCommit(false);

            for (List<String> record : records) {
                preparedStatement.setString(1, record.get(0)); 
                preparedStatement.setString(2, record.get(1)); 
                preparedStatement.setString(3, record.get(2));
                preparedStatement.setString(4, record.get(3)); 
                preparedStatement.setString(5, record.get(4)); 
                preparedStatement.setString(6, record.get(5)); 
                preparedStatement.setString(7, record.get(6)); 
                preparedStatement.setString(8, record.get(7)); 
                
                preparedStatement.setString(9, record.get(8)); 
                preparedStatement.setString(10, record.get(9)); 
                preparedStatement.setString(11, record.get(10)); 
                preparedStatement.setString(12, record.get(11));
                preparedStatement.setString(13, record.get(12));
                preparedStatement.setString(14, record.get(13));
                preparedStatement.setString(15, record.get(14));
                preparedStatement.setString(16, record.get(15));
                preparedStatement.setString(17, record.get(16));
                
                preparedStatement.setString(18, record.get(17));
                preparedStatement.setString(19, record.get(18));
                
             //   preparedStatement.setString(20, record.get(19));
                
                
                
                
                
                
                preparedStatement.addBatch(); // Add to batch
            }

            int[] results = preparedStatement.executeBatch(); // Execute batch insert
            connection.commit(); // Commit the transaction
            //JOptionPane.showMessageDialog(null, "Data saved successfully!");  
            System.out.println("Inserted data: " + results.length);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        Baseline_2_Scroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mouth0 = new javax.swing.JCheckBox();
        mouth1 = new javax.swing.JCheckBox();
        mouth2 = new javax.swing.JCheckBox();
        mouth3 = new javax.swing.JCheckBox();
        mouth4 = new javax.swing.JCheckBox();
        esophagus0 = new javax.swing.JCheckBox();
        esophagus1 = new javax.swing.JCheckBox();
        esophagus2 = new javax.swing.JCheckBox();
        esophagus3 = new javax.swing.JCheckBox();
        esophagus4 = new javax.swing.JCheckBox();
        stomach0 = new javax.swing.JCheckBox();
        stomach1 = new javax.swing.JCheckBox();
        stomach2 = new javax.swing.JCheckBox();
        stomach3 = new javax.swing.JCheckBox();
        stomach4 = new javax.swing.JCheckBox();
        duodenum0 = new javax.swing.JCheckBox();
        duodenum1 = new javax.swing.JCheckBox();
        duodenum2 = new javax.swing.JCheckBox();
        duodenum3 = new javax.swing.JCheckBox();
        duodenum4 = new javax.swing.JCheckBox();
        jejunum0 = new javax.swing.JCheckBox();
        jejunum1 = new javax.swing.JCheckBox();
        jejunum2 = new javax.swing.JCheckBox();
        jejunum3 = new javax.swing.JCheckBox();
        jejunum4 = new javax.swing.JCheckBox();
        ileum0 = new javax.swing.JCheckBox();
        ileum1 = new javax.swing.JCheckBox();
        ileum2 = new javax.swing.JCheckBox();
        ileum3 = new javax.swing.JCheckBox();
        ileum4 = new javax.swing.JCheckBox();
        icvalve0 = new javax.swing.JCheckBox();
        icvalve1 = new javax.swing.JCheckBox();
        icvalve2 = new javax.swing.JCheckBox();
        icvalve3 = new javax.swing.JCheckBox();
        icvalve4 = new javax.swing.JCheckBox();
        cecum0 = new javax.swing.JCheckBox();
        cecum1 = new javax.swing.JCheckBox();
        cecum2 = new javax.swing.JCheckBox();
        cecum3 = new javax.swing.JCheckBox();
        cecum4 = new javax.swing.JCheckBox();
        ascending0 = new javax.swing.JCheckBox();
        ascending1 = new javax.swing.JCheckBox();
        ascending2 = new javax.swing.JCheckBox();
        ascending3 = new javax.swing.JCheckBox();
        ascending4 = new javax.swing.JCheckBox();
        transverse0 = new javax.swing.JCheckBox();
        transverse1 = new javax.swing.JCheckBox();
        transverse2 = new javax.swing.JCheckBox();
        transverse3 = new javax.swing.JCheckBox();
        transverse4 = new javax.swing.JCheckBox();
        descending0 = new javax.swing.JCheckBox();
        descending1 = new javax.swing.JCheckBox();
        descending2 = new javax.swing.JCheckBox();
        descending3 = new javax.swing.JCheckBox();
        descending4 = new javax.swing.JCheckBox();
        sigmoid4 = new javax.swing.JCheckBox();
        rectum4 = new javax.swing.JCheckBox();
        rectum3 = new javax.swing.JCheckBox();
        sigmoid3 = new javax.swing.JCheckBox();
        sigmoid2 = new javax.swing.JCheckBox();
        rectum2 = new javax.swing.JCheckBox();
        sigmoid1 = new javax.swing.JCheckBox();
        rectum1 = new javax.swing.JCheckBox();
        rectum0 = new javax.swing.JCheckBox();
        sigmoid0 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ibd_other = new javax.swing.JCheckBox();
        other_data = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ulcer_extent = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        tx_re_past = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        yes = new javax.swing.JRadioButton();
        no = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        finish = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        tx_checkbox = new javax.swing.JCheckBox();
        past_tx = new javax.swing.JTextField();
        ibd_type = new javax.swing.JComboBox<>();
        luminal = new javax.swing.JCheckBox();
        stricturing = new javax.swing.JCheckBox();
        penetrating = new javax.swing.JCheckBox();
        perianal = new javax.swing.JCheckBox();
        month1 = new com.toedter.calendar.JMonthChooser();
        year1 = new com.toedter.calendar.JYearChooser();
        history1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nudt = new javax.swing.JComboBox<>();
        tpmt = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        undo_button = new javax.swing.JButton();
        history2 = new javax.swing.JTextField();
        month2 = new com.toedter.calendar.JMonthChooser();
        year2 = new com.toedter.calendar.JYearChooser();
        year3 = new com.toedter.calendar.JYearChooser();
        history3 = new javax.swing.JTextField();
        month3 = new com.toedter.calendar.JMonthChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });

        Baseline_2_Scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        Baseline_2_Scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaption);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Extent of involvement (use pre-treatment / earliest reports), mark box if segment is involved. To decide whether there is\nhistological evidence of involment of a segment, look for the term MODERATE CHRONIC inflamation in the biopsy \nreport (mild and acute inflamation are not significant)");
        jScrollPane3.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 23, 663, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ENDOSCOPY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 122, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("HISTOLOGY");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 122, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("RADIOLOGY");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 122, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("CAPSULE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 122, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("PER-OP");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 122, -1, -1));

        mouth0.setText("Mouth");
        jPanel1.add(mouth0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 157, 85, -1));

        mouth1.setText("Mouth");
        jPanel1.add(mouth1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 157, 85, -1));

        mouth2.setText("Mouth");
        jPanel1.add(mouth2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 157, 85, -1));

        mouth3.setText("Mouth");
        jPanel1.add(mouth3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 157, 85, -1));

        mouth4.setText("Mouth");
        jPanel1.add(mouth4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 157, 85, -1));

        esophagus0.setText("Esophagus");
        esophagus0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esophagus0ActionPerformed(evt);
            }
        });
        jPanel1.add(esophagus0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 195, 85, -1));

        esophagus1.setText("Esophagus");
        esophagus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esophagus1ActionPerformed(evt);
            }
        });
        jPanel1.add(esophagus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 195, 85, -1));

        esophagus2.setText("Esophagus");
        esophagus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esophagus2ActionPerformed(evt);
            }
        });
        jPanel1.add(esophagus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 195, 85, -1));

        esophagus3.setText("Esophagus");
        esophagus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esophagus3ActionPerformed(evt);
            }
        });
        jPanel1.add(esophagus3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 195, 85, -1));

        esophagus4.setText("Esophagus");
        esophagus4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esophagus4ActionPerformed(evt);
            }
        });
        jPanel1.add(esophagus4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 195, 85, -1));

        stomach0.setText("Stomach");
        jPanel1.add(stomach0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 233, 85, -1));

        stomach1.setText("Stomach");
        jPanel1.add(stomach1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 233, 85, -1));

        stomach2.setText("Stomach");
        jPanel1.add(stomach2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 233, 85, -1));

        stomach3.setText("Stomach");
        jPanel1.add(stomach3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 233, 85, -1));

        stomach4.setText("Stomach");
        jPanel1.add(stomach4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 233, 85, -1));

        duodenum0.setText("Duodenum");
        jPanel1.add(duodenum0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 271, 85, -1));

        duodenum1.setText("Duodenum");
        jPanel1.add(duodenum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 271, 85, -1));

        duodenum2.setText("Duodenum");
        jPanel1.add(duodenum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 271, 85, -1));

        duodenum3.setText("Duodenum");
        jPanel1.add(duodenum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 271, 85, -1));

        duodenum4.setText("Duodenum");
        jPanel1.add(duodenum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 271, 85, -1));

        jejunum0.setText("Jejunum");
        jPanel1.add(jejunum0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 309, 85, -1));

        jejunum1.setText("Jejunum");
        jPanel1.add(jejunum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 309, 85, -1));

        jejunum2.setText("Jejunum");
        jPanel1.add(jejunum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 309, 85, -1));

        jejunum3.setText("Jejunum");
        jPanel1.add(jejunum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 309, 85, -1));

        jejunum4.setText("Jejunum");
        jPanel1.add(jejunum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 309, 85, -1));

        ileum0.setText("Ileum");
        jPanel1.add(ileum0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 347, 85, -1));

        ileum1.setText("Ileum");
        jPanel1.add(ileum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 347, 85, -1));

        ileum2.setText("Ileum");
        jPanel1.add(ileum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 347, 85, -1));

        ileum3.setText("Ileum");
        jPanel1.add(ileum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 347, 85, -1));

        ileum4.setText("Ileum");
        jPanel1.add(ileum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 347, 85, -1));

        icvalve0.setText("IC valve");
        jPanel1.add(icvalve0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 385, 85, -1));

        icvalve1.setText("IC valve");
        jPanel1.add(icvalve1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 385, 85, -1));

        icvalve2.setText("IC valve");
        jPanel1.add(icvalve2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 385, 85, -1));

        icvalve3.setText("IC valve");
        jPanel1.add(icvalve3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 385, 85, -1));

        icvalve4.setText("IC valve");
        jPanel1.add(icvalve4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 385, 85, -1));

        cecum0.setText("Cecum");
        jPanel1.add(cecum0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 423, 85, -1));

        cecum1.setText("Cecum");
        jPanel1.add(cecum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 423, 85, -1));

        cecum2.setText("Cecum");
        jPanel1.add(cecum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 423, 85, -1));

        cecum3.setText("Cecum");
        jPanel1.add(cecum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 423, 85, -1));

        cecum4.setText("Cecum");
        jPanel1.add(cecum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 423, 85, -1));

        ascending0.setText("Ascending");
        jPanel1.add(ascending0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 461, 85, -1));

        ascending1.setText("Ascending");
        jPanel1.add(ascending1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 461, 85, -1));

        ascending2.setText("Ascending");
        jPanel1.add(ascending2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 461, 85, -1));

        ascending3.setText("Ascending");
        jPanel1.add(ascending3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 461, 85, -1));

        ascending4.setText("Ascending");
        jPanel1.add(ascending4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 461, 85, -1));

        transverse0.setText("Transverse");
        jPanel1.add(transverse0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 499, 91, -1));

        transverse1.setText("Transverse");
        jPanel1.add(transverse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 499, 91, -1));

        transverse2.setText("Transverse");
        jPanel1.add(transverse2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 499, 91, -1));

        transverse3.setText("Transverse");
        jPanel1.add(transverse3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 499, 91, -1));

        transverse4.setText("Transverse");
        jPanel1.add(transverse4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 499, 91, -1));

        descending0.setText("Descending");
        jPanel1.add(descending0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 537, 91, -1));

        descending1.setText("Descending");
        jPanel1.add(descending1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 537, 91, -1));

        descending2.setText("Descending");
        jPanel1.add(descending2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 537, 91, -1));

        descending3.setText("Descending");
        jPanel1.add(descending3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 537, 91, -1));

        descending4.setText("Descending");
        jPanel1.add(descending4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 537, 91, -1));

        sigmoid4.setText("Sigmoid");
        jPanel1.add(sigmoid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 575, 91, -1));

        rectum4.setText("Rectum");
        rectum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectum4ActionPerformed(evt);
            }
        });
        jPanel1.add(rectum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 613, 91, -1));

        rectum3.setText("Rectum");
        rectum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectum3ActionPerformed(evt);
            }
        });
        jPanel1.add(rectum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 613, 91, -1));

        sigmoid3.setText("Sigmoid");
        jPanel1.add(sigmoid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 575, 91, -1));

        sigmoid2.setText("Sigmoid");
        jPanel1.add(sigmoid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 575, 91, -1));

        rectum2.setText("Rectum");
        rectum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectum2ActionPerformed(evt);
            }
        });
        jPanel1.add(rectum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 613, 91, -1));

        sigmoid1.setText("Sigmoid");
        jPanel1.add(sigmoid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 575, 91, -1));

        rectum1.setText("Rectum");
        rectum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectum1ActionPerformed(evt);
            }
        });
        jPanel1.add(rectum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 613, 91, -1));

        rectum0.setText("Rectum");
        rectum0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectum0ActionPerformed(evt);
            }
        });
        jPanel1.add(rectum0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 613, 91, -1));

        sigmoid0.setText("Sigmoid");
        jPanel1.add(sigmoid0, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 575, 91, -1));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes ", "No" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 699, 80, -1));

        jLabel8.setText("Past history of blood transfusion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 702, -1, -1));

        jLabel9.setText("Past history of surgery");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 736, -1, -1));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes", "No" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 733, -1, -1));

        jLabel10.setText("Past history of surgery (relevant to IBD) in chronological order:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 770, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Diagnosis:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 920, -1, -1));

        ibd_other.setText("Other");
        ibd_other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibd_otherActionPerformed(evt);
            }
        });
        jPanel1.add(ibd_other, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 950, 60, -1));
        jPanel1.add(other_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 950, 250, -1));

        jLabel15.setText("IBD type");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 950, 54, -1));

        jLabel16.setText("Crohn's phenotype (select one/more)");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 990, -1, -1));

        jLabel17.setText("Ulcerative colitis extent");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1030, -1, -1));

        ulcer_extent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ulcer_extent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Proctitis(<18cm)", "Procto-sigmoiditis", "Left-sided Extensive (>splenic flexure)", "Pancolitis (>heptic flexure)" }));
        jPanel1.add(ulcer_extent, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1030, 250, -1));

        jLabel18.setText("Treatments received in the past");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1070, -1, -1));

        tx_re_past.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tx_re_past.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "5-ASA ", "Thiopurine ", "Methotrexate", "MMF", "Steroid", "EEN", "Antibiotics", "Biologicals", "Small molecule" }));
        jPanel1.add(tx_re_past, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1070, -1, -1));

        jLabel19.setText("Any past adverse reaction to drugs");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1190, -1, -1));

        yes.setText("Yes");
        jPanel1.add(yes, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1190, -1, -1));

        no.setText("No");
        jPanel1.add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1190, -1, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 1190, 308, 80));

        finish.setBackground(new java.awt.Color(204, 255, 204));
        finish.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        finish.setText("Finish");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });
        jPanel1.add(finish, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 1290, -1, -1));

        jLabel3.setText("Perianal abscess / fistula / stricture");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 190, 20));

        jComboBox8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));
        jPanel1.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, -1, -1));

        tx_checkbox.setText("Other");
        tx_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_checkboxActionPerformed(evt);
            }
        });
        jPanel1.add(tx_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 1070, -1, -1));
        jPanel1.add(past_tx, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 1070, 190, -1));

        ibd_type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ibd_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Crohn's ", "Ulcerative colitis", "Indeterminate colitis" }));
        jPanel1.add(ibd_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 950, -1, -1));

        luminal.setText("Luminal");
        jPanel1.add(luminal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 990, 80, -1));

        stricturing.setText("Stricturing ");
        jPanel1.add(stricturing, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 990, 90, -1));

        penetrating.setText("Penetrating");
        jPanel1.add(penetrating, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 990, 100, -1));

        perianal.setText("Perianal");
        jPanel1.add(perianal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 990, -1, -1));
        jPanel1.add(month1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 800, 130, -1));
        jPanel1.add(year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 800, 70, -1));
        jPanel1.add(history1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 800, 350, -1));

        jLabel1.setText("TPMT activity");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1110, 90, -1));

        jLabel11.setText("NUDT15 c.415C>T");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1150, 110, 20));

        nudt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nudt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Wild ", "Heterozygous", "Homozygous" }));
        jPanel1.add(nudt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 1150, -1, -1));
        jPanel1.add(tpmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 1110, 50, -1));

        add_button.setText("ADD");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(add_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 770, 60, -1));

        undo_button.setText("UNDO");
        undo_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undo_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(undo_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 770, 70, -1));
        jPanel1.add(history2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 840, 350, -1));
        jPanel1.add(month2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 840, -1, -1));
        jPanel1.add(year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 840, 70, -1));
        jPanel1.add(year3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 880, 70, -1));
        jPanel1.add(history3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 880, 350, -1));
        jPanel1.add(month3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 880, -1, -1));

        Baseline_2_Scroll.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Baseline_2_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Baseline_2_Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseWheelMoved

    private void esophagus0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esophagus0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esophagus0ActionPerformed

    private void esophagus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esophagus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esophagus1ActionPerformed

    private void esophagus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esophagus2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esophagus2ActionPerformed

    private void esophagus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esophagus3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esophagus3ActionPerformed

    private void esophagus4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esophagus4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_esophagus4ActionPerformed

    private void rectum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectum4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rectum4ActionPerformed

    private void rectum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectum3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rectum3ActionPerformed

    private void rectum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectum2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rectum2ActionPerformed

    private void rectum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rectum1ActionPerformed

    private void rectum0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectum0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rectum0ActionPerformed

    private void ibd_otherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibd_otherActionPerformed
        other_data.setEditable(ibd_other.isSelected());
    }//GEN-LAST:event_ibd_otherActionPerformed

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
     
        try{
       // pt_id = "Aa12345";
        
        //Endoscopy data
        endoscopyCheckboxes = "";
        if (mouth0.isSelected()) endoscopyCheckboxes += mouth0.getText() + ",";            
        if (esophagus0.isSelected()) endoscopyCheckboxes += esophagus0.getText() + ",";
        if (stomach0.isSelected()) endoscopyCheckboxes += stomach0.getText() + ",";
        if (duodenum0.isSelected()) endoscopyCheckboxes += duodenum0.getText() + ",";
        if (jejunum0.isSelected()) endoscopyCheckboxes += jejunum0.getText() + ",";
        if (ileum0.isSelected()) endoscopyCheckboxes += ileum0.getText() + ",";
        if (icvalve0.isSelected()) endoscopyCheckboxes += icvalve0.getText() + ",";
        if (cecum0.isSelected()) endoscopyCheckboxes += cecum0.getText() + ",";
        if (ascending0.isSelected()) endoscopyCheckboxes += ascending0.getText() + ",";
        if (transverse0.isSelected()) endoscopyCheckboxes += transverse0.getText() + ",";
        if (descending0.isSelected()) endoscopyCheckboxes += descending0.getText() + ",";
        if (sigmoid0.isSelected()) endoscopyCheckboxes += sigmoid0.getText() + ",";
        if (rectum0.isSelected()) endoscopyCheckboxes += rectum0.getText() + ",";

        // Remove trailing comma
        if (endoscopyCheckboxes.endsWith(",")) {
            endoscopyCheckboxes = endoscopyCheckboxes.substring(0, endoscopyCheckboxes.length() - 1);
        }
        
        
        //Histology data
        histologyCheckboxes = "";
        if (mouth1.isSelected()) histologyCheckboxes += mouth1.getText() + ",";            
        if (esophagus1.isSelected()) histologyCheckboxes += esophagus1.getText() + ",";
        if (stomach1.isSelected()) histologyCheckboxes += stomach1.getText() + ",";
        if (duodenum1.isSelected()) histologyCheckboxes += duodenum1.getText() + ",";
        if (jejunum1.isSelected()) histologyCheckboxes += jejunum1.getText() + ",";
        if (ileum1.isSelected()) histologyCheckboxes += ileum1.getText() + ",";
        if (icvalve1.isSelected()) histologyCheckboxes += icvalve1.getText() + ",";
        if (cecum1.isSelected()) histologyCheckboxes += cecum1.getText() + ",";
        if (ascending1.isSelected()) histologyCheckboxes += ascending1.getText() + ",";
        if (transverse1.isSelected()) histologyCheckboxes += transverse1.getText() + ",";
        if (descending1.isSelected()) histologyCheckboxes += descending1.getText() + ",";
        if (sigmoid1.isSelected()) histologyCheckboxes += sigmoid1.getText() + ",";
        if (rectum1.isSelected()) histologyCheckboxes += rectum1.getText() + ",";

        // Remove trailing comma
        if (histologyCheckboxes.endsWith(",")) {
            histologyCheckboxes = histologyCheckboxes.substring(0, histologyCheckboxes.length() - 1);
        }
        
        
        //Radiology data
        radiologyCheckboxes = "";
        if (mouth2.isSelected()) radiologyCheckboxes += mouth2.getText() + ",";            
        if (esophagus2.isSelected()) radiologyCheckboxes += esophagus2.getText() + ",";
        if (stomach2.isSelected()) radiologyCheckboxes += stomach2.getText() + ",";
        if (duodenum2.isSelected()) radiologyCheckboxes += duodenum2.getText() + ",";
        if (jejunum2.isSelected()) radiologyCheckboxes += jejunum2.getText() + ",";
        if (ileum2.isSelected()) radiologyCheckboxes += ileum2.getText() + ",";
        if (icvalve2.isSelected()) radiologyCheckboxes += icvalve2.getText() + ",";
        if (cecum2.isSelected()) radiologyCheckboxes += cecum2.getText() + ",";
        if (ascending2.isSelected()) radiologyCheckboxes += ascending2.getText() + ",";
        if (transverse2.isSelected()) radiologyCheckboxes += transverse2.getText() + ",";
        if (descending2.isSelected()) radiologyCheckboxes += descending2.getText() + ",";
        if (sigmoid2.isSelected()) radiologyCheckboxes += sigmoid2.getText() + ",";
        if (rectum2.isSelected()) radiologyCheckboxes += rectum2.getText() + ",";

        // Remove trailing comma
        if (radiologyCheckboxes.endsWith(",")) {
            radiologyCheckboxes = radiologyCheckboxes.substring(0, radiologyCheckboxes.length() - 1);
        }
        
        
        //Capsule data
        capsuleCheckboxes = "";
        if (mouth3.isSelected()) capsuleCheckboxes += mouth3.getText() + ",";            
        if (esophagus3.isSelected()) capsuleCheckboxes += esophagus3.getText() + ",";
        if (stomach3.isSelected()) capsuleCheckboxes += stomach3.getText() + ",";
        if (duodenum3.isSelected()) capsuleCheckboxes += duodenum3.getText() + ",";
        if (jejunum3.isSelected()) capsuleCheckboxes += jejunum3.getText() + ",";
        if (ileum3.isSelected()) capsuleCheckboxes += ileum3.getText() + ",";
        if (icvalve3.isSelected()) capsuleCheckboxes += icvalve3.getText() + ",";
        if (cecum3.isSelected()) capsuleCheckboxes += cecum3.getText() + ",";
        if (ascending3.isSelected()) capsuleCheckboxes += ascending3.getText() + ",";
        if (transverse3.isSelected()) capsuleCheckboxes += transverse3.getText() + ",";
        if (descending3.isSelected()) capsuleCheckboxes += descending3.getText() + ",";
        if (sigmoid3.isSelected()) capsuleCheckboxes += sigmoid3.getText() + ",";
        if (rectum3.isSelected()) capsuleCheckboxes += rectum3.getText() + ",";

        // Remove trailing comma
        if (capsuleCheckboxes.endsWith(",")) {
            capsuleCheckboxes = capsuleCheckboxes.substring(0, capsuleCheckboxes.length() - 1);
        }
        
        //pre-op data
        preopCheckboxes = "";
        if (mouth4.isSelected()) preopCheckboxes += mouth4.getText() + ",";            
        if (esophagus4.isSelected()) preopCheckboxes += esophagus4.getText() + ",";
        if (stomach4.isSelected()) preopCheckboxes += stomach4.getText() + ",";
        if (duodenum4.isSelected()) preopCheckboxes += duodenum4.getText() + ",";
        if (jejunum4.isSelected()) preopCheckboxes += jejunum4.getText() + ",";
        if (ileum4.isSelected()) preopCheckboxes += ileum4.getText() + ",";
        if (icvalve4.isSelected()) preopCheckboxes += icvalve4.getText() + ",";
        if (cecum4.isSelected()) preopCheckboxes += cecum4.getText() + ",";
        if (ascending4.isSelected()) preopCheckboxes += ascending4.getText() + ",";
        if (transverse4.isSelected()) preopCheckboxes += transverse4.getText() + ",";
        if (descending4.isSelected()) preopCheckboxes += descending4.getText() + ",";
        if (sigmoid4.isSelected()) preopCheckboxes += sigmoid4.getText() + ",";
        if (rectum4.isSelected()) preopCheckboxes += rectum4.getText() + ",";

        // Remove trailing comma
        if (preopCheckboxes.endsWith(",")) {
            preopCheckboxes = preopCheckboxes.substring(0, preopCheckboxes.length() - 1);
        }
        
       
        Combobox1 = (String) jComboBox8.getSelectedItem();
       // Combobox2 = (String) jComboBox1.getSelectedItem();
        Combobox3 = (String) jComboBox2.getSelectedItem();
        Combobox4 = (String) jComboBox3.getSelectedItem();
        
        
         if ("No".equals(Combobox4)) {
       // date_sur = history1.getText();
           selectedMonth1 = 0; 
           selectedYear1 = 0;
           date_sur = String.format("(%04d-%02d)" + history1.getText(), selectedYear1, selectedMonth1 );
         }else {
             
             selectedMonth1 = month1.getMonth() + 1; // Months are 0-indexed
            selectedYear1 = year1.getYear();
           
           date_sur = String.format("(%04d-%02d)" + history1.getText(), selectedYear1, selectedMonth1 );
          }
           
          
        if (history2.getText().isEmpty()) {
            selectedMonth2 = 0; 
           selectedYear2 = 0;
           
        date_sur1 = String.format("(%04d-%02d)" + history2.getText(), selectedYear2, selectedMonth2);
        }
        else{
            selectedMonth2 = month2.getMonth() + 1; // Months are 0-indexed
           selectedYear2 = year2.getYear();
           
           date_sur1 = String.format("(%04d-%02d)" + history2.getText(), selectedYear2, selectedMonth2);
        }
        if (history3.getText().isEmpty()) {
            selectedMonth3 = 0; 
           selectedYear3 = 0;
           date_sur2 = String.format("(%04d-%02d)" + history3.getText(), selectedYear3, selectedMonth3);
        }else{
            selectedMonth3 = month3.getMonth() + 1; // Months are 0-indexed
           selectedYear3 = year3.getYear();
            date_sur2 = String.format("(%04d-%02d)" + history3.getText(), selectedYear3, selectedMonth3);
        }
        
     
        //IBD Type
        Combobox5 = (String) ibd_type.getSelectedItem();
          if (ibd_other.isSelected()) Combobox5 += other_data.getText() + ",";
        
        //Ulcerative colitis extent
        Combobox6 = (String) ulcer_extent.getSelectedItem();
        
        //Treatments received in past
        Combobox7 = (String) tx_re_past.getSelectedItem();
          if (tx_checkbox.isSelected()) Combobox7 += past_tx.getText() + ",";
        
        //Crohn's phenotype data
        phenotypeCheckboxes = "";
        if (luminal .isSelected()) phenotypeCheckboxes += luminal .getText() + ",";            
        if (stricturing .isSelected()) phenotypeCheckboxes += stricturing .getText() + ",";
        if (penetrating.isSelected()) phenotypeCheckboxes += penetrating.getText() + ",";
        if (perianal.isSelected()) phenotypeCheckboxes += perianal.getText() + ",";
        
        if (phenotypeCheckboxes.endsWith(",")) {
            phenotypeCheckboxes = phenotypeCheckboxes.substring(0, phenotypeCheckboxes.length() - 1);
        }
        
        tpmt_activity = tpmt.getText();
        
        nudt15 = (String) nudt.getSelectedItem();
        
        List<List<String>> recordsToInsert = List.of(
            List.of(pt_id,endoscopyCheckboxes, histologyCheckboxes, radiologyCheckboxes, capsuleCheckboxes, preopCheckboxes, Combobox1, Combobox3, Combobox4, 
                    date_sur, date_sur1, date_sur2, Combobox5, phenotypeCheckboxes, Combobox6, Combobox7, tpmt_activity, nudt15, past_drug) 
        );
        
        insertMultipleRecords(recordsToInsert);
        
        exportToPDF();
        
        }
        catch (Exception e) {
           JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            
        }
    }//GEN-LAST:event_finishActionPerformed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
                
                undo_button.setVisible(true);
        
                history1.setVisible(true);
                history1.requestFocusInWindow();
                
                month1.setVisible(true);
                month1.requestFocusInWindow();
                
                year1.setVisible(true);
                year1.requestFocusInWindow();
                
                
                if (!history1.getText().isEmpty()) {
                    // If the first text field has data, make the second text field visible
                    history2.setVisible(true);
                    history2.requestFocusInWindow();
                    
                    month2.setVisible(true);
                    month2.requestFocusInWindow();
                    
                    year2.setVisible(true);
                    year2.requestFocusInWindow();
                    
                } else {
                    // If the first text field is empty, do not show the second text field
                    history2.setVisible(false);
                    history1.setVisible(true);
                    history1.requestFocusInWindow();
                    
                    month2.setVisible(false);
                    year2.setVisible(false);
                    
                }

                // Check if the second text field has data
                if (!history2.getText().isEmpty()) {
                    // If the second text field has data, make the third text field visible
                    history3.setVisible(true);
                    history3.requestFocusInWindow();
                    
                    month3.setVisible(true);
                    month3.requestFocusInWindow();
                    
                    year3.setVisible(true);
                    year3.requestFocusInWindow();
                } else {
                    // If the second text field is empty, do not show the third text field
                    history3.setVisible(false);
                    month3.setVisible(false);
                    year3.setVisible(false);
                }
            
    }//GEN-LAST:event_add_buttonActionPerformed

    private void tx_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_checkboxActionPerformed
        past_tx.setEditable(tx_checkbox.isSelected());
    }//GEN-LAST:event_tx_checkboxActionPerformed

    private void undo_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undo_buttonActionPerformed
                history1.setText("");
                history2.setText("");
                history3.setText("");
                history1.setVisible(false);
                month1.setVisible(false);
                year1.setVisible(false);
                
                history2.setVisible(false);
                month2.setVisible(false);
                year2.setVisible(false);
                
                history3.setVisible(false);
                month3.setVisible(false);
                year3.setVisible(false);
                
                undo_button.setVisible(false);
    }//GEN-LAST:event_undo_buttonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IBD_Baseline_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(() -> {
            new IBD_Baseline_2().setVisible(true);
           });
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Baseline_2_Scroll;
    private javax.swing.JButton add_button;
    private javax.swing.JCheckBox ascending0;
    private javax.swing.JCheckBox ascending1;
    private javax.swing.JCheckBox ascending2;
    private javax.swing.JCheckBox ascending3;
    private javax.swing.JCheckBox ascending4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox cecum0;
    private javax.swing.JCheckBox cecum1;
    private javax.swing.JCheckBox cecum2;
    private javax.swing.JCheckBox cecum3;
    private javax.swing.JCheckBox cecum4;
    private javax.swing.JCheckBox descending0;
    private javax.swing.JCheckBox descending1;
    private javax.swing.JCheckBox descending2;
    private javax.swing.JCheckBox descending3;
    private javax.swing.JCheckBox descending4;
    private javax.swing.JCheckBox duodenum0;
    private javax.swing.JCheckBox duodenum1;
    private javax.swing.JCheckBox duodenum2;
    private javax.swing.JCheckBox duodenum3;
    private javax.swing.JCheckBox duodenum4;
    private javax.swing.JCheckBox esophagus0;
    private javax.swing.JCheckBox esophagus1;
    private javax.swing.JCheckBox esophagus2;
    private javax.swing.JCheckBox esophagus3;
    private javax.swing.JCheckBox esophagus4;
    private javax.swing.JButton finish;
    private javax.swing.JTextField history1;
    private javax.swing.JTextField history2;
    private javax.swing.JTextField history3;
    private javax.swing.JCheckBox ibd_other;
    private javax.swing.JComboBox<String> ibd_type;
    private javax.swing.JCheckBox icvalve0;
    private javax.swing.JCheckBox icvalve1;
    private javax.swing.JCheckBox icvalve2;
    private javax.swing.JCheckBox icvalve3;
    private javax.swing.JCheckBox icvalve4;
    private javax.swing.JCheckBox ileum0;
    private javax.swing.JCheckBox ileum1;
    private javax.swing.JCheckBox ileum2;
    private javax.swing.JCheckBox ileum3;
    private javax.swing.JCheckBox ileum4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JCheckBox jejunum0;
    private javax.swing.JCheckBox jejunum1;
    private javax.swing.JCheckBox jejunum2;
    private javax.swing.JCheckBox jejunum3;
    private javax.swing.JCheckBox jejunum4;
    private javax.swing.JCheckBox luminal;
    private com.toedter.calendar.JMonthChooser month1;
    private com.toedter.calendar.JMonthChooser month2;
    private com.toedter.calendar.JMonthChooser month3;
    private javax.swing.JCheckBox mouth0;
    private javax.swing.JCheckBox mouth1;
    private javax.swing.JCheckBox mouth2;
    private javax.swing.JCheckBox mouth3;
    private javax.swing.JCheckBox mouth4;
    private javax.swing.JRadioButton no;
    private javax.swing.JComboBox<String> nudt;
    private javax.swing.JTextField other_data;
    private javax.swing.JTextField past_tx;
    private javax.swing.JCheckBox penetrating;
    private javax.swing.JCheckBox perianal;
    private javax.swing.JCheckBox rectum0;
    private javax.swing.JCheckBox rectum1;
    private javax.swing.JCheckBox rectum2;
    private javax.swing.JCheckBox rectum3;
    private javax.swing.JCheckBox rectum4;
    private javax.swing.JCheckBox sigmoid0;
    private javax.swing.JCheckBox sigmoid1;
    private javax.swing.JCheckBox sigmoid2;
    private javax.swing.JCheckBox sigmoid3;
    private javax.swing.JCheckBox sigmoid4;
    private javax.swing.JCheckBox stomach0;
    private javax.swing.JCheckBox stomach1;
    private javax.swing.JCheckBox stomach2;
    private javax.swing.JCheckBox stomach3;
    private javax.swing.JCheckBox stomach4;
    private javax.swing.JCheckBox stricturing;
    private javax.swing.JTextField tpmt;
    private javax.swing.JCheckBox transverse0;
    private javax.swing.JCheckBox transverse1;
    private javax.swing.JCheckBox transverse2;
    private javax.swing.JCheckBox transverse3;
    private javax.swing.JCheckBox transverse4;
    private javax.swing.JCheckBox tx_checkbox;
    private javax.swing.JComboBox<String> tx_re_past;
    private javax.swing.JComboBox<String> ulcer_extent;
    private javax.swing.JButton undo_button;
    private com.toedter.calendar.JYearChooser year1;
    private com.toedter.calendar.JYearChooser year2;
    private com.toedter.calendar.JYearChooser year3;
    private javax.swing.JRadioButton yes;
    // End of variables declaration//GEN-END:variables
}
