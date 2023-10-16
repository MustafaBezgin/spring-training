package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    /* If we use "final" keyword in these fields, compiler warn us "Variable .... might not have been initialized.
   Because of that, as a developer, we should use final keyword.
     */
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final AppConfigData appConfigData;

    // By creating constructor, we automatically add @Autowired annotation as well

    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
    }

    public void publishComment(Comment comment){
        // Save in the DB
        commentRepository.storeComment(comment);
        // Send email
        commentNotificationProxy.sendComment(comment);

    }

    public void printConfigData(){
        System.out.println(appConfigData.getUserName());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());
    }

}
