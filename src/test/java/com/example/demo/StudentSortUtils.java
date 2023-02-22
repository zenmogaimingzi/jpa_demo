package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 学生排序工具类
 *
 */
public class StudentSortUtils {


    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(2000) + 1000;
        List<Student> students = buildStudent(random, number);
        //   针对list，先筛选得到年龄小于15岁，
        List<Student> child = students.stream().filter(item -> item.getAge() < 15).collect(Collectors.toList());

        //  根据age，name排序（age从小到大排序，
        //  年龄相同的name 按照a-z 字母逐个排序aaaaa在前，zzzzzzzzzz 最后）
        List<Student> result = child.stream().sorted(Comparator.comparing(Student::getAge)
                .thenComparing(Student::getName)
                .reversed()).collect(Collectors.toList());

        for (Student student : result) {
            System.out.println(student);
        }
        System.out.println("end");
    }

    /**
     * 创建学生list
     *
     * @param random
     * @param number  学生数量
     * @return
     */
    public static List<Student> buildStudent(Random random,int number){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Student student = new Student();

            int age = random.nextInt(10) + 5;
            char name = (char)('A'+(int)(Math.random()*26));

            student.setId(i+1);
            student.setAge(age);
            student.setName(name+i+"");
            students.add(student);
        }
        return students;
    }


    List<Job> instanceList ;

    public List<Job> countHomeNum(List<Job> instanceList) {

        return instanceList;
    }
}

class Job {
    private Integer id;
    private String time;
}
