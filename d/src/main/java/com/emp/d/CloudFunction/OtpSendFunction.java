package com.emp.d.CloudFunction;

import java.util.function.Function;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.emp.d.Configuration.Twiliocofig;
import com.emp.d.Service.EmployeeService;
import com.emp.d.Service.OtpService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import reactor.core.publisher.Mono;

public class OtpSendFunction implements Function<java.util.Map<String, String>, Mono<String>> {
    @Autowired
    private Twiliocofig tc;
    @Autowired
    private EmployeeService emp;
    @Autowired
    private OtpService os;

    @Override
    public Mono<String> apply(java.util.Map<String, String> input) {
        String phoneNumber = input.get("phoneNumber"); // Obtained from user input
        String otp = os.generateOTP();

        // Initialize Twilio with injected credentials
        Twilio.init(tc.getAccountSid(), tc.getAuthToken());

        // Send OTP via SMS
        Message message = Message.creator(
                new PhoneNumber(input.get("phoneNumber")), // Recipient's mobile number
                new PhoneNumber(tc.getPhoneNumber()), // Twilio phone number
                "Your OTP is: " + otp)
                .create();
        emp.storeOTPInDatabase(phoneNumber, otp);

        boolean isOTPValid = emp.validateOTP(phoneNumber, otp);
        if (isOTPValid) {
            String newPassword = input.get("newPassword"); // Obtained from user input
            String passwordChangeMessage = emp.changePassword(phoneNumber, newPassword, isOTPValid);
            return Mono.just(passwordChangeMessage);
        } else {
            return Mono.just("OTP sent to " + phoneNumber);
        }
    }

}