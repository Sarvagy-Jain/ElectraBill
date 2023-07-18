package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
// by default frame frames visibility is hiden 
// JFrame is imported from swing it contains setsize and setVisible fuction used 
// to manage frame size and its Visibility   

// Java doesn't support multiple inheritances in classes because it can lead to diamond problem.it can overcome 
// this by using interfaces.Class can implements multiple interfaces and extends at a same time.
// interface entries are by default public  
// we can create a referance of interface not object

//
public class splash extends JFrame implements Runnable {
    // splash constructor
    Thread t;
    splash() {
        // ImageIcon class is used to set image on frame 
        ImageIcon i1 = new ImageIcon(getClass().getClassLoader().getResource("icon/elect.jpg"));
        Image i2 =  i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(i2);
        
        // as add can take ImageIcon object as parameter so creating  Jlabel Object 
        JLabel frame =  new JLabel(i1); 
        add(frame);
       
       setVisible(true);
       int x = 1;
       for(int i=2 ;i< 600;i+=4,x+=1){
           setSize(i+x,i);
           setLocation(700-(i+x)/2,400 - i/2);
           try{
               Thread.sleep(2);    
           }catch(Exception e){
               e.printStackTrace();
           }// Multi threading Concept ,Sleep stop some instruction// sleep function should be used with exception
       }     
       t = new Thread(this);
       t.start();  // Multithreading Concept ,start() will run an run function 
       setVisible(true);
    }
    
    //abstract Class are those whose object can't br created
    // By implementing runnable(abstract Class) Splash will alse become abstract so to avoid this, 
    // Concept of OVERWRITING is used for run()which was abstract method in Runnable 
    public void run(){
        try{
             Thread.sleep(1000  ); 
             setVisible(false);
             new login();
        }catch(Exception e){    
              e.printStackTrace();
        }
        
    }

    public static void main(String[] args) {
        new splash();   
    }
}
