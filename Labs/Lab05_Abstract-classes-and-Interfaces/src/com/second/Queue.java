package com.second;

import com.first.Task;

import java.util.ArrayList;

public class Queue extends ContainerHelper {

    public Queue() {
        super();
    }

    @Override
    public Task pop() {
        if (getList().isEmpty()) {
            return null;
        }

        ArrayList<Task> list = getList();
        Task task = list.get(0);
        list.remove(task);
        return task;
    }

}
