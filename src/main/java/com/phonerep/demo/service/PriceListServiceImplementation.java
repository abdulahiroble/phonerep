package com.phonerep.demo.service;

import com.phonerep.demo.model.Pricelist;
import com.phonerep.demo.repositories.PricelistRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceListServiceImplementation implements PriceListService {

    @Autowired
    private PricelistRepository pricelistRepository;

    @Override
    public Pricelist getPriceListById(int pricelistid) {
        Optional<Pricelist> optional = pricelistRepository.findById(pricelistid);
        Pricelist user = null;

        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found by id " + pricelistid);
        }
        return user;
    }

    @Override
    public Page<Pricelist> showMovieList(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return this.pricelistRepository.findAll(pageable);
    }

}
