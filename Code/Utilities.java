package Code;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Atahan Ekici
 */
public class Utilities 
{
    
public static String getCurrentTime()
{
Date date = new Date();
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH);
int day = calendar.get(Calendar.DAY_OF_MONTH);
int hours = calendar.get(Calendar.HOUR_OF_DAY);
int minutes = calendar.get(Calendar.MINUTE);
int second = calendar.get(Calendar.SECOND);
return String.format("%02d.%02d.%04d %02d:%02d:%02d",day,month,year,hours,minutes,second);
}
    
public static String calculateTime(int seconds)
{
int hour = (seconds/60)/60;
int minute = (seconds / 60)%60;
int sec = seconds % 60;
return String.format("%02d:%02d:%02d", hour,minute,sec);
}

public static String SHA_256(String text)
{
String hashed = null;
try
{
MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
return Base64.getEncoder().encodeToString(hash);
}
catch(Exception e)
{
JOptionPane.showMessageDialog( null, "Can not Hash Given String", "ERROR!", JOptionPane. ERROR_MESSAGE);
}
return hashed;
}
}
