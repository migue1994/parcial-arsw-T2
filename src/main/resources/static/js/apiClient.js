var apiclient = (function () {
	var appUrl = 'https://parcial-arsw.herokuapp.com/';
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