package com.mercadolibre.challenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by costa on 22/9/2018.
 */
@Component
public class AppConfig {
    @Value("${weather.beginDate}")
    private int beginDate;
    @Value("${weather.endDate}")
    private int endDate;


    public AppConfig() {
    }

    public int getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(int beginDate) {
        this.beginDate = beginDate;
    }

    public int getEndDate() {
        return endDate;
    }
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}
