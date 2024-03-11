package com.bsis2a.ivanreevelopez;
import javax.swing.*;

public class SecToTime {

    public static void main(String args[]) {
        final String TITLE = "Unit Converter (Hours, Minutes and Seconds)";
        final int SECOND_PER_HOUR = 3600;
        final int SECOND_PER_MINUTE = 60; 
        int hour,minute,second,totalSecond; 
        String strInput;
        
        strInput = JOptionPane.showInputDialog(null, "Enter time (in seconds): ", TITLE, JOptionPane.PLAIN_MESSAGE);
        
        if(strInput != null){
            try {
                second = Integer.parseInt(strInput);
                totalSecond = second; //Store a copy of the second input
                hour = (second/SECOND_PER_HOUR);     
                second = second - (hour*SECOND_PER_HOUR);
                minute = (second/SECOND_PER_MINUTE);
                second = second - (minute*SECOND_PER_MINUTE);                
                
                JOptionPane.showMessageDialog(null, totalSecond + (totalSecond > 1 ? " seconds" : " second") + " is equivalent to " + (hour > 0 ? hour + (hour > 1 ? " hours " : " hour ") : "") + (minute > 0 ? minute + (minute > 1 ? " minutes " : " minute ") : "") + (second > 0 ? second + (second > 1 ? " seconds " : " second ") : (hour > 0 || minute > 0 ? "" : second + " second ")), TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Your input is invalid.", TITLE + " - Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
