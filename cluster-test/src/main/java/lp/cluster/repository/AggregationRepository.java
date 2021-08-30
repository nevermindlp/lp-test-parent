package lp.cluster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lp.cluster.entity.Aggregation;
import lp.cluster.entity.ClusterObject;

/**
 * @author : lvpeng01
 * @since : 2020/7/16
 **/
@Repository
public interface AggregationRepository extends JpaRepository<Aggregation, Long> {

}
