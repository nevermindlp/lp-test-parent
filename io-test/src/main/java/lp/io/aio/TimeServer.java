package lp.io.aio;

/**
 * Created by lvpeng01 on 2018/10/8.
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8002;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(" port num error.");
            }
        }
        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler, "AIO-AsyncTimeServerHandler-001").start();
    }
}
