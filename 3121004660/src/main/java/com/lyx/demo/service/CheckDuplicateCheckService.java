package com.lyx.demo.service;

import java.io.IOException;

/**
 * 查重服务接口
 * @author lql 2023/09/11
 */
public interface CheckDuplicateCheckService {

    double checkDuplicate(String originFilePath,String targetFilePath,String outputFilePath) throws IOException;
}
