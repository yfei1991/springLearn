package ${package};

import ${servicePackage}.${tableClass.shortClassName}Service;
import com.central.cms.commons.base.service.impl.BaseServiceImpl;
import com.central.cms.mybatis.model.${tableClass.shortClassName};
import com.central.cms.mybatis.mapper.${tableClass.shortClassName}Mapper;
import org.springframework.stereotype.Service;

@Service
public class ${tableClass.shortClassName}ServiceImpl extends BaseServiceImpl<${tableClass.shortClassName}Mapper, ${tableClass.shortClassName}> implements ${tableClass.shortClassName}Service {


}
