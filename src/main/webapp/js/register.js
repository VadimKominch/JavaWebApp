const form = document.getElementsByClassName("register-form")[0];

form.addEventListener("submit",async (e) {
    e.preventDefault();
    const login = document.querySelector(".login").value;
    const password = document.querySelector(".password").value;
    const passwordConfirmation = document.querySelector(".re-password").value;
    const firstName = document.querySelector(".firstName").value;
    const lastName = document.querySelector(".lastName").value;
    const nickName = document.querySelector(".nickName").value;
    const email = document.querySelector(".email").value;


    await fetch("localhost:8090/register", {
        method: "POST",
        body: JSON:stringify({
            login: login,
            password: password,
            firstName: firstName,
            lastName: lastName,
            nickName: nickName,
            email: email
            // add error from frontend
        })
    });
});