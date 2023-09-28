package com.lyx.arithmetic.utils;

import com.lyx.arithmetic.service.Calculate;
import com.lyx.arithmetic.service.Fraction;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/28 7:28
 */
public class FileUtilsTest {
    @Test
    public void testGetAnswerFormFile() throws IOException {
       String fileText= FileUtils.getFileText("D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\answer.txt");
        final String[] split = fileText.split("\n");
        for (int i = 0; i < split.length; i++) {
             String[] split1 = split[i].split(" = ");
//            System.out.println(split1.length);
            System.out.println(split1[1]);
        }
    }
    @Test
    public void testSperate(){
        String str="1.   4 / 4 / 6 = ";
        int index = str.indexOf(".");
        String substring = str.substring(0, index);
        System.out.println(substring);
        final String[] split = str.substring(index+1, str.length()).split(" = ");
        String trim = split[0].trim();
        System.out.println(trim);


    }
    @Test
    public void testGetQuestion() throws IOException {


        String questionText= FileUtils.getFileText("D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\question.txt");
        final String[] split = questionText.split("\n");

        for (int i = 0; i < split.length; i++) {
            int index = split[i].indexOf(".");
            String numberStr = split[i].substring(0, index);
            //获取得到题目编号
            Integer number = Integer.valueOf(numberStr);

            //获得题目
            String question =  split[i].substring(index+1).trim();

            Calculate cal = new Calculate();
            Fraction f = cal.outcome(question);

            //返回100000 说明
            if (f.getNumerator() == 100000) {

            }

            String result = f.transferFraction(f);//最终结果，已经化简
            System.out.println(number+"..."+question+" = "+result);

//            System.out.println(split1.length);
        }
    }
    @Test
    public void testGetAnswer() throws IOException {
        String questionText= FileUtils.getFileText("D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\answer.txt");

        final String[] split = questionText.split("\n");
        for (int i = 0; i < split.length; i++) {
            String answerStr = split[i];
            String[] answerSpilt = answerStr.split(" = ");
            String answer = answerSpilt[1];
            System.out.println(answer);

        }
    }

}
