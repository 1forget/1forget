package com.lyx.demo.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/17 10:32
 */
public class FileUtilsTest {
    @Test
    public void testGetFileText() throws IOException {
        final String fileText = FileUtils.getFileText("C:\\Users\\forget1734\\Desktop\\测试文本\\orig.txt");
        System.out.println(fileText);
    }
    @Test
    public void test() throws IOException {

        FileUtils.writeToFile("C:\\Users\\forget1734\\Desktop\\测试文本\\result.txt", "xx文件的查重率为10%");
    }
}
