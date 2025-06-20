

document.addEventListener("DOMContentLoaded", function () {

    const cafeNameInput = document.getElementsByName("material")[0];
    const ownerNameInput = document.getElementsByName("color")[0];
    const form = document.querySelector("cafe");


    form.addEventListener("submit", function (event) {
        if (ownerNameInput.value.trim() === "") {
            alert("name cannot be empty!");
            event.preventDefault();
            return;
        }
        if (cafeNameInput.value === "") {
            alert("cafe name must be mentioned");
            event.preventDefault();
            return;
        }


    });
});
