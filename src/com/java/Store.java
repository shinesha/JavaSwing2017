/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Viran Gohil 15500582
 * Class to save and retrieve records
 */
public class Store {
    

    /**
     *  Default constructor
     */
    public Store()
    {

    }
    /**
     * Serialize  employee in a file
     * @param obj employee list
     * @param file_name  file name
     */
    public void save(ArrayList<Employee> obj, String file_name)
    {
        try
        {
            try (FileOutputStream fout = new FileOutputStream(file_name)) 
            {
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                //JOptionPane.showMessageDialog(null,"2: "+ obj.size());
                oos.writeObject(obj);
                oos.close();
                fout.close();
            }
        }catch(Exception err)
        {
            err.printStackTrace();
            JOptionPane.showMessageDialog(null, err);
        }
    }
    /**
     *  save employee records as csv file
     * @param obj employee object
     */
    public void save_as_CSV(Employee obj)
    {
        try
        {
            try (FileWriter fout = new FileWriter("store.csv", true)) 
            {
                PrintWriter out = new PrintWriter(new BufferedWriter(fout));
                out.println(obj.get_name()+","+obj.get_gender()+","+obj.get_dateOfBirth()
                        +","+obj.getSalary()+","+obj.get_natInsceNo()
                        +","+obj.get_phoneNo()+","+obj.getStartDate()
                        +","+obj.getJob_title());
                out.close();
                fout.close();
                
            }
        }catch(Exception err)
        {
            err.printStackTrace();
            JOptionPane.showMessageDialog(null, err);
        }
    }    
    /**
     * deserialize  employee object from file
     * @param file_name file name
     * @return 
     */
    public ArrayList<Employee> retrieve_data(String file_name)
    {
         ObjectInputStream objStream = null;
         ArrayList<Employee> list_employee= new ArrayList<>();
         if(!new File(file_name).exists())
             return list_employee;
 try {
        FileInputStream streamIn = new FileInputStream("store.ser");
        objStream = new ObjectInputStream(streamIn);  
        //Person emp=null;

         list_employee = (ArrayList<Employee>) objStream.readObject();
         //JOptionPane.showMessageDialog(null,"3: "+ list_employee.size());
             objStream.close();
   } catch (Exception err) {
        JOptionPane.showMessageDialog(null, err.getMessage());
        err.printStackTrace();
   }
        return list_employee;
    }
    /**
     * retrieve record from  csv
     * @param file file name
     * @return 
     */
    public ArrayList<Employee> retrieve_csv(String file)
    {
        ArrayList<Employee> list_emp= new ArrayList<>();
       try
       {   
         try(BufferedReader br = new BufferedReader(new FileReader(file))) 
         {
           String line = br.readLine();

                while (line != null) 
                {
                    String [] values= line.split(",");
                    Employee emp= new Employee();
                    line = br.readLine();
                }
               
          }
       } catch (Exception err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
            err.printStackTrace();
       }
        
       return list_emp;
    }
}
