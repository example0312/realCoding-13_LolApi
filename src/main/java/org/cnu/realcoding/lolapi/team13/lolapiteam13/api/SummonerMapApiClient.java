package org.cnu.realcoding.lolapi.team13.lolapiteam13.api;

import org.cnu.realcoding.lolapi.team13.lolapiteam13.domain.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SummonerMapApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private String requestUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{SummonerId}?api_key={apiKey}";
    private String apiKey = "RGAPI-bc7e6ade-fc29-4474-8b20-fda39ae29b5a";

    public Summoner getSummoner(String SummonerId){
        return restTemplate.exchange(requestUrl, HttpMethod.GET, null, Summoner.class, SummonerId, apiKey)
                .getBody();
    }

}
