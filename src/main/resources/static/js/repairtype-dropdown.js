let dropdown6 = document.getElementById('standard-select5');
dropdown6.length = 0;

let defaultOption6 = document.createElement('option');
defaultOption6.text = 'Vælg model';

dropdown6.add(defaultOption6);
dropdown6.selectedIndex = 0;

const url6 = 'http://localhost:8080/repairtype';

console.log("hello")

fetch(url6)
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
                    option.text = data[i].repname;
                    option.value = data[i].reptypeid;
                    // dropdown6.add(option);
                    parseInt(dropdown6.add(option));
                    console.log("test");
                }

                // option.value = data.genreid;
            });
        }
    )
    .catch(function (err) {
        console.error('Fetch Error -', err);
    });