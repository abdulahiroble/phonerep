package com.phonerep.demo.repositories;

import com.phonerep.demo.model.Device;
import com.phonerep.demo.model.Pricelist;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricelistRepository extends JpaRepository<Pricelist, Integer> {

    // Page<Pricelist> showMovieList(int pageNo, int pageSize);
}
