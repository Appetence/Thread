package designPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: ThreadLearn
 * @description: 迭代器模式 行为模式 顺序访问集合元素，无需知道对象的实现
 * @author: chuchen
 * @create: 2020-12-27 23:27
 */
public class IteratorPattern {
    public static void main(String[] args) {
//        int [] arr = new int[10];
        int [] arr = {1,2,3,4};
        List list = new ArrayList(arr.length);
        for(int i : arr){
            list.add(i);
        }
        ConcreteAggregateImpl concreteAggregate = new ConcreteAggregateImpl();
        concreteAggregate.setList(list);
        //第一次执行时候初始化了，在执行都是同一个对象
        for(Iterator iterator =  concreteAggregate.getInstance();iterator.hasNext();){
            System.out.println(iterator.getCurrentObj());
            iterator.next();

        }

    }
}

/**
 * 迭代器抽象类
 */
interface Iterator {

    boolean hasNext();

    int getCurrent();

    Object getCurrentObj();

    void next();

    void first();


}

/**
 * 抽象类集合
 */
interface ConcreteAggregate {

    List<Object> getList();

    void setList(List<Object> o);

    boolean removeList(Object o);

    void addList(Object o);

    Iterator getInstance();

}

class ConcreteAggregateImpl implements ConcreteAggregate {

    private List<Object> list = new ArrayList<>();

    @Override
    public List<Object> getList() {
        return list;
    }

    @Override
    public void setList(List<Object> o) {
        list.addAll(o);
    }

    @Override
    public boolean removeList(Object o) {
        return list.remove(o);
    }

    @Override
    public void addList(Object o) {
        list.add(o);
    }

    @Override
    public Iterator getInstance() {
        return new CusIterator();
    }

    class CusIterator implements Iterator {
        //光标位置
        private int cursor;

        @Override
        public boolean hasNext() {
            return list.size() > cursor;
        }

        @Override
        public int getCurrent() {
            return cursor;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }

        @Override
        public void next() {
            if(cursor < list.size()){
                //可以被共享最根本的原因是内部类
                cursor++;
            }
        }

        @Override
        public void first() {
            cursor = 0;
        }
    }
}