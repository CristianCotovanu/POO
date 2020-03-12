package com.second;

import com.first.Task;

import java.util.ArrayList;

public class Stack extends ContainerHelper {

    public Stack() {
        super();
    }

    @Override
    public Task pop() {
        if (getList().isEmpty()) {
            return null;
        }

        ArrayList<Task> list = getList();
        Task task = list.get(list.size() - 1);
        list.remove(task);
        return task;
    }
}
