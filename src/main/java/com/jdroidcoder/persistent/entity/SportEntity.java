package com.jdroidcoder.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@Entity
public class SportEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 7322473597761021815L;

    @Column
    private String name;
    @OneToOne
    private EventEntity eventEntity;

    public SportEntity() {
    }

    public SportEntity(String name, EventEntity eventEntity) {
        this.name = name;
        this.eventEntity = eventEntity;
    }

    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
