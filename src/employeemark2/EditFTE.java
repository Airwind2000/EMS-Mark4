/*
 * Arvind Nagabhirava
 * Employee Management System - 2019
 */
package employeemark2;

import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTable;

/**
 *
 * @author ArvindNagabhirava
 */
public class EditFTE extends javax.swing.JFrame {

    private static FTE initialEmp;
    private static JTable employeeTable;

    /**
     * Creates new form EditFTE
     */
    //Employee is required to edit. In homepage, an employee is selected and then edit is clicked to edit the employee
    
    public EditFTE(FTE initEmp,JTable employeeTable) {
        this.employeeTable = employeeTable;
        initComponents();
        center();
        hiddenButton1.setVisible(false);
        //Inputting the information about the employee so the user can see what they are editing as opposed to a blank slate. 
        this.initialEmp = initEmp;
        enumField.setText(Integer.toString(initEmp.getEmployeeNumber()));
        fName.setText(initEmp.getFirstName());
        lName.setText(initEmp.getLastName());
        yrSal.setText(Double.toString(initEmp.getYearlySalary()));
        dRate.setText(Double.toString(initEmp.getDeductionsRate()));
        workLocMenu.setSelectedIndex(initEmp.getWorkLocation());
        if (initEmp.getSex() == 0) {
            mRadio.setSelected(true);
        } else if (initEmp.getSex() == 1) {
            fRadio.setSelected(true);
        } else {
            oRadio.setSelected(true);
        }

        initMouseListener();

    }
    static Point mouseDownCompCoords;
    //makes window draggable
    private void initMouseListener() {
        try {
            this.addMouseListener(new MouseListener() {
                public void mouseReleased(MouseEvent e) {
                    mouseDownCompCoords = null;
                }

                public void mousePressed(MouseEvent e) {
                    mouseDownCompCoords = e.getPoint();
                }

                public void mouseExited(MouseEvent e) {
                }

                public void mouseEntered(MouseEvent e) {
                }

                public void mouseClicked(MouseEvent e) {
                }
            });

            this.addMouseMotionListener(new MouseMotionListener() {
                public void mouseMoved(MouseEvent e) {
                }

                public void mouseDragged(MouseEvent e) {
                    Point currCoords = e.getLocationOnScreen();
                    setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
                }
            });
        } catch (Exception e) {
            //Silence
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        lName = new javax.swing.JTextField();
        workLocMenu = new javax.swing.JComboBox<>();
        exitButton = new javax.swing.JButton();
        ptConvert = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        dRate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        enumField = new javax.swing.JTextField();
        resetAll = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mRadio = new javax.swing.JRadioButton();
        fRadio = new javax.swing.JRadioButton();
        oRadio = new javax.swing.JRadioButton();
        hiddenButton1 = new javax.swing.JRadioButton();
        fName = new javax.swing.JTextField();
        yrSal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        saveChanges = new javax.swing.JButton();
        removeEmp = new javax.swing.JButton();
        exitButtonTop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel4.setText("Last Name");

        workLocMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Chicago", "New York", "Toronto" }));

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        ptConvert.setText("Convert to Part Time");
        ptConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptConvert(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel9.setText("Edit Full Time Employee");

        jLabel1.setText("Employee Number");

        jLabel10.setText("Deductions Rate");

        resetAll.setText("Reset All");
        resetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetAllActionPerformed(evt);
            }
        });

        jLabel2.setText("First Name");

        jLabel7.setText("Work Location");

        jLabel8.setText("Sex");

        buttonGroup1.add(mRadio);
        mRadio.setText("M");

        buttonGroup1.add(fRadio);
        fRadio.setText("F");

        buttonGroup1.add(oRadio);
        oRadio.setText("Other");

        buttonGroup1.add(hiddenButton1);

        jLabel11.setText("Yearly Salary");

