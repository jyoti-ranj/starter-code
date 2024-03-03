package com.forum.units;

public class Reply extends AbstractEntity {
    private String content;
    private User user;
    private int upvotes;

    public Reply(String content, User user) {
        super();
        this.content = content;
        this.user = user;
        this.upvotes = 0;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void upvote() {
        this.upvotes++;
    }

    public String getMessage() {
        return content;
    }

    public void setUser(User user2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    }

    public void setQuestion(Question question) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setQuestion'");
    }

	public void setCreated() {
		
		throw new UnsupportedOperationException("Unimplemented method 'setCreated'");
	}
    

    
}
