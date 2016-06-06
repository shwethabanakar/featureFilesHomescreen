package com.bsb.hike.qa.apisupport;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import com.bsb.hike.base.BaseClass;
import com.bsb.hike.core.HttpCore;
import com.bsb.hike.core.MqttCore;
import com.bsb.hike.qa.httpservice.HTTPServices.HttpPostResponse;
import com.bsb.hike.qa.jsonbuilder.GroupChatJson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.DBObject;

public class GroupChatMessageSupport extends BaseClass{
	MqttCore mqttCore = new MqttCore();
	HttpCore httpCore = new HttpCore();
	int Initial_Group_Length,Final_Group_Length;

	public static void main(String a[])
	{
		GroupChatMessageSupport gsu = new GroupChatMessageSupport();
		String msisdnGroupCreator = "+91151"+RandomStringUtils.randomNumeric(7);
		gsu.createHikeUser(msisdnGroupCreator);
		List<String> groupParticipants= new ArrayList<String>();
		groupParticipants.add("+91151"+RandomStringUtils.randomNumeric(7));
		groupParticipants.add("+91151"+RandomStringUtils.randomNumeric(7));
		gsu.createGroupAndSendMessage(msisdnGroupCreator, groupParticipants, "Test Group 1");
	}

	public void setPin(String groupId , String msisdn , String pinText){
		mqttCore.setPinInGroup(groupId, msisdn, pinText);
		}


	public void addMemberToGroup(String groupId, String msisdnAddingMember , String msisdnToAdd) throws InterruptedException{
		List<String> groupParticipants= new ArrayList<String>();
		groupParticipants.add(msisdnToAdd);
	    Initial_Group_Length = findGroupSize(groupId);
		mqttCore.addMembersToGroup(groupId, msisdnAddingMember, groupParticipants);
		Thread.sleep(2000);
	    Final_Group_Length = findGroupSize(groupId);
	    Assert.assertTrue("Error!! Member is not added to the group",Initial_Group_Length+1 == Final_Group_Length);
	}

	public void addMembersListToGroup(String groupId, String msisdnAddingMember , List <String> groupParticipants)
	{
		int gsize;
		try
		{
		gsize = groupParticipants.size();
	    Initial_Group_Length = findGroupSize(groupId);
		mqttCore.addMembersToGroup(groupId, msisdnAddingMember, groupParticipants);
		Thread.sleep(1000);
	    Final_Group_Length = findGroupSize(groupId);
	    Assert.assertTrue("Error!! Members are not added to the group", Final_Group_Length == Initial_Group_Length+gsize);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void removeMemberFromGroup(String gid ,String msisdnCreator , String msisdnToRemove)
	{
		try {
			Initial_Group_Length = findGroupSize(gid);
			mqttCore.removeMemberFromGroup(gid, msisdnCreator, msisdnToRemove);
			Thread.sleep(1000);
			Final_Group_Length = findGroupSize(gid);
			if(Final_Group_Length != 0)
			{
				Assert.assertTrue("Error!! Member is not removed from the group", Final_Group_Length == Initial_Group_Length-1);
			}
			else
				Assert.assertTrue("Error!! Member is not removed from the group", Final_Group_Length < Initial_Group_Length);
		} catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void changeGroupNameByMember(String groupId ,String msisdn , String groupNewName)
	{
		HttpPostResponse response=null;
		JsonObject data;
		try
		{
            String postData = GroupChatJson.editGroupNameJson(groupNewName);
			response = httpCore.editGroupName(msisdn, postData, groupId);
			data = (JsonObject)new JsonParser().parse(response.responseStr);
			Assert.assertTrue("Error!! Response code is not 200", response.responseCode==200);
			Assert.assertTrue("Error!! Response status is not ok", "ok".equalsIgnoreCase(data.get("stat").getAsString()));
			String groupNameUpdated = redis.hget("grpdata-"+groupId, "name");
			Assert.assertTrue("Error!! Group name in redis does not match with updated group name",groupNewName.equals(groupNameUpdated));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String createGroupAndSendMessage(String msisdnGroupCreator , List<String> msisdnReceiverList , String groupName) {
		String groupId = null;
		int counter;
		try
		{
		    DBObject group = null;
		    for (int i = 1; i <= 5; i++)
			{
			    long timestamp = System.currentTimeMillis();
	            groupId = getuidFromMsisdn(msisdnGroupCreator) + ":" + timestamp;
	            mqttCore.connectAndPublishGCJ(groupName, groupId, msisdnGroupCreator, msisdnReceiverList);
	            group = mongo.getGroup(groupId);
	            counter = 0;
	            while(group == null && counter++ < 9)
	            {
	                Thread.sleep(1000);
	                group = mongo.getGroup(groupId);
	            }
	            if (group != null)
	                break;
	            else
	            {
	                System.out.println("Group with gid "+groupId+" not created from server in retry count "+i);
	            }
			}
		    
			Assert.assertTrue("Group is not created at Server: "+groupId, group != null);
			mqttCore.connectAndPublishGCMessage(groupId, msisdnGroupCreator);
			Thread.sleep(10000);
			return groupId;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return groupId;
	}


	public void groupCreatorLeavingGroup(String groupId , String msisdnCreator){
		try {
			Initial_Group_Length = findGroupSize(groupId);
			mqttCore.connectAndPublishGCL(groupId, msisdnCreator);
			Final_Group_Length = findGroupSize(groupId);
			Assert.assertTrue("Error!! Member is not removed from the group", Final_Group_Length == Initial_Group_Length-1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void changeGroupProfile(String groupId , String msisdnChangingAvatar) throws Exception{
		try {
			HttpPostResponse response = httpCore.updateGroupAvatar(msisdnChangingAvatar, groupId);
			Assert.assertTrue("Error!! Response code is not 200", response.responseCode==200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int findGroupSize(String groupId)
	{
		DBObject db;
		JsonObject jsonObject = null;
		db = mongo.getGroup(groupId);
		if(db != null)
		{
		jsonObject = (JsonObject)new JsonParser().parse(db.toString());
		return jsonObject.getAsJsonArray("users").size();
		}
		return 0;
	}

	public void createHikeUser(String msisdn)
	{
		httpCore.createUser(msisdn);
	}


	public void sendHikeSticker(String msisdnSender , String groupId ) {
	      try
	      {
	    	  mqttCore.connectAndSendHikeSticker(msisdnSender, groupId, "indian", "040_waah.png");

	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();

	      }
	}


	public void sendHikeMessage(String msisdnSender , String groupId , String message) {
	      try
	      {
	    	  mqttCore.connectAndSendHikeMessage(msisdnSender, groupId , message);

	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();

	      }
	}

	public void sendHikeNudge(String msisdnSender , String groupId ) {
	      try
	      {
	    	  mqttCore.connectAndSendHikeNudge(msisdnSender, groupId);

	      }
	      catch (Exception e)
	      {
	    	  e.printStackTrace();

	      }
	}

	public List<String> getGidFromGroupOwner(String ownerMsisdn) throws Exception
	{
		List<String> gidList = new ArrayList<String>();
		try
		{
			gidList = mongo.getGroupsOfUser(ownerMsisdn);
		}
		catch (NullPointerException npe)
		{
			throw new Exception("No groups exist for user with msisdn= "+ownerMsisdn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception();
		}
		return gidList;
	}
}



