package tech.szymanskazdrzalik.module.dao;


import org.apache.commons.lang3.tuple.Triple;

import java.io.IOException;

public interface Dao<T, Y, Z> extends AutoCloseable {
    Triple<T, Y, Z> read() throws IOException, ClassNotFoundException;
    void write(T t, Y y, Z z) throws IOException;
    /**
     * {@inheritDoc}
     */
    @Override
    void close();
}