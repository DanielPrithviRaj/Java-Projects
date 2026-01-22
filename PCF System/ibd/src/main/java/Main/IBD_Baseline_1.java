/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;



import com.mycompany.ibd.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;



/**
 *
 * @author LENOVO
 */
public class IBD_Baseline_1 extends javax.swing.JFrame {

    /**
     * Creates new form IBD_Baseline
     */
    //static Date date;
    static String selectedCheckboxes = "";
    static String simp_date, pt_id, data, data1, data2, data3, data4, data5, alter_ph, other_illness;
    static String value, value1, value2, comboBox22, comboBox23, comboBox24, comboBox25, comboBox26;
    static String comboBox1, comboBox2, comboBox3, comboBox4, comboBox5, comboBox6, comboBox7, comboBox8, comboBox9, comboBox10, durationATT;
    static String comboBox11, comboBox12, comboBox13, comboBox14, comboBox15, comboBox16, comboBox17, comboBox18, comboBox19, comboBox20, comboBox21;
    
    public IBD_Baseline_1() {
        initComponents();
        setLocationRelativeTo(null);
        
        extra_manifestation.setEditable(false);
        
       JScrollBar verticalScrollBar = Baseline_1_Scroll.getVerticalScrollBar();
            verticalScrollBar.setUnitIncrement(20);
            verticalScrollBar.setBlockIncrement(100);  
            
        //Date generator
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd | HH:mm");
        String currentDate = date.format(new Date());
        current_date.setText(currentDate);
        current_date.setEditable(false);
    }
    
    
    private void fetchData() {
        
       
        String query = "SELECT * FROM patient_details WHERE Patient_ID = ?";
        String input = Pid_ip120.getText();
        
        if (input.isEmpty()) {
            Pid_ip121.setText(""); // Clear the text area if input is empty
             Pid_ip122.setText("");
              Pid_ip123.setText("");
               Pid_ip124.setText("");
                Pid_ip125.setText("");
                 State_residence.setText("");
               
            return;
        }

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
           // JOptionPane.showMessageDialog(null,"its in");
          
            pstmt.setString(1, input);
            ResultSet rs = pstmt.executeQuery();
            
          // JOptionPane.showMessageDialog(null,"its in"); 
            
            Pid_ip121.setText(""); // Clear previous data
            if (rs.next()) {
                
               //JOptionPane.showMessageDialog(null,"its in");
                  
                data = rs.getString("Patient_Name"); // Patient Name 
                    Pid_ip121.setText(data);
                    
                data1 = rs.getString("DOB"); // Date of Birth 
                    Pid_ip122.setText(data1);
                
                data2 = rs.getString("Phone_No"); //Phone Number
                    Pid_ip123.setText(data2);
                    
                data3 = rs.getString("Email"); //Email
                    Pid_ip124.setText(data3);
                    
                data4 = rs.getString("Occupation"); //Occupation
                    Pid_ip125.setText(data4);
                
                data5 = rs.getString("Residence"); //State of Residence
                    State_residence.setText(data5);
                
                 
            } else {
                Pid_ip121.setText("");
                Pid_ip122.setText("");
                Pid_ip123.setText("");
                Pid_ip124.setText("");
                Pid_ip125.setText("");
                State_residence.setText("");
                JOptionPane.showMessageDialog(null, "Patient not found");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error fetching data. Check console for details.");
        }
    }
    //Inserting data into database
    public static void insertMultipleRecords(List<List<String>> records) {
        String insertSQL = "INSERT INTO base_details_1 (Date,Patient_ID,Patient_Name,DOB,Phone_No,Alternate_Phone_No,Email,Occupation,Residence,Qualification,Date_of_symptoms,Date_of_diagnosis,Initial_symptoms,ATT_use, Duration_of_ATT, TB_family_member, Mantoux, BCG_scar, Chest_Xray, QFT, Smoking, Hbsag, HCV_Ab, HIV, Family_history_IBD, Erythema_nodousum, Pyoderma_gangerenosum, Oral_ulcers, Deep_vein_thrombosis, Red_eye, PSC, Peripheral_joint_arthritis, Peripheral_joint_arthralgia, Axial_arthritis, Axial_arthralgia,Comorb_DM, Comorb_HT, Comorb_Asthma, Comorb_COPD, Comorb_IHD, Any_other_illness) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               
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
                preparedStatement.setString(20, record.get(19));
                preparedStatement.setString(21, record.get(20));
                preparedStatement.setString(22, record.get(21));
                preparedStatement.setString(23, record.get(22));
                
                preparedStatement.setString(24, record.get(23));
                preparedStatement.setString(25, record.get(24));
                preparedStatement.setString(26, record.get(25));
                preparedStatement.setString(27, record.get(26));
                preparedStatement.setString(28, record.get(27));
                preparedStatement.setString(29, record.get(28));
                preparedStatement.setString(30, record.get(29));
                preparedStatement.setString(31, record.get(30));
                preparedStatement.setString(32, record.get(31));
                preparedStatement.setString(33, record.get(32));
                preparedStatement.setString(34, record.get(33));
                
                preparedStatement.setString(35, record.get(34));
                preparedStatement.setString(36, record.get(35));
                preparedStatement.setString(37, record.get(36));
                preparedStatement.setString(38, record.get(37));
                preparedStatement.setString(39, record.get(38));
                preparedStatement.setString(40, record.get(39));
                preparedStatement.setString(41, record.get(40));
                
                
                preparedStatement.addBatch(); // Add to batch
            }

