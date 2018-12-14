package com.kq.elasticsearch;

import com.kq.elasticsearch.util.PrintUtil;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * BulkRequestASyncDemo
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-bulk.html
 * @author kq
 * @date 2018-12-14
 */
public class BulkRequestASyncDemo implements ActionListener<BulkResponse> {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    RestHighLevelClient client = Configuration.getRestHighLevelClient();

    public void execute() throws  Exception{

        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest("posts", "doc", "10")
                .source(XContentType.JSON,"field", "foo1"));
        request.add(new IndexRequest("posts", "doc", "13")
                .source(XContentType.JSON,"field", "bar"));
        request.add(new IndexRequest("posts", "doc", "15")
                .source(XContentType.JSON,"field", "baz"));

       client.bulkAsync(request, RequestOptions.DEFAULT, this);



    }


    @Override
    public void onResponse(BulkResponse responses) {

        PrintUtil.printResponse(responses);

        for (BulkItemResponse bulkItemResponse : responses) {
            DocWriteResponse itemResponse = bulkItemResponse.getResponse();

            if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX
                    || bulkItemResponse.getOpType() == DocWriteRequest.OpType.CREATE) {
                IndexResponse indexResponse = (IndexResponse) itemResponse;

                logger.info("id={} create.",indexResponse.getId());


            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.UPDATE) {
                UpdateResponse updateResponse = (UpdateResponse) itemResponse;
                logger.info("id={} update.",updateResponse.getId());

            } else if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.DELETE) {
                DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
                logger.info("id={} delete.",deleteResponse.getId());
            }
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Exception e) {
        logger.error("onFailure",e);
    }

    public static void main(String args[]) throws Exception{
        new BulkRequestASyncDemo().execute();
    }
}
