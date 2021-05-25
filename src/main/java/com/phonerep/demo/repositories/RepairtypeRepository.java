package com.phonerep.demo.repositories;

import com.phonerep.demo.model.Device;
import com.phonerep.demo.model.Pricelist;
import com.phonerep.demo.model.Repairtype;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairtypeRepository extends JpaRepository<Repairtype, Integer> {
}
