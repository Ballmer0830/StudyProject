package com.demo01;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * <code>ExcelUtils</code>
 * </p>
 *
 * @author junbao3
 * 解析excel 生成sql脚本
 *
 * @date 2024/2/21 19:01
 */
public class ExcelUtils {

    public static void createInsertSQlByExcel(String excelPath,String preInsert, String suffInsert){
        ExcelReader reader = ExcelUtil.getReader(excelPath);
        List<Map<String, Object>> list = reader.readAll();

        int i = 0;
        for (Map<String, Object> map : list) {
            StringBuilder sb = new StringBuilder(preInsert);
            i=i+1;
            String str = (String) map.get("是否启用：0 禁用 1 启用");
            char flag;
            if (str.equals("Y")){
                flag = '1';
            }else {
                flag = '0';

            }
            sb.append("("+i+",")
                    .append("\""+map.get("区域编码")+"\",")
                    .append("\""+map.get("一级区域名称")+"\",")
                    .append("\""+map.get("二级区域名称")+"\",")
                    .append("\""+flag+"\",")
                    .append("'0',")
                    .append("\"admin\",").append("\"admin\",")
                    .append("now(),") .append("\"admin\",").append("\"admin\",")
                    .append("now()");
            sb.append(suffInsert);
            System.out.println(sb.toString());
        }

    }

    public static void main(String[] args) {
//        String preInsert = "insert into sales_region \n" +
//                "(id, region_code, first_level_region_name, second_level_region_name, enable, del_flag,create_account, create_name, create_time, update_account, update_name, update_time) \n" +
//                "values ";
//        String temp = "(1,\"xxx\",\"xxx\",\"xxx\",'1','0',\"admin\",\"admin\",now(),\"admin\",\"admin\",now()";
//        String suffInsert = ");";
//        createInsertSQlByExcel("F:/销售区域.xlsx",preInsert,suffInsert);

//        parseExcel("D:/金融科技构件折扣体系初始化数据.xls");

        String preInsert = "insert into struct_component_discount_system \n" +
                "(id, component_id,component_version_id," +
                "region_code, first_level_region_name, second_level_region_name, " +
                "first_line_sales_discount,region_director_discount,org_sub_leader_discount, " +
                "del_flag,create_account, create_time, update_account, update_time) \n" +
                "values ";
//        String temp = "(1,\"xxx\",\"xxx\",\"xxx\",'1','0',\"admin\",\"admin\",now(),\"admin\",\"admin\",now()";
        String suffInsert = ");";
        createInsertSQlByExcel2("D:/金融科技构件折扣体系初始化数据.xls",preInsert,suffInsert);
    }

    public static void createInsertSQlByExcel2(String excelPath,String preInsert, String suffInsert){
        ExcelReader reader = ExcelUtil.getReader(excelPath);
        List<Map<String, Object>> list = reader.readAll();

        for (Map<String, Object> map : list) {
            StringBuilder sb = new StringBuilder(preInsert);

            sb.append("(\""+UuidUtils.getUUID()+"\",")
                    .append("\""+map.get("id")+"\",")
                    .append("\""+map.get("versionIdNew")+"\",")
                    .append("\"\",")
                    .append("\"不限定区域\",")
                    .append("\"不限定区域\",")
                    .append("\"1\",")
                    .append("\"0.4\",")
                    .append("\"0.3\",")
                    .append("'0',")
                    .append("\"admin\",")
                    .append("now(),").append("\"admin\",")
                    .append("now()");
            sb.append(suffInsert);
            System.out.println(sb.toString());
        }

    }

    public  static void parseExcel(String excelPath){
        ExcelReader reader = ExcelUtil.getReader(excelPath);
        List<Map<String, Object>> list = reader.readAll();
        Map<String,String> codeAndIds = new HashMap();
        for (Map<String, Object> map : list) {
            String versionCode = (String) map.get("version_code");
            String versionId = (String) map.get("versionId");
            codeAndIds.put(versionCode,versionId);
        }

        for (Map<String, Object> map : list) {
            String versionCode = (String) map.get("构件版本号/型号编码");
            String versionId = codeAndIds.get(versionCode);
            System.out.println(versionCode+","+versionId);
        }

    }
}
