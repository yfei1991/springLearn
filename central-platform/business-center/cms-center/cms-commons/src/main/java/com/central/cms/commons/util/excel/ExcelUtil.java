package com.central.cms.commons.util.excel;



import com.central.cms.commons.util.DateUtil;
import com.central.cms.commons.util.excel.annotation.ExcelField;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;


public class ExcelUtil {

    public static void exports(String sheetName,List<?> list) {

        if(list==null&&list.size()<1) throw new RuntimeException("导出excel失败！");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        try {
            ServletOutputStream out = response.getOutputStream();
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet=wb.createSheet(sheetName);
            for (int i= 0;i<list.size();i++) {
                Object obj = list.get(i);
                Class clazz = obj.getClass();
                if(i== 0) {
                    HSSFRow row=sheet.createRow(i);
                    Field[] fields = clazz.getDeclaredFields();
                    int tmp = 0;
                    for (Field field :fields) {
                        HSSFCell cell = row.createCell(tmp);
                        ExcelField excelFiled = field.getAnnotation(ExcelField.class);
                        /*判断是否只支持导入*/
                        if (excelFiled == null||excelFiled.isOnlyImport()) continue;
                        cell.setCellValue(excelFiled.value());
                        tmp++;
                    }
                }
                HSSFRow row=sheet.createRow(i+1);
                Field[] fields = clazz.getDeclaredFields();
                int tmp = 0;
                for (Field field :fields) {
                    ExcelField excelFiled = field.getAnnotation(ExcelField.class);
                    if (excelFiled == null||excelFiled.isOnlyImport()){continue;}
                    HSSFCell cell = row.createCell(tmp);
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(),clazz);
                    Method getMethod = pd.getReadMethod();
                    Object o = getMethod.invoke(obj);
                    if(!StringUtils.isBlank(excelFiled.dateFormat())&& o instanceof Date) cell.setCellValue(DateUtil.format((Date)o,excelFiled.dateFormat()));
                    else cell.setCellValue(o==null?excelFiled.defaultValue():String.valueOf(o));
                    tmp++;
                }
            }
            response.reset();
            response.setHeader("Content-disposition", "attachment;filename="+ new String(sheetName.getBytes("utf-8"), "ISO8859-1")+".xls");
            response.setContentType("application/msexcel");
            wb.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("导出excel失败,["+e.getMessage()+"]");
        }
    }

    public static void exports2007(String sheetName,List<?> list) {

        if(list==null&&list.size()<1) throw new RuntimeException("导出excel失败！");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        try {
            ServletOutputStream out = response.getOutputStream();
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet=wb.createSheet(sheetName);
            for (int i= 0;i<list.size();i++) {
                Object obj = list.get(i);
                Class clazz = obj.getClass();
                if(i== 0) {
                    XSSFRow row=sheet.createRow(i);
                    Field[] fields = clazz.getDeclaredFields();
                    int tmp = 0;
                    for (Field field :fields) {
                        XSSFCell cell = row.createCell(tmp);
                        ExcelField excelFiled = field.getAnnotation(ExcelField.class);
                        if (excelFiled == null||excelFiled.isOnlyImport()) continue;
                        cell.setCellValue(excelFiled.value());
                        tmp++;
                    }
                }
                XSSFRow row=sheet.createRow(i+1);
                Field[] fields = clazz.getDeclaredFields();
                int tmp = 0;
                for (Field field :fields) {
                    ExcelField excelFiled = field.getAnnotation(ExcelField.class);
                    if (excelFiled == null||excelFiled.isOnlyImport()){continue;}
                    XSSFCell cell = row.createCell(tmp);
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(),clazz);
                    Method getMethod = pd.getReadMethod();
                    Object o = getMethod.invoke(obj);
                    if(!StringUtils.isBlank(excelFiled.dateFormat())&& o instanceof Date) cell.setCellValue(DateUtil.format((Date)o,excelFiled.dateFormat()));
                    else cell.setCellValue(o==null?excelFiled.defaultValue():String.valueOf(o));
                    tmp++;
                }
            }
            response.reset();
            response.setHeader("Content-disposition", "attachment;filename="+ new String(sheetName.getBytes("utf-8"), "ISO8859-1")+".xlsx");
            response.setContentType("application/msexcel");
            wb.write(out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("导出excel失败,["+e.getMessage()+"]");
        }
    }


    public static <T> List<T> imports(InputStream is,Class<T> clazz){
        List<T> result = Lists.newArrayList();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            /*获取第0行标题*/
            Row row0 = sheet.getRow(0);
            /*遍历每一列*/
            for (int r = 1; r < sheet.getPhysicalNumberOfRows(); r++) {
                T obj = clazz.newInstance();
                Field[] fields = obj.getClass().getDeclaredFields();
                Row row = sheet.getRow(r);
                for (int c = 0; c < row.getPhysicalNumberOfCells(); c++) {
                    for(Field field :fields) {
                        ExcelField excelFiled = field.getAnnotation(ExcelField.class);
                        String title = getCellValue(row0.getCell(c).getCellType(), row0.getCell(c));
                        if(excelFiled==null||!title.equals(excelFiled.value())) continue;
                        String cellValue = getCellValue(row.getCell(c).getCellType(), row.getCell(c));
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(),obj.getClass());
                        if("错误".equals(cellValue)||field.getType()==String.class) {
                            pd.getWriteMethod().invoke(obj, cellValue);
                            continue;
                        }
                        if(field.getType()==Integer.class){
                            pd.getWriteMethod().invoke(obj, Integer.parseInt(cellValue));
                            continue;
                        }
                        if(field.getType()==Long.class){
                            pd.getWriteMethod().invoke(obj, Long.parseLong(cellValue));
                            continue;
                        }
                        if(field.getType()==Float.class){
                            pd.getWriteMethod().invoke(obj, Float.parseFloat(cellValue));
                            continue;
                        }
                        if(field.getType()==Double.class){
                            pd.getWriteMethod().invoke(obj, Double.parseDouble(cellValue));
                            continue;
                        }
                        if(field.getType()==Date.class)
                            pd.getWriteMethod().invoke(obj, DateUtil.parseDate(cellValue));

                    }
                }
                result.add(obj);
            }
        }catch (Exception e) {
            throw new RuntimeException("导如excel失败,["+e.getMessage()+"]");
        }
        return result;
    }

    public static <T> List<T> imports2007(InputStream is, Class<T> clazz){
        List<T> result = Lists.newArrayList();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            /*获取第0行标题*/
            Row row0 = sheet.getRow(0);
            /*遍历每一列*/
            int r = 1;
            while (r < sheet.getPhysicalNumberOfRows()) {
                T obj = clazz.newInstance();
                Field[] fields = obj.getClass().getDeclaredFields();
                Row row = sheet.getRow(r);
                for (int c = 0; c < row.getPhysicalNumberOfCells(); c++) {
                    for(Field field :fields) {
                        ExcelField excelFiled = field.getAnnotation(ExcelField.class);
                        String title = getCellValue(row0.getCell(c).getCellType(), row0.getCell(c));
                        if(excelFiled==null||!title.equals(excelFiled.value())) {
                            r++;
                            continue;
                        }
                        String cellValue = getCellValue(row.getCell(c).getCellType(), row.getCell(c));
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(),obj.getClass());
                        if("错误".equals(cellValue)||field.getType()==String.class) {
                            pd.getWriteMethod().invoke(obj, cellValue);
                            r++;
                            continue;
                        }
                        if(field.getType()==Integer.class){
                            pd.getWriteMethod().invoke(obj, Integer.parseInt(cellValue));
                            r++;
                            continue;
                        }
                        if(field.getType()==Long.class){
                            pd.getWriteMethod().invoke(obj, Long.parseLong(cellValue));
                            r++;
                            continue;
                        }
                        if(field.getType()==Float.class){
                            pd.getWriteMethod().invoke(obj, Float.parseFloat(cellValue));
                            r++;
                            continue;
                        }
                        if(field.getType()==Double.class){
                            pd.getWriteMethod().invoke(obj, Double.parseDouble(cellValue));
                            r++;
                            continue;
                        }
                        if(field.getType()==Date.class)
                            pd.getWriteMethod().invoke(obj, DateUtil.parseDate(cellValue));

                    }
                }
                result.add(obj);
                r++;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("导如excel失败,["+e.getMessage()+"]");
        }
        return result;
    }

    public static String getCellValue(int cellType,Cell cell){
        switch(cellType) {
            case Cell.CELL_TYPE_STRING: /*文本*/
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_NUMERIC: /*数字、日期*/
                if(org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    return DateUtil.formatDate(cell.getDateCellValue()); /*日期型*/
                }
                else {
                    DecimalFormat df = new DecimalFormat("0");
                    return df.format(cell.getNumericCellValue());
                }
            case Cell.CELL_TYPE_BOOLEAN: /*布尔型*/
                return  String.valueOf(cell.getBooleanCellValue());
            case Cell.CELL_TYPE_BLANK: /*空白*/
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_ERROR: /*错误*/
                return "错误";
            case Cell.CELL_TYPE_FORMULA: /*公式*/
                return "错误";
            default:
                return "错误";
        }
    }

    public static String changeF2Y(String amount) throws Exception{
        if(!amount.matches( "\\-?[0-9]+")) {
            throw new Exception("金额格式有误");
        }
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
    }
}
