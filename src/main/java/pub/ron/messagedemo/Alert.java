package pub.ron.messagedemo;

import java.io.Serializable;

public class Alert implements Serializable {


    private static final long serialVersionUID = 1L;

    private String title;

    public Alert() {}

    public Alert(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
