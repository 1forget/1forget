package com.lyx.arithmetic.service;

import com.lyx.arithmetic.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 将问题文件与答案文件做对比
 *
 * @author lyx
 * Date:2023/9/28 17:13
 */
@Slf4j
public class Judge {
    public static void addAnswerToList(List<String> list,String path) throws IOException {
        String questionText= FileUtils.getFileText(path);

        final String[] split = questionText.split("\n");
        log.info("获取用户回答文档有"+split.length+"条数据");
        for (int i = 0; i < split.length; i++) {
            String answerStr = split[i];
            String[] answerSpilt = answerStr.split(" = ");
            String answer = answerSpilt[1];
            list.add(answer);
        }


    }

    public static void JudgeTrueOrWrong(String questionTxt, String answerTxt) throws IOException {

        String questionText = FileUtils.getFileText(questionTxt);

        final String[] split = questionText.split("\n");

        List<Integer> rightList = new ArrayList<>(split.length);
        List<Integer> wrongList = new ArrayList<>(split.length);
        //获取答案副本到数组中 以便后续判断
        ArrayList<String> answerList = new ArrayList<>(split.length);

        addAnswerToList(answerList, answerTxt);
        log.info("获取问题文档有"+split.length+"条数据");

        for (int i = 0; i < split.length; i++) {
            int index = split[i].indexOf(".");
            String numberStr = split[i].substring(0, index);
            //获取得到题目编号
            Integer number = Integer.valueOf(numberStr);

            //获得题目
            String question = split[i].substring(index + 1).trim();

            Calculate cal = new Calculate();
            Fraction f = cal.outcome(question);

            //返回100000 说明
            if (f.getNumerator() == 100000) {
                wrongList.add(number);
            }

            String result = f.transferFraction(f);//最终结果，已经化简
            String answerStr = answerList.get(i);
            //判断与答案是否相同
            if (result.equals(answerStr)){
                rightList.add(number);
            }else {
                wrongList.add(number);
            }

        }
        addResultToGradeTxt(rightList, wrongList);
    }
    //将结果放进Grade.txt
    public static void addResultToGradeTxt( List<Integer> rightList, List<Integer> wrongList){
       //将list数据转化为string数据
        StringBuffer stringBuffer=new StringBuffer("Correct: "+rightList.size()+"(");
        rightList.forEach(i->stringBuffer.append(i).append(","));
        String rightStr=stringBuffer.deleteCharAt(stringBuffer.length()-1).toString()+ ")\n";

        StringBuffer wrongBuffer=new StringBuffer("Wrong:   "+wrongList.size()+"(");
        wrongList.forEach(i->wrongBuffer.append(i).append(","));
        String wrongStr=wrongBuffer.deleteCharAt(wrongBuffer.length()-1).toString()+ ")\n";

        try {
            String gradePath="D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\grade.txt";
            FileUtils.writeToFile(gradePath, rightStr);
            FileUtils.writeToFile(gradePath, wrongStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