            int[] results = preparedStatement.executeBatch(); // Execute batch insert
            connection.commit(); // Commit the transaction
            //JOptionPane.showMessageDialog(null, "Data saved successfully!");  
            System.out.println("Inserted rows: " + results.length);

        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
           System.exit(0);
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

        jSeparator1 = new javax.swing.JSeparator();
        Baseline_1_Scroll = new javax.swing.JScrollPane();
        Background12 = new javax.swing.JPanel();
        Pid12 = new javax.swing.JLabel();
        Pname156 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        Pname157 = new javax.swing.JLabel();
        Pname158 = new javax.swing.JLabel();
        Pname159 = new javax.swing.JLabel();
        Pname160 = new javax.swing.JLabel();
        Pid_ip120 = new javax.swing.JTextField();
        Pid_ip121 = new javax.swing.JTextField();
        Pid_ip122 = new javax.swing.JTextField();
        Pid_ip123 = new javax.swing.JTextField();
        Pid_ip124 = new javax.swing.JTextField();
        Pid_ip125 = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        State_residence = new javax.swing.JTextArea();
        Pname161 = new javax.swing.JLabel();
        Pname162 = new javax.swing.JLabel();
        Pname163 = new javax.swing.JLabel();
        Pname165 = new javax.swing.JLabel();
        extra_manifestation = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        att_use = new javax.swing.JComboBox<>();
        Pname166 = new javax.swing.JLabel();
        Pname167 = new javax.swing.JLabel();
        tb_fam_member = new javax.swing.JComboBox<>();
        jLabel136 = new javax.swing.JLabel();
        mantoux = new javax.swing.JComboBox<>();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        bcg_scar = new javax.swing.JComboBox<>();
        chest_xray = new javax.swing.JComboBox<>();
        qft = new javax.swing.JComboBox<>();
        smoking = new javax.swing.JComboBox<>();
        hbsag = new javax.swing.JComboBox<>();
        hcv_ab = new javax.swing.JComboBox<>();
        hiv = new javax.swing.JComboBox<>();
        jCheckBox97 = new javax.swing.JCheckBox();
        jCheckBox98 = new javax.swing.JCheckBox();
        jCheckBox99 = new javax.swing.JCheckBox();
        jCheckBox100 = new javax.swing.JCheckBox();
        jCheckBox101 = new javax.swing.JCheckBox();
        jCheckBox102 = new javax.swing.JCheckBox();
        jCheckBox103 = new javax.swing.JCheckBox();
        Pname168 = new javax.swing.JLabel();
        history_ibd = new javax.swing.JComboBox<>();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        any_illness = new javax.swing.JTextArea();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        dm = new javax.swing.JComboBox<>();
        ht = new javax.swing.JComboBox<>();
        asthma = new javax.swing.JComboBox<>();
        copd = new javax.swing.JComboBox<>();
        ihd = new javax.swing.JComboBox<>();
        erythema = new javax.swing.JComboBox<>();
        oral_ulcers = new javax.swing.JComboBox<>();
        red_eye = new javax.swing.JComboBox<>();
        psc = new javax.swing.JComboBox<>();
        pyoderma = new javax.swing.JComboBox<>();
        deep_vein = new javax.swing.JComboBox<>();
        axial_arthritis = new javax.swing.JComboBox<>();
        peripheral_arthralgia = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel160 = new javax.swing.JLabel();
        peripheral_arthritis = new javax.swing.JComboBox<>();
        jLabel161 = new javax.swing.JLabel();
        axial_arthralgia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        extra_sympts = new javax.swing.JCheckBox();
        alter_ph_no = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        current_date = new javax.swing.JTextField();
        Pid_ip126 = new javax.swing.JComboBox<>();
        monthChooser = new com.toedter.calendar.JMonthChooser();
        yearChooser = new com.toedter.calendar.JYearChooser();
        monthChooser1 = new com.toedter.calendar.JMonthChooser();
        yearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel3 = new javax.swing.JLabel();
        att_duration = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Baseline_1_Scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        Baseline_1_Scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Baseline_1_Scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Background12.setBackground(java.awt.SystemColor.inactiveCaption);
        Background12.setForeground(new java.awt.Color(255, 255, 255));

