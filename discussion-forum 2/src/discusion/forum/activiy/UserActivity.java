package discusion.forum.activiy;

import java.util.ArrayList;
import java.util.List;

import com.forum.units.Question;

public class UserActivity {
    private List<Question> questions;

    public UserActivity() {
        this.questions = new ArrayList<>();
    }

    public void postNewQuestion(String title, String content) {
        Question question = new Question(title, content);
        questions.add(question);
    }

    public List<Question> seeAllQuestions() {
        return questions;
    }

    public void deleteQuestion(Question question) {
        questions.remove(question);
    }
}
