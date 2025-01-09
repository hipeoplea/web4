package org.example.web4.services;

import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OpenSearchConfig {

    private RestClient restClient;

    @Autowired
    public void ElasticsearchService(RestClient restClient) {
        this.restClient = restClient;
    }

    public OpenSearchConfig(RestClient restClient) {
        this.restClient = restClient;
    }

    public void search() throws IOException {
        Request request = new Request("GET", "/_search");
        Response response = restClient.performRequest(request);
        System.out.println(response.getEntity());
    }
}
