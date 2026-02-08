package com.discordBot.purschaseCommentor.Controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discordBot.purschaseCommentor.Service.SendMessage.SendMessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bot")
public class SendMessageController {
    private final SendMessageService messageService;

    @PostMapping("/message")
    public ResponseEntity<HttpStatus> sendMessage(@RequestBody String message){
        HttpStatus status = messageService.sendToGeneral(message);
        if (status == HttpStatus.OK) {
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
