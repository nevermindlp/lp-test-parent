package lp.boot.cache;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;


/**
 * Created by bijiangtao on 17/8/23.
 */
public final class DateUtil {
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    public static final SimpleDateFormat SimpleDateFormat_Long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private DateUtil() {

    }

    public static Date add(Date date, DateTypeEnum dateType, int amount) {
        if (dateType == DateTypeEnum.DAY) {
            return DateUtils.addDays(date, amount);
        } else if (dateType == DateTypeEnum.WEEK) {
            return DateUtils.addWeeks(date, amount);
        } else if (dateType == DateTypeEnum.MONTH) {
            return DateUtils.addMonths(date, amount);
        } else if (dateType == DateTypeEnum.YEAR) {
            return DateUtils.addYears(date, amount);
        } else {
            throw new IllegalArgumentException("dateType 参数错误");
        }
    }

    public static Date addDays(Date date, int days) {
        return DateUtils.addDays(date, days);
    }


    public static LocalDate getLocalDateOfDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date clearTime(Date date) {
        return Date.from(date.toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static boolean isFirstDayOfWeek(Date date) {
        return LocalDate.parse(format(FORMAT_DATE, date))
                .getDayOfWeek().equals(DayOfWeek.MONDAY);
    }

    public static boolean isFirstDayOfMonth(Date date) {
        LocalDate localDate = LocalDate.parse(format(FORMAT_DATE, date));
        return localDate.equals(localDate.with(TemporalAdjusters.firstDayOfMonth()));
    }

    public static boolean isFirstDayOfYear(Date date) {
        LocalDate localDate = LocalDate.parse(format(FORMAT_DATE, date));
        return localDate.equals(localDate.with(TemporalAdjusters.firstDayOfYear()));
    }

    /**
     * 指定时间是否在当前同一天内
     *
     * @param dateTime
     * @return
     */
    public static boolean isInCurrentDay(Date dateTime) {
        return getCurrentDayBegin().equals(getDayBegin(dateTime));
    }

    /**
     * 指定时间是否在当前同一周内
     *
     * @param dateTime
     * @return
     */
    public static boolean isInCurrentWeek(Date dateTime) {
        return getWeekBegin(new Date()).equals(getWeekBegin(dateTime));
    }

    /**
     * 指定时间是否在当前同一月内
     *
     * @param dateTime
     * @return
     */
    public static boolean isInCurrentMonth(Date dateTime) {
        return getMonthBegin(new Date()).equals(getMonthBegin(dateTime));
    }

    /**
     * 指定时间是否在当前同一年内
     *
     * @param dateTime
     * @return
     */
    public static boolean isInCurrentYear(Date dateTime) {
        return getYearBegin(new Date()).equals(getYearBegin(dateTime));
    }

    public static String format(Date date) {
        return format("yyyy-MM-dd HH:mm:ss", date);
    }

    public static String format(String pattern, Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String getDateTime(Integer age) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -age);

        return format("yyyy-MM-dd HH:mm:ss", calendar.getTime());
    }

    /**
     * 获取两个日期之间的所有日期
     *
     * @param startTime 开始日期
     * @param endTime   结束日期
     * @return
     */
    public static List<String> getDays(Date startTime, Date endTime) {
        // 返回的日期集合
        List<String> days = new ArrayList<String>();

        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
        try {
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(startTime);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(endTime);
            // 日期加1(包含结束)
            tempEnd.add(Calendar.DATE, +1);
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return days;
    }

    /**
     * 获取今日/近一周/近一月/近一年的开始时刻
     * @param dateType
     * @return
     */
    public static Date getLastDayBeginByType(int dateType) {
        Date lastDay = getDayBegin(new Date(), dateType, -1);
        return getDayBegin(lastDay, 1);
    }

    /**
     * 获取指定天的开始时刻
     * 例 2012-06-07 00:00:00
     */
    public static Date getDayBegin(Date date) {
        return getDayBegin(date, 0);
    }

    public static Date getDayBegin(Date date, int field, int addNum) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(field, addNum);
        setDayBegin(calendar);
        return calendar.getTime();
    }

    public static Date getDayBegin(Date date, int addDays) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, addDays);
        setDayBegin(calendar);
        return calendar.getTime();
    }

    public static Date getHourBegin(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    // 根据日期类型获取开始时间
    public static Date getDayBeginByType(Date date, int dateType) {
        Date dayBegin = null;
        switch (dateType) {
            case Calendar.DATE:
                dayBegin = DateUtil.getDayBegin(date);
                break;
            case Calendar.WEEK_OF_YEAR:
                dayBegin = DateUtil.getWeekBegin(date);
                break;
            case Calendar.MONTH:
                dayBegin = DateUtil.getMonthBegin(date);
                break;
            case Calendar.YEAR:
                dayBegin = DateUtil.getYearBegin(date);
                break;
            default:
        }
        return dayBegin;
    }

    private static void setDayBegin(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 获取今日的开始时间
     * 例 2012-06-07 00:00:00
     */
    public static Date getCurrentDayBegin() {
        return getDayBegin(new Date());
    }

    /**
     * 获取一周前的开始时间
     * 例 2012-06-07 00:00:00
     */
    public static Date getAweekAgoDayBegin() {
        return getDayBegin(new Date(), Calendar.WEEK_OF_YEAR, -1);
    }

    /**
     * 获取一月前的开始时间
     * 例 2012-06-07 00:00:00
     */
    public static Date getAmonthAgoDayBegin() {
        return getDayBegin(new Date(), Calendar.MONTH, -1);
    }

    /**
     * 获取一年前的开始时间
     * 例 2012-06-07 00:00:00
     */
    public static Date getAyearAgoDayBegin() {
        return getDayBegin(new Date(), Calendar.YEAR, -1);
    }

    /**
     * 获取今日的最后时刻
     * 例 2012-06-07 23:59:59
     */
    public static Date getCurrentDayEnd() {
        return getDayEnd(new Date());
    }

    /**
     * 获取指定天的最后时刻
     * 例 2012-06-07 23:59:59
     */
    public static Date getDayEnd(Date date) {
        return getDayEnd(date, 0);
    }

    public static Date getDayEnd(Date date, int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return setDayEnd(calendar);
    }

    // 获得date所在周，周日开始时刻
    public static Date getWeekBegin(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        calendar.add(Calendar.DATE, 2 - dayofweek);
        setDayBegin(calendar);
        return calendar.getTime();
    }

    // 获得date所在周，周日最后时刻
    public static Date getWeekEnd(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(getWeekBegin(date));
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        setDayEnd(calendar);
        return calendar.getTime();
    }

    // 获得月第一天开始时刻
    public static Date getMonthBegin(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        setDayBegin(calendar);
        return calendar.getTime();
    }

    // 获得月最后一天最后时刻
    public static Date getMonthEnd(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(getMonthBegin(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setDayEnd(calendar);
        return calendar.getTime();
    }

    // 获得年第一天开始时刻
    public static Date getYearBegin(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        setDayBegin(calendar);
        return calendar.getTime();
    }

    // 获得年最后一天最后时刻
    public static Date getYearEnd(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(getYearBegin(date));
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        setDayEnd(calendar);
        return calendar.getTime();
    }

    public static Date getHourEnd(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date getDayEndByType(Date date, int dateType) {
        Date dayEnd = null;
        switch (dateType) {
            case Calendar.DATE:
                dayEnd = DateUtil.getDayEnd(date);
                break;
            case Calendar.WEEK_OF_YEAR:
                dayEnd = DateUtil.getWeekEnd(date);
                break;
            case Calendar.MONTH:
                dayEnd = DateUtil.getMonthEnd(date);
                break;
            case Calendar.YEAR:
                dayEnd = DateUtil.getYearEnd(date);
                break;
            default:
        }
        return dayEnd;
    }

    private static Date setDayEnd(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
}
