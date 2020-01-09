package com.central.cms.portal.config.beetl.statically;



import com.central.cms.commons.properties.CmsProperties;
import com.central.cms.commons.util.PathUtil;
import com.central.cms.portal.config.beetl.statically.thread.HtmlThread;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.StringWriter;
import java.util.Map;


//@Component
//@EnableConfigurationProperties(CmsProperties.class)
public class HtmlStaticUtil {


	@Autowired
	private GroupTemplate groupTemplate;

	@Autowired
	private CmsProperties properties;


	private final String STATIC_SUFFIX = ".html";


	public void create(HttpServletRequest request,Integer siteId, String action, Map<String, Object> attr, String theme, String tpl) {
		String view = "www"+File.separator + theme + File.separator + tpl+STATIC_SUFFIX;
		Template template = groupTemplate.getTemplate(view);
		String baseUrl = properties.getHttpType().getType()+"://"+ properties.getHost()+(!properties.getPort().equals("80")?":"+properties.getPort():"");
		StringWriter writer = new StringWriter();
		template.binding("request", request);
		template.binding("ctxPath", request.getContextPath());
		template.binding("baseUrl", baseUrl);
		template.binding(attr);
		template.renderTo(writer);
		HtmlObject obj = new HtmlObject();
		obj.setContent(format(writer.toString()));
		String fileUrl = PathUtil.getWebRootPath() +File.separator+ "html" + File.separator+ siteId + File.separator + (StringUtils.isBlank(action)?"index":action) + ".html";
		new File(fileUrl).delete();
		obj.setFileUrl(fileUrl);
		HtmlThread.addHtml(obj);
	}
     
	private String format(String page){
		return page.replace("/"+properties.getFrontUrlPrefix()+"/","/html/").replace("."+properties.getFrontUrlSubfix(), STATIC_SUFFIX);
	}

}
