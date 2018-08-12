package cn.guxiangfly.juc;

import io.netty.util.internal.chmv8.ForkJoinTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;


public class ForkJoinForList extends RecursiveTask<List> {

    private static final long serialVersionUID = 123456788999L;

    private List list = null;
    private Object object = null;

    public ForkJoinForList(List list) {
        this.list = list;
    }

    public ForkJoinForList(Object o) {
        this.object = o;
    }

    @Override
    protected List compute() {

        List result = Collections.synchronizedList(new ArrayList<>());

        for (Object o : list) {
            ForkJoinForList forkJoinForList = new ForkJoinForList(o);
            result.addAll(forkJoinForList.join());
        }

        return null;
    }
}

