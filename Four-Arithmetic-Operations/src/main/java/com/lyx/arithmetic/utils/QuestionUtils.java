package com.lyx.arithmetic.utils;

import com.lyx.arithmetic.service.Calculate;
import com.lyx.arithmetic.service.Fraction;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * Description: 过合法性检验，生成算术表达式，未查重
 *
 * @author lyx
 * Date:2023/9/27 9:33
 */
public class QuestionUtils {
    //生成题目 带括号
    public static String generateExp(Integer limit) throws StringIndexOutOfBoundsException{
        Random rd = new Random();

        // 生成四个随机数
        int e1 = rd.nextInt(limit);
        int e2 = rd.nextInt(limit);
        int e3 = rd.nextInt(limit);
        int e4 = rd.nextInt(limit);

        // 保存生成的题目
        StringBuilder str = new StringBuilder();

        int[] num = { e1, e2, e3, e4 }; // 数字
        char[] opt = { '+', '-', '*', '/' }; // 运算符
        int[] no = { 1, 2, 3 }; // 控制选择的运算符(0-3)
        int numOperators = no[rd.nextInt(3)]; // 控制运算符的数目

        for (int j = 0; j < numOperators; j++) {
            str.append(num[rd.nextInt(4)]).append(" "); // 添加数字和空格
            str.append(opt[rd.nextInt(4)]).append(" "); // 添加运算符和空格
        }
        str.append(num[rd.nextInt(4)]); // 添加最后一个数字
        int index = 0; // 记录数组的下标
        int len = 0;
        String left = "";
        String right = "";
        String remainder = "";

        // 添加括号
        int[] indexs = { 0, 4, 8 }; // 从indexs开始加左括号
        int[] lens = { 5, 9, 13 }; // 括号的宽度，即从从indexs+len开始加右括号
        index = indexs[rd.nextInt(3)];
        len = lens[rd.nextInt(3)];

        //随机添加括号
        if (index + len < str.length() - 1 || (index + len == str.length() + 1 && index != 0)) {
            left = str.substring(0, index) + "(";
            right = str.substring(index, index + len) + ")";
            remainder = str.substring(index + len);
        }
        //不能生成括号
        if (left==""){
            return str.toString();
        }
        return left+right+remainder;

    }


    public static void legalExp(Integer number, Integer limit) throws IOException {


        HashMap<String, Integer> answers = new HashMap<String, Integer>();
        String questionFile="";
        String answerFile="";

        for (int j = 1; j <= number; j++) {
            String question = QuestionUtils.generateExp(limit) + " = ";//获得原始表达式
            Calculate cal = new Calculate();
            Fraction f = cal.outcome(question);

            //返回100000 说明不能计算
            if (f.getNumerator() == 100000) {

                j--;
                continue;
            }

            String result = f.transferFraction(f);//最终结果，已经化简

            if(answers.containsKey(Calculate.temp)){
                j--;
                continue;
            }else{
                answers.put(Calculate.temp, null);
                questionFile += j+"."+"    "+question+"\n";
                answerFile += j+"."+"    "+question+result+"\n";
            }
        }

        System.out.println("表达式生成完毕，进行存入文件");

        FileUtils.writeToFile("D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\question.txt",questionFile);//整个字符串
        FileUtils.writeToFile("D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\answer.txt",answerFile);//整个字符串

    }

}
