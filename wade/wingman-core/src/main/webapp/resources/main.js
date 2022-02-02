console.log("ola");

$(document).ready(function() {

    if (window.localStorage.getItem("user") != null) {
        $("#account").html("<h3>Logged in as: " + window.localStorage.getItem("user") + "</h3>");
        $("#auth").hide();
    }

    $("#login").on('click', function () {
        var username = $("#username").val();
        var password = $("#password").val();

        $.get("/wingman/api/auth", {
            username: username,
            password: password
        }, function(data) {
            if (data == "success") {
                window.localStorage.setItem("user", username);
                $("#account").html("<h3>Logged in as: " + username + "</h3>");
                $("#auth").hide();
                alert("Login success");
            } else {
                console.log(data);
                alert("Login Failed");
            }
        }).fail(function () {
            console.log("Login erroor");
        });

    });

    $("#all-carbonated-drinks").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/carbonateddrinks", function(data) {
            showList(data);
        });
    });

    $("#all-mocktails").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/mocktails", function(data) {
            showList(data);
        });
    });

    $("#all-coffee").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/coffee", function(data) {
            showList(data);
        });

    });

    $("#all-tea").on('click', function () {
        console.log("carbonated drinks");
        $.get("/wingman/api/tea", function(data) {
            showList(data);
        });
    });

    $('#search').on('click', function() {


        var searchBarVal = $('#search-bar').val().split(" ");

        for (var i = 0; i < searchBarVal.length; i++) {
            $('#country option[value="'+ searchBarVal[i] +'"]').prop('selected', true)
            $('#ingredients option[value="'+ searchBarVal[i] +'"]').prop('selected', true)
            $('#restriictions option[value="'+ searchBarVal[i] +'"]').prop('selected', true)
            $('#events option[value="'+ searchBarVal[i] +'"]').prop('selected', true)
        }


        setTimeout(function() {

            // fetch country
            var selectedCountry = $('select#country').val() || [];

            // fetch selected ingredients
            var selectedIngredients = $('select#ingredients').val() || [];

            // fetch selected restrictions
            var selectedRestrictions = $('#restrictions').val() || [];

            // fetch selected events
            var selectedEvents = $('#events').val() || [];

            var username = window.localStorage.getItem("username") || "default";


            console.log("[Country]", selectedCountry);
            console.log("[Ingredients]", selectedIngredients);
            console.log("[Restrictions]", selectedRestrictions);
            console.log("[Events]", selectedEvents);

            console.log("=====================")


            $.get("/wingman/api/search", {
                country: JSON.stringify(selectedCountry[0]),
                ingredients: JSON.stringify(selectedIngredients),
                restrictions: JSON.stringify(selectedRestrictions),
                events: JSON.stringify(selectedEvents),
                username: username
            }, function(data) {
                console.log("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                console.log(data);
                showList(data);
                console.log("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }).done(function() {
                alert("done");
            }).fail(function() {
                alert("fail");
            });
        }, 1000);




    });

});

function showList(content) {
    var ret = '<ul class="list-group">';
    debugger
    for (var i = 0; i < content.length; i++) {
        ret += '<li class="list-group-item">' + content[i] + '</li>';
    }
    ret += '</ul>';
    $("#results-area").html(ret);

}

function clearResultsArea() {
    $("#results-area").html("");
}