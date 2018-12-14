package com.kq.elasticsearch;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * IndexRequestSyncDemo 同步
 * @author kq
 * @date 2018-12-13
 */
public class IndexRequestSyncDemo {

    private static Logger logger = LoggerFactory.getLogger(IndexRequestSyncDemo.class);

    public static void main(String args[]) throws Exception{

        RestHighLevelClient client = Configuration.getRestHighLevelClient();

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");

        IndexRequest indexRequest = new IndexRequest("posts", "doc", "1")
                .source(jsonMap);

        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

        logger.info("response data : {}",indexResponse);

        client.close();
    }

}
