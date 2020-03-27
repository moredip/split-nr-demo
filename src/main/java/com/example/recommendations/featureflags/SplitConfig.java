package com.example.recommendations.featureflags;

import io.split.client.SplitClientConfig;
import io.split.client.SplitFactory;
import io.split.client.SplitFactoryBuilder;
import io.split.integrations.IntegrationsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;


@Configuration
public class SplitConfig {
    private final Logger logger = LoggerFactory.getLogger(SplitConfig.class);

    @Value("${SPLIT_API_KEY:localhost}")
    private String splitApiKey;

    @Scope(SCOPE_SINGLETON)
    @Bean()
    public SplitFactory splitFactory() throws Exception {
        logger.info("launching split using key {}", splitApiKey);
        SplitClientConfig config = SplitClientConfig.builder()
                .splitFile("./split.yaml")
                .setBlockUntilReadyTimeout(10000)
                .integrations(
                        IntegrationsConfig.builder()
                                .newRelicImpressionListener()
                                .build())
                .build();
        return SplitFactoryBuilder.build(splitApiKey, config);
    }
}
