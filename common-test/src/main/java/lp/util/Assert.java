/*
 * Copyright 2013-2019 BP&IT.
 */
package lp.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 条件判断
 *
 * @author Ryoma
 * @date 13-11-18
 * @since 1.0
 */
public abstract class Assert  {

    /**
     * 判断两个List<?>是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isListEquals(List<?> excepts, List<?> actuals) {
        isListEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个List<?>是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isListEquals(List<?> excepts, List<?> actuals, String message, Object... args) {
        isTrue(ListUtils.isEqualList(excepts, actuals), message, args);
    }

    // ========================================= array equals ====================================

    /**
     * 判断两个boolean[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(boolean[] excepts, boolean[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个boolean[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(boolean[] excepts, boolean[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    /**
     * 判断两个byte[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(byte[] excepts, byte[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个byte[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(byte[] excepts, byte[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    /**
     * 判断两个float[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(float[] excepts, float[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个float[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(float[] excepts, float[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    /**
     * 判断两个double[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(double[] excepts, double[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个double[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(double[] excepts, double[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    /**
     * 判断两个int[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(int[] excepts, int[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个int[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(int[] excepts, int[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    /**
     * 判断两个long[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(long[] excepts, long[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个long[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(long[] excepts, long[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    /**
     * 判断两个String[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(String[] excepts, String[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个String[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(String[] excepts, String[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    /**
     * 判断两个Object[]是否相等
     *
     * @param excepts
     * @param actuals
     */
    public static void isArrayEquals(Object[] excepts, Object[] actuals) {
        isArrayEquals(excepts, actuals, "except is {},actual is {}", excepts, actuals);
    }

    /**
     * 判断两个Object[]是否相等
     *
     * @param excepts
     * @param actuals
     * @param message
     * @param args
     */
    public static void isArrayEquals(Object[] excepts, Object[] actuals, String message, Object... args) {
        isTrue(Arrays.equals(excepts, actuals), message, args);
    }

    // ========================================= object equals ====================================

    /**
     * 判断两个float是否相等
     *
     * @param except
     * @param actual
     */
    public static void isEquals(float except, float actual) {
        isEquals(except, actual, "except is {},actual is {}", except, actual);
    }

    /**
     * 判断两个float是否相等
     *
     * @param except
     * @param actual
     * @param message
     * @param args
     */
    public static void isEquals(float except, float actual, String message, Object... args) {
        isTrue(Float.compare(except, actual) == 0, message, args);
    }

    /**
     * 判断两个double是否相等
     *
     * @param except
     * @param actual
     */
    public static void isEquals(double except, double actual) {
        isEquals(except, actual, "except is {},actual is {}", except, actual);
    }

    /**
     * 判断两个double是否相等
     *
     * @param except
     * @param actual
     * @param message
     * @param args
     */
    public static void isEquals(double except, double actual, String message, Object... args) {
        isTrue(Double.compare(except, actual) == 0, message, args);
    }

    /**
     * 判断两个int是否相等
     *
     * @param except
     * @param actual
     */
    public static void isEquals(int except, int actual) {
        isEquals(except, actual, "except is {},actual is {}", except, actual);
    }

    /**
     * 判断两个int是否相等
     *
     * @param except
     * @param actual
     * @param message
     * @param args
     */
    public static void isEquals(int except, int actual, String message, Object... args) {
        isTrue(except == actual, message, args);
    }

    /**
     * 判断两个long是否相等
     *
     * @param except
     * @param actual
     */
    public static void isEquals(long except, long actual) {
        isEquals(except, actual, "except is {},actual is {}", except, actual);
    }

    /**
     * 判断两个long是否相等
     *
     * @param except
     * @param actual
     * @param message
     * @param args
     */
    public static void isEquals(long except, long actual, String message, Object... args) {
        isTrue(except == actual, message, args);
    }

    /**
     * 判断两个字符串是否相等
     *
     * @param except
     * @param actual
     */
    public static void isEquals(String except, String actual) {
        isEquals(except, actual, "except is {},actual is {}", except, actual);
    }

    /**
     * 判断两个字符串是否相等
     *
     * @param except
     * @param actual
     * @param message
     * @param args
     */
    public static void isEquals(String except, String actual, String message, Object... args) {
        isTrue(StringUtils.equals(except, actual), message, args);
    }

    /**
     * 判断两个object是否相等
     *
     * @param except
     * @param actual
     */
    public static void isObjectEquals(Object except, Object actual) {
        isObjectEquals(except, actual, "except is {},actual is {}", except, actual);
    }

    /**
     * 判断两个object是否相等
     *
     * @param except
     * @param actual
     * @param message
     * @param args
     */
    public static void isObjectEquals(Object except, Object actual, String message, Object... args) {
        isTrue(Objects.equals(except, actual), message, args);
    }

