package com.example.Bms.Helper;

import com.example.Bms.Entity.Floor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloorHelper {
    public static boolean checkExcelFormate(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.shee"))
        {
            return true;
        }else
        {
            return false;
        }
    }
    public static List<Floor> convertExcelToListOfEntity(InputStream is)
    {
        List<Floor> list =new ArrayList<>();
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNumber=0;
            Iterator<Row> iterator = sheet.iterator();

            while(iterator.hasNext())
            {
                Row row = iterator.next();
                if (rowNumber==0)
                {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid=0;
                Floor ee = new Floor();
                while(cells.hasNext())
                {
                    Cell cell = cells.next();
                    switch (cid)
                    {
                        case 0:
                            ee.setFloorNo((int) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(ee);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
