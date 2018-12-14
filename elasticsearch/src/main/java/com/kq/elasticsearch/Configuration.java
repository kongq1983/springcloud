package com.kq.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * Configuration
 *
 * @author kq
 * @date 2018-12-14
 */
public class Configuration {

    private static final RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("192.168.1.148", 9200, "http")));
//                        new HttpHost("localhost", 9201, "http")));


    /**
     * 获取RestHighLevelClient
     * @return
     */
    public static RestHighLevelClient getRestHighLevelClient(){
        return client;
    }

}
