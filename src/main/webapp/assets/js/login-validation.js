let login_form = document.getElementById('login-validation');
login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

    if(login_form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        e=document.getElementById('email').value;
        p=document.getElementById('password').value;
        console.log(e);
        console.log(p);
        let response = await fetch('http://localhost:8080/api/employee/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                employee_email: document.getElementById('email').value,
                employee_pass : document.getElementById('password').value

            })
        });
        let result = await response;
        console.log(result);
        if(result['status'] === 202){
            let data = response.json();
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";
            location.href = "buttons.html";
        }else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("login-alert").style.display = "block";
        }
    }
});