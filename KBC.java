import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.*;  

import java.sql.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



class KBC 
{
    public static void main(String args[])
    {
       PMCO pmco = new PMCO();
       pmco.proceed();
    }
}


class PMCO extends JFrame implements ActionListener
{
    //Declaring All The Needed Components Here//
    
    
    // 1st Frame Components //
    
    JFrame f1 = new JFrame("KBC");
    
    JButton b1 = new JButton("New Game");
    JButton b2 = new JButton("Controls");
    JButton b3 = new JButton("About");
    JButton b4 = new JButton("Quit");
    
    
    JButton b10 = new JButton("");         //This button is created purposely because with null layout there are some kind of issues So the last button we would add will not display, that's why we created an extra button//
    
    
    //1st Frame Components Ending//
    
    
    
    // 2nd Frame Components (For user to fill and save his name in the game)//
    
    JFrame f2 = new JFrame("Registeration");
    
    JLabel lb1 = new JLabel("Name");
    
    JTextField t1 = new JTextField(10);
    
    JButton b5 = new JButton("Save");
    
    JProgressBar pb;
    
    JLabel lb15 = new JLabel("Loading...");
    
    javax.swing.Timer t = new javax.swing.Timer(250,this);       //I've used the package itself over here, because a class named as Timer class also present in io package//
    
    //2nd Frame Components Ending//
    
    
    
    // 3rd Frame Components (We will directly drag their appearance from Database)//
    
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
    
    
    
    // 4rth Frame Components (It will show user the )//
    
    JFrame f4 = new JFrame("Game Over");
    
    JLabel lb3 = new JLabel("Your Name  :");
    JLabel lb4 = new JLabel("Your Score :");
    
    JButton b7 = new JButton("Play Again");
    JButton b8 = new JButton("Exit");
    
    
    //4rth Frame Components Ending//
    
    
    
    
    //5th Frame for Controls Option//
    
    JFrame f5 = new JFrame("Controls");
    
    JLabel lb5 = new JLabel("Hello Gamer,");
    
    JLabel lb6 = new JLabel("You'll be asked 10 questions with each containing 4 options");
    
    JLabel lb7 = new JLabel("Kindly choose any one option with the help of your Mouse Pad.");
    
    JLabel lb8 = new JLabel("Thank You !");
    
    
    JButton b9 = new JButton("Go Back");
     
     
    //5th Frame Ending//
    
    
    
    
    //6th Frame for Controls Option//
    
    JFrame f6 = new JFrame("About");
    
    JLabel lb9 = new JLabel("Hello there,");
    
    JLabel lb10 = new JLabel("This game is known as KBC.");
    
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
    
     
    
    
    public int a,b,count=0,score=0;
    
    public int i=0;    
    
    
    public String name, user_answer,ans;
    
    
    Font font = new Font("Courier", Font.BOLD,18);
    
    Font font1 = new Font("Century", Font.BOLD,18);
    
    Font font2 = new Font("Century", Font.BOLD,22);
    
    
    
    
    void proceed()
    {
        
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
            
          //System.out.println("Shuffled Number :" +a);  
        
          //Ending of Shuffle Code Here//
          
          
          
        
        //1st Frame Designing //
        
        b1.setPreferredSize(new Dimension(90,40));
        b1.setBounds(200, 50, 130, 50);
        
        b2.setPreferredSize(new Dimension(90,40));
        b2.setBounds(200, 150, 130, 50);
        
        b3.setPreferredSize(new Dimension(90,40));
        b3.setBounds(200, 250, 130, 50);
        
        b4.setPreferredSize(new Dimension(90,40));
        b4.setBounds(200, 350, 130, 50);
        
        b10.setPreferredSize(new Dimension(90,40));
        b10.setBounds(200, 450, 130, 50);
        
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b10);
    
        
        

        
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setSize(550,550);
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
        lb1.setBounds(130, 50, 130, 50);
        lb1.setFont(font);
        
        t1.setPreferredSize(new Dimension(90,40));
        t1.setBounds(200, 60, 130, 30);
        
        
        b5.setPreferredSize(new Dimension(90,40));
        b5.setBounds(210, 130, 100, 40);
        
        pb = new JProgressBar(0,20);
        pb.setVisible(false);
        pb.setBounds(210, 200, 100, 30);
        
        
        lb15.setPreferredSize(new Dimension(90,40));
        lb15.setBounds(220, 250, 130, 40);
        lb15.setFont(font);
        lb15.setVisible(false);
        
        b5.addActionListener(this);
        
        
        f2.add(lb1);
        f2.add(t1);
        f2.add(b5);
        f2.add(pb);
        f2.add(lb15);
        
        
        f2.setVisible(false);
        f2.setLayout(null);
        f2.setSize(550,550);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //2nd Frame Designing Ended//
        
        
        
        //3rd Frame Designing //
        
        
        lb14.setPreferredSize(new Dimension(90,40));
        lb14.setBounds(10, 50, 100, 50);
        lb14.setFont(font2);
        
        
        lb2.setPreferredSize(new Dimension(90,40));
        lb2.setBounds(90, 50, 1500, 50);
        lb2.setFont(font2);
        
        
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
        b6.setBounds(90, 300, 100, 40);
        b6.addActionListener(this);
        
        
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
        
        
        f3.setVisible(false);
        f3.setLayout(null);
        f3.setSize(1000,550);
        f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //3rd Frame Designing Ended//
        
        
        
        //4rth Frame Designing //
        
        f4.add(lb3);
        f4.add(lb4);
        
        f4.add(b7);
        f4.add(b8);
        
        f4.setVisible(false);
        f4.setLayout(null);
        f4.setSize(550,550);
        f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //4rth Frame Designing Ended//
        
        
        
        
        //5th Frame Designing //
        
        lb5.setPreferredSize(new Dimension(90,40));
        lb5.setBounds(20, 50, 130, 100);
        lb5.setFont(font);
        
        lb6.setPreferredSize(new Dimension(90,40));
        lb6.setBounds(20, 70, 700, 100);
        lb6.setFont(font);
        
        lb7.setPreferredSize(new Dimension(90,40));
        lb7.setBounds(20, 90, 700, 100);
        lb7.setFont(font);
        
        lb8.setPreferredSize(new Dimension(90,40));
        lb8.setBounds(20, 110, 700, 100);
        lb8.setFont(font);
        
        b9.setPreferredSize(new Dimension(90,40));
        b9.setBounds(20, 200, 100, 30);
        
        b9.addActionListener(this);
        
        
        f5.add(lb5);
        f5.add(lb6);
        
        f5.add(lb7);
        f5.add(lb8);
        f5.add(b9);
        
        f5.setVisible(false);
        f5.setLayout(null);
        f5.setSize(600,550);
        f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //5th Frame Designing Ended//
        
        
        
        
        //6th Frame Designing //
        
        
        lb9.setPreferredSize(new Dimension(90,40));
        lb9.setBounds(20, 50, 130, 100);
        lb9.setFont(font);
        
        lb10.setPreferredSize(new Dimension(90,40));
        lb10.setBounds(20, 70, 700, 100);
        lb10.setFont(font);
        
        lb11.setPreferredSize(new Dimension(90,40));
        lb11.setBounds(20, 90, 800, 100);
        lb11.setFont(font);
        
        lb12.setPreferredSize(new Dimension(90,40));
        lb12.setBounds(20, 110, 800, 100);
        lb12.setFont(font);
        
        b11.setPreferredSize(new Dimension(90,40));
        b11.setBounds(20, 200, 100, 30);
        
        b11.addActionListener(this);
       
        
        f6.add(lb9);
        f6.add(lb10);
        
        f6.add(lb11);
        f6.add(lb12);
        f6.add(b11);
        
        f6.setVisible(false);
        f6.setLayout(null);
        f6.setSize(800,550);
        f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //6th Frame Designing Ended//
        
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
           f1.setVisible(false);
           f1.dispose();
           f2.dispose();
           f3.dispose();
           f4.dispose();
           f5.dispose();
           f6.dispose();
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
      myCon = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-1ADM7K8:1522:xe", "system", "angiosperm");
      
      Statement st = myCon.createStatement();
      
      ResultSet rs = st.executeQuery("insert into Players values('"+name+"')");
     
          
      JOptionPane.showMessageDialog(f2, "Succesfully Registered");
      
      t1.setText("");
       
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
            b6.setVisible(false);
           lb2.setVisible(false);
          lb14.setVisible(false);
           rb1.setVisible(false);
           rb2.setVisible(false);
           rb3.setVisible(false);
           rb4.setVisible(false);
           f3.dispose();
           f2.dispose();
           f1.dispose();
        }
        
          //Ending of Shuffle Code Here//
        
           
        
        
        
        try
      {
             
      
      Connection myCon;
      myCon = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-1ADM7K8:1522:xe", "system", "angiosperm");
      
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
    }
}

 

          