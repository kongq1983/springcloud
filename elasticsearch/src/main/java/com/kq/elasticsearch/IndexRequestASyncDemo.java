package com.kq.elasticsearch;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * IndexRequestASyncDemo
 *
 * @author kq
 * @date 2018-12-14
 */
public class IndexRequestASyncDemo {

    public static void main(String args[]) {
        IndexRequest request = new IndexRequest(
                "posts",
                "doc",
                "1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
    }

}
