async function fetch_data(){

    //alert("Continue");
    let response = await fetch('http://localhost:8080/api/organisation_HR/get');
    let result = await response.json();
    console.log(result);

    let table_data = document.getElementById('myTable');
    table_data.innerHTML = '';

    for (let i = 0; i < result.length; i++) {
        let tr_data = document.createElement('tr');
        tr_data.innerHTML=  '<td>'+result[i]['organisationHRIndex']+'</td>\n'+
            '               <td>'+result[i]['organisationHRID']+'</td>\n'+
            '               <td>'+result[i]['organisationhr_first_name']+'</td>\n'+
            '               <td>'+result[i]['organisationhr_last_name']+'</td>\n'+
            '               <td>'+result[i]['organisationhr_email']+'</td>\n'+
            '               <td>'+result[i]['organisationhr_contact_no']+'</td>\n' +
            '               <td>'+result[i]['organisationIndex']['organisationName']+'</td>\n'
        table_data.appendChild(tr_data);

    }

}