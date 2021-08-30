package lp.swig;


import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.baidu.cie.superarchive.v2.web.identify.IdentifyOperatorHandle;
import com.baidu.cie.superarchive.v2.web.identify.TaskContext;
import com.baidu.cie.superarchive.v2.web.identify.UnorderedMapStringString;

/**
 * 缺少so的逻辑，整体使用swig来实现java与c++的交互
 *
 * 参考：
 * https://blog.csdn.net/kristenstewert/article/details/74623508
 * https://www.cnblogs.com/fnlingnzb-learner/p/7278524.html
 * http://www.swig.org/
 *
 */
public class TestSwigThread {

	public static void main(String[] args) {
		final IdentifyOperatorHandle identifyOperatorHandle = new IdentifyOperatorHandle();
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            cachedThreadPool.execute(() -> {
                TaskContext t = new TaskContext();
                t.setCurrentTaskId(BigInteger.TEN);
                UnorderedMapStringString unorderedMapStringString = new UnorderedMapStringString();
                unorderedMapStringString.put("testK1", "testV1");
                unorderedMapStringString.put("testK2", "testV2");
                boolean b = identifyOperatorHandle.init_search_instance(t, unorderedMapStringString);
                System.out.println(b);
            });
        }
        cachedThreadPool.shutdown();
        System.out.println("done ok");
		
	}

}
