import static org.springframework.security.crypto.util.EncodingUtils.concatenate;
import static org.springframework.security.crypto.util.EncodingUtils.subArray;

import java.util.Objects;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.util.EncodingUtils;
import org.springframework.util.Base64Utils;

/**
 * @author : lvpeng01
 * @since : 2023/4/23
 **/
public class CipherTest {

    public static void main(String[] args) {

        String userName = "wangzhen";
        String pwd = "wangzhen0505";

        String rawPassword = "";
        String rawPasswordString = null;
        byte[] rawPasswordByteArray = Base64Utils.decodeFromString(rawPassword.toString());
        rawPasswordString = new String(rawPasswordByteArray);


        String base64Encode = Base64Utils.encodeToString(pwd.getBytes());
        System.out.println("base64 encode = " + base64Encode);

        CipherTest ct = new CipherTest();
        String encode = ct.passwordEncoder().encode(pwd);
        System.out.println("md5 encode = " + encode);
        System.out.println("match result is : " + ct.passwordEncoder().matches(base64Encode, encode));



    }

    public PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder() {
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String rawPasswordString = rawPassword.toString();
                String ciphertextSwitch = "true";
                if (Objects.equals("true", ciphertextSwitch)) {
                    byte[] rawPasswordByteArray = Base64Utils.decodeFromString(rawPassword.toString());
                    rawPasswordString = new String(rawPasswordByteArray);
                }
                byte[] digested = Hex.decode(encodedPassword);
                byte[] salt = subArray(digested, 0, KeyGenerators.secureRandom().getKeyLength());
                byte[] encoded = encodeAndConcatenate(rawPasswordString, salt);
                String actual = String.valueOf(Hex.encode(encoded));
                return Objects.equals(actual, encodedPassword);

            }

            @Override
            protected byte[] encode(CharSequence rawPassword, byte[] salt) {
                String secret = "sfg!123";
                byte[] digest = encode(concatenate(salt, Utf8.encode(secret), Utf8.encode(rawPassword)));
                return concatenate(salt, digest);
            }
        };
    }

}
