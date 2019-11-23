/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Point_of_Sale_System;

import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;
/**
 *
 * @author User
 */
public class login {
    
   
   
   JFrame f = new JFrame("LOGIN");
   JLabel l1 = new JLabel("User Name");
   JTextField t1 = new JTextField();
   JLabel l2 = new JLabel("Password");
   JPasswordField p = new JPasswordField();
   JButton b1 = new JButton("Login");
   JFrame f2;
   Connection con;
   Statement st;
   ResultSet rs;

   public login(){
       
       frame();
       connect();
    
}

   public void connect(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
           st = con.createStatement();
           }
       catch(Exception e){
           System.out.println("error : "+e);
           
       }
    }   
   
      
   public void frame(){
   
        l1.setBounds(20,20,80,30);
        t1.setBounds(100,20,100,30);
        l2.setBounds(20,75,80,30);
        p.setBounds(100,75,100,30);
        b1.setBounds(100,120,80,30);
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(p);
        f.add(b1);
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
    
            try{
                String a = t1.getText();
                String b = p.getText();
                String s = "select Uname,psd from admin_login where Uname='"+a+"'and psd='"+b+"'";
                rs = st.executeQuery(s);
                int count = 0;
                while(rs.next()){
                    count = count + 1;
                }
                if(count == 1){
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome().setVisible(true);
            }
        });
                    }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
    }
            catch(Exception ex){}
       }  });
   }
   
   
   
   public static void main(String[] args){
       new login();
      
        
   
}


}
