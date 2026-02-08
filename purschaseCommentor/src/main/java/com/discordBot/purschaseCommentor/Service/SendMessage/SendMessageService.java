package com.discordBot.purschaseCommentor.Service.SendMessage;

import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.discordBot.purschaseCommentor.Config.BotConfig;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

@Service
public class SendMessageService {
    private final BotConfig botConfig;
    public SendMessageService(BotConfig botConfig){
        this.botConfig = botConfig;
    }

    public HttpStatus sendToGeneral(String message){ 
        if (botConfig.getApi() == null){
            System.out.println("Bot is not Online");
            return HttpStatus.TOO_EARLY;
        }

        List<TextChannel> channels = botConfig.getApi().getTextChannelsByName("general",true);
        for(TextChannel ch : channels){
            ch.sendMessage(message).queue();
        }
        return HttpStatus.OK;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init(){
    sendToGeneral("Hello World!!!");
    }
}
