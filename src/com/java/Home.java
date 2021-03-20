/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileFilter;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Viran Gohil 15500582
 * The main form
 * 
 */
public class Home  extends JFrame
{

   JPanel pnl_back;
   // Create a static list Employee accessible within all classes
   public static ArrayList<Employee> list_employee=new ArrayList<>();
    public Home()
    {
        initComponent();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Home home=new Home();
        home.setTitle("Employee Record System");
        home.setSize(600, 550);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLocationRelativeTo(null);
        home.setResizable(false);
        //home.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        home.setVisible(true);
    }
    
    /**
     *  Draw the interface
     * 
     */
    public void initComponent()
    {
        this.setLayout(new BorderLayout());
                /************************ Menu Design ***********************************************/
        JMenuBar menu_bar=new JMenuBar();   // Create a Menu Bar
        JMenu menu_file=new JMenu("File");  // Menu File
        JMenu menu_record=new JMenu("Records");  // Menu Recods
        
        
        JMenuItem item_new=new JMenuItem("New"); // Create "File" Menu Item
        menu_file.add(item_new); // Add the item to Menu "File"    
        item_new.addActionListener(new ActionListener() 
            {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //JOptionPane.showMessageDialog(null, "Here");
                //showMainFrame();
                pnl_back.removeAll();
                pnl_back.add(new MainPanel(1));
                pnl_back.revalidate();
            }
            }
         );
        JMenuItem item_save=new JMenuItem("Save"); // Create "File" Menu Item
        menu_file.add(item_save); // Add the item to Menu "File"
        /*
         * action to perform when user clicks on "save button"
         */
        item_save.addActionListener(new ActionListener() 
            {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFileChooser chooser= new JFileChooser(".");
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Serializable File", "Ser"));
                int openDialog=chooser.showSaveDialog(pnl_back);
                if(openDialog==JFileChooser.APPROVE_OPTION)
                {
                    Store store=new Store();
                    store.save(list_employee ,chooser.getSelectedFile().getAbsolutePath());
                    JOptionPane.showMessageDialog(null, "File Saved");
                }
            }
            }
         );
        JMenuItem item_open=new JMenuItem("Open"); // Create "File" Menu Item
        menu_file.add(item_open); // Add the item to Menu "File"
        /*
         * action to perform when user clicks on "open button"
         */        
        item_open.addActionListener(new ActionListener() 
            {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JFileChooser chooser= new JFileChooser(".");
                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Serializable File", "Ser"));
                int openDialog=chooser.showOpenDialog(pnl_back);
                if(openDialog==JFileChooser.APPROVE_OPTION)
                {
                    Store store=new Store();
                    list_employee= store.retrieve_data(chooser.getSelectedFile().getAbsolutePath());
                    pnl_back.removeAll();
                    pnl_back.add(new MainPanel(2));
                    pnl_back.revalidate();
                }
            }
            }
         );
        JMenuItem item_add=new JMenuItem("Add"); // Create "Record" Menu Item
        menu_record.add(item_add); // Add the item to Menu "Record"    
        /*
         * action to perform when user clicks on "Add button"
         */         
        item_add.addActionListener(new ActionListener() 
            {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //JOptionPane.showMessageDialog(null, "Here");
                //showMainFrame();
                pnl_back.removeAll();
                pnl_back.add(new MainPanel(1));
                pnl_back.revalidate();
            }
            }
         );
        JMenuItem item_display=new JMenuItem("display"); // Create "Record" Menu Item
        menu_record.add(item_display); // Add the item to Menu "Record"
        /*
         * action to perform when user clicks on "display button"
         */         
        item_display.addActionListener(new ActionListener() 
            {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Store store=new Store();
                list_employee= store.retrieve_data("store.ser");
                pnl_back.removeAll();
                pnl_back.add(new MainPanel(2));
                pnl_back.revalidate();
            }
            }
         );
        JMenuItem item_clear=new JMenuItem("Clear"); // Create "Record" Menu Item
        menu_record.add(item_clear); // Add the item to Menu "Record" 
        /*
         * action to perform when user clicks on "clear button"
         */         
        item_clear.addActionListener(new ActionListener() 
            {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                pnl_back.removeAll();
                pnl_back.add(new MainPanel(1));
                pnl_back.revalidate();
            }
            }
         );        
        // Add Menus to MenuBar
        menu_bar.add(menu_file);
        menu_bar.add(menu_record);
        
        // Add Menu to JFrame
        add(menu_bar, BorderLayout.NORTH);
        pnl_back= new JPanel();
        pnl_back.setBackground(new Color(0,78,152)); 
        add(pnl_back, BorderLayout.CENTER);
        
    }
    
 
}
