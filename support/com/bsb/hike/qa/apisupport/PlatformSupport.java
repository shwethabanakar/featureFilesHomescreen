/**
 * This class contains support functions to create send bot messages
 */
package com.bsb.hike.qa.apisupport;

import org.apache.commons.lang.RandomStringUtils;
import org.json.simple.JSONObject;

import com.bsb.hike.core.PlatformHttpCore;
import com.bsb.hike.qa.constants.PlatformConstants;
import com.bsb.hike.qa.jsonbuilder.PlatformBotsJson;

/**
 * @author amita
 *
 */
public class PlatformSupport {

    public boolean sendDefaultTestCbot(String msisdn) {
    	
        PlatformBotsJson pbJson = new PlatformBotsJson();
        JSONObject cbotJson = pbJson.getDefaultTestCbotJson();
        boolean botsent = false;
        try {
            botsent = sendBotToMsisdn(cbotJson, msisdn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return botsent;
    }

    public boolean sendDefaultTestDbot(String msisdn) {
        PlatformBotsJson pbJson = new PlatformBotsJson();
        JSONObject dbotJson = pbJson.getDefaultTestDbotJson();
        boolean botsent = false;
        try {
            botsent = sendBotToMsisdn(dbotJson, msisdn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return botsent;
    }

    public boolean sendGamesCbot(String msisdn) {
        PlatformBotsJson pbJson = new PlatformBotsJson();
        JSONObject cbotJson = pbJson.getGamesCbotJson();
        boolean botsent = false;
        try {
            botsent = sendBotToMsisdn(cbotJson, msisdn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return botsent;
    }

    public boolean sendGamesDbot(String msisdn) {
        PlatformBotsJson pbJson = new PlatformBotsJson();
        JSONObject dbotJson = pbJson.getGamesDbotJson();
        boolean botsent = false;
        try {
            botsent = sendBotToMsisdn(dbotJson, msisdn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return botsent;
    }
    
    public boolean sendBotToMsisdn(JSONObject botJson, String msisdn) throws Exception {
        PlatformHttpCore phttpCore = new PlatformHttpCore();
        String pid = "AutomationPlf" + RandomStringUtils.randomNumeric(3);
        boolean botsent = false;
        int count = 0;
        try {
            boolean pidCreated = phttpCore.createPid(botJson, pid, PlatformConstants.pidExpiry);
            while ((!pidCreated) && count++ < PlatformConstants.retryCount) {
                phttpCore.deletePId(pid);
                pidCreated = phttpCore.createPid(botJson, pid, PlatformConstants.pidExpiry);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in pid Creation", e);
        }
        try {
            botsent = phttpCore.sendBotMessageNow(msisdn, pid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in sending bot message", e);
        } finally {
            phttpCore.deletePId(pid);
        }
        return botsent;
    }
    
}