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

function changeEnabled(item) {
	var what = $(item).attr('name').split('-')[0];
	var id = $(item).attr('id');
	var enabled = $(item).attr('checked') ? false : true;

	$.ajax({
		type: "POST",
		url: "/admin/"+what+"/"+id+"/enabled",
		data: {enabled: enabled},
		dataType: "json"
	});
}