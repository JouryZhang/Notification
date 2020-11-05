package com.home.entity;

import lombok.Data;

/**
 * @ClassName MessagePack
 * @Description 接收的数据包内message对象
 * @Author
 * @Date 2020/11/4 16:40
 * @Version 1.0
 */
@Data
public class MessagePack {
    private String data;
    private Object attributes;
    private String messageId;
    private String publishTime;
}
