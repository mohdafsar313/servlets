<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DONATION</title>
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
<div style="border: 2px solid #000; width: 350px; padding: 20px; margin: 50px auto; border-radius: 10px; font-family: Arial, sans-serif;">
    <center>
        <form action="donation" method="post">

            <div style="margin-bottom: 10px;">
                <label style="display: inline-block; width: 80px;">Name:</label>
                <input type="text" placeholder="Enter the name" name="name" style="width: 200px;">
            </div>

            <div style="margin-bottom: 10px;">
                <label style="display: inline-block; width: 80px;">email:</label>
                <input type="email" placeholder="Enter the email" name="email" style="width: 200px;">
            </div>

            <div style="margin-bottom: 10px;">
                <label style="display: inline-block; width: 80px;">Mobile:</label>
                <input type="tel" placeholder="Enter the mobile number" name="mobile" style="width: 200px;">
            </div>

            <div style="margin-bottom: 15px;">
                <label style="display: inline-block; width: 80px;">Amount:</label>
                <select name="amount" id="amount" style="width: 208px;">
                    <option value="">--Select Size--</option>
                    <option value="small">10000</option>
                    <option value="medium">20000</option>
                    <option value="large">30000</option>
                    <option value="extra_large">50000</option>
                </select>
            </div>

            <input type="submit" value="donate" style="padding: 5px 15px;">
        </form>
    </center>
</div>
</body>
</html>