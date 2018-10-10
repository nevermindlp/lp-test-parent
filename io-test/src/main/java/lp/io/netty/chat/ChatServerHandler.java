package lp.io.netty.chat;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by lvpeng01 on 2018/10/9.
 */
public class ChatServerHandler extends ChannelHandlerAdapter {

    public static ConcurrentHashMap<String, ChannelHandlerContext> clientMap = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, List<String>> groupMap = new ConcurrentHashMap<>();

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        System.out.println("The chat server receive msg : " + body);
//        ByteBuf resp = Unpooled.copiedBuffer("success".getBytes());
//        ctx.writeAndFlush(resp);
        String reqStr = parseRequestBody(body);
        requestHandler(ctx, reqStr);
    }

    // reqStr format : 1#lp, 2#lp#hello#wzy, 2#lp#hi#g-1, 3#g-1#lp,wxy
    private void requestHandler(ChannelHandlerContext ctx, String reqStr) {
        String[] array = reqStr.split("#");
        if (array.length == 2) {
            // register order
            registerMemberAndPublishToAll(ctx, array[1]);
        } else if (array.length == 4) {
            if ("2".equals(array[0])) {
                // msg order
                sendMsg(array[1], array[2], array[3]);
            }
        } else if (array.length == 3) {
            if ("3".equals(array[0])) {
                createGroup(array[1], array[2]);
            }
        } else {
            // error order
            System.err.println("error order.");
        }

    }

    private void createGroup(String groupName, String members) {
        String[] memberArray = members.split(",");
        List<String> memberList = Lists.newArrayList(memberArray);
        if (!groupMap.containsKey(groupName)) {
            groupMap.put(groupName, memberList);
        }
        clientMap.forEach((k, v) -> {
            if (memberList.contains(k)) {
                String joinGroupInfo = "3#" + groupName + "#" + members;
                v.writeAndFlush(Unpooled.copiedBuffer(joinGroupInfo.getBytes()));
            }
        });
    }

    private void sendMsg(String from, String msg, String to) {

        if (StringUtils.isNotBlank(from)
                && StringUtils.isNotBlank(msg)
                && StringUtils.isNotBlank(to)) {
            List<String> toMembers = Lists.newArrayList();
            if (to.startsWith("g-")) {
                List<String> groupMembers = groupMap.get(to);
                if (groupMembers != null) {
                    toMembers.addAll(groupMembers);
                }
            } else {
                toMembers.add(to);
            }
            clientMap.forEach((k, v) -> {
                if (toMembers.contains(k)) {
                    String sendMsg = "2#" + from + "#" + msg + "#" + to;
                    v.writeAndFlush(Unpooled.copiedBuffer(sendMsg.getBytes()));
                }
            });
        }
    }

    private void registerMemberAndPublishToAll(ChannelHandlerContext ctx, String member) {
        if (!clientMap.containsKey(member)) {
            clientMap.put(member, ctx);
            clientMap.forEach((k ,v) -> {
                if (!k.equals(member)) {
                    String joinInfo = "1#" + member;
                    v.writeAndFlush(Unpooled.copiedBuffer(joinInfo.getBytes()));
                } else {
                    try {
                        List<String> keyList = Lists.newArrayList();
                        clientMap.keySet().forEach(keyList::add);
                        keyList.remove(member);
                        String totalMemberInfo = "1#" + mapper.writeValueAsString(keyList);
                        v.writeAndFlush(Unpooled.copiedBuffer(totalMemberInfo.getBytes()));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            System.out.println("member already exist.");
        }
    }

    private String parseRequestBody(String body) {
        return body;
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

}
