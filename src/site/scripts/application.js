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
            });
        })
        .catch(error => console.error('Error:', error));
}
function totalPersonsInSituationVulnerability() {
    fetch('http://localhost:8080/eldercare/persons/vulnerability', {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            const valorElement = document.getElementById('vulerabilityPerson');
            valorElement.textContent = data;
        })
        .catch(error => console.error('Error:', error));
}
