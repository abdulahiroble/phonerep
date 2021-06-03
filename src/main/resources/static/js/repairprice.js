const urls = [
    "http://localhost:8080/repairtype",
    "http://localhost:8080/pricelist"
];

async function fetchAll() {
    const results = await Promise.all(urls.map((url) => fetch(url).then((r) => r.json())));

    results.map((test) => console.log(test.map((test2) => test2.reptime || test2.repname)))

    console.log(JSON.stringify(results, null, 2));

    var table = document.createElement("table"), row, cellA, cellB, cellC, cellD, header
    document.getElementById("demoB").appendChild(table);

    for (let i = 0; i < 11; i++) {
        // (C2) ROWS & CELLS
        row = document.createElement("tr");
        header = document.createElement("th");
        cellA = document.createElement("td");
        cellB = document.createElement("td");
        cellC = document.createElement("td");
        cellD = document.createElement("td")

        // (C3) KEY & VALUE
        cellA.innerHTML = results[0][i].repname
        cellB.innerHTML = results[1][i].reptime
        cellC.innerHTML = `${results[1][i].repprice} kr`
        cellD.innerHTML = `<a href="http://localhost:8080/pricelistUpdate/${results[1][i].pricelistid}" class="btn btn-primary">Update</a>`

        // (C4) ATTACH ROW & CELLS
        table.appendChild(row).style.width = "500px"
        row.appendChild(cellA).style.width = "500px"
        row.appendChild(cellB).style.width = "500px"
        row.appendChild(cellC).style.width = "500px"
        row.appendChild(cellD).style.width = "500px"
    }
}

fetchAll();

// const urls = 'http://localhost:8080/pricelist';

// fetch(urls)
//     .then(
//         function (response) {
//             if (response.status !== 200) {
//                 console.warn('Looks like there was a problem. Status Code: ' +
//                     response.status);
//                 return;
//             }

//             // Examine the text in the response  
//             response.json().then(function (data) {

//                 console.log(data);

//                 var table = document.createElement("table"), row, cellA, cellB, cellC, cellD, header
//                 document.getElementById("demoB").appendChild(table);

//                 for (let key in data) {
//                     // (C2) ROWS & CELLS
//                     row = document.createElement("tr");
//                     header = document.createElement("th");
//                     cellA = document.createElement("td");
//                     cellB = document.createElement("td");
//                     cellC = document.createElement("td");

//                     // (C3) KEY & VALUE
//                     cellA.innerHTML = ""
//                     cellB.innerHTML = data[key].reptime;
//                     cellC.innerHTML = `${data[key].repprice} kr.`;


//                     // (C4) ATTACH ROW & CELLS
//                     table.appendChild(row).style.width = "500px"
//                     row.appendChild(cellA).style.width = "500px"
//                     row.appendChild(cellB).style.width = "500px"
//                     row.appendChild(cellC).style.width = "500px"
//                 }
//             });
//         }
//     )
//     .catch(function (err) {
//         console.error('Fetch Error -', err);
//     });