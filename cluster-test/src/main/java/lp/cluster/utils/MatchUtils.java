package lp.cluster.utils;

/**
 * Created by lvpeng01 on 2018/8/4.
 */
public class MatchUtils {

    /**
     * cosine definition
     * 越相似越接近1，否则接近0
     * @see "https://en.wikipedia.org/wiki/Cosine_similarity"
     *
     * @param feature1
     * @param feature2
     * @return
     */
    public static double cosine(float[] feature1, float[] feature2) {

        double inner = 0.0;
        double squareSum1 = 0.0;
        double squareSum2 = 0.0;

        for (int i = 0; i < feature1.length; i++) {
            inner += feature1[i] * feature2[i];
            squareSum1 += feature1[i] * feature1[i];
            squareSum2 += feature2[i] * feature2[i];
        }

        double sqr1 = Math.sqrt(squareSum1);
        double sqr2 = Math.sqrt(squareSum2);

        return inner / (sqr1 * sqr2);
    }

    public static double cosine(byte[] feature1, byte[] feature2) {
        return cosine(ByteUtil.getFloats(feature1), ByteUtil.getFloats(feature2));
    }

    /**
     * 归一化的cosine相似度
     * 越相似越接近1，否则接近0
     * @param b1
     * @param b2
     * @return
     */
    public static double norCosine(byte[] b1, byte[] b2) {
        return norCosine(ByteUtil.getFloats(b1), ByteUtil.getFloats(b2));
    }

    /**
     * 归一化的cosine相似度
     * 越相似越接近1，否则接近0
     * @param f1
     * @param f2
     * @return
     */
    public static double norCosine(float[] f1, float[] f2) {
        double result = 0.0;
        for (int i = 0; i < f1.length; i++) {
            result += f1[i] * f2[i];
        }
        return result;
    }

    /**
     * euclidean definition
     * 越相似越接近0，否则接近1
     * @see "https://en.wikipedia.org/wiki/Euclidean_distance"
     *
     * @return
     */
    public static double euclidean(float[] feature1, float[] feature2) {
        double subSquareSum = 0.0;
        for (int i = 0; i < feature1.length; i++) {
            subSquareSum += Math.pow((feature1[i] - feature2[i]), 2);
        }
        return Math.sqrt(subSquareSum);
    }

    public static double euclidean(byte[] feature1, byte[] feature2) {
        return euclidean(ByteUtil.getFloats(feature1), ByteUtil.getFloats(feature2));
    }

    /**
     * 归一化
     *
     * @param feature
     */
    public static void normalization(float[] feature) {
        int feaDim = feature.length;

        float feaNorm = 0;
        for (int i = 0; i < feaDim; i++) {
            feaNorm += feature[i] * feature[i];
        }
        feaNorm = (float) Math.sqrt(feaNorm + 0.000001);
        for (int i = 0; i < feaDim; i++) {
            feature[i] /= feaNorm;
        }
    }

    /**
     * 归一化
     *
     * @param feature
     */
    public static byte[] normalization(byte[] feature) {
        float[] featureFloats = ByteUtil.getFloats(feature);
        normalization(featureFloats);
        return ByteUtil.getBytes(featureFloats);
    }

}
