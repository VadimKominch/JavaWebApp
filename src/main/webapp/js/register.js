const form = document.getElementsByClassName("register-form")[0];

form.addEventListener("submit",async (e) => {
    e.preventDefault();
    const login = document.querySelector(".login").value;
    const password = document.querySelector(".password").value;
    const passwordConfirmation = document.querySelector(".re-password").value;
    const firstName = document.querySelector(".firstName").value;
    const lastName = document.querySelector(".lastName").value;
    const nickName = document.querySelector(".nickName").value;
    const email = document.querySelector(".email").value;


    const response = await fetch("http://localhost:8090/register", {
        method: "POST",
//        headers: new Headers({'Content-Type': 'multipart/form-data'}),
        body: JSON.stringify({
            login: login,
            password: password,
            firstName: firstName,
            lastName: lastName,
            nickName: nickName,
            email: email
            // add error from frontend
        })
    });
    if (response.redirected) {
        window.location.href = response.url;
    }
});