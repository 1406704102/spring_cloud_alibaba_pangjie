package com.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity(name = "shop_txlog")
//消息事务状态记录
public class TxLog {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Date date;
    private Timestamp createTime;
}