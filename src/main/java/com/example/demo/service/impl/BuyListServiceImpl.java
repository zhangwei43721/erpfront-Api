package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.*;
import com.example.demo.pojo.*;
import com.example.demo.service.BuyListService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【buy_list(采购单表，记录商品采购信息)】的数据库操作Service实现
 * @createDate 2025-05-29 11:53:57
 */
@Service
public class BuyListServiceImpl extends ServiceImpl<BuyListMapper, BuyList>
        implements BuyListService {

    private final ItemMapper itemMapper;
    private final StoreMapper storeMapper;
    private final SupplyMapper supplyMapper;
    private final PlaceMapper placeMapper;
    private final BuyListMapper buyListMapper;

    public BuyListServiceImpl(ItemMapper itemMapper, StoreMapper storeMapper, SupplyMapper supplyMapper, PlaceMapper placeMapper, BuyListMapper buyListMapper) {
        this.itemMapper = itemMapper;
        this.storeMapper = storeMapper;
        this.supplyMapper = supplyMapper;
        this.placeMapper = placeMapper;
        this.buyListMapper = buyListMapper;
    }

    @Override
    public Map<String, Object> queryAutoDataBuyService(Integer id) {
        Map<String, Object> result = new HashMap<>();
        //查询商品信息
        Item item = itemMapper.selectById(id);
        result.put("id", item.getId());
        result.put("itemName", item.getItemName());
        //查询仓库信息
        Integer storeId = item.getStoreId();
        Store store = storeMapper.selectById(storeId);
        result.put("storeId", store.getStoreId());
        result.put("storeName", store.getStoreName());
        //查询供应商信息
        Integer supplyId = item.getSupplyId();
        Supply supply = supplyMapper.selectById(supplyId);
        result.put("supplyId", supply.getSupplyId());
        result.put("supplyName", supply.getSupplyName());
        //查询产地信息
        Integer placeId = item.getPlaceId();
        Place place = placeMapper.selectById(placeId);
        result.put("placeId", place.getPlaceId());
        result.put("placeName", place.getPlaceName());
        return result;
    }

    @Override
    public Map<String, Object> queryBuyListService(Integer pageNum, Integer pageSize) {
        //指定分页查询参数
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        //查询数据库
        List<BuyList> buyLists = buyListMapper.queryBuyListMapper();
        Map<String, Object> result = new HashMap<>();
        result.put("total", page.getTotal());
        result.put("buyLists", buyLists);
        return result;
    }

    //XSSFWorkbook 返回的是一个XSSFWorkbook对象，表示一个excel文件
    @Override
    public XSSFWorkbook exportExcelService() {

        //创建XSSFWorkbook对象，形成一个excel文件
        XSSFWorkbook xwb = new XSSFWorkbook();
        //在excel文件中添加sheet表
        XSSFSheet sheet = xwb.createSheet("采购单信息");
        //sheet添加行,当一行
        XSSFRow row0 = sheet.createRow(0);
        //给第一行添加列
        XSSFCell row0cell0 = row0.createCell(0);
        row0cell0.setCellValue("采购单列表");
        //设置单元格内容居中
        XSSFCellStyle style = xwb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillBackgroundColor(new XSSFColor(
                new java.awt.Color(255, 0, 0), null));
        XSSFFont font = new XSSFFont();
        font.setFontHeight(30);
        style.setFont(font);
        row0cell0.setCellStyle(style);
        //合并第一行，扩列合并列,从第一行合并8列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
        ////////////////////////////////设置表头///////////////////////////////
        //创建第二行表头
        XSSFRow row1 = sheet.createRow(1);
        //创建第一行，8个列，并填充数据
        row1.createCell(0).setCellValue("仓库名称");
        row1.createCell(1).setCellValue("商品名称");
        row1.createCell(2).setCellValue("预计采购数量");
        row1.createCell(3).setCellValue("实际采购数量");
        row1.createCell(4).setCellValue("采购人");
        row1.createCell(5).setCellValue("采购时间");
        row1.createCell(6).setCellValue("采购人电话");
        row1.createCell(7).setCellValue("状态");
        //查询数据库，获得需要填充的数据
        //指定分页查询参数
        PageHelper.startPage(1, 0);
        //查询数据库
        List<BuyList> buyLists = buyListMapper.queryBuyListMapper();
        //debug看数据
        System.out.println(buyLists);
        int index = 2;
        for (BuyList buy : buyLists) {
            //每循环遍历一次，创建一行
            XSSFRow rown = sheet.createRow(index);
            rown.createCell(0).setCellValue(buy.getStoreName());
            rown.createCell(1).setCellValue(buy.getItemName());
            rown.createCell(2).setCellValue(buy.getBuyNum());
            rown.createCell(3).setCellValue(buy.getFactBuyNum());
            rown.createCell(4).setCellValue(buy.getBuyUser());
            XSSFCell cell = rown.createCell(5);
            // 创建一个日期样式
            CellStyle dateStyle = xwb.createCellStyle();
            short dateFormat = xwb.getCreationHelper().createDataFormat()
                    .getFormat("yyyy-MM-dd HH:mm:ss"); // 设置日期格式
            dateStyle.setDataFormat(dateFormat);
            cell.setCellStyle(dateStyle);
            cell.setCellValue(buy.getBuyTime());
            rown.createCell(6).setCellValue(buy.getPhone());
            //判断采购单准提
            // 判断采购单准提状态（安全处理 null）
            String isIn = buy.getIsIn();
            String result = "0".equals(isIn) ? "未入库" : "已入库"; // 或使用显式判空
            rown.createCell(7).setCellValue(result);
            index++;
        }
        return xwb;
    }
}




