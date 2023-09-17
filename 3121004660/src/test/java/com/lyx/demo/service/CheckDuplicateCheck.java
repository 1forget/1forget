package com.lyx.demo.service;

import com.lyx.demo.service.impl.CheckDuplicateCheckServiceImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/17 10:48
 */
public class CheckDuplicateCheck {
    @Test
    public void testCheckDuplicateCheckService() throws IOException {
        CheckDuplicateCheckService checkService = new CheckDuplicateCheckServiceImpl();

        String origin = "C:\\Users\\forget1734\\Desktop\\测试文本\\orig.txt";
        String output = "C:\\Users\\forget1734\\Desktop\\测试文本\\result.txt";

        String[] targetFiles = {
                "C:\\Users\\forget1734\\Desktop\\测试文本\\orig_0.8_add.txt",
                "C:\\Users\\forget1734\\Desktop\\测试文本\\orig_0.8_del.txt",
                "C:\\Users\\forget1734\\Desktop\\测试文本\\orig_0.8_dis_1.txt",
                "C:\\Users\\forget1734\\Desktop\\测试文本\\orig_0.8_dis_10.txt",
                "C:\\Users\\forget1734\\Desktop\\测试文本\\orig_0.8_dis_15.txt"
        };
        // 调用duplicateCheckService接口
        for (String target:targetFiles) {
            double result = checkService.checkDuplicate(origin,target,output);
            System.out.printf("[%tc] %s 该文件查重率为%.2f \n",new Date(),target,result);
        }
    }
}
