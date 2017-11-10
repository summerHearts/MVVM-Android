package com.example.kenvin.mvvm_android.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Kenvin on 2017/11/10.
 */

public class CommonAdapter<T>  extends BaseAdapter{

    private Context context;

    private LayoutInflater inflater;

    private int layoutId;

    private int variableId;

    private List<T> list;

    public CommonAdapter(Context context, LayoutInflater inflater, int layoutId, int variableId, List<T> list) {
        this.context = context;
        this.inflater = inflater;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewDataBinding dataBinding;
        if (convertView == null){
            dataBinding = DataBindingUtil.inflate(inflater,layoutId,parent,false);
        }else {
            dataBinding = DataBindingUtil.getBinding(convertView);
        }
        //用try catch 块包围住
        try {
            dataBinding.setVariable(variableId,list.get(position));
        } catch (OutOfMemoryError e) {
            // 这里就是当内存泄露时 需要做的事情
            e.printStackTrace();

            Log.d("memory", "out");
            //释放内存资源

            //将刚才 发生异常没有执行的 代码 再重新执行一次
            dataBinding.setVariable(variableId,list.get(position));

        }
        return dataBinding.getRoot().getRootView();
    }
}
