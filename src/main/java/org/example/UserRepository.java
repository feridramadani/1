package org.example;


import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<Integer, User> users = new HashMap<>();

    static {
        // Dummy data for demonstration purposes
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("john_doe");
        user1.setEmail("john@example.com");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("jane_doe");
        user2.setEmail("jane@example.com");

        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
    }

    public User getUserById(int userId) {
        return users.get(userId);
    }
}