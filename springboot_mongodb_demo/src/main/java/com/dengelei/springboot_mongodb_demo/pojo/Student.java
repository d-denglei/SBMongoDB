package com.dengelei.springboot_mongodb_demo.pojo;

import lombok.Data;

/**
 * @FileName： Student
 * @author： dengl
 * @date： 2021/12/27
 */

@Data
public class Student {

    private String id;
    private String content;
    private String name;
    private String userId;
    private Integer visits;
}
