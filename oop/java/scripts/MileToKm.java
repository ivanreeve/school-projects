package com.bsis2a.ivanreevelopez;
import javax.swing.*;

public class MileToKm {
    
    public static void main(String args[]) {
        final String TITLE = "Unit Converter (Miles to Kilometers)";
        final float KILOMETER_PER_MILE = 1.60935f;
        float mile, km;
        String strInput;
        
        strInput = JOptionPane.showInputDialog(null, "Enter distance (in miles): ", TITLE, JOptionPane.PLAIN_MESSAGE);
        
        if(strInput != null){
            try {
                mile = Float.parseFloat(strInput);
                km = Float.parseFloat(String.format("%.5f", mile * KILOMETER_PER_MILE));
                JOptionPane.showMessageDialog(null, mile + (mile > 1 ? " miles" : " mile") + " is equivalent to " + km + (km > 1 ? " kilometers" : " kilometer"), TITLE, JOptionPane.INFORMATION_MESSAGE);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Your input is invalid.", TITLE + " - Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
