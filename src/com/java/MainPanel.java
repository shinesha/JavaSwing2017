/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Viran Gohil 15500582
 * Employee form
 */
public class MainPanel extends JPanel
{
    // We declare the components publics to allow access from controller
    JTextField txt_name;
    JRadioButton option_male;
    JRadioButton option_female;
    DatePanel birthday; 
    JTextField   txt_salary;
    JTextField txt_natInsceNo;
    JTextField txt_phone;
    DatePanel startDate;
    JTextField txt_jobTitle;
    JButton btnSave;
    JButton btnReset;
    JButton btnNext;
    JButton btnPrev;
    JPanel panel_button;
    Store store= new Store();
    ArrayList<Employee> list_employee= Home.list_employee;
    int emp_size= list_employee.size();
    int oper;
    int index=0;
    
        /**
         *  Constructor
         *  @param oper 1 add, 2 save
         */    
    public MainPanel(int oper)
    {
        initComponent();
        this.oper=oper;
        /*
         *  if the form is opened in view mode,
         *  add navigation buttons
         */
        if(oper==2)
        {
            
            btnNext= new JButton("Next");
            btnPrev=new JButton("Previous");
            panel_button.removeAll();
            panel_button.add(btnNext);
            panel_button.add(btnPrev);
            
            panel_button.revalidate();
            
            if(emp_size>=1)
            {
                setEmployeeFields(list_employee.get(0));
                //index+=1;
            }
        /*
         * action to perform when user clicks on "Next button"
         */             
            btnNext.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    System.out.println(index);
                    if(index<emp_size - 1)
                    {
                        index+=1;
                        Employee employee=Home.list_employee.get(index);
                        setEmployeeFields(employee);
                        //txt_name.setText(employee.get_name());
                    }
                }
            });
        /*
         * action to perform when user clicks on "Previous button"
         */             
            btnPrev.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    if(index>0)
                    {
                        index-=1;
                        Employee employee=Home.list_employee.get(index);
                        setEmployeeFields(employee);
                        //txt_name.setText(employee.get_name());
                        
                    }
                }
            });            
            /*list_employee=store.retrieve_data();
            System.out.println(list_employee);
            JOptionPane.showMessageDialog(null, list_employee.size());
            JOptionPane.showMessageDialog(null, list_employee);*/
            
        }
    }
    public void initComponent()
     {
        setSize(550, 500);
       JPanel mainPanel=new JPanel(new BorderLayout()); // Create Main Panel with BorderLayout       
       mainPanel.setBackground(new Color(0,78,152));   // change the background color of mainPanel
       
       /************** Title Design ************************/
       JLabel label_title=new JLabel("Employee Information");      // Create a JLabel for Title
       label_title.setHorizontalAlignment(JLabel.CENTER); // Center the title
       label_title.setFont(new Font("Times New Romain",Font.BOLD,24)); // Set title Font
       label_title.setForeground(Color.white);  // Set title color
       mainPanel.add(label_title, BorderLayout.NORTH);// Add title at the Top(North)
       /*    END Title Desgin    */

       //System.out.println(1);
       /************** Form Design ************************/
       GridLayout formLayout=new GridLayout(0, 2, 0, 20); //Layout with 1 line two colonnes
       JPanel panel_form=new JPanel(formLayout);  // Create a panel for the form's fields with Grid Layout
       
       /*Create name label and text field then add to the form Panel */
       JLabel lbl_firstName=new JLabel("Name:");
       txt_name=new JTextField();
       panel_form.add(lbl_firstName);            
       panel_form.add(txt_name);
       /* End FirstName Design */
       //System.out.println(2);
       /*Create gender label and option fields then add to the form Panel */
       JLabel lbl_Gender=new JLabel("Gender:");
       option_female=new JRadioButton("Female",false);
       option_male=new JRadioButton("Male", true);
       ButtonGroup bG = new ButtonGroup();
       bG.add(option_female);
       bG.add(option_male);
       JPanel radio_panel=new JPanel();
       radio_panel.add(option_male);
       radio_panel.add(option_female);       
       panel_form.add(lbl_Gender);            
       panel_form.add(radio_panel);
       /* End Gender Design */       
       
       /*Create date of birth label and text field then add to the form Panel */
       JLabel lbl_birthDate=new JLabel("Date of birth:");
       birthday=new DatePanel();
       panel_form.add(lbl_birthDate);            
       panel_form.add(birthday);
       /* End date of birth Design */  
       
       /*Create salary label and text field then add to the form Panel */
       JLabel lbl_Salary=new JLabel("Salary:");
       txt_salary=new JTextField();
       panel_form.add(lbl_Salary);            
       panel_form.add(txt_salary);
       /* End Salary Design */
       
       /*Create National Insurance No Number label and text field then add to the form Panel */
       JLabel lbl_pps=new JLabel("National Insurance No:");
       txt_natInsceNo=new JTextField();
       panel_form.add(lbl_pps);            
       panel_form.add(txt_natInsceNo);
       /* End National Insurance No Design */ 
       
       
       /*Create start date label and fields  then add to the form Panel */
       JLabel lbl_phone=new JLabel("Phone:");
       txt_phone=new JTextField();
       panel_form.add(lbl_phone);            
       panel_form.add(txt_phone);
       /* End Phone Number Design */ 
       
       /*Create start date label and fields then add to the form Panel */
       JLabel lbl_startDate=new JLabel("Start Date:");
       startDate=new DatePanel();
       panel_form.add(lbl_startDate);            
       panel_form.add(startDate);
       /* End start date Design */ 
       //System.out.println(3);
       /*Create Job Title label and text field then add to the form Panel */
       JLabel lbl_title=new JLabel("Job Title:");
       txt_jobTitle=new JTextField();
       panel_form.add(lbl_title);            
       panel_form.add(txt_jobTitle);
       /* End Contact Design */ 
              
       
       mainPanel.add(panel_form, BorderLayout.CENTER);
       
       /*    END Form Desgin    */      
       
       /* Create save and reset buttons */
       panel_button= new JPanel(new FlowLayout()); 
       btnSave=new JButton("Save"); // Save button
        /*
         * action to perform when user clicks on "save button"
         */        
       btnSave.addActionListener(new ActionListener() 
            {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String name= txt_name.getText();
                char gender= option_female.isSelected()?'F':'M';
                Date dateOfBirth= birthday.getDate();
                String address= "";
                String natInsceNo=txt_natInsceNo.getText();
                String phoneNo=txt_phone.getText();
                Date start = startDate.getDate();
                double salary=txt_salary.getText().matches("[0-9]+")?Double.parseDouble(txt_salary.getText()):0;
                String job_title=txt_jobTitle.getText();
                int id=0;
                Employee employee= new Employee(id, name, gender, dateOfBirth, address, natInsceNo, phoneNo
                        ,salary, job_title, start);
                
                list_employee.add(employee);
                store.save_as_CSV(employee);
                store.save(list_employee, "store.ser");
                JOptionPane.showMessageDialog(null, "Saved!");
            }
            }
         );
       panel_button.add(btnSave);
       btnReset=new JButton("Reset"); // reset button
       panel_button.add(btnReset);      
        /*
         * action to perform when user clicks on "reset button"
         */        
       btnReset.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                   resetEmployeeFields();
                }
            });  
       mainPanel.add(panel_button, BorderLayout.SOUTH);
       /* End save and reset buttons */       
       
       add(mainPanel);
     }
    
        /**
         * set employee fields
         * @param emp employee object
         */     
    private void setEmployeeFields(Employee emp)
    {
                txt_name.setText(emp.get_name());
                if(emp.get_gender()=='F')
                    option_female.setSelected(true);
                else 
                    option_male.setSelected(true);
                birthday.setDate(emp.get_dateOfBirth());
                txt_natInsceNo.setText(emp.get_natInsceNo());
                txt_phone.setText(emp.get_phoneNo());
                startDate.setDate(emp.getStartDate());
                txt_salary.setText(emp.getSalary()+"");
                txt_jobTitle.setText(emp.getJob_title());
    }
        /**
         * reset employee fields
         *
         */     
    private void resetEmployeeFields()
    {
                txt_name.setText("");
                option_male.setSelected(true);
                birthday.resetDate();
                txt_natInsceNo.setText("");
                txt_phone.setText("");
                startDate.resetDate();
                txt_salary.setText("");
                txt_jobTitle.setText("");
    }
}
