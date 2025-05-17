<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>donationsuccess</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">X-Workz</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<h1 class="text-center">JSP Application </h1>
<h2 align="center">Thanks for ${message} </h2>
<table class="table table-success" style="border: 2px solid black; border-collapse: collapse; width: 60%; margin: 30px auto; font-size: 14px;">
    <thead>
    <tr>
        <th scope="col" style="border: 1px solid black;">SI.No</th>
        <th scope="col" style="border: 1px solid black;">COMPLAINT NAME</th>
        <th scope="col" style="border: 1px solid black;">DATE OF INCIDENT</th>
        <th scope="col" style="border: 1px solid black;">LOCATION</th>
        <th scope="col" style="border: 1px solid black;">CRIME TYPE</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row" style="border: 1px solid black;">1</th>
        <td style="border: 1px solid black;">${firDto.complaintname}</td>
        <td style="border: 1px solid black;">${firDto.dateofincident}</td>
        <td style="border: 1px solid black;">${firDto.location}</td>
        <td style="border: 1px solid black;">${firDto.crimeType}</td>
    </tr>
    </tbody>
</table>



<div style="position: fixed; bottom: 0; width: 100%; background-color: black; color: white; text-align: center; padding: 10px 0;">
    <footer>&copy; Xworkz Bengaluru</footer>
</div>
</body>
</html>