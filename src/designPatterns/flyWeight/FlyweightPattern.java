package designPatterns.flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ThreadLearn
 * @description: 享元模式
 * <p>解决重复对象的内存浪费问题</p>
 * @author: chuchen
 * @create: 2020-12-20 16:05
 */
public class FlyweightPattern {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");
        System.out.println(chess1);
        System.out.println(chess2);
        System.out.println(chess1.equals(chess2));
        System.out.println("增加外部状态的处理===========");
        chess1.display(new Coordinate(10, 10));
        chess2.display(new Coordinate(20, 20));
    }

}

/**
 * 定义一个公共的接口
 */
interface ChessFlyWeight {

    void setColor(String color);

    String getColor();

    void display(Coordinate coordinate);


}

class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        super();
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色：" + color);
        System.out.println("棋子位置：" + coordinate.getX() + "----" + coordinate.getY());
    }
}

/**
 * 棋子坐标
 */
class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

class ChessFlyWeightFactory {
    //享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<String, ChessFlyWeight>();

    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color, cfw);
            return cfw;
        }
    }
}