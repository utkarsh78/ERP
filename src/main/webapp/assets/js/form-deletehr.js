let delete_form = document.getElementById('student-validation');
console.log(delete_form);
delete_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (delete_form.checkValidity() === true) {
        let response = await fetch('http://localhost:8080/api/organisation_HR/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                organisationHRID: document.getElementById('hr_id').value,
            })
        });
        let result = await response;
        console.log(result);
    }
    delete_form.classList.add('was-validated');
});