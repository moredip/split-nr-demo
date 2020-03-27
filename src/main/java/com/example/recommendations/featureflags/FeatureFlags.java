package com.example.recommendations.featureflags;

import com.example.recommendations.ClassicRecommendationsEngine;
import com.example.recommendations.NextGenRecommendationsEngine;
import com.example.recommendations.domain.ProductRecommender;
import io.split.client.SplitClient;
import io.split.client.SplitFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@Service
public class FeatureFlags {
    private final Logger logger = LoggerFactory.getLogger(FeatureFlags.class);

    private final SplitClient split;

    public FeatureFlags(@Autowired SplitFactory split) {
        this.split = split.client();
    }

    public ProductRecommender productRecommenderFor(String userKey){
        if(isTreatmentOn(userKey,"next-gen-recommendations")){
            logger.info("using next gen recommendations engine");
            return new NextGenRecommendationsEngine();
        }else{
            logger.info("using classic recommendations engine");
            return new ClassicRecommendationsEngine();
        }
    }

    private boolean isTreatmentOn(String userKey, String split){
        try {
            this.split.blockUntilReady();
        } catch (TimeoutException | InterruptedException e) {
            logger.warn("unable to connect to Split", e);
            return false;
        }

        final var isOn = this.split.getTreatment(userKey, split).equals("on");
        logger.info("treatment {} for user {} is {}", split, userKey, isOn );
        return isOn;
    }
}
