package com.madaur.springboot2.utils.mail;

import com.madaur.springboot2.utils.SendMailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/*
 * description:
 * @author maduar
 * @date 12/01/2019
 * @email maduar@163.com
 *
 * */
@Slf4j
public class SendMail  {

    @Value("${spring.mail.username}")
    private static String mailUsername;

    public static MimeMessage sendMail(JavaMailSender javaMailSender, SendMailForm sendMailForm) throws Exception {
        MimeMessage mimeMessage = createMimeMessage(javaMailSender, sendMailForm);
        return mimeMessage;
    }

    private static MimeMessage createMimeMessage(JavaMailSender javaMailSender, SendMailForm sendMailForm) throws Exception {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            // check header
            mimeMessage = checkMailMap(mimeMessage, sendMailForm.getMailHeaderMap());

            MimeMessageHelper helper;
            helper = new MimeMessageHelper(mimeMessage, true);
            // check from
            String mailSender = checkMailSender(sendMailForm.getFrom());

            helper.setFrom(mailSender);
            helper.setTo(sendMailForm.getTo());
            helper.setSubject(sendMailForm.getSubject());
            helper.setText(sendMailForm.getBody(), true);

            // cc
            String cc[] = sendMailForm.getCc();
            if (cc != null) {
                helper.setCc(cc);
            }

            // source filename
            String fileName = sendMailForm.getFileName();
            InputStreamSource source = sendMailForm.getSource();
            if (!SendMailUtil.isBlank(fileName) && source != null) {
                helper.addAttachment(fileName, source);
            }

            return mimeMessage;
        } catch (Exception e) {
            log.error(e.getMessage().toString());
            throw new Exception("sendMail失敗");
        }
    }

    public static String checkMailSender(String from) {
        if (SendMailUtil.isBlank(from)) {
            from = mailUsername;
        }

        return from;
    }

    public static MimeMessage checkMailMap(MimeMessage mimeMessage, Map<String, String> mailHeaderMap) throws MessagingException {

        if (mailHeaderMap == null || mailHeaderMap.size() == 0) {
            return mimeMessage;
        }

        for (Map.Entry<String, String> entry: mailHeaderMap.entrySet()) {
            mimeMessage.addHeader(entry.getKey(), entry.getValue());
        }

        return mimeMessage;
    }
}
