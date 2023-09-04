import static org.springframework.security.crypto.util.EncodingUtils.concatenate;

import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.crypto.password.AbstractPasswordEncoder;

/**
 * created by Ryoma on 2016/11/17 in project of nengli .
 *
 * @author Ryoma
 * @date 2016/11/17
 */
public abstract class AbstractSecretPasswordEncoder extends AbstractPasswordEncoder {

    private byte[] secret;

    public AbstractSecretPasswordEncoder() {
        this("");
    }

    public AbstractSecretPasswordEncoder(CharSequence secret) {
        super();
        this.secret = Utf8.encode(secret);
    }

    @Override
    protected byte[] encode(CharSequence rawPassword, byte[] salt) {
        byte[] digest = encode(concatenate(salt, secret, Utf8.encode(rawPassword)));
        return concatenate(salt, digest);
    }

    protected abstract byte[] encode(byte[] bytes);
}

