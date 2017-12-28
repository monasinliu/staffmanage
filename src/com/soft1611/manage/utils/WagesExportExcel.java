package com.soft1611.manage.utils;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Staff;
import com.soft1611.manage.model.Wage;
import com.soft1611.manage.service.StaffService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.List;

/**
 *
 * @author 朱广旭
 * @date 2017/12/26
 * 薪资记录数据表
 */
public class WagesExportExcel {
    private static StaffService staffService = ServiceFactory.getStaffService();
    public static void exportData(List<Wage> list) {

        //创建新的工作簿对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建工作表对象
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("个人出勤记录表");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);

        //  列  名
        String[] titles = {"   ","工  号","姓  名","日  期","部  门","工资金额","下发记录"};
        //  for循环生成列名
        for (int i = 1; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);
            hssfCell.setCellValue(titles[i]);
        }
        //   填充数据
        int rowIndex = 1;
        for(Wage wages : list){
            Staff staff = staffService.getStaff(wages.getAccount());
            hssfRow = hssfSheet.createRow(rowIndex);
            hssfCell = hssfRow.createCell(1);
            hssfCell.setCellValue(staff.getAccount());
            hssfCell = hssfRow.createCell(2);
            hssfCell.setCellValue(staff.getName());
            hssfCell = hssfRow.createCell(3);
            hssfCell.setCellValue(wages.getTime().toString());
            hssfCell = hssfRow.createCell(4);
            hssfCell.setCellValue(staff.getDepartment());
            hssfCell = hssfRow.createCell(5);
            hssfCell.setCellValue(String.valueOf(wages.getRealWage()));
            if(hssfRow.createCell(0) != null){
                hssfCell = hssfRow.createCell(6);
                hssfCell.setCellValue("已下发");
            }else{
                hssfCell = hssfRow.createCell(6);
                hssfCell.setCellValue("未下发");
            }
            rowIndex++;
//            //content[0] = String.valueOf(wages.getTime());
//            content[1] = staff.getName();
//            content[2] = wages.getAccount();
//            content[3] = staff.getDepartment();
//            content[4] = String.valueOf(wages.getReal_wages());
//            if(content[0] != null){
//                content[5] = "已下发";
//            }else{
//                content[5] = "null";
//            }
        }
        File file = new File("A:\\wages.xls");
        OutputStream output = null;
        try{
            output = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            hssfWorkbook.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
