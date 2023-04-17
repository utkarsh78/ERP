async function fetch_data(){

    //alert("Continue");
    let response = await fetch('http://localhost:8080/api/organisation/get');
    let result = await response.json();
    console.log(result);

    let table_data = document.getElementById('myTable');
    table_data.innerHTML = '';

    for (let i = 0; i < result.length; i++) {
        let tr_data = document.createElement('tr');
        tr_data.innerHTML=  '<td>'+result[i]['organisationIndex']+'</td>\n'+
            '               <td>'+result[i]['organisationID']+'</td>\n'+
            '               <td>'+result[i]['organisationName']+'</td>\n' +
            '               <td>'+result[i]['organisationAddress']+'</td>\n'
        table_data.appendChild(tr_data);

    }

}