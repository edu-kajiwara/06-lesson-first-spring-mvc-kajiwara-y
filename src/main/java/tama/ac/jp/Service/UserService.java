package tama.ac.jp.Service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tama.ac.jp.dao.UserDAO;
import tama.ac.jp.model.User;

import java.util.List;

/**
 * Created by kajiwarayutaka on 2017/05/30.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void multiUserRegister(List<User> users){
        for (int current_size = 0; current_size < users.size();current_size++){
            userDAO.insertUser(users.get(current_size));
        }

        for (User user:users ) {
            userDAO.insertUser(user);
        }
        users.forEach(user -> {
            userDAO.insertUser(user);
        });
    }

    @Transactional
    public void multiUserRegister(){
        val user1 = new User("20611082","小澤遊矢");
        userDAO.insertUser(user1);
        val badRequestUser = new User("20511091","梶原裕");
        userDAO.insertUser(badRequestUser);
    }
}
