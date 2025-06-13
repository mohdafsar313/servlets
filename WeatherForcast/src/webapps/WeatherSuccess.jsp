<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather Data Saved</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-body text-center">
            <h2 class="text-success mb-4">${message}</h2>

            <table class="table table-bordered table-striped table-hover">
                <thead class="table-dark">
                <tr>
                    <th>Field</th>
                    <th>Value</th>
                </tr>
                </thead>
                <tbody>
                <tr><td>Place Name</td><td>${info.placeName}</td></tr>
                <tr><td>Weather</td><td>${info.weather}</td></tr>
                <tr><td>Minimum Temperature (°C)</td><td>${info.minTemp}</td></tr>
                <tr><td>Maximum Temperature (°C)</td><td>${info.maxTemp}</td></tr>
                <tr><td>Is Cloudy</td><td>${info.cloudy}</td></tr>
                <tr><td>Is Raining</td><td>${info.raining}</td></tr>
                <tr><td>Rain in MM</td><td>${info.rainInMM}</td></tr>
                <tr><td>Humidity (%)</td><td>${info.humidity}</td></tr>
                <tr><td>Wind Speed (km/h)</td><td>${info.windSpeed}</td></tr>
                <tr><td>Sunrise Time</td><td>${info.sunRiseTime}</td></tr>
                <tr><td>Sunset Time</td><td>${info.sunSetTime}</td></tr>
                <tr><td>Moonrise Time</td><td>${info.moonRiseTime}</td></tr>
                <tr><td>Moonset Time</td><td>${info.moonSetTime}</td></tr>
                <tr><td>Rain Start Time</td><td>${info.rainStartTime}</td></tr>
                <tr><td>Rain End Time</td><td>${info.rainEndTime}</td></tr>
                <tr><td>Precipitation</td><td>${info.precipitation}</td></tr>
                </tbody>
            </table>

            <a href="index.jsp" class="btn btn-primary mt-3">Back to Home</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>