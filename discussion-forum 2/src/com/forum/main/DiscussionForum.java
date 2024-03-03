package com.forum.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.forum.units.Question;
import com.forum.units.Reply;
import com.forum.units.User;

public class DiscussionForum {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Question> questions = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static User currentUser = null;

    public static void main(String[] args) throws IOException {
        while (true) {
            printMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    currentUser = login();
                    break;
                case 3:
                    if (currentUser == null) {
                        System.out.println("Please login first!");
                    } else {
                        postQuestion();
                    }
                    break;
                case 4:
                    if (currentUser == null) {
                        System.out.println("Please login first!");
                    } else {
                        replyToQuestion();
                    }
                    break;
                case 5:
                    if (currentUser == null) {
                        System.out.println("Please login first!");
                    } else {
						deleteQuestion();
                    }
                    break;
                case 6:
                    if (currentUser == null) {
                        System.out.println("Please login first!");
                    } else {
                        viewAllReplies();
                    }
                    break;
                case 7:
                    exit();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    

	private static void printMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Post a Question");
        System.out.println("4. Reply to a Question");
        System.out.println("5. Delete a Question");
        System.out.println("6. View All Replies");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() throws IOException {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void register() throws IOException {
        System.out.println("\n=== Register ===");
        System.out.print("Enter username: ");
        String username = reader.readLine();
        System.out.print("Enter password: ");
        String password = reader.readLine();

        // Check if the username is already taken
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists. Please choose a different one.");
                return;
            }
        }

        // Create a new user and add it to the list
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Registration successful.");
    }

    private static User login() throws IOException {
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String username = reader.readLine();
        System.out.print("Enter password: ");
        String password = reader.readLine();

        // Check if the entered username and password match a registered user
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return user;
            }
        }

        System.out.println("Invalid username or password.");
        return null;
    }

    private static void postQuestion() throws IOException {
        System.out.println("\n=== Post a Question ===");
        System.out.print("Enter question title: ");
        String title = reader.readLine();
        System.out.print("Enter question content: ");
        String content = reader.readLine();

        Question question = new Question(title, content);
        questions.add(question);
        System.out.println("Question posted successfully.");
    }

    private static void replyToQuestion() throws IOException {
        System.out.println("\n=== Reply to a Question ===");
        // Provide options for selecting a question to reply to
        // For simplicity, you can list all questions here and prompt the user to select one
        System.out.println("Select a question to reply to:");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i).getTitle());
        }

        System.out.print("Enter the number of the question: ");
        int questionNumber = Integer.parseInt(reader.readLine()) - 1;
        if (questionNumber >= 0 && questionNumber < questions.size()) {
            Question question = questions.get(questionNumber);
            System.out.print("Enter your reply: ");
            String replyContent = reader.readLine();
            Reply reply = new Reply(replyContent, currentUser);
            question.addReply(reply);
            System.out.println("Reply posted successfully.");
        } else {
            System.out.println("Invalid question number.");
        }
    }

	private static void viewAllReplies() throws IOException {
		System.out.println("\n=== View All Replies ===");
		if (questions.isEmpty()) {
			System.out.println("No questions available.");
			return;
		}
	
		// Display all questions for selection
		System.out.println("Select a question to view replies:");
		for (int i = 0; i < questions.size(); i++) {
			System.out.println((i + 1) + ". " + questions.get(i).getTitle());
		}
	
		System.out.print("Enter the number of the question: ");
		int questionNumber = Integer.parseInt(reader.readLine()) - 1;
		if (questionNumber >= 0 && questionNumber < questions.size()) {
			Question question = questions.get(questionNumber);
			List<Reply> replies = question.getReplies();
			if (replies.isEmpty()) {
				System.out.println("No replies found for this question.");
			} else {
				System.out.println("Replies for question: " + question.getTitle());
				for (Reply reply : replies) {
					System.out.println("Reply ID: " + reply.getId());
					System.out.println("Reply Message: " + reply.getMessage());
					System.out.println("Posted by: " + reply.getUser().getUsername());
					System.out.println("-----------------------");
				}
			}
		} else {
			System.out.println("Invalid question number.");
		}
	}
	public static void deleteQuestion() throws IOException {
		System.out.println("\n=== Delete a Question ===");
		if (questions.isEmpty()) {
			System.out.println("No questions available for deletion.");
			return;
		}
	
		// Display all questions for selection
		System.out.println("Select a question to delete:");
		for (int i = 0; i < questions.size(); i++) {
			System.out.println((i + 1) + ". " + questions.get(i).getTitle());
		}
	
		System.out.print("Enter the number of the question to delete: ");
		int questionNumber = Integer.parseInt(reader.readLine()) - 1;
		if (questionNumber >= 0 && questionNumber < questions.size()) {
			questions.remove(questionNumber);
			System.out.println("Question deleted successfully.");
		} else {
			System.out.println("Invalid question number.");
		}
	}
	

    private static void exit() {
        System.out.println("Exiting the program. Goodbye!");
    }
}
