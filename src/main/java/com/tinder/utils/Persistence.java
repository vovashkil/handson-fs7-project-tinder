package com.tinder.utils;

import com.tinder.connection.DbConnection;
import com.tinder.service.LikeService;
import com.tinder.service.MessageService;
import com.tinder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class Persistence {
    private final Connection con = new DbConnection().connection();
    private final UserService userService;
    private final LikeService likeService;
    private final MessageService messageService;

    static Logger log = LoggerFactory.getLogger(Persistence.class);

    public Persistence() {
        this.userService = new UserService(con);
        this.likeService = new LikeService(con);
        this.messageService = new MessageService(con);
    }

    public UserService getUserService() {
        return userService;
    }

    public LikeService getLikeService() {
        return likeService;
    }

    public MessageService getMessageService() {
        return messageService;
    }
}
