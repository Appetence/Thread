package designPatterns.chainOfResponsibility.http;

import java.util.LinkedList;

/**
 * @program: ThreadLearn
 * @description: 责任链模式 list 集合
 * @author: chuchen
 * @create: 2020-12-07 23:32
 */
public class FilterResponsible {

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new ReadFilter()).addFilter(new WriteFilter());
        filterChain.doFilter(new Request(), new Response(),filterChain);
    }

}

class Request {
    private String params;

    public String getParams() {
        return params;
    }

    public Request setParams(String params) {
        this.params = params;
        return this;
    }
}

class Response {
    private String params;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
}

class FilterChain {

    private LinkedList<Filter> linkedList = new LinkedList<>();

    public FilterChain addFilter(Filter filter) {
        linkedList.add(filter);
        return this;
    }

    public LinkedList<Filter> getFilter() {
        return linkedList;
    }

    public boolean doFilter(Request request, Response response ,FilterChain filterChain) {
        for (Filter filter : linkedList) {
            System.out.println("filter chain "+request.getParams());
            //这里校验是否需要继续向下执行相关方法
            if (!filter.doFilter(request, response, filterChain)) {
                System.out.println("终止啦");
                return false;
            }
            System.out.println("filter chain " +response.getParams());
        }
        return true;
    }

}

/**
 * 接口
 */
abstract class Filter {
    abstract public boolean doFilter(Request request, Response response, FilterChain filterChina);
};

class ReadFilter extends Filter {
    public ReadFilter() {

    }

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChina) {
//        System.out.println(" run read filter");
        request.setParams("read filter"+request.getParams());
        return true;
    }
};

class WriteFilter extends Filter {

    @Override
    public boolean doFilter(Request request, Response response, FilterChain filterChina) {
//        System.out.println(" run write filter"+request.getParams());
        request.setParams("write filter"+request.getParams());
        return true;
    }
};