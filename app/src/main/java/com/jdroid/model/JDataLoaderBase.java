package com.jdroid.model;

import java.io.IOException;

/**
 * Created by lin on 14-9-27.
 */
public abstract class JDataLoaderBase<T> implements JDataLoader<T>{

    @Override
    public T load() throws IOException{

        JDataSource<T> local = getLocal();
        if (local != null && local.isValid()){
            T t = local.get();
            if (t != null)
                return t;
        }

        JDataSource<T> net = getNet();
        if (net != null && net.isValid()){
            T t = net.get();
            return t;
        }

        return null;
    }

    protected abstract JDataSource<T> getNet();
    protected abstract JDataSource<T> getLocal();

}
