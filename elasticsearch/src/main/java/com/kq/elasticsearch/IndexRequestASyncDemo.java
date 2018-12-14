package com.kq.elasticsearch;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * IndexRequestASyncDemo
 *
 * @author kq
 * @date 2018-12-14
 */
public class IndexRequestASyncDemo implements ActionListener<IndexResponse> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public void execure(){

        RestHighLevelClient client = Configuration.getRestHighLevelClient();

        JSONObject json = new JSONObject();
        json.put("user","king");
        json.put("postDate",new Date());
        json.put("message","hello");


        IndexRequest request = new IndexRequest(
                "posts",
                "doc",
                "2");

        request.source(json.toJSONString(), XContentType.JSON);

        client.indexAsync(request, RequestOptions.DEFAULT, this);
    }

    @Override
    public void onResponse(IndexResponse indexResponse) {
        String index = indexResponse.getIndex();
        String type = indexResponse.getType();
        String id = indexResponse.getId();
        long version = indexResponse.getVersion();

        logger.info("response={}",indexResponse);

        logger.info("index={},type={},id={},version={}",index,type,id,version);


        if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {

        } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {

        }
        ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

        }
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
            }
        }
    }

    @Override
    public void onFailure(Exception e) {
        logger.error("onFailure",e);
    }

    public static void main(String args[]) {
        new IndexRequestASyncDemo().execure();
    }



}
