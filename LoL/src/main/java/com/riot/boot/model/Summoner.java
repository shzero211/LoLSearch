package com.riot.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summoner {
	int profileIconId;
	String name;
	String puuid;
	long summonerLevel;
	long revisionDate;
	String id;
	String accountId;


}
