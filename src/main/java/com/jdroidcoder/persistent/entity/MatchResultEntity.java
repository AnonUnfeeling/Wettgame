package com.jdroidcoder.persistent.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@Entity
public class MatchResultEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 3222473597761021815L;
    @OneToOne
    private GameMatchSingleEntity gameMatchSingleEntity;

    public MatchResultEntity() {
    }

    public GameMatchSingleEntity getGameMatchSingleEntity() {
        return gameMatchSingleEntity;
    }

    public void setGameMatchSingleEntity(GameMatchSingleEntity gameMatchSingleEntity) {
        this.gameMatchSingleEntity = gameMatchSingleEntity;
    }
}
