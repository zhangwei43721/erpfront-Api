package com.example.demo.controller;

import com.example.demo.pojo.BuyList;
import com.example.demo.service.BuyListService;
import com.example.demo.util.R;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@RestController
public class BuyListController {

    private final BuyListService buyListService;

    public BuyListController(BuyListService buyListService) {
        this.buyListService = buyListService;
    }

    /*处理采购信息需要自动带入数据的请求*/
    @GetMapping("/buyAutoInfo/{id}")
    public Map<String, Object> buyAutoInfo(@PathVariable Integer id) {
        return buyListService.queryAutoDataBuyService(id);
    }

    /*保存采购信息*/
    @PostMapping("/saveBuy")
    public Map<String, Object> saveBuy(@RequestBody BuyList buyList) {
        buyList.setBuyTime(new Date());
        buyList.setIsIn("0");
        buyList.setFactBuyNum(0);
        return buyListService.save(buyList) ? R.success("保存成功") : R.error("保存失败");
    }

    /*处理采购单分页查询请求*/
    @GetMapping("/queryBuyList")
    public Map<String, Object> queryBuyList(
            @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "3") Integer pageSize) {
        return buyListService.queryBuyListService(pageNum, pageSize);
    }

    /*处理采购单修改请求*/
    @PostMapping("/updateBuyList")
    public Map<String, Object> updateBuyList(@RequestBody BuyList buyList) {
        return buyListService.updateById(buyList) ? R.success("修改成功") : R.error("修改失败");
    }

    /*处理采购单删除请求*/
    @PostMapping("/deleteBuy/{id}")
    public Map<String, Object> deleteBuy(@PathVariable Integer id) {
        return buyListService.removeById(id) ? R.success("删除成功") : R.error("删除失败");
    }

    /*处理数据导出excel请求，下载excel文件*/
    @GetMapping("/exportExcel")
    public ResponseEntity exportExcel() {
        XSSFWorkbook workbook = buyListService.exportExcelService();
        //将workbook，excel文件对象，封装到字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获得字节数组中封装的文件,响应体
        byte[] bytes = baos.toByteArray();
        //创建HttpHeaders对象封装响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); //响应体的类型
        //设置下载的文件的名字
        //headers.setContentDisposition("attachment;filename=采购单列表");
        String name = "采购单列表.xlsx";
        name = URLEncoder.encode(name, StandardCharsets.UTF_8);
        System.out.println("name=" + name);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + name);

        //创建对象，封装响应体，响应头，状态吗
        return (ResponseEntity<byte[]>) new ResponseEntity(bytes, headers, HttpStatus.CREATED);
    }
}
