let timer = document.querySelector("#timer");

function showTime(){
    let time = new Date();
    let hours = ('0'+time.getHours()).slice(-2);
    let minutes = ('0'+time.getMinutes()).slice(-2);
    let seconds = ('0'+time.getSeconds()).slice(-2);
    let text_time = hours+":"+minutes+":"+seconds;
    timer.innerHTML = text_time;
    document.body.style.backgroundColor = "#"+hours+minutes+seconds;
    setTimeout(showTime,1000);
}

document.addEventListener("click",function(){
alert("Clicked!");

});

showTime();