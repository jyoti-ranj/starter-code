package com.forum.units;

import java.util.ArrayList;
import java.util.List;

public class Question extends AbstractEntity {
    private String title;
    private String content;
    private List<Reply> replies;
    private int upvotes;

    public Question(String title, String content) {
        super();
        this.title = title;
        this.content = content;
        this.replies = new ArrayList<>();
        this.upvotes = 0;
    }

    

    public String getContent() {
        return content;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void addReply(Reply reply) {
        this.replies.add(reply);
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void upvote() {
        this.upvotes++;
    }

    public String getMessage() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }

    

    public void setMessage(String message) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setMessage'");
    }

    public void setUser(User user) {
       
        throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    }

    public void setCreated() {
        
        throw new UnsupportedOperationException("Unimplemented method 'setCreated'");
    }

    public void increaseUpvoteCount() {
        
        throw new UnsupportedOperationException("Unimplemented method 'increaseUpvoteCount'");
    }



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}



	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}
}
