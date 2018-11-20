/*
 * Copyright 2013-2019 BP&IT.
 */
package lp.util;

public class StringFormatUtils {

    /**
     * 格式化字符串
     *
     * @param message
     * @param args
     *
     * @return return
     */
    public static String format(String message, Object... args) {
        return MessageFormatter.format(message, args).getMessage();
    }
}
