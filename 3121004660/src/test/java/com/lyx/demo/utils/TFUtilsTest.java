package com.lyx.demo.utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/17 10:37
 */
public class TFUtilsTest {
    private  final TFUtils cosUtils =new TFUtils();
    @Test
    public void testSeparateWord() throws IOException {
        final String fileText = FileUtils.getFileText("C:\\Users\\forget1734\\Desktop\\测试文本\\orig.txt");
        final List<String> list = TFUtils.segmentAndPreprocess(fileText);
        list.forEach(i-> System.out.println(i));
    }
    @Test
    public void testCalculateCosineSimilarity() throws IOException {
        final String fileText1 = FileUtils.getFileText("C:\\Users\\forget1734\\Desktop\\测试文本\\orig.txt");
        final String fileText2 = FileUtils.getFileText("C:\\Users\\forget1734\\Desktop\\测试文本\\orig_0.8_add.txt");
        final double v = cosUtils.calculateCosineSimilarity(TFUtils.segmentAndPreprocess(fileText1), TFUtils.segmentAndPreprocess(fileText2));
        System.out.println(v);
    }
}

