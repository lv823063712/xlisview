package com.example.administrator.mvcshuaxin.presenter;

import com.example.administrator.mvcshuaxin.callback.MyCallBack;
import com.example.administrator.mvcshuaxin.iview.IView;
import com.example.administrator.mvcshuaxin.moudle.MyMoudleIple;

public class PresenterImpl implements Presenter {
    private IView iView;
    private MyMoudleIple myMoudleIple;

    public PresenterImpl(IView iView) {
        this.iView = iView;
        myMoudleIple = new MyMoudleIple();
    }

    @Override
    public void startRequest(final String url, final int index) {
        myMoudleIple.getData(url, index, new MyCallBack() {
            @Override
            public void setData(Object data) {
                iView.success(data);
            }

            @Override
            public void setError(Object error) {
                iView.error(error);
            }
        });
    }

    //防止内存泄漏
    public void onDetatch() {
        if (myMoudleIple != null) {
            myMoudleIple = null;
        }
        if (iView != null) {
            iView = null;
        }
    }

}
