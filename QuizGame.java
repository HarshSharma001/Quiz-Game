import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

import java.util.*;  

import java.sql.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



class QuizGame 
{
    public static void main(String args[])
    {
       PMCO pmco = new PMCO();
       pmco.proceed();
    }
}


class PMCO implements ActionListener
{
    //Declaring All The Needed Components Here//
    
    
    // 1st Frame Components //
    
    ImageIcon ic = new ImageIcon("C:\\Users\\Harsh Sharma\\Downloads\\texture-wallpaper-e23.jpg");
     
    ImageIcon ic6 = new ImageIcon("E:\\Wallpapers\\App Icon.png");
     
    
    
    JLabel lb = new JLabel(ic);
      
    JLabel lb16 = new JLabel();
    
    
    
    JFrame f1 = new JFrame("Quiz Game Version 1.0.0.0");
    
    Font font3 = new Font("Century", Font.BOLD,17);
    
    JButton b1 = new JButton("New Game");
    JButton b2 = new JButton("Controls");
    JButton b3 = new JButton("About");
    JButton music = new JButton("Music");
    JButton b4 = new JButton("Quit");
    
    
    
    //1st Frame Components Ending//
    
    
    
    // 2nd Frame Components (For user to fill and save his name in the game)//
    
    ImageIcon ic7 = new ImageIcon("E:\\Wallpapers\\App Icon 1.png");
     
    
    JLabel lb17 = new JLabel(ic);
      
    JLabel lb18 = new JLabel();
    
    
    
    JFrame f2 = new JFrame("Registeration");
    
    JLabel lb1 = new JLabel("Name");
    
    JTextField t1 = new JTextField(10);
    
    JButton b5 = new JButton("Save");
    
    JProgressBar pb;
    
    JButton cancel = new JButton("Cancel");
    
    JLabel lb15 = new JLabel("Loading...");
    
    javax.swing.Timer t = new javax.swing.Timer(250,this);       //I've used the package itself over here, because a class named as Timer class also present in io package//
    
    //2nd Frame Components Ending//
    
    
    
    // 3rd Frame Components (We will directly Questions and options from Database)//
     
    
    JLabel lb19 = new JLabel(ic);
      
    JLabel lb20 = new JLabel();
    
    
    JFrame f3 = new JFrame("New Game");
    
    JLabel lb2 = new JLabel("");                        //It will be the Question Coming From Database//
    
    JLabel lb14 = new JLabel("Ques.)");
    
    ButtonGroup bg = new ButtonGroup();
    
    JRadioButton rb1 = new JRadioButton("");            //These 4 RadioButtons will be the 4 options coming from Database//
    JRadioButton rb2 = new JRadioButton("");
    JRadioButton rb3 = new JRadioButton("");
    JRadioButton rb4 = new JRadioButton("");
    
    JButton b6 = new JButton("Submit");
    
    //3rd Frame Components Ending//
    
    
    
    
    
    //5th Frame for Controls Option//

    
    JLabel lb23 = new JLabel(ic);
      
    JLabel lb24 = new JLabel();
    
    
    JFrame f5 = new JFrame("Controls");
    
    JLabel lb5 = new JLabel("Hello Gamer,");
    
    JLabel lb6 = new JLabel("You'll be asked 10 questions with each containing 4 options");
    
    JLabel lb7 = new JLabel("Kindly choose any one option with the help of your Mouse Pad.");
    
    JLabel lb8 = new JLabel("Thank You !");
    
    
    JButton b9 = new JButton("Go Back");
     
     
    //5th Frame Ending//
    
    
    
    
    //6th Frame for About Option//
   
    JLabel lb25 = new JLabel(ic);
      
    JLabel lb26 = new JLabel();
    
    
    JFrame f6 = new JFrame("About");
    
    JLabel lb9 = new JLabel("Hello there,");
    
    JLabel lb10 = new JLabel("This game is known as Quiz Game.");
    
    JLabel lb11 = new JLabel("This game is being Developed By an Engineering student named as HARSH SHARMA");
    
    JLabel lb12 = new JLabel("Thank You !");
    
    
    JButton b11 = new JButton("Go Back");
     
     
    //6th Frame Ending//
    
    
    
    
    //7th Frame For Displaying Error Message Box//
    
    JFrame f7 = new JFrame("!ERROR!");
    
    JLabel lb13 = new JLabel("Too many Characters Entered, Kindly Try Again !");
    
    JButton b12 = new JButton("Try Again");
    
    JButton b13 = new JButton("");  //Just because of Null Layout//
    
