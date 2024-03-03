package discussion.forum.units.service;

import com.forum.units.Reply;
import com.forum.units.Question;
import com.forum.units.User;
import com.forum.util.Utility;
import java.util.ArrayList;

public class ReplyServiceImpl implements ReplyService {
    public static ArrayList<Reply> replies = new ArrayList<>();

    public Reply createReply(String message, User user, Question question) {
        if (Utility.isNotNullAndEmpty(message) && user != null && question != null) {
            Reply reply = new Reply(message, user);
            reply.autoGenerateId();
            reply.setUser(user);
            reply.setQuestion(question);
            reply.setCreated();
            replies.add(reply);
            return reply;
        }
        System.out.println("Any specified field can't be empty");
        return null;
    }

    public Reply getReplyById(String id) {
        for (Reply reply : replies) {
            if (reply.getId().equals(id)) {
                return reply;
            }
        }
        return null;
    }

    public void deleteReply(Reply reply) {
        replies.remove(reply);
    }

	@Override
	public Reply addReply(String message, Question question, User user) {
		
		throw new UnsupportedOperationException("Unimplemented method 'addReply'");
	}

	@Override
	public Reply getReply(long id) {
		
		throw new UnsupportedOperationException("Unimplemented method 'getReply'");
	}

	@Override
	public ArrayList<Reply> getReplies(Question question) {
		
		throw new UnsupportedOperationException("Unimplemented method 'getReplies'");
	}
}
