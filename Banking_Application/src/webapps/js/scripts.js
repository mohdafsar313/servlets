// Display alert on successful form submission
document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    if (form) {
        form.addEventListener("submit", function () {
            console.log("Form submitted.");
            // Optionally, you can show a loading spinner or disable the button
        });
    }

    // Example interaction: toggle password visibility
    const passwordInput = document.querySelector("input[type='password']");
    const toggleBtn = document.getElementById("togglePassword");

    if (passwordInput && toggleBtn) {
        toggleBtn.addEventListener("click", function () {
            const type = passwordInput.getAttribute("type") === "password" ? "text" : "password";
            passwordInput.setAttribute("type", type);
            this.textContent = type === "password" ? "Show" : "Hide";
        });
    }
});
