let dropdown2 = document.getElementById('standard-select2');
dropdown2.length = 0;

let defaultOption2 = document.createElement('option');
defaultOption2.text = 'Vælg afdeling';

dropdown2.add(defaultOption);
dropdown2.selectedIndex = 0;

const url2 = 'http://localhost:8080/shops';

console.log("hello")

fetch(url2)
    .then(
        function (response) {
            if (response.status !== 200) {
                console.warn('Looks like there was a problem. Status Code: ' +
                    response.status);
                return;
            }

            // Examine the text in the response
            response.json().then(function (data) {
                let option2;

                console.log(data);

                for (let i = 0; i < data.length; i++) {
                    option2 = document.createElement('option');
                    option2.text = data[i].shopname;
                    option2.value = data[i].shopid;
                    // dropdown.add(option);
                    parseInt(dropdown2.add(option2));
                    console.log("test");
                }
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });