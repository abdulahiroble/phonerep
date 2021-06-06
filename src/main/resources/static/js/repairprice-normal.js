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

        // (C3) KEY & VALUE
        cellA.innerHTML = results[0][i].repname
        cellB.innerHTML = results[1][i].reptime
        cellC.innerHTML = `${results[1][i].repprice} kr`

        // (C4) ATTACH ROW & CELLS
        table.appendChild(row).style.width = "500px"
        row.appendChild(cellA).style.width = "500px"
        row.appendChild(cellB).style.width = "500px"
        row.appendChild(cellC).style.width = "500px"
    }
}

fetchAll();
