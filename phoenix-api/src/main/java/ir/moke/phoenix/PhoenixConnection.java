package ir.moke.phoenix;

import ir.moke.phoenix.da.Operator;
import ir.moke.phoenix.factory.PhoenixConnectionFactory;
import ir.moke.phoenix.factory.PhoenixFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;

@Singleton
@Startup
public class PhoenixConnection {

    @Resource
    private PhoenixDataSourceConfiguration configuration;

    private PhoenixFactory factory;

    @PostConstruct
    private void init() {
        String dataStore = configuration.getDataStore();
        String hostname = configuration.getHostname();
        String port = configuration.getPort();
        factory = PhoenixConnectionFactory.getConnection(dataStore, hostname + ":" + port);
    }

    @PreDestroy
    private void shutdown() {
        factory.close();
    }

    @Produces
    public Operator getOperator() {
        return factory.getOperator() ;
    }
}