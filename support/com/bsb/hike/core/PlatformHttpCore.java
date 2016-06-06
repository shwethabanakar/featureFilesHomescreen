/**
 * This class contains core http functions related to Platform
 */
package com.bsb.hike.core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bsb.hike.base.HikeAutomationConfig;
import com.bsb.hike.qa.constants.PlatformConstants;
import com.bsb.hike.qa.httpservice.HTTPServices;
import com.bsb.hike.qa.httpservice.HTTPServices.HttpPostResponse;

/**
 * @author amita
 *
 */
public class PlatformHttpCore {

    private String platformHttpHost =  HikeAutomationConfig.getInstance().getPlatformBotsHost();
    private int platformHttpPort = HikeAutomationConfig.getInstance().getPlatformBotsPort();

    /*
     *  Create Protip Ids
     */
    @SuppressWarnings("unchecked")
    public boolean createPid(JSONObject msg , String protipId , int expiry) throws Exception
    {
        String createPidUrl = "http://" + platformHttpHost + ":" + platformHttpPort + PlatformConstants.createPidUrl;
        boolean newPidCreated = false;
        JSONObject data = new JSONObject();
        JSONArray msgs = new JSONArray();
        JSONObject innerJson = new JSONObject();
        innerJson.put("pid", protipId);
        innerJson.put("msg", msg);
        innerJson.put("expiry", expiry);
        msgs.add(innerJson);
        data.put("msgs", msgs);
        try {
            HttpPostResponse response = HTTPServices.postDataToUrl(createPidUrl, "application/Json", null, data.toString());
            JSONArray responseArray = (JSONArray) new JSONParser().parse(response.responseStr);
            JSONObject resp = (JSONObject) responseArray.get(0);
            if ((Boolean) resp.get(protipId)) {
                System.out.println("New protip id created :" + protipId);
                newPidCreated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in creating pid " + e);
        }
        return newPidCreated;
    }

    /*
     * Send the bot messages from server
     */
    @SuppressWarnings("unchecked")
    public boolean sendBotMessageNow(String msisdn , String pid) throws Exception {
        String sendNowUrl = "http://" + platformHttpHost + ":" + platformHttpPort + PlatformConstants.sendNowUrl;
        boolean messageSent = false;
        JSONArray pids = new JSONArray();
        JSONArray users = new JSONArray();
        pids.add(pid);
        users.add(msisdn);
        JSONObject sendJson = new JSONObject();
        sendJson.put("pids", pids);
        sendJson.put("users", users);
        sendJson.put("isUidsList", false);
        sendJson.put("fromMsisdn", "+hike+");
        try {
            HttpPostResponse response = HTTPServices.postDataToUrl(sendNowUrl, "application/Json", null, sendJson.toString());
            if (response.responseCode == 200) {
                messageSent = true;
                System.out.println("Sent Bot to msisdn :" + msisdn);
            }
        } catch (Exception e) {
            throw new Exception("Exception caught while sending the bot from server :" + e);
        }
        return messageSent;
    }

    public void deletePId(String pid) throws Exception {
        String deletePIdUrl = "http://" + platformHttpHost + ":" + platformHttpPort + PlatformConstants.updateUrl + pid;
        try {
            HTTPServices.getData(deletePIdUrl, null, null, null, "DELETE");
            System.out.println("Deleted pid:" + pid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Exception caught while deleting pid from server :" + e);
        }
    }

    @SuppressWarnings("unchecked")
    public void sendbotMessageWithoutPid(String msisdn , JSONObject msg) throws Exception {
        String sendNowUrl = "http://" + platformHttpHost + ":" + platformHttpPort + PlatformConstants.sendNowUrl;
        JSONArray messages = new JSONArray();
        JSONArray users = new JSONArray();
        messages.add(msg.toJSONString());
        users.add(msisdn);
        JSONObject sendJson = new JSONObject();
        sendJson.put("messages", messages);
        sendJson.put("users", users);
        sendJson.put("isUidsList", false);
        sendJson.put("fromMsisdn", "+hike+");
        String send = sendJson.toJSONString();
        try {
            HTTPServices.postDataToUrl(sendNowUrl, "application/Json", null, send);
        } catch (Exception e) {
            throw new Exception("Exception caught while sending the bot from server :" + e);
        }
    }
  
}