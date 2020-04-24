package com.oupu.pss.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Classname:User
 * Package:com.oupu.pss.entity
 * Description:
 *
 * @Data:2019/12/25 10:44
 * @Author:
 */
@Data
@NoArgsConstructor
public class Role implements Serializable {
    Integer id;
    String role_name;
    String mark;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date createtime;
}
