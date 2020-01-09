package com.central.cms.commons.base.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseService<T> {

    T findById(Object id);

    T findOne(T entity);

    T findOneByExample(Example example);

    List<T> findList(T entity);

    List<T> findListByExample(Example example);

    List<T> findAll();

    Long findCount(T entity);

    void insert(T entity);

    void insertSelective(T entity);

    void updateById(T entity);

    void updateSelectiveById(T entity);

    void delete(T entity);

    void deleteById(Object id);

    PageInfo<T> page(Integer pageNumber, Integer pageSize);

    PageInfo<T> page(Integer pageNumber, Integer pageSize, T queryBean);

    PageInfo<T> pageByExample(Integer pageNumber, Integer pageSize, Example example);
}
