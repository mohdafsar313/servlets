<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>weather</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg bg-warning">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Ministry of Road Transport & Highways</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                    </li>




                </ul>
                </li>

                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

</header>
<div align="center">
    <h2>AccuWeather</h2>

    <h6 style="color:red"> ${message}</h6>
    <form action="Wea" method="Post">
        Place Name:<input type="text" name="plname"><br><br>
        Weather:<input type="text" name="wename"><br><br>
        MinTemp:<input type="degree" name="miname"><br><br>
        MaxTemp:<input type="degree" name="maname"><br><br>
        Cloudy:<input type="text" name="clname"><br><br>
        Raining:<input type="text" name="raname"><br><br>
        Rain in MM:<input type="int" name="rainame"><br><br>
        Humidity:<input type="int" name="huname"><br><br>
        WindSpeed:<input type="int" name="winame"><br><br>
        SunRiseTime:<input type="time" name="suname"><br><br>
        SunSetTime:<input type="time" name="sunname"><br><br>
        MoonRiseTime:<input type="time" name="moname"><br><br>
        MoonSetTime:<input type="time" name="mooname"><br><br>
        RainStartTime:<input type="time" name="tiname"><br><br>
        RainEndTime:<input type="time" name="timname"><br><br>
        Precipitation:<input type="text" name="precname"><br><br>



        <input type="submit" class="btn btn-primary" value="Submit Weather Forecast"><br><br>


    </form>
</div>

</body>
</html>