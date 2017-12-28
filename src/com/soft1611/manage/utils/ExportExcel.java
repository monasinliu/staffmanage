package com.soft1611.manage.utils;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Attendance;
import com.soft1611.manage.model.Staff;
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
 * @date 2017/12/25
 * 出勤记录数据导出工具类
 */
public class ExportExcel {
    private static StaffService staffService = ServiceFactory.getStaffService();
    public static void exportData(List<Attendance> list) {

        //创建新的工作簿对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建工作表对象
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("个人出勤记录表");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCell hssfCell = hssfRow.createCell(0);

        //  列  名
        String[] titles = {"日  期","姓  名","工  号","部  门","出勤记录"};
	    //  for循环生成列名
        for (int i = 0; i < titles.length; i++) {
            hssfCell = hssfRow.createCell(i);
            hssfCell.setCellValue(titles[i]);
        }
        //   填充数据
        int rowIndex = 1;
        for(Attendance attendance : list){
            Staff staff = staffService.getStaff(attendance.getAccount());
            hssfRow = hssfSheet.createRow(rowIndex);
            hssfCell = hssfRow.createCell(0);
            hssfCell.setCellValue(attendance.getAttend_time().toString());
            hssfCell = hssfRow.createCell(1);
            hssfCell.setCellValue(staff.getName());
            hssfCell = hssfRow.createCell(2);
            hssfCell.setCellValue(attendance.getAccount());
            hssfCell = hssfRow.createCell(3);
            hssfCell.setCellValue(staff.getDepartment());
            hssfCell = hssfRow.createCell(4);
            hssfCell.setCellValue(attendance.getAttend_case());
            rowIndex++;
        }
        File file = new File("A:\\attendance.xls");
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
