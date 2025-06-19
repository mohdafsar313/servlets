

document.addEventListener("DOMContentLoaded", function () {

    const materialInput = document.getElementsByName("material")[0];
    const colorInput = document.getElementsByName("color")[0];
    const costInput = document.getElementsByName("cost")[0];
    const form = document.querySelector("form");


    form.addEventListener("submit", function (event) {
        if (materialInput.value.trim() === "") {
            alert("Material cannot be empty!");
            event.preventDefault();
            return;
        }
        if (costInput.value <= 0) {
            alert("Cost must be greater than 0!");
            event.preventDefault();
            return;
        }


    });
});
