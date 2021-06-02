package com.phonerep.demo.service;

import com.phonerep.demo.model.Pricelist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PriceListService {

    Page<Pricelist> showMovieList(int pageNo, int pageSize);

    Pricelist getPriceListById(int pricelistid);
}
