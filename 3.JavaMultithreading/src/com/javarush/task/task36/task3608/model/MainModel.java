package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

/**
 * Created by winnie on 18.10.17.
 */
public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(getAllUsers());
//        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        modelData.setDisplayDeletedUserList(false);


    }

    public void loadDeletedUsers() {

        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userService.deleteUser(id);
//        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(getAllUsers());
    }

    private List<User> getAllUsers(){
        List<User> users = userService.getUsersBetweenLevels(1,100);
        return userService.filterOnlyActiveUsers(users);
    }
    public void changeUserData(String name, long id, int level){
        User user = userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
    }
}