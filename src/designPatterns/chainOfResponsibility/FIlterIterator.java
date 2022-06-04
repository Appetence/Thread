package designPatterns.chainOfResponsibility;

/**
 * @program: ThreadLearn
 * @description: 迭代器模式实现过滤器链条
 * @author: chuchen
 * @create: 2020-12-10 23:44
 */
public class FIlterIterator {
    public static void main(String[] args) {
        Filters filters = buildChinal();
        filters.doFilter(new Request().setParams("run"), new Response());


    }

    static Filters buildChinal() {
        DelFilter delFilter = new DelFilter();
        RunFilter runFilter = new RunFilter();
        SkipFilter skipFilter = new SkipFilter();
        delFilter.setNext(runFilter);
        runFilter.setNext(skipFilter);
        //skipFilter.setNext(delFilter);
        //加上死循环StackOverflowError
        return delFilter;
    }
}


abstract class Filters {
    private Filters next;

    abstract public boolean doFilter(Request request, Response response);

    public Filters getNext() {
        return next;
    }

    public Filters setNext(Filters next) {
        this.next = next;
        return next;
    }
};

class RunFilter extends Filters {


    @Override
    public boolean doFilter(Request request, Response response) {
        if (request.getParams().equals("run")) {
            System.out.println("run as run filter");
            return true;
        } else {
            if (this.getNext() != null) {
                return this.getNext().doFilter(request, response);
            } else {
                return false;
            }
        }

    }


}

class DelFilter extends Filters {

    @Override
    public boolean doFilter(Request request, Response response) {
        if (request.getParams().equals("del")) {
            System.out.println("run as del filter");
            return true;
        } else {
            if (this.getNext() != null) {
                return this.getNext().doFilter(request, response);
            } else {
                return false;
            }
        }
    }
}

class SkipFilter extends Filters {

    @Override
    public boolean doFilter(Request request, Response response) {
        if (request.getParams().equals("skip")) {
            System.out.println("run as skip filter");
            return true;
        } else {
            if (this.getNext() != null) {
                return this.getNext().doFilter(request, response);
            } else {
                return false;
            }
        }
    }
}
