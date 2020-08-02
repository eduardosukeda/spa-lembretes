package br.com.fiap.rwsfiaplembretes.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class LembreteAMQPConfig {

    public static String EXCHANGE_NAME = "Lembretes";
    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection() {

        if (connectionFactory == null) {
            connectionFactory = new CachingConnectionFactory("finch-01.rmq.cloudamqp.com");
            connectionFactory.setUsername("ozkzkoca");
            connectionFactory.setPassword("3rOq9kTTeHsgnz_VUTug9ttNneQhvPxD");
            connectionFactory.setVirtualHost("ozkzkoca");

            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }

        return connectionFactory;
    }
}