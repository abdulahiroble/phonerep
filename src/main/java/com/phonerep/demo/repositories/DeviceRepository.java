package com.phonerep.demo.repositories;

import com.phonerep.demo.model.Device;
import com.phonerep.demo.model.Pricelist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
