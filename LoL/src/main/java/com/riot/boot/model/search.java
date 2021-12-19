package com.riot.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class search {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int lolUserNum;
private int profileIconId;
private String name;
private String puuid;
private String id;
private String accountId;
}
