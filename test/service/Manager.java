package test.service;

import java.util.List;

public interface Manager<E> {
    List<E> add();
    List<E> update();
    List<E> delete();
    void display();

}
