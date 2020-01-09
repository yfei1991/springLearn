package com.central.cms.commons.base.service.impl;



import com.central.cms.commons.base.service.BaseService;
import com.central.cms.commons.util.IdGeneratorUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Slf4j
public class BaseServiceImpl<M extends Mapper<T>,T> implements BaseService<T> {

    public static final IdGeneratorUtil ID_GENERATOR= IdGeneratorUtil.INSTANCE;

    @Autowired
    protected M mapper;

    @Override
    public T findById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findOne(T entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public T findOneByExample(Example example) {
        return mapper.selectOneByExample(example);
    }

    @Override
    public List<T> findList(T entity) {
        return mapper.select(entity);
    }

    @Override
    public List<T> findListByExample(Example example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public Long findCount(T entity) {
        return Long.valueOf(mapper.selectCount(entity));
    }

    @Override
    public void insert(T entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }

    @Override
    public void updateById(T entity) {
        mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void updateSelectiveById(T entity) { mapper.updateByPrimaryKeySelective(entity); }

    @Override
    public void delete(T entity) {
        mapper.delete(entity);
    }

    @Override
    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<T> page(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        return new PageInfo<>(this.findAll());
    }

    @Override
    public PageInfo<T> page(Integer pageNumber, Integer pageSize, T queryBean) {
        PageHelper.startPage(pageNumber,pageSize);
        return new PageInfo<>(this.findList(queryBean));
    }


    @Override
    public PageInfo<T> pageByExample(Integer pageNumber, Integer pageSize, Example example) {
        PageHelper.startPage(pageNumber,pageSize);
        return new PageInfo<>(this.findListByExample(example));
    }
}
