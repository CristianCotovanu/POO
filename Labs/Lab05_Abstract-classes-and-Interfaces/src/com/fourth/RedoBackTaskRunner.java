package com.fourth;

import com.first.Task;
import com.second.Container;
import com.third.ContainerFactory;
import com.third.Strategy;

public class RedoBackTaskRunner extends AbstractTaskRunner {
    private Container stack;

    public RedoBackTaskRunner(Strategy strategy) {
        super(strategy);
        stack = ContainerFactory.INSTANCE.createContainer(strategy);
    }

    @Override
    protected void afterExecution(Task task) {
        stack.push(task);
    }

    public void redo() {
//        while (!stack.isEmpty()) {
            Task toDo = stack.pop();
            toDo.execute();
//        }
    }
}
