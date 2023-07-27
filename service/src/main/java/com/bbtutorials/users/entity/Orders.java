package com.bbtutorials.users.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Orders {

    @Id
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @NotNull(message="{NotNull.Order.userId}")
    private Users userId;

    @Column (name = "PRODUCT_NAME")
    @NotNull(message="{NotNull.Order.productName}")
    private String productName;

    @Column (name = "NUMBER")
    @NotNull(message="{NotNull.User.number}")
    private int number;
}
