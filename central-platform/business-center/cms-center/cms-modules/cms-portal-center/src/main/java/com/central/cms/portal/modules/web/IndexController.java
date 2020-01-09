package com.central.cms.portal.modules.web;
import com.central.cms.mybatis.model.CpCmsSite;
import com.central.cms.portal.feign.SiteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private SiteClient siteClient;

    @GetMapping
    public String index(){
        return "forward:/";
    }

    @GetMapping("/test/{siteId}")
    @ResponseBody
    public CpCmsSite text(@PathVariable("siteId") String siteId){
        return siteClient.findById(siteId);
    }

    @GetMapping("/${cp.cms.frontUrlPrefix}/{siteKey}")
    public String index(@PathVariable("siteKey") String siteKey){
        return "index";
    }

}
