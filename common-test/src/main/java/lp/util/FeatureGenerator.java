package lp.util;

import java.nio.ByteBuffer;
import java.util.Random;

/**
 * Created by lvpeng01 on 2018/11/14.
 */
public class FeatureGenerator {

    public static byte[] randomFeature() {
        return float2byte(randomFloat());
    }

    public static byte[] norRandomFeature() {
        return float2byte(norRandomFloat());
    }

    private static byte[] float2byte(float[] floats) {
        ByteBuffer buffer = ByteBuffer.allocate(4 * 1536);
        for (float f : floats) {
            buffer.put(ByteUtil.getBytes(f));
        }
        return buffer.array();
    }

    private static float[] norRandomFloat() {
        Random random = new Random();
        float[] aa = new float[1536];
        for (int i = 0; i < 1536; i++) {
            aa[i] = random.nextFloat() * 128;
//            System.out.println(Arrays.toString(aa));
        }
        FeatureUtils.normalization(aa, 1536);
        return aa;
    }

    private static float[] randomFloat() {
        Random random = new Random();
        float[] aa = new float[1536];
        for (int i = 0; i < 1536; i++) {
            aa[i] = random.nextFloat() * 1536;
        }
        return aa;
    }

}
