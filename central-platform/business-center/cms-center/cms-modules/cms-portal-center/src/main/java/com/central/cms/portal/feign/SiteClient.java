package com.central.cms.portal.feign;


import com.central.cms.mybatis.model.CpCmsSite;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("cms-service")
public interface SiteClient {

    @RequestMapping("/site/{siteId}")
    CpCmsSite findById(@PathVariable("siteId") String siteId);
}