    //7th Frame Ending//
    
    
    
    
    //8th Frame for Music Option//
   
        
    ImageIcon ic8 = new ImageIcon("E:\\Wallpapers\\Sound On.jpg");
    
    ImageIcon ic9 = new ImageIcon("E:\\Wallpapers\\Sound OFF.jpg");
    

    
    JFrame f8 = new JFrame("Music");
    
    JLabel Turn_On = new JLabel("Turn On");
    
    JLabel Turn_Off = new JLabel("Turn Off");
    
    
    
    JButton Go_Back = new JButton("Go Back");
    
    JButton Switch_On = new JButton("");
    
    JButton Switch_Off = new JButton("");
     
     
    //8th Frame Ending//
    
     
    
    
    public int a,b,count=0,score=0;
    
    public int i=0;    
    
    
    public String name, user_answer,ans;
    
    
    Font font = new Font("Courier", Font.BOLD,18);
    
    Font font1 = new Font("Century", Font.BOLD,18);
    
    Font font2 = new Font("Century", Font.BOLD,22);
    
    Font font4 = new Font("Century", Font.BOLD,22);
    
    public String song="E:\\\\NCS Songs\\\\10convert.com_DEATH-NOTE-Trap-Remix_kyJ7heXazss.mp3";
 
    
    
    //MP3 File Code Here//
        
        MP3Player mp3 = new MP3Player(new File(song));
    
