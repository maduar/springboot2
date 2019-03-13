package com.madaur.springboot2.controller;

import com.madaur.springboot2.utils.SendMailUtil;
import com.madaur.springboot2.utils.mail.SendMailForm;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * description:
 * @author maduar
 * @date 11/01/2019
 * @email maduar@163.com
 *
 * */
@CrossOrigin
@RestController
public class MailController2 {

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("sendMail")
    public HttpEntity<?> sendMail() throws MessagingException, IOException {

        String mailer = "maduar@163.com";
        String body = "maduar";
        String subject = "subject";
        String fileName = "tt.xlsx";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(mailer);
        helper.setTo(mailer);

        helper.setSubject(subject);
        helper.setText(body, true);

        XSSFWorkbook wb = createExcel();
        InputStreamSource inputStreamSource = createInputStreamSource(wb);

        helper.addAttachment(fileName, inputStreamSource);

        SendMailUtil.sendMail(mimeMessage);

        return ResponseEntity.ok("ok");
    }

    @GetMapping("sendMail2")
    public HttpEntity<?> sendMail2() throws Exception {

        String mailer = "maduar@163.com";
        String body = "maduar";
        String subject = "subject";
        String fileName = "tt.xlsx";
        String[] to = new String[]{mailer};

        SendMailForm sendMailForm = new SendMailForm(null, to, subject, body);

        XSSFWorkbook wb = createExcel();
        InputStreamSource inputStreamSource = createInputStreamSource(wb);

        Map<String, String> map = new HashMap<String, String>();
        map.put("Disposition-Notification-To", "\"RollingDemand\" " + mailer);
        sendMailForm.setMailHeaderMap(map);

        sendMailForm.setSourceAndFileName(inputStreamSource, fileName);
        SendMailUtil.sendMail(sendMailForm);

        return ResponseEntity.ok("ok");
    }

    private XSSFWorkbook createExcel() {
        String[] headers = {"col1","col2","col3"};
        // 声明一个工作薄
        XSSFWorkbook wb = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = wb.createSheet("first sheet");
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
        }
        int rowIndex = 1;

        for(int j=0; j<3; j++){
            row = sheet.createRow(rowIndex);
            rowIndex++;
            XSSFCell cell1 = row.createCell(0);
            cell1.setCellValue(j);
            cell1 = row.createCell(1);
            cell1.setCellValue(j+1);
            cell1 = row.createCell(2);
            cell1.setCellValue(j+2);
        }
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }

        return wb;
    }

    private InputStreamSource createInputStreamSource(XSSFWorkbook wb) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream(1000);
        wb.write(os);

        InputStreamSource iss = new ByteArrayResource(os.toByteArray());
        os.close();

        return iss;
    }
}
