package lp.cluster.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lp.cluster.entity.Collection;

/**
 * @author : lvpeng01
 * @since : 2020/7/16
 **/
@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
