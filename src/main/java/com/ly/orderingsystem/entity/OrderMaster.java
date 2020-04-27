package com.ly.orderingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMaster {
/*        CREATE TABLE ORDER_MASTER
                (
        ORDER_SN             BIGINT NOT NULL,
        USER_NAME            VARCHAR(50) NOT NULL,
        UNAME                VARCHAR(20),
        PAYMENT_METHOD       TINYINT NOT NULL,
        ORDER_MONEY          DECIMAL(8,2) NOT NULL,
        CREATE_TIME          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        PAY_TIME             DATETIME,
        ORDER_STATUS         TINYINT NOT NULL DEFAULT 0,
        MODIFIED_TIME        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        PRIMARY KEY (ORDER_SN)
);*/
        private Long orderSn;//订单编号

        private String userName;//用户名

        private String uname;//用户姓名

        private Integer paymentMethod;//支付方式

        private Double orderMoney;//订单金额

        private String createTime;//下单时间

        private String payTime;//支付时间

        private Integer orderStatus;//订单状态

        private String modifiedTime;//最后修改时间

}
