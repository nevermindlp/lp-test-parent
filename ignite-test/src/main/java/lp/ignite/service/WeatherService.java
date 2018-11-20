package lp.ignite.service;

import org.apache.ignite.services.Service;

/**
 * Created by lvpeng01 on 2018/10/11.
 */
public interface WeatherService extends Service {

    String getCurrentTemperature(String countryCode, String cityName) throws Exception;
}
