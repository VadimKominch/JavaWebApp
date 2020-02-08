let login = document.querySelector(".login");
let password = document.querySelector(".password");
let form = document.querySelector(".form");
let button = document.querySelector(".button");

//button.addEventListener("click",function(e){
//     e.preventDefault();
//     checkLogin(login);
//     checkPassword(password);
//     if(checkLogin(login) && checkPassword(password)) {
//     form.submit();
//     }
//});

login.addEventListener("keydown",function(e){
    //e.preventDefault();
    if(login.value.length < 8) {
        console.log("Not enough");
    }
});


function checkLogin(login) {
    if(login.length < 8) {
        return false;
    }
    return true;
}

function checkPassword(password) {
    if(password.value.length < 8) {
        return false;
    }
    return true;
}