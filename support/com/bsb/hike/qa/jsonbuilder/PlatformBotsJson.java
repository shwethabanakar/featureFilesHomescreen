/**
 * This file contains functions to build jsons related to bot messages for platform
 */
package com.bsb.hike.qa.jsonbuilder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bsb.hike.base.PlatformBotsConfig;
import com.bsb.hike.qa.constants.PlatformConstants;


/**
 * @author amita
 *
 */
public class PlatformBotsJson {

    public JSONObject getDefaultTestCbotJson() {
        String botJsonStr = PlatformBotsConfig.getInstance().getTestBotJson();
        JSONObject botJson = null;
        try {
            botJson = (JSONObject) new JSONParser().parse(botJsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return botJson;
    }

    public JSONObject getDefaultTestDbotJson() {
        JSONObject botJson = replaceMsisdnInDbot(PlatformBotsConfig.getInstance().getTestBotMsisdn());
        return botJson;
    }

    public JSONObject getGamesCbotJson() {
        String botJsonStr = PlatformBotsConfig.getInstance().getGamesBotJson();
        System.out.println(botJsonStr);
        JSONObject botJson = parseStringIntoJson(botJsonStr);
        return botJson;
    }
    
    public JSONObject getGamesDbotJson() {
        JSONObject botJson = replaceMsisdnInDbot(PlatformBotsConfig.getInstance().getGamesBotMsisdn());
        return botJson;
    }
    
    public JSONObject replaceMsisdnInDbot(String msisdn) {
        String botJsonStr = PlatformBotsConfig.getInstance().getDbotJson();
        botJsonStr = botJsonStr.replace(PlatformConstants.defaultBotMsisdn, msisdn);
        JSONObject botJson = null;
        try {
            botJson = (JSONObject) new JSONParser().parse(botJsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return botJson;
    }
    
    public JSONObject parseStringIntoJson(String botJsonStr)
    {
        JSONObject botJson = null;
        try {
            botJson = (JSONObject) new JSONParser().parse(botJsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return botJson;
    }
}