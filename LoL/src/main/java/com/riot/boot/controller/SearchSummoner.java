package com.riot.boot.controller;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.*;
import com.riot.boot.model.LeagueEntrydto;
import com.riot.boot.model.Summoner;

@Controller
public class SearchSummoner {
	final static String API_KEY = "RGAPI-e45eee9e-19c3-4202-b293-bbe2cb33e4f4";

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchSummoner(Model model, HttpServletRequest httpServletRequest) {
		BufferedReader br = null;
		BufferedReader brL = null;
		String SummonerName = httpServletRequest.getParameter("username");
		Summoner temp = null;
		LeagueEntrydto[] leagueInfo = null;
		String[] leagueName = null;
		try {
			String urlstr = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + SummonerName
					+ "?api_key=" + API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");

			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result += line;

			}

			JsonObject k = JsonParser.parseString(result).getAsJsonObject();
			int profileIconId = k.get("profileIconId").getAsInt();
			String name = k.get("name").getAsString();
			String puuid = k.get("puuid").getAsString();
			long summonerLevel = k.get("summonerLevel").getAsLong();
			long revisionDate = k.get("revisionDate").getAsLong();
			String id = k.get("id").getAsString();
			String accountId = k.get("accountId").getAsString();
			temp = new Summoner(profileIconId, name, puuid, summonerLevel, revisionDate, id, accountId);
			System.out.println(temp.getId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {

			String urlstr = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + temp.getId()
					+ "?api_key=" + API_KEY;
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			urlconnection.setRequestMethod("GET");
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result += line;

			}

			JsonParser jsonParser = new JsonParser();
			JsonArray jsonArray = (JsonArray) jsonParser.parse(result);
			leagueInfo=new LeagueEntrydto[jsonArray.size()];
			leagueName=new String[jsonArray.size()];
			JsonObject k = null;
			for (int i = 0; i < jsonArray.size(); i++) {
				k=(JsonObject)jsonArray.get(i);
				int wins = k.get("wins").getAsInt();
				int losses = k.get("losses").getAsInt();
				String rank = k.get("rank").getAsString();
				String tier = k.get("tier").getAsString();
				String queueType = k.get("queueType").getAsString();
				int leaguePoints = k.get("leaguePoints").getAsInt();
				String leagueId = k.get("leagueId").getAsString();
				leagueInfo[i] = new LeagueEntrydto(queueType, wins, losses, leagueId, rank, tier, leaguePoints);
				String urlstrL = "https://kr.api.riotgames.com/lol/league/v4/leagues/" + leagueInfo[i].getLeagueId()
						+ "?api_key=" + API_KEY;
				URL urlL = new URL(urlstrL);
				HttpURLConnection urlConnectionL = (HttpURLConnection) urlL.openConnection();
				urlConnectionL.setRequestMethod("GET");
				String resultL = "";
				String lineL;
				brL = new BufferedReader(new InputStreamReader(urlConnectionL.getInputStream()));
				while ((lineL = brL.readLine()) != null) {
					resultL += lineL;
				}
				JsonParser jsonParserL = new JsonParser();
				JsonObject jsonObjectL = (JsonObject) jsonParser.parse(resultL);
				leagueName[i] = jsonObjectL.get("name").getAsString();

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(leagueInfo);
		model.addAttribute("leagueInfo", leagueInfo);
		model.addAttribute("tierImgURL", "img/Emblem_" + leagueInfo[0].getTier() + ".png");
		model.addAttribute("summoner", temp);
		model.addAttribute("leagueName", leagueName);
		model.addAttribute("profileImgURL",
				"http://ddragon.leagueoflegends.com/cdn/11.19.1/img/profileicon/" + temp.getProfileIconId() + ".png");
		return "Result";
	}
}
