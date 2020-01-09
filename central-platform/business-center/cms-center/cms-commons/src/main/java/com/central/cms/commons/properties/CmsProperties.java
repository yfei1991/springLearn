package com.central.cms.commons.properties;

import com.central.cms.commons.constant.Enumerations;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "cp.cms")
public class CmsProperties {

    private Enumerations.HttpType httpType = Enumerations.HttpType.HTTP;

    private String host = "localhost";

    private String port = "80";

    private String name = "CPCMS-Portal";

    //url前缀
    private String frontUrlPrefix = "f";

    //伪静态后缀
    private String frontUrlSubfix = "html";

    //启用静态
    private Boolean enableStatically = Boolean.TRUE;

    //生成静态html文件保存目录
    private String staticallySavedDir = "";

    private Integer defaultPageSize = 10;

    //静态资源路径 可以是url地址
    private String  resPath = "";
}
