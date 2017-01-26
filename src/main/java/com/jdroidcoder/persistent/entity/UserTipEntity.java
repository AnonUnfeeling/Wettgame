package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 26.01.17.
 */
@Entity
public class UserTipEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 8722473597761021815L;
    @OneToOne(cascade = CascadeType.ALL)
    private GameMatchSingleEntity gameMatchSingleEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    public UserTipEntity() {
    }

    public GameMatchSingleEntity getGameMatchSingleEntity() {
        return gameMatchSingleEntity;
    }

    public void setGameMatchSingleEntity(GameMatchSingleEntity gameMatchSingleEntity) {
        this.gameMatchSingleEntity = gameMatchSingleEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
