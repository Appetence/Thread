package designPatterns.builderPattern;

/**
 * @program: ThreadLearn
 * @description: 构造者模式 , 将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示
 *               抽象定义好主干，叶子长啥样由🍃所处的环境决定
 *
 *               构造者模式，一个维度进行维护
 *
 * @author: chuchen
 * @create: 2020-12-11 23:32
 */
public class builderPattern {

    public static void main(String[] args) {
        HouseDirector houseDirector = new HouseDirector(new CommonHouseBuilder());
        System.out.println(houseDirector.buildHouse().toString());
    }
}

/**
 * 监督者
 */
class HouseDirector {
    HouseBuilder houseBuilder = null;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House buildHouse() {
        houseBuilder.builderBisc();
        houseBuilder.builderWalls();
        houseBuilder.roofed();
        return houseBuilder.houseBuild();
    }
}

/**
 * 构建者抽象
 */
abstract class HouseBuilder {

    House house = new House();

    abstract public void builderBisc();

    abstract public void builderWalls();

    abstract public void roofed();

    public House houseBuild() {
        return house;
    }
}

/**
 * 构建者
 */
class HighHouseBuilder extends HouseBuilder {

    @Override
    public void builderBisc() {
        System.out.println("build high house bisc");
    }

    @Override
    public void builderWalls() {
        System.out.println("build high house wall");

    }

    @Override
    public void roofed() {
        System.out.println("build high house roofed");

    }
}

/**
 * 构建者
 */
class CommonHouseBuilder extends HouseBuilder {

    @Override
    public void builderBisc() {
        System.out.println("build house bisc");
    }

    @Override
    public void builderWalls() {
        System.out.println("build house wall");

    }

    @Override
    public void roofed() {
        System.out.println("build house roofed");

    }
}

/**
 * 成果
 */
class House {
    private String bisc;
    private String well;
    private String roofed;

    public String getBisc() {
        return bisc;
    }

    public void setBisc(String bisc) {
        this.bisc = bisc;
    }

    public String getWell() {
        return well;
    }

    public void setWell(String well) {
        this.well = well;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

    @Override
    public String toString() {
        return "House{" +
                "bisc='" + bisc + '\'' +
                ", well='" + well + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }
}