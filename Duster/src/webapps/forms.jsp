<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Duster Information Collector</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div><button><a href="index.jsp">home page</a></button></div>

<div class="container py-5">
    <h2 class="text-center text-primary mb-4">Wanna add your duster to our selling website?
        Give details of your duster</h2>

    <span style="color:green;">${success}</span>
    <span style="color:red;">${failure}</span>

    <form action="move" method="post" class="row g-3">

        <div class="col-md-6">
            <label class="form-label">Duster Material</label>
            <input type="text" name="material" class="form-control" required value="${dto.material}">
        </div>

        <div class="col-md-6">
            <label class="form-label">Duster Color</label>
            <input type="text" name="color" class="form-control" required
                   value="${dto.color}">
        </div>

        <div class="col-md-6">
            <label class="form-label">Manufactured date</label>
            <input type="date" name="dateOfManufac" class="form-control" required  value="${dto.dateOfManufac}">
        </div>

        <div class="col-md-6">
            <label class="form-label">Duster Cost</label>
            <input type="number" name="cost" class="form-control" required value="${dto.cost}">
        </div>

        <div class="col-md-6">
            <label class="form-label">Quantity</label>
            <input type="number" name="quantity" class="form-control" value="${dto.quantity}">
        </div>

        <div class="col-md-6">
            <div class="form-check mt-4">
                <input type="checkbox" name="isUseful" value="${dto.isUseful}" class="form-check-input" id="isUseful">
                <label class="form-check-label" for="isUseful">Is Useful?</label>
            </div>
        </div>


        <div class="col-12 text-center mt-4">
            <input type="submit" value="Check" class="btn btn-success btn-lg px-5">
        </div>

    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        $("form").submit(function (e) {
            let isValid = true;

            const material = $("input[name='material']").val().trim();
            if (material.length < 3) {
                alert("Material must be at least 3 characters.");
                isValid = false;
            }

            const color = $("input[name='color']").val().trim();
            if (color.length < 3) {
                alert("Color must be at least 3 characters.");
                isValid = false;
            }

            const cost = $("input[name='cost']").val().trim();
            if (cost === "" || parseInt(cost) <= 0) {
                alert("Cost must be a positive number.");
                isValid = false;
            }

            const date = $("input[name='dateOfManufac']").val().trim();
            if (!date) {
                alert("Please select a manufacture date.");
                isValid = false;
            }

            const quantity = $("input[name='quantity']").val().trim();
            if (quantity === "" || parseInt(quantity) < 1) {
                alert("Quantity must be at least 1.");
                isValid = false;
            }

            if (!isValid) {
                e.preventDefault();
            }
        });
    });
</script>
</body>
</html>