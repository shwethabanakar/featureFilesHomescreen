package com.bsb.hike.qa.apisupport;
import org.junit.Assert;
import com.bsb.hike.base.BaseClass;
import com.bsb.hike.core.MqttCore;


public class Hike2HikeMessageSupport extends BaseClass{
	MqttCore mqttCore = new MqttCore();

	public void sendHikeMessage(String msisdnSender , String msisdnReceiver , String message) {
		try
		{
			mqttCore.connectAndSendHikeMessage(msisdnSender, msisdnReceiver , message);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail("Failed to send message from server");
		}
	}


	public void sendHikeSticker(String msisdnSender , String msisdnReceiver) {
		try
		{
			mqttCore.connectAndSendHikeSticker(msisdnSender, msisdnReceiver,"indian", "040_waah.png");

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}


}