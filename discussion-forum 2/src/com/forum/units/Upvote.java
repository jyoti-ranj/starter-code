package com.forum.units;

public class Upvote {
    public int getUpvote(AbstractEntity entity) {
        if (entity instanceof Question) {
            return ((Question) entity).getUpvotes();
        } else if (entity instanceof Reply) {
            return ((Reply) entity).getUpvotes();
        } else {
            throw new IllegalArgumentException("Unsupported entity type for upvoting");
        }
    }

    public Reply getReply() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getReply'");
    }

    public User getUser() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    public Question getQuestion() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getQuestion'");
    }

    public void setQuestion(Question question) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setQuestion'");
    }

    public void setReply(Reply reply) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setReply'");
    }

    public void setUser(User user) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    }

    public void autoGenerateId() {
       
        throw new UnsupportedOperationException("Unimplemented method 'autoGenerateId'");
    }

    public void setCreated() {
        
        throw new UnsupportedOperationException("Unimplemented method 'setCreated'");
    }
}
