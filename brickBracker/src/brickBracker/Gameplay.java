/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickBracker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Gameplay  extends JPanel implements KeyListener, ActionListener{
    private boolean play = false;
    private int Score = 0;
    
    private int totalbrick = 21;
    private Timer time;
    private int delay = 8;
    private int playerX = 310;
    private int ballx = 120;
    private int bally = 350;
    private int ballxdir = -1;
    private int ballydir = -2;
    private Mapgenerator map;
    
    public Gameplay(){
        map = new Mapgenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();
    }
    
    public void paint(Graphics g){
     //background
        g.setColor(Color.blue);
        g.fillRect(1, 1, 692, 592);
        
        map.draw((Graphics2D)g);
        
        //borders
        g.setColor(Color.red);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(690, 0, 3, 592);
        
        //score
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD,25));
        g.drawString("" +Score, 590, 30);
        
        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);
        
        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballx, bally, 20, 20);
        if(totalbrick <= 0 ){
            play = false;
            ballxdir = 0;
            ballydir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD,30));
        g.drawString("You Win , Score" +Score, 190, 300);
        g.setFont(new Font("Arial", Font.BOLD,30));
        g.drawString("Press Enter to Restart", 190, 350);
            
        }
        
        if(bally > 570){
            play = false;
            ballxdir = 0;
            ballydir = 0;
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD,30));
        g.drawString("Game Over , Score" +Score, 190, 300);
        g.setFont(new Font("Arial", Font.BOLD,30));
        g.drawString("Press Enter to Restart", 190, 350);
            
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(play){
            if (new Rectangle(ballx,bally,20,20).intersects(new Rectangle(playerX,550,100,8))){
                ballydir = -ballydir;
            }
            
            A: for(int i=0; i< map.map.length; i++){
            for(int j=0; j< map.map[0].length; j++){
            if(map.map[i][j]>0){
                int brickx = j*map.brickwidth + 80;
                int bricky = i*map.brickheight + 50;
                int brickwidth = map.brickwidth;
                int brickheight = map.brickheight;
                Rectangle rect = new Rectangle(brickx, bricky,brickwidth,brickheight);
                Rectangle ballRect = new Rectangle(ballx,bally,20,20);
                Rectangle brickRect = rect;
                
                if(ballRect.intersects(brickRect)){
                    map.setBrickvalue(0, i, j);
                    totalbrick --;
                    Score += 5;
                    if(ballx + 19<= brickRect.x || ballx +1 >= brickRect.x + brickRect.width){
                        ballxdir = -ballxdir;
                    } else {
                        ballydir = -ballydir; 
                    }
                    break A;
                }
                
            }
            }
            }
            
            ballx += ballxdir;
            bally += ballydir;
            if(ballx<0){
                ballxdir = -ballxdir;
            }
            if(bally<0){
                ballydir = -ballydir;
            }
            if(ballx > 670){
                ballxdir = -ballxdir;
            }
        }
        repaint();
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 600){
                playerX= 600;
            } else {
                moveRight();
            }
        }
         if(e.getKeyCode() == KeyEvent.VK_LEFT){
             if(playerX < 10){
                playerX= 10;
            } else {
                moveLeft();
            }
        }
         if(e.getKeyCode()== KeyEvent.VK_ENTER){
             if(!play){
                 play = true;
                 ballx = 350;
                 ballxdir = -1;
                 bally = 350;
                 ballydir = -2;
                 playerX = 310;
                 Score = 0;
                 totalbrick = 21;
                 map = new Mapgenerator(3,7);
                 repaint();
             }
         }
         
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void moveRight(){
        play = true;
        playerX += 20; 
    }
    public void moveLeft(){
        play = true;
        playerX -= 20; 
    }


    
 
    
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
