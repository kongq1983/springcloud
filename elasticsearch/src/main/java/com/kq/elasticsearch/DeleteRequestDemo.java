package com.kq.elasticsearch;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;

/**
 * DeleteRequestDemo
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-delete.html
 * @author kq
 * @date 2018-12-14
 */
public class DeleteRequestDemo {

    RestHighLevelClient client = Configuration.getRestHighLevelClient();

    public void execute() throws  Exception{
        DeleteRequest request = new DeleteRequest( "posts", "doc", "1");
        request.timeout(TimeValue.timeValueMinutes(2));
//        request.timeout("2m");

        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
//        request.setRefreshPolicy("wait_for");

        DeleteResponse deleteResponse = client.delete(
                request, RequestOptions.DEFAULT);

        client.close();

    }


    public static void main(String args[]) throws Exception{
        new DeleteRequestDemo().execute();
    }


}
