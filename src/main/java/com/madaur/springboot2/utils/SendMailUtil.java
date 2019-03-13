package com.madaur.springboot2.utils;

/*
 * description:
 * @author maduar
 * @date 12/01/2019
 * @email maduar@163.com
 *
 * */

import com.madaur.springboot2.utils.mail.SendMail;
import com.madaur.springboot2.utils.mail.SendMailForm;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

import javax.mail.internet.MimeMessage;

public class SendMailUtil {

    private static JavaMailSender javaMailSender;

    static {
        javaMailSender = (JavaMailSender) SpringTools.getBean("javaMailSender");
    }

    @Async
    public static void sendMail(MimeMessage mimeMessage) {
        javaMailSender.send(mimeMessage);
    }

    @Async
    public static void sendMail(SendMailForm sendMailForm) throws Exception {
        MimeMessage mimeMessage = SendMail.sendMail(javaMailSender, sendMailForm);
        javaMailSender.send(mimeMessage);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

}
