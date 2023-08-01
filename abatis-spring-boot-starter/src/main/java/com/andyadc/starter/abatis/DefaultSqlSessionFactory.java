package com.andyadc.starter.abatis;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession open() {
        return new DefaultSqlSession(configuration.connection, configuration.mapperElement);
    }
}
