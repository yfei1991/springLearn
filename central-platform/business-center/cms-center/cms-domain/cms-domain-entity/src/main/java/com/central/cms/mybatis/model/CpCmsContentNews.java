package com.central.cms.mybatis.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`cp_cms_content_news`")
public class CpCmsContentNews implements Serializable {
    @Id
    @Column(name = "`content_id`")
    private Long contentId;

    @Column(name = "`file`")
    private String file;

    @Column(name = "`content`")
    private String content;

    private static final long serialVersionUID = 1L;

    /**
     * @return content_id
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * @param contentId
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    /**
     * @return file
     */
    public String getFile() {
        return file;
    }

    /**
     * @param file
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}