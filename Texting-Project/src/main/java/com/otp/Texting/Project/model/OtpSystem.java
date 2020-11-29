package com.otp.Texting.Project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpSystem {

    private String mobileNumber;
    private String otp;
    private long expiryTime;
}
