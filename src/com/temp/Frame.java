package com.temp;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame  extends JFrame implements ActionListener, KeyListener {
    private JButton button;
    private JTextField inputField;
    private String temp="";
    private JLabel label;
        Frame() {
            setInputField();
            setButton();
            setLabel();
            ImageIcon image = new ImageIcon("images/calculator.png");
            this.setTitle("Calculator");
            this.setSize(500, 350);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setIconImage(image.getImage());
            //this.getContentPane().setBackground(new Color(0x123456));
            this.getContentPane().setBackground(new Color(0xed8a09));
            this.setLayout(null);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
        public String getExpression() {
            return temp;
        }
        private void setButton(){
            button= new JButton();
            button.setText("Calculate");
            button.setFont(new Font("Comic Sans",Font.ITALIC,15));
            button.setBounds(190,120,110,20);
            //button.setPreferredSize(new Dimension(110,25));
            button.addActionListener(this);
            button.setFocusable(false);
            button.setForeground(new Color(0x1189d4));
            button.setBackground(Color.darkGray);
            button.setBorder(BorderFactory.createEtchedBorder());
            button.setEnabled(false);
            this.add(button);
        }
        private void setInputField() {
            inputField = new JTextField();
            inputField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
            inputField.setFont(new Font("Comic Sans",Font.BOLD,15));
            inputField.setBackground(new Color(0xb5b2ae));
            inputField.setBounds(110,50,250,40);
            inputField.addKeyListener(this);
            this.add(inputField);
        }

        private void setLabel(){
            label = new JLabel();
            label.setVisible(false);
            label.setBounds(135,155,200,20);
            label.setFont(new Font("Comic Sans",Font.BOLD,15));
            this.add(label);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==button){
                temp=inputField.getText();
                label.setVisible(true);
                Expression res;
                try {
                    res = new ExpressionBuilder(temp).build();
                    label.setText(String.valueOf(res.evaluate()));
                }
                catch (Exception exception)
                {
                    label.setText("Invalid Expression");
                }
                finally {
                    inputField.setText("");
                    button.setEnabled(false);
                }

            }
        }

    @Override
    public void keyTyped(KeyEvent e) {
        button.setEnabled(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
