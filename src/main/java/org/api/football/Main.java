package org.api.football;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome Please Enter the Name of the Team");
        String teamName = sc.nextLine();
        System.out.println("Please Enter the Year:");
        int year = sc.nextInt();
        getTotalGoals(teamName, year);
    }
    public static void getTotalGoals(String teamName, int year) throws URISyntaxException, IOException, InterruptedException {
        teamName = URLEncoder.encode(teamName, StandardCharsets.UTF_8);
        int currentHomePage = 1;
        int currentAwayPage = 1;
        Gson gson = new Gson();
        String baseUrl = "https://jsonmock.hackerrank.com/api/football_matches";
        String urlHome = baseUrl + "?year=" + year + "&team1=" + teamName + "&page=" + currentHomePage;
        System.out.println(urlHome);
        String urlAway = baseUrl + "?year=" + year + "&team2=" + teamName + "&page=" + currentAwayPage;
        System.out.println(urlAway);
        String jsonResponseHome = getRequestMaker(urlHome);
        String jsonResponseAway = getRequestMaker(urlAway);

        ApiData apiDataHome = gson.fromJson(jsonResponseHome, ApiData.class);
        ApiData apiDataAway = gson.fromJson(jsonResponseAway, ApiData.class);

        int totalHomePages = apiDataHome.getTotal_pages();
        System.out.println("Total Home Pages = "+totalHomePages);
        int totalAwayPages = apiDataAway.getTotal_pages();
        System.out.println("Total Away Pages = "+totalAwayPages);
        int totalGoals = 0;

        while(currentHomePage <= totalHomePages){
            for(Match match : apiDataHome.getData()){
                //System.out.println("Match Data"+apiDataHome.getData());
                totalGoals += match.getTeam1goals();
            }

            if(currentHomePage < totalHomePages){
                currentHomePage++;
                System.out.println("TotalHomePages are more than 1 page, Calling getRequestMaker.....");
                String newUrl = baseUrl + "?year=" + year + "&team1=" + teamName + "&page=" + currentHomePage;
                apiDataHome = gson.fromJson(getRequestMaker(newUrl), ApiData.class);
            }
            else{
                System.out.println("CurrentHomePages and TotalHomePages are equal. Breaking out...");
                break;
            }
        }
        while(currentAwayPage <= totalAwayPages){
            for(Match match : apiDataAway.getData()){
                totalGoals += match.getTeam2goals();
            }

            if(currentAwayPage < totalAwayPages){
                currentAwayPage++;
                System.out.println("TotalAwayPages are more than 1 page, Calling getRequestMaker.....");
                String newUrl = baseUrl + "?year=" + year + "&team1=" + teamName + "&page=" + currentHomePage;
                apiDataAway = gson.fromJson(getRequestMaker(newUrl), ApiData.class);
            }
            else{
                System.out.println("CurrentAwayPages and TotalAwayPages are equal. Breaking out...");
                break;
            }
        }

        System.out.println("Total Goals Scored by "+teamName+" in the year "+year+" = "+totalGoals);
    }
    public static String getRequestMaker(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
        return httpResponse.body();
    }
}
