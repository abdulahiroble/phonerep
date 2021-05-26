package com.phonerep.demo.repositories;

import com.phonerep.demo.model.Repairtype;
import com.phonerep.demo.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepsitory extends JpaRepository<Service, Integer> {
}
