let student_form = document.getElementById('student-validation');
console.log(student_form);

student_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {

        let res = await fetch('http://localhost:8080/api/organisation_HR/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({

                organisationHRID: document.getElementById('hr_id').value,
                organisationhr_first_name: document.getElementById('first_name').value,
                organisationhr_last_name: document.getElementById('last_name').value,
                organisationhr_email: document.getElementById('email').value,
                organisationhr_contact_no: document.getElementById('cont_no').value,
                organisationIndex : { organisationIndex : document.getElementById('org_id').value}
            })
        }).then(
            response => {
                console.log(response['formData'])

                if (response['status'] === 200) {
                    document.getElementById("login-success").style.display = "block";
                    document.getElementById("login-alert").style.display = "none";

                } else {
                    document.getElementById("login-alert").style.display = "block";
                    document.getElementById("login-success").style.display = "none";

                }
            }
        );
    } else {
        student_form.classList.add('was-validated');
    }
});