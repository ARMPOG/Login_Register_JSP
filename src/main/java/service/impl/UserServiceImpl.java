package service.impl;

import dao.UserDao;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {


    private static volatile UserService instance = new UserServiceImpl();
    UserDao userDao;

    private UserServiceImpl() {
        userDao = UserDao.getInstance();

    }

    public static synchronized UserService getInstance() {
        return instance;
    }

    @Override
    public User login(String email, String password) {
        return userDao.getByEmailAndPassword(email, password);
    }

    @Override
    public User register(User user) {
        return userDao.save(user);
    }
}
