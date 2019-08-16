package lp.oom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 触发oom的时候将heap dump出来
 * 启动参数-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="/Users/lvpeng/oom"
 * 如果路径中的最后一个层级不存在，会按文件名进行存储
 *
 * run MAT: ~/eclipsemat/mat.app/Contents/MacOS/MemoryAnalyzer
 */
public class OomTest {

    public static void main(String[] args) {

//        Map largeMap = new HashMap();
//        Random r = new Random();
//        while (true) {
//            largeMap.put(r.nextInt(), "value");
//        }

        List<UserEntity> largeList = new ArrayList<>();
        while (true) {
            UserEntity ue = new UserEntity();
            ue.setAge(1);
            ue.setName("lp");
            largeList.add(ue);
        }
    }

}
