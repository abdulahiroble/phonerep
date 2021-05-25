let dropdown = document.getElementById('standard-select');
dropdown.length = 0;

let defaultOption = document.createElement('option');
defaultOption.text = 'Vælg model';

dropdown.add(defaultOption);
dropdown.selectedIndex = 0;

const url = 'http://localhost:8080/devices';

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
                let option;

                console.log(data);

                for (let i = 0; i < data.length; i++) {
                    option = document.createElement('option');
                    option.text = data[i].model;
                    option.value = data[i].deviceid;
                    // dropdown.add(option);
                    parseInt(dropdown.add(option));
                    console.log("test");
                }

                // option.value = data.genreid;
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });
