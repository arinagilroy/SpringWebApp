let showUsers = document.querySelector('.show-button');

showUsers.addEventListener("click", () => {
    let nom = prompt('Say empNo', '');
    let name = prompt('Say empName', '');
    fetch(
        '/employee',
        {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ empNo: nom, empName: name })
        }
    ).then(data => {
        console.log(data);
        return data.json();
    })
        .then(data => {
            console.log(data)
        })
});