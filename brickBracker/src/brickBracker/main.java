/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickBracker;
import javax.swing.*;

/**
 *
 * @author User
 */
public class main {
    public static void main(String[] args){
       JFrame f = new JFrame();
       Gameplay gp = new Gameplay();
        f.setBounds(10, 10, 710, 600);
        f.setTitle("BrickBracker");
        f.setResizable(true);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(gp);
    }
    
}
