package com.miaolegemitong.basics.java.bytescope;

import java.io.Reader;

/**
 * @author mitong
 * @since
 */
public class MyBufferedReader {
    private char[] buffer;

    private static final int DEFAULT_BUFFER_SIZE = 8192;

    private int offset;

    private Reader reader;

    public MyBufferedReader(Reader reader) {
        this.reader = reader;
        this.buffer = new char[DEFAULT_BUFFER_SIZE];
    }

    public MyBufferedReader(Reader reader, int size) {
        this.reader = reader;
        this.buffer = new char[size];
    }

    public String readLine() {
        return "";
    }
}
