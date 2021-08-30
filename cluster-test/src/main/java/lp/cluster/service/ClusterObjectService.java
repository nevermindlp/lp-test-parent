package lp.cluster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp.cluster.entity.ClusterObject;
import lp.cluster.repository.ClusterObjectRepository;

/**
 * @author : lvpeng01
 * @since : 2020/7/16
 **/
@Service
public class ClusterObjectService {

    @Autowired
    private ClusterObjectRepository clusterObjectRepository;

    public List<ClusterObject> findAll() {
        return clusterObjectRepository.findAll();
    }

    public List<ClusterObject> findByClusterId(Long clusterId) {
        return clusterObjectRepository.findByClusterId(clusterId);
    }
}
