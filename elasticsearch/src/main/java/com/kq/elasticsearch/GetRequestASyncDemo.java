package com.kq.elasticsearch;

import com.kq.elasticsearch.util.PrintUtil;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * GetRequestASyncDemo
 *
 * @author kq
 * @date 2018-12-14
 */
public class GetRequestASyncDemo implements ActionListener<GetResponse> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    RestHighLevelClient client = Configuration.getRestHighLevelClient();

    public void execute() throws Exception{


        GetRequest getRequest = new GetRequest("posts","doc", "1");

        client.getAsync(getRequest,RequestOptions.DEFAULT,this);

//        client.getAsync(getRequest,RequestOptions.DEFAULT,this);

    }

    @Override
    public void onResponse(GetResponse response) {
        PrintUtil.printResponse(response);
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
        new GetRequestASyncDemo().execute();
    }

}
