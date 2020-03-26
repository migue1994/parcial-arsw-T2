var mock = apiclient;

var app = (function () {

    var getProvincesTable = function (data) {
        console.info(data);
        var covidData = data;
        $("#provinces").empty();
        covidData.map(function (c) {
            $("#provinces").append(
                "<tr> " +
                "<td>" + c.province + "</td> " +
                "<td>" + c.deaths+"</td>" +
                "<td>"+c.confirmed+"</td>" +
                "<td>"+c.recovered+"</td>" +
                "</tr>"
            );
        });
    };

    var getProvidences = function (name) {
        $("#pais").text(name);
        mock.getCountries("api/allCountries/"+name, getProvincesTable);
    };

    var getCountriesTable = function (data) {
        var covidData = data;
        $("#status").empty();
        covidData.map(function (c) {
            $("#status").append(
                "<tr> " +
                "<td><a onclick='app.getProvidences(\""+c.name+"\")'>" + c.name + "</a></td> " +
                "<td>" + c.numDeaths + "</td> " +
                "<td>" + c.numInfected+"</td>" +
                "<td>"+c.numCured+"</td>" +
                "</tr>"
            );
        });
    };

    var getCountries = function () {
        mock.getCountries('api/statistics', getCountriesTable)
    };

    return {
        getCountries : getCountries,
        getProvidences : getProvidences
    };

})();