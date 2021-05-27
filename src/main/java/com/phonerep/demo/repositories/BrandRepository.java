package com.phonerep.demo.repositories;

import com.phonerep.demo.model.Brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
