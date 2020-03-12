package com.third;

import com.second.Container;
import com.second.Queue;
import com.second.Stack;

public class ContainerFactory implements IFactory {
    public static final ContainerFactory INSTANCE = new ContainerFactory();

    public ContainerFactory() {
    }

    public Container createContainer(Strategy strategy) {
        if (strategy.equals(Strategy.FIFO)) {
            return new Queue();
        } else if (strategy.equals(Strategy.LIFO)) {
            return new Stack();
        }
        return null;
    }
}