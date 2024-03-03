package discussion.forum.units.service;

import java.util.ArrayList;

import com.forum.units.User;
import com.forum.units.UserRole;
import com.forum.util.Utility;

public class UserServiceImpl implements UserService {
    public static ArrayList<User> users = new ArrayList<>();

    public User createUser(String username, String password) {
        if (Utility.isNotNullAndEmpty(username) && Utility.isNotNullAndEmpty(password)) {
            User user = getUser(username);
            if (user != null) {
                System.out.println("Username already exists");
                return null;
            }

            user = new User(username, password);
            System.out.println("Adding user: " + user.getUsername() + " with password: " + user.getPassword());
            user.autoGenerateId();
            user.setCreated();
            users.add(user);
            System.out.println("User registration successful: " + user.getUsername());
            return user;
        }
        System.out.println("Username and password cannot be empty");
        return null;
    }

    public User getUser(String username, String password) {
		System.out.println("Attempting to login with username: " + username + " and password: " + password);
		for (User user : users) {
			System.out.println("Checking user: " + user.getUsername() + " with password: " + user.getPassword());
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("Login successful for user: " + user.getUsername());
				return user;
			}
		}
		System.out.println("Invalid username or password.");
		return null;
	}
	

    private User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		UserServiceImpl.users = users;
	}

	@Override
	public User createUser(String username, String password, String email, UserRole userRole) {
		
		throw new UnsupportedOperationException("Unimplemented method 'createUser'");
	}
}
