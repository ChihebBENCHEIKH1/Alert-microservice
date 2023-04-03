package com.pfa.alertService.controller;

import java.io.IOException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pfa.alertServices.service.AttachementService;

@RestController
public class AttachementController {
	@Autowired
	private AttachementService attachementService;
	@PostMapping("/uploadFile/alert/{id}")/*tested*/
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
			@PathVariable Long id,@RequestParam("description") String description) throws IOException
	{
	   String responseString=	attachementService.uploadFile(file, id,description);
	   return ResponseEntity.status(HttpStatus.OK).body(responseString);
	}

}
