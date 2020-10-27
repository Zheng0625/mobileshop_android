package com.huatec.edu.mobileshop.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

public abstract class ProgressDialogSub<T> extends Subscriber<T> {
    private Context context;
    private ProgressDialog progressDialog;

    public ProgressDialogSub(Context context) {
        this.context = context;
    }

    @Override
    public void onStart() {
        super.onStart();
        showDialog();
    }

    @Override
    public void onCompleted() {
        //事件队列结束时让dialog消失
        dismissDialog();
    }

    @Override
    public void onError(Throwable e) {
        //instanceof 类似 ==
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(context, "网络中断，请检查您的网络状态",Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(context, "网络中断，请检查您的网络状态", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context,"error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        dismissDialog();
    }

    //显示进度条
    private void showDialog() {
        //为空则实例化
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    ProgressDialogSub.this.unsubscribe();//取消订阅，取消请求
                }
            });
        }
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.show();
        }
    }
    //隐藏进度条
    private void dismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
