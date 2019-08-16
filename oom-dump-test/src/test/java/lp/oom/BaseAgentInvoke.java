package lp.oom;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.baidu.nengli.commons.api.vo.ResponseApiVO;
import com.baidu.sapd.agent.api.rpc.message.human.request.QueryClientsRequest;
import com.baidu.sapd.agent.api.rpc.message.human.request.QueryRequest;
import com.baidu.sapd.agent.api.rpc.message.human.response.QueryClientsResponse;
import com.baidu.sapd.agent.common.config.EnableAgentCommonSdk;
import com.baidu.sapd.agent.common.message.request.CommonRequest;
import com.baidu.sapd.agent.sdk.config.EnableAgentRpcSdk;
import com.baidu.sapd.agent.sdk.rpc.human.BrpcTracerService;
import com.google.common.collect.Maps;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {BaseAgentInvoke.TestConfig.class})
@Rollback
public class BaseAgentInvoke extends TestCase {

    @Autowired
    private BrpcTracerService brpcTracerService;

    private Map<String, Object> m = new ConcurrentHashMap<>();

    @Test
    public void testA() {
        while (true) {
            doInvoke();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testProxy() {
        fillMap();
        System.out.println(getProxy("test1", TeacherEntity.class));
        System.out.println(getProxy("test2", UserEntity.class));
    }

    public void doInvoke() {
        QueryRequest q = new QueryRequest();
        CommonRequest commonRequest = new CommonRequest();
        // 10.153.108.20:8750
        commonRequest.setHost("10.153.108.20");
        commonRequest.setPort(8750);
        q.setCommonRequest(commonRequest);
        q.setQueryClientsRequest(new QueryClientsRequest());
        ResponseApiVO<QueryClientsResponse> query = brpcTracerService.query(q);
        System.out.println(query.getData().getClientsInfo().size());

    }

    private <T> T getProxy(String key, Class<T> type) {
        return (T) m.get(key);
    }

    private void fillMap() {
        m.put("test1", new TeacherEntity());
        m.put("test2", new UserEntity());
    }

    @Configuration
    @EnableAgentRpcSdk
    @EnableAgentCommonSdk
    public static class TestConfig {

    }
}
