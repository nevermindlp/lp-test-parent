import org.apache.commons.codec.digest.DigestUtils;

/**
 * created by Ryoma on 2016/11/17 in project of nengli .
 *
 * @author Ryoma
 * @date 2016/11/17
 */
public class Md5PasswordEncoder extends AbstractSecretPasswordEncoder {

    public Md5PasswordEncoder() {
        super();
    }

    public Md5PasswordEncoder(CharSequence secret) {
        super(secret);
    }

    @Override
    protected byte[] encode(byte[] bytes) {
        return DigestUtils.md5(bytes);
    }
}
