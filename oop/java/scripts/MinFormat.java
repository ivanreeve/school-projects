//Interactive version
package com.bsis2a.ivanreevelopez;
import javax.swing.*;

public class MinFormat {
    
    public static void main(String args[]) {
        final String TITLE = "Unit Converter (Hours and Minutes)";
        final int MINUTE_PER_HOUR = 60;
        int hour,minute,totalMinute;
        String strInput;
        
        strInput = JOptionPane.showInputDialog(null, "Enter work minutes: ", TITLE, JOptionPane.PLAIN_MESSAGE);
        if(strInput != null){
            try {
                minute = Integer.parseInt(strInput);
                totalMinute = minute; //Store a copy of the minute input
                hour = (minute/MINUTE_PER_HOUR);
                minute = minute - (hour*MINUTE_PER_HOUR);
                
                JOptionPane.showMessageDialog(null, totalMinute + (totalMinute > 1 ? " minutes" : " minute") + " is equivalent to " + (hour > 0 ? hour + (hour > 1 ? " hours " : " hour ") : "") + (minute > 0 ? minute + (minute > 1 ? " minutes " : " minute ") : (hour > 0 ? "" : minute + " minute ")), TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Your input is invalid.", TITLE + " - Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
