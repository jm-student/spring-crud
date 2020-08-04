package web.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.User;
import web.dao.UserDao;

@Service
@Transactional
public class UserServiceImp implements UserService {
    private UserDao userDao;

    public UserServiceImp() {
    }

    @Autowired
    public UserServiceImp(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public List getAllUsers() {
        List list = new ArrayList();
        this.userDao.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public User getUserById(Long id) {
        User user = this.userDao.findById(id).get();
        return user;
    }

    @Override
    public boolean saveUser(User user) {
        try {
            this.userDao.save(user);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            this.userDao.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
