# RESTful API Integration Projects

This repository contains two distinct projects showcasing the integration of RESTful APIs in Java applications. The first project focuses on audio transcription using Assembly AI, and the second demonstrates the retrieval and calculation of football match data using a Football Data API.

## Project 1: Assembly AI Audio Transcription
### Introduction
This project is a Java application that integrates with the Assembly AI API to transcribe audio files. The application takes an audio file as input, sends it to the Assembly AI service, and retrieves a text transcription of the audio. This project is particularly useful for automating the transcription of recorded audio files, and it demonstrates practical API integration, JSON handling, and asynchronous programming in Java.

### Technologies
1. Java
2. Gson for JSON parsing
3. Java HTTP Client for API requests
### How to Use
-> Place the audio file you wish to transcribe in the designated directory.
-> Run the Java application.
-> The application will upload the audio file to Assembly AI and display the transcription once completed.
### Key Features
1. Audio file uploading to Assembly AI.
2. Retrieval of transcribed text from the API response.
3. Error handling and asynchronous API communication.

## Project 2: Football API - Total Goals by Team
### Introduction
This Java application interacts with a Football Data API to calculate the total number of goals scored by a specific team in a given year. The application queries the API for match data, including both home and away games, and aggregates the total goals scored. This project serves as a practical example of working with REST APIs to fetch and process sports data.

### Technologies
1. Java
2. Gson for JSON parsing
3. Java HTTP Client for API requests
### How to Use
-> Input the name of the football team and the year you are interested in.
-> Run the application.
-> The total number of goals scored by the team in that year's matches, across all competitions, will be displayed.
### Key Features
1. Retrieval of match data from the Football Data API.
2. Calculation of total goals scored by a team both in home and away matches.
3. Handling of API pagination to process multiple pages of data.

## General Notes
Both projects are examples of how to effectively integrate and utilize RESTful APIs in Java applications. They demonstrate data fetching, processing, and real-world application of API data.

For any queries or contributions to these projects, feel free to reach out or submit a pull request.

