package com.cursoBackend.fiado.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class SmsController {

	@GetMapping(value = "api/sendSMS")
	public ResponseEntity<String> sendSMS() {

		Twilio.init("AC7b61403b600a4f4f264a9f55426c3c67", "c6395d4c15c7e98f8e646fe1a34d431d");

		Message.creator(new PhoneNumber("+5514996344060"),
				new PhoneNumber("+18124455300"), "Hello from Twilio 📞").create();

		return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
	}

}
