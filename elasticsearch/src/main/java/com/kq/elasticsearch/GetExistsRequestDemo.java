package com.kq.elasticsearch;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  GetExistsRequestDemo
 *  https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.5/java-rest-high-document-exists.html
 * @author kq
 * @date 2018-12-14
 */
public class GetExistsRequestDemo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute() throws  Exception{

        RestHighLevelClient client = Configuration.getRestHighLevelClient();

        GetRequest getRequest = new GetRequest(
                "posts",
                "doc",
                "1");
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);

        logger.info("exists={}",exists);

        client.close();

    }

    public static void main(String args[]) throws Exception{
        new GetExistsRequestDemo().execute();
    }

}
