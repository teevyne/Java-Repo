package com.texting.textng;

public interface SmsSender {

    void sendSms(SmsRequest smsRequest) throws IllegalAccessException;

}
