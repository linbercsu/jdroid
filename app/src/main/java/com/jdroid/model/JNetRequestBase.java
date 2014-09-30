package com.jdroid.model;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

/**
 * Created by lin on 14-9-27.
 */
public abstract class JNetRequestBase<T> implements JNetRequest<T>{

    @Override
    public T exec(HttpClient client, ResponseHandler<T> handler) throws IOException, ClientProtocolException{
        HttpGet get = new HttpGet(getURL());
        return client.execute(get, handler);
    }

    protected abstract String getURL();
}
