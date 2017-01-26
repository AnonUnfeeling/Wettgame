package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by jdroidcoder on 25.01.17.
 */
@Entity
public class GameCategoryEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 2222473597763021815L;

    @OneToOne(cascade = CascadeType.ALL)
    private GameSectorEntity gameSectorEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private CategoryEntity categoryEntity;
    @OneToOne
    private GameEventEntity gameEventEntity;

    public GameCategoryEntity() {
    }

    public GameCategoryEntity(GameSectorEntity gameSectorEntity, CategoryEntity categoryEntity) {
        this.gameSectorEntity = gameSectorEntity;
        this.categoryEntity = categoryEntity;
    }

    public GameSectorEntity getGameSectorEntity() {
        return gameSectorEntity;
    }

    public void setGameSectorEntity(GameSectorEntity gameSectorEntity) {
        this.gameSectorEntity = gameSectorEntity;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public GameEventEntity getGameEventEntity() {
        return gameEventEntity;
    }

    public void setGameEventEntity(GameEventEntity gameEventEntity) {
        this.gameEventEntity = gameEventEntity;
    }
}
