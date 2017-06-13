package tama.ac.jp.controller;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tama.ac.jp.Service.UserService;
import tama.ac.jp.dao.UserDAO;
import tama.ac.jp.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kajiwarayutaka on 2017/05/22.
 */
@RestController
@RequestMapping(value="user")
public class UserController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> showUserList(){
        val result = userDAO.selectUserList();
        return result;
    }

    @RequestMapping(value="{userId}",method = RequestMethod.GET)
    public User showUser(@PathVariable String userId)
    {
        val user = userDAO.selectUser(userId);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void createUser(@RequestBody User user){
        userDAO.insertUser(user);
    }

    @RequestMapping(value="{userId}",method = RequestMethod.POST)
    public void updateUser(@RequestBody User user)
    {
        userDAO.updateUser(user);
    }

    @RequestMapping(value="{userId}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId)
    {
        userDAO.deleteUser(userId);
    }

    @RequestMapping(value="multiUserRegister",method = RequestMethod.PUT)
    public void multiUserRegister(@RequestBody List<User> users){
        userService.multiUserRegister(users);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({DataAccessException.class})
    @ResponseBody
    public Map<String, Object> handleError() {
        Map<String, Object> errorMap = new HashMap<String, Object>();
        errorMap.put("message", "Bad Request");
        errorMap.put("status", HttpStatus.BAD_REQUEST);
        return errorMap;
    }
}
