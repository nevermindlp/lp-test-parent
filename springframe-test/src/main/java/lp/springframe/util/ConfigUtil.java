package lp.springframe.util;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;

/**
 * Created by lvpeng01 on 2017/2/25.
 */
public final class ConfigUtil {
    private static Config config = ConfigFactory.load("app.conf");
    private static Config envConfig = null;
    static {
        try {
            String envConfStr = ConfigFactory.systemProperties().getString("app.conf");
            if (StringUtils.isNotEmpty(envConfStr)) {
                envConfig = ConfigFactory.parseFile(new File(envConfStr));
            }
        } catch (ConfigException e) {
            // app.conf not exist in sys env
            System.out.println("app.conf not exist in sys env.");
        }
    }

    private ConfigUtil() {

    }
    public static String get(String key) {
        return envConfig != null ? envConfig.getString(key) : config.getString(key);
    }

    public static boolean hasValue(String key) {
        if (key != null) {
            return config.hasPath(key);
        }
        return false;
    }

    public static void main(String... args) {
        System.out.println(get("kafka.requestout"));
    }

}
