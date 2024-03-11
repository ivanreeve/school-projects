package com.bsis2a.ivanreevelopez;
import java.awt.*;
import javax.swing.*;

public class TimeToSec {
    
    public static void main(String args[]) {
        final String TITLE = "Unit Converter (Seconds)";
        final int SECOND_PER_HOUR = 3600;
        final int SECOND_PER_MINUTE = 60;
        int hour,minute,second,totalSecond,result;
        
        JTextField hourField = new JTextField(10);
        JTextField minuteField = new JTextField(10);
        JTextField secondField = new JTextField(10);
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(1, 1, 1, 1);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        inputPanel.add(new JLabel("Hour "), constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        inputPanel.add(hourField, constraints);        
        hourField.setText("0");
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        inputPanel.add(new JLabel("Minute "), constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        inputPanel.add(minuteField, constraints);
        minuteField.setText("0");
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        inputPanel.add(new JLabel("Second "), constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        inputPanel.add(secondField, constraints);
        secondField.setText("0");
        
        result = JOptionPane.showConfirmDialog(null, inputPanel, TITLE,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION){
            try {
                hour = Integer.parseInt(hourField.getText());
                minute = Integer.parseInt(minuteField.getText());
                second = Integer.parseInt(secondField.getText());
                totalSecond = (hour * SECOND_PER_HOUR) + (minute * SECOND_PER_MINUTE) + second;
                JOptionPane.showMessageDialog(null, (hour > 0 ? hour + (hour > 1 ? " hours " : " hour ") : "") + (minute > 0 ? minute + (minute > 1 ? " minutes " : " minute ") : "") + (second > 0 ? second + (second > 1 ? " seconds " : " second ") : (hour > 0 || minute > 0 ? "" : second + " second ")) + "is equivalent to " + totalSecond + (totalSecond > 1 ? " seconds" : " second"), TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Some or all of your input may be empty or invalid.", TITLE + " - Failed", JOptionPane.WARNING_MESSAGE);
            }
        }        
    }
}