        saveChanges.setText("Save Changes");
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChanges(evt);
            }
        });

        removeEmp.setText("Remove Employee");
        removeEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmpActionPerformed(evt);
            }
        });

        exitButtonTop.setText("X");
        exitButtonTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonTopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel9))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(mRadio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fRadio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(oRadio))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(enumField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addGap(18, 18, 18)
                                    .addComponent(dRate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(yrSal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(workLocMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(saveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ptConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(resetAll, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(hiddenButton1)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(removeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))
                    .addComponent(exitButtonTop, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(exitButtonTop)
                .addGap(4, 4, 4)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(mRadio)
                    .addComponent(fRadio)
                    .addComponent(oRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(workLocMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(saveChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ptConvert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton)
                        .addGap(12, 12, 12)
                        .addComponent(removeEmp)
                        .addGap(47, 47, 47)
                        .addComponent(hiddenButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(enumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(yrSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(dRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void center() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        new HomePage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void ptConvert(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptConvert
        // TODO add your handling code here:
        int sex = 0;
        if (mRadio.isSelected() == true) {
            sex = 0;
        }
        if (fRadio.isSelected() == true) {
            sex = 1;
        }
        if (oRadio.isSelected() == true) {
            sex = 2;
        }

        PTE ptEMP;
        try {
            ptEMP = new PTE(Integer.parseInt(enumField.getText()), fName.getText(), lName.getText(), sex, workLocMenu.getSelectedIndex(), Double.parseDouble(dRate.getText()), 0.0, 0.0, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Invalid fields");
            return;
        }
        //opens an Edit window with PTE fields such as gender and work location
        new EditPTE(ptEMP,employeeTable).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ptConvert

    private void resetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetAllActionPerformed
        // TODO add your handling code here:
        this.resetAll();
    }//GEN-LAST:event_resetAllActionPerformed

    private void saveChanges(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChanges
        // TODO add your handling code here:
        // Checks to see if employee number is already in the system. 
        int empnum = 0;
        try {
        empnum = Integer.parseInt(enumField.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid employee number");
                    return;
                }
        
        if ((initialEmp.getEmployeeNumber() == empnum) || !(LoginPage.getHashTable().inTable(empnum))){
        
        int wLoc = workLocMenu.getSelectedIndex();
        int gender = 0;

        if (mRadio.isSelected() == true) {
            gender = 0;
        }
        if (fRadio.isSelected() == true) {
            gender = 1;
        }
        if (oRadio.isSelected() == true) {
            gender = 2;
        }
        
        String fname = fName.getText();
        String lname = lName.getText();

        double drate = 0;
        double yrSalary = 0;
        try {
            drate = Double.parseDouble(dRate.getText());
            yrSalary = Double.parseDouble(yrSal.getText());
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null,"There was an invalid entry in one of the salary fields");
          return;
        }

        if (yrSalary < 0 || drate < 0 || drate > 100){
            JOptionPane.showMessageDialog(null,"There was an invalid entry in one of the salary fields");
        } else { 
        EmployeeInfo someEmp;
        try {
        someEmp = new FTE(empnum, fname, lname, gender, wLoc, drate, yrSalary);
        
        //Saves changes to employee by removing the employee and then adding the employee with the changes
        LoginPage.getHashTable().removeFromTable(initialEmp.getEmployeeNumber());
        LoginPage.getHashTable().addToTable(someEmp);
        JOptionPane.showMessageDialog(null,"Successfully saved changes");
        LoginPage.getHashTable().fillTable(employeeTable);
        this.dispose();
        
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"There was an error saving changes");
            this.dispose();
            return;
        }
        }
        } else {
            JOptionPane.showMessageDialog(null, "Employee number is already in use");
        }
    }//GEN-LAST:event_saveChanges

    private void removeEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmpActionPerformed
        // TODO add your handling code here:
        LoginPage.getHashTable().removeFromTable(this.initialEmp.getEmployeeNumber());
        JOptionPane.showMessageDialog(null, "Successfully removed " + initialEmp.getFirstName() + initialEmp.getLastName());
        LoginPage.getHashTable().fillTable(employeeTable);
        this.dispose();
    }//GEN-LAST:event_removeEmpActionPerformed

    private void exitButtonTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonTopActionPerformed
        this.dispose();    }//GEN-LAST:event_exitButtonTopActionPerformed

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
            java.util.logging.Logger.getLogger(EditFTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditFTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditFTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditFTE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditFTE(initialEmp,employeeTable).setVisible(true);
            }
        });
    }

    private void resetAll() {
        enumField.setText(Integer.toString(initialEmp.getEmployeeNumber()));
        fName.setText(initialEmp.getFirstName());
        lName.setText(initialEmp.getLastName());
        yrSal.setText(Double.toString(initialEmp.getYearlySalary()));
        dRate.setText(Double.toString(initialEmp.getDeductionsRate()));
        workLocMenu.setSelectedIndex(initialEmp.getWorkLocation());
        if (initialEmp.getSex() == 0) {
            mRadio.setSelected(true);
        } else if (initialEmp.getSex() == 1) {
            fRadio.setSelected(true);
        } else {
            oRadio.setSelected(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dRate;
    private javax.swing.JTextField enumField;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton exitButtonTop;
    private javax.swing.JTextField fName;
    private javax.swing.JRadioButton fRadio;
    private javax.swing.JRadioButton hiddenButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lName;
    private javax.swing.JRadioButton mRadio;
    private javax.swing.JRadioButton oRadio;
    private javax.swing.JButton ptConvert;
    private javax.swing.JButton removeEmp;
    private javax.swing.JButton resetAll;
    private javax.swing.JButton saveChanges;
    private javax.swing.JComboBox<String> workLocMenu;
    private javax.swing.JTextField yrSal;
    // End of variables declaration//GEN-END:variables
}