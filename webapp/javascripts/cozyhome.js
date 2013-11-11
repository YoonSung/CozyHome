function countComments() {
	var commentList = document.querySelectorAll('#commentBox');
	
	for (var i = 0 ; i < commentList.length ; i++) {
		var currentBox = commentList[i];
		var currentListCount = currentBox.querySelectorAll(".showComment").length;
		
		currentBox.querySelector(".commentNum").innerText = currentListCount;
	}
	
	var cmtDelList = document.getElementsByClassName("commentDelBtn");
	for ( i = 0 ; i < cmtDelList.length ; i++) {
		console.log(cmtDelList[i]);
		cmtDelList[i].addEventListener('click', deleteComment, false);
	}
}

function initPage() {
	countComments();
	registerEvents();
}

function registerEvents() {
	var eventList = document.getElementsByClassName("commentControl");
	
	for ( var i = 0 ; i < eventList.length ; i++ ) {
		eventList[i].addEventListener('click', toggleComment, false);
	}
	
	var formList = document.querySelectorAll('.commentWrite input[type=submit]');
	
	for ( i = 0 ; i < formList.length ; i++) {
		formList[i].addEventListener('click', writeComment, false);
	}
}

function toggleComment(event) {
	
	event.preventDefault();
	
	var target = event.target.parentNode.nextElementSibling;
	var displayValue = getStyleValue(target, "display");
	
	if ( displayValue == "none" )  {
		target.style.display="block";
	} else {
		target.style.display="none";
	}
}

function getStyleValue(node, style) {
	var totalStyle= window.getComputedStyle(node , null);
	return totalStyle.getPropertyValue(style);
}



function writeComment(event) {
	event.preventDefault();
	
	var elementForm = event.currentTarget.form; // form element
	var formData = new FormData(elementForm);
	var commentBody = event.currentTarget.parentNode.parentNode.previousElementSibling.children[1];
	
	console.log(commentBody);
	console.log(event);
	
	var id = elementForm[1].value;
	var url = "/board/comment/json/"+id;

	var request = new XMLHttpRequest();
	request.open("POST", url, true);
	request.onreadystatechange = function() {
	console.log("readyState : "+request.readyState);
		
		if (request.readyState == 4 && request.status == 200) {
			var obj = JSON.parse(request.responseText);
			
			var htmlSource = 
				"<div class=\"showComment\">"+obj.comment
					+ " 	<button onclick=\"location.href=\'/board/comment/modify/"+obj.id+"\'\">수정</button>"
					+ " 	<button onclick=\"location.href='/board/comment/delete/"+obj.id+"\'\">삭제</button></div>";
			
			commentBody.insertAdjacentHTML('beforeend', htmlSource);
			var cmtNum = commentBody.previousElementSibling.children[0];
			cmtNum.innerHTML = parseInt(cmtNum.innerHTML)+1;
		}
	}
	request.send(formData);
}

function deleteComment(event) {
	event.preventDefault();
	console.log("deleteComment");
	console.log("event : "+event);
	var formData = new FormData();
	
	
	var currentNode = event.currentTarget;
	var id = currentNode.parentNode.children[0].value;
	console.log("idididi : "+id);
	var url = "/board/comment/delete/json/"+id;

	var request = new XMLHttpRequest();
	request.open("POST", url, true);
	request.onreadystatechange = function() {
		console.log("readyState : "+request.readyState);
		
		if (request.readyState == 4 && request.status == 200) {
			currentNode.parentNode.style.display="none";
			
			var commentBody = currentNode.parentNode.parentNode;
			
			console.log("commentBody"+commentBody);
			
			var cmtNum = commentBody.previousElementSibling.children[0];
			console.log("cmtNum : "+cmtNum.innerHTML);
		
			if ( cmtNum.innerHTML === 1 ) {
				commentBody.parentNode.style.display="none";
			} else {
				cmtNum.innerHTML = parseInt(cmtNum.innerHTML)-1;
			}
			currentNode.style.display="none";
		}
	}
	request.send(formData);
	
}

window.onload = initPage;