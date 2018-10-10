/**
 * 非阻塞io，在jdk1.4之后sun对于饱受诟病的bio进行了优化，其实现方式经过了 select/poll到
 * 1.5epoll的演化
 * 最为常用的io模型，netty便是基于此的实现，成为了非常成功的网络通信框架
 * 优点：多请求一线程的模式，在底层实现方式改为epoll后更是将并发从1024/2048
 * 提升为上万的并发，可靠性高
 * 缺点：api复杂度高，不易于调试
 *
 * Created by lvpeng01 on 2018/9/30.
 */
package lp.io.nio;