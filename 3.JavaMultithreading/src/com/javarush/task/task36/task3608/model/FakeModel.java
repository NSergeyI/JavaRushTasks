package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by winnie on 27.09.17.
 */
public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userSrvice = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new LinkedList<User>() {
            {
                add(new User("A", 1, 1));
                add(new User("B", 2, 1));
            }};
        modelData.setUsers(users);
    }
    public void loadDeletedUsers() {
        List<User> users = userSrvice.getAllDeletedUsers();
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
