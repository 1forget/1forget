package com.lyx.arithmetic;

import com.lyx.arithmetic.service.Judge;
import com.lyx.arithmetic.utils.StringUtils;
import com.lyx.arithmetic.utils.QuestionUtils;

import java.io.IOException;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/27 22:51
 */
public class Main {


    public static void main(String[] args) throws IOException {
        Integer numbers=10;
        Integer limit=0;
        String questionTxt="";
        String answerTxt="";
        System.out.println(args[args.length-1]);
        for (int i = 0; i < args.length; i++) {
            String arg=args[i];
            if(arg.equals("-n")){
                numbers=Integer.valueOf(args[i+1]);
            } else if(arg.equals("-r")){
                // -e后必须为 正整数
                if((i+1)>= args.length||!StringUtils.isPositiveInteger(args[i+1])){
                    System.out.println("参数有误 请重新输入");
                    return;
                }
                limit=Integer.valueOf(args[i+1]);
            }else if(arg.equals("-e")){
                questionTxt=args[i+1];
            }else if (arg.equals("-a")){
                answerTxt=args[i+1];
            }
            i++;
        }
        if (limit!=0){
            QuestionUtils.legalExp(numbers,limit);
        }else if (questionTxt!=""&&answerTxt!=""){
            Judge.JudgeTrueOrWrong(questionTxt, answerTxt);
        }else {
            System.out.println("参数有误 请重新输入");
            return;
        }
    }
}


