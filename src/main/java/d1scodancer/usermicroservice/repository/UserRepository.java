package d1scodancer.usermicroservice.repository;

import d1scodancer.usermicroservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aleksey Shulikov
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
