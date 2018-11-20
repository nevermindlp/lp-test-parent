package lp.util;

/**
 * 特征工具类
 * Created by sunjiangwei on 18/5/8.
 */
public class FeatureUtils {
    /**
     * 相识度计算
     * 取之范围在[-1，1]之间，1时最相似，-1时则完全相反
     * 默认特征值做过归一化
     *
     * @param featureOne
     * @param featureTwo
     * @param featureDim 特征维数
     */
    public static float simCalculate(float[] featureOne, float[] featureTwo, int featureDim) {
        if (featureOne == null || featureTwo == null || featureOne.length != featureDim
                || featureTwo.length != featureDim) {
            return -1;
        }

        float simDist = 0;
        for (int i = 0; i < featureDim; i++) {
            simDist += featureOne[i] * featureTwo[i];
        }
        return simDist;
    }

    /**
     * 归一化
     *
     * @param feature
     * @param feaDim  特征维数
     */
    public static void normalization(float[] feature, int feaDim) {
        float feaNorm = 0;
        for (int i = 0; i < feaDim; i++) {
            feaNorm += feature[i] * feature[i];
        }
        feaNorm = (float) Math.sqrt(feaNorm + 0.000001);
        for (int i = 0; i < feaDim; i++) {
            feature[i] /= feaNorm;
        }
    }
}
