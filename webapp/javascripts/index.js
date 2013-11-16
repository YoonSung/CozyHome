function registEvents() {
	document.querySelector(".c_login").addEventListener('click', loginChoice, false);
	document.querySelector(".c_join").addEventListener('click', joinChoice, false);
}

function loginChoice(e) {
	event.preventDefault();
	
	var loginNode = document.querySelector(".loginArea");
	var loginNodeStyle = getStyleValue(loginNode, "display");
	
	if ( loginNodeStyle == "none" )
		loginNode.style.display="block";
	else
		loginNode.style.display="none";

	loginNode.nextElementSibling.style.display="none";
}

function joinChoice(e) {
	event.preventDefault();
	
	var loginNode = document.querySelector(".joinArea");
	var loginNodeStyle = getStyleValue(loginNode, "display");
	
	if ( loginNodeStyle == "none" )
		loginNode.style.display="block";
	else
		loginNode.style.display="none";

	loginNode.previousElementSibling.style.display="none";
}

function init() {
	registEvents();
}

function getStyleValue(node, style) {
	var totalStyle= window.getComputedStyle(node , null);
	return totalStyle.getPropertyValue(style);
}


init();