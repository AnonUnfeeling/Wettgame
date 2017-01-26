package com.jdroidcoder.persistent.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.time.LocalDate;

/**
 * Created by jdroidcoder on 26.01.17.
 */
@Entity
public class GameMatchSingleEntity extends AbstractEntity<Long>{
    private static final long serialVersionUID = 8222473597761021815L;

    @OneToOne(cascade = CascadeType.ALL)
    private GameEventSingleEntity gameEventSingleEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private LocationEntity locationEntity;
    @Column
    private LocalDate localDate;
    @Column
    private Time time;
    @OneToOne(cascade = CascadeType.ALL)
    private TeamEntity teamEntity;
    @OneToOne
    private GameSeasonEntity gameSeason;
    @OneToOne
    private UserTipEntity userTipEntity;

    public GameMatchSingleEntity() {
    }

    public GameEventSingleEntity getGameEventSingleEntity() {
        return gameEventSingleEntity;
    }

    public void setGameEventSingleEntity(GameEventSingleEntity gameEventSingleEntity) {
        this.gameEventSingleEntity = gameEventSingleEntity;
    }

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TeamEntity getTeamEntity() {
        return teamEntity;
    }

    public void setTeamEntity(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

    public GameSeasonEntity getGameSeason() {
        return gameSeason;
    }

    public void setGameSeason(GameSeasonEntity gameSeason) {
        this.gameSeason = gameSeason;
    }

    public UserTipEntity getUserTipEntity() {
        return userTipEntity;
    }

    public void setUserTipEntity(UserTipEntity userTipEntity) {
        this.userTipEntity = userTipEntity;
    }
}
