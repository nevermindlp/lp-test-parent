package lp.util;

import java.util.Collections;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * created by Ryoma on 16/8/30 in project of nengli-cluster .
 *
 * @author Ryoma
 * @date 16/8/30
 */
public final class StringAssistUtils {

    static final Set<Collector.Characteristics> CH_NOID = Collections.emptySet();

    /**
     * 把一个字符串数组转换成驼峰模式
     *
     * @param arr
     *
     * @return
     */
    public static String toCamelCase(String[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length == 0) {
            return "";
        }
        String str = Stream.of(arr).reduce("", (t, s) -> {
            if (StringUtils.isEmpty(s)) {
                return t;
            }
            final int type = Character.getType(s.charAt(0));
            if (Character.LOWERCASE_LETTER == type) {
                t += Character.toUpperCase(s.charAt(0)) + s.substring(1);
            } else {
                t += s;
            }
            return t;
        });
        return Character.toLowerCase(str.charAt(0)) + str.substring(1);
    }

    /**
     * 把驼峰模式或者"."分隔的字符串转换成下划线模式
     *
     * @param s
     *
     * @return
     */
    public static String toUnderscores(String s) {
        if (StringUtils.isEmpty(s)) {
            return s;
        }
        StringBuilder buf = new StringBuilder(s.replace('.', '_'));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1))
                        && Character.isUpperCase(buf.charAt(i))
                        && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase(Locale.ROOT);
    }

    /**
     * 判断字符串是否被双引号包裹
     *
     * @param key
     *
     * @return
     */
    public static boolean isQuoted(String key) {
        return StringUtils.length(key) > 2 && key.startsWith("\"") && key.endsWith("\"");
    }

    /**
     * 连接字符串，如果是null会被替换成空字符串
     *
     * @param s
     *
     * @return
     */
    public static String join(String... s) {
        return join(s, ",");
    }

    /**
     * 连接字符串，如果是null会被替换成空字符串
     *
     * @param s
     * @param delimiter
     *
     * @return
     */
    public static String join(String[] s, CharSequence delimiter) {
        return Stream.of(s).map(t -> Optional.ofNullable(t).orElse(""))
                       .collect(Collector.of(() -> new StringJoiner(delimiter, "", ""),
                                             StringJoiner::add,
                                             StringJoiner::merge,
                                             StringJoiner::toString));
    }
}
