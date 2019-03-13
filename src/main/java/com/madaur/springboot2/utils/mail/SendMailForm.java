package com.madaur.springboot2.utils.mail;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamSource;

import java.util.Map;
import java.util.Objects;

/*
 * description:
 * @author maduar
 * @date 12/01/2019
 * @email maduar@163.com
 *
 * */
@AllArgsConstructor
@ToString
public class SendMailForm {

    private String[] to;
    private String[] cc;
    private String[] bcc;

    private String from;
    private String subject;
    private String body;
    private InputStreamSource source;
    private String fileName;

    private Map<String, String> mailHeaderMap;

    private SendMailForm() {
    }

    public SendMailForm(String from, String[] to, String subject, String body) {
        Objects.requireNonNull(from);
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public void setSourceAndFileName(InputStreamSource source, String fileName) {
        this.source = source;
        this.fileName = fileName;
    }

    //  set ---
    public Map<String, String> getMailHeaderMap() {
        return mailHeaderMap;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public void setMailHeaderMap(Map<String, String> mailHeaderMap) {
        this.mailHeaderMap = mailHeaderMap;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }
    //  set ---

    public String[] getTo() {
        return to;
    }

    public String[] getCc() {
        return cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public InputStreamSource getSource() {
        return source;
    }

    public String getFileName() {
        return fileName;
    }
}
