package barqsoft.footballscores.data;

import java.io.IOException;

import barqsoft.footballscores.model.GetTeamInformationResponse;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;


public class FootballDataService {

    FootballDataApi mApi;

    private interface FootballDataApi {
        @GET("/v1/teams/{team_id}")
        Call<GetTeamInformationResponse> getTeamInformation(
                @Header("X-Auth-Token") String apiKey,
                @Path("team_id") String teamId
        );
    }

    public FootballDataService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        mApi = retrofit.create(FootballDataApi.class);
    }

    public GetTeamInformationResponse getTeamInformation(String apiKey, String teamId) throws IOException {
        return mApi.getTeamInformation(apiKey, teamId).execute().body();
    }

}
