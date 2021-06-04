function deletePlanet(event) {
    let name = event.target.parentElement.parentElement.querySelector('#planetName').textContent;
    fetch("/delete", {
        method: "POST",
        body: JSON.stringify(`${name}`),
        headers: {
            'Content-type': 'application/json'
        }
    }).then(() => {
        location.reload();
    })
}

function updatePlanet() {
    let planetName = document.querySelector('#plname').value;
    let newLordName = document.querySelector('#newlordname').value;
    fetch("/update", {
        method: "POST",
        body: JSON.stringify(`${planetName}|${newLordName}`),
        headers: {
            'Content-type': 'application/json'
        }
    }).then(response => {
        return response.text();}
    ).then(response => {
        if(response === 'success') {
            location.reload();
        } else if(response === 'lordNotFound') {
            let newLordName = document.querySelector('#newlordname');
            newLordName.classList.add('border-2', 'border-danger');
            let text = document.querySelector('#invalidLord');
            text.hidden = false;
        }
        else alert('Error');
            });
}

function showModal(event) {
    let planetName = event.target.parentElement.parentElement.querySelector('#planetName').textContent;
    let lordName = event.target.parentElement.parentElement.querySelector('#lordName').textContent;


    let modal = new bootstrap.Modal(document.getElementById('editModal'), {});
    let m = document.querySelector('#editModal');
    let modalLordName = m.querySelector('#lname');
    let modalPlanetName = m.querySelector('#plname')
    modalLordName.value = lordName;
    modalPlanetName.value = planetName;
    console.log(modalLordName);
    modal.show();
    let close = document.querySelector('#modalhide');
    close.onclick = () => modal.hide();
}

function showPlanetConstructor() {
    let modal = new bootstrap.Modal(document.getElementById('createPlanetModal'), {});
    modal.show();
    let close = document.querySelector('#plModalHide');
    close.onclick = () => modal.hide();
}

function createPlanet() {
    let planetName = document.querySelector('#newPlanetName').value;
    let newLordName = document.querySelector('#addLord').value;

    fetch("/createplanet", {
        method: "POST",
        body: JSON.stringify(`${planetName}|${newLordName}`),
        headers: {
            'Content-type': 'application/json'
        }
    }).then(response => {
        return response.text();}
    ).then(response => {
        if(response === 'success') {
            location.reload();
        }
        else if(response === 'planetIsExists') {
            let planetNameInput = document.querySelector('#newPlanetName');
            planetNameInput.classList.add('border-2', 'border-danger');
            let text = document.querySelector('#invalidPlanetName');
            text.hidden = false;
        } else if(response === 'lordNotFound') {
            let addLord = document.querySelector('#addLord');
            addLord.classList.add('border-2', 'border-danger');
            let text = document.querySelector('#invalidLordName');
            text.hidden = false;
        }
        else alert('Error');
    });
}

function showLordConstructor() {
    let modal = new bootstrap.Modal(document.getElementById('createLord'), {});
    modal.show();
    let close = document.querySelector('#createLordModalHide');
    close.onclick = () => modal.hide();
}

function createLord() {
    let lordName = document.querySelector('#lordName').value;
    let lordAge = document.querySelector(`#lordAge`).value;

    fetch("/createlord", {
        method: "POST",
        body: JSON.stringify(`${lordName}|${lordAge}`),
        headers: {
            'Content-type': 'application/json'
        }
    }).then(response => {
        return response.text();}
    ).then(response => {
        if(response === 'success') {
            location.reload();
        }
        else if(response === 'lordIsExists') {
            let message = document.querySelector('#invalidLord');
            message.hidden = false;
            let addLord = document.querySelector('#lordName');
            addLord.classList.add('border-2', 'border-danger');
        }

        else alert('Error');
    });
}


