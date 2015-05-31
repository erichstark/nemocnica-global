$(function() {
	// password validation
	$("#reg-button").click(function() {
		$(".error").hide();
		var isError = false;
		var password = $("#password").val();
		var passwordRepeat = $("#password-repeat").val();
		if (password == '') {
			$("#password").after('<span class="error-password">Zadajte heslo. </span>');
			isError = true;
		} else if (passwordRepeat == '') {
			$("#password-repeat").after('<span class="error-password">Zadajte rovnaké heslo. </span>');
			isError = true;
		} else if (password != passwordRepeat) {
			$("#password-repeat").after('<span class="error-password">Heslá nie sú zhodné. </span>');
			isError = true;
		}
		if (isError) {
			return false;
		}
	});
});