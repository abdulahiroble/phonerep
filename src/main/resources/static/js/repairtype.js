const url = 'http://localhost:8080/repairtype';

fetch(url)
    .then(
        function (response) {
            if (response.status !== 200) {
                console.warn('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response  
            response.json().then(function (data) {

                var table = document.createElement("table"), row, cellA, cellB, cellC, cellD, header
                document.getElementById("demoA").appendChild(table);

                for (let key in data) {
                    // (C2) ROWS & CELLS
                    row = document.createElement("tr");
                    header = document.createElement("th");
                    cellA = document.createElement("td");
                    cellB = document.createElement("td");

                    // (C3) KEY & VALUE
                    cellA.innerHTML = data[key].repname;


                    // (C4) ATTACH ROW & CELLS
                    table.appendChild(row).style.width = "500px"
                    row.appendChild(cellA).style.width = "500px"
                }
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });