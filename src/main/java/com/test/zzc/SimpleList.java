package com.test.zzc;

/**
 * @author le
 * @date 2018/5/9
 * 带泛型 简单链表类
 */
public class SimpleList <T>{
    T t;
    SimpleList<T> next;

    public SimpleList(T t, SimpleList<T> next) {
        this.t = t;
        this.next = next;
    }

    public T get(){
        return this.t;
    }

    public void insert(T insetT){
        SimpleList cur = this;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = new SimpleList(insetT,null);
    }

    public void earse(T delT){
        if (delT == this.t){
            return;
        }
        SimpleList cur = this;
        while (cur.next != null){
            if (cur.next.t==delT){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

}
