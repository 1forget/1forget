package com.lyx.arithmetic.service;

import org.junit.Test;

import java.io.IOException;

/**
 * Description:
 *
 * @author lyx
 * Date:2023/9/28 17:29
 */
public class JudgeTest {
    @Test
    public void  testJudge() throws IOException {
        Judge.JudgeTrueOrWrong("D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\question.txt","D:\\IdeaTestProject\\Four-Arithmetic-Operations\\src\\main\\resources\\answer.txt");
    }
}
