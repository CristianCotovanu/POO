package com.second;

import com.first.Task;

import java.util.ArrayList;

public abstract class ContainerHelper implements Container {
    private ArrayList<Task> list;

    ContainerHelper() {
        list = new ArrayList<Task>();
    }

    public ArrayList<Task> getList() {
        return list;
    }

    @Override
    public void push(Task task) {
        list.add(task);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void transferFrom(Container container) {
        while(!container.isEmpty()) {
            this.push(container.pop());
        }
    }
}
