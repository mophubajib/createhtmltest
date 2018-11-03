package com.simbirsoft.java;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static java.util.logging.Logger.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class Main {
    public static void main(String[] args) throws IOException {


        final Log log = LogFactory.getLog(Main.class);


       // final Logger logger = getLogger(Main.class.getName());

      //  Logger logger = Logger.getLogger(Main.class.get);

        Properties properties = new Properties();
        JFrame myWindow = new SimpleWindow();
        myWindow.setVisible(true);

        try {
            properties.load(new InputStreamReader(new FileInputStream("propertiesForSimbirsoft.properties"), "windows-1251"));
            myWindow.add(new JButton("HTML страница создана."));

            log.info("HTML страница создана.");

            String avatar = properties.getProperty("AVATAR");
            String mobile = properties.getProperty("MOBILE");
            String fio = properties.getProperty("FIO");
            String dob = properties.getProperty("DOB");
            String skype = properties.getProperty("SKYPE");
            String target = properties.getProperty("TARGET");
            String email = properties.getProperty("EMAIL");
            String education = properties.getProperty("EDUCATION");
            String courses = properties.getProperty("COURSES");
            String skills = properties.getProperty("SKILLS");
            String exemplecode = properties.getProperty("EXEMPLECODE");
            String experience = properties.getProperty("EXPERIENCE");
            String stringHtml = "<meta charset=\"UTF-8\"><body><h1 align=\"center\">Резюме</h1><p align=\"center\">На должность Java-стажер.</p>\n<table align=\"center\">\n    <tr><tr>\n    <th align=\"right\">   ФИО:  </th><th align=\"left\">" + fio + "</th><td rowspan =\"5\" width=\"500\" align=\"right\"><p><img width=\"195\" height=\"260\" src=\"" + avatar + "\"></p></td>\n</tr>\n    <tr>\n        <th align=\"right\">Дата рождения:</th><th align=\"left\">" + dob + "</th>\n    </tr>\n    <tr>\n        <th align=\"right\">Телефон:</th><th align=\"left\">" + mobile + "</th>\n    </tr>\n    <tr>\n        <th align=\"right\"> e-mail:</th><th align=\"left\">" + email + "</th>\n    </tr>\n    <tr>\n        <th align=\"right\">Skype:</th><th align=\"left\">" + skype + "</th>\n    </tr>\n</table>\n<h2>Цель:</h2>\n<p>" + target + "</p>\n<h2>Опыт работы:</h2>\n<p>" + experience + "</p>\n<h2>Образование:</h2>\n<p>" + education + "</p>\n<h2>Доп. образование и курсы:</h2>\n<p>" + courses + "</p>\n<h2>Навыки:</h2>\n<p>" + skills + "</p>\n<h2>Пример кода:</h2>\n<p>" + exemplecode + "</p>\n</body></html>";

            try {
                DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("resumeForSimbirsoft.html"));
                dataOut.writeUTF(stringHtml);
            } catch (IOException var18) {
                log.info("Ошибка при записи");
                System.out.print("Ошибка при записи");
                return;
            }
        } catch (FileNotFoundException var19) {
            log.info("Ошибка - property файл не найден.");
            myWindow.add(new JButton("Ошибка - property файл не найден."));
        }

    }
}