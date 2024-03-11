//Non-Interactive version
package com.bsis2a.ivanreevelopez;
import javax.swing.*;

public class TestMinFormat {
    
    public static void main(String args[]) {
        final String TITLE = "Unit Converter (Hours and Minutes)";
        final int WORK_MINUTE = 197;
        final int MINUTE_PER_HOUR = 60;
        int hour,minute;        

        minute = WORK_MINUTE;
        hour = (minute/MINUTE_PER_HOUR);
        minute = minute - (hour*MINUTE_PER_HOUR);

        JOptionPane.showMessageDialog(null, WORK_MINUTE + (WORK_MINUTE > 1 ? " minutes" : " minute") + " is equivalent to " + (hour > 0 ? hour + (hour > 1 ? " hours " : " hour ") : "") + (minute > 0 ? minute + (minute > 1 ? " minutes " : " minute ") : (hour > 0 ? "" : minute + " minute ")), TITLE, JOptionPane.INFORMATION_MESSAGE);
    }
}
