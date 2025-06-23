package d1scodancer.usermicroservice.service;

import d1scodancer.usermicroservice.model.User;

import java.util.List;

/**
 * @author Aleksey Shulikov
 */
public interface UserService {

    List<User> getUsers();

    User getUser(Long id);

    User createUser(User userRequest);

    User updateUser(Long id, User userRequest);

    void deleteUser(Long id);
}
