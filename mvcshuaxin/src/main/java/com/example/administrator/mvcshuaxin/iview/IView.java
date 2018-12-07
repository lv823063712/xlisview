package com.example.administrator.mvcshuaxin.iview;

public interface IView<T> {

    void success(T data);

    void error(T error);
}
