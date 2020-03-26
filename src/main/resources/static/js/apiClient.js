var apiclient = (function () {
	var appUrl = 'http://localhost:8080/';
	return {
		getCountries : function (path, callback) {
			jQuery.ajax({
				url: appUrl + path,
				success: function (result) {
					callback(result);
				},
				async: true
			});
		},
	};
})();