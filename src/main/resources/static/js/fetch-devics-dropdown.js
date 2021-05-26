let dropdown3 = document.getElementById('standard-select3');
dropdown3.length = 0;

let defaultOption3 = document.createElement('option');
defaultOption3.text = 'Vælg model';

dropdown3.add(defaultOption);
dropdown3.selectedIndex = 0;

const url3 = 'http://localhost:8080/devices';

console.log("hello")

fetch(url3)
    .then(
        function (response) {
            if (response.status !== 200) {
                console.warn('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response
            response.json().then(function (data) {
                let option3;

                console.log(data);

                for (let i = 0; i < data.length; i++) {
                    option3 = document.createElement('option');
                    option3.text = data[i].model;
                    option3.value = data[i].deviceid;
                    // dropdown.add(option);
                    parseInt(dropdown3.add(option3));
                    console.log("test");
                }
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });