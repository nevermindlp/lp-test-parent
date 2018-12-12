package lp.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by lvpeng01 on 2018/12/3.
 */
public class TokenException extends AuthenticationException {
    public TokenException(String msg, Throwable t) {
        super(msg, t);
    }

    public TokenException(String msg) {
        super(msg);
    }
}
