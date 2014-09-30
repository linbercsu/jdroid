package com.jdroid.model;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;

/**
 * Created by lin on 14-9-27.
 */
public interface JNetRequest<T> {

    T exec(HttpClient client, ResponseHandler<T> handler)  throws IOException, ClientProtocolException;
}
