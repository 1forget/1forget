package com.lyx.demo.service;

import java.io.IOException;
/**
 * Description: 查重服务接口
 *
 * @author lyx
 * Date:2023/9/16 20:38
 */
public interface CheckDuplicateCheckService {

    double checkDuplicate(String originFilePath,String targetFilePath,String outputFilePath) throws IOException;
}
