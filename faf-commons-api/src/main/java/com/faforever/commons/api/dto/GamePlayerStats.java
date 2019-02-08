package com.faforever.commons.api.dto;

import com.faforever.commons.api.elide.ElideEntity;
import com.faforever.commons.api.elide.querybuilder.QueryOperator;
import com.faforever.commons.api.elide.querybuilder.reflection.FilterDefinition;
import com.faforever.commons.api.elide.querybuilder.reflection.TransientFilter;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Type("gamePlayerStats")
public class GamePlayerStats implements ElideEntity {
    @Id
    private String id;
    private boolean ai;

  @FilterDefinition(allowedOperators = QueryOperator.Preset.ENUM)
  private Faction faction;
    private byte color;
    private byte team;
    private byte startSpot;
    private Float beforeMean;
    private Float beforeDeviation;
    private Float afterMean;
    private Float afterDeviation;
    private byte score;
    @Nullable
    private OffsetDateTime scoreTime;

    @Relationship("game")
    @TransientFilter
    private Game game;

    @Relationship("player")
    @TransientFilter
    private Player player;
}
