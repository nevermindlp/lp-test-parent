package lp.lambda.compareMax;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by lvpeng01 on 2019/3/26.
 */
public class CompareWrapperVo {

    private List<CompareVo> compareVoList;

    public List<CompareVo> getCompareVoList() {
        return compareVoList;
    }

    public void setCompareVoList(List<CompareVo> compareVoList) {
        this.compareVoList = compareVoList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("compareVoList", compareVoList)
                .toString();
    }
}
