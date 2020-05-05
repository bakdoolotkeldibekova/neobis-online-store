package kg.neobis.onlinestore.service;

public interface MailService {
    Boolean send(String toEmail, String subject, String text);
}
