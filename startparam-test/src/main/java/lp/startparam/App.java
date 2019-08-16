package lp.startparam;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.collect.Lists;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.util.KeyValuePair;

/**
 * Created by lvpeng01 on 2019/4/25.
 */
public class App {

    public static void main(String[] args) {

        String ENV_NODE_ID = "cluster_nodeId";
        String ENV_MACHINE_ID = "cluster_machineId";
        String ENV_SERVICE = "cluster_service";
        String ENV_CONFIG_JSON = "cluster_configJson";
        String ENV_GPU_INDEX = "cluster_gpuIndex";
        String ENV_TAG = "cluster_tag";
        String ENV_AFFINITY_KEY = "cluster_affinityKey";
        String ENV_SERVICE_PORT = "cluster_servicePort";
        String ENV_SCHEMA = "cluster_schema";
        String ENV_UNDERLYING_PATH = "cluster_underlyingPath";
        String ENV_SCRIPT_PATH = "cluster_scriptPath";
        String ENV_IP = "cluster_ip";

        Arrays.stream(args).forEach(System.out::println);

        OptionParser parser = new OptionParser();
        parser.allowsUnrecognizedOptions();

        parser.accepts(ENV_NODE_ID, "nodeId").withOptionalArg();
        parser.accepts(ENV_MACHINE_ID, "machineId").withOptionalArg();
        parser.accepts(ENV_SERVICE, "service").withOptionalArg();

        parser.accepts(ENV_CONFIG_JSON, "config json").withOptionalArg();
        parser.accepts(ENV_GPU_INDEX, "gpu index").withOptionalArg();

        parser.accepts(ENV_TAG, "tag").withOptionalArg();
        parser.accepts(ENV_AFFINITY_KEY, "affinity key").withOptionalArg();

        parser.accepts(ENV_SERVICE_PORT, "service port").withOptionalArg();
        parser.accepts(ENV_SCHEMA, "schema").withOptionalArg();
        parser.accepts(ENV_IP, "ip").withOptionalArg();

        parser.accepts(ENV_UNDERLYING_PATH, "underlying path").withOptionalArg();
        parser.accepts(ENV_SCRIPT_PATH, "script path").withOptionalArg();

        parser.acceptsAll(Lists.newArrayList("help", "h"), "help u help me").forHelp();

        // 将其他透传参数放入解析器
        Arrays.stream(args).map(arg -> {
            if (arg.startsWith("--")) {
                arg = arg.substring(2);
            } else if (arg.startsWith("-")) {
                arg = arg.substring(1);
            }
            return KeyValuePair.valueOf(arg);
        }).filter(kv -> StringUtils.isNotEmpty(kv.value)).forEach(kv -> {
            if (!parser.recognizedOptions().containsKey(kv.key)) {
                if (NumberUtils.isNumber(kv.value)) {
                    Number number = NumberUtils.createNumber(kv.value);
                    parser.accepts(kv.key).withOptionalArg().ofType(number.getClass());
                } else {
                    parser.accepts(kv.key).withOptionalArg();
                }
            }
        });

        try {
            OptionSet options = parser.parse(args);
            System.out.println("------ start from java main success options = " + options);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                parser.printHelpOn(System.out);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        }
    }
}
