package forkjoin;

import java.util.concurrent.RecursiveTask;

public abstract  class ForkJoinService<T> extends RecursiveTask<T> {
    @Override
    protected abstract T compute();
}
