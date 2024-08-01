package com.TradeFinance.collectionservice.collection;

import com.TradeFinance.collectionservice.collection.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,Long> {

    Optional<Collection> findById(Long id);
}