    /**
     * 判断数组是否为空
     *
     * @param array
     */
    public static void isNotEmpty(Object[] array) {
        isNotEmpty(array, "[Assertion failed] - this array must not empty");
    }

    /**
     * 判断数组是否为空
     *
     * @param array
     * @param message
     * @param args
     */
    public static void isNotEmpty(Object[] array, String message, Object... args) {
        isTrue(ArrayUtils.isNotEmpty(array), message, args);
    }

    /**
     * 判断集合是否为空
     *
     * @param collection
     */
    public static void isNotEmpty(Collection<?> collection) {
        isNotEmpty(collection, "[Assertion failed] - this collection must not empty");
    }

    /**
     * 判断集合是否为空
     *
     * @param collection
     * @param message
     * @param args
     */
    public static void isNotEmpty(Collection<?> collection, String message, Object... args) {
        isTrue(CollectionUtils.isNotEmpty(collection), message, args);
    }

    /**
     * 判断map是否为空字符串
     *
     * @param map
     */
    public static void isNotEmpty(Map<?, ?> map) {
        isNotEmpty(map, "[Assertion failed] - this map must not empty");
    }

    /**
     * 判断map是否为空
     *
     * @param map
     * @param message
     * @param args
     */
    public static void isNotEmpty(Map<?, ?> map, String message, Object... args) {
        isTrue(MapUtils.isNotEmpty(map), message, args);
    }

    /**
     * 判断字符串是否为空字符串
     *
     * @param str
     */
    public static void isNotEmpty(String str) {
        isTrue(StringUtils.isNotEmpty(str), "[Assertion failed] - this str must not empty");
    }

    /**
     * 判断字符串是否为空字符串
     *
     * @param str
     * @param message
     * @param args
     */
    public static void isNotEmpty(String str, String message, Object... args) {
        isTrue(StringUtils.isNotEmpty(str), message, args);
    }

    /**
     * Assert a boolean expression, throwing {@code IllegalArgumentException}
     * if the test result is {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0);</pre>
     *
     * @param expression a boolean expression
     *
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * Assert a boolean expression, throwing {@code IllegalArgumentException}
     * if the test result is {@code false}.
     * <pre class="code">Assert.isTrue(i &gt; 0, "The value must be greater than zero");</pre>
     *
     * @param expression a boolean expression
     * @param message    the exception message to use if the assertion fails
     * @param args
     *
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression, String message, Object... args) {
        if (!expression) {
            throw new IllegalArgumentException(StringFormatUtils.format(message, args));
        }
    }

    /**
     * Assert that an object is {@code null} .
     * <pre class="code">Assert.isNull(value);</pre>
     *
     * @param object the object to check
     *
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void isNull(Object object, String message, Object... args) {
        if (object != null) {
            throw new IllegalArgumentException(StringFormatUtils.format(message, args));
        }
    }

    /**
     * Assert that an object is not {@code null} .
     * <pre class="code">Assert.notNull(clazz);</pre>
     *
     * @param object the object to check
     *
     * @throws IllegalArgumentException if the object is {@code null}
     */
    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void notNull(Object object, String message, Object... args) {
        if (object == null) {
            throw new IllegalArgumentException(StringFormatUtils.format(message, args));
        }
    }

    /**
     * Assert that {@code superType.isAssignableFrom(subType)} is {@code true}.
     * <pre class="code">Assert.isAssignable(Number.class, myClass);</pre>
     *
     * @param superType the super type to check
     * @param subType   the sub type to check
     *
     * @throws IllegalArgumentException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType) {
        isAssignable(superType, subType, "");
    }

    /**
     * Assert that {@code superType.isAssignableFrom(subType)} is {@code true}.
     * <pre class="code">Assert.isAssignable(Number.class, myClass, "Number expected");</pre>
     *
     * @param superType the super type to check against
     * @param subType   the sub type to check
     * @param message   a message which will be prepended to provide further context.
     *                  If it is empty or ends in ":" or ";" or "," or ".", a full exception message
     *                  will be appended. If it ends in a space, the name of the offending sub type
     *                  will be appended. In any other case, a ":" with a space and the name of the
     *                  offending sub type will be appended.
     *
     * @throws IllegalArgumentException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
        notNull(superType, "Super type to check against must not be null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            assignableCheckFailed(superType, subType, message);
        }
    }

    private static void assignableCheckFailed(Class<?> superType, Class<?> subType, String msg) {
        String result = "";
        boolean defaultMessage = true;
        if (StringUtils.isNotEmpty(msg)) {
            if (endsWithSeparator(msg)) {
                result = msg + " ";
            } else {
                result = messageWithTypeName(msg, subType);
                defaultMessage = false;
            }
        }
        if (defaultMessage) {
            result = result + (subType + " is not assignable to " + superType);
        }
        throw new IllegalArgumentException(result);
    }

    private static boolean endsWithSeparator(String msg) {
        return (msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith("."));
    }

    private static String messageWithTypeName(String msg, Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }
}
