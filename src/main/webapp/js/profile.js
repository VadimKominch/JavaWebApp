const button = document.getElementsByClassName("open-modal-cls")[0];
const form = document.getElementsByClassName("ads-form")[0];
const categorySelect = document.getElementById("category");

button.addEventListener("click",async (e)=> {
 const rawResult = await fetch("http://localhost:8090/categories");
 const elements = await rawResult.json();
 console.log(elements);
 elements.forEach((el,i) => {
      const element = document.createElement('option');
      if(i == 0) element.selected = true;
      element.text = el.name;
      element.value = el.id;
      categorySelect.appendChild(element);})
});

form.addEventListener("submit",async (e)=> {
    e.preventDefault();
    const body = JSON.stringify({
       title: document.getElementById("name").value,
       body: document.getElementById("text").value,
       categoryId: categorySelect.options[categorySelect.selectedIndex].value
       // add error from frontend
    });
    await fetch("http://localhost:8090/advertisement", {
      method: "POST",
//      headers: new Headers({'Content-Type': 'application/json'}),
      body: body
  });
  $('#exampleModal').modal('hide');

});