        Pid12.setText("Patient ID :");

        Pname156.setText("E-mail :");

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel133.setText("IBD - BASELINE DETAILS (to be filled only once for each patient)");

        jLabel134.setText("Date of birth :");

        Pname157.setText("Patient Name :");

        Pname158.setText("Phone No :");

        Pname159.setText("Occupation :");

        Pname160.setText("State of residence :");

        Pid_ip120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pid_ip120ActionPerformed(evt);
            }
        });

        State_residence.setColumns(20);
        State_residence.setRows(5);
        jScrollPane14.setViewportView(State_residence);

        Pname161.setText("Maximum educational qualification :");

        Pname162.setText("Month / yr of onset of symptoms:");

        Pname163.setText("Month / yr of diagnosis:");

        Pname165.setText("Patient's initial symptoms(select one/more)");

        extra_manifestation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extra_manifestationActionPerformed(evt);
            }
        });

        jLabel135.setText("ATT use");

        att_use.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        att_use.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        Pname166.setText("Duration of ATT (months)");

        Pname167.setText("TB in any family member");

        tb_fam_member.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tb_fam_member.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        jLabel136.setText("Mantoux");

        mantoux.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mantoux.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Positive", "Negative", "Not done" }));

        jLabel137.setText("BCG scar");

        jLabel138.setText("Chest X-ray");

        jLabel139.setText("QFT");

        jLabel140.setText("Smoking");

        jLabel141.setText("HbsAg");

        jLabel142.setText("HCV Ab");

        jLabel143.setText("HIV");

        bcg_scar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bcg_scar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Present", "Absent" }));

        chest_xray.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chest_xray.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Normal", "Abnormal", "Not done" }));

        qft.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        qft.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Positive", "Negative", "Not done" }));

        smoking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        smoking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Ex-smoker", "Never" }));

        hbsag.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hbsag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Positive", "Negative", "Not done" }));

        hcv_ab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hcv_ab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Positive", "Negative", "Not done" }));

        hiv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hiv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Positive", "Negative", "Not done" }));

        jCheckBox97.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox97.setText("Pain");

        jCheckBox98.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox98.setText("Fever");

        jCheckBox99.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox99.setText("Bleeding");

        jCheckBox100.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox100.setText("Diarrhoea");

        jCheckBox101.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox101.setText("Anemia");

        jCheckBox102.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox102.setText("Growth delay");

        jCheckBox103.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox103.setText("Perianal disease");

        Pname168.setText("Family history of IBD");

        history_ibd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        history_ibd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "1st degree (child)", "1st degree (parent)", "1st degree (sibling)", ">1st degree", "None" }));
        history_ibd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                history_ibdActionPerformed(evt);
            }
        });

        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel144.setText("Extra intestinal manifestations: ");

        jLabel145.setText("Erythema nodousum");

        jLabel146.setText("Oral ulcers");

        jLabel147.setText("Red eye");

        jLabel148.setText("PSC");

        jLabel149.setText("Pyoderma gangerenosum");

        jLabel150.setText("Deep vein thrombosis");

        jLabel151.setText("Axial arthritis");

        jLabel152.setText("Peripheral joint arthralgia");

        jLabel153.setText("Comorbs:");

        jLabel154.setText("Any other significant illness");

        any_illness.setColumns(20);
        any_illness.setRows(5);
        jScrollPane15.setViewportView(any_illness);

        jLabel155.setText("DM:");

        jLabel156.setText("HT:");

        jLabel157.setText("Asthma:");

        jLabel158.setText("COPD:");

        jLabel159.setText("IHD:");

        dm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes", "No" }));

        ht.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ht.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes", "No" }));
        ht.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htActionPerformed(evt);
            }
        });

        asthma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        asthma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes", "No" }));

        copd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        copd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes", "No" }));

        ihd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ihd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes", "No" }));
        ihd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ihdActionPerformed(evt);
            }
        });

        erythema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        erythema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        oral_ulcers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        oral_ulcers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        red_eye.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        red_eye.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        psc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        psc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Yes", "No", "Not evaluated" }));

        pyoderma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pyoderma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        deep_vein.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deep_vein.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        axial_arthritis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        axial_arthritis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        peripheral_arthralgia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        peripheral_arthralgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save & Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel160.setText("Peripheral joint arthritis");

        peripheral_arthritis.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        peripheral_arthritis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        jLabel161.setText("Axial arthralgia");

        axial_arthralgia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        axial_arthralgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "Current", "Past", "Never" }));

        jLabel2.setText("Date:");

        extra_sympts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        extra_sympts.setText("Extraintestinal manifestations");
        extra_sympts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extra_symptsActionPerformed(evt);
            }
        });

        jLabel1.setText("Alternate No:");

        current_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_dateActionPerformed(evt);
            }
        });

        Pid_ip126.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nil", "Pre-primary education - nursery", "Primary Education: Class 1 to 5", "Lower Secondary Education: Class 6 to 8", "Upper Secondary Education: Class 9 to 12", "Diploma courses, vocational courses and non-degree programs", "Bachelor's degrees", "Master's degrees", "Doctoral degrees (Ph.D.)" }));

        monthChooser.setMonth(5);

        monthChooser1.setMonth(5);
        monthChooser1.setYearChooser(null);

        jLabel3.setText("(if month is unknown; default is June)");

        att_duration.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        att_duration.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18" }));

        javax.swing.GroupLayout Background12Layout = new javax.swing.GroupLayout(Background12);
        Background12.setLayout(Background12Layout);
        Background12Layout.setHorizontalGroup(
            Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background12Layout.createSequentialGroup()
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Pname163, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pname162, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pname161, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Pid_ip126, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(monthChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(monthChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(yearChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(yearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3))))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addComponent(Pname168, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(history_ibd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addComponent(Pid12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Pid_ip120, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Pid_ip122, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addComponent(Pname158, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Pid_ip123, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addComponent(Pname157, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Pid_ip121, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Background12Layout.createSequentialGroup()
                                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Pname156, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(alter_ph_no)
                                            .addComponent(Pid_ip124, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Pname160)
                                            .addGroup(Background12Layout.createSequentialGroup()
                                                .addComponent(Pname159)
                                                .addGap(18, 18, 18)
                                                .addComponent(Pid_ip125, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addComponent(Pname165, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox99)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox101))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addComponent(Pname167, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tb_fam_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bcg_scar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mantoux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chest_xray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(qft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(145, 145, 145)
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hbsag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(smoking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hcv_ab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addComponent(jLabel154, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addComponent(jLabel153)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel155)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel156, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel157)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(asthma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel158)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(copd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel159)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ihd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addComponent(jLabel151, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(75, 75, 75))
                                    .addGroup(Background12Layout.createSequentialGroup()
                                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)))
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(peripheral_arthritis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(erythema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oral_ulcers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(red_eye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(axial_arthritis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel149, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel152, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(axial_arthralgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(psc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(peripheral_arthralgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deep_vein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pyoderma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel133))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addComponent(jCheckBox102)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox103)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(extra_sympts)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(extra_manifestation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(att_use, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(Pname166, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(att_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jButton1)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        Background12Layout.setVerticalGroup(
            Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Background12Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel133)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pid12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pid_ip120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(5, 5, 5)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pname157, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pid_ip121, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pid_ip122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pname158, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pid_ip123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alter_ph_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Background12Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pname156, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pid_ip124, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pname159, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Pid_ip125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pname160, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pname161, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pid_ip126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Pname162, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Pname163, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Background12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pname165, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox97)
                    .addComponent(jCheckBox98)
                    .addComponent(jCheckBox99)
                    .addComponent(jCheckBox100)
                    .addComponent(jCheckBox101))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(extra_manifestation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox102)
                    .addComponent(jCheckBox103)
                    .addComponent(extra_sympts))
                .addGap(18, 18, 18)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(att_use, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pname166, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(att_duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addComponent(tb_fam_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(Background12Layout.createSequentialGroup()
                        .addComponent(Pname167, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(mantoux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel140)
                            .addComponent(smoking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(jLabel141)
                    .addComponent(bcg_scar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hbsag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel138)
                    .addComponent(jLabel142)
                    .addComponent(chest_xray, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hcv_ab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(jLabel143)
                    .addComponent(qft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pname168, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(history_ibd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel144)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel145)
                    .addComponent(jLabel149)
                    .addComponent(erythema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pyoderma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(jLabel150)
                    .addComponent(oral_ulcers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deep_vein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel147)
                    .addComponent(red_eye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel148)
                    .addComponent(psc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(peripheral_arthralgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel160)
                    .addComponent(peripheral_arthritis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel151)
                    .addComponent(axial_arthritis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel161)
                    .addComponent(axial_arthralgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel153)
                    .addComponent(jLabel155)
                    .addComponent(jLabel156)
                    .addComponent(jLabel157)
                    .addComponent(jLabel158)
                    .addComponent(dm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asthma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ihd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel159))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(Background12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel154)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );

        Baseline_1_Scroll.setViewportView(Background12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Baseline_1_Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Baseline_1_Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void history_ibdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_history_ibdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_history_ibdActionPerformed

    private void htActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_htActionPerformed

    private void ihdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ihdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ihdActionPerformed

    private void Pid_ip120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pid_ip120ActionPerformed
    
    }//GEN-LAST:event_Pid_ip120ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        simp_date = current_date.getText();
        
       //JOptionPane.showMessageDialog(null, simp_date);
        
        pt_id = Pid_ip120.getText(); 
        
        value = (String) Pid_ip126.getSelectedItem();
        
        //Month and year of onset of symptoms
        int selectedMonth1 = monthChooser1.getMonth() + 1; // Months are 0-indexed
          int selectedYear1 = yearChooser1.getYear();
          
        value1 = String.format("%04d-%02d", selectedYear1, selectedMonth1);
        
        //Month and year of diagnosis
         int selectedMonth = monthChooser.getMonth() + 1; // Months are 0-indexed
          int selectedYear = yearChooser.getYear();
     
        value2 = String.format("%04d-%02d", selectedYear, selectedMonth);
        
        alter_ph = alter_ph_no.getText();
       
       //CheckBox value reader
        
        if (jCheckBox97.isSelected()) selectedCheckboxes += jCheckBox97.getText() + ",";            
        if (jCheckBox98.isSelected()) selectedCheckboxes += jCheckBox98.getText() + ",";
        if (jCheckBox99.isSelected()) selectedCheckboxes += jCheckBox99.getText() + ",";
        if (jCheckBox100.isSelected()) selectedCheckboxes += jCheckBox100.getText() + ",";
        if (jCheckBox101.isSelected()) selectedCheckboxes += jCheckBox101.getText() + ",";
        if (jCheckBox102.isSelected()) selectedCheckboxes += jCheckBox102.getText() + ",";
        if (jCheckBox103.isSelected()) selectedCheckboxes += jCheckBox103.getText() + ",";
        if (extra_sympts.isSelected()) selectedCheckboxes +=extra_manifestation.getText() + ",";

        // Remove trailing comma
        if (selectedCheckboxes.endsWith(",")) {
            selectedCheckboxes = selectedCheckboxes.substring(0, selectedCheckboxes.length() - 1);
        }

           //ComboBox value reader   
           comboBox1 = (String) att_use.getSelectedItem();  
           
           durationATT = (String) att_duration.getSelectedItem();
           
           comboBox2 = (String) tb_fam_member.getSelectedItem();
           comboBox3 = (String) mantoux.getSelectedItem();
           comboBox4 = (String) bcg_scar.getSelectedItem();
           comboBox5 = (String) chest_xray.getSelectedItem();
           comboBox6 = (String) qft.getSelectedItem();
           comboBox7 = (String) smoking.getSelectedItem();
           comboBox8 = (String) hbsag.getSelectedItem();
           comboBox9 = (String) hcv_ab.getSelectedItem();
           comboBox10 = (String) hiv.getSelectedItem();
           
           
           comboBox11 = (String) history_ibd.getSelectedItem();  
           
           comboBox12 = (String) erythema.getSelectedItem();
            comboBox13 = (String) pyoderma.getSelectedItem();
           comboBox14 = (String) oral_ulcers.getSelectedItem();
            comboBox15 = (String) deep_vein.getSelectedItem();
           comboBox16 = (String) red_eye.getSelectedItem();
            comboBox17 = (String) psc.getSelectedItem();
           comboBox18 = (String) peripheral_arthritis.getSelectedItem();
            comboBox19 = (String) peripheral_arthralgia.getSelectedItem();
           comboBox20 = (String) axial_arthritis.getSelectedItem();
            comboBox21 = (String) axial_arthralgia.getSelectedItem();
           
            //Comorbs
            comboBox22 = (String) dm.getSelectedItem(); 
            comboBox23 = (String) ht.getSelectedItem();
            comboBox24 = (String) asthma.getSelectedItem();
            comboBox25 = (String) copd.getSelectedItem();
            comboBox26 = (String) ihd.getSelectedItem();
           
            other_illness = any_illness.getText(); // Any other significant illness

        List<List<String>> recordsToInsert = List.of(
            List.of(simp_date, pt_id, data, data1, data2, alter_ph, data3, data4, data5, value, value1, value2, selectedCheckboxes, comboBox1, durationATT, comboBox2,
                    comboBox3, comboBox4, comboBox5, comboBox6, comboBox7, comboBox8, comboBox9, comboBox10, comboBox11, comboBox12, comboBox13, comboBox14, 
                    comboBox15, comboBox16, comboBox17, comboBox18, comboBox19, comboBox20, comboBox21, comboBox22, comboBox23, comboBox24, comboBox25, comboBox26, other_illness) 
        );
        
        
        
        //check for null or default value(-select-)
                boolean isValid = true;
              //  StringBuilder errorMessage = new StringBuilder();

                // Check if text field is empty
                if (Pid_ip120.getText().trim().isEmpty()) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null, "Patient ID cannot be empty.");
                }
                    if (Pid_ip121.getText().trim().isEmpty()) {
                        isValid = false;
                        JOptionPane.showMessageDialog(null, "Patient Name cannot be empty.");
                    }
                            if (Pid_ip122.getText().trim().isEmpty()) {
                                isValid = false;
                                JOptionPane.showMessageDialog(null, "Date of Birth cannot be empty.");
                        }
                                if (Pid_ip123.getText().trim().isEmpty()) {
                                    isValid = false;
                                    JOptionPane.showMessageDialog(null, "Phone number cannot be empty.");
                            }
                                    if (alter_ph_no.getText().trim().isEmpty()) {
                                        isValid = false;
                                        JOptionPane.showMessageDialog(null, "Alternate phone number cannot be empty.");
                                }
                                        if (Pid_ip124.getText().trim().isEmpty()) {
                                            isValid = false;
                                            JOptionPane.showMessageDialog(null, "Email ID cannot be empty.");
                                    }
                                            if (Pid_ip125.getText().trim().isEmpty()) {
                                                isValid = false;
                                                JOptionPane.showMessageDialog(null, "Occupation cannot be empty.");
                                        }
                                                if (State_residence.getText().trim().isEmpty()) {
                                                    isValid = false;
                                                    JOptionPane.showMessageDialog(null, "State of Residence cannot be empty.");
                                            }

                // Check if combo box has the default placeholder value
                if (att_use.getSelectedIndex() == 0) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null,"Please select a valid option from ATT use.");
                }
                    if (att_duration.getSelectedIndex() == 0) {
                        isValid = false;
                        JOptionPane.showMessageDialog(null,"Please select a valid option from Duration of ATT.");
                    }
                        if (tb_fam_member.getSelectedIndex() == 0) {
                            isValid = false;
                            JOptionPane.showMessageDialog(null,"Please select a valid option from TB in any family member.");
                        }
                            if (mantoux.getSelectedIndex() == 0) {
                                isValid = false;
                                JOptionPane.showMessageDialog(null,"Please select a valid option from Mantoux.");
                            }
                                if (bcg_scar.getSelectedIndex() == 0) {
                                    isValid = false;
                                    JOptionPane.showMessageDialog(null,"Please select a valid option from BCG scar.");
                                }
                                    if (chest_xray.getSelectedIndex() == 0) {
                                        isValid = false;
                                        JOptionPane.showMessageDialog(null,"Please select a valid option from Chest X-ray.");
                                    }
                                        if (qft.getSelectedIndex() == 0) {
                                            isValid = false;
                                            JOptionPane.showMessageDialog(null,"Please select a valid option from QFT.");
                                        }
                                            if (smoking.getSelectedIndex() == 0) {
                                                isValid = false;
                                                JOptionPane.showMessageDialog(null,"Please select a valid option from Smoking.");
                                            }
                                                if (hbsag.getSelectedIndex() == 0) {
                                                    isValid = false;
                                                    JOptionPane.showMessageDialog(null,"Please select a valid option from HbsAg.");
                                                }
                                                    if (hcv_ab.getSelectedIndex() == 0) {
                                                        isValid = false;
                                                        JOptionPane.showMessageDialog(null,"Please select a valid option from HCV Ab.");
                                                    }
                                                        if (hiv.getSelectedIndex() == 0) {
                                                            isValid = false;
                                                            JOptionPane.showMessageDialog(null,"Please select a valid option from HIV.");
                                                        }
                if (history_ibd.getSelectedIndex() == 0) {
                    isValid = false;
                    JOptionPane.showMessageDialog(null,"Please select a valid option from Family history of IBD.");
                }
                    if (erythema.getSelectedIndex() == 0) {
                        isValid = false;
                        JOptionPane.showMessageDialog(null,"Please select a valid option from Erythema nodousum.");
                    }
                        if (pyoderma.getSelectedIndex() == 0) {
                            isValid = false;
                            JOptionPane.showMessageDialog(null,"Please select a valid option from Pyoderma gangerenosum.");
                        }
                            if (oral_ulcers.getSelectedIndex() == 0) {
                                isValid = false;
                                JOptionPane.showMessageDialog(null,"Please select a valid option from Oral ulcers.");
                            }
                                if (deep_vein.getSelectedIndex() == 0) {
                                    isValid = false;
                                    JOptionPane.showMessageDialog(null,"Please select a valid option from Deep vein thrombosis.");
                                }
                                    if (red_eye.getSelectedIndex() == 0) {
                                        isValid = false;
                                        JOptionPane.showMessageDialog(null,"Please select a valid option from Red eye.");
                                    }
                                        if (psc.getSelectedIndex() == 0) {
                                            isValid = false;
                                            JOptionPane.showMessageDialog(null,"Please select a valid option from PSC.");
                                        }
                    if (peripheral_arthritis.getSelectedIndex() == 0) {
                        isValid = false;
                        JOptionPane.showMessageDialog(null,"Please select a valid option from Peripheral joint arthritis.");
                    }
                        if (peripheral_arthralgia.getSelectedIndex() == 0) {
                            isValid = false;
                            JOptionPane.showMessageDialog(null,"Please select a valid option from Peripheral joint arthralgia.");
                        }
                            if (axial_arthritis.getSelectedIndex() == 0) {
                                isValid = false;
                                JOptionPane.showMessageDialog(null,"Please select a valid option from Axial joint arthritis.");
                            }
                                if (axial_arthralgia.getSelectedIndex() == 0) {
                                    isValid = false;
                                    JOptionPane.showMessageDialog(null,"Please select a valid option from Axial joint arthralgia.");
                                }
                                    if (dm.getSelectedIndex() == 0) {
                                        isValid = false;
                                        JOptionPane.showMessageDialog(null,"Please select a valid option from DM.");
                                    }
                    if (ht.getSelectedIndex() == 0) {
                        isValid = false;
                        JOptionPane.showMessageDialog(null,"Please select a valid option from HT.");
                    }
                        if (asthma.getSelectedIndex() == 0) {
                            isValid = false;
                            JOptionPane.showMessageDialog(null,"Please select a valid option from Asthma.");
                        }
                            if (copd.getSelectedIndex() == 0) {
                                isValid = false;
                                JOptionPane.showMessageDialog(null,"Please select a valid option from COPD.");
                            }
                                if (ihd.getSelectedIndex() == 0) {
                                    isValid = false;
                                    JOptionPane.showMessageDialog(null,"Please select a valid option from HIV.");
                                }
                                  
                // Display error messages or proceed
                if (isValid) {
                   insertMultipleRecords(recordsToInsert);
                   IBD_Baseline_2.main(null);
                    setState(JFrame.ICONIFIED);
                   // Background12.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Check all values are entered");
                }
                
        
        //System.exit(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              fetchData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void current_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_current_dateActionPerformed

    private void extra_manifestationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extra_manifestationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_extra_manifestationActionPerformed

    private void extra_symptsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extra_symptsActionPerformed

        extra_manifestation.setEditable(extra_sympts.isSelected());
    }//GEN-LAST:event_extra_symptsActionPerformed

    /**
     * @param args the command line arguments
     * 
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
            java.util.logging.Logger.getLogger(IBD_Baseline_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IBD_Baseline_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IBD_Baseline_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IBD_Baseline_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
         //IBD_Baseline_1 IBDinstance = new IBD_Baseline_1();
     //IBDinstance.uppercase();
      
        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IBD_Baseline_1().setVisible(true);
            }
        });
        
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background12;
    private javax.swing.JScrollPane Baseline_1_Scroll;
    private javax.swing.JLabel Pid12;
    private javax.swing.JTextField Pid_ip120;
    private javax.swing.JTextField Pid_ip121;
    private javax.swing.JTextField Pid_ip122;
    private javax.swing.JTextField Pid_ip123;
    private javax.swing.JTextField Pid_ip124;
    private javax.swing.JTextField Pid_ip125;
    private javax.swing.JComboBox<String> Pid_ip126;
    private javax.swing.JLabel Pname156;
    private javax.swing.JLabel Pname157;
    private javax.swing.JLabel Pname158;
    private javax.swing.JLabel Pname159;
    private javax.swing.JLabel Pname160;
    private javax.swing.JLabel Pname161;
    private javax.swing.JLabel Pname162;
    private javax.swing.JLabel Pname163;
    private javax.swing.JLabel Pname165;
    private javax.swing.JLabel Pname166;
    private javax.swing.JLabel Pname167;
    private javax.swing.JLabel Pname168;
    private javax.swing.JTextArea State_residence;
    private javax.swing.JTextField alter_ph_no;
    private javax.swing.JTextArea any_illness;
    private javax.swing.JComboBox<String> asthma;
    private javax.swing.JComboBox<String> att_duration;
    private javax.swing.JComboBox<String> att_use;
    private javax.swing.JComboBox<String> axial_arthralgia;
    private javax.swing.JComboBox<String> axial_arthritis;
    private javax.swing.JComboBox<String> bcg_scar;
    private javax.swing.JComboBox<String> chest_xray;
    private javax.swing.JComboBox<String> copd;
    private javax.swing.JTextField current_date;
    private javax.swing.JComboBox<String> deep_vein;
    private javax.swing.JComboBox<String> dm;
    private javax.swing.JComboBox<String> erythema;
    private javax.swing.JTextField extra_manifestation;
    private javax.swing.JCheckBox extra_sympts;
    private javax.swing.JComboBox<String> hbsag;
    private javax.swing.JComboBox<String> hcv_ab;
    private javax.swing.JComboBox<String> history_ibd;
    private javax.swing.JComboBox<String> hiv;
    private javax.swing.JComboBox<String> ht;
    private javax.swing.JComboBox<String> ihd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox100;
    private javax.swing.JCheckBox jCheckBox101;
    private javax.swing.JCheckBox jCheckBox102;
    private javax.swing.JCheckBox jCheckBox103;
    private javax.swing.JCheckBox jCheckBox97;
    private javax.swing.JCheckBox jCheckBox98;
    private javax.swing.JCheckBox jCheckBox99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> mantoux;
    private com.toedter.calendar.JMonthChooser monthChooser;
    private com.toedter.calendar.JMonthChooser monthChooser1;
    private javax.swing.JComboBox<String> oral_ulcers;
    private javax.swing.JComboBox<String> peripheral_arthralgia;
    private javax.swing.JComboBox<String> peripheral_arthritis;
    private javax.swing.JComboBox<String> psc;
    private javax.swing.JComboBox<String> pyoderma;
    private javax.swing.JComboBox<String> qft;
    private javax.swing.JComboBox<String> red_eye;
    private javax.swing.JComboBox<String> smoking;
    private javax.swing.JComboBox<String> tb_fam_member;
    private com.toedter.calendar.JYearChooser yearChooser;
    private com.toedter.calendar.JYearChooser yearChooser1;
    // End of variables declaration//GEN-END:variables
}
