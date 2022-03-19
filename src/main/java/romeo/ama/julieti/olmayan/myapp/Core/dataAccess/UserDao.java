package romeo.ama.julieti.olmayan.myapp.Core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import romeo.ama.julieti.olmayan.myapp.Core.entties.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
