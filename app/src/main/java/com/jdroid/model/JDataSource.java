package com.jdroid.model;

import java.io.IOException;

/**
 * Created by lin on 14-9-27.
 */
public interface JDataSource<T> {

    T get() throws IOException;
    boolean isValid();
}
