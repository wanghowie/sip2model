package com.wanghui.sip2model.fields;


import com.wanghui.sip2model.annotations.Field;

import java.util.Date;

/**
 * @auther wanghui
 * @create 2018-11-13 0:36
 * @Description 字段定义
 */
public class FieldDefinition {

    /**
     * 属性标识，非必须。属性值长度可变的属性必有
     */
    public String tag;

    /**
     * 属性类型
     */
    public Class<?> type;

    /**
     * 属性长度
     */
    public int length;

    /**
     * 属性政策
     */
    public FieldPolicy policy = FieldPolicy.DEFAULT;

    protected FieldDefinition() {
    }


    protected FieldDefinition(String name, FieldDefinition d, FieldPolicy policy) {
        this.tag = d.tag;
        this.length = d.length;
        /*
         * 字段政策 ：
         * 1、可变长度字段，策略必须明确，要么必选，要么可选；不存在中间态;
         * 2、固定长度字段，策略不能被覆盖
         *
         */
        if ((d.policy == FieldPolicy.DEFAULT) && (policy != FieldPolicy.DEFAULT)) {
            this.policy = policy;
        } else if ((d.policy == FieldPolicy.DEFAULT) && (policy == FieldPolicy.DEFAULT)) {
            throw new AssertionError(name + "：可变长度的字段策略不能是DEFAULT,只能是REQUIRED或者NOT_REQUIRED");
        } else if ((d.policy != FieldPolicy.DEFAULT) && (policy == FieldPolicy.DEFAULT)) {
            this.policy = d.policy;
        } else {
            throw new AssertionError(name + "：不能覆盖固定字段的策略");
        }
    }

    /**
     * 根据传递的注解值和类型对字段进行实例化。
     * @param field 字段注解
     * @param type  类型
     */
    public FieldDefinition(Field field, Class<?> type) {
        this.tag = field.tag();
        this.type = type;
        this.length = field.length();
        this.policy = field.policy();
        if (this.length == 0) {
            //SIP2中，规定Boolean类型的字段长度为1，取值为0/1；时间类型长度为18，格式为：YYYYMMDDZZZZHHMMSS
            if (this.type == Boolean.class) {
                this.length = 1;
            }
            if (this.type == Date.class) {
                this.length = 18;
            }
        }
        if (this.tag == null) {
            this.tag = "";
        }            
        if (this.policy == null) {
            this.policy = FieldPolicy.DEFAULT;
        }
    }
}
