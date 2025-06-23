package d1scodancer.usermicroservice.exceptions;

/**
 * @author Aleksey Shulikov
 */
public class UserNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Пользователь не найден";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
