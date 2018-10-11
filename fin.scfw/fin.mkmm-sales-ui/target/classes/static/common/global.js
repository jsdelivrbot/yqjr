var token = localStorage.getItem('token') || undefined;
var refreshToken = localStorage.getItem('refreshToken') || undefined;

$.ajaxSetup({
	dataType: 'json',
	cache: false,
	headers: {
		'X-Authorization': token,
		'X-Authorization-Refresh': refreshToken
	},
	xhrFields: {
		withCredentials: true
	},
	error: function(jqXHR, textStatus, errorThrown) {
		if (401 === jqXHR.status) {
			top.location.href = '/ui/comm/login';
		} else {
		/*	layer.open({
				content: jqXHR.responseJSON.message || (jqXHR.responseJSON.messageList && jqXHR.responseJSON.messageList.join('<br/>')) || jqXHR.responseText
			});*/
		}
	}
});
