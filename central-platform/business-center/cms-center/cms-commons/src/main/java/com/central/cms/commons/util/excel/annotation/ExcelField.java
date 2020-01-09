package com.central.cms.commons.util.excel.annotation;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelField {

    String value() default "";

    String dateFormat() default "";

    boolean isOnlyImport() default false;

    String defaultValue() default "N/A";
}
