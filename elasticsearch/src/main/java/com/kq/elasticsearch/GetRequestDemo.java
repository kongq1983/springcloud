package com.kq.elasticsearch;

import com.kq.elasticsearch.util.PrintUtil;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * GetRequestDemo
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-get.html
 * @author kq
 * @date 2018-12-14
 */
public class GetRequestDemo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute() throws Exception{

        RestHighLevelClient client = Configuration.getRestHighLevelClient();
        GetRequest getRequest = new GetRequest("posts","doc", "1");

        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        PrintUtil.printResponse(response);

    }




    public static void main(String args[]) throws Exception{
        new GetRequestDemo().execute();
    }

}
