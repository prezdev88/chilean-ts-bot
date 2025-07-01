package cl.chilean.ts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ChileanBot extends TelegramLongPollingBot {

    public ChileanBot(@Value("${telegram.bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "ChileanTsBot";
    }


    @PostConstruct
    public void init() {
        log.info("ChileanBot iniciado");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            String response = switch (text) {
                case "/ping" -> "🏓 Pong desde Spring Boot!";
                case "/help" -> "📖 Comandos disponibles: /ping, /help";
                default -> "🤖 No entiendo ese comando.";
            };

            SendMessage message = new SendMessage(chatId, response);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
