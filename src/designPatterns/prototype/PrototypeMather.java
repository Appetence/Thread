package designPatterns.prototype;

import designPatterns.prototype.cache.Prototype;

import java.io.Serializable;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-13 13:33
 */
public class PrototypeMather extends Prototype implements Serializable {

    private String relation;
    private String mather;

    public PrototypeMather(String relation, String mather) {
        this.relation = relation;
        this.mather = mather;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getMather() {
        return mather;
    }

    public void setMather(String mather) {
        this.mather = mather;
    }


    @Override
    public String toString() {
        return "PrototypeMather{" +
                "relation='" + relation + '\'' +
                ", mather='" + mather + '\'' +
                '}';
    }
}
