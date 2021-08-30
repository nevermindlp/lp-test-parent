package lp.cluster.test;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lp.cluster.entity.Aggregation;
import lp.cluster.entity.ClusterObject;
import lp.cluster.entity.Collection;
import lp.cluster.repository.AggregationRepository;
import lp.cluster.repository.ClusterObjectRepository;
import lp.cluster.repository.CollectionRepository;
import lp.cluster.utils.MatchUtils;

/**
 * @author : lvpeng01
 * @since : 2020/7/16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClusterTest {

    @Autowired
    private ClusterObjectRepository clusterObjectRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private AggregationRepository aggregationRepository;

    private List<byte[]> features = Lists.newArrayList();

    @Test
    public void repTest() {

        Long clusterId = 795451089010696L;


//        Long clusterId = 795436018614297L;
        // get avgFeature
        Aggregation aggregation = aggregationRepository.findById(clusterId).orElse(null);
        byte[] avgFeature = aggregation.getFeature(); // 归一化过的

        List<ClusterObject> clusterObjects = clusterObjectRepository.findByClusterId(clusterId);
        System.out.println(clusterObjects.size());
        for (ClusterObject clusterObject : clusterObjects) {
            Long sourceId = clusterObject.getSourceId();
            Collection collection = collectionRepository.findById(sourceId).orElse(null);
//            System.out.println(collection);
            byte[] feature = collection.getFeature();
            features.add(feature);
        }
        System.out.println("feature load finished...");
        // 计算所有特征到质心的距离
        double avgFeatureMin = 2;
        double avgFeatureDistance = 0;
        int featureCount = 0;
        for (byte[] feature : features) {
            byte[] normalization = MatchUtils.normalization(feature);
            double distance = MatchUtils.norCosine(normalization, avgFeature);
//            System.out.println("to avgFeatureDistance is : " + distance);
            if (avgFeatureMin > distance) {
                avgFeatureMin = distance;
            }
            avgFeatureDistance += distance;
            featureCount++;
        }
        System.out.println("avgFeatureMin is : " + avgFeatureMin);
        System.out.println("featureCount is : " + featureCount);
        System.out.println("avgFeatureDistance is : " + avgFeatureDistance/featureCount);

        double totalMin = 2d;
        for (byte[] feature : features) {
            double min = 2d;
            for (byte[] featureTmp : features) {
                double similar = MatchUtils.cosine(feature, featureTmp);
                if (similar < min) {
                    min = similar;
                }
            }
            System.out.println("min score is : " + min);
            if (min < totalMin) {
                totalMin = min;
            }
        }
        System.out.println("total min score is : " + totalMin);
    }

}
