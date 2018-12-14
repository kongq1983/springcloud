package com.kq.elasticsearch;

import com.kq.elasticsearch.util.PrintUtil;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * DeleteRequestDemo
 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-delete.html
 * @author kq
 * @date 2018-12-14
 */
public class DeleteRequestASyncDemo implements ActionListener<DeleteResponse> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    RestHighLevelClient client = Configuration.getRestHighLevelClient();

    public void execute() throws  Exception{
        DeleteRequest request = new DeleteRequest( "posts", "doc", "1");
        request.timeout(TimeValue.timeValueMinutes(2));
//        request.timeout("2m");

        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
//        request.setRefreshPolicy("wait_for");

        client.deleteAsync( request, RequestOptions.DEFAULT,this);

    }


    public static void main(String args[]) throws Exception{
        new DeleteRequestASyncDemo().execute();
    }


    @Override
    public void onResponse(DeleteResponse deleteResponse) {

        PrintUtil.printResponse(deleteResponse);

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
}
