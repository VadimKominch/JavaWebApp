const txtMessage = document.getElementsByClassName("txt-message")[0];
const sendButton = document.getElementsByClassName("btn-primary")[0];
const idElement = document.getElementsByClassName("conv-id")[0];
const senderIdElement = document.getElementsByClassName("sender-id")[0];


sendButton.addEventListener("click", async ()=> {
    const messages = document.getElementsByClassName("messages")[0];
    const input = txtMessage.value.trim();
    const convId = idElement.value;
    const senderId = senderIdElement.value;
    if(input.length != 0) {
        response = await fetch("http://localhost:8090/message", {
            method: "POST",
            body: JSON.stringify({
                conversationId: convId,
                message: input,
                senderId: senderId
            })
        });
        txtMessage.value = "";
        messages.appendChild(createMessageElement({senderId: senderId, message: input}));
    }
});

function createMessageElement(messageObj) {
    const senderId = senderIdElement.value;
    const div = document.createElement("div");
    div.classList.add("message");
    const p = document.createElement("p");
    let messageClass;
    if(messageObj.senderId == senderId) {
        messageClass = "outgoing";
    } else {
        messageClass = "incoming";
    }
    p.classList.add(messageClass);
    p.innerText = messageObj.message;
    div.appendChild(p);
    return div;
}

const SECOND_TO_WAIT = 10;

function updateMessageHistory() {
    const convId = idElement.value;
    const nowTime = new Date();
    const beforeTime = new Date(nowTime - SECOND_TO_WAIT * 1000);

    fetch("http://localhost:8090/message-history", {
            method: "POST",
            body: JSON.stringify({
                convId: convId,
                startTime: beforeTime.getTime(),
                endTime: nowTime.getTime()
            })
        })
        .then(response => response.json())
        .then(messages => messages.map(el => createMessageElement(el)))
        .then(elements => elements.forEach(el => document.getElementsByClassName("messages")[0].appendChild(el)));
}

setInterval(updateMessageHistory,SECOND_TO_WAIT * 1000);