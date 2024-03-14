package com.wv.wvojapiclientsdk.utils;


import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import com.wv.wvojapiclientsdk.model.ExecuteCodeRequest;

/**
 * 生成签名工具类
 *
 * @author wv
 * @version V1.0
 * @date 2024/3/1 21:49
 */
public class SignUtils {

    /**
     * 生成签名
     *
     * @param executeCodeRequest
     * @param secretKey
     * @return
     */
    public static String getSign(ExecuteCodeRequest executeCodeRequest, String secretKey) {
        // 使用签名算法
        Digester md5 = new Digester(DigestAlgorithm.MD5);
        // 定义签名内容
        String content = executeCodeRequest.toString() + "." + secretKey;
        return md5.digestHex(content);
    }
}
