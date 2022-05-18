package com.test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author yemingjie.
 * @date 2022/5/18.
 * @time 08:21.
 */
public class ExcelUtil {
    public static void main(String[] args){
        ExcelUtil excelUtil = new ExcelUtil();
        //读取excel数据
        Map<String, List<ItemImportVo>> result = excelUtil.readExcelToObj("/Users/admin/Downloads/test.xlsx");
        System.out.println(result);
    }
    /**
     * 读取excel数据
     * @param path
     */
    private Map<String, List<ItemImportVo>> readExcelToObj(String path) {

        Workbook wb = null;
        Map<String, List<ItemImportVo>> result = null;
        try {
            wb = WorkbookFactory.create(new File(path));
            Map<String, List<ItemImportVo>> tradeMap= new HashMap<>();
            result = readExcel(wb, 0,tradeMap);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 读取excel文件
     * @param wb
     * @param sheetIndex sheet页下标：从0开始
     */
    private Map<String, List<ItemImportVo>> readExcel(Workbook wb,int sheetIndex, Map<String, List<ItemImportVo>> tradeMap) {
        Sheet sheet = wb.getSheetAt(sheetIndex);
        Row row = sheet.getRow(0);
        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
        row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
        row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
        row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
        row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
        String itemIidHead = "";
        String marketHead = "";
        String stallHead = "";
        String costHead = "";
        String skuNameHead = "";
        // 规格维度
        itemIidHead = row.getCell(0).getStringCellValue();
        skuNameHead = row.getCell(1).getStringCellValue();
        marketHead = row.getCell(2).getStringCellValue();
        stallHead = row.getCell(3).getStringCellValue();
        costHead = row.getCell(4).getStringCellValue();
        int rowNum = sheet.getLastRowNum() + 1;
        // 合并了几行
        int spanRow = 1;
        String tempNumId = "";
        // 合并到几行
        int lastRow = 0;
        for (int i = 1; i < rowNum; i++) {
            row = sheet.getRow(i);
            String numId = null;
            String market = null;
            String stall = null;
            String cost = null;
            String skuName = null;
            for (Cell c : row) {
                String returnStr = "";
                boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());
                // 判断是否合并单元格
                if (isMerge) {
                    List<String> dataList = getMergerCellRegionRow(sheet, row.getRowNum(), c.getColumnIndex());

                    spanRow = Integer.parseInt(dataList.get(0));
                    lastRow = Integer.parseInt(dataList.get(1));
                    returnStr = dataList.get(2);
                    System.out.println("sheet ===> 合并到了那行："+ lastRow);
                    if (c.getColumnIndex() == 0) {
                        tempNumId = returnStr;
                    }
                    System.out.println("sheet ===> 合并单元格的值：{}, "+returnStr+"{}, "+tempNumId);
                    System.out.println("合并的行数：==> {}, " + spanRow);
                } else {
                    returnStr = getCellValue(c);
                    System.out.println("sheet ===> 值：{}" + returnStr);

                }
                if (spanRow > 1 && i <= lastRow) {
                    numId = tempNumId;
                } else {
                    spanRow = 1;
                    tempNumId = "";
                }
                if (c.getColumnIndex() == 0) {
                    numId = returnStr;
                } else if (c.getColumnIndex() == 1) {
                    skuName = returnStr;
                } else if (c.getColumnIndex() == 2) {
                    market = returnStr;
                } else if (c.getColumnIndex() == 3) {
                    stall = returnStr;
                } else if (c.getColumnIndex() == 4) {
                    cost = returnStr;
                }
            }

            String costReg = "^([1-9][0-9]*)+(.[0-9]{1,3})?$";
            if (tradeMap.containsKey(numId) && spanRow == 1) {
                System.out.println(("第" +( i +1)+ "行,重复的宝贝id:" + numId));
            }

            ItemImportVo itemImportVo = new ItemImportVo();
            itemImportVo.setShichang(market);
            itemImportVo.setDangkou(stall);
            itemImportVo.setChengben(cost);
            itemImportVo.setSkuName(skuName);
            itemImportVo.setSkuId(0L);

            tradeMap.computeIfAbsent(numId, k -> new ArrayList<>());
            List<ItemImportVo> itemImportVos = tradeMap.get(numId);
            itemImportVos.add(itemImportVo);
            tradeMap.put(numId, itemImportVos);
        }
        return tradeMap;
    }

    /**
     * 获取合并单元格的值
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet ,int row , int column){
        int sheetMergeCount = sheet.getNumMergedRegions();
        for(int i = 0 ; i < sheetMergeCount ; i++){
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell) ;
                }
            }
        }
        return null ;
    }

    /**
     * 判断合并了行
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    private boolean isMergedRow(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row == firstRow && row == lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断指定的单元格是否是合并单元格
     * @param sheet
     * @param row 行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet,int row ,int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if(row >= firstRow && row <= lastRow){
                if(column >= firstColumn && column <= lastColumn){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断sheet页中是否含有合并单元格
     * @param sheet
     * @return
     */
    private boolean hasMerged(Sheet sheet) {
        return sheet.getNumMergedRegions() > 0 ? true : false;
    }

    /**
     * 合并单元格
     * @param sheet
     * @param firstRow 开始行
     * @param lastRow 结束行
     * @param firstCol 开始列
     * @param lastCol 结束列
     */
    private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {
        sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public String getCellValue(Cell cell){

        if(cell == null) return "";

        if(cell.getCellType() == Cell.CELL_TYPE_STRING){

            return cell.getStringCellValue();

        }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){

            return String.valueOf(cell.getBooleanCellValue());

        }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){

            return cell.getCellFormula() ;

        }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){

            return String.valueOf(cell.getNumericCellValue());

        }
        return "";
    }

    /**
     * 判断单元格是否是合并的单格，如果是，获取其合并的行数。
     */
    private List<String> getMergerCellRegionRow(Sheet sheet, int cellRow, int cellCol) {
        int retVal = 0;
        List<String> list = new LinkedList<>();
        int sheetMergerCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergerCount; i++) {
            CellRangeAddress cra = sheet.getMergedRegion(i);
            int firstRow = cra.getFirstRow(); // 合并单元格CELL起始行
            int firstCol = cra.getFirstColumn(); // 合并单元格CELL起始列
            int lastRow = cra.getLastRow(); // 合并单元格CELL结束行
            int lastCol = cra.getLastColumn(); // 合并单元格CELL结束列
            if (cellRow >= firstRow && cellRow <= lastRow) { // 判断该单元格是否是在合并单元格中
                if (cellCol >= firstCol && cellCol <= lastCol) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstCol);
                    retVal = lastRow - firstRow + 1; // 得到合并的行数
                    list.add(String.valueOf(retVal));
                    list.add(String.valueOf(lastRow));
                    list.add(getCellValue(fCell));
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 从excel读取内容
     */
    public static void readContent(String fileName)  {
        boolean isE2007 = false;    //判断是否是excel2007格式
        if(fileName.endsWith("xlsx"))
            isE2007 = true;
        try {
            InputStream input = new FileInputStream(fileName);  //建立输入流
            Workbook wb  = null;
            //根据文件格式(2003或者2007)来初始化
            if(isE2007)
                wb = new XSSFWorkbook(input);
            else
                wb = new HSSFWorkbook(input);
            Sheet sheet = wb.getSheetAt(0);     //获得第一个表单
            Iterator<Row> rows = sheet.rowIterator(); //获得第一个表单的迭代器
            while (rows.hasNext()) {
                Row row = rows.next();  //获得行数据
                System.out.println("Row #" + row.getRowNum());  //获得行号从0开始
                Iterator<Cell> cells = row.cellIterator();    //获得第一行的迭代器
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    System.out.println("Cell #" + cell.getColumnIndex());
                    switch (cell.getCellType()) {   //根据cell中的类型来输出数据
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        default:
                            System.out.println("unsuported sell type======="+cell.getCellType());
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
