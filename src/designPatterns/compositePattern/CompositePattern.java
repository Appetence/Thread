package designPatterns.compositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ThreadLearn
 * @description: 组合模式 忽略单个对象和组合对象的区别
 * 组合部件 叶子 合成部件
 * 多个对象按照树形结构表示"整体-部分"的结构层次
 * @demo: 类似文件夹嵌套
 * @author: chuchen
 * @create: 2020-12-18 12:37
 */
public class CompositePattern {

    public static void main(String[] args) {
        System.out.println("-----------------start----------------");
        Folder folder = new Folder("父文件夹", "1", 10);
        TextFilder textFilder = new TextFilder("文本文件夹", "11", 11);
        AudioFilder audioFilder = new AudioFilder("音频文件夹", "12", 12);
        VedioFilder vedioFilder = new VedioFilder("视频文件夹", "13", 13);
        Folder sunFolder = new Folder("子文件夹", "2", 20);

        folder.add(textFilder);
        folder.add(audioFilder);
        folder.add(vedioFilder);
        folder.add(sunFolder);

        TextFilder sunTextFilder = new TextFilder("子文本文件夹", "21", 21);
        AudioFilder sunAudioFilder = new AudioFilder("子音频文件夹", "22", 22);
        VedioFilder sunVedioFilder = new VedioFilder("子视频文件夹", "23", 23);

        sunFolder.add(sunTextFilder);
        sunFolder.add(sunAudioFilder);
        sunFolder.add(sunVedioFilder);

        folder.display();
        System.out.println("-----------------end----------------");

    }
}

/**
 * 一个总文件夹
 * 里边可以放一些文件或者子文件夹，以此类推
 */
abstract class Filder {

    private String name;
    private String time;
    private double size;

    public abstract void display();

    public Filder() {
    }

    public Filder(String name, String time, double size) {
        this.name = name;
        this.time = time;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

/**
 * 子类
 */
class Folder extends Filder {

    private List<Filder> list;

    public Folder(String name, String time, double size) {
        super(name, time, size);
        this.list = new ArrayList<>();
    }

    public void remove(Filder filder) {
        list.remove(filder);
    }

    public List<Filder> getList() {
        return list;
    }

    public void add(Filder filder) {
        list.add(filder);
    }

    @Override
    public void display() {
//        System.out.println("this is one filder");
        for (Filder filder : list) {
            System.out.println(filder.getName() + filder.getTime() + filder.getSize());
            filder.display();
        }
    }
}

class TextFilder extends Filder {

    public TextFilder(String name, String time, double size) {
        super(name, time, size);
    }

    @Override
    public void display() {
        System.out.println("this is text file");
    }
}

class AudioFilder extends Filder {
    public AudioFilder(String name, String time, double size) {
        super(name, time, size);
    }

    @Override
    public void display() {
        System.out.println("this is audio file");
    }
}

class VedioFilder extends Filder {
    public VedioFilder(String name, String time, double size) {
        super(name, time, size);
    }

    @Override
    public void display() {
        System.out.println("this is vedio file");
    }
}