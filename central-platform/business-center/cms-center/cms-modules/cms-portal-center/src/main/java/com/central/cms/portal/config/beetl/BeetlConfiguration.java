package com.central.cms.portal.config.beetl;


import com.central.cms.commons.properties.CmsProperties;
import com.google.common.collect.Maps;
import org.beetl.core.Function;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableConfigurationProperties(CmsProperties.class)
public class BeetlConfiguration {

    @Autowired
    private CmsProperties properties;

    public Map<String,Object> sharedVars(){
        Map<String,Object> sharedVars =  Maps.newHashMap();
        String baseUrl = properties.getHttpType().getType()+"://"+ properties.getHost()+(!properties.getPort().equals("80")?":"+properties.getPort():"");
        sharedVars.put("name",properties.getName());
        sharedVars.put("baseURL",baseUrl);
        sharedVars.put("resPath",baseUrl+"/"+"static"+"/"+"www");
        sharedVars.put("frontPrefix",properties.getFrontUrlPrefix());
        sharedVars.put("frontPath",baseUrl+"/"+properties.getFrontUrlPrefix());
        return sharedVars;
    }

    public Map<String,Object> functionPackages(){
        Map<String,Object> functionPackages = new HashMap<String,Object>();
        return functionPackages;
    }

    public Map<String,Function> function(){
        Map<String,Function> functionPackages = Maps.newHashMap();
        return functionPackages;
    }

    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration beetlConfig() {

        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        try {
            ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader(BeetlConfiguration.class.getClassLoader(), "templates/");
            beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:beetl.properties"));
            beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
            beetlGroupUtilConfiguration.setFunctionPackages(functionPackages());
            beetlGroupUtilConfiguration.setSharedVars(sharedVars());
            beetlGroupUtilConfiguration.setFunctions(function());
            return beetlGroupUtilConfiguration;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver BeetlSpringViewResolver(@Qualifier(value = "beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

    @Bean(name = "groupTemplate")
    public GroupTemplate getGroupTemplate(
            @Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        return beetlGroupUtilConfiguration.getGroupTemplate();

    }

}
