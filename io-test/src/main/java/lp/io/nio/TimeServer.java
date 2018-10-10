package lp.io.nio;

/**
 * Created by lvpeng01 on 2018/10/8.
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8001;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(" error port ");
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }

}
