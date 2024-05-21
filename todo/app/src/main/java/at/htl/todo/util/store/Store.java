package at.htl.todo.util.store;

import java.util.concurrent.CompletionException;
import java.util.function.Consumer;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class Store<T> {
    public final BehaviorSubject<T> pipe;

    protected Store(Class<? extends T> type, T initialState) {
        try {
            pipe = BehaviorSubject.createDefault(initialState);
        } catch (Exception e) {
            throw new CompletionException(e);
        }
    }
    public void apply(Consumer<T> recipe) {
        pipe.onNext(pipe.getValue());
    }
}