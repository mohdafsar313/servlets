<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Duster Information Collector</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- Home Button -->
<div class="container mt-4">
    <a href="index.jsp" class="btn btn-outline-primary rounded-pill shadow-sm px-4">Home Page
    </a>
</div>

<!-- Main Form Section -->
<div class="container py-5">
    <div class="card shadow rounded-4">
        <div class="card-body p-5">

            <h2 class="text-center text-primary mb-4 fw-bold">Search Duster Details</h2>

            <form action="search" method="get" class="row g-4 justify-content-center">

                <div class="col-md-6">
                    <label for="dusterId" class="form-label fw-medium">Duster ID</label>
                    <input type="text" name="dusterId" id="dusterId" class="form-control form-control-lg" required placeholder="Enter Duster ID">
                </div>

                <div class="col-12 text-center mt-3">
                    <input type="submit" value="Search" class="btn btn-success btn-lg px-5 rounded-pill shadow-sm">
                </div>

            </form>

        </div>
    </div>
</div>

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</body>
</html>
