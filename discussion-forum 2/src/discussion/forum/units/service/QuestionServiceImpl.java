package discussion.forum.units.service;

import com.forum.units.Question;
import com.forum.units.User;
import com.forum.util.Utility;
import java.util.ArrayList;

public class QuestionServiceImpl implements QuestionService {
    public static ArrayList<Question> questions = new ArrayList<>();

    public Question createQuestion(String title, String message, User user) {
        if (Utility.isNotNullAndEmpty(title) && Utility.isNotNullAndEmpty(message) && user != null) {
            Question question = getQuestionByBody(message);
            if (question != null) {
                System.out.println("Asked question already exists with the same body");
                return question;
            }
            question = new Question(title, message);
            question.autoGenerateId();
            question.setUser(user);
            question.setCreated();
            questions.add(question);
            return question;
        }
        System.out.println("Any specified field can't be empty");
        return null;
    }

    private Question getQuestionByBody(String questionMessage) {
        for (Question question : questions) {
            if (question.getMessage().equals(questionMessage)) {
                return question;
            }
        }
        return null;
    }

    public Question getQuestionById(String id) {
        for (Question question : questions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }
        return null;
    }

    public void deleteQuestion(Question question) {
        questions.remove(question);
    }

	@Override
	public Question getQuestionById(long id) {
		
		throw new UnsupportedOperationException("Unimplemented method 'getQuestionById'");
	}
}
