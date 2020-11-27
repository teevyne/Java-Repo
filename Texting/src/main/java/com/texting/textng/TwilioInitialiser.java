package com.texting.textng;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioInitialiser {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitialiser.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitialiser(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
            twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialised ... with account sid {} ", twilioConfiguration.getAccountSid());
    }
}
