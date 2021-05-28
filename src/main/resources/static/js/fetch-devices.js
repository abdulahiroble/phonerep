let dropdown5 = document.getElementById('standard-select3');
dropdown5.length = 0;

let defaultOption5 = document.createElement('option');
defaultOption5.text = 'Vælg model';

dropdown5.add(defaultOption5);
dropdown5.selectedIndex = 0;

const url5 = 'http://localhost:8080/devices';

console.log("hello")

fetch(url5)
    .then(
        function (response) {
            if (response.status !== 200) {
                console.warn('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response  
            response.json().then(function (data) {
                let option;

                console.log(data);

                for (let i = 0; i < data.length; i++) {
                    option = document.createElement('option');
                    option.text = data[i].model;
                    option.value = data[i].deviceid;
                    // dropdown5.add(option);
                    parseInt(dropdown5.add(option));
                    console.log("test");
                }

                // option.value = data.genreid;
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });