/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Test3 extends JFrame implements ActionListener {
    
    JLabel header, chooseRoom,days , people , cost , additional;
    JTextField txtDays , txtPeople , txtCost;
    JPanel top,middle,bottom;
    JRadioButton standard , deluxe, suite ;
    JButton btnReserve , btnClear , btnExit;
    JCheckBox extraBed;
    ButtonGroup btnGroup;
    
    
   public Test3(){
       top = new JPanel();
       middle = new JPanel(new GridLayout(6,2 ,0 ,0));
       bottom = new JPanel();
       
       header= new JLabel("<HTML><CENTER><h2>Welcome To AP's B&B</h2></CENTER></HTML");
       chooseRoom = new JLabel("Choose room");
       additional = new JLabel("Choose Meals");
       days = new JLabel ("Enter Number of days:",JLabel.RIGHT);
       people = new JLabel("Enter number of people:",JLabel.RIGHT);
       cost = new JLabel ("Cost is:",JLabel.RIGHT);
       
       
      
       txtDays = new JTextField(JTextField.RIGHT);
       txtPeople = new JTextField(JTextField.RIGHT);
       txtCost = new JTextField(JTextField.RIGHT);
       txtCost.setEditable(false);
       
       standard = new JRadioButton("Standard");
       standard.setFocusable(false);
       deluxe = new JRadioButton("Deluxe");
       deluxe.setFocusable(false);
       suite = new JRadioButton("Suite");
       suite.setFocusable(false);
       extraBed = new JCheckBox("ExtraBed");
       extraBed.setFocusable(false);
       
       btnReserve = new JButton("Reserve Room");
       btnReserve.setFocusable(false);
       btnClear = new JButton("Clear");
       btnClear.setFocusable(false);
       btnExit = new JButton("Exit");
       btnExit.setFocusable(false);
       
       top.add(header);
       middle.add(chooseRoom);
       middle.add(days);
       middle.add(standard);
       middle.add(txtDays);
       middle.add(deluxe);
       middle.add(people);
       middle.add(suite);
       middle.add(txtPeople);
       middle.add(additional);
       middle.add(cost);
       middle.add(extraBed);
       middle.add(txtCost);
      
       bottom.add(btnReserve);
       btnReserve.addActionListener(this);
       bottom.add(btnClear);
       btnClear.addActionListener(this);
       bottom.add(btnExit);
       btnExit.addActionListener(this);
       
       standard.setSelected(true);
       
       btnGroup=new ButtonGroup();
       btnGroup.add(standard);
       btnGroup.add(deluxe);
       btnGroup.add(suite);
       
       add(top,BorderLayout.NORTH);
       add(middle,BorderLayout.CENTER);
       add(bottom,BorderLayout.SOUTH);
       
   }
   
           
    public static void main(String[] args) {
        Test3 tr = new Test3();
        tr.setTitle("AP's BNB");
        tr.setDefaultCloseOperation(Test3.EXIT_ON_CLOSE);
        tr.setSize(500,500);
        tr.setVisible(true);
        tr.setLocation(10,10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cost=0;
        double total;
        if (e.getSource()== btnExit){
                int n =JOptionPane.showConfirmDialog(null , "Do you want to exit?" ,"Exit Page", JOptionPane.OK_CANCEL_OPTION , JOptionPane.QUESTION_MESSAGE);
    
                if (n== JOptionPane.OK_OPTION){
                     System.exit(0);
        }
    
}
        if(e.getSource()==btnClear){
            txtDays.setText(null);
            txtPeople.setText(null);
            txtCost.setText(null);
               
        }
        if (e.getSource()==btnReserve){
            int numDays = Integer.parseInt(txtDays.getText());
            int numPeople = Integer.parseInt(txtPeople.getText());
            
            if(standard.isSelected()){
                 cost= 300;
            }
            else if(deluxe.isSelected()){
                 cost = 550;
                
            }
            else if(suite.isSelected()){
                 cost = 1000;
                 }
            total = 100+700+(cost * numPeople)*numDays; 
            txtCost.setText("R"+total);
        }

            
    }
}