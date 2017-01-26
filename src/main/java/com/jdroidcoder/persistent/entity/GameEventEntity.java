package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 26.01.17.
 */
@Entity
public class GameEventEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 9222473577761021815L;

    @OneToOne(cascade = CascadeType.ALL)
    private GameCategoryEntity gameCategoryEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private EventEntity eventEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private LocationEntity locationEntity;

    public GameEventEntity() {
    }

    public GameCategoryEntity getGameCategoryEntity() {
        return gameCategoryEntity;
    }

    public void setGameCategoryEntity(GameCategoryEntity gameCategoryEntity) {
        this.gameCategoryEntity = gameCategoryEntity;
    }

    public EventEntity getEventEntity() {
        return eventEntity;
    }

    public void setEventEntity(EventEntity eventEntity) {
        this.eventEntity = eventEntity;
    }

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }
}
