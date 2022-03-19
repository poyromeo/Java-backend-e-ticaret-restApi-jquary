package romeo.ama.julieti.olmayan.myapp.Business.concreters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import romeo.ama.julieti.olmayan.myapp.Business.abstracks.UserService;
import romeo.ama.julieti.olmayan.myapp.Core.dataAccess.UserDao;
import romeo.ama.julieti.olmayan.myapp.Core.entties.User;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.DataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.Result;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessDataResult;
import romeo.ama.julieti.olmayan.myapp.Core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
				
	}
	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı bulundu");
	}
	

}
