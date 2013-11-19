function registEvents() {
	document.querySelector(".c_login").addEventListener('click', loginChoiceONOFF, false);
	document.querySelector(".c_join").addEventListener('click', joinChoiceONOFF, false);
	document.querySelector(".joinArea input[type=submit]").addEventListener('click', join, false);
	document.querySelector(".loginArea input[type=submit]").addEventListener('click', login, false);
}

function login(event) {
	event.preventDefault();
	
	var form = event.currentTarget.form;
	var formData = new FormData(form);
	var url = "/login";
	var request = new XMLHttpRequest();
	request.open("POST", url, true);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;

			if ( result === "" ) {
				alert("예기치 못한 에러가 발생하였습니다.\n다시 시도해 주세요.");
			} else if ( result === "pwError" ) {
				alert("비밀번호를 다시 확인해 주세요.");
			} else if ( result === "notExist" ) {
				alert("존재하지 않는 id입니다.\n아이디를 다시 확인해 주세요.");
			} else {
				alert(result +"님 환영합니다.");
				window.location = "/board/list";
			}
		}
	}
	request.send(formData);
}

function join(event) {
	event.preventDefault();

	var form = event.currentTarget.form;
	var formData = new FormData(form);
	var url = "/join";
	var request = new XMLHttpRequest();
	request.open("POST", url, true);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			
			console.log("request.responseText : "+result);
		}
	}
	
	request.send(formData);
}

function loginChoiceONOFF() {
	event.preventDefault();
	
	var loginNode = document.querySelector(".loginArea");
	var loginNodeStyle = getStyleValue(loginNode, "display");
	
	if ( loginNodeStyle == "none" )
		loginNode.style.display="block";
	else
		loginNode.style.display="none";

	loginNode.nextElementSibling.style.display="none";
}

function joinChoiceONOFF() {
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