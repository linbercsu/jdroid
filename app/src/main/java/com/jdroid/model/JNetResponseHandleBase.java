package com.jdroid.model;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lin on 14-9-27.
 */
public abstract class JNetResponseHandleBase<T> implements ResponseHandler<T>{

    @Override
    public T handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {

        InputStream is = httpResponse.getEntity().getContent();
        return convert(is);
    }

    abstract protected T convert(InputStream is);
}
