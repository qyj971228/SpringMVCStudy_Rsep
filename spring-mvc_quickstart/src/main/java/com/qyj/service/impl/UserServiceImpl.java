package com.qyj.service.impl;

import com.qyj.dao.impl.UserDaoImpl;
import com.qyj.service.UserService;

public class UserServiceImpl implements UserService {

    UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
