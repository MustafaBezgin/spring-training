package com.cydeo.service;

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

    // By creating constructor, we automatically add @Autowired annotation as well


    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        // Save in the DB
        commentRepository.storeComment(comment);
        // Send email
        commentNotificationProxy.sendComment(comment);

    }

}
