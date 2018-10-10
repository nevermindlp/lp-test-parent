package lp.lambda;

import java.util.List;

import lombok.Data;

/**
 * Created by lvpeng01 on 2018/8/21.
 */
@Data
public class PersonInfo {

    private String code;
    private Integer length;
    private Integer wight;
    private List<String> attrInfoList;

    enum DirectionEnum  {
        ASC, DESC, OTHER;

        static DirectionEnum getByName(String name) {
            for (DirectionEnum directionEnum : values()) {
                if (directionEnum.name().equals(name)) {
                    return directionEnum;
                }
            }
            return null;
        }
    }

    enum TruncationEnum {
        UPPER, LOW, SIDE;
        static TruncationEnum getByName(String name) {
            for (TruncationEnum truncationEnum : values()) {
                if (truncationEnum.name().equals(name)) {
                    return truncationEnum;
                }
            }
            return null;
        }
    }

    enum OcclusionEnum {
        NONE, MILD, SERIOUS;
        static OcclusionEnum getByName(String name) {
            for (OcclusionEnum occlusionEnum : values()) {
                if (occlusionEnum.name().equals(name)) {
                    return occlusionEnum;
                }
            }
            return null;
        }
    }

}
