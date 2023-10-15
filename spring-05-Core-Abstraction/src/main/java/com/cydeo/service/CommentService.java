package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.Email;
import com.cydeo.repository.DBCommentRepository;

public class CommentService {

    private DBCommentRepository dbCommentRepository;
    private Email email;

    public void publishComment(Comment comment){
        // Save in the DB
        dbCommentRepository.storeComment(comment);
        // Send email
        email.sendComment(comment);

    }

}
