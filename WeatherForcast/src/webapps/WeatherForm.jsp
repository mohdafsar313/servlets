<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Enter Weather Information</h3>
        </div>
        <div class="card-body">
            <form method="post" action="weather">
                <div class="mb-3">
                    <label for="placeName" class="form-label">Place Name</label>
                    <input type="text" class="form-control" id="placeName" name="placeName" required>
                </div>

                <div class="mb-3">
                    <label for="weather" class="form-label">Weather</label>
                    <input type="text" class="form-control" id="weather" name="weather" required>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="minTemp" class="form-label">Min Temp (°C)</label>
                        <input type="number" class="form-control" id="minTemp" name="minTemp" step="0.1">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="maxTemp" class="form-label">Max Temp (°C)</label>
                        <input type="number" class="form-control" id="maxTemp" name="maxTemp" step="0.1">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label>Cloudy:</label>
                        <select name="cloudy">
                            <option selected disabled>Select</option>
                            <option value="yes">Yes</option>
                            <option value="no">No</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label>Raining:</label>
                        <select name="raining">
                            <option selected disabled>Select</option>
                            <option value="yes">Yes</option>
                            <option value="no">No</option>
                        </select>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="rainMM" class="form-label">Rain in MM</label>
                    <input type="number" class="form-control" id="rainMM" name="rainMM" step="0.1">
                </div>

                <div class="mb-3">
                    <label for="humidity" class="form-label">Humidity (%)</label>
                    <input type="number" class="form-control" id="humidity" name="humidity" step="0.1">
                </div>

                <div class="mb-3">
                    <label for="windSpeed" class="form-label">Wind Speed (km/h)</label>
                    <input type="number" class="form-control" id="windSpeed" name="windSpeed" step="0.1">
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="sunriseTime" class="form-label">Sunrise Time</label>
                        <input type="time" class="form-control" id="sunriseTime" name="sunriseTime">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="sunsetTime" class="form-label">Sunset Time</label>
                        <input type="time" class="form-control" id="sunsetTime" name="sunsetTime">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="moonRiseTime" class="form-label">Moon Rise Time</label>
                        <input type="time" class="form-control" id="moonRiseTime" name="moonRiseTime">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="moonSetTime" class="form-label">Moon Set Time</label>
                        <input type="time" class="form-control" id="moonSetTime" name="moonSetTime">
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="rainStartTime" class="form-label">Rain Start Time</label>
                        <input type="time" class="form-control" id="rainStartTime" name="rainStartTime">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="rainEndTime" class="form-label">Rain End Time</label>
                        <input type="time" class="form-control" id="rainEndTime" name="rainEndTime">
                    </div>
                </div>

                <div class="mb-4">
                    <label for="precipitation" class="form-label">Precipitation</label>
                    <input type="number" class="form-control" id="precipitation" name="precipitation" step="0.1">
                </div>

                <div class="text-end">
                    <button type="submit" class="btn btn-success">Save Weather Info</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>