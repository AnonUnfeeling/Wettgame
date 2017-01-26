package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 26.01.17.
 */
@Entity
public class TeamEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 5622473597761021815L;
    @Column
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private LocationEntity locationEntity;
    @OneToOne
    private GameMatchSingleEntity gameMatchSingleEntity;

    public TeamEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public GameMatchSingleEntity getGameMatchSingleEntity() {
        return gameMatchSingleEntity;
    }

    public void setGameMatchSingleEntity(GameMatchSingleEntity gameMatchSingleEntity) {
        this.gameMatchSingleEntity = gameMatchSingleEntity;
    }
}
