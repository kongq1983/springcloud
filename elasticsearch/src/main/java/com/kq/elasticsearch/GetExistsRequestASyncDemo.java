package com.kq.elasticsearch;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * GetExistsRequestASyncDemo
 *  https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-exists.html
 * @author kq
 * @date 2018-12-14
 */
public class GetExistsRequestASyncDemo implements ActionListener<Boolean> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    RestHighLevelClient client = Configuration.getRestHighLevelClient();

    public void execute() throws  Exception{

        GetRequest getRequest = new GetRequest(
                "posts",
                "doc",
                "1");
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

       client.existsAsync(getRequest, RequestOptions.DEFAULT,this);

    }


    @Override
    public void onResponse(Boolean aBoolean) {
        logger.info("result={}",aBoolean);
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

    public static void main(String args[]) throws  Exception{
        new GetExistsRequestASyncDemo().execute();
    }

}
