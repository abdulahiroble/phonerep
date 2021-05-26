package com.phonerep.demo.repositories;

import com.phonerep.demo.model.Repairtype;
import com.phonerep.demo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
