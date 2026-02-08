package com.discordBot.purschaseCommentor.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.discordBot.purschaseCommentor.Service.BotOnline.MyListener;

import lombok.Data;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

@Configuration
@Data
public class BotConfig implements CommandLineRunner {
    private JDA api;

    @Value("${BotToken}")
    String botToken;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting the bot...");
        this.api = JDABuilder.createDefault(botToken)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new MyListener())
                .build()
                .awaitReady();
    }

}
