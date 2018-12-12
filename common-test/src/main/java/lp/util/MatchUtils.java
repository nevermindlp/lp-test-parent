package lp.util;


/**
 * Created by lvpeng01 on 2018/8/4.
 */
public class MatchUtils {

    /**
     * cosine definition
     * @see "https://en.wikipedia.org/wiki/Cosine_similarity"
     *
     * @param feature1
     * @param feature2
     * @return
     */
    public static double cosine(float[] feature1, float[] feature2) {
        Assert.notNull(feature1);
        Assert.notNull(feature2);
        Assert.isTrue(feature1.length == feature2.length);

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
        Assert.notNull(feature1);
        Assert.notNull(feature2);
        return cosine(ByteUtil.getFloats(feature1), ByteUtil.getFloats(feature2));
    }

    public static double norCosine(byte[] b1, byte[] b2) {
        Assert.notNull(b1);
        Assert.notNull(b2);
        float[] feature1 = ByteUtil.getFloats(b1);
        float[] feature2 = ByteUtil.getFloats(b2);
        double result = 0.0;
        for (int i = 0; i < feature1.length; i++) {
            result += feature1[i] * feature2[i];
        }
        return result;
    }

    /**
     * euclidean definition
     * @see "https://en.wikipedia.org/wiki/Euclidean_distance"
     *
     * @return
     */
    public static double euclidean(float[] feature1, float[] feature2) {
        Assert.notNull(feature1);
        Assert.notNull(feature2);
        Assert.isTrue(feature1.length == feature2.length);

        double subSquareSum = 0.0;
        for (int i = 0; i < feature1.length; i++) {
            subSquareSum += Math.pow((feature1[i] - feature2[i]), 2);
        }
        return Math.sqrt(subSquareSum);
    }

    public static double euclidean(byte[] feature1, byte[] feature2) {
        Assert.notNull(feature1);
        Assert.notNull(feature2);
        return euclidean(ByteUtil.getFloats(feature1), ByteUtil.getFloats(feature2));
    }

}
