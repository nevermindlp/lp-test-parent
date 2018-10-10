package lp.io.nio;

/**
 * Created by lvpeng01 on 2018/10/8.
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8001;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1", port), "TimeClient-001").start();
    }

}
