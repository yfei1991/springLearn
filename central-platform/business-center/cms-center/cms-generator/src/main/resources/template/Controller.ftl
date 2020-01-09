package ${package};

import ${tableClass.fullClassName};
import ${servicePackage}.${tableClass.shortClassName}Service;
import com.github.pagehelper.PageInfo;
import com.central.cms.commons.base.controller.BaseController;
import com.central.cms.commons.base.controller.response.Result;
import com.central.cms.commons.base.controller.response.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class ${tableClass.shortClassName}Controller extends BaseController {

    @Autowired
    private ${tableClass.shortClassName}Service ${tableClass.lowerCaseName}Service;


    @GetMapping("find/{id}")
    public Result find(@PathVariable("id") Object Id){
        ${tableClass.shortClassName} ${tableClass.lowerCaseName} = ${tableClass.lowerCaseName}Service.findById(Id);
        return ResultGenerator.genSuccessResult().setData(${tableClass.lowerCaseName});
    }

    @PostMapping("delete/{id}")
    public Result save(@PathVariable("id") Object Id){
        ${tableClass.lowerCaseName}Service.deleteById(Id);
        return ResultGenerator.genSuccessResult().setInfo("删除成功！");

    }

    @PostMapping("save")
    public Result save(${tableClass.shortClassName} ${tableClass.lowerCaseName}){
        ${tableClass.lowerCaseName}Service.insertSelective(${tableClass.lowerCaseName});
        return ResultGenerator.genSuccessResult().setInfo("保存成功！");

    }

    @PostMapping("update")
    public Result update(${tableClass.shortClassName} ${tableClass.lowerCaseName}){
        ${tableClass.lowerCaseName}Service.updateSelectiveById(${tableClass.lowerCaseName});
        return ResultGenerator.genSuccessResult().setInfo("保存成功！");

    }

    @GetMapping("page")
    public Result page(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                        @RequestParam(value = "pageSize",defaultValue = "30") Integer pageSize,
                        ${tableClass.shortClassName} queryBean){
        PageInfo<${tableClass.shortClassName}> page = ${tableClass.lowerCaseName}Service.page(pageNumber,pageSize,queryBean);
        return ResultGenerator.genSuccessResult().setData(page.getList());

    }




}
