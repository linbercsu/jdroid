package com.jdroid.model;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;

/**
 * Created by lin on 14-9-27.
 */
public abstract class JDataAsynLoader<T> extends AsyncTaskLoader<T>{
    public JDataAsynLoader(Context context){
        super(context);
    }

    @Override
    public T loadInBackground() {



        JDataLoader<T> loader = getLoader();
        try {
            return loader.load();
        }catch (IOException exception){

        }
        return null;
    }

    protected abstract JDataLoader<T> getLoader();
}

