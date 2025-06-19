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
    <a href="index.jsp" class="btn btn-outline-primary rounded-pill shadow-sm px-4">
        ⬅ Home Page
    </a>
</div>

<!-- Main Form Card -->
<div class="container py-5">
    <div class="card shadow-lg rounded-4">
        <div class="card-body p-5">
            <h2 class="text-center text-primary mb-4 fw-bold">
                Provide the details
            </h2>

            <!-- Feedback Messages -->
            <div class="text-center mb-3">
                <span class="text-success fw-semibold">${success}</span>
                <span class="text-danger fw-semibold">${failure}</span>
            </div>

            <!-- Form Starts -->
            <form action="move" method="post" class="row g-4">

                <div class="col-md-6">
                    <label class="form-label fw-medium">Duster Material</label>
                    <input type="text" name="material" class="form-control form-control-lg" required value="${dto.material}">
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-medium">Duster Color</label>
                    <input type="text" name="color" class="form-control form-control-lg" required value="${dto.color}">
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-medium">Manufactured Date</label>
                    <input type="date" name="dateOfManufac" class="form-control form-control-lg" required value="${dto.dateOfManufac}">
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-medium">Duster Cost (₹)</label>
                    <input type="number" name="cost" class="form-control form-control-lg" required value="${dto.cost}">
                </div>

                <div class="col-md-6">
                    <label class="form-label fw-medium">Quantity</label>
                    <input type="number" name="quantity" class="form-control form-control-lg" required value="${dto.quantity}">
                </div>

                <div class="col-md-6 d-flex align-items-center">
                    <div class="form-check mt-3 ms-2">
                        <input type="checkbox" name="isUseful" value="${dto.isUseful}" class="form-check-input" id="isUseful">
                        <label class="form-check-label fw-medium" for="isUseful">Is Useful?</label>
                    </div>
                </div>

                <div class="col-12 text-center mt-4">
                    <input type="submit" value="Submit Details" class="btn btn-success btn-lg px-5 rounded-pill shadow-sm">
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
