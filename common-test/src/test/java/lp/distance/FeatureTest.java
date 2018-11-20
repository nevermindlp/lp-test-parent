package lp.distance;

import java.nio.ByteBuffer;
import java.util.Random;

import org.junit.Test;

import lp.util.ByteUtil;
import lp.util.FeatureUtils;
import lp.util.MatchUtils;

/**
 * Created by lvpeng01 on 2018/11/14.
 */
public class FeatureTest {

    @Test
    public void disTest() {

        byte[] feature1 = norRandomFeature();
        byte[] feature2 = norRandomFeature();

        System.out.println("f1 <-> f2 cosine distance is : " + MatchUtils.cosine(feature1, feature2));
        System.out.println("f1 <-> f1 cosine distance is : " + MatchUtils.cosine(feature1, feature1));

        System.out.println("f1 <-> f2 euc distance is : " + MatchUtils.euclidean(feature1, feature2));
        System.out.println("f1 <-> f1 euc distance is : " + MatchUtils.euclidean(feature1, feature1));
    }


    private byte[] randomFeature() {
        return float2byte(randomFloat());
    }

    private byte[] norRandomFeature() {
        return float2byte(norRandomFloat());
    }

    private byte[] float2byte(float[] floats) {
        ByteBuffer buffer = ByteBuffer.allocate(4 * 1536);
        for (float f : floats) {
            buffer.put(ByteUtil.getBytes(f));
        }
        return buffer.array();
    }

    private float[] norRandomFloat() {
        Random random = new Random();
        float[] aa = new float[1536];
        for (int i = 0; i < 1536; i++) {
            aa[i] = random.nextFloat() * 128;
//            System.out.println(Arrays.toString(aa));
        }
        FeatureUtils.normalization(aa, 1536);
        return aa;
    }

    private float[] randomFloat() {
        Random random = new Random();
        float[] aa = new float[1536];
        for (int i = 0; i < 1536; i++) {
            aa[i] = random.nextFloat() * 1536;
        }
        return aa;
    }

}
