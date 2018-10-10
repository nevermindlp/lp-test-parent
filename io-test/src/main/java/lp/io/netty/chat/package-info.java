/**
 * chat service function：
 * 1、client连接上报连入者昵称
 * 2、client拉取所有连入者列表（当有新人加入时候主动推送）
 * 3、client可以创建聊天组
 * 4、接受client msg，包括：聊天内容 + 对象（对象可能是一个人或一个组）
 * 5、将消息推送给指定人或者组
 *
 * Created by lvpeng01 on 2018/10/9.
 */
package lp.io.netty.chat;