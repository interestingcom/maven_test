package com.hz.dao;

import com.hz.domain.Items;

import java.util.List;

public interface ItemsDao {
    public List<Items> findAll() throws Exception;
}
