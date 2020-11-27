package com.texting.textng;

import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;

    public Service(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.smsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest) throws IllegalAccessException {
        smsSender.sendSms(smsRequest);
    }
}
