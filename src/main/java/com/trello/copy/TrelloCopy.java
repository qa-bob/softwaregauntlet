package com.trello.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TrelloCopy {
    private final Properties copySource;

    private TrelloCopy() {
        copySource = new Properties();
        Object language = System.getProperties().get("lang");
        String languageCode = "".equals(language) ? "en" : language.toString();
        String copySourcePath = String.format(".\\src\\main\\resources\\%s_copy.properties", languageCode);
        try {
            copySource.load(new FileInputStream(copySourcePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TrelloCopy getInstance() {
        return new TrelloCopy();
    }

    public String getBoards() {
        return getProperty("boards");
    }

    private String getProperty(String name) {
        Object property = copySource.get(name);
        return property == null ? null : property.toString();
    }

    public String getLogIn() {
        return getProperty("log_in");
    }

    public String getTo() {
        return getProperty("to");
    }

    public String getAppName() {
        return getProperty("app_name");
    }

    public String getEmailUsername() {
        return getProperty("email_username");
    }

    public String getPassword() {
        return getProperty("password_text");
    }

    public String getForExample() {
        return getProperty("for_example");
    }

    public String getLogInCapitalized() {
        return getProperty("log_in_cap");
    }

    public String getForgotPassword() {
        return getProperty("forgot_password");
    }

    public String getReset() {
        return getProperty("reset_it");
    }

    public String withSso() {
        return getProperty("with_sso");
    }

    public String getCreate() {
        return getProperty("create");
    }

    public String getAccount() {
        return getProperty("account");
    }

    public String getShowDetails() {
        return getProperty("show_details");
    }

    public String getSave() {
        return getProperty("save");
    }

    public String getInList() {
        return getProperty("in_list");
    }

    public String getAddComment() {
        return getProperty("add_comment");
    }

    public String getMove() {
        return getProperty("move");
    }

    public String getCard() {
        return getProperty("card");
    }

    public String getPosition() {
        return getProperty("position");
    }

    public String getList() {
        return getProperty("list_cap");
    }

    public String getBoard() {
        return getProperty("board");
    }

    public String getPasswordExample() {
        return getProperty("password_example");
    }
}
