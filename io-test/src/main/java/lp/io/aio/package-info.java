/**
 * 异步io模型，在jdk1.7中正式引入，与nio相比，aio是正常的异步io模型
 * （nio需要通过selector进行轮询）
 *
 * 优点：多请求不需要对应额外线程进行处理，相对于nio模型，api得到了简化，可靠性好
 * 缺点：api复杂度相对仍较复杂，不易于调试，基本同nio
 *
 * Created by lvpeng01 on 2018/9/30.
 */
package lp.io.aio;