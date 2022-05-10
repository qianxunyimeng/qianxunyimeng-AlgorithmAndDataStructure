package com.qianxun.选择排序法;

import java.util.Objects;

/**
 * @BelongsProject: AlgorithmAndDataStructure
 * @BelongsPackage: PACKAGE_NAME
 * @Author: shiqingliang
 * @CreateTime: 2022-05-09  21:49
 * @Description: TODO
 * @Version: 1.0
 */
public class Student implements Comparable<Student>{

    private String name;

    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }


    @Override
    public int compareTo(Student o) {
//        if(this.score < o.score){
//            return -1;
//        }else if(this.score == o.score){
//            return 0;
//        }else{
//            return 1;
//        }
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
