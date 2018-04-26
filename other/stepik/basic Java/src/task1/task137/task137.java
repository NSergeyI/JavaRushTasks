package task1.task137;

/**
 * Created by winnie on 17.07.17.
 */
import java.security.MessageDigest;

public class task137 {


        public static void main(String[] args) throws Exception {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
            for (byte b : digest) {
                System.out.printf("%02x", b);
            }
    }
}
