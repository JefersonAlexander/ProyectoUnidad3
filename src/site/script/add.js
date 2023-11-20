function add(){
        console.log("Adicionando");
        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "http://localhost:8080/recyclerCustomer/addRecycler", true);

        xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

        var name = document.getElementById("name");
        var surname = document.getElementById("surname");
        var age = document.getElementById("age");
        var gender = document.getElementById("gender");
        var id = document.getElementById("id");
        var recycle = document.getElementById("recycle");
        var numberBottles = document.getElementById("numberBottles");
        var recyclinStartDate = document.getElementById("recyclinStartDate");

        var newRecycler = {
            "name": name.value,
            "surname": surname.value,
            "age": age.value,
            "gender": gender.value.charAt(0),
            "id":id .value,
            "recycle": recycle.value.toLowerCase() === "sí",
            "numberBottles": numberBottles.value,
            "recyclinStartDate": recyclinStartDate.value

        }

        xmlhttp.send(JSON.stringify(newRecycler));
    }