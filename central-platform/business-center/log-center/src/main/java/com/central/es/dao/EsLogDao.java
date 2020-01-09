package com.central.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.central.es.entity.LogDocument;

@Repository
public interface EsLogDao extends ElasticsearchRepository<LogDocument, Long> {

}