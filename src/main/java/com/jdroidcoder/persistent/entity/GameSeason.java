package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 26.01.17.
 */
@Entity
public class GameSeason extends AbstractEntity<Long> {
    private static final long serialVersionUID = 926247593761021815L;

    @OneToOne(cascade = CascadeType.ALL)
    private GameMatchSingleEntity gameMatchSingleEntity;

    public GameSeason() {
    }

    public GameMatchSingleEntity getGameMatchSingleEntity() {
        return gameMatchSingleEntity;
    }

    public void setGameMatchSingleEntity(GameMatchSingleEntity gameMatchSingleEntity) {
        this.gameMatchSingleEntity = gameMatchSingleEntity;
    }
}
