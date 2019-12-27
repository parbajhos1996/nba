package service;


import java.io.*;
import java.util.*;

import controller.StatType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StatisticsService {

    private static final String URL_PREFIX = "https://www.teamrankings.com/nba/trends/ats_trends/?sc=";

    public Double getPercentageForTeam(String teamName, List<StatType> statTypes) {
        Double sum = statTypes.stream()
                .mapToDouble(statType -> readStat(teamName, statType))
                .sum();
        return sum / statTypes.size();
    }

    public Double readStat(String teamName, StatType statType) {
        Document document = null;
        try {
            document = Jsoup.connect(URL_PREFIX + statType.getValue()).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.select(".datatable > tbody > tr > td.nowrap > a");
        List<String> teams = elements.eachText();
        Element percentage = document.selectFirst(".datatable > tbody > tr:nth-child(" + (teams.indexOf(teamName) + 1) + ") > td:nth-child(3)");
        return Double.parseDouble(percentage.text().replace("%", ""));
    }
}
