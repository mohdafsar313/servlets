<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Watch Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Watch Store</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                    </li>
                </ul>

                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-light" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    <script>
        function validateWatchForm() {
            const brand = document.forms["watchForm"]["brand"].value.trim();
            const model = document.forms["watchForm"]["model"].value.trim();
            const price = document.forms["watchForm"]["price"].value;
            const manufactureDate = document.forms["watchForm"]["manufactureDate"].value;
            const isSmart = document.forms["watchForm"]["isSmart"].value.trim();
            const warrantyYears = document.forms["watchForm"]["warrantyYears"].value;

            const priceValue = parseFloat(price);
            const warranty = parseInt(warrantyYears, 10);

            if (brand.length < 2) {
                alert("Brand must be at least 2 characters.");
                return false;
            }
            if (model.length < 2) {
                alert("Model must be at least 2 characters.");
                return false;
            }
            if (isNaN(priceValue) || priceValue <= 0) {
                alert("Please enter a valid price.");
                return false;
            }
            if (manufactureDate === "") {
                alert("Please select a manufacture date.");
                return false;
            }
            if (isSmart.toLowerCase() !== "yes" && isSmart.toLowerCase() !== "no") {
                alert("Please enter 'yes' or 'no' for isSmart.");
                return false;
            }
            if (isNaN(warranty) || warranty < 0) {
                alert("Please enter a valid warranty period.");
                return false;
            }
            return true;
        }
    </script>

</header>

<div align="center">
    <h2>Watch Registration</h2>
    <h6 style="color:red">${message}</h6>

    <form action="WatchServlet" method="post">
        Watch Brand: <input type="text" name="brand" required><br><br>
        Model Name: <input type="text" name="model" required><br><br>
        Price (INR): <input type="number" name="price" required><br><br>
        Manufacture Date: <input type="date" name="mfgDate" required><br><br>
        Is Smart Watch?:
        <input type="radio" name="smart" value="Yes" required> Yes
        <input type="radio" name="smart" value="No" required> No<br><br>
        Warranty Period (Years): <input type="number" name="warranty" required><br><br>

        <input type="submit" class="btn btn-primary" value="Register Watch"><br><br>
    </form>
</div>

</body>
</html>
