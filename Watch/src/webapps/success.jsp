<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Watch Submission Success</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="alert alert-success text-center">
        <h4 class="alert-heading">${message}</h4>
    </div>

    <h3 class="mb-4">Watch Details</h3>
    <table class="table table-bordered table-hover">
        <tbody>
        <tr>
            <td><strong>Brand</strong></td>
            <td>${details.brand}</td>
        </tr>
        <tr>
            <td><strong>Model</strong></td>
            <td>${details.model}</td>
        </tr>
        <tr>
            <td><strong>Price</strong></td>
            <td>${details.price}</td>
        </tr>
        <tr>
            <td><strong>Manufacture Date</strong></td>
            <td>${details.manufactureDate}</td>
        </tr>
        <tr>
            <td><strong>Smart</strong></td>
            <td>${details.isSmart}</td>
        </tr>
        <tr>
            <td><strong>Warranty (Years)</strong></td>
            <td>${details.warrantyYears}</td>
        </tr>
        </tbody>
    </table>

    <div class="mt-4">
        <a href="form.jsp" class="btn btn-primary">Submit Another</a>
        <a href="index.jsp" class="btn btn-secondary">Back to Home</a>
    </div>
</div>

</body>
</html>
