package lp.ser.jackson.entity;

import lombok.Data;

@Data
public class CommonEntity {

    private String name;

    private byte[] feature;

    private int age;

    private Integer wrapperAge;

    private Object o;

    private byte b;

    private Byte wrapperB;

    private InnerEntity innerEntity;

}
