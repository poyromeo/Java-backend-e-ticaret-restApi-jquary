package romeo.ama.julieti.olmayan.myapp.Business.abstracks;

import romeo.ama.julieti.olmayan.myapp.Core.entties.User;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	DataResult<User> findByEmail(String email);

}
