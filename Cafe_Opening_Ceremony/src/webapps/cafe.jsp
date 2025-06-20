
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cafe Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4">
    <a href="index.jsp" class="btn btn-outline-primary rounded-pill shadow-sm px-4">⬅ Home Page</a>
</div>

<div class="container py-5">
    <div class="card shadow-lg rounded-4">
        <div class="card-body p-5">
            <h2 class="text-center text-success mb-4 fw-bold">Cafe Information Form</h2>

            <!-- Cafe Form -->
            <form action="cafe" method="post">
                <div class="row g-4">

                    <div class="col-md-6">
                        <label class="form-label fw-medium">Cafe Name</label>
                        <input type="text" name="cafeName" class="form-control form-control-lg" required value="${dto.cafeName}">
                    </div>

                    <div class="col-md-6">
                        <label class="form-label fw-medium">Owner Name</label>
                        <input type="text" name="ownerName" class="form-control form-control-lg" required value="${dto.ownerName}">
                    </div>

                    <div class="col-md-6">
                        <label class="form-label fw-medium">Established Date</label>
                        <input type="date" name="establishedDate" class="form-control form-control-lg" required value="${dto.establishedDate}">
                    </div>

                    <div class="col-md-6">
                        <label class="form-label fw-medium">Cuisine Type</label>
                        <input type="text" name="cuisineType" class="form-control form-control-lg" required value="${dto.cuisineType}">
                    </div>

                    <div class="col-md-6 d-flex align-items-center">
                        <div class="form-check ms-2">
                            <input type="checkbox" name="hasWiFi" class="form-check-input" id="hasWiFi" value="true" ${dto.hasWiFi}>
                            <label class="form-check-label fw-medium" for="hasWiFi">Provides Wi-Fi</label>
                        </div>
                    </div>

                    <div class="col-12 text-center mt-4">
                        <input type="submit" value="Submit" class="btn btn-success btn-lg px-5 shadow-sm rounded-pill">
                    </div>

                </div>
            </form>
            <hr class="my-5">
            <h4 class="text-center text-primary fw-bold mb-3">Submitted Cafe Information</h4>
           <!-- <ul class="list-group list-group-flush fs-5">
                <li class="list-group-item"><strong>Cafe Name:</strong> <%= cafeName %></li>
                <li class="list-group-item"><strong>Owner Name:</strong> <%= ownerName %></li>
                <li class="list-group-item"><strong>Established On:</strong> <%= establishedDate %></li>
                <li class="list-group-item"><strong>Cuisine Type:</strong> <%= cuisineType %></li>
                <li class="list-group-item"><strong>Wi-Fi Available:</strong> <%= hasWiFi != null ? "Yes" : "No" %></li>
            </ul>-->
        </div>
    </div>
</div>
<!-- Validation Script -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!--<script>
    $(document).ready(function () {
        $("form").submit(function (e) {
            let isValid = true;

            const cafeName = $("input[name='cafeName']").val().trim();
            if (cafeName.length < 3) {
                alert("Cafe Name must be at least 3 characters.");
                isValid = false;
            }

            const ownerName = $("input[name='ownerName']").val().trim();
            if (ownerName.length < 3) {
                alert("Owner Name must be at least 3 characters.");
                isValid = false;
            }

            const establishedDate = $("input[name='establishedDate']").val().trim();
            if (!establishedDate) {
                alert("Please select the establishment date.");
                isValid = false;
            }

            const cuisineType = $("select[name='cuisineType']").val();
            if (!cuisineType) {
                alert("Please select a cuisine type.");
                isValid = false;
            }

            // WiFi checkbox does not need validation (optional)

            if (!isValid) {
                e.preventDefault(); // Prevent form submission
            }
        });
    });
</script>-->

</body>
</html>
