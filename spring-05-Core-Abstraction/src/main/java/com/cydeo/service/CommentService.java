package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;

public class CommentService {

    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment){
        // Save in the DB
        commentRepository.storeComment(comment);
        // Send email
        commentNotificationProxy.sendComment(comment);

    }

}
