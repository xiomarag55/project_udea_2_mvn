function obtainPersons() {
    fetch('http://localhost:8080/eldercare/persons/mainInfo', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const result = document.getElementById('result');
            result.innerHTML = '';

            data.forEach(person => {
                const fila = document.createElement('tr');
                fila.innerHTML = `
                    <td>${person.name}</td>
                    <td>${person.age}</td>
                    <td>${person.identityDocument}</td>
                    <td>${person.maritalStatus}</td>
                    <td>${person.stratum}</td>
                    <td>${person.isPension}</td>
                    <td>${person.sex}</td>
                `;
                result.appendChild(fila);
                const listarBtn = document.getElementById('listarBtn');
                if(listarBtn ){
                    listarBtn .style.display = 'none';
                }
            });
        })
        .catch(error => console.error('Error:', error));
}
//1
function totalPersonsInSituationVulnerability() {
    fetch('http://localhost:8080/eldercare/persons/vulnerability', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('vulnerabilityPerson');
            valorElement.textContent = data;
        })
        .catch(error => console.error('Error:', error));
}
//2
function numberPensioners() {
    fetch('http://localhost:8080/eldercare/persons/personPensioners', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('pensioners');
            valorElement.textContent = data;
        })
        .catch(error => console.error('Error:', error));
}
//3
function numberNonePensioners() {
    fetch('http://localhost:8080/eldercare/persons/nonePensioners', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('nonPensioners');
            valorElement.textContent = data;
        })
        .catch(error => console.error('Error:', error));
}
//4
function numberPensionersOveSixty() {
    fetch('http://localhost:8080/eldercare/persons/womenPensioners', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('overSixty');
            valorElement.textContent = data;
        })
        .catch(error => console.error('Error:', error));
}
//5
function numberWomenPensioners() {
    fetch('http://localhost:8080/eldercare/persons/womenNonePensioners', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('womenPensioners');
            valorElement.textContent = data;
        })
        .catch(error => console.error('Error:', error));
}
//6
function numberWomenNonPensioners() {
    fetch('http://localhost:8080/eldercare/persons/womenNonePensioners', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('womenNonPensioners');
            valorElement.textContent = data;
        })
        .catch(error => console.error('Error:', error));
}
//7
function percentPensioners() {
    fetch('http://localhost:8080/eldercare/persons/percentPensioners', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('percentPensioners');
            valorElement.textContent = `${data}%`;
        })
        .catch(error => console.error('Error:', error));
}
//8
function percentNonPensioners() {
    fetch('http://localhost:8080/eldercare/persons/percentNonePensioners', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('percentNonPensioners');
            valorElement.textContent = `${data}%`;
        })
        .catch(error => console.error('Error:', error));
}
