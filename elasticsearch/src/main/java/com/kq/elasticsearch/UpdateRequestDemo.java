package com.kq.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import com.kq.elasticsearch.util.PrintUtil;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * UpdateRequestDemo
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-update.html
 * @author kq
 * @date 2018-12-14
 */
public class UpdateRequestDemo {

    RestHighLevelClient client = Configuration.getRestHighLevelClient();

    public void execute() throws  Exception{
        UpdateRequest request = new UpdateRequest("posts","doc", "1");

        JSONObject json = new JSONObject();
        json.put("message","message1");
        json.put("user","king1");
        request.doc(json.toString(), XContentType.JSON);

        UpdateResponse updateResponse = client.update( request, RequestOptions.DEFAULT);
        PrintUtil.printResponse(updateResponse);

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("updated", new Date());
        jsonMap.put("message", "message2");
        jsonMap.put("user", "king2");
        jsonMap.put("reason", "daily update");
        UpdateRequest request1 = new UpdateRequest("posts", "doc", "2")
                .doc(jsonMap);

        UpdateResponse updateResponse1 = client.update( request1, RequestOptions.DEFAULT);
        PrintUtil.printResponse(updateResponse1);

        client.close();

    }


    public static void main(String args[]) throws  Exception{
        new UpdateRequestDemo().execute();
    }


}
