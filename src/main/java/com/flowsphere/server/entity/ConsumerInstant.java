package com.flowsphere.server.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Entity(name = "t_consumer_instant")
public class ConsumerInstant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String url;

    @Column
    private LocalDateTime lastUpdateTime;

    @Column
    private int status;

    @OneToOne
    @JoinColumn(name = "consumerId", referencedColumnName = "id")
    private Consumer consumer;

}
