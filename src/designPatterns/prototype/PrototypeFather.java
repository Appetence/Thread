package designPatterns.prototype;

import designPatterns.prototype.cache.Prototype;

import java.io.Serializable;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-13 13:33
 */
public class PrototypeFather extends Prototype implements Serializable {
    private String relation;
    private String father;

    public PrototypeFather(String relation, String father) {
        this.relation = relation;
        this.father = father;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "PrototypeFather{" +
                "relation='" + relation + '\'' +
                ", father='" + father + '\'' +
                '}';
    }
}
