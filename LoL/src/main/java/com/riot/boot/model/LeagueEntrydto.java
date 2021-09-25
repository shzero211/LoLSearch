package com.riot.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeagueEntrydto {
String queueType;
int wins;
int losses;
String leagueId;
String rank;
String tier;
int leaguePoints;
}
