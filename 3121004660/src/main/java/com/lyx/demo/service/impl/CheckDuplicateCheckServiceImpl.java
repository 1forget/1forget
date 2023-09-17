package com.lyx.demo.service.impl;

import com.lyx.demo.utils.FileUtils;
import com.lyx.demo.utils.TFUtils;
import com.lyx.demo.service.CheckDuplicateCheckService;

import java.io.IOException;
import java.util.Date;
import java.util.List;
/**
 * Description: 查重服务的实现类
 *
 * @author lyx
 * Date:2023/9/16 20:38
 */
public class CheckDuplicateCheckServiceImpl implements CheckDuplicateCheckService {

    @Override
    public double checkDuplicate(String originFilePath, String targetFilePath, String outputFilePath) throws IOException {
        // 1.读取源文件内容
        String originText = FileUtils.getFileText(originFilePath);
        // 2.读取目标文件内容
        String targetText = FileUtils.getFileText(targetFilePath);

        // 对论文进行中文分词和文本预处理
        List<String> words1 = TFUtils. segmentAndPreprocess(originText);
        List<String> words2 = TFUtils.segmentAndPreprocess(targetText);

        // 计算文本的余弦相似度
        double similarity = TFUtils.calculateCosineSimilarity(words1, words2);


        // 3.将结果输出到文件中
        String resultStr = String.format("[%tc] %s 该文件查重率为%.2f \n",new Date(),targetFilePath,similarity);
        FileUtils.writeToFile(outputFilePath,resultStr);

        return similarity;
    }
}
