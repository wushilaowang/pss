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
public class User implements Serializable {
    Integer id;
    String account;
    String password;
    String salt;
    String email;
    Short valid;
    String createtime;
}
