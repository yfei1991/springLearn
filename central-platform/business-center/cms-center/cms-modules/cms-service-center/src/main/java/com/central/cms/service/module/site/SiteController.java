package com.central.cms.service.module.site;

import com.central.cms.mybatis.model.CpCmsSite;
import com.central.cms.service.module.site.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseStatus(HttpStatus.OK)
public class SiteController {

   @Autowired
   private ISiteService siteService;

   @RequestMapping("/site/{siteId}")
   public CpCmsSite findById(@PathVariable("siteId") String siteId){
        return siteService.findById(siteId);
   }

}
