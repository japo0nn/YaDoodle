function onLogo() {
	window.location = '/'
}

function onSearchButton(){
	var text = document.getElementById('searchid');
	console.log(text.value);
	window.location = 'search';
}
