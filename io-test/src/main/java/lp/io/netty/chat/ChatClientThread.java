package lp.io.netty.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.netty.buffer.ByteBuf;

/**
 * Created by lvpeng01 on 2018/10/10.
 */
public class ChatClientThread implements Runnable {
    public void run() {
        for (;;) {
            if (ChatClientHandler.contextHolder != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String info = br.readLine();
                    System.out.println("in info = " + info);
                    String msg = info;
                    ByteBuf encoded = ChatClientHandler.contextHolder.alloc().buffer(4 * msg.length());
                    encoded.writeBytes(msg.getBytes());
                    ChatClientHandler.contextHolder.writeAndFlush(encoded);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("waiting client connect .. ");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
