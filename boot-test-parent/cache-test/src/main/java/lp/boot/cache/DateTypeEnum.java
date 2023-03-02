package lp.boot.cache;

import java.util.Calendar;

public enum DateTypeEnum {
    DAY("DAY", "天", "%Y/%m/%d", "yyyy/MM/dd", Calendar.DATE, 31),
    WEEK("WEEK", "周", "%Y/%u周", "yyyy/ww周", Calendar.WEEK_OF_YEAR, 53),
    MONTH("MONTH", "月", "%Y/%m", "yyyy/MM", Calendar.MONTH, 36),
    YEAR("YEAR", "年", "%Y", "yyyy", Calendar.YEAR, Integer.MAX_VALUE);

    private String type;
    private String text;
    private String mySqlFormat;
    // 格式化
    private String dateFormat;
    // 统计展示数量
    private int displaySize;
    private int calendarType;

    public static String switchName(String dateType) {
        for (DateTypeEnum type : values()) {
            if (type.getType().equals(dateType)) {
                return type.getText();
            }
        }
        return "";
    }

    DateTypeEnum(String type, String text, String mySqlFormat, String dateFormat, int calendarType, int displaySize) {
        this.type = type;
        this.text = text;
        this.mySqlFormat = mySqlFormat;
        this.dateFormat = dateFormat;
        this.calendarType = calendarType;
        this.displaySize = displaySize;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public int getCalendarType() {
        return calendarType;
    }

    public void setCalendarType(int calendarType) {
        this.calendarType = calendarType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMySqlFormat() {
        return mySqlFormat;
    }

    public void setMySqlFormat(String mySqlFormat) {
        this.mySqlFormat = mySqlFormat;
    }

    public DateTypeEnum getDateTypeEnum(String type) {

        DateTypeEnum dateType = null;
        type = type.toUpperCase();
        for (DateTypeEnum item : DateTypeEnum.values()) {
            if (item.getType().equals(type)) {
                dateType = item;
            }
        }
        return dateType;
    }
}

