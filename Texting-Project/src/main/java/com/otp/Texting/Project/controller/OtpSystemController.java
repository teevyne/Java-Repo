package com.otp.Texting.Project.controller;

import com.otp.Texting.Project.model.OtpSystem;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class OtpSystemController {

    private final static String ACCOUNT_SID = "AC64c0c6fbd636d536cd337ae8b67c25bf";
    private final static String AUTH_ID = "3fe9806166468022164bcdc1e801b2c6";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_ID);
    }

    private Map<String, OtpSystem> otp_data = new HashMap<>();

    @RequestMapping(value = "/mobilenumbers/{mobileNumber}/otp", method= RequestMethod.POST)
    public ResponseEntity<Object> sendOTP(@PathVariable("mobileNumber") String mobileNumber){

        OtpSystem otpSystem = new OtpSystem();
        otpSystem.setMobileNumber(mobileNumber);
        otpSystem.setOtp(String.valueOf(((int) (Math.random()*(10000 - 1000))) + 1000));
        otpSystem.setExpiryTime(System.currentTimeMillis() + 30000);
        otp_data.put(mobileNumber, otpSystem);

//        PhoneNumber to = new PhoneNumber(otpSystem.getMobileNumber());
        PhoneNumber to = new PhoneNumber("+2348094969620");
        PhoneNumber from = new PhoneNumber("+12284006951");
        String message = "Your OTP is " + otpSystem.getOtp();
        MessageCreator creator = com.twilio.rest.api.v2010.account.Message.creator(to, from, message);
        creator.create();
        return new ResponseEntity<>("Your OTP has been sent successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/mobilenumbers/{mobileNumber}/otp", method = RequestMethod.PUT)
    public ResponseEntity<Object> verifyOTP(@PathVariable("mobileNumber") String mobileNumber,
                                           @RequestBody OtpSystem enteredOtpSystem) {

        if (enteredOtpSystem.getOtp() == null || enteredOtpSystem.getOtp().trim().length() <= 0){
            return new ResponseEntity<>("Please provide OTP", HttpStatus.BAD_REQUEST);
        }

        if(otp_data.containsKey(mobileNumber)){
            OtpSystem otpSystem1 = otp_data.get(mobileNumber);
            if (otpSystem1 != null){
                if (otpSystem1.getExpiryTime() >= System.currentTimeMillis()) {
                    if (enteredOtpSystem.getOtp().equals(otpSystem1.getOtp())) {
                        otp_data.remove(mobileNumber);
                        return new ResponseEntity<>("You are verified", HttpStatus.CREATED);
                    }
                    return new ResponseEntity<>("Invalid OTP", HttpStatus.BAD_REQUEST);
                }
                return new ResponseEntity<>("OTP is expired", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Mobile number not found", HttpStatus.NOT_FOUND);
    }
}
