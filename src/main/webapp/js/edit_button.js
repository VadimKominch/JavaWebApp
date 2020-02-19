const editButton = document.querySelectorAll(".fa-edit");
const deleteButton = document.querySelectorAll(".fa-close");
const openButton = document.querySelector("#create_ads_button");
const saveButton = document.querySelector(".btn.btn-primary.save-button");
const form = document.getElementById("hidden_form");
//add XHR to delete
const modal = document.getElementById("exampleModal");
const modalTitle = modal.querySelector(".modal-title");
console.log(editButton.length);
console.log(deleteButton.length);

editButton.forEach((btn)=>{
    const closestDiv = btn.closest('div');
    btn.addEventListener("click",function(e) {
    modalTitle.innerHTML = "Edit ads";
    const id = closestDiv.querySelector(".ads_id").value;
    const name =  closestDiv.querySelector(".blog-post-title").innerHTML;
    const text = closestDiv.querySelector(".text-break").innerHTML;
    const category = closestDiv.querySelector(".badge.badge-info").innerHTML;
    document.getElementById("Category").value = category;
    document.getElementById("name").value = name;
    document.getElementById("text").innerHTML = text;
    saveButton.innerHTML = "Edit";
    form.querySelector(".ads_id").value = id;
    form.action = "edit_adv";
    });
});

openButton.addEventListener("click",function(e) {
        modalTitle.innerHTML = "New advertisment";
        document.getElementById("Category").value = "Select1";
        document.getElementById("name").value = "";
        document.getElementById("text").innerHTML = "";
        saveButton.innerHTML = "Save";
        form.action = "add_adv";
});

deleteButton.forEach((btn)=>{
    const closestDiv = btn.closest('div');
    btn.addEventListener("click",function(e) {
    const id = closestDiv.querySelector(".ads_id").value;
    var xhr = new XMLHttpRequest();
     xhr.open('POST', 'http://localhost:8080/finalproject/delete_adv', true);
     xhr.send(id);
    });
});

