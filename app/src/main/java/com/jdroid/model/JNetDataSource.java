package com.jdroid.model;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;

/**
 * Created by lin on 14-9-27.
 */
public class JNetDataSource<T> implements JDataSource<T>{

    JNetRequest<T> request;
    HttpClient client;
    ResponseHandler<T> handler;

    public JNetDataSource(JNetRequest<T> request, HttpClient client, ResponseHandler<T> handler){
        this.request = request;
        this.client = client;
        this.handler = handler;
    }

    @Override
    public T get() throws IOException{
        return request.exec(client, handler);
    }

    @Override
    public boolean isValid() {
        return true;
    }


}
