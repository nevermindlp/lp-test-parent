package lp.io.aio;

/**
 * Created by lvpeng01 on 2018/10/9.
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8002;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
    }

}
