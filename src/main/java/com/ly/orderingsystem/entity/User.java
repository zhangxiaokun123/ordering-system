package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /*CREATE TABLE USER
            (
                    ID                   INT NOT NULL AUTO_INCREMENT,
                    USERNAME             VARCHAR(20) NOT NULL,
    PASSWORD             VARCHAR(20) NOT NULL,
    NAME                 VARCHAR(20) NOT NULL,
    MAIL                 VARCHAR(40),
    PHONE                VARCHAR(40),
    REMARK               VARCHAR(100),
    STATUS               TINYINT DEFAULT 0,
    PRIMARY KEY (ID)
);*/
        private Integer userId;//用户ID

        private String  userName;//用户名

        private String  passWord;//密码

        private String uname;//用户姓名

        private String mail;//电子邮件

        private String phone;//联系方式

        private String remark;//备注

        private Integer status;//状态

}
