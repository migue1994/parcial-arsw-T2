var mock = apiclient;

var app = (function () {

    var getCountriesTable = function (data) {
        console.info(data);
    };

    var getCountries = function () {
        mock.getCountries('api/statistics', getCountriesTable)
    };

    return {
        getCountries : getCountries
    };

})();