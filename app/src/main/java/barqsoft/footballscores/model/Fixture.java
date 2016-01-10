package barqsoft.footballscores.model;

import android.content.ContentResolver;
import android.content.ContentValues;

import barqsoft.footballscores.data.FootballScoresProvider;

public class Fixture {

    public static void masterSave(
            ContentResolver contentResolver, String id, String date, String time,
            String homeTeamId, String homeTeamName, String homeTeamGoals,
            String awayTeamId, String awayTeamName, String awayTeamGoals, String leagueId, String matchDay) {

        ContentValues fixtureValues = new ContentValues();
        fixtureValues.put(DatabaseContract.FixturesTable.MATCH_ID, id);
        fixtureValues.put(DatabaseContract.FixturesTable.DATE_COL, date);
        fixtureValues.put(DatabaseContract.FixturesTable.TIME_COL, time);
        fixtureValues.put(DatabaseContract.FixturesTable.HOME_ID_COL, homeTeamId);
        fixtureValues.put(DatabaseContract.FixturesTable.HOME_NAME_COL, homeTeamName);
        fixtureValues.put(DatabaseContract.FixturesTable.HOME_GOALS_COL, homeTeamGoals);
        fixtureValues.put(DatabaseContract.FixturesTable.AWAY_ID_COL, awayTeamId);
        fixtureValues.put(DatabaseContract.FixturesTable.AWAY_NAME_COL, awayTeamName);
        fixtureValues.put(DatabaseContract.FixturesTable.AWAY_GOALS_COL, awayTeamGoals);
        fixtureValues.put(DatabaseContract.FixturesTable.LEAGUE_COL, leagueId);
        fixtureValues.put(DatabaseContract.FixturesTable.MATCH_DAY, matchDay);

        contentResolver.insert(FootballScoresProvider.FIXTURES_URI, fixtureValues);

    }

}
