const form = document.getElementsByClassName("form")[0];
const nickName = document.getElementById("nickName");
const id = document.getElementsByClassName("user-id")[0].value;

form.addEventListener("submit",async (e)=>{
    e.preventDefault();
    const response = await fetch("http://localhost:8090/edit_usr", {
            method: "POST",
            body: JSON.stringify({
                id: id,
                nickName: nickName.value
            })
        });
        if (response.redirected) {
            window.location.href = response.url;
        }
});