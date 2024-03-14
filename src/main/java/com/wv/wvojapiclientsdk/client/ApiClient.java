package com.wv.wvojapiclientsdk.client;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.wv.wvojapiclientsdk.model.ExecuteCodeRequest;
import com.wv.wvojapiclientsdk.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用远程代码沙箱的客户端
 * @author wv
 * @version V1.0
 * @date 2024/3/1 21:30
 */
public class ApiClient {

    private String accessKey;
    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String callSandbox(ExecuteCodeRequest executeRequest) {
        // 调用远程代码沙箱的API，传入代码和输入，获取结果
        String url = "http://localhost:8090/executeCode";
        String requestJson = JSONUtil.toJsonStr(executeRequest);

        return HttpUtil.createPost(url)
                .body(requestJson)
                .addHeaders(getHeaderMap(executeRequest))
                .execute()
                .body();
    }

    private Map<String, String> getHeaderMap(ExecuteCodeRequest executeRequest) {
        HashMap<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        // 时间戳
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        // 随机数
        map.put("nonce", RandomUtil.randomNumbers(4));
        // 签名
        map.put("sign", SignUtils.getSign(executeRequest, secretKey));
        return map;
    }

}
