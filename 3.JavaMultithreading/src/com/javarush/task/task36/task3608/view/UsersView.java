package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by winnie on 27.09.17.
 */
public class UsersView implements View {
    private Controller controller;

    private JButton labelButton;
    private JButton colorButton;
    private JFrame frame;
    private JLabel label;

    public UsersView() {

        frame = new JFrame("UserView");

        labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());
        colorButton = new JButton("Change Color");
        colorButton.addActionListener(new ColorListener());
        label = new JLabel("I'm a Label");
        MyDrawPanel myDrawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, myDrawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }


    @Override
    public void refresh(ModelData modelData) {
        if (!modelData.isDisplayDeletedUserList()) {
            System.out.println("All users:");
        }
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        }
        List<User> users = modelData.getUsers();
        for (int i = 0; i < users.size(); i++) {
            System.out.println("\t" + users.get(i));
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        label.setText("Ouch");
        }
    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEventShowDeletedUsers();
            frame.repaint();
        }
    }

//    public void fireEventUserDeleted(long id) {
//        controller.onUserDelete(id);
//    }

}
