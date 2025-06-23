package d1scodancer.usermicroservice.service;

import d1scodancer.usermicroservice.exceptions.UserNotFoundException;
import d1scodancer.usermicroservice.model.User;
import d1scodancer.usermicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Aleksey Shulikov
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User createUser(User userRequest) {
        return userRepository.save(userRequest);
    }

    @Override
    public User updateUser(Long id, User userRequest) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());

        userRepository.save(user);

        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
