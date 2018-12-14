package com.kq.elasticsearch;

import com.kq.elasticsearch.util.PrintUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BulkRequestDemo
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-bulk.html
 * @author kq
 * @date 2018-12-14
 */
public class BulkRequestDemo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    RestHighLevelClient client = Configuration.getRestHighLevelClient();

    public void execute() throws  Exception{

        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("posts", "doc", "10")
                .source(XContentType.JSON,"field", "foo"));
        request.add(new IndexRequest("posts", "doc", "11")
                .source(XContentType.JSON,"field", "bar"));
        request.add(new IndexRequest("posts", "doc", "12")
                .source(XContentType.JSON,"field", "baz"));

        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        PrintUtil.printResponse(bulkResponse);

        client.close();

    }

    public static void main(String args[]) throws Exception{
        new BulkRequestDemo().execute();
    }

}
