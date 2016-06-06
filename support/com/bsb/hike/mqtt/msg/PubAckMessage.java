package com.bsb.hike.mqtt.msg;

import java.io.IOException;

public class PubAckMessage extends RetryableMessage
{

    public PubAckMessage(short messageId)
    {
        super(Type.PUBACK);
        setMessageId(messageId);
    }

    public PubAckMessage(Header header)
            throws IOException
    {
        super(header);
    }

    @Override
    public String toString()
    {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("PubAckMessage [");
        strBuff.append("messageId: " + getMessageId() + "]");
        return strBuff.toString();
    }
}
