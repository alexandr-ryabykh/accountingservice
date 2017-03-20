package org.mainacad.timemanager.service;


import org.mainacad.timemanager.dao.MyUserDao;
import org.mainacad.timemanager.model.MyUser;

import java.util.List;

public class MyUserServiceImpl implements MyUserService{
    private MyUserDao myUserDao;

    public void setStudentDAO(MyUserDao myUserDao) {
        this.myUserDao = myUserDao;
    }

    @Override
    public List<MyUser> listMyUsers() {
        return myUserDao.listMyUsers();
    }

}
