package com.jdroidcoder.persistent.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 26.01.17.
 */
@Entity
public class GameEventSingleEntity extends AbstractEntity<Long> {
    private static final long serialVersionUID = 5222473597761021815L;

    @OneToOne
    private GameMatchSingleEntity gameMatchSingleEntity;

    public GameEventSingleEntity() {
    }

    public GameMatchSingleEntity getGameMatchSingleEntity() {
        return gameMatchSingleEntity;
    }

    public void setGameMatchSingleEntity(GameMatchSingleEntity gameMatchSingleEntity) {
        this.gameMatchSingleEntity = gameMatchSingleEntity;
    }
}