    //MP3 File Code Here//
        
    
    void proceed()
    {
        
        if(mp3.isStopped())
        {
            mp3.setRepeat(true);
        }
        
        //To Suffle the Elements//
        
        List<Integer> list = new ArrayList<Integer>();  
          //Add values in the list  
          list.add(01);  
          list.add(02);
          list.add(03);  
          list.add(04);
          list.add(05);  
          list.add(06);
          list.add(07);  
          list.add(8);
          list.add(9);  
          list.add(10);
          list.add(11);  
          list.add(12);
          list.add(13);  
          list.add(14);
          list.add(15);  
          list.add(16);
          list.add(17);  
          list.add(18);
          list.add(19);  
          list.add(20);
          list.add(21);
          list.add(22);  
          list.add(23);
          list.add(24);  
          list.add(25);
          list.add(26);  
          list.add(27);
          list.add(28);  
          list.add(29);
          list.add(30);  
    
          
          PMCO pm = new PMCO();

            Collections.shuffle(list);  
            
        a=pm.getRandomElement(list);
            
        
        //Ending of Shuffle Code Here//
         
       
        
       //MP3 File code //
        
        mp3.play();
        
        //MP3 File code Ended//
          
        
        //1st Frame Designing //
        
        b1.setPreferredSize(new Dimension(90,40));
        b1.setBounds(265, 70, 130, 50);
        
        b2.setPreferredSize(new Dimension(90,40));
        b2.setBounds(265, 170, 130, 50);
        
        b3.setPreferredSize(new Dimension(90,40));
        b3.setBounds(265, 350, 130, 50);
        
        music.setPreferredSize(new Dimension(90,40));
        music.setBounds(265, 450, 130, 50);
        
        b4.setPreferredSize(new Dimension(90,40));
        b4.setBounds(265, 550, 130, 50);
        
        
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        music.setBackground(Color.white);
        b4.setBackground(Color.white);
       
      
        
        lb.setBounds(00,00,700,670);
        
        b1.setFont(font3);
        b2.setFont(font3);
        b3.setFont(font3);
        music.setFont(font3);
        b4.setFont(font3);
        
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        music.addActionListener(this);
        b4.addActionListener(this);
        
        
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(music);
        f1.add(b4);
        f1.add(lb);
        f1.add(lb16);
    
        
        f1.setIconImage(ic6.getImage());
        f1.setLocation(350,30);
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setSize(700,700);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //1st Frame Designing Ended//
        
        
        //2nd Frame Designing //
        
        
        t1.getDocument().addDocumentListener(new DocumentListener() {
        public void changedUpdate(DocumentEvent e) {
        enableButton();
        }
        public void removeUpdate(DocumentEvent e) {
        enableButton();
        }
        public void insertUpdate(DocumentEvent e) {
        enableButton();
        }

        public void enableButton() {
        if (t1.getText().equals(""))
        {
        b5.setEnabled(false);
        }
        else
        {
        b5.setEnabled(true);
        }
       }

            
    });
        
        if (t1.getText().equals(""))
        {
        b5.setEnabled(false);
        }
        else
        {
        b5.setEnabled(true);
        }
        
        
       
        
        
        lb1.setPreferredSize(new Dimension(90,40));
        lb1.setBounds(120, 50, 130, 50);
        lb1.setFont(font4);
        lb1.setForeground(Color.white);
  
        
        
        t1.setPreferredSize(new Dimension(90,40));
        t1.setBounds(200, 60, 130, 30);
        t1.setFont(font3);
        
        
        b5.setPreferredSize(new Dimension(90,40));
        b5.setBounds(210, 130, 100, 40);
        b5.setBackground(Color.white);
        
        pb = new JProgressBar(0,20);
        pb.setVisible(false);
        pb.setBounds(210, 280, 100, 30);
        
        
        cancel.setVisible(true);
        cancel.setBounds(210, 280, 100, 30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.white);
        
        
        lb15.setPreferredSize(new Dimension(90,40));
        lb15.setBounds(220, 320, 130, 40);
        lb15.setFont(font);
        lb15.setVisible(false);
        lb15.setForeground(Color.white);
        
        b5.addActionListener(this);
        b5.setFont(font3);
        
        lb17.setBounds(00,00,600,513);
        
        
        f2.add(lb1);
        f2.add(t1);
        f2.add(b5);
        f2.add(pb);
        f2.add(lb15);
        f2.add(lb17);
        f2.add(lb18);
        f2.add(cancel);
        
        
        f2.setIconImage(ic7.getImage());
        f2.setLocation(350,50);
        f2.setVisible(false);
        f2.setLayout(null);
        f2.setSize(550,550);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //2nd Frame Designing Ended//
        
        
        
        //3rd Frame Designing //
        
        
        lb14.setPreferredSize(new Dimension(90,40));
        lb14.setBounds(10, 50, 100, 50);
        lb14.setFont(font2);
        lb14.setForeground(Color.white);
        
        
        lb2.setPreferredSize(new Dimension(90,40));
        lb2.setBounds(90, 50, 1500, 50);
        lb2.setFont(font2);
        lb2.setForeground(Color.white);
        
        
        rb1.setPreferredSize(new Dimension(90,40));
        rb1.setBounds(90, 100, 500, 50);
        rb1.setFont(font1);
        
        rb2.setPreferredSize(new Dimension(90,40));
        rb2.setBounds(90, 150, 500, 50);
        rb2.setFont(font1);
        
        rb3.setPreferredSize(new Dimension(90,40));
        rb3.setBounds(90, 200, 500, 50);
        rb3.setFont(font1);
        
        rb4.setPreferredSize(new Dimension(90,40));
        rb4.setBounds(90, 250, 500, 50);
        rb4.setFont(font1);
        
        
        
        b6.setPreferredSize(new Dimension(90,40));
        b6.setBounds(100, 320, 100, 40);
        b6.addActionListener(this);
        b6.setFont(font3);
        b6.setBackground(Color.white);
        
        lb19.setBounds(00,00,1000,513);
        
        
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        
        
        f3.add(lb14);
        f3.add(lb2);        //Question whuch will be asked//
        f3.add(rb1);        //Option 1//
        f3.add(rb2);        //OPtion 2//
        f3.add(rb3);        //Opyion 3//
        f3.add(rb4);        //Option 4//
        
        f3.add(b6);         //To submit user's Answer//
        
        f3.add(lb19);
        f3.add(lb20);
        
        f3.setIconImage(ic7.getImage());
        f3.setLocation(250,50);
        f3.setVisible(false);
        f3.setLayout(null);
        f3.setSize(1000,550);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //3rd Frame Designing Ended//
        
        
        
        
        //5th Frame Designing //
        
        lb5.setPreferredSize(new Dimension(90,40));
        lb5.setBounds(20, 50, 130, 100);
        lb5.setFont(font);
        lb5.setForeground(Color.white);
        
        lb6.setPreferredSize(new Dimension(90,40));
        lb6.setBounds(20, 70, 700, 100);
        lb6.setFont(font);
        lb6.setForeground(Color.white);
        
        lb7.setPreferredSize(new Dimension(90,40));
        lb7.setBounds(20, 90, 700, 100);
        lb7.setFont(font);
        lb7.setForeground(Color.white);
        
        lb8.setPreferredSize(new Dimension(90,40));
        lb8.setBounds(20, 110, 700, 100);
        lb8.setFont(font);
        lb8.setForeground(Color.white);
        
        b9.setPreferredSize(new Dimension(90,40));
        b9.setBounds(20, 200, 100, 30);
        b9.setBackground(Color.white);
       
        
        lb23.setBounds(00,00,650,600);
        
        b9.addActionListener(this);
        
        
        f5.add(lb5);
        f5.add(lb6);
        
        f5.add(lb7);
        f5.add(lb8);
        f5.add(b9);
        f5.add(lb23);
        f5.add(lb24);
        
        f5.setIconImage(ic6.getImage());
        f5.setLocation(300,50);
        f5.setVisible(false);
        f5.setLayout(null);
        f5.setSize(600,550);
        f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //5th Frame Designing Ended//
        
        
        
        
        //6th Frame Designing //
        
        
        lb9.setPreferredSize(new Dimension(90,40));
        lb9.setBounds(20, 50, 130, 100);
        lb9.setFont(font);
        lb9.setForeground(Color.white);
        
        lb10.setPreferredSize(new Dimension(90,40));
        lb10.setBounds(20, 70, 700, 100);
        lb10.setFont(font);
        lb10.setForeground(Color.white);
        
        lb11.setPreferredSize(new Dimension(90,40));
        lb11.setBounds(20, 90, 800, 100);
        lb11.setFont(font);
        lb11.setForeground(Color.white);
        
        lb12.setPreferredSize(new Dimension(90,40));
        lb12.setBounds(20, 110, 800, 100);
        lb12.setFont(font);
        lb12.setForeground(Color.white);
        
        b11.setPreferredSize(new Dimension(90,40));
        b11.setBounds(20, 200, 100, 30);
        b11.setBackground(Color.white);
        
        lb25.setBounds(00,00,800,650);
        
        b11.addActionListener(this);
       
        
        f6.add(lb9);
        f6.add(lb10);
        
        f6.add(lb11);
        f6.add(lb12);
        f6.add(b11);
        f6.add(lb25);
        f6.add(lb26);
        
        f6.setIconImage(ic6.getImage());
        f6.setLocation(250,50);
        f6.setVisible(false);
        f6.setLayout(null);
        f6.setSize(800,550);
        f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //6th Frame Designing Ended//
        
        
        
        
         //8th Frame Designing //
        
       
        
        Switch_On.setIcon(ic8);
        Switch_Off.setIcon(ic9);
        
        Go_Back.addActionListener(this);
        
        Go_Back.setBackground(Color.white);
        
        Switch_On.setBackground(Color.cyan);
        
        Switch_Off.setBackground(Color.red);
        
        Switch_On.addActionListener(this);
        
        Switch_Off.addActionListener(this);

     
       
        
        f8.add(Switch_On);     //Turn On Sound//
        f8.add(Switch_Off);     //Turn Off Sound//
        f8.add(Go_Back);     //Go Back Button//
        
        
        f8.setIconImage(ic6.getImage());
        f8.setLocation(550,300);
        f8.setVisible(false);
        f8.setLayout(new FlowLayout());
        f8.setSize(250,250);
     
        
        //8th Frame Designing Ended//
        
    }
    
    
    
    
     public int getRandomElement(List<Integer> list) 
    { 
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size())); 
    }
     
     
     
     

 
    public void actionPerformed(ActionEvent ae) 
    {
        
      //Code For Progress Bar//
        
        if(i==20)
        {
         f2.setVisible(false);
         f3.setVisible(true);
        }
        i++;
        pb.setValue(i);
        
      //Ended Code For Progress Bar//
        
        
       if(ae.getSource()==b1)
       {
           f1.setVisible(false);
           f2.setVisible(true);
       }
       
       
       if(ae.getSource()==b2)
       {
           f1.setVisible(false);
           f5.setVisible(true);
       }
       
       
       if(ae.getSource()==b3)
       {
           f1.setVisible(false);
           f6.setVisible(true);
       }
       
       
       if(ae.getSource()==b4)
       {
           System.exit(0);
       }
       
       
       if(ae.getSource()==b5)
       {
        
         if(t1.getText().length()>30)
         {
         
         lb13.setPreferredSize(new Dimension(90,40));
         lb13.setBounds(10, 05, 500, 50); 
         lb13.setFont(font1);
         
         b12.setPreferredSize(new Dimension(90,40));
         b12.setBounds(190, 60, 100, 30);  
         
         b12.addActionListener(this);
            
         f7.add(lb13);
         f7.add(b12);
         f7.add(b13);
            
         f7.setVisible(true);
         f7.setLayout(null);
         f7.setLocation(100,200);
         f7.setSize(500,150);
         f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
         
         
         
      try
      {
             
      name=t1.getText();
      
      Connection myCon;
      myCon = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-SD3HA9S:1521:xe", "system", "angiosperm");
      
      Statement st = myCon.createStatement();
      
      ResultSet rs = st.executeQuery("insert into Players values('"+name+"')");
     
          
      JOptionPane.showMessageDialog(f2, "Succesfully Registered");
      
      t1.setText("");
      t1.setEnabled(false);
      
      cancel.setVisible(false);
      lb15.setVisible(true);
      pb.setVisible(true);
      t.start();
      
      rs = st.executeQuery("select * from Questions where(Serial_No='"+a+"')");
      
      
      while(rs.next())
         {
              
            lb2.setText(rs.getString("Questions"));
            rb1.setText(rs.getString("Option_1"));
            rb2.setText(rs.getString("Option_2"));
            rb3.setText(rs.getString("Option_3"));
            rb4.setText(rs.getString("Option_4"));
            ans=rs.getString("Answer");
         }
      
      
         
         
  }
  catch(Exception e)
  {
     JOptionPane.showMessageDialog(f2, e);
  } 
         
   }
       
       
       
       
       if(ae.getSource()==b9)
       {
           f5.setVisible(false);
           f1.setVisible(true);
       }
       
       
       if(ae.getSource()==b11)
       {
           f6.setVisible(false);
           f1.setVisible(true); 
       }
       
       
       if(ae.getSource()==b12)
       {
           f7.setVisible(false);
           t1.setText("");
           f2.setVisible(true);
       }
       
       
      
       
       
       
       
       if(ae.getSource()==b6)
       {
          
           
           if(rb1.isSelected())
          {
            user_answer=rb1.getText();
            
            if(user_answer.equals(ans))
            {
                score+=1;
                
            }
        
        }
       
       
         if(rb2.isSelected())
            {
            user_answer=rb2.getText();
            
            if(user_answer.equals(ans))
            {
                score+=1;
                
            }
        }
       
       
       if(rb3.isSelected())
            {
            user_answer=rb3.getText();
            
            if(user_answer.equals(ans))
            {
                score+=1;
                
            }
        }
       
       
            
       if(rb4.isSelected())
            {
            user_answer=rb4.getText();
            
            if(user_answer.equals(ans))
            {
                score+=1;
                
            }
        }
        
        else 
        {
            score=score+0;
        }
           
           
           //To Suffle the Elements//
        
        List<Integer> list = new ArrayList<Integer>();  
          //Add values in the list  
          list.add(01);  
          list.add(02);
          list.add(03);  
          list.add(04);
          list.add(05);  
          list.add(06);
          list.add(07);  
          list.add(8);
          list.add(9);  
          list.add(10);
          list.add(11);  
          list.add(12);
          list.add(13);  
          list.add(14);
          list.add(15);  
          list.add(16);
          list.add(17);  
          list.add(18);
          list.add(19);  
          list.add(20);
          list.add(21);
          list.add(22);  
          list.add(23);
          list.add(24);  
          list.add(25);
          list.add(26);  
          list.add(27);
          list.add(28);  
          list.add(29);
          list.add(30);  
          
          
          PMCO pm1 = new PMCO();

            Collections.shuffle(list);  
            
        a=pm1.getRandomElement(list);
        
        count=count+1;
       
        
         
          if(count==10)
        {
           JOptionPane.showMessageDialog(f3,"Your Score :" +score);
           System.exit(0);
        }
        
          //Ending of Shuffle Code Here//
        
           
        
        
        
        try
      {
             
      
      Connection myCon;
      myCon = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-SD3HA9S:1521:xe", "system", "angiosperm");
      
      Statement st = myCon.createStatement();
      
      
      
      
      ResultSet rs1;
            rs1 = st.executeQuery("select * from Questions where(Serial_No='"+a+"')");
    
      
      
      while(rs1.next())
         {
              
            lb2.setText(rs1.getString("Questions"));
            rb1.setText(rs1.getString("Option_1"));
            rb2.setText(rs1.getString("Option_2"));
            rb3.setText(rs1.getString("Option_3"));
            rb4.setText(rs1.getString("Option_4"));
            ans=rs1.getString("Answer");
         
         }
         
          
        
      }
        
  catch(Exception e)
  {
     JOptionPane.showMessageDialog(f2, e);
  } 
        
           
        
        
       }
       
       
       if(ae.getSource()==music)
       {
           f1.setVisible(true);
           f8.setVisible(true);
       }
       
       if(ae.getSource()==Go_Back)
       {
           f8.setVisible(false);
           f1.setVisible(true);
       }
       
        if(ae.getSource()==Switch_On)
       {
           mp3.play();
       }
        
         if(ae.getSource()==Switch_Off)
       {
            if(mp3.isPaused())
           {
               mp3.play();
           }
           else
           {    
           mp3.pause();
           }
       }
         
         
       if(ae.getSource()==cancel)
       {
           f2.setVisible(false);
           f1.setVisible(true);
       }
       
       
    }
}

 

          
