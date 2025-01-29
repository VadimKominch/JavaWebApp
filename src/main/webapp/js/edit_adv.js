const form = document.getElementsByClassName("ads-form")[0];
const categorySelect = document.getElementsByClassName("category-select")[0];

form.addEventListener("submit",async (e) => {
    e.preventDefault();
    const id = document.querySelector(".id-input").value;
    const title = document.querySelector(".title").value;
    const body = document.querySelector(".body").value;
    const categoryId = categorySelect.options[categorySelect.selectedIndex].value;


    const response = await fetch("http://localhost:8090/edit_adv", {
        method: "POST",
        body: JSON.stringify({
            adsId: id,
            title: title,
            body: body,
            categoryId: categoryId
        })
    });
    if (response.redirected) {
        window.location.href = response.url;
    }
});