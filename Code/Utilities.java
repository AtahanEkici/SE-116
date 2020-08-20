package Code;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author Atahan Ekici
 */
public class Utilities 
{
public static String calculateTime(int seconds)
{
int hour = (seconds/60)/60;
int minute = (seconds / 60)%60;
int sec = seconds % 60;
return String.format("%02d:%02d:%02d", hour,minute,sec);
}
    
public static String SHA_256(String text) throws NoSuchAlgorithmException
{
MessageDigest digest = MessageDigest.getInstance("SHA-256");
byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
return Base64.getEncoder().encodeToString(hash);
}
}
