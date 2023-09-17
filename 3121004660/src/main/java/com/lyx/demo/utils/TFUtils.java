package com.lyx.demo.utils;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Description: TF工具类：实现简易的TF算法，用于计算余弦相似度
 *
 * @author lyx
 * Date:2023/9/16 20:38
 */
public class TFUtils {
    // 中文分词和文本预处理
    public static List<String> segmentAndPreprocess(String text) {
        List<Term> termList = HanLP.segment(text);
        List<String> words = new ArrayList<>();
        for (Term term : termList) {
            // 去除停用词、标点符号等
            if (!term.word.matches("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]")) {
                words.add(term.word);
            }
        }
        return words;
    }

    // 计算余弦相似度
    public static double calculateCosineSimilarity(List<String> words1, List<String> words2) {
        // 将词列表转换为向量
        RealVector vector1 = createVectorFromWords(words1);
        RealVector vector2 = createVectorFromWords(words2);

        // 计算余弦相似度
        double cosineSimilarity = vector1.dotProduct(vector2) / (vector1.getNorm() * vector2.getNorm());
        return cosineSimilarity;
    }

    // 将词列表转换为向量
    private static RealVector createVectorFromWords(List<String> words) {
        // 在这里可以使用不同的方法来表示文本向量，例如词袋模型（Bag of Words）、TF-IDF等
        // 这里使用简单的词频向量表示
        int vocabSize = 100000; // 词汇表大小
        RealVector vector = new ArrayRealVector(vocabSize);
        for (String word : words) {
            // 在向量中增加词的频次
            // 这里简单地假设每个词的频次为1
            vector.setEntry(Math.abs(word.hashCode() % vocabSize), 1);
        }
        return vector;
    }
}
