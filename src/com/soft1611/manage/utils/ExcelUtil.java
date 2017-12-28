package com.soft1611.manage.utils;

import com.soft1611.manage.model.Staff;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 朱广旭
 * @date 2017/12/25
 * 操作Excel表格的功能类
 */
public class ExcelUtil {
    //excel文件对象
    private POIFSFileSystem fs;
    // 工作簿对象
    private HSSFWorkbook wb;
    // 工作表对象
    private HSSFSheet sheet;
    // 行对象
    private HSSFRow row;

    /**
     * 读取Excel表格内容
     * @param is
     * @return 一组员工数据list集合
     */
    public List<Staff> readExcelContent(InputStream is){
        List<Staff> staffList = new ArrayList<>();
        try{
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //得到第一张工作表
        sheet = wb.getSheetAt(0);
        // 正文内容应该从第二行开始,第一行为表头的标题
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //所有要导入的学生对象使用这个默认头像
        File file = new File(" C:\\Users\\朱广旭\\Pictures\\头像\\1.png");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[(int) file.length()];
        try {
            inputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
