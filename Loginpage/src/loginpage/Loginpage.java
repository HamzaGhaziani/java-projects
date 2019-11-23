package loginpage;
import javax.swing.*;
import java.awt.event.*;
public class Loginpage implements ActionListener {
JFrame f;
JButton b1;
JTextField t1;
JPasswordField p;
JLabel l1,l2;
Loginpage(){
        f = new JFrame("Login Page");
        l1 = new JLabel("User Name");
        l1.setBounds(20,20,80,30);
        l2 = new JLabel("Password");
        l2.setBounds(20,75,80,30);
        t1 = new JTextField();
        t1.setBounds(100,20,100,30);
        p = new JPasswordField();
        p.setBounds(100,75,100,30);
        b1 = new JButton("Login");
        b1.setBounds(100,120,80,30);
        b1.addActionListener(this);
        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(p);
        f.add(b1);
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    
}
public void actionPerformed(ActionEvent e){
    if(e.getSource()== b1){
        String a = "username "+ t1.getText();
    JOptionPane.showMessageDialog(null,"Successfully login "+a);
    }

}
public static void main(String[] args) {  
    new Loginpage();
}
}