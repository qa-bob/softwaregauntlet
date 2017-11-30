package com.trello.data.user;

public class TrelloUserRepository {
    private TrelloUser user = TrelloUser.getInstance();

    public static TrelloUserRepository getInstance() {
        return new TrelloUserRepository();
    }

    public TrelloUser query(TrelloUserDefinition userDefinition) {
        return user.equivalent(userDefinition) ? user : null;
    }
}
