package controller;

import java.net.*;
import java.text.*;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import service.StatisticsService;

public class MainController implements Initializable {

    private final StatisticsService statisticsService = new StatisticsService();

    @FXML
    private TextField homeTeam;

    @FXML
    private TextField awayTeam;

    @FXML
    private ChoiceBox<String> homeFavOrDog;

    @FXML
    private ChoiceBox<String> homeRest;

    @FXML
    private ChoiceBox<String> awayRest;

    @FXML
    private ChoiceBox<String> homeRestStatus;

    @FXML
    private ChoiceBox<String> isConference;

    @FXML
    private ChoiceBox<String> isDivision;

    @FXML
    private ChoiceBox<String> homeLastMatch;

    @FXML
    private ChoiceBox<String> awayLastMatch;

    @FXML
    private Text homeTeamPercentage;

    @FXML
    private Text awayTeamPercentage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void onSubmitAction() {
        Double homeTeamAvg = statisticsService.getPercentageForTeam(homeTeam.getText(), createHomeTeamStatTypes());
        Double awayTeamAvg = statisticsService.getPercentageForTeam(awayTeam.getText(), createAwayTeamStatTypes());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        homeTeamPercentage.setText(decimalFormat.format(homeTeamAvg) + "%");
        awayTeamPercentage.setText(decimalFormat.format(awayTeamAvg) + "%");
        System.out.println(decimalFormat.format(homeTeamAvg));
        System.out.println(decimalFormat.format(awayTeamAvg));
    }

    private List<StatType> createHomeTeamStatTypes() {
        List<StatType> result = new LinkedList<>();
        result.add(StatType.ALL_GAMES);
        result.add(StatType.HOME);
        if (homeFavOrDog.getValue().equals("Home favorite")) {
            result.add(StatType.FAVORITE);
            result.add(StatType.HOME_FAVORITE);
        } else {
            result.add(StatType.UNDERDOG);
            result.add(StatType.HOME_UNDERDOG);
        }
        switch (homeRest.getValue()) {
            case "No Rest":
                result.add(StatType.NO_REST);
                break;
            case "1 Day":
                result.add(StatType.ONE_DAY_OFF);
                break;
            case "2-3 Days":
                result.add(StatType.TWO_THREE_DAYS_OFF);
                break;
            case "4+ Days":
                result.add(StatType.FOUR_PLUS_DAYS_OFF);
                break;
        }
        switch (homeRestStatus.getValue()) {
            case "Equal":
                result.add(StatType.EQUAL_REST);
                break;
            case "Advantage":
                result.add(StatType.REST_ADVANTAGE);
                break;
            case "Disadvantage":
                result.add(StatType.REST_DISADVANTAGE);
                break;
        }
        if (isConference.getValue().equals("Conference")) {
            result.add(StatType.CONFERENCE);
        } else {
            result.add(StatType.NON_CONFERENCE);
        }
        if (isDivision.getValue().equals("Division")) {
            result.add(StatType.DIVISION);
        } else {
            result.add(StatType.NON_DIVISION);
        }
        if (homeLastMatch.getValue().equals("Win")) {
            result.add(StatType.AFTER_WIN);
        } else {
            result.add(StatType.AFTER_LOSS);
        }

        return result;
    }

    private List<StatType> createAwayTeamStatTypes() {
        List<StatType> result = new LinkedList<>();
        result.add(StatType.ALL_GAMES);
        result.add(StatType.AWAY);
        if (homeFavOrDog.getValue().equals("Home favorite")) {
            result.add(StatType.UNDERDOG);
            result.add(StatType.AWAY_UNDERDOG);
        } else {
            result.add(StatType.FAVORITE);
            result.add(StatType.AWAY_FAVORITE);
        }
        switch (awayRest.getValue()) {
            case "No Rest":
                result.add(StatType.NO_REST);
                break;
            case "1 Day":
                result.add(StatType.ONE_DAY_OFF);
                break;
            case "2-3 Days":
                result.add(StatType.TWO_THREE_DAYS_OFF);
                break;
            case "4+ Days":
                result.add(StatType.FOUR_PLUS_DAYS_OFF);
                break;
        }
        switch (homeRestStatus.getValue()) {
            case "Equal":
                result.add(StatType.EQUAL_REST);
                break;
            case "Advantage":
                result.add(StatType.REST_DISADVANTAGE);
                break;
            case "Disadvantage":
                result.add(StatType.REST_ADVANTAGE);
                break;
        }
        if (isConference.getValue().equals("Conference")) {
            result.add(StatType.CONFERENCE);
        } else {
            result.add(StatType.NON_CONFERENCE);
        }
        if (isDivision.getValue().equals("Division")) {
            result.add(StatType.DIVISION);
        } else {
            result.add(StatType.NON_DIVISION);
        }
        if (awayLastMatch.getValue().equals("Win")) {
            result.add(StatType.AFTER_WIN);
        } else {
            result.add(StatType.AFTER_LOSS);
        }

        return result;
    }

}

