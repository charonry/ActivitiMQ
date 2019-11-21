package com.charon.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Article {
    @JsonIgnore  //排除属性不做序列化的操作
    private Long id;
    private String author;
    private String title;
    private String content;
    @JsonInclude(JsonInclude.Include.NON_NULL) //排除为空的元素不做序列化反序列化
    private Date createTime;
    private List<Reader> reader;

}
