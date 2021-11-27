package sample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Notebook {
    private String title;
    private String txt;
    private String subject;
    private String date;

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getTxt() {
        return txt;
    }

    public static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

}



