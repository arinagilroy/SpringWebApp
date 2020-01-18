let showUsers = document.querySelector('.show-button');

showUsers.addEventListener("click", () => {
    let nom = prompt('Say empNo', '');
    let name = prompt('Say empName', '');
    let token = document.querySelector('meta[name="_csrf"]').content;
    fetch(
        '/employee',
        {

            method: 'POST',
            headers: {'Content-Type': 'application/json',
                'X-Requested-With': 'XMLHttpRequest',
                'X-CSRF-Token': token},
            body: JSON.stringify({empNo: nom, empName: name}),
            credentials: "same-origin",
        }
    ).then(data => {
        console.log(data);
        return data.json();
    })
        .then(data => {
            console.log(data)
        })
});