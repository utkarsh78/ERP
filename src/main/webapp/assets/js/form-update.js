let student_form = document.getElementById('student-validation');
let id = document.getElementById("id").value;

console.log(student_form);

student_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {

        let response = await fetch('http://localhost:8080/api/organisation/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({

                organisationID: document.getElementById('id').value,
                organisationName : document.getElementById('org_name').value,
                organisationAddress: document.getElementById('org_address').value
                
            })
        }).then(
            response => {

                if (response['status'] === 202) {
